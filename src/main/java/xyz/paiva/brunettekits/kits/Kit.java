package xyz.paiva.brunettekits.kits;

import com.sun.istack.internal.Nullable;
import org.bukkit.inventory.ItemStack;
import xyz.paiva.brunettekits.handler.KitHandler;
import xyz.paiva.brunettekits.prototypes.impl.KitPlayer;

public interface Kit {

    KitHandler handler = KitHandler.getInstance();

    String getName();

    @Nullable
    ItemStack getIcon();

    KitItem getItem();

    void handle(KitPlayer player);

}
