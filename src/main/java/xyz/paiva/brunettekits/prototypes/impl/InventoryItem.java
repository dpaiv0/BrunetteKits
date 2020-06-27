package xyz.paiva.brunettekits.prototypes.impl;

import org.bukkit.Material;

public class InventoryItem {

    private final String name;
    private final Integer amount;
    private final Integer slot;
    private final Material type;
    private final String[] lore;

    public InventoryItem(String name, Integer amount, Integer slot, Material type, String... lore) {
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