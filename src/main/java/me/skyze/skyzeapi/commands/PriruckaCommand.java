package me.skyze.skyzeapi.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PriruckaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player p) {
            if (args.length == 0 || args[0].equalsIgnoreCase("1")) {
                prirucka(1, p);
            } else if (args[0].equalsIgnoreCase("2")) {
                //
            } else if (args[0].equalsIgnoreCase("admin")) {
                p.sendMessage(ChatColor.DARK_GRAY + "----------------------------------------"); // 20x -
                p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "    ADMIN PRIRUCKA skyzeAPI str. 1/1");
                p.sendMessage("");
                p.sendMessage(ChatColor.DARK_AQUA+""+ChatColor.BOLD+"/davaj <custom_item> <pocet>" +ChatColor.GOLD+""+ChatColor.ITALIC+"  Givne item zo skyzeAPI");
                p.sendMessage("");
                p.sendMessage(ChatColor.DARK_GRAY + "----------------------------------------"); // 20x -
            }
        }
        return true;
    }

    public void prirucka(int strana, Player p) {
        if (strana==1) {
            p.sendMessage(ChatColor.DARK_GRAY + "----------------------------------------"); // 20x -
            p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "    PRIRUCKA skyzeAPI str. 1/1");
            p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC + "/prirucka cislostrany");
            p.sendMessage("");
            //p.sendMessage(ChatColor.DARK_AQUA+""+ChatColor.BOLD+"/vianoce" +ChatColor.GOLD+""+ChatColor.ITALIC+"  Portne ta k vianocnemu stromceku");
            p.sendMessage(ChatColor.DARK_AQUA+""+ChatColor.BOLD+"/grg" +ChatColor.GOLD+""+ChatColor.ITALIC+"  Ogrgne typkov v okoli");
            p.sendMessage("");
            p.sendMessage(ChatColor.RED + "Vianocne prikazy dostupne az na vianoce!");
            p.sendMessage("");
            p.sendMessage(ChatColor.DARK_GREEN+"Crafting recepty specialnych");
            p.sendMessage(ChatColor.DARK_GREEN+"itemov a viac na: "+ChatColor.RESET+"http://magyarorszag.ga");
            p.sendMessage(ChatColor.DARK_GRAY + "----------------------------------------"); // 20x -
        }
    }
}
