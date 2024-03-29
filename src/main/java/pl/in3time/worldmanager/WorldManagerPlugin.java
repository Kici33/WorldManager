package pl.in3time.worldmanager;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.in3time.worldmanager.di.modules.MainModule;
import pl.in3time.worldmanager.events.PlayerJoin;
import pl.in3time.worldmanager.events.PlayerLeave;

import java.io.File;


public class WorldManagerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Injector injector = Guice.createInjector(new MainModule(this));
        injector.injectMembers(this);
        Bukkit.getPluginManager().registerEvents(injector.getInstance(PlayerJoin.class), this);
        Bukkit.getPluginManager().registerEvents(injector.getInstance(PlayerLeave.class), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }

    private String getServerRootPath() {
        return new File(getDataFolder().getAbsolutePath()).getParentFile().getParentFile().getAbsolutePath();
    }

    public String getInstancesPath() {
        return getServerRootPath() + File.separator + "instances";
    }

    public String getTemplatesPath() {
        return getServerRootPath() + File.separator + "templates";
    }
}
