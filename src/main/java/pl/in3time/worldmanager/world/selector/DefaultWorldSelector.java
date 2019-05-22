package pl.in3time.worldmanager.world.selector;

import com.google.inject.Inject;
import pl.in3time.worldmanager.world.instance.WorldInstance;
import pl.in3time.worldmanager.world.template.WorldTemplateFactory;
import pl.in3time.worldmanager.world.instance.WorldInstanceFactory;
import org.bukkit.entity.Player;

import java.io.IOException;


public class DefaultWorldSelector implements WorldSelector {
    private final WorldInstanceFactory worldInstanceFactory;
    private final WorldTemplateFactory templateFactory;


    @Inject
    public DefaultWorldSelector(WorldInstanceFactory worldInstanceFactory, WorldTemplateFactory templateFactory) {
        this.worldInstanceFactory = worldInstanceFactory;
        this.templateFactory = templateFactory;
    }


    @Override
    public WorldInstance getWorldInstanceForPlayer(Player player) {
        String playerName = player.getDisplayName();
        WorldInstance playerWorldInstance = worldInstanceFactory.getWorldInstanceByName(playerName);
        if (playerWorldInstance == null) {
            try {
                playerWorldInstance = worldInstanceFactory.createWorldInstanceFromTemplate(templateFactory.getTemplateByFileName("default"), playerName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return playerWorldInstance;
    }
}
