package me.skyze.skyzeapi.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ActivatedEmeraldUtils {

    public static ItemStack createActivatedEmerald(int pocet) {

        ItemStack activatedEmerald = new ItemStack(Material.EMERALD, pocet);
        ItemMeta activatedEmeraldMeta = activatedEmerald.getItemMeta();
        activatedEmeraldMeta.setDisplayName(ChatColor.DARK_GREEN +""+ChatColor.BOLD + "Aktivovany Emerald");
        activatedEmeraldMeta.setLore(List.of("Dokaze neuveritelne veci! ", ""));
        activatedEmeraldMeta.addEnchant(Enchantment.LUCK, 1, true);
        activatedEmerald.setItemMeta(activatedEmeraldMeta);

        return activatedEmerald;
    }
}
