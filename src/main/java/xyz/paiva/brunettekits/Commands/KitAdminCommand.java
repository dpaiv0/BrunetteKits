package xyz.paiva.brunettekits.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.paiva.brunettekits.Utils.InventoryHelper;
import xyz.paiva.brunettekits.Structures.Item;

public class KitAdminCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command needs to be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        InventoryHelper inventory = new InventoryHelper(27, "§6§lBrunetteKits Admin GUI");
        for (int i = 0; i <= 8; i++) {
            inventory.addItem(new Item("", 1, i, Material.BLACK_STAINED_GLASS_PANE, ""));
        }

        for (int i = 9; i <= 11; i++) {
            inventory.addItem(new Item("", 1, i, Material.WHITE_STAINED_GLASS_PANE, ""));
        }

        // Positions 12, 13 and 14, respectively.
        inventory.addItem(new Item("§6§lCreate a Kit", 1, 12, Material.NAME_TAG, ""));
        inventory.addItem(new Item("§6§lEdit a Kit", 1, 13, Material.NAME_TAG, ""));
        inventory.addItem(new Item("§6§lDelete a Kit", 1, 14, Material.NAME_TAG, ""));

        for (int i = 15; i <= 17; i++) {
            inventory.addItem(new Item("", 1, i, Material.WHITE_STAINED_GLASS_PANE, ""));
        }

        for (int i = 18; i <= 25; i++) {
            inventory.addItem(new Item("", 1, i, Material.BLACK_STAINED_GLASS_PANE, ""));
        }

        // Position 27
        inventory.addItem(new Item("§6§lPlugin Information", 1, 26, Material.DIAMOND, ""));

        inventory.openInventory(player);

        return true;
    }
}
