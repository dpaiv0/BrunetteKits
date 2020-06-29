package xyz.paiva.brunettekits.kits;

import org.bukkit.inventory.ItemStack;

public class KitItem {

    private ItemStack item;

    public KitItem(ItemStack item) {
        this.item = item;
    }

    public ItemStack getMinecraftItem() {
        return item;
    }
}
