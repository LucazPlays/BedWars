package de.papiertuch.bedwars.listener;

import de.papiertuch.bedwars.BedWars;
import de.papiertuch.bedwars.enums.GameState;

import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Created by Leon on 15.06.2019.
 * development with love.
 * © Copyright by Papiertuch
 */

public class PlayerInteractAtEntityListener implements Listener {

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        if (BedWars.getInstance().getGameState() != GameState.INGAME) {
            event.setCancelled(true);
            return;
        }
        if (BedWars.getInstance().getSpectators().contains(player.getUniqueId())) {
            event.setCancelled(true);
            return;
        }
        if (EntityType.valueOf(BedWars.getInstance().getBedWarsConfig().getString("settings.shopType")) != EntityType.VILLAGER) {
            if (event.getRightClicked().getType() == EntityType.valueOf(BedWars.getInstance().getBedWarsConfig().getString("settings.shopType")) && BedWars.getInstance().getPlayers().contains(player.getUniqueId())) {
                event.setCancelled(true);
                player.openInventory(BedWars.getInstance().getShopHandler().getMainInventory(player));
                player.playSound(player.getLocation(), BedWars.getInstance().getGameHandler().getSound(BedWars.getInstance().getBedWarsConfig().getString("sound.interact")), 1, 1);
            }
        }
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (BedWars.getInstance().getGameState() != GameState.INGAME) {
            event.setCancelled(true);
            return;
        }
        if (BedWars.getInstance().getSpectators().contains(player.getUniqueId())) {
            event.setCancelled(true);
            return;
        }
        if (event.getRightClicked().getType() == EntityType.valueOf(BedWars.getInstance().getBedWarsConfig().getString("settings.shopType")) && BedWars.getInstance().getPlayers().contains(player.getUniqueId())) {
            event.setCancelled(true);
            player.openInventory(BedWars.getInstance().getShopHandler().getMainInventory(player));
            player.playSound(player.getLocation(), BedWars.getInstance().getGameHandler().getSound(BedWars.getInstance().getBedWarsConfig().getString("sound.interact")), 1, 1);
        }
    }
    
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			if (!Bukkit.getOnlinePlayers().contains(e.getEntity())) {
				if (e.getDamager() instanceof Player) {
					if (npcname(e.getEntity()).toLowerCase(Locale.ROOT).contains("shop")) {
						Player player = (Player) e.getDamager();
			            player.openInventory(BedWars.getInstance().getShopHandler().getMainInventory(player));
			            player.playSound(player.getLocation(), BedWars.getInstance().getGameHandler().getSound(BedWars.getInstance().getBedWarsConfig().getString("sound.interact")), 1, 1);
					}
				}
			}
		}
	}

	@EventHandler
	public void onClick(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() != null) {
			if (e.getRightClicked() instanceof Player) {
				if (!Bukkit.getOnlinePlayers().contains(e.getRightClicked())) {
					if (npcname(e.getRightClicked()).toLowerCase(Locale.ROOT).contains("shop")) {
						Player player = e.getPlayer();
			            player.openInventory(BedWars.getInstance().getShopHandler().getMainInventory(player));
			            player.playSound(player.getLocation(), BedWars.getInstance().getGameHandler().getSound(BedWars.getInstance().getBedWarsConfig().getString("sound.interact")), 1, 1);
					}
				}
			}
		}
	}
    
    
	public static String npcname(Entity en) {
		String name = en.getCustomName();
		name = name.replaceAll("»", "");
		name = name.replaceAll("☣", "");
		name = name.replaceAll("⚠", "");
		name = name.replaceAll("⚒", "");
		name = name.replaceAll("➥", "");
		name = name.replaceAll("§0", "");
		name = name.replaceAll("§1", "");
		name = name.replaceAll("§2", "");
		name = name.replaceAll("§3", "");
		name = name.replaceAll("§4", "");
		name = name.replaceAll("§5", "");
		name = name.replaceAll("§6", "");
		name = name.replaceAll("§7", "");
		name = name.replaceAll("§8", "");
		name = name.replaceAll("§9", "");
		name = name.replaceAll("§f", "");
		name = name.replaceAll("§c", "");
		name = name.replaceAll("§a", "");
		name = name.replaceAll("§d", "");
		name = name.replaceAll("§b", "");
		name = name.replaceAll("§l", "");
		name = name.replaceAll("§o", "");
		name = name.replaceAll("§r", "");
		name = name.replaceAll("§m", "");
		name = name.replaceAll("§n", "");
		name = name.replaceAll("§e", "");
		name = name.replaceAll("§k", "");
		name = name.replaceAll(" ", "");
		return name;
	}
}
