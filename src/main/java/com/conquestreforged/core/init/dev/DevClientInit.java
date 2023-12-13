package com.conquestreforged.core.init.dev;

import com.conquestreforged.core.asset.lang.VirtualLang;
import com.conquestreforged.core.asset.pack.PackFinder;
import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Consumer;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DevClientInit {

    @SubscribeEvent // use this event as it happens later in the registry event cycle, but before first resource reload
    public static void recipes(RegistryEvent.Register<RecipeSerializer<?>> event) {
        if (Environment.isProduction()) {
            return;
        }

        Log.debug("Registering client resources");

        ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
        Consumer<RepositorySource> resourcePacks = Minecraft.getInstance().getResourcePackRepository()::addPackFinder;

        BlockDataRegistry.getInstance().getNamespaces().forEach(namespace -> {
            VirtualResourcepack.Builder builder = VirtualResourcepack.builder(namespace).type(PackType.CLIENT_RESOURCES);
            BlockDataRegistry.getInstance().getData(namespace).forEach(data -> data.addClientResources(builder));
            builder.add(new VirtualLang(namespace));
            builder.build(resourceManager);
        });

        PackFinder.getInstance(PackType.CLIENT_RESOURCES).register(resourceManager, resourcePacks);
    }
}
