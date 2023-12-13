package com.conquestreforged.core.asset.pack;

import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

public class Locations {

    private Locations() {

    }

    public static ResourceLocation state(ResourceLocation name) {
        return new ResourceLocation(name.getNamespace(), "blockstates/" + name.getPath() + ".json");
    }

    public static ResourceLocation model(ResourceLocation name) {
        return new ResourceLocation(name.getNamespace(), "models/" + name.getPath() + ".json");
    }

    public static String recipePath(ResourceLocation name) {
        return path("data", "recipes", name);
    }

    public static String modRecipePath(ResourceLocation name) {
        return path("assets", "recipes", name);
    }

    public static String statePath(ResourceLocation name) {
        return path("assets", "blockstates", name);
    }

    public static String modelPath(ModelResourceLocation name) {
        return path("assets", "models", name);
    }

    public static String stateTemplatePath(ResourceLocation name) {
        return path("templates", "blockstates", name);
    }

    public static String modelTemplatePath(ModelResourceLocation name) {
        return path("templates", "models", name);
    }

    public static String path(ResourceLocation location) {
        if (location.getPath().endsWith(".json")) {
            return "assets/" + location.getNamespace() + "/" + location.getPath();
        }
        return "assets/" + location.getNamespace() + "/" + location.getPath() + ".json";
    }

    public static String path(String root, String prefix, ResourceLocation location) {
        if (location.getPath().endsWith(".json")) {
            return root + "/" + location.getNamespace() + "/" + prefix + "/" + location.getPath();
        }
        return root + "/" + location.getNamespace() + "/" + prefix + "/" + location.getPath() + ".json";
    }
}
