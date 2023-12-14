package com.conquestreforged.core.init.dev;

import com.conquestreforged.core.asset.lang.VirtualLang;
import com.conquestreforged.core.asset.pack.PackFinder;
import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import com.conquestreforged.core.util.log.Log;
import net.fabricmc.api.EnvType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.resource.ResourceType;

import java.util.function.Consumer;

@net.fabricmc.api.Environment(EnvType.CLIENT)
public class DevClientInit {

    // use this event as it happens later in the registry event cycle, but before first resource reload
    public static void recipes() {
        if (Environment.isProduction()) {
            return;
        }

        Log.debug("Registering client resources");

        ResourceManager resourceManager = MinecraftClient.getInstance().getResourceManager();
        Consumer<ResourcePackProvider> resourcePacks = MinecraftClient.getInstance().getResourcePackManager()::addPackFinder;

        BlockDataRegistry.getInstance().getNamespaces().forEach(namespace -> {
            VirtualResourcepack.Builder builder = VirtualResourcepack.builder(namespace).type(ResourceType.CLIENT_RESOURCES);
            BlockDataRegistry.getInstance().getData(namespace).forEach(data -> data.addClientResources(builder));
            builder.add(new VirtualLang(namespace));
            builder.build(resourceManager);
        });

        PackFinder.getInstance(ResourceType.CLIENT_RESOURCES).register(resourceManager, resourcePacks);
    }
}
