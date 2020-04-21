package xyz.paiva.brunettekits;

import com.sun.org.apache.xpath.internal.objects.XObject;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.paiva.brunettekits.Commands.KitAdminCommand;
import xyz.paiva.brunettekits.Utils.Configuration;
import xyz.paiva.brunettekits.Utils.InventoryHelper;

import java.util.Objects;


public final class BrunetteKits extends JavaPlugin {

    private static BrunetteKits plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getLogger().info("Initializing main config...");
        try {
            Configuration.MainConfig = new Configuration("config");
            getLogger().info("Config loaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        getLogger().info("Initializing commands...");
        try {
            Objects.requireNonNull(this.getCommand("kitadmin")).setExecutor(new KitAdminCommand());
            getLogger().info("Commands have been loaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        getLogger().info("Registering events...");
        try {
            getServer().getPluginManager().registerEvents(new InventoryHelper(9, ""), this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getLogger().info("BrunetteKits has been loaded successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BrunetteKits has been unloaded successfully!");
    }

    public static BrunetteKits getPlugin() {
        return plugin;
    }
}
