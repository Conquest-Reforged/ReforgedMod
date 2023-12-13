package com.conquestrefabricated.api.painting.vanilla;

import com.conquestrefabricated.api.painting.Painting;
import net.minecraft.util.Identifier;

public class VanillaPainting implements Painting {

    public static final Painting INSTANCE = new VanillaPainting();

    private final Identifier name = new Identifier("conquest:vanilla_painting");

    @Override
    public String getName() {
        return "Vanilla";
    }

    @Override
    public String getTranslationKey() {
        return "";
    }

    @Override
    public Identifier getRegistryName() {
        return name;
    }

    public static Painting fromName(String name) {
        return INSTANCE;
    }
}
