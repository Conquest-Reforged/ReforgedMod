package com.conquestreforged.core.init;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Context {

    private static final Map<ModContainer, Context> contexts = new ConcurrentHashMap<>();

    private String namespace = "";

    public static Context getInstance() {
        return getCurrentContext();
    }

    public synchronized String getNamespace() {
        return namespace;
    }

    public synchronized Identifier newResourceLocation(String path) {
        return new Identifier(namespace, path);
    }

    public synchronized void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    private static Context getCurrentContext() {
        ModContainer current = FabricLoader.getInstance().getModContainer("conquest").get();
        return contexts.computeIfAbsent(current, k -> {
            Context context = new Context();
            context.setNamespace(k.getMetadata().getId());
            return context;
        });
    }

}
