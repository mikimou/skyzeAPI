package me.skyze.skyzeapi.commands;

import me.skyze.skyzeapi.utility.ActivatedEmeraldUtils;
import me.skyze.skyzeapi.utility.BowUtils;
import me.skyze.skyzeapi.utility.DraciaKrvUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DavajCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player p) {
            if (p.hasPermission("skyzeapi.admin")) {
                if (args.length == 0) {
                    p.sendMessage("/davaj tpbow");
                    p.sendMessage("/davaj aktivovany_emerald <pocet>");
                    p.sendMessage("/davaj dracia_krv");
                } else if (args.length > 0) {

                    if (args[0].equalsIgnoreCase("aktivovany_emerald")) {

                        try {
                            if(Integer.parseInt(args[1]) >= 1) {
                                ItemStack i = ActivatedEmeraldUtils.createActivatedEmerald(Integer.parseInt(args[1]));
                                p.getInventory().addItem(i);
                                p.sendMessage("Givol si si aktivovany_emerald "+args[1]+"x");
                            }
                        }
                        catch(Exception e) {
                            ItemStack i = ActivatedEmeraldUtils.createActivatedEmerald(1);
                            p.getInventory().addItem(i);
                            p.sendMessage("Givol si si aktivovany_emerald 1x");
                        }

                    } else if (args[0].equalsIgnoreCase("tpbow")) {
                        ItemStack i = BowUtils.createTeleportBow();
                        p.getInventory().addItem(i);
                    } else if (args[0].equalsIgnoreCase("dracia_krv")) {
                        ItemStack i = DraciaKrvUtils.createDraciaKrv();
                        p.getInventory().addItem(i);
                        p.sendMessage("Givol si si draciu_krv 1x");
                    }


                } else {p.sendMessage("error");}
            } else {
                p.sendMessage(ChatColor.RED+ "Nemas povolenie na tento command!");
            }
        }
        return true;
    }
}
