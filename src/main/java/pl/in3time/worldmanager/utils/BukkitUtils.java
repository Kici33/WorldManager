package pl.in3time.worldmanager.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.in3time.worldmanager.world.instance.WorldInstance;

import java.util.function.Consumer;


public class BukkitUtils {

    public static void teleportPlayerWithDelay(Player player, Location location, Plugin plugin, Consumer<Boolean> callBack) {
        Bukkit.getScheduler().runTaskLater(plugin, () -> callBack.accept(player.teleport(location)), 20);
    }

    public static void teleportPlayerWithDelay(Player player, Location location, Plugin plugin) {
        Bukkit.getScheduler().runTaskLater(plugin, () -> player.teleport(location), 20);
    }

    public static void unloadWorldIstanceLater(WorldInstance worldInstance, long delay, Plugin plugin) {
        Bukkit.getScheduler().runTaskLater(plugin, worldInstance::unload, delay);
    }
}
