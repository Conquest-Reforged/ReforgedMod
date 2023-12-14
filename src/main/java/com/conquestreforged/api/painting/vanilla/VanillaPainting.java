package com.conquestreforged.api.painting.vanilla;

import com.conquestreforged.api.painting.Painting;
import net.minecraft.resources.ResourceLocation;

public class VanillaPainting implements Painting {

    public static final Painting INSTANCE = new VanillaPainting();

    private final ResourceLocation name = new ResourceLocation("conquest:vanilla_painting");

    @Override
    public String getName() {
        return "Vanilla";
    }

    @Override
    public String getTranslationKey() {
        return "";
    }

    @Override
    public ResourceLocation getRegistryName() {
        return name;
    }

    public static Painting fromName(String name) {
        return INSTANCE;
    }
}
