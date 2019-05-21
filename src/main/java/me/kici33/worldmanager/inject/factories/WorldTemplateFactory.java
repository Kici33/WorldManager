package me.kici33.worldmanager.inject.factories;

import com.google.inject.assistedinject.Assisted;
import me.kici33.worldmanager.world.templates.WorldTemplate;


public interface WorldTemplateFactory {
    WorldTemplate create(@Assisted String name);
}
