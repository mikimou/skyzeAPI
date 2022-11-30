package me.skyze.skyzeapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class VianoceThrowListener implements Listener {

    @EventHandler
    public void onSnowballThrow(ProjectileLaunchEvent e){

        if (e.getEntity() instanceof Snowball s) {
            if (s.getShooter() instanceof Player p) {
                if (s.getNearbyEntities(1,1,1) instanceof Player pp) {
                    pp.setHealth(pp.getHealth()-2);
                }
            }

        }

    }
}
