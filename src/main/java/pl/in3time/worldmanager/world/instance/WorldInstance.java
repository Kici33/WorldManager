package pl.in3time.worldmanager.world.instance;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import pl.in3time.worldmanager.world.template.WorldTemplate;

import java.io.File;


public class WorldInstance {
    private World bukkitWorld;
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
        return bukkitWorld;
    }

    public WorldTemplate getOriginalTemplate() {
        return originalTemplate;
    }

    public World load() {
        this.bukkitWorld = new WorldCreator(file.getName()).createWorld();
        return bukkitWorld;
    }

    public boolean unload() {
        if (bukkitWorld == null) return true;
        return Bukkit.getServer().unloadWorld(file.getName(), true);
    }

    public boolean isLoaded() {
        return Bukkit.getWorld(name) != null;
    }
}
