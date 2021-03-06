package com.tyzoid.jailr.events;

import com.tyzoid.jailr.api.JailAPI;
import com.tyzoid.jailr.util.Messenger;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * Class that implements event handlers that prevent interaction
 * from quarantined players.
 * 
 * @author Sushi
 */
public class InteractionListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (JailAPI.isQuarantined(player.getName())) {
            Messenger.sendNoPermissionError(player);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (JailAPI.isQuarantined(player.getName())) {
            Messenger.sendNoPermissionError(player);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (JailAPI.isQuarantined(player.getName())) {
            Messenger.sendNoPermissionError(player);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();

        if (JailAPI.isQuarantined(player.getName())) {
            Messenger.sendNoPermissionError(player);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType() == EntityType.PLAYER) {
            Player player = (Player) event.getEntity();

            if (JailAPI.isQuarantined(player.getName())) {
                Messenger.sendNoPermissionError(player);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        HumanEntity humanEntity = event.getPlayer();

        if (humanEntity.getType() == EntityType.PLAYER) {
            Player player = (Player) event.getPlayer();

            if (JailAPI.isQuarantined(player.getName())) {
                Messenger.sendNoPermissionError(player);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (JailAPI.isQuarantined(player.getName())) {
            Messenger.sendNoPermissionError(player);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onShootBow(EntityShootBowEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType() == EntityType.PLAYER) {
            Player player = (Player) event.getEntity();

            if (JailAPI.isQuarantined(player.getName())) {
                Messenger.sendNoPermissionError(player);
                event.setCancelled(true);
            }
        }
    }
}
