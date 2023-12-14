package com.conquestreforged.core.init.dev;

import com.conquestreforged.core.asset.pack.PackFinder;
import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import com.conquestreforged.core.util.log.Log;
import net.fabricmc.api.EnvType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.resource.ResourceType;
import net.minecraft.server.MinecraftServer;

import java.util.function.Consumer;

@net.fabricmc.api.Environment(EnvType.SERVER)
public class DevServerInit {

    public static void server(MinecraftServer server) {
        if (Environment.isProduction()) {
            return;
        }

        Log.info("Registering server resources");

        ResourceManager resourceManager = MinecraftClient.getInstance().getResourceManager();
        Consumer<ResourcePackProvider> resourcePackList = server.getDataPackManager()::addPackFinder;

        BlockDataRegistry.getInstance().getNamespaces().forEach(namespace -> {
            VirtualResourcepack.Builder builder = VirtualResourcepack.builder(namespace).type(ResourceType.SERVER_DATA);
            BlockDataRegistry.getInstance().getData(namespace).forEach(data -> data.addServerResources(builder));
            builder.build(resourceManager);
        });

        PackFinder.getInstance(ResourceType.SERVER_DATA).register(resourceManager, resourcePackList);
    }
}
