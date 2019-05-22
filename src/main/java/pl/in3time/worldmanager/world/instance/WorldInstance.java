package pl.in3time.worldmanager.world.instance;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import pl.in3time.worldmanager.world.template.WorldTemplate;

import java.io.File;


public class WorldInstance {
    private final WorldTemplate originalTemplate;
    private final File file;
    private String name;


    public WorldInstance(WorldTemplate originalTemplate, File file) {
        this.originalTemplate = originalTemplate;
        this.file = file;
        this.name = file.getName();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public World getBukkitWorld() {
        return Bukkit.getWorld(name);
    }

    public WorldTemplate getOriginalTemplate() {
        return originalTemplate;
    }

    public void load() {
        new WorldCreator(file.getName()).createWorld();
    }

    public boolean unload() {
        return Bukkit.getServer().unloadWorld(file.getName(), true);
    }

    public boolean isLoaded() {
        return Bukkit.getWorld(name) != null;
    }
}
