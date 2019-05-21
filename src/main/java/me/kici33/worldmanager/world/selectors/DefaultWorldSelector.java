package me.kici33.worldmanager.world.selectors;

import com.google.inject.Inject;
import me.kici33.worldmanager.inject.factories.WorldTemplateFactory;
import me.kici33.worldmanager.world.WorldMaker;
import org.bukkit.World;
import org.bukkit.entity.Player;


public class DefaultWorldSelector implements WorldSelector {
    private World playerWorld;

    @Inject
    private WorldMaker worldMaker;

    @Inject
    private WorldTemplateFactory templateFactory;


    @Override
    public World getWorldForPlayer(Player player) {
        String playerName = player.getDisplayName();
        if (playerWorld == null) playerWorld = worldMaker.createWorldFromTemplate(templateFactory.create("world"));
        return playerWorld;
    }
}
