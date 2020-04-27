package xyz.paiva.brunettekits.Utils.Gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import xyz.paiva.brunettekits.Structures.Item;
import xyz.paiva.brunettekits.Utils.InventoryHelper;

import java.util.ArrayList;
import java.util.List;

public class ThreeItemGui {
    public List<Item> items = new ArrayList<Item>();
    public Player player;
    public String title;

    public ThreeItemGui(Player player) {
        this.player = player;
    }

    public ThreeItemGui addItem(Item item) {
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
            inventory.addItem(new Item("", 1, i, Material.BLACK_STAINED_GLASS_PANE, ""));
        }

        for (int i = 9; i <= 11; i++) {
            inventory.addItem(new Item("", 1, i, Material.WHITE_STAINED_GLASS_PANE, ""));
        }

        // Positions 12, 13 and 14, respectively.
        for (Item item : items) {
            inventory.addItem(item);
        }

        for (int i = 15; i <= 17; i++) {
            inventory.addItem(new Item("", 1, i, Material.WHITE_STAINED_GLASS_PANE, ""));
        }

        for (int i = 18; i <= 26; i++) {
            inventory.addItem(new Item("", 1, i, Material.BLACK_STAINED_GLASS_PANE, ""));
        }

        inventory.openInventory(player);
    }

    public ThreeItemGui get() {
        return this;
    }
}
