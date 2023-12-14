package com.conquestreforged;

import com.conquestreforged.content.blocks.init.BlockRegistrar;
import com.conquestreforged.content.blocks.init.ParticleRegistrar;
import com.conquestreforged.content.blocks.init.TileRegistrar;
import com.conquestreforged.content.entities.init.EntityCommonInit;
import com.conquestreforged.content.items.init.ItemCommonInit;

@Mod("conquest")
public class ReforgedMod {

    public static void ReforgedMod() {
        BlockRegistrar.blocks();
        BlockRegistrar.items();
       // InitCommon.items();
        ItemCommonInit.init();
        TileRegistrar.entities();
        EntityCommonInit.entities();
        ParticleRegistrar.onIParticleTypeRegistration();
        /*
        BlockRegistrar.blocks();
        InitCommon.blocks();
        BlockRegistrar.items();
        InitCommon.items();*/
       // InitCommon.common();

    }
}
