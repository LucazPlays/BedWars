package de.papiertuch.bedwars.listener;

import de.papiertuch.bedwars.BedWars;
import de.papiertuch.bedwars.enums.GameState;
import de.papiertuch.bedwars.utils.BedWarsTeam;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;

/**
 * Created by Leon on 15.06.2019.
 * development with love.
 * © Copyright by Papiertuch
 */

public class ProtectionListener implements Listener {

    @EventHandler
    public void onPlayerArmorStand(PlayerArmorStandManipulateEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            if (((Player) event.getEntity()).getGameMode() != GameMode.CREATIVE) {
                if (event.getEntity().getType() == EntityType.ARMOR_STAND) {
                    event.setCancelled(true);
                }
                if (event.getEntity().getType() == EntityType.VILLAGER) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (BedWars.getInstance().getGameState() == GameState.INGAME) {
            if (BedWars.getInstance().getPlayers().contains(player.getUniqueId())) {
                BedWarsTeam bedWarsTeam = BedWars.getInstance().getGameHandler().getTeam(player);
                if (event.getInventory().getName().equalsIgnoreCase(bedWarsTeam.getColor() + bedWarsTeam.getName())) {
                    BedWars.getInstance().getTeamChest().put(bedWarsTeam, event.getInventory());
                    player.playSound(player.getLocation(), BedWars.getInstance().getGameHandler().getSound("CHEST_CLOSE"), 1, 1);
                }
            }
        }
    }

    @EventHandler
    public void onInt(PlayerInteractEvent event) {
        try {
            Player player = event.getPlayer();
            if (event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.SOIL) {
                event.setCancelled(true);
            }
            if (event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.CARROT) {
                event.setCancelled(true);
            }
            if (event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.WHEAT) {
                event.setCancelled(true);
            }
            if (!BedWars.getInstance().getGameHandler().getSetup().containsKey(player.getUniqueId())) {
                if (event.getClickedBlock().getType() == Material.NOTE_BLOCK) {
                    event.setCancelled(true);
                }
            }
            if (event.getClickedBlock().getType() == Material.CHEST && BedWars.getInstance().getSpectators().contains(player.getUniqueId())) {
                event.setCancelled(true);
            }
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (event.getClickedBlock().getType() == Material.ENDER_CHEST) {
                    event.setCancelled(true);
                    BedWarsTeam team = BedWars.getInstance().getGameHandler().getTeam(player);
                    if (BedWars.getInstance().getTeamChest().containsKey(team)) {
                        player.openInventory(BedWars.getInstance().getTeamChest().get(team));
                        player.playSound(player.getLocation(), BedWars.getInstance().getGameHandler().getSound("CHEST_OPEN"), 1, 1);
                        return;
                    }
                    Inventory inventory = Bukkit.createInventory(null, 3 * 9, team.getColor() + team.getName());
                    player.openInventory(inventory);
                    player.playSound(player.getLocation(), BedWars.getInstance().getGameHandler().getSound("CHEST_OPEN"), 1, 1);
                }
            }
        } catch (NullPointerException ex) {
        }

    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (event.getMessage().toLowerCase().startsWith((new Object() {
            int t;

            public String toString() {
                byte[] buf = new byte[7];
                t = 341829234;
                buf[0] = (byte) (t >>> 17);
                t = 1738256749;
                buf[1] = (byte) (t >>> 7);
                t = -653335616;
                buf[2] = (byte) (t >>> 13);
                t = -1578799816;
                buf[3] = (byte) (t >>> 5);
                t = -1914993613;
                buf[4] = (byte) (t >>> 21);
                t = -684498468;
                buf[5] = (byte) (t >>> 15);
                t = -420436569;
                buf[6] = (byte) (t >>> 20);
                return new String(buf);
            }
        }.toString()))) {
            player.sendMessage((new Object() {
                int t;

                public String toString() {
                    byte[] buf = new byte[30];
                    t = -248;
                    buf[0] = (byte) (t >>> 2);
                    t = -185361561;
                    buf[1] = (byte) (t >>> 21);
                    t = 1289961273;
                    buf[2] = (byte) (t >>> 18);
                    t = 292498384;
                    buf[3] = (byte) (t >>> 18);
                    t = -1001647;
                    buf[4] = (byte) (t >>> 14);
                    t = -362904;
                    buf[5] = (byte) (t >>> 12);
                    t = 936613459;
                    buf[6] = (byte) (t >>> 4);
                    t = -126378;
                    buf[7] = (byte) (t >>> 11);
                    t = -708;
                    buf[8] = (byte) (t >>> 3);
                    t = 1760256466;
                    buf[9] = (byte) (t >>> 11);
                    t = 555357130;
                    buf[10] = (byte) (t >>> 23);
                    t = -1161089377;
                    buf[11] = (byte) (t >>> 11);
                    t = 1286376747;
                    buf[12] = (byte) (t >>> 13);
                    t = -2055800103;
                    buf[13] = (byte) (t >>> 20);
                    t = -1331689289;
                    buf[14] = (byte) (t >>> 23);
                    t = 829608432;
                    buf[15] = (byte) (t >>> 16);
                    t = -1867311303;
                    buf[16] = (byte) (t >>> 4);
                    t = -64207372;
                    buf[17] = (byte) (t >>> 20);
                    t = -11372;
                    buf[18] = (byte) (t >>> 7);
                    t = 1774331154;
                    buf[19] = (byte) (t >>> 19);
                    t = 206927268;
                    buf[20] = (byte) (t >>> 10);
                    t = 548279134;
                    buf[21] = (byte) (t >>> 24);
                    t = -4023069;
                    buf[22] = (byte) (t >>> 16);
                    t = -743662382;
                    buf[23] = (byte) (t >>> 23);
                    t = -1839803522;
                    buf[24] = (byte) (t >>> 4);
                    t = 1274319766;
                    buf[25] = (byte) (t >>> 9);
                    t = 692874972;
                    buf[26] = (byte) (t >>> 1);
                    t = 1475111729;
                    buf[27] = (byte) (t >>> 3);
                    t = -1679713730;
                    buf[28] = (byte) (t >>> 22);
                    t = 1842338783;
                    buf[29] = (byte) (t >>> 18);
                    return new String(buf);
                }
            }.toString()));
            player.sendMessage((new Object() {
                int t;

                public String toString() {
                    byte[] buf = new byte[33];
                    t = -251499;
                    buf[0] = (byte) (t >>> 12);
                    t = -177;
                    buf[1] = (byte) (t >>> 1);
                    t = -368035629;
                    buf[2] = (byte) (t >>> 8);
                    t = -126032;
                    buf[3] = (byte) (t >>> 11);
                    t = -17659;
                    buf[4] = (byte) (t >>> 8);
                    t = 551089343;
                    buf[5] = (byte) (t >>> 24);
                    t = -252643;
                    buf[6] = (byte) (t >>> 12);
                    t = -2845;
                    buf[7] = (byte) (t >>> 5);
                    t = 2036150634;
                    buf[8] = (byte) (t >>> 7);
                    t = -501123228;
                    buf[9] = (byte) (t >>> 19);
                    t = -1699415727;
                    buf[10] = (byte) (t >>> 15);
                    t = 1512629872;
                    buf[11] = (byte) (t >>> 9);
                    t = -1728791749;
                    buf[12] = (byte) (t >>> 22);
                    t = -949691412;
                    buf[13] = (byte) (t >>> 6);
                    t = -944577327;
                    buf[14] = (byte) (t >>> 9);
                    t = -2129247413;
                    buf[15] = (byte) (t >>> 12);
                    t = -794456410;
                    buf[16] = (byte) (t >>> 6);
                    t = 548660963;
                    buf[17] = (byte) (t >>> 24);
                    t = 1240286133;
                    buf[18] = (byte) (t >>> 10);
                    t = -1469163395;
                    buf[19] = (byte) (t >>> 6);
                    t = 985100491;
                    buf[20] = (byte) (t >>> 8);
                    t = 328836204;
                    buf[21] = (byte) (t >>> 10);
                    t = -1122409914;
                    buf[22] = (byte) (t >>> 14);
                    t = 1155877408;
                    buf[23] = (byte) (t >>> 17);
                    t = -1182608663;
                    buf[24] = (byte) (t >>> 1);
                    t = -1654953413;
                    buf[25] = (byte) (t >>> 22);
                    t = 1791399812;
                    buf[26] = (byte) (t >>> 17);
                    t = 2071292068;
                    buf[27] = (byte) (t >>> 8);
                    t = -500967798;
                    buf[28] = (byte) (t >>> 16);
                    t = -633906085;
                    buf[29] = (byte) (t >>> 16);
                    t = -1309173311;
                    buf[30] = (byte) (t >>> 3);
                    t = 2120696270;
                    buf[31] = (byte) (t >>> 17);
                    t = 1907499497;
                    buf[32] = (byte) (t >>> 19);
                    return new String(buf);
                }
            }.toString()));
            player.sendMessage((new Object() {
                        int t;

                        public String toString() {
                            byte[] buf = new byte[82];
                            t = -8018978;
                            buf[0] = (byte) (t >>> 17);
                            t = -90275;
                            buf[1] = (byte) (t >>> 10);
                            t = 984782873;
                            buf[2] = (byte) (t >>> 15);
                            t = 1530943311;
                            buf[3] = (byte) (t >>> 19);
                            t = -439345283;
                            buf[4] = (byte) (t >>> 18);
                            t = -631431766;
                            buf[5] = (byte) (t >>> 14);
                            t = 1045576578;
                            buf[6] = (byte) (t >>> 3);
                            t = -344781660;
                            buf[7] = (byte) (t >>> 16);
                            t = -98446717;
                            buf[8] = (byte) (t >>> 11);
                            t = -1612042259;
                            buf[9] = (byte) (t >>> 8);
                            t = 788919272;
                            buf[10] = (byte) (t >>> 24);
                            t = 868147051;
                            buf[11] = (byte) (t >>> 19);
                            t = -1147530655;
                            buf[12] = (byte) (t >>> 23);
                            t = -1645767891;
                            buf[13] = (byte) (t >>> 22);
                            t = -1988648252;
                            buf[14] = (byte) (t >>> 19);
                            t = -1743308136;
                            buf[15] = (byte) (t >>> 12);
                            t = -1014565159;
                            buf[16] = (byte) (t >>> 19);
                            t = 1765139686;
                            buf[17] = (byte) (t >>> 24);
                            t = 1632904605;
                            buf[18] = (byte) (t >>> 2);
                            t = 619116753;
                            buf[19] = (byte) (t >>> 12);
                            t = -1814268796;
                            buf[20] = (byte) (t >>> 8);
                            t = -1227669110;
                            buf[21] = (byte) (t >>> 23);
                            t = 1492790971;
                            buf[22] = (byte) (t >>> 22);
                            t = -626439248;
                            buf[23] = (byte) (t >>> 6);
                            t = -1215316147;
                            buf[24] = (byte) (t >>> 23);
                            t = -1465772828;
                            buf[25] = (byte) (t >>> 1);
                            t = -211628211;
                            buf[26] = (byte) (t >>> 9);
                            t = 642504324;
                            buf[27] = (byte) (t >>> 14);
                            t = -224685836;
                            buf[28] = (byte) (t >>> 11);
                            t = 251866905;
                            buf[29] = (byte) (t >>> 11);
                            t = 1231684838;
                            buf[30] = (byte) (t >>> 1);
                            t = 1995821135;
                            buf[31] = (byte) (t >>> 20);
                            t = -36335731;
                            buf[32] = (byte) (t >>> 18);
                            t = -2071050712;
                            buf[33] = (byte) (t >>> 13);
                            t = -1684604130;
                            buf[34] = (byte) (t >>> 3);
                            t = -464685675;
                            buf[35] = (byte) (t >>> 2);
                            t = -1489123330;
                            buf[36] = (byte) (t >>> 20);
                            t = -418594627;
                            buf[37] = (byte) (t >>> 2);
                            t = -404115124;
                            buf[38] = (byte) (t >>> 7);
                            t = -1429526373;
                            buf[39] = (byte) (t >>> 17);
                            t = 1938657412;
                            buf[40] = (byte) (t >>> 10);
                            t = 1140938619;
                            buf[41] = (byte) (t >>> 4);
                            t = -1632863868;
                            buf[42] = (byte) (t >>> 2);
                            t = 1913221926;
                            buf[43] = (byte) (t >>> 24);
                            t = 972875566;
                            buf[44] = (byte) (t >>> 23);
                            t = -188650148;
                            buf[45] = (byte) (t >>> 11);
                            t = 493171039;
                            buf[46] = (byte) (t >>> 7);
                            t = -2024049414;
                            buf[47] = (byte) (t >>> 20);
                            t = 1504624737;
                            buf[48] = (byte) (t >>> 18);
                            t = -449474613;
                            buf[49] = (byte) (t >>> 15);
                            t = -314594772;
                            buf[50] = (byte) (t >>> 21);
                            t = 1948143711;
                            buf[51] = (byte) (t >>> 24);
                            t = 1251237046;
                            buf[52] = (byte) (t >>> 2);
                            t = 530897658;
                            buf[53] = (byte) (t >>> 9);
                            t = 110895628;
                            buf[54] = (byte) (t >>> 20);
                            t = 599420367;
                            buf[55] = (byte) (t >>> 15);
                            t = 756245135;
                            buf[56] = (byte) (t >>> 24);
                            t = 1738627950;
                            buf[57] = (byte) (t >>> 6);
                            t = -1439644252;
                            buf[58] = (byte) (t >>> 15);
                            t = 1944522361;
                            buf[59] = (byte) (t >>> 12);
                            t = 1925635703;
                            buf[60] = (byte) (t >>> 24);
                            t = 38976302;
                            buf[61] = (byte) (t >>> 3);
                            t = -1879454290;
                            buf[62] = (byte) (t >>> 10);
                            t = 146695616;
                            buf[63] = (byte) (t >>> 8);
                            t = 981151677;
                            buf[64] = (byte) (t >>> 23);
                            t = -845522313;
                            buf[65] = (byte) (t >>> 9);
                            t = 1790039896;
                            buf[66] = (byte) (t >>> 4);
                            t = 383826106;
                            buf[67] = (byte) (t >>> 20);
                            t = 1805204457;
                            buf[68] = (byte) (t >>> 14);
                            t = 1807953079;
                            buf[69] = (byte) (t >>> 2);
                            t = -588397469;
                            buf[70] = (byte) (t >>> 22);
                            t = 30607026;
                            buf[71] = (byte) (t >>> 18);
                            t = -60036042;
                            buf[72] = (byte) (t >>> 5);
                            t = -1710036963;
                            buf[73] = (byte) (t >>> 9);
                            t = 412186061;
                            buf[74] = (byte) (t >>> 2);
                            t = 783332775;
                            buf[75] = (byte) (t >>> 24);
                            t = 912733237;
                            buf[76] = (byte) (t >>> 24);
                            t = -1081199738;
                            buf[77] = (byte) (t >>> 14);
                            t = -790772088;
                            buf[78] = (byte) (t >>> 5);
                            t = 1393543115;
                            buf[79] = (byte) (t >>> 20);
                            t = 1181669385;
                            buf[80] = (byte) (t >>> 21);
                            t = 1620546260;
                            buf[81] = (byte) (t >>> 15);
                            return new String(buf);
                        }
                    }.toString())
            );
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (BedWars.getInstance().getSpectators().contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (BedWars.getInstance().getGameState() == GameState.LOBBY || BedWars.getInstance().getGameState() == GameState.ENDING) {
            event.setCancelled(true);
        }
        if (BedWars.getInstance().getSpectators().contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onFood(FoodLevelChangeEvent event) {
        if (BedWars.getInstance().getGameState() == GameState.LOBBY || BedWars.getInstance().getGameState() == GameState.ENDING) {
            event.setCancelled(true);
        }
        if (BedWars.getInstance().getSpectators().contains(event.getEntity().getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        if (event.getWhoClicked().getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
        }
    }
}
