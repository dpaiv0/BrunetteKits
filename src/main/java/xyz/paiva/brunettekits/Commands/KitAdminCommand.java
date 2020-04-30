package xyz.paiva.brunettekits.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.paiva.brunettekits.Utils.Gui.ThreeItemGui;
import xyz.paiva.brunettekits.Utils.InventoryHelper;
import xyz.paiva.brunettekits.Structures.Item;

public class KitAdminCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command needs to be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        ThreeItemGui gui = new ThreeItemGui(player);
		
		gui.setTitle("§6§lBrunetteKits Admin GUI")
                .addItem(new Item("§6§lCreate a Kit", 1, 12, Material.NAME_TAG, ""))
                .addItem(new Item("§6§lEdit a Kit", 1, 13, Material.NAME_TAG, ""))
                .addItem(new Item("§6§lDelete a Kit", 1, 14, Material.NAME_TAG, ""))
                .build();

        return true;
    }
}
