package me.skyze.skyzeapi.listeners;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Random;

public class FlameStickListener implements Listener {

    @EventHandler
    public void onRighClickEntity(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        Entity ent = e.getRightClicked();

        if (!(ent instanceof Player)) {
            ItemStack itemInHand = p.getInventory().getItemInMainHand();
            ItemStack lavaBucket = new ItemStack(Material.LAVA_BUCKET, 1);
            if (itemInHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED +""+ ChatColor.BOLD + "Paliva" + ChatColor.RESET +""+ChatColor.BOLD + " Palicka")) {
                if (p.getInventory().contains(lavaBucket)) {
                    Collection<Entity> entities = ent.getLocation().getNearbyEntities(8, 5, 8);
                    for (Entity enti : entities) {
                        if (enti instanceof Player) {
                            continue;
                        } else {
                            enti.setFireTicks(1000);
                        }
                    }
                    Random r = new Random();
                    if (r.nextInt(100) < 15) {
                        p.getInventory().removeItem(lavaBucket);
                        p.getInventory().addItem(new ItemStack(Material.BUCKET, 1));
                    }
                    Particle.DustTransition dt = new Particle.DustTransition(Color.RED, Color.ORANGE, 1.0F);
                    Collection<Player> onlinePlayers = (Collection<Player>) Bukkit.getServer().getOnlinePlayers();
                    for (Player online : onlinePlayers) {
                        online.spawnParticle(Particle.DUST_COLOR_TRANSITION, ent.getLocation().add(0, 0.1F, 0), 200, 8.0F, 0.1F, 8.01F, dt);
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Musis mat v inv lavu!");
                }
            }
            //p.spawnParticle(Particle.DUST_COLOR_TRANSITION, ent.getLocation().add(0, 0.1F, 0), 100, 5.0F, 0.1F, 5.01F, dt);
        }
    }
}
