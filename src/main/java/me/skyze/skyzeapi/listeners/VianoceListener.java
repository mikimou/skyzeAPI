package me.skyze.skyzeapi.listeners;

import me.skyze.skyzeapi.SkyzeAPI;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class VianoceListener implements Listener {

    private Random r = new Random();

//    @EventHandler
//    public void onSnowballThrow(EntityDamageByEntityEvent e){
//
//        if (e.getEntity() instanceof Player damaged) {
//            if (e.getDamager().getType() == EntityType.SNOWBALL) {
//                    damaged.setHealth(damaged.getHealth() - 2);
//                    HumanEntity damager = (HumanEntity) e.getDamager();
//                    damager.setHealth(damager.getHealth()-2);
//            }
//        }
//    }

    @EventHandler
    public void onSwapHands(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();
        ItemStack item = new ItemStack(Material.GUNPOWDER, 1);

        if (p.getInventory().getItemInMainHand().getType() == Material.GUNPOWDER) {

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SkyzeAPI.getPlugin(), () -> p.getInventory().removeItemAnySlot(item), 4);

            //p.getInventory().removeItemAnySlot(item);
            Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
            FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
            data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.GREEN).with(FireworkEffect.Type.BALL_LARGE).withFlicker().build());
            data.setPower(1);
            firework.setFireworkMeta(data);
            //firework.detonate();
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().contains(Material.GUNPOWDER)) {
            if (r.nextInt(1000) < 2) {
                Firework firework = p.getWorld().spawn(p.getLocation(), Firework.class);
                FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.GREEN).with(FireworkEffect.Type.BALL_LARGE).withFlicker().build());
                data.setPower(1);
                firework.setFireworkMeta(data);
            }
        }
    }

    @EventHandler
    public void onVianoceMenuClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player p) {
            if (e.getView().getTitle().equalsIgnoreCase("Vianocne menu")){
                e.setCancelled(true);
                if (e.getCurrentItem() == null){
                    return;
                }else if (e.getCurrentItem().getType().equals(Material.SPRUCE_SAPLING)) {
                    p.sendMessage("Bol si teleportovany ku stromceku!");
                    Location loc = new Location(Bukkit.getWorlds().get(0), -2448, 66, 158);
                    p.teleport(loc);
                    p.closeInventory();
                } else if (e.getCurrentItem().getType().equals(Material.CHEST)) {
                    p.sendMessage("/darcek <menohraca> <sprava>");
                    p.closeInventory();
                }
            }

        }
    }
}
