package me.skyze.skyzeapi;

import me.skyze.skyzeapi.commands.DavajCommand;
import me.skyze.skyzeapi.commands.GrgCommand;
import me.skyze.skyzeapi.commands.PriruckaCommand;
import me.skyze.skyzeapi.commands.VianoceCommand;
import me.skyze.skyzeapi.listeners.*;
import me.skyze.skyzeapi.recipes.ActivatedEmeraldRecipe;
import me.skyze.skyzeapi.recipes.FlameStickRecipe;
import me.skyze.skyzeapi.recipes.TeleportBowRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyzeAPI extends JavaPlugin {

    private static SkyzeAPI plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getLogger().info("Inicializuje sa skyzeAPI");
        //getServer().broadcastMessage(ChatColor.YELLOW+"Inicializuje sa skyzeAPI");

        // Commands
        getCommand("grg").setExecutor(new GrgCommand());
        getCommand("davaj").setExecutor(new DavajCommand());
        getCommand("vianoce").setExecutor(new VianoceCommand()); // Vianocne
        getCommand("prirucka").setExecutor(new PriruckaCommand()); // PRIRUCKA

        // Listeners
        getServer().getPluginManager().registerEvents(new TeleportBowListener(), this);
        getServer().getPluginManager().registerEvents(new FlameStickListener(), this);
        getServer().getPluginManager().registerEvents(new CustomTreesListener(), this);
        getServer().getPluginManager().registerEvents(new DraciaKrvListener(), this);
        getServer().getPluginManager().registerEvents(new VianoceListener(), this); // Vianoce
        getServer().getPluginManager().registerEvents(new onJoin(), this);

        //getServer().getPluginManager().registerEvents(new onJoin(), this);

        // Recipes
        TeleportBowRecipe.initialize(this);
        FlameStickRecipe.initialize(this);
        ActivatedEmeraldRecipe.initialize(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SkyzeAPI getPlugin() {
        return plugin;
    }
}
