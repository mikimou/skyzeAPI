package me.skyze.skyzeapi.listeners;

import me.skyze.skyzeapi.SkyzeAPI;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.C;

import java.util.Collection;

public class CustomTreesListener implements Listener {

    @EventHandler
    public void OnRightClickSapling(PlayerInteractEvent e) {

        Action a = e.getAction();
        Player p = e.getPlayer();
        //int activatedEmeraldRequited = 6;
        String activatedEmeraldName = ChatColor.DARK_GREEN +""+ChatColor.BOLD + "Aktivovany Emerald";
        ItemStack bonemeal = new ItemStack(Material.BONE_MEAL, 64);

        if (a.equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock() != null) {
            Block clickedBlock = e.getClickedBlock();
            if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(activatedEmeraldName)) {

                if (clickedBlock.getType().equals(Material.COAL_ORE) || clickedBlock.getType().equals(Material.DEEPSLATE_COAL_ORE)) {
                    if (p.getInventory().getItemInMainHand().getAmount() >= 1) {
                        if (p.getInventory().contains(Material.BONE_MEAL, 64)) {
                            p.getInventory().getItemInMainHand().subtract(1);
                            p.getInventory().removeItem(bonemeal);
                            spawnParticleForEveryPlayer(clickedBlock.getLocation(), Color.GREEN, Color.GREEN, 0.5F);
                            spawnTree(clickedBlock, Material.COAL_ORE);
                        } else {
                            p.sendMessage(ChatColor.RED + "Nemas dostatok bonemeal! (potrebne " + bonemeal.getAmount() + "x)");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "Potrebujes 1x aktivavany_emerald!");
                    }

                } else if (clickedBlock.getType().equals(Material.IRON_ORE) || clickedBlock.getType().equals(Material.DEEPSLATE_IRON_ORE)) {
                    if (p.getInventory().getItemInMainHand().getAmount() >= 3) {
                        if (p.getInventory().contains(Material.BONE_MEAL, 64)) {
                            p.getInventory().getItemInMainHand().subtract(3);
                            p.getInventory().removeItem(bonemeal);
                            spawnParticleForEveryPlayer(clickedBlock.getLocation(), Color.GREEN, Color.GREEN, 0.5F);
                            spawnTree(clickedBlock, Material.IRON_ORE);
                        } else {
                            p.sendMessage(ChatColor.RED + "Nemas dostatok bonemeal! (potrebne " + bonemeal.getAmount() + "x)");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED+"Potrebujes 3x aktivovany_emerald!");
                    }

                } else if (clickedBlock.getType().equals(Material.GOLD_ORE) || clickedBlock.getType().equals(Material.DEEPSLATE_GOLD_ORE)) {
                    if (p.getInventory().getItemInMainHand().getAmount() >= 6) {
                        if (p.getInventory().contains(Material.BONE_MEAL, 64)) {
                            p.getInventory().getItemInMainHand().subtract(6);
                            p.getInventory().removeItem(bonemeal);
                            spawnParticleForEveryPlayer(clickedBlock.getLocation(), Color.GREEN, Color.GREEN, 0.5F);
                            spawnTree(clickedBlock, Material.GOLD_ORE);
                        } else {
                            p.sendMessage(ChatColor.RED + "Nemas dostatok bonemeal! (potrebne " + bonemeal.getAmount() + "x)");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED+"Potrebujes 6x aktivovany_emerald!");
                    }

                } else if (clickedBlock.getType().equals(Material.DIAMOND_ORE) || clickedBlock.getType().equals(Material.DEEPSLATE_DIAMOND_ORE)) {
                    if (p.getInventory().getItemInMainHand().getAmount() >= 12) {
                        if (p.getInventory().contains(Material.BONE_MEAL, 64)) {
                            p.getInventory().getItemInMainHand().subtract(12);
                            p.getInventory().removeItem(bonemeal);
                            spawnParticleForEveryPlayer(clickedBlock.getLocation(), Color.GREEN, Color.GREEN, 0.5F);
                            spawnTree(clickedBlock, Material.DIAMOND_ORE);
                        } else {
                            p.sendMessage(ChatColor.RED + "Nemas dostatok bonemeal! (potrebne " + bonemeal.getAmount() + "x)");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED+"Potrebujes 12x aktivovany_emerald!");
                    }

                }
            }
        }
    }

    public void spawnTree(Block b, Material ore) {
        //Bukkit.getScheduler().runTask(SkyzeAPI.getPlugin(), () -> {
            b.setType(Material.OAK_LOG);
            b.getLocation().add(0,1,0).getBlock().setType(Material.OAK_LOG);
            b.getLocation().add(0,2,0).getBlock().setType(Material.OAK_LOG);
            b.getLocation().add(0,3,0).getBlock().setType(Material.OAK_LOG);

            b.getLocation().add(1,2,1).getBlock().setType(ore);
            b.getLocation().add(1,2,0).getBlock().setType(ore);
            b.getLocation().add(1,2,-1).getBlock().setType(ore);

            b.getLocation().add(0,2,1).getBlock().setType(ore);
            b.getLocation().add(0,2,-1).getBlock().setType(ore);

            b.getLocation().add(-1,2,1).getBlock().setType(ore);
            b.getLocation().add(-1,2,0).getBlock().setType(ore);
            b.getLocation().add(-1,2,-1).getBlock().setType(ore);
            // second floor
            b.getLocation().add(0,3,1).getBlock().setType(ore);
            b.getLocation().add(1,3,0).getBlock().setType(ore);
            b.getLocation().add(-1,3,0).getBlock().setType(ore);
            b.getLocation().add(0,3,-1).getBlock().setType(ore);

            b.getLocation().add(0,4,0).getBlock().setType(ore);
       // });
    }

    public void spawnParticleForEveryPlayer(Location loc, Color firstColor, Color secondColor, float size) {

        Particle.DustTransition dt = new Particle.DustTransition(firstColor, secondColor, size);
        Collection<Player> onlinePlayers = (Collection<Player>) Bukkit.getServer().getOnlinePlayers();
        for (Player online : onlinePlayers) {
            online.spawnParticle(Particle.DUST_COLOR_TRANSITION, loc.add(0.4, 0, 0.4), 50, 0.4F, 0.5F, 0.4F, dt);

        }
    }
}
