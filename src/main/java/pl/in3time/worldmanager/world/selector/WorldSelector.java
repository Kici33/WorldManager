package pl.in3time.worldmanager.world.selector;

import org.bukkit.World;
import org.bukkit.entity.Player;
import pl.in3time.worldmanager.world.instance.WorldInstance;


public interface WorldSelector {

    WorldInstance getWorldInstanceForPlayer(Player player);
}
