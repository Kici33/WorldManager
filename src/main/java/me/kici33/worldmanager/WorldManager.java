package me.kici33.worldmanager;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.kici33.worldmanager.events.PlayerJoin;
import me.kici33.worldmanager.inject.modules.MainModule;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public class WorldManager extends JavaPlugin {

    @Override
    public void onEnable() {
        Injector injector = Guice.createInjector(new MainModule());
        Bukkit.getPluginManager().registerEvents(injector.getInstance(PlayerJoin.class), this);
    }

    @Override
    public void onDisable() {

    }

    public String getServerRootPath() {
        return getDataFolder().getParentFile().getAbsolutePath();
    }

    public String getInstancesPath() {
        return getServerRootPath() + File.separator + "instances";
    }

    public String getTemplatesPath() {
        return getServerRootPath() + File.separator + "templates";
    }
}
