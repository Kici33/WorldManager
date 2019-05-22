package pl.in3time.worldmanager.world.template;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import pl.in3time.worldmanager.WorldManagerPlugin;

import java.util.HashMap;
import java.util.Map;


@Singleton
public class WorldTemplateFactory {
    private final WorldManagerPlugin plugin;
    private final Map<String, WorldTemplate> templates = new HashMap<>();


    @Inject
    public WorldTemplateFactory(WorldManagerPlugin plugin) {
        this.plugin = plugin;
    }


    public WorldTemplate getTemplateByFileName(String fileName) {
        if (templates.containsKey(fileName)) return templates.get(fileName);
        WorldTemplate template = new WorldTemplate(fileName, plugin);
        templates.put(template.getName(), template);
        return template;
    }
}
