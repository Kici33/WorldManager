package pl.in3time.worldmanager.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.in3time.worldmanager.world.instance.WorldInstance;

import java.util.function.Consumer;


public class BukkitUtils {

    public static void teleportPlayerWithDelay(Player player, Location location, Plugin plugin) {
        teleportPlayerWithDelay(player, location, plugin, null);

    }

    public static void teleportPlayerWithDelay(Player player, Location location, Plugin plugin, Consumer<Boolean> callBack) {
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            boolean success = player.teleport(location);
            if (callBack != null) callBack.accept(success);
        }, 20);
    }


    public static void unloadWorldInstanceLater(WorldInstance worldInstance, Player player, long delay, Plugin plugin) {
        unloadWorldInstanceLater(worldInstance, player, delay, plugin, null);
    }

    public static void unloadWorldInstanceLater(WorldInstance worldInstance, Player player, long delay, Plugin plugin, Consumer<Boolean> callBack) {
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            boolean success = false;
            if (!player.isOnline())
                success = worldInstance.unload();
            if (callBack != null)
                callBack.accept(success);
        }, delay);
    }
}
