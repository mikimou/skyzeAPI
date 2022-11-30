package me.skyze.skyzeapi.recipes;

import me.skyze.skyzeapi.SkyzeAPI;
import me.skyze.skyzeapi.utility.BowUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class TeleportBowRecipe {

    public static void initialize(SkyzeAPI pl) {
        NamespacedKey key = new NamespacedKey(pl, "teleportbow");
        ShapedRecipe recipe = new ShapedRecipe(key, BowUtils.createTeleportBow());
        recipe.shape(
                " S ",
                "SXS",
                " S ");
        recipe.setIngredient('X', Material.BOW);
        recipe.setIngredient('S', Material.EMERALD);
        Bukkit.addRecipe(recipe);
    }
}
