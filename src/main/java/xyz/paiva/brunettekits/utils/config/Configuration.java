package xyz.paiva.brunettekits.utils.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import xyz.paiva.brunettekits.BrunetteKits;

import java.io.File;
import java.io.IOException;

import static org.bukkit.Bukkit.*;

public class Configuration {

    public static Configuration MainConfig;

    private final File file;
    private final FileConfiguration config;

    public Configuration(String fileName) {
        // Let's first create the plugin folder, if inexistent.
        if (!BrunetteKits.getInstance().getDataFolder().exists()) {
            try {
                boolean dirCreated = BrunetteKits.getInstance().getDataFolder().mkdir();
                if (!dirCreated) {
                    getLogger().severe("Unable to create the data folder for the plugin.");
                    getLogger().severe("Please, create a data folder with the plugin's name and restart the server.");
                    getPluginManager().disablePlugin(BrunetteKits.getInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // And now, the configuration file.
        file = new File(BrunetteKits.getInstance().getDataFolder(), fileName + ".yml");

        // Let's verify that it exists, and can be writable to disk.
        if (file.exists()) {
            try {
                boolean fileCreated = file.createNewFile();
                if (!fileCreated) {
                    getLogger().warning(fileName + ".yml already exists in the plugin's data folder, won't override current data.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public <Type> Type get(String path) {
        return (Type) config.get(path).getClass();
    }

    public void set(String path, java.io.Serializable value) {
        config.set(path, value);
        save();
    }

    public boolean contains(String path) {
        return config.contains(path);
    }

    public ConfigurationSection createSection(String path) {
        ConfigurationSection section = config.createSection(path);
        save();
        return section;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
