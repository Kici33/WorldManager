package me.kici33.worldmanager.world.templates;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import me.kici33.worldmanager.WorldManager;

import java.io.File;


public class NormalWorldTemplate implements WorldTemplate {
    private String name;
    private File file;

    @Inject
    private WorldManager plugin;

    public File getFile() {
        return file;
    }

    public String getName() {
        return name;
    }

    @Inject
    public NormalWorldTemplate(@Assisted String name) {
        this.name = name;
        this.file = new File(plugin.getTemplatesPath() + File.separator + name);
    }
}
