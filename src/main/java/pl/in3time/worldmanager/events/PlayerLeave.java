package pl.in3time.worldmanager.events;

import com.google.inject.Inject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.in3time.worldmanager.WorldManagerPlugin;
import pl.in3time.worldmanager.utils.BukkitUtils;
import pl.in3time.worldmanager.world.instance.WorldInstance;
import pl.in3time.worldmanager.world.instance.WorldInstanceFactory;


public class PlayerLeave implements Listener {
    private WorldInstanceFactory worldInstanceFactory;
    private WorldManagerPlugin plugin;


    @Inject
    public PlayerLeave(WorldInstanceFactory worldInstanceFactory, WorldManagerPlugin plugin) {
        this.worldInstanceFactory = worldInstanceFactory;
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        WorldInstance worldInstance = worldInstanceFactory.getWorldInstanceByName(event.getPlayer().getDisplayName());
        BukkitUtils.unloadWorldInstanceLater(worldInstance, event.getPlayer(), 20000000000000L, plugin);
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        WorldInstance worldInstance = worldInstanceFactory.getWorldInstanceByName(event.getPlayer().getDisplayName());
        BukkitUtils.unloadWorldInstanceLater(worldInstance, event.getPlayer(), 2000000000000L, plugin);
    }
}
