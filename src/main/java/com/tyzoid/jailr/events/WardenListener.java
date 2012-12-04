package com.tyzoid.jailr.events;

import com.tyzoid.jailr.api.JailAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Class that implements event handlers that prevent prisoners
 * from escaping jail.
 *
 * @author Sushi
 */
public class WardenListener implements Listener {
    @EventHandler
    public void onSpawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (JailAPI.isJailed(player.getName())) {
        	if(JailAPI.isJailPointSet()) {
        		player.teleport(JailAPI.getJailPoint());
        	}
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (JailAPI.isJailed(player.getName())) {
        	if(JailAPI.isJailPointSet()) {
        		player.teleport(JailAPI.getJailPoint());
        	}
        }
    }
}
