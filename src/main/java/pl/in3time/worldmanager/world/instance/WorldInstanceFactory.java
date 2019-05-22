package pl.in3time.worldmanager.world.instance;

import com.google.inject.Inject;
import pl.in3time.worldmanager.WorldManagerPlugin;
import pl.in3time.worldmanager.utils.FileUtils;
import pl.in3time.worldmanager.world.template.WorldTemplate;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class WorldInstanceFactory {
    private final WorldManagerPlugin plugin;
    private final Map<String, WorldInstance> instances = new HashMap<>();


    @Inject
    public WorldInstanceFactory(WorldManagerPlugin plugin) {
        this.plugin = plugin;
    }


    public WorldInstance createWorldInstanceFromTemplate(WorldTemplate worldTemplate, String instanceName) throws IOException {
        File instanceFile = copyWorldFiles(worldTemplate, instanceName);
        WorldInstance worldInstance = new WorldInstance(worldTemplate, instanceFile);
        instances.put(instanceName, worldInstance);
        return worldInstance;
    }

    public WorldInstance getWorldInstanceByName(String instanceName) {
        return instances.get(instanceName);
    }

    private File copyWorldFiles(WorldTemplate worldTemplate, String name) throws IOException {
        File worldFile = worldTemplate.getFile();
        File instanceFile = new File(plugin.getInstancesPath() + File.separator + name);
        FileUtils.copyFile(worldFile, instanceFile);
        return instanceFile;
    }
}
