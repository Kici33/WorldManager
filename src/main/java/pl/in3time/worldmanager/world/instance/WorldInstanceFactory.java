package pl.in3time.worldmanager.world.instance;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import pl.in3time.worldmanager.WorldManagerPlugin;
import pl.in3time.worldmanager.utils.FileUtils;
import pl.in3time.worldmanager.world.template.WorldTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.Map;


@Singleton
public class WorldInstanceFactory {
    private final WorldManagerPlugin plugin;
    private final Map<String, WorldInstance> instances = new HashMap<>();


    @Inject
    public WorldInstanceFactory(WorldManagerPlugin plugin) {
        this.plugin = plugin;
    }


    public WorldInstance createWorldInstanceFromTemplate(WorldTemplate worldTemplate, String instanceName) throws IOException {
        File instanceFile = new File(plugin.getInstancesPath() + File.separator + instanceName);
        if (instanceFile.exists()) throw new FileAlreadyExistsException(instanceFile.getAbsolutePath());
        FileUtils.copyFile(worldTemplate.getFile(), instanceFile);
        WorldInstance worldInstance = new WorldInstance(instanceFile);
        instances.put(instanceName, worldInstance);
        return worldInstance;
    }

    public WorldInstance getWorldInstanceByName(String instanceName) {
        File instanceFile = new File(plugin.getInstancesPath() + File.separator + instanceName);
        if (instanceFile.exists()) {
            instances.put(instanceName, new WorldInstance(instanceFile));
        }
        return instances.get(instanceName);
    }
}
