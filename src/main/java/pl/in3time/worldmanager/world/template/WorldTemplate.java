package pl.in3time.worldmanager.world.template;

import com.google.inject.Inject;
import pl.in3time.worldmanager.WorldManagerPlugin;

import java.io.File;


public class WorldTemplate {
    private String name;
    private File file;


    public WorldTemplate(String name, WorldManagerPlugin plugin) {
        this.name = name;
        this.file = new File(plugin.getTemplatesPath() + File.separator + name);
    }


    public File getFile() {
        return file;
    }

    public String getName() {
        return name;
    }
}
