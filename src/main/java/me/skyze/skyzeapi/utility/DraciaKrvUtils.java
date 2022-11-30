package me.skyze.skyzeapi.utility;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class DraciaKrvUtils {

    public static ItemStack createDraciaKrv() {

        ItemStack draciaKrv = new ItemStack(Material.LINGERING_POTION);
        ItemMeta draciaKrvMeta = draciaKrv.getItemMeta();
        draciaKrvMeta.setDisplayName(ChatColor.BOLD+"Dracia"+ChatColor.DARK_RED +""+ChatColor.BOLD + " Krv");
        draciaKrvMeta.setLore(List.of("Krv z Ender draka", ""));
        draciaKrvMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        draciaKrv.setItemMeta(draciaKrvMeta);

        return draciaKrv;
    }
}
