package de.papiertuch.bedwars.utils;

import de.papiertuch.bedwars.BedWars;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Leon on 14.06.2019.
 * development with love.
 * © Copyright by Papiertuch
 */

public class BedWarsConfig {

    private File file;
    private FileConfiguration configuration;

    private HashMap<String, String> cacheString;
    private HashMap<String, Boolean> cacheBoolean;
    private HashMap<String, Integer> cacheInt;

    public BedWarsConfig() {
        file = new File("plugins/BedWars", "config.yml");
        configuration = YamlConfiguration.loadConfiguration(file);

        cacheString = new HashMap<>();
        cacheBoolean = new HashMap<>();
        cacheInt = new HashMap<>();
    }

    public void loadConfig() {
        if (configuration.get("settings.mysql.host") != null) {
            return;
        }
        configuration.options().copyDefaults(true);

        configuration.addDefault("settings.mysql.host", "host");
        configuration.addDefault("settings.mysql.dataBase", "dataBase");
        configuration.addDefault("settings.mysql.user", "user");
        configuration.addDefault("settings.mysql.password", "password");
        configuration.addDefault("settings.mode", "4x2");
        configuration.addDefault("settings.minPlayers", 2);
        configuration.addDefault("settings.shopType", "ARMOR_STAND");
        configuration.addDefault("settings.border", true);
        configuration.addDefault("settings.enableStats", true);
        configuration.addDefault("settings.stopServerAfterRound", false);
        configuration.addDefault("settings.sendTitle", true);
        configuration.addDefault("settings.coinCommand.enable", false);
        configuration.addDefault("settings.coinCommand.command", "coins add %player% %value%");
        configuration.addDefault("settings.coinCommand.killValue", 3);
        configuration.addDefault("settings.coinCommand.playedValue", 5);
        configuration.addDefault("settings.coinCommand.winValue", 20);
        configuration.addDefault("settings.coinCommand.bedValue", 10);

        configuration.addDefault("settings.motd.lobby", "&a&lLOBBY &f%map%");
        configuration.addDefault("settings.motd.ingame", "&6&lINGAME &f%map%");
        configuration.addDefault("settings.motd.ending", "&c&lENDING &f%map%");

        configuration.addDefault("countDown.lobbyDuration", 60);
        configuration.addDefault("countDown.endingDuration", 15);
        configuration.addDefault("countDown.gameTime", 3600);
        configuration.addDefault("countDown.bronzeSpawnRate", 1);
        configuration.addDefault("countDown.ironSpawnRate", 15);
        configuration.addDefault("countDown.goldSpawnRate", 40);
        configuration.addDefault("module.cloudNet.v2", false);
        configuration.addDefault("module.cloudNet.v3", false);

        List<String> teams = new ArrayList<>();
        teams.add("Blau");
        teams.add("Rot");
        teams.add("Lila");
        teams.add("Gelb");
        configuration.addDefault("team.teams", teams);

        configuration.addDefault("team.Blau.colorCode", "&9");
        configuration.addDefault("team.Blau.color", "BLUE");

        configuration.addDefault("team.Rot.colorCode", "&c");
        configuration.addDefault("team.Rot.color", "RED");

        configuration.addDefault("team.Lila.colorCode", "&5");
        configuration.addDefault("team.Lila.color", "PURPLE");

        configuration.addDefault("team.Gelb.colorCode", "&e");
        configuration.addDefault("team.Gelb.color", "YELLOW");

        List<String> tabList = new ArrayList<>();
        tabList.add("Admin");
        tabList.add("default");
        configuration.addDefault("nameTags.tabList", tabList);

        configuration.addDefault("nameTags.Admin.prefix", "&8[&4Admin&8] &4");
        configuration.addDefault("nameTags.Admin.suffix", "&4");
        configuration.addDefault("nameTags.Admin.display", "&4");
        configuration.addDefault("nameTags.Admin.tagId", 9998);
        configuration.addDefault("nameTags.Admin.permission", "bedwars.admin");

        configuration.addDefault("nameTags.default.prefix", "&7");
        configuration.addDefault("nameTags.default.suffix", "&7");
        configuration.addDefault("nameTags.default.display", "&7");
        configuration.addDefault("nameTags.default.tagId", 9999);
        configuration.addDefault("nameTags.default.permission", "bedwars.default");

        configuration.addDefault("command.setup.permission", "bedwars.setup");
        configuration.addDefault("command.forceMap.permission", "bedwars.forcemap");
        configuration.addDefault("command.start.permission", "bedwars.start");
        configuration.addDefault("command.start.seconds", 5);

        configuration.addDefault("sound.click", "WOOD_CLICK");
        configuration.addDefault("sound.interact", "PISTON_EXTEND");
        configuration.addDefault("sound.kill", "LEVEL_UP");
        configuration.addDefault("sound.countdown", "CLICK");
        configuration.addDefault("sound.error", "NOTE_PLING");
        configuration.addDefault("sound.destroyBed", "WITHER_DEATH");
        configuration.addDefault("sound.endingCountdown", "LAVA_POP");

        configuration.addDefault("message.prefix", "&8[&e&lBedWars&8]&7");
        configuration.addDefault("message.locationNotFound", "%prefix% &cDie Location &f%loc% &cwurde nicht gefunden");
        configuration.addDefault("message.pathNotFound", "%prefix% &cDer Wert &f%value% &cwurde nicht gefunden");
        configuration.addDefault("message.gameStop", "%prefix% &cDie Runde wird neugestartet...");
        configuration.addDefault("message.forceMap.changeMap", "%prefix% &7Du hast die Map zu &e&l%map% &7ge\u00E4ndert");
        configuration.addDefault("message.forceMap.mapNotExists", "%prefix% &cDiese Map gibt es nicht");
        configuration.addDefault("message.gameStarting", "%prefix% &aDas Spiel wird gestartet...");
        configuration.addDefault("message.gameStartingIn", "%prefix% &7Das &a&lSpiel &7startet in &a&l%seconds% &7Sekunden");
        configuration.addDefault("message.gameStartingInOneSecond", "%prefix% &7Das &a&lSpiel &7startet in &a&leiner &7Sekunde");
        configuration.addDefault("message.goldStatus", "%prefix% &7Gold &8\u00BB &e&l%state%");
        configuration.addDefault("message.itemDropStatus", "%prefix% &7ItemDrops &8\u00BB &e&l%state%");
        configuration.addDefault("message.mapStatus", "%prefix% &7Aktuelle Map &8\u00BB &e&l%map%");
        configuration.addDefault("message.yourInTeam", "%prefix% &7Du bist nun im Team %team%");
        configuration.addDefault("message.teamWin", " %prefix% &7Das Team %team% &7hat gewonnen!");
        configuration.addDefault("message.borderIn", "%prefix% &7Die &cBorder &7verkleinert sich in &c&l%minutes% &7Minuten");
        configuration.addDefault("message.borderInOneMinute", "%prefix% &7Die &cBorder &7verkleinert sich in &c&leiner Minute");
        configuration.addDefault("message.border", "%prefix% &7Die &cBorder &7verkleinert sich nun!");
        configuration.addDefault("message.roundStarting", "%prefix% &7Die Runde wurde gestartet");
        configuration.addDefault("message.destroyAllBeds", "%prefix% &cEs wurden &4&lAlle &cBetten entfernt");
        configuration.addDefault("message.smallBoarder", "%prefix% &cDie Border ist nun ganz klein!");
        configuration.addDefault("message.roundEnds", "%prefix% &cDie Runde ist zuende");
        configuration.addDefault("message.notEnoughResources", "%prefix% &cDu hast nicht genug Ressourcen");
        configuration.addDefault("message.serverStopIn", "%prefix% &cDer Server stoppt in &a&l%seconds% &cSekunden");
        configuration.addDefault("message.serverStopInOneSecond", "%prefix% &cDer Server stoppt in &a&leiner &cSekunde");
        configuration.addDefault("message.serverStop", "%prefix% &cDer Server stoppt jetzt!");
        configuration.addDefault("message.start.startRound", "%prefix% &aDu hast die Runde gestartet");
        configuration.addDefault("message.start.countDownUnderSeconds", "%prefix% &cDer Countdown ist bereits unter &a&l%seconds% &cSekunden!");
        configuration.addDefault("message.start.notEnoughPlayers", "%prefix% &cEs sind nicht genug Spieler online");
        configuration.addDefault("message.start.roundAlreadyStarting", "%prefix% &cDie Runde startet bereits...");
        configuration.addDefault("message.noPerms", "%prefix% &cDazu hast du keine Rechte...");
        configuration.addDefault("message.destroyOwnBed", "%prefix% &cDu kannst dein eigenes Bett nicht abbauen!");
        configuration.addDefault("message.destroyBed", "%prefix% &7Das Bett vom Team %team% &7wurde von %player% &7abgebaut!");
        configuration.addDefault("message.teamFull", "%prefix% &cDieses Team ist bereits voll!");
        configuration.addDefault("message.teamEmpty", "%prefix% &cEs wurden alle Spieler neuverteilt da die Teams unfair belegt sind...");
        configuration.addDefault("message.otherTeamsEmpty", "%prefix% &cNehme ein anderes Team da diese leer sind");
        configuration.addDefault("message.choseTeam", "%prefix% &7Du wirst nun im Team %team% &7sein");
        configuration.addDefault("message.teleportToPlayer", "%prefix% &7Du bist nun bei %player%");
        configuration.addDefault("message.killMessage", "%prefix% %player% &7wurde von %killer% &7get\u00F6tet");
        configuration.addDefault("message.killerLife", "%prefix% &7Leben von %killer% &8\u00BB &c%live%");
        configuration.addDefault("message.death", "%prefix% %player% &7ist gestorben");
        configuration.addDefault("message.leaveGameWithItem", "%prefix% &cDu hast den Server verlassen...");
        configuration.addDefault("message.teamDeath", "%prefix% &7Das Team %team% &7ist ausgeschieden");
        configuration.addDefault("message.teamReamingPlayers", "%prefix% &7Das Team %team% &7hat noch &a&l%players% Spieler");
        configuration.addDefault("message.joinGame", "%prefix% %player% &7hat das Spiel betreten");
        configuration.addDefault("message.spectator", "%prefix% &7Du bist ist ein Spectator");
        configuration.addDefault("message.leaveGame", "%prefix% %player% &7hat das Spiel verlassen");
        configuration.addDefault("message.actionBar.lobby", "%team%");
        configuration.addDefault("message.actionBar.lobbyWaiting", "%prefix% &fWarte auf &c&l%players% &fSpieler...");
        configuration.addDefault("message.actionBar.game", "&e&lGold &8» %goldVote% &8┃ &e&lItemDrop &8» %itemDropVote% &8┃ &e&lKarte §8» &f&l%map%");
        configuration.addDefault("message.setup.addMap", "%prefix% &7Das Setup für die Map &a&l%map% §7wurde gestartet");
        configuration.addDefault("message.setup.addTeam", "%prefix% &7Du hast das Team &a&l%team% &7erstellt");
        configuration.addDefault("message.setup.addNameTag", "%prefix% &7Du hast den NameTag &a&l%nameTag% &7erstellt");
        configuration.addDefault("message.setup.loadMap", "%prefix% &aDie Welt wird geladen...");
        configuration.addDefault("message.setup.loadFinish", "%prefix% &7Die Map wurde geladen");
        configuration.addDefault("message.setup.setLobby", "%prefix% &7Du hast den &a&lLobby &7Spawn gesetzt");
        configuration.addDefault("message.setup.setSpectator", "%prefix% &7Du hast den &a&lSpectator &7Spawn gesetzt");
        configuration.addDefault("message.setup.setTeamSpawn", "%prefix% &7Du hast den Spawn von %team% &7gesetzt");
        configuration.addDefault("message.setup.noBackup", "%prefix% &cDu musst erst die Map als Backup speichern");
        configuration.addDefault("message.setup.finishSetup", "%prefix% &fDas Setup wurde beendet, dass Spiel kann beginnen");
        configuration.addDefault("message.setup.saveMap", "%prefix% &7Du hast die Map &a&l%map% &7gespeichert");
        configuration.addDefault("message.setup.teleport", "%prefix% &7Du wurdest zur Map &a&l%map% &7teleportiert");
        configuration.addDefault("message.setup.mapNotExists", "%prefix% &cDiese Map gibt es nicht");
        configuration.addDefault("message.setup.setupTeam", "%prefix% &7Du richtest nun das Team %team% &7ein");
        configuration.addDefault("message.voting.voteEnable", "&aAktiviert");
        configuration.addDefault("message.voting.voteDisable", "&cDeaktiviert");
        configuration.addDefault("message.voting.withGold", "&8» &aMit Gold");
        configuration.addDefault("message.voting.withOutGold", "&8» &cOhne Gold");
        configuration.addDefault("message.voting.withItemDrop", "&8» &aMit ItemDrop");
        configuration.addDefault("message.voting.withOutItemDrop", "&8» &cOhne ItemDrop");
        configuration.addDefault("message.voting.mapVote", "%prefix% &7Du hast für die Map &a&l%map% &7gestimmt");
        configuration.addDefault("message.voting.alreadyForeMap", "%prefix% &cEs wurde bereits durch einen ForceMap eine Map ausgesucht");
        configuration.addDefault("message.voting.yes", "%prefix% &7Du hast für &aJa &7gestimmt");
        configuration.addDefault("message.voting.no", "%prefix% &7Du hast für &cNein &7gestimmt");
        configuration.addDefault("message.title.win.one", "%teamColor% Team %team%");
        configuration.addDefault("message.title.win.two", "&ahat gewonnen");
        configuration.addDefault("message.title.bedDestroy.one", "&cDein Bett");
        configuration.addDefault("message.title.bedDestroy.two", "&cwurde zerstört");
        configuration.addDefault("message.drops.bronze", "&cBronze");
        configuration.addDefault("message.drops.iron", "&fEisen");
        configuration.addDefault("message.drops.gold", "&6Gold");
        configuration.addDefault("message.inventory.teamChose", "&8\u00BB &f%count%");
        configuration.addDefault("message.inventory.votingAmount", "&8\u00BB &f%votes% Stimmen");


        List<String> list = new ArrayList<>();
        list.add("%prefix% &7Stats von %player%");
        list.add("&8» &f&lPlatz &8» &e%ranking%");
        list.add("&8» &f&lPunkte &8» &e%points%");
        list.add("&8» &f&lKills &8» &e%kills%");
        list.add("&8» &f&lDeaths &8» &e%deaths%");
        list.add("&8» &f&lGespielt &8» &e%played%");
        list.add("&8» &f&lGewonnen &8» &e%wins%");
        list.add("&8» &f&lVerloren &8» &e%loses%");
        list.add("&8» &f&lBetten &8» &e%beds%");

        configuration.addDefault("message.stats.lines", list);

        configuration.addDefault("chat.format.spectators", "&8[&4\u2716&8] %player% &8\u00BB &7%message%");
        configuration.addDefault("chat.format.normal", "%player% &8\u00BB &7%message%");
        configuration.addDefault("chat.format.team", "%player% &8\u00BB &7%message%");
        configuration.addDefault("chat.format.all", "&8[&f&lGlobal&8] %player% &8\u00BB&7%message%");

        configuration.addDefault("scoreboard.title", "%prefix% &f%time%");

        configuration.addDefault("scoreboard.line1.title", "&f&lSpieler");
        configuration.addDefault("scoreboard.line1.input", " &8\u00BB &e%players%");
        configuration.addDefault("scoreboard.line2.title", "&f&lVariante");
        configuration.addDefault("scoreboard.line2.input", " &8\u00BB &e%mode%");
        configuration.addDefault("scoreboard.line3.title", "&f&lKarte");
        configuration.addDefault("scoreboard.line3.input", " &8\u00BB &e%map%");
        configuration.addDefault("scoreboard.line4.title", "&f&lTeam");
        configuration.addDefault("scoreboard.line4.input", " &8\u00BB %team%");
        configuration.addDefault("scoreboard.line5.title", "&f&lTeams");

        configuration.addDefault("scoreboard.line.teamHasBed.one", " &8\u00BB &2\u2714 %team%");
        configuration.addDefault("scoreboard.line.teamHasBed.two", " &8\u2503 &f%players%");
        configuration.addDefault("scoreboard.line.teamHasNoBed.one", " &8\u00BB &4\u2716 %team%");
        configuration.addDefault("scoreboard.line.teamHasNoBed.two", " &8\u2503 &f%players%");
        configuration.addDefault("scoreboard.line.teamDeath.one", " &r&8\u00BB &4\u2716 %team%&m");
        configuration.addDefault("scoreboard.line.teamDeath.two", "&r");

        configuration.addDefault("scoreboard.teams.prefix", "%team%");
        configuration.addDefault("scoreboard.spectator.prefix", "&7");
        configuration.addDefault("scoreboard.spectator.display", "&7");

        configuration.addDefault("item.team.material", "ARMOR_STAND");
        configuration.addDefault("item.team.name", "&8\u00BB &e§lTeams");
        configuration.addDefault("item.team.slot", 1);
        configuration.addDefault("item.leave.material", "MAGMA_CREAM");
        configuration.addDefault("item.leave.name", "&8\u00BB &e&lVerlassen");
        configuration.addDefault("item.leave.slot", 7);
        configuration.addDefault("item.compass.material", "COMPASS");
        configuration.addDefault("item.compass.name", "&8\u00BB &e&lSpieler");
        configuration.addDefault("item.compass.slot", 4);
        configuration.addDefault("item.vote.material", "PAPER");
        configuration.addDefault("item.vote.name", "&8\u00BB &e&lVoting");
        configuration.addDefault("item.vote.slot", 3);
        configuration.addDefault("item.start.material", "REDSTONE_TORCH_ON");
        configuration.addDefault("item.start.name", "&8\u00BB &e&lSpiel starten");
        configuration.addDefault("item.start.slot", 5);
        configuration.addDefault("item.voting.mapVote", "&8\u00BB &e&lMapvoting");
        configuration.addDefault("item.voting.goldVote", "&8\u00BB &e&lGoldVoting");
        configuration.addDefault("item.voting.itemDropVote", "&8\u00BB &e&lItemDrop Voting");
        configuration.addDefault("item.setup.setLobby.name", "&8» &7&lLobby Spawn setzen (Rechtsklick)");
        configuration.addDefault("item.setup.setLobby.lore", "&8» &7Bitte auf Position stellen und Rechtsklick");
        configuration.addDefault("item.setup.setSpectator.name", "&8» &7&lSpectator Spawn setzen (Rechtsklick)");
        configuration.addDefault("item.setup.setSpectator.lore", "&8» &7Bitte auf Position stellen und Rechtsklick");
        configuration.addDefault("item.setup.setTeamSpawn.name", "&8» &7&lSpawn setzen von %team% (Rechtsklick)");
        configuration.addDefault("item.setup.setTeamSpawn.lore", "&8» &7Bitte auf Position stellen und Rechtsklick");
        configuration.addDefault("item.setup.setBed.name", "&8» &7&lUnteres Teil des Bettes von %team% (Zerschlagen)");
        configuration.addDefault("item.setup.setBed.lore", "&8» &7Bitte auf das Bett schlagen");
        configuration.addDefault("item.setup.setBedTop.name", "&8» &7&lOberes Teil des Bettes von %team% (Zerschlagen)");
        configuration.addDefault("item.setup.setBedTop.lore", "&8» &7Bitte auf das Bett schlagen");
        configuration.addDefault("item.setup.setStatsWall.name", "&8» &7&lStats Wand setzen (Zerschlagen)");
        configuration.addDefault("item.setup.setStatsWall.lore", "&8» &7Bitte auf den Kopf klicken");
        configuration.addDefault("item.setup.setBronzeSpawner.name", "&8» &c&lBronze Spawner setzen (Zerschlagen)");
        configuration.addDefault("item.setup.setBronzeSpawner.lore", "&8» &7Bitte auf den Block klicken");
        configuration.addDefault("item.setup.setIronSpawner.name", "&8» &f&lEisen Spawner setzen (Zerschlagen)");
        configuration.addDefault("item.setup.setIronSpawner.lore", "&8» &7Bitte auf den Block klicken");
        configuration.addDefault("item.setup.setGoldSpawner.name", "&8» &6&lGold Spawner setzen (Zerschlagen)");
        configuration.addDefault("item.setup.setGoldSpawner.lore", "&8» &7Bitte auf den Block klicken");
        configuration.addDefault("item.setup.saveMap.name", "&8» &a&lMap speichern (Nicht Wartelobby)");
        configuration.addDefault("item.setup.back.name", "&8» &c&lZurück");
        configuration.addDefault("item.setup.finish.name", "&8» &b&lSetup beenden (Rechtsklick)");
        configuration.addDefault("item.setup.options.name", "&8» &7&lTeams einrichten (Rechtsklick)");

        configuration.addDefault("inventory.shop.title", "&8\u00BB &6Haupt");
        configuration.addDefault("inventory.shop.bricks.name", "&8\u00BB &6Steine");
        configuration.addDefault("inventory.shop.bricks.item", "STAINED_CLAY");
        configuration.addDefault("inventory.shop.armor.name", "&8\u00BB &6R\u00FCstung");
        configuration.addDefault("inventory.shop.armor.item", "CHAINMAIL_CHESTPLATE");
        configuration.addDefault("inventory.shop.tools.name", "&8\u00BB &6Spitzhacken");
        configuration.addDefault("inventory.shop.tools.item", "STONE_PICKAXE");
        configuration.addDefault("inventory.shop.swords.name", "&8\u00BB &6Schwerter");
        configuration.addDefault("inventory.shop.swords.item", "WOOD_SWORD");
        configuration.addDefault("inventory.shop.bows.name", "&8\u00BB &6B\u00F6gen");
        configuration.addDefault("inventory.shop.bows.item", "BOW");
        configuration.addDefault("inventory.shop.food.name", "&8\u00BB &6Essen");
        configuration.addDefault("inventory.shop.food.item", "COOKED_BEEF");
        configuration.addDefault("inventory.shop.chests.name", "&8\u00BB &6Kisten");
        configuration.addDefault("inventory.shop.chests.item", "CHEST");
        configuration.addDefault("inventory.shop.potions.name", "&8\u00BB &6Tr\u00E4nke");
        configuration.addDefault("inventory.shop.potions.item", "GLASS_BOTTLE");
        configuration.addDefault("inventory.shop.specials.name", "&8\u00BB &6Extras");
        configuration.addDefault("inventory.shop.specials.item", "EMERALD");
        configuration.addDefault("inventory.shop.item.bricks.name", "&8\u00BB &aBl\u00F6cke");
        configuration.addDefault("inventory.shop.item.bricks.amount", 2);
        configuration.addDefault("inventory.shop.item.bricks.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.bricks.price.price", 1);
        configuration.addDefault("inventory.shop.item.endStone.name", "&8\u00BB &aEndsteine");
        configuration.addDefault("inventory.shop.item.endStone.amount", 1);
        configuration.addDefault("inventory.shop.item.endStone.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.endStone.price.price", 8);
        configuration.addDefault("inventory.shop.item.ironBlock.name", "&8\u00BB &aEisenblock");
        configuration.addDefault("inventory.shop.item.ironBlock.amount", 1);
        configuration.addDefault("inventory.shop.item.ironBlock.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.ironBlock.price.price", 3);
        configuration.addDefault("inventory.shop.item.glass.name", "&8\u00BB &aGlass");
        configuration.addDefault("inventory.shop.item.glass.amount", 1);
        configuration.addDefault("inventory.shop.item.glass.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.glass.price.price", 4);
        configuration.addDefault("inventory.shop.item.glowStone.name", "&8\u00BB &aLicht");
        configuration.addDefault("inventory.shop.item.glowStone.amount", 1);
        configuration.addDefault("inventory.shop.item.glowStone.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.glowStone.price.price", 4);
        configuration.addDefault("inventory.shop.item.helmet.name", "&8\u00BB &aHelm");
        configuration.addDefault("inventory.shop.item.helmet.amount", 1);
        configuration.addDefault("inventory.shop.item.helmet.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.helmet.price.price", 1);
        configuration.addDefault("inventory.shop.item.leggings.name", "&8\u00BB &aHose");
        configuration.addDefault("inventory.shop.item.leggings.amount", 1);
        configuration.addDefault("inventory.shop.item.leggings.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.leggings.price.price", 1);
        configuration.addDefault("inventory.shop.item.boots.name", "&8\u00BB &aSchuhe");
        configuration.addDefault("inventory.shop.item.boots.amount", 1);
        configuration.addDefault("inventory.shop.item.boots.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.boots.price.price", 1);
        configuration.addDefault("inventory.shop.item.chestPlate1.name", "&8\u00BB &aBrustpanzer I");
        configuration.addDefault("inventory.shop.item.chestPlate1.amount", 1);
        configuration.addDefault("inventory.shop.item.chestPlate1.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.chestPlate1.price.price", 1);
        configuration.addDefault("inventory.shop.item.chestPlate2.name", "&8\u00BB &aBrustpanzer II");
        configuration.addDefault("inventory.shop.item.chestPlate2.amount", 1);
        configuration.addDefault("inventory.shop.item.chestPlate2.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.chestPlate2.price.price", 3);
        configuration.addDefault("inventory.shop.item.chestPlate3.name", "&8\u00BB &aBrustpanzer III");
        configuration.addDefault("inventory.shop.item.chestPlate3.amount", 1);
        configuration.addDefault("inventory.shop.item.chestPlate3.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.chestPlate3.price.price", 5);
        configuration.addDefault("inventory.shop.item.chestPlate4.name", "&8\u00BB &aBrustpanzer IV");
        configuration.addDefault("inventory.shop.item.chestPlate4.amount", 1);
        configuration.addDefault("inventory.shop.item.chestPlate4.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.chestPlate4.price.price", 7);
        configuration.addDefault("inventory.shop.item.woodPickAxe.name", "&8\u00BB &aHolzspitzhacke");
        configuration.addDefault("inventory.shop.item.woodPickAxe.amount", 1);
        configuration.addDefault("inventory.shop.item.woodPickAxe.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.woodPickAxe.price.price", 4);
        configuration.addDefault("inventory.shop.item.stonePickAxe.name", "&8\u00BB &aSteinspitzhacke");
        configuration.addDefault("inventory.shop.item.stonePickAxe.amount", 1);
        configuration.addDefault("inventory.shop.item.stonePickAxe.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.stonePickAxe.price.price", 2);
        configuration.addDefault("inventory.shop.item.ironPickAxe.name", "&8\u00BB &aEisenspitzhacke");
        configuration.addDefault("inventory.shop.item.ironPickAxe.amount", 1);
        configuration.addDefault("inventory.shop.item.ironPickAxe.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.ironPickAxe.price.price", 1);
        configuration.addDefault("inventory.shop.item.stick.name", "&8\u00BB &aStock");
        configuration.addDefault("inventory.shop.item.stick.amount", 1);
        configuration.addDefault("inventory.shop.item.stick.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.stick.price.price", 8);
        configuration.addDefault("inventory.shop.item.sword1.name", "&8\u00BB &aHolzschwert I");
        configuration.addDefault("inventory.shop.item.sword1.amount", 1);
        configuration.addDefault("inventory.shop.item.sword1.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.sword1.price.price", 1);
        configuration.addDefault("inventory.shop.item.sword2.name", "&8\u00BB &aHolzschwert II");
        configuration.addDefault("inventory.shop.item.sword2.amount", 1);
        configuration.addDefault("inventory.shop.item.sword2.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.sword2.price.price", 3);
        configuration.addDefault("inventory.shop.item.sword3.name", "&8\u00BB &aHolzschwert III");
        configuration.addDefault("inventory.shop.item.sword3.amount", 1);
        configuration.addDefault("inventory.shop.item.sword3.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.sword3.price.price", 5);
        configuration.addDefault("inventory.shop.item.sword4.name", "&8\u00BB &aEisenschwert");
        configuration.addDefault("inventory.shop.item.sword4.amount", 1);
        configuration.addDefault("inventory.shop.item.sword4.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.sword4.price.price", 5);
        configuration.addDefault("inventory.shop.item.bow1.name", "&8\u00BB &aBogen I");
        configuration.addDefault("inventory.shop.item.bow1.amount", 1);
        configuration.addDefault("inventory.shop.item.bow1.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.bow1.price.price", 3);
        configuration.addDefault("inventory.shop.item.bow2.name", "&8\u00BB &aBogen II");
        configuration.addDefault("inventory.shop.item.bow2.amount", 1);
        configuration.addDefault("inventory.shop.item.bow2.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.bow2.price.price", 6);
        configuration.addDefault("inventory.shop.item.bow3.name", "&8\u00BB &aBogen III");
        configuration.addDefault("inventory.shop.item.bow3.amount", 1);
        configuration.addDefault("inventory.shop.item.bow3.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.bow3.price.price", 9);
        configuration.addDefault("inventory.shop.item.arrow.name", "&8\u00BB &aPfeil");
        configuration.addDefault("inventory.shop.item.arrow.amount", 1);
        configuration.addDefault("inventory.shop.item.arrow.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.arrow.price.price", 1);
        configuration.addDefault("inventory.shop.item.apple.name", "&8\u00BB &aApfel");
        configuration.addDefault("inventory.shop.item.apple.amount", 1);
        configuration.addDefault("inventory.shop.item.apple.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.apple.price.price", 1);
        configuration.addDefault("inventory.shop.item.beef.name", "&8\u00BB &aFleisch");
        configuration.addDefault("inventory.shop.item.beef.amount", 1);
        configuration.addDefault("inventory.shop.item.beef.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.beef.price.price", 2);
        configuration.addDefault("inventory.shop.item.cake.name", "&8\u00BB &aKuchen");
        configuration.addDefault("inventory.shop.item.cake.amount", 1);
        configuration.addDefault("inventory.shop.item.cake.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.cake.price.price", 1);
        configuration.addDefault("inventory.shop.item.goldenApple.name", "&8\u00BB &aGold Apfel");
        configuration.addDefault("inventory.shop.item.goldenApple.amount", 1);
        configuration.addDefault("inventory.shop.item.goldenApple.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.goldenApple.price.price", 2);
        configuration.addDefault("inventory.shop.item.chest.name", "&8\u00BB &aKiste");
        configuration.addDefault("inventory.shop.item.chest.amount", 1);
        configuration.addDefault("inventory.shop.item.chest.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.chest.price.price", 1);
        configuration.addDefault("inventory.shop.item.endChest.name", "&8\u00BB &aEnderkiste");
        configuration.addDefault("inventory.shop.item.endChest.amount", 1);
        configuration.addDefault("inventory.shop.item.endChest.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.endChest.price.price", 1);
        configuration.addDefault("inventory.shop.item.healing1.name", "&8\u00BB &aHeltrank I");
        configuration.addDefault("inventory.shop.item.healing1.amount", 1);
        configuration.addDefault("inventory.shop.item.healing1.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.healing1.price.price", 3);
        configuration.addDefault("inventory.shop.item.healing2.name", "&8\u00BB &aHeiltrank II");
        configuration.addDefault("inventory.shop.item.healing2.amount", 1);
        configuration.addDefault("inventory.shop.item.healing2.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.healing2.price.price", 6);
        configuration.addDefault("inventory.shop.item.strength.name", "&8\u00BB &aSt\u00E4rketrank");
        configuration.addDefault("inventory.shop.item.strength.amount", 1);
        configuration.addDefault("inventory.shop.item.strength.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.strength.price.price", 3);
        configuration.addDefault("inventory.shop.item.regeneration.name", "&8\u00BB &aRegenerationstrank");
        configuration.addDefault("inventory.shop.item.regeneration.amount", 1);
        configuration.addDefault("inventory.shop.item.regeneration.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.regeneration.price.price", 3);
        configuration.addDefault("inventory.shop.item.speed.name", "&8\u00BB &aSchnelligkeitstrank");
        configuration.addDefault("inventory.shop.item.speed.amount", 1);
        configuration.addDefault("inventory.shop.item.speed.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.speed.price.price", 4);
        configuration.addDefault("inventory.shop.item.ladder.name", "&8\u00BB &aLeiter");
        configuration.addDefault("inventory.shop.item.ladder.amount", 1);
        configuration.addDefault("inventory.shop.item.ladder.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.ladder.price.price", 4);
        configuration.addDefault("inventory.shop.item.web.name", "&8\u00BB &aSpinnennetz");
        configuration.addDefault("inventory.shop.item.web.amount", 1);
        configuration.addDefault("inventory.shop.item.web.price.material", "CLAY_BRICK");
        configuration.addDefault("inventory.shop.item.web.price.price", 16);
        configuration.addDefault("inventory.shop.item.warp.name", "&8\u00BB &aTeleporter");
        configuration.addDefault("inventory.shop.item.warp.amount", 1);
        configuration.addDefault("inventory.shop.item.warp.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.warp.price.price", 5);
        configuration.addDefault("inventory.shop.item.shop.name", "&8\u00BB &aMobiler Shop");
        configuration.addDefault("inventory.shop.item.shop.amount", 1);
        configuration.addDefault("inventory.shop.item.shop.price.material", "IRON_INGOT");
        configuration.addDefault("inventory.shop.item.shop.price.price", 7);
        configuration.addDefault("inventory.shop.item.tnt.name", "&8\u00BB &aTNT");
        configuration.addDefault("inventory.shop.item.tnt.amount", 1);
        configuration.addDefault("inventory.shop.item.tnt.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.tnt.price.price", 3);
        configuration.addDefault("inventory.shop.item.egg.name", "&8\u00BB &aFallschirm");
        configuration.addDefault("inventory.shop.item.egg.amount", 1);
        configuration.addDefault("inventory.shop.item.egg.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.egg.price.price", 3);
        configuration.addDefault("inventory.shop.item.rescue.name", "&8\u00BB &aRettungsplatform");
        configuration.addDefault("inventory.shop.item.rescue.amount", 1);
        configuration.addDefault("inventory.shop.item.rescue.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.rescue.price.price", 4);
        configuration.addDefault("inventory.shop.item.pearl.name", "&8\u00BB &aEnderperle");
        configuration.addDefault("inventory.shop.item.pearl.amount", 1);
        configuration.addDefault("inventory.shop.item.pearl.price.material", "GOLD_INGOT");
        configuration.addDefault("inventory.shop.item.pearl.price.price", 13);
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfiguration() {
        return configuration;
    }

    public Integer getInt(String string) {
        try {
            if (!cacheInt.containsKey(string)) {
                cacheInt.put(string, configuration.getInt(string));
            }
            return cacheInt.get(string);
        } catch (Exception e) {
            Bukkit.broadcastMessage(BedWars.getInstance().getBedWarsConfig().getString("message.pathNotFound")
                    .replace("%value%", string));
            return 0;
        }
    }

    public Boolean getBoolean(String string) {
        if (!cacheBoolean.containsKey(string)) {
            cacheBoolean.put(string, configuration.getBoolean(string));
        }
        return cacheBoolean.get(string);
    }

    public String getString(String string) {
        try {
            if (!cacheString.containsKey(string)) {
                cacheString.put(string, ChatColor.translateAlternateColorCodes('&', configuration.getString(string)
                        .replace("%prefix%", configuration.getString("message.prefix"))));
            }
            return cacheString.get(string);
        } catch (Exception e) {
            return BedWars.getInstance().getBedWarsConfig().getString("message.pathNotFound")
                    .replace("%value%", string);
        }
    }
}
