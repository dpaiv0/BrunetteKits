package xyz.paiva.brunettekits.utils.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.paiva.brunettekits.prototypes.impl.InventoryItem;

import java.util.Arrays;

public class InventoryHelper implements InventoryHolder, Listener {
    private final Inventory inventory;

    public InventoryHelper(Integer slots, String name) {
        inventory = Bukkit.createInventory(this, slots, name);
    }

    public void addItem(InventoryItem item) {
        // Required Parameters: Name, Amount, Slot, Item, Lore...
        inventory.setItem(item.getSlot(), createGuiItem(item.getName(), item.getAmount(), item.getType(), item.getLore()));
    }

    protected ItemStack createGuiItem(String name, Integer amount, Material type, String... lore) {
        final ItemStack item = new ItemStack(type, amount);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        assert meta != null;
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        player.sendMessage("onInventoryClick event has fired!");
        e.setCancelled(true);
        player.sendMessage("bruh sound effect #2");

        /*getLogger().info(String.valueOf(e.getRawSlot()));
        if (e.getInventory().getHolder() != this) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        p.sendMessage("You clicked at slot " + e.getRawSlot());*/
    }
}
