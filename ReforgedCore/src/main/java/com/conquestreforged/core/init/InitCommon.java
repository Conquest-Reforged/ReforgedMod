package com.conquestreforged.core.init;

import com.conquestreforged.core.block.BlockStats;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import com.conquestreforged.core.data.BlockDump;
import com.conquestreforged.core.init.dev.Environment;
import com.conquestreforged.core.item.family.FamilyRegistry;
import com.conquestreforged.core.util.cache.Cache;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InitCommon {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void blocks(RegistryEvent.Register<Block> event) {
        Log.info("Registering blocks");
        BlockDataRegistry.getInstance().forEach(data -> Registrar.register(data, data.getBlock(), event.getRegistry()));
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void items(RegistryEvent.Register<Item> event) {
        Log.info("Registering block items");
        BlockDataRegistry.getInstance().forEach(data -> Registrar.register(data, data.getItem(), event.getRegistry()));
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void common(FMLCommonSetupEvent event) {
        if (!Environment.isProduction()) {
            BlockDump.run();

            BlockStats stats = new BlockStats();
            Log.info("Block Stats:");
            Log.info("(Total) Blocks: {}, States: {}", stats.totalBlocks, stats.totalStates);
            Log.info("(Vanilla) Blocks: {}, States: {}", stats.vanillaBlocks, stats.vanillaStates);
            Log.info("(Conquest) Blocks: {}, States: {}", stats.conquestBlocks, stats.conquestStates);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void complete(FMLLoadCompleteEvent event) {
        if (Environment.isProduction()) {
            Log.info("Load complete. Clearing loading caches");
            Cache.clearAll();
            FamilyRegistry.bake();
            BlockDataRegistry.getInstance().dispose();
        }
    }
}
