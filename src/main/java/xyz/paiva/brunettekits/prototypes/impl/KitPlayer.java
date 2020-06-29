package xyz.paiva.brunettekits.prototypes.impl;

import org.bukkit.entity.Player;
import xyz.paiva.brunettekits.handler.AccountHandler;
import xyz.paiva.brunettekits.kits.Kit;
import xyz.paiva.brunettekits.prototypes.Prototype;

public class KitPlayer implements Prototype {

    private final Player player;
    private Kit kit;

    public KitPlayer(Player player, Kit kit) {
        this.player = player;
        this.kit = kit;
    }

    public Account getAccount() {
        return AccountHandler.getInstance().retrieve(getBukkitPlayer().getUniqueId());
    }

    public Player getBukkitPlayer() {
        return player;
    }

    public Kit getKit() {
        return kit;
    }
}
