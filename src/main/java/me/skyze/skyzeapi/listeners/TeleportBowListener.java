package me.skyze.skyzeapi.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class TeleportBowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {
        if (e.getEntity().getType() == EntityType.ARROW) {
            //check to see if shot by tel.bow
            if (e.getEntity().getShooter() instanceof Player p) {

                ItemStack itemInHand = p.getInventory().getItemInMainHand();

                if (itemInHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "" + ChatColor.BOLD + "Mikiho Teleport Bow")) {

                    if (p.getLevel() >= 1) {

                        Location loc = e.getEntity().getLocation();

                        p.teleport(loc);
                        p.setLevel((p.getLevel() - 1));
                        e.getEntity().remove();
                        p.playSound(p, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    } else {
                        p.sendMessage(ChatColor.RED+ "Mas malo xp na teleport!");
                    }
                }
            }
        }
    }
}

