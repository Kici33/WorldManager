package me.kici33.worldmanager.world.selectors;

import org.bukkit.World;
import org.bukkit.entity.Player;


public interface WorldSelector {

    World getWorldForPlayer(Player player);
}
