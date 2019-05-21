package me.kici33.worldmanager.events;

import com.google.inject.Inject;
import me.kici33.worldmanager.inject.factories.WorldTemplateFactory;
import me.kici33.worldmanager.world.WorldMaker;
import me.kici33.worldmanager.WorldManager;
import me.kici33.worldmanager.world.selectors.WorldSelector;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoin implements Listener {

    @Inject
    private WorldSelector worldSelector;

    @Inject
    private WorldManager plugin;


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        World world = worldSelector.getWorldForPlayer(player);
        Bukkit.getScheduler().runTaskLater(plugin, () -> player.teleport(world.getSpawnLocation()), 20);
    }
}
