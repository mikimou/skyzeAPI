package me.skyze.skyzeapi.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VianoceCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player p) {
            //if (p.hasPermission("skyzeapi.vianoce")) {
            if (p.getName().equalsIgnoreCase("misko_22")||p.getName().equalsIgnoreCase("KingDiri")) {
                if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                    p.sendMessage(ChatColor.DARK_GRAY + "----------------------------------------"); // 20x -
                    p.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "    VIANOCNE PRIKAZY");
                    p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC + "/vianoce help"+ ChatColor.BLUE+"    Ukaze vsetky prikazy");
                    p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC + "/vianoce tp"+ ChatColor.BLUE+"    Teleportne ta ku stromceku");
                    p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC + "/darcek menohraca sprava"+ ChatColor.BLUE+"    Vytvori darcek");
                    p.sendMessage(ChatColor.DARK_GRAY + "----------------------------------------"); // 20x -
                } else if (args[0].equalsIgnoreCase("tp")) {
                    Location loc = new Location(Bukkit.getWorlds().get(0), -2448, 66, 158);
                    p.teleport(loc);
                }
            } else {
                p.sendMessage(ChatColor.RED + "Vianocne prikazy budu dostupne az na vianoce!");
            }
        }
        return true;
    }
}
