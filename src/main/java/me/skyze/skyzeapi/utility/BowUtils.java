package me.skyze.skyzeapi.utility;

import me.skyze.skyzeapi.SkyzeAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

// Create and provide teleport bows
public class BowUtils {

    public static ItemStack createTeleportBow() {
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Mikiho Teleport Bow");
        List<String> lore = new ArrayList<>();
        lore.add("Vystrel a portnes");
        lore.add("sa kam dopadne sip.");
        lore.add("-1 Lvl za teleport");
        bowMeta.setLore(lore);

        bowMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
        bow.setItemMeta(bowMeta);

        return bow;
    }
}
