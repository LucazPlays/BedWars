package de.papiertuch.bedwars.listener;

import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.ext.bridge.bukkit.BukkitCloudNetHelper;
import de.papiertuch.bedwars.BedWars;
import de.papiertuch.bedwars.enums.GameState;
import de.papiertuch.nickaddon.utils.NickAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Leon on 15.06.2019.
 * development with love.
 * © Copyright by Papiertuch
 */

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (BedWars.getInstance().getGameState() == GameState.LOBBY) {
            if (player.hasPermission("update.notify")) {
                if (BedWars.getInstance().getNewVersion() != null && !BedWars.getInstance().getNewVersion().equalsIgnoreCase(BedWars.getInstance().getDescription().getVersion())) {
                    player.sendMessage(BedWars.getInstance().getBedWarsConfig().getString("message.prefix") + " §aEs ist eine neue Version verfügbar §8» §f§l" + BedWars.getInstance().getNewVersion());
                    player.sendMessage("§ehttps://www.spigotmc.org/resources/bedwars-bukkit-mit-mapreset-und-stats.68403/");
                }
            }
            if (BedWars.getInstance().isNickEnable()) {
                if (new NickAPI(player).getAutoNickState(player.getUniqueId())) {
                    new NickAPI(player).setNick(player.getUniqueId(), true);
                }
            }
            BedWars.getInstance().getStatsHandler().createPlayer(player);
            BedWars.getInstance().getGameHandler().setPlayer(player);
            BedWars.getInstance().getBoard().addPlayerToBoard(player);
            event.setJoinMessage(BedWars.getInstance().getBedWarsConfig().getString("message.joinGame")
                    .replace("%player%", player.getDisplayName())
                    .replace("%players%", String.valueOf(Bukkit.getOnlinePlayers().size()))
                    .replace("%maxPlayers%", String.valueOf(BedWars.getInstance().getGameHandler().getMaxPlayers())));
            if ((BedWars.getInstance().getPlayers().size() >= BedWars.getInstance().getBedWarsConfig().getInt("settings.minPlayers")) && (!BedWars.getInstance().getScheduler().getLobby().isRunning())) {
                BedWars.getInstance().getScheduler().getLobby().stopWaiting();
                BedWars.getInstance().getScheduler().getLobby().startCountdown();
            }
            if ((BedWars.getInstance().getPlayers().size() < BedWars.getInstance().getBedWarsConfig().getInt("settings.minPlayers")) && (!BedWars.getInstance().getScheduler().getLobby().isWaiting())) {
                BedWars.getInstance().getScheduler().getLobby().startWaiting();
            }
            if (BedWars.getInstance().getPlayers().size() == BedWars.getInstance().getGameHandler().getMaxPlayers()) {
                BedWars.getInstance().getScheduler().getLobby().setSeconds((BedWars.getInstance().getBedWarsConfig().getInt("countDown.lobbyDuration") / 2));
                BedWars.getInstance().getGameHandler().sendBroadCast(BedWars.getInstance().getBedWarsConfig().getString("message.gameStarting"));
            }
        }
        if (BedWars.getInstance().getGameState() == GameState.INGAME) {
            event.setJoinMessage(null);
            player.sendMessage(BedWars.getInstance().getBedWarsConfig().getString("message.spectator"));
            BedWars.getInstance().getGameHandler().setSpectator(player);
        }
    }

    @EventHandler
    public void onLoginEvent(PlayerLoginEvent event) {
        if (BedWars.getInstance().getGameState() == GameState.LOBBY) {
            Player player = event.getPlayer();
            int i = getMaxPlayers();
            if (Bukkit.getOnlinePlayers().size() != i) {
                return;
            }
            if (!player.hasPermission("bedwars.premium")) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, BedWars.getInstance().getBedWarsConfig().getString("message.prefix") + " §cDu benötigst mindestens den §6§lPremium §cRang, um diesen Server betreten zu können!");
                return;
            }
            List<Player> list = new ArrayList<>();
            for (Player other : Bukkit.getOnlinePlayers()) {
                if (!other.hasPermission("bedwars.premium")) {
                    list.add(other);
                }
            }
            if (list.isEmpty()) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, BedWars.getInstance().getBedWarsConfig().getString("message.prefix") + " §cDieser Server ist komplett voll. Jeder hat mindestenes einen §6§lPremium §cRang!");
            }

            Player random = list.get(new Random().nextInt(list.size()));
            random.kickPlayer(BedWars.getInstance().getBedWarsConfig().getString("message.prefix") + " §cDu wurdest von einem §e§lhöherrängigen §cSpieler gekickt!");
            event.allow();
        }
        if (BedWars.getInstance().getGameState() == GameState.ENDING) {
            event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
            event.setKickMessage(BedWars.getInstance().getBedWarsConfig().getString("message.prefix") + " §cDie Runde ist bereits zuende...");
        }
    }

    private int getMaxPlayers() {
        if (BedWars.getInstance().getBedWarsConfig().getBoolean("module.cloudNet.v2")) {
            return CloudServer.getInstance().getMaxPlayers();
        }
        if (BedWars.getInstance().getBedWarsConfig().getBoolean("module.cloudNet.v3")) {
            return BukkitCloudNetHelper.getMaxPlayers();
        }
        return Bukkit.getMaxPlayers();
    }
}