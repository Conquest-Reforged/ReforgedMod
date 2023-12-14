package com.conquestreforged.core.config;

import net.minecraftforge.fml.config.ModConfig;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private final Map<ModConfig.Type, Config> configs = new HashMap<>();

    public Config getConfig(ModConfig.Type type) {
        return configs.get(type);
    }

    public void addConfig(Config config) {
        configs.put(config.getType(), config);
    }
}
