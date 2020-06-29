package xyz.paiva.brunettekits.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.paiva.brunettekits.handler.AccountHandler;
import xyz.paiva.brunettekits.prototypes.impl.Account;

public class RegisterListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (AccountHandler.getInstance().retrieve(event.getPlayer().getUniqueId()) == null) {
            AccountHandler.getInstance().register(new Account(event.getPlayer().getUniqueId()));
        }
    }

}
