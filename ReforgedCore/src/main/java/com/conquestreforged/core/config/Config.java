package com.conquestreforged.core.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Paths;

public class Config {

    private final ModConfig.Type type;
    private final CommentedFileConfig root;

    public Config(ModConfig.Type type, ForgeConfigSpec spec) {
        String filename = defaultConfigName(type, ModLoadingContext.get().getActiveContainer().getModId());

        this.type = type;

        this.root = CommentedFileConfig.builder(Paths.get("config", filename))
                .sync()
                .preserveInsertionOrder()
                .writingMode(WritingMode.REPLACE)
                .build();

        root.load();

        spec.setConfig(root);
    }

    public ModConfig.Type getType() {
        return type;
    }

    public CommentedConfig getRoot() {
        return root;
    }

    public void save() {
        root.save();
    }

    private static String defaultConfigName(ModConfig.Type type, String modId) {
        return String.format("%s-%s.toml", modId, type.extension());
    }
}
