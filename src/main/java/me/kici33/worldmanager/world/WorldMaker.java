package me.kici33.worldmanager.world;

import com.google.inject.Inject;
import me.kici33.worldmanager.WorldManager;
import me.kici33.worldmanager.utils.WorldCopier;
import me.kici33.worldmanager.world.templates.WorldTemplate;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class WorldMaker {

    @Inject
    private WorldCopier worldCopier;

    @Inject
    private WorldManager plugin;

    public World createWorldFromTemplate(WorldTemplate worldTemplate) {
        File worldFile = worldTemplate.getFile();
        String worldName = worldTemplate.getName();
        File instanceFile = new File(plugin.getInstancesPath() + File.separator + worldName);
        copyWorld(worldFile, instanceFile);
        WorldCreator worldCreator = new WorldCreator(instanceFile.getName());
        return worldCreator.createWorld();
    }

    private void copyWorld(File source, File target){
        try {
            ArrayList<String> ignore = new ArrayList<>(Arrays.asList("uid.dat", "session.dat"));
            if(!ignore.contains(source.getName())) {
                if(source.isDirectory()) {
                    if(!target.exists())
                        target.mkdirs();
                    String files[] = source.list();
                    for (String file : files) {
                        File srcFile = new File(source, file);
                        File destFile = new File(target, file);
                        copyWorld(srcFile, destFile);
                    }
                } else {
                    InputStream in = new FileInputStream(source);
                    OutputStream out = new FileOutputStream(target);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = in.read(buffer)) > 0)
                        out.write(buffer, 0, length);
                    in.close();
                    out.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
