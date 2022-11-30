package me.skyze.skyzeapi.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        //e.getPlayer().setResourcePack("https://www.curseforge.com/minecraft/texture-packs/new-default-style-christmas-pack/download/4075071/file");
    }
}
