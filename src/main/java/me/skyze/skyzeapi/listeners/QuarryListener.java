package me.skyze.skyzeapi.listeners;

import me.skyze.skyzeapi.SkyzeAPI;
import me.skyze.skyzeapi.utility.QuarryUtils;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collection;

import static org.bukkit.Bukkit.getServer;

public class QuarryListener implements Listener {

    private boolean running = false;
    private Block chest;

    private ArrayList<QuarryUtils> quarries = new ArrayList<QuarryUtils>();
    private ArrayList<Location> locations = new ArrayList<Location>();

    @EventHandler
    public void onRightClickQuarry(PlayerInteractEvent e) {
        Action a = e.getAction();
        Player p = e.getPlayer();
        if (a.equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock() != null) {
            Block clickedBlock = e.getClickedBlock();
            //this.clickedBlock = clickedBlock;
            if (clickedBlock.getType().equals(Material.OBSERVER)) {
                Block chest = p.getWorld().getBlockAt(clickedBlock.getLocation().add(0,1,0));
                this.chest = chest;
                if (chest.getType() == Material.CHEST) {
                    quarryGUI(p, clickedBlock.getLocation());
                }
            }
        }
    }

    public void quarryGUI(Player p, Location loc) {
        String location = Integer. toString(loc.hashCode());

        Inventory gui = Bukkit.createInventory(p, 9, "Quarry menu "+location);
        ItemStack start = new ItemStack(Material.EMERALD_BLOCK, 1);
        ItemMeta startMeta = start.getItemMeta();
        startMeta.setDisplayName(ChatColor.GREEN+ "START");
        start.setItemMeta(startMeta);

        ItemStack stop = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta stopMeta = stop.getItemMeta();
        stopMeta.setDisplayName(ChatColor.RED+ "STOP");
        stop.setItemMeta(stopMeta);

        ItemStack hranice = new ItemStack(Material.PAPER, 1);
        ItemMeta hraniceMeta = hranice.getItemMeta();
        hraniceMeta.setDisplayName(ChatColor.GOLD+ "Ukaz hranice");
        hranice.setItemMeta(hraniceMeta);

        gui.addItem(start);
        gui.addItem(stop);
        gui.addItem(hranice);
        p.openInventory(gui);
    }

    @EventHandler
    public void onQuarryCreation(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (e.getBlockPlaced().getType() == Material.CHEST) {
            Location observerLocation = e.getBlockPlaced().getLocation().add(0,-1,0);
            if (p.getWorld().getBlockAt(observerLocation).getType() == Material.OBSERVER) {
                p.sendMessage("Quarry bolo vytvorene");

                if ((locations.contains(observerLocation))) {
                    return;
                } else {this.locations.add(observerLocation);}
//                this.locations.add(new Location(p.getWorld(), 1, 2, 2));
//                for (Location l : this.locations) {
//                    if (l.equals(observerLocation)) {
//
//                    } else {this.locations.add(observerLocation);}
//                }

                if ((quarries.contains(new QuarryUtils(observerLocation)))) {
                    return;
                } else {this.quarries.add(new QuarryUtils(observerLocation));}
//                this.quarries.add(new QuarryUtils(new Location(p.getWorld(), 2, 2, 2)));
//                for (QuarryUtils q : this.quarries) {
//                    if (q.getLoc().equals(observerLocation)) {
//
//                    } else {this.quarries.add(new QuarryUtils(observerLocation));}
//                }
                //ha(observerLocation);
                //Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SkyzeAPI.getPlugin(), () -> SkyzeAPI.spawnParticleForEveryPlayer(observerLocation, Color.RED, Color.ORANGE, 0.5F, 0.4, 0.4, 0.4, 50, 0.4F, 0.4F, 0.4F), 4);
            }
        }
    }

    @EventHandler
    public void onQuarryMenuClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player p) {
            for (Location l : this.locations) {
                if (e.getView().getTitle().equalsIgnoreCase("Quarry menu "+Integer. toString(l.hashCode()))) {
                    e.setCancelled(true);
                    for (QuarryUtils q : this.quarries) {
                        if (q.getLoc().equals(l)) {
                            if (e.getCurrentItem() == null) {
                                return;
                            } else if (e.getCurrentItem().getType().equals(Material.REDSTONE_BLOCK)) {

                                if (q.getRunning()) {
                                    p.sendMessage("Quarry sa zastavilo!");
                                    q.setRunning(false);
                                } else {
                                    p.sendMessage("Quarry prave nepracuje");
                                }


                            } else if (e.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)) {
                                BlockState bs = chest.getState();
                                Container cont = (Container) bs;
                                Inventory inv = cont.getInventory();
                                if (inv.contains(Material.NETHERITE_INGOT)) {
                                    if (q.getRunning()) {
                                        p.sendMessage("Quarry prave pracuje");
                                    } else {
                                        p.sendMessage("Quarry sa spustilo");
                                        q.setRunning(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}
