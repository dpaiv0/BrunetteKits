package xyz.paiva.brunettekits;

import org.bukkit.plugin.Plugin;
import xyz.paiva.brunettekits.handler.KitHandler;
import xyz.paiva.brunettekits.kits.impl.KangarooKit;

public class KitLoader {

    private final Plugin plugin;

    public KitLoader(Plugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        KitHandler.getInstance().register(new KangarooKit());
    }

}
