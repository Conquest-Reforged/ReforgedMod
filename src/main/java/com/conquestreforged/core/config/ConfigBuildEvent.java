package com.conquestreforged.core.config;

import com.conquestreforged.core.config.section.ConfigSectionSpec;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ConfigBuildEvent {

    private final ConfigManager manager;
    private final Map<ModConfig.Type, ForgeConfigSpec.Builder> builders = new HashMap<>();

    public ConfigBuildEvent(ConfigManager manager) {
        this.manager = manager;
    }

    public ConfigSectionSpec client(String name, String... comment) {
        return section(ModConfig.Type.CLIENT, name, comment);
    }

    public ConfigSectionSpec common(String name, String... comment) {
        return section(ModConfig.Type.COMMON, name, comment);
    }

    public ConfigSectionSpec server(String name, String... comment) {
        return section(ModConfig.Type.SERVER, name, comment);
    }

    public void forEach(BiConsumer<ModConfig.Type, ForgeConfigSpec.Builder> consumer) {
        builders.forEach(consumer);
    }

    private ConfigSectionSpec section(ModConfig.Type type, String section, String... comment) {
        ForgeConfigSpec.Builder root = builders.computeIfAbsent(type, t -> new ForgeConfigSpec.Builder().comment(comment));
        return new ConfigSectionSpec(manager, section, type, root.push(section));
    }
}
