package com.conquestrefabricated;

import com.conquestrefabricated.content.blocks.init.BlockRegistrar;
import com.conquestrefabricated.content.blocks.init.ParticleRegistrar;
import com.conquestrefabricated.content.blocks.init.TileRegistrar;
import com.conquestrefabricated.content.entities.init.EntityCommonInit;
import com.conquestrefabricated.content.items.init.ItemCommonInit;
import com.conquestrefabricated.core.init.InitCommon;
import net.fabricmc.api.ModInitializer;

public class RefabricatedMod implements ModInitializer {


    @Override
    public void onInitialize() {
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
