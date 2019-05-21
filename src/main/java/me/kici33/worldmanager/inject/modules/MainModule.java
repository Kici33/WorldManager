package me.kici33.worldmanager.inject.modules;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import me.kici33.worldmanager.WorldManager;
import me.kici33.worldmanager.inject.factories.WorldTemplateFactory;
import me.kici33.worldmanager.world.selectors.DefaultWorldSelector;
import me.kici33.worldmanager.world.selectors.WorldSelector;
import me.kici33.worldmanager.world.templates.NormalWorldTemplate;
import me.kici33.worldmanager.world.templates.WorldTemplate;


public class MainModule extends AbstractModule {
    private final WorldManager plugin;

    public MainModule(WorldManager plugin) {
        this.plugin = plugin;
    }

    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(WorldTemplate.class, NormalWorldTemplate.class)
                .build(WorldTemplateFactory.class));

        bind(WorldSelector.class).to(DefaultWorldSelector.class);
        bind(WorldManager.class).toInstance(this.plugin);
    }
}
