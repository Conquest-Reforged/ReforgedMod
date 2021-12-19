package com.conquestreforged.core.init.dev;

import com.conquestreforged.core.asset.pack.PackFinder;
import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmlserverevents.FMLServerAboutToStartEvent;

import java.util.function.Consumer;

@Mod.EventBusSubscriber
public class DevServerInit {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void server(FMLServerAboutToStartEvent event) {
        if (Environment.isProduction()) {
            return;
        }

        Log.info("Registering server resources");

        ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
        Consumer<RepositorySource> resourcePackList = event.getServer().getPackRepository()::addPackFinder;

        BlockDataRegistry.getInstance().getNamespaces().forEach(namespace -> {
            VirtualResourcepack.Builder builder = VirtualResourcepack.builder(namespace).type(PackType.SERVER_DATA);
            BlockDataRegistry.getInstance().getData(namespace).forEach(data -> data.addServerResources(builder));
            builder.build(resourceManager);
        });

        PackFinder.getInstance(PackType.SERVER_DATA).register(resourceManager, resourcePackList);
    }
}
