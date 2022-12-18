package me.skyze.skyzeapi.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class VianoceCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player p) {
            //if (p.hasPermission("skyzeapi.vianoce")) {
            if (p.getName().equalsIgnoreCase("misko_22")||p.getName().equalsIgnoreCase("KingDiri")) {
                gui(p);
            } else {
                p.sendMessage(ChatColor.RED + "Vianocne prikazy budu dostupne az na vianoce!");
            }
        }
        return true;
    }

    public void gui(Player p) {
        Inventory gui = Bukkit.createInventory(p, 9, "Vianocne menu");
        ItemStack sapling = new ItemStack(Material.SPRUCE_SAPLING, 1);
        ItemMeta saplingMeta = sapling.getItemMeta();
        saplingMeta.setDisplayName(ChatColor.GREEN+ "Teleport ku Vianocnemu stromceku");
        sapling.setItemMeta(saplingMeta);

        ItemStack chest = new ItemStack(Material.CHEST, 1);
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.setDisplayName(ChatColor.RED+ "Vytvor darcek!");
        chest.setItemMeta(chestMeta);

        gui.addItem(sapling);
        gui.addItem(chest);
        p.openInventory(gui);
    }
}
