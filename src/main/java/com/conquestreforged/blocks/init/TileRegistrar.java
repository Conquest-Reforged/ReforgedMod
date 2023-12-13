package com.conquestreforged.blocks.init;

import com.conquestreforged.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TileRegistrar {

    @SubscribeEvent
    public static void entities(RegistryEvent.Register<BlockEntityType<?>> event) {
        Log.info("Registering TileEntities");
        event.getRegistry().register(TileEntityTypes.CAMPFIRE);
        event.getRegistry().register(TileEntityTypes.ENCHANTING_TABLE);
        event.getRegistry().register(TileEntityTypes.FURNACE);
        event.getRegistry().register(TileEntityTypes.ANIMAL);
        event.getRegistry().register(TileEntityTypes.SEAT);
    }

}
