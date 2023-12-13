package com.conquestreforged.core.init.dev;

import com.conquestreforged.core.asset.pack.PackFinder;
import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.resources.IPackFinder;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.ResourcePackType;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;

import java.util.function.Consumer;

@Mod.EventBusSubscriber
public class DevServerInit {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void server(FMLServerAboutToStartEvent event) {
        if (Environment.isProduction()) {
            return;
        }

        Log.info("Registering server resources");

        IResourceManager resourceManager = event.getServer().getResourceManager();
        Consumer<IPackFinder> resourcePackList = event.getServer().getResourcePacks()::addPackFinder;

        BlockDataRegistry.getInstance().getNamespaces().forEach(namespace -> {
            VirtualResourcepack.Builder builder = VirtualResourcepack.builder(namespace).type(ResourcePackType.SERVER_DATA);
            BlockDataRegistry.getInstance().getData(namespace).forEach(data -> data.addServerResources(builder));
            builder.build(resourceManager);
        });

        PackFinder.getInstance(ResourcePackType.SERVER_DATA).register(resourceManager, resourcePackList);
    }
}
