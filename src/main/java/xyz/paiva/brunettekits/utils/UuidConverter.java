package xyz.paiva.brunettekits.utils;

import org.bukkit.OfflinePlayer;

import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class UuidConverter {

    public static UUID convert(String playerName) {
        // Since we can get *any* player, we have to get an OfflinePlayer object, instead of a Player object.
        // But since 2015, Mojang has implemented username changes, so we need to use UUIDs.
        // https://www.spigotmc.org/threads/why-is-getofflineplayer-string-deprecated.277895/
        // (and this also makes possible for offline mode servers to use this plugin)
        UUID targetUuid = null;

        OfflinePlayer[] offlinePlayers = getServer().getOfflinePlayers();
        int i = 0;
        while ((i < offlinePlayers.length) && (targetUuid == null)) {
            if (playerName.equalsIgnoreCase(offlinePlayers[i].getName())) {
                targetUuid = offlinePlayers[i].getUniqueId();
            }
            i++;
        }

        return targetUuid;
    }
}
