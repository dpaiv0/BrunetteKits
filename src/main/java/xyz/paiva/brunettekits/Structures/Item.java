package xyz.paiva.brunettekits.Structures;

import org.bukkit.Material;

public class Item {
    private final String name;
    private final Integer amount;
    private final Integer slot;
    private final Material type;
    private final String[] lore;

    public Item(String name, Integer amount, Integer slot, Material type, String... lore) {
        this.name = name;
        this.amount = amount;
        this.slot = slot;
        this.type = type;
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getSlot() {
        return slot;
    }

    public Material getType() {
        return type;
    }

    public String[] getLore() {
        return lore;
    }
}
