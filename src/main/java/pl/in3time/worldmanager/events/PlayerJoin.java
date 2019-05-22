package pl.in3time.worldmanager.events;

import com.google.inject.Inject;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.in3time.worldmanager.WorldManagerPlugin;
import pl.in3time.worldmanager.utils.BukkitUtils;
import pl.in3time.worldmanager.world.instance.WorldInstance;
import pl.in3time.worldmanager.world.selector.WorldSelector;


public class PlayerJoin implements Listener {
    private final WorldSelector worldSelector;
    private final WorldManagerPlugin plugin;


    @Inject
    public PlayerJoin(WorldSelector worldSelector, WorldManagerPlugin plugin) {
        this.worldSelector = worldSelector;
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        WorldInstance world = worldSelector.getWorldInstanceForPlayer(player);
        if (!world.isLoaded()) world.load();
        BukkitUtils.teleportPlayerWithDelay(player, world.getBukkitWorld().getSpawnLocation(), plugin);
    }
}
