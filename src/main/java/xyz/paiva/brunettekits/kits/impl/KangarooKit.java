package xyz.paiva.brunettekits.kits.impl;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import xyz.paiva.brunettekits.kits.Kit;
import xyz.paiva.brunettekits.kits.KitItem;
import xyz.paiva.brunettekits.prototypes.impl.KitPlayer;

public class KangarooKit implements Kit {

    @Override
    public String getName() {
        return "Anchor";
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(Material.ANVIL);
    }

    @Override
    public KitItem getItem() {
        return new KitItem(new ItemStack(Material.FIREWORK_ROCKET));
    }

    @Override
    public void handle(KitPlayer player) {
        Player minecraftPlayer = player.getBukkitPlayer();

        final Vector vector = minecraftPlayer.getEyeLocation().getDirection();
        vector.multiply(1.2F);
        vector.setY(0.8);
        minecraftPlayer.setVelocity(vector);
    }

}
