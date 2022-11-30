package me.skyze.skyzeapi.commands;

import me.skyze.skyzeapi.SkyzeAPI;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class GrgCommand implements CommandExecutor {

    private final HashMap<UUID, Long> cooldown;
    long cakat = 20000; // ms !
    static SkyzeAPI pl = SkyzeAPI.getPlugin();
    private Collection<Player> nearPlayers;

    public GrgCommand() {
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        if (sender instanceof Player p) {
//            if (!this.cooldown.containsKey(p.getUniqueId()) || System.currentTimeMillis() - this.cooldown.get(p.getUniqueId()) >= this.cakat) {
//
//                this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());
//
//                this.nearPlayers = p.getLocation().getNearbyPlayers(5);
//                for (Player nearPlayer : this.nearPlayers) {
//                    nearPlayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 150, 10));
//                }
//                p.setFoodLevel(p.getFoodLevel()-4);
//                p.sendMessage(ChatColor.YELLOW+"Poriadny grg bol!");
//                pl.getServer().broadcastMessage(ChatColor.YELLOW + "" +ChatColor.BOLD+p.getName()+" ogrgol typka");
//
//            } else {
//                p.sendMessage("Musis pockat kym sa ti bude chcet!");
//            }

            if (p.getFoodLevel() == 20) {

                this.nearPlayers = p.getLocation().getNearbyPlayers(5);
                for (Player nearPlayer : this.nearPlayers) {
                    nearPlayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 150, 10));
                }
                p.setFoodLevel(p.getFoodLevel()-4);
                p.sendMessage(ChatColor.YELLOW+"Poriadny grg bol!");
                pl.getServer().broadcastMessage(ChatColor.YELLOW + "" +ChatColor.BOLD+p.getName()+" ogrgol typka");

            } else {
                p.sendMessage("Musis byt poriadne najedeny!");
            }

        }

        return true;
    }
}
