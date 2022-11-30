package me.skyze.skyzeapi.recipes;

import me.skyze.skyzeapi.SkyzeAPI;
import me.skyze.skyzeapi.utility.FlameStickUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class FlameStickRecipe {

    public static void initialize(SkyzeAPI pl) {
        NamespacedKey key = new NamespacedKey(pl, "flamestick");
        ShapedRecipe recipe = new ShapedRecipe(key, FlameStickUtils.createFlameStick());
        recipe.shape(
                "CSC",
                "SXS",
                "CSC");
        recipe.setIngredient('X', Material.BLAZE_ROD);
        recipe.setIngredient('S', Material.NETHERITE_INGOT);
        recipe.setIngredient('C', Material.GOLD_BLOCK);
        Bukkit.addRecipe(recipe);
    }
}
