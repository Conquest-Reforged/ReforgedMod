package com.conquestreforged.core.asset.pack;

import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;

public class Locations {

    private Locations() {

    }

    public static Identifier state(Identifier name) {
        return new Identifier(name.getNamespace(), "blockstates/" + name.getPath() + ".json");
    }

    public static Identifier model(Identifier name) {
        return new Identifier(name.getNamespace(), "models/" + name.getPath() + ".json");
    }

    public static String recipePath(Identifier name) {
        return path("data", "recipes", name);
    }

    public static String modRecipePath(Identifier name) {
        return path("assets", "recipes", name);
    }

    public static String statePath(Identifier name) {
        return path("assets", "blockstates", name);
    }

    public static String modelPath(ModelIdentifier name) {
        return path("assets", "models", name);
    }

    public static String stateTemplatePath(Identifier name) {
        return path("templates", "blockstates", name);
    }

    public static String modelTemplatePath(ModelIdentifier name) {
        return path("templates", "models", name);
    }

    public static String path(Identifier location) {
        if (location.getPath().endsWith(".json")) {
            return "assets/" + location.getNamespace() + "/" + location.getPath();
        }
        return "assets/" + location.getNamespace() + "/" + location.getPath() + ".json";
    }

    public static String path(String root, String prefix, Identifier location) {
        if (location.getPath().endsWith(".json")) {
            return root + "/" + location.getNamespace() + "/" + prefix + "/" + location.getPath();
        }
        return root + "/" + location.getNamespace() + "/" + prefix + "/" + location.getPath() + ".json";
    }
}
