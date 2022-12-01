package me.skyze.skyzeapi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("");
        p.sendMessage(ChatColor.YELLOW+""+ChatColor.ITALIC+"  skyzeAPI prirucka: "+ ChatColor.RED+""+ChatColor.BOLD+"/prirucka");
        p.sendMessage("");

        if (p.hasPermission("skyzeapi.admin")) {
            p.sendMessage(ChatColor.YELLOW+"skyzeAPI"+ ChatColor.RED+" ADMIN/OP: "+ChatColor.GREEN+" YES");
            p.sendMessage(ChatColor.GOLD+"skyzeAPI admin permissions granted!");
            p.sendMessage(ChatColor.YELLOW+""+ChatColor.ITALIC+"  skyzeAPI ADMIN prirucka: "+ ChatColor.RED+""+ChatColor.BOLD+"/prirucka admin");
            p.sendMessage(ChatColor.DARK_AQUA+""+ChatColor.BOLD+"Online admini:");
            for (Player pp : Bukkit.getServer().getOnlinePlayers()) {
                if (pp.hasPermission("skyzeapi.admin")) {
                    p.sendMessage(ChatColor.DARK_AQUA+pp.getName());
                }
            }
        }
    }
}
