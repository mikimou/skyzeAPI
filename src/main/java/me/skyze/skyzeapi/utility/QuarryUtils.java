package me.skyze.skyzeapi.utility;

import me.skyze.skyzeapi.SkyzeAPI;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Random;

public class QuarryUtils {

    private int ID;
    private boolean running = false;
    private Location loc;

    public QuarryUtils(Location loc) {
        Random r = new Random();
        this.ID = r.nextInt((9999 - 1) + 1) + 1;

        this.loc = loc;

    }

    public int getID() { return this.ID; }

    public Location getLoc() { return this.loc; }

    public boolean getRunning() { return this.running; }

    public void setRunning(boolean set) { this.running = set; }
}
