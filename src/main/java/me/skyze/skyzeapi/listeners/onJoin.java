package me.skyze.skyzeapi.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.YELLOW+""+ChatColor.BOLD+"  SkyzeAPI prirucka: "+ ChatColor.RED+""+ChatColor.BOLD+"/prirucka");
    }
}
