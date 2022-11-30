package me.skyze.skyzeapi.recipes;

import me.skyze.skyzeapi.SkyzeAPI;
import me.skyze.skyzeapi.utility.ActivatedEmeraldUtils;
import me.skyze.skyzeapi.utility.FlameStickUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ShapedRecipe;

public class ActivatedEmeraldRecipe {

    public static void initialize(SkyzeAPI pl) {

        NamespacedKey key = new NamespacedKey(pl, "activatedemerald");
        BlastingRecipe recipe = new BlastingRecipe(key, ActivatedEmeraldUtils.createActivatedEmerald(1), Material.EMERALD, 10.0f, 2500);
        Bukkit.addRecipe(recipe);


    }
}
