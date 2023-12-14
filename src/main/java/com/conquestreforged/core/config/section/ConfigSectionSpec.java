package com.conquestreforged.core.config.section;

import com.conquestreforged.core.config.ConfigManager;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class ConfigSectionSpec implements AutoCloseable {

    private final DelegateConfigSection section;
    private final ForgeConfigSpec.Builder builder;

    public ConfigSectionSpec(ConfigManager manager, String name, ModConfig.Type type, ForgeConfigSpec.Builder builder) {
        this.builder = builder;
        this.section = new DelegateConfigSection(name, () -> manager.getConfig(type));
    }

    public ConfigSection getSection() {
        return section;
    }

    public ForgeConfigSpec.Builder getBuilder() {
        return builder;
    }

    @Override
    public void close() {
        builder.pop();
    }
}
