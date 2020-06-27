package xyz.paiva.brunettekits.utils.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import xyz.paiva.brunettekits.prototypes.impl.InventoryItem;
import xyz.paiva.brunettekits.utils.inventory.InventoryHelper;

import java.util.ArrayList;
import java.util.List;

public class ThreeItemGui {
    public List<InventoryItem> items = new ArrayList<>();
    public Player player;
    public String title;

    public ThreeItemGui(Player player) {
        this.player = player;
    }

    public ThreeItemGui addItem(InventoryItem item) {
        items.add(item);
        return this.get();
    }

    public ThreeItemGui setTitle(String title) {
        this.title = title;
        return this.get();
    }

    public void build() {
        InventoryHelper inventory = new InventoryHelper(27, this.title);

        for (int i = 0; i <= 8; i++) {
            inventory.addItem(new InventoryItem("", 1, i, Material.BLACK_STAINED_GLASS_PANE, ""));
        }

        for (int i = 9; i <= 11; i++) {
            inventory.addItem(new InventoryItem("", 1, i, Material.WHITE_STAINED_GLASS_PANE, ""));
        }

        // Positions 12, 13 and 14, respectively.
        for (InventoryItem item : items) {
            inventory.addItem(item);
        }

        for (int i = 15; i <= 17; i++) {
            inventory.addItem(new InventoryItem("", 1, i, Material.WHITE_STAINED_GLASS_PANE, ""));
        }

        for (int i = 18; i <= 26; i++) {
            inventory.addItem(new InventoryItem("", 1, i, Material.BLACK_STAINED_GLASS_PANE, ""));
        }

        inventory.openInventory(player);
    }

    public ThreeItemGui get() {
        return this;
    }
}
