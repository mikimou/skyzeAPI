package me.skyze.skyzeapi.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class FlameStickUtils {

    public static ItemStack createFlameStick() {

        ItemStack flameStick = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta flameStickMeta = flameStick.getItemMeta();
        flameStickMeta.setDisplayName(ChatColor.RED +""+ ChatColor.BOLD + "Paliva" + ChatColor.RESET +""+ChatColor.BOLD + " Palicka");
        flameStickMeta.setLore(List.of("Tato palicka ", "zapaluje mobov."));
        flameStickMeta.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
        flameStick.setItemMeta(flameStickMeta);

        return flameStick;
    }
}
