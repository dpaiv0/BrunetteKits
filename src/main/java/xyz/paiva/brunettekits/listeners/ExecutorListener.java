package xyz.paiva.brunettekits.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.paiva.brunettekits.handler.KitPlayerHandler;
import xyz.paiva.brunettekits.prototypes.impl.KitPlayer;

public class ExecutorListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        KitPlayer player = KitPlayerHandler.getInstance().retrieve(event.getPlayer());
        if (player == null) return;

        if (event.getItem() == player.getKit().getItem().getMinecraftItem()) {
            player.getKit().handle(player);
        }
    }

}
