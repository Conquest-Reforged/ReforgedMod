package com.conquestreforged.content.blocks.init;

import com.conquestreforged.content.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.core.util.log.Log;


public class TileRegistrar {

    //@SubscribeEvent
    public static void entities() {
        Log.info("Registering TileEntities");
        TileEntityTypes.init();
        //BlockEntityType<ModdedCampfireTileEntity> campfire = TileEntityTypes.CAMPFIRE;
        /*Registry.register(Registry.BLOCK_ENTITY_TYPE, TileEntityTypes.CAMPFIRE);
        event.getRegistry().register(TileEntityTypes.ENCHANTING_TABLE);
        event.getRegistry().register(TileEntityTypes.FURNACE);
        event.getRegistry().register(TileEntityTypes.ANIMAL);
        event.getRegistry().register(TileEntityTypes.SEAT);*/
    }

}