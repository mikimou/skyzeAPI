package me.skyze.skyzeapi.listeners;

import me.skyze.skyzeapi.utility.DraciaKrvUtils;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import java.util.Random;
public class DraciaKrvListener implements Listener {

    @EventHandler
    public void onDragonDeath(EntityDeathEvent e) {
        if(e.getEntity() instanceof EnderDragon d){
            d.getKiller().getInventory().addItem(DraciaKrvUtils.createDraciaKrv());
            Random r = new Random();
            if (r.nextInt(100) < 40) {
                d.getKiller().getInventory().addItem(DraciaKrvUtils.createDraciaKrv());
            }
        }
    }
}
