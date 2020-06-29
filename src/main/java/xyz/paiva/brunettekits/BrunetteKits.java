package xyz.paiva.brunettekits;

import org.bukkit.plugin.java.JavaPlugin;

import xyz.paiva.brunettekits.commands.KitAdminCommand;
import xyz.paiva.brunettekits.listeners.ExecutorListener;
import xyz.paiva.brunettekits.listeners.RegisterListener;
import xyz.paiva.brunettekits.utils.config.Configuration;
import xyz.paiva.brunettekits.utils.inventory.InventoryHelper;

import java.util.Objects;


public final class BrunetteKits extends JavaPlugin {

    @Override
    public void onEnable() {
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
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        getLogger().info("Registering listeners...");
        getServer().getPluginManager().registerEvents(new InventoryHelper(9, ""), this);
        getServer().getPluginManager().registerEvents(new ExecutorListener(), this);
        getServer().getPluginManager().registerEvents(new RegisterListener(), this);

        getLogger().info("Loading kits...");
        new KitLoader(this).load();

        getLogger().info("BrunetteKits has been loaded successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BrunetteKits has been unloaded successfully!");
    }

    public static BrunetteKits getInstance() {
        return getPlugin(BrunetteKits.class);
    }
}
