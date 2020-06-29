package xyz.paiva.brunettekits.handler;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.bukkit.entity.Player;
import xyz.paiva.brunettekits.prototypes.impl.KitPlayer;

import java.util.HashMap;
import java.util.Map;

public class KitPlayerHandler {

    private static KitPlayerHandler instance;

    public static KitPlayerHandler getInstance() {
        if (instance == null) {
            instance = new KitPlayerHandler();
        }
        return instance;
    }

    private final Map<Player, KitPlayer> repository = new HashMap<>();

    public void register(KitPlayer player) {
        repository.put(player.getBukkitPlayer(), player);
    }

    @Nullable
    public KitPlayer retrieve(@NotNull Player player) {
        return repository.get(player);
    }

    private KitPlayerHandler() {}

}
