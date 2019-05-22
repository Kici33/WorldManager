package pl.in3time.worldmanager.di.modules;

import com.google.inject.AbstractModule;
import pl.in3time.worldmanager.WorldManagerPlugin;
import pl.in3time.worldmanager.world.selector.DefaultWorldSelector;
import pl.in3time.worldmanager.world.selector.WorldSelector;


public class MainModule extends AbstractModule {
    private final WorldManagerPlugin plugin;


    public MainModule(WorldManagerPlugin plugin) {
        this.plugin = plugin;
    }


    protected void configure() {
        bind(WorldSelector.class).to(DefaultWorldSelector.class);
        bind(WorldManagerPlugin.class).toInstance(this.plugin);
    }
}
