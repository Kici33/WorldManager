package me.kici33.worldmanager.inject.modules;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import me.kici33.worldmanager.inject.factories.WorldTemplateFactory;
import me.kici33.worldmanager.world.templates.NormalWorldTemplate;
import me.kici33.worldmanager.world.templates.WorldTemplate;


public class MainModule extends AbstractModule {
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(WorldTemplate.class, NormalWorldTemplate.class)
                .build(WorldTemplateFactory.class));
    }
}
