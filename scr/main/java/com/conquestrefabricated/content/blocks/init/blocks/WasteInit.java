package com.conquestrefabricated.content.blocks.init.blocks;

import com.conquestrefabricated.content.blocks.BlockVoxelShapes;
import com.conquestrefabricated.content.blocks.block.decor.ModelBlock;
import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import com.conquestrefabricated.core.util.RenderLayer;

public class WasteInit {

    public static void init() {
        VanillaProps.stone()
                .group(ModGroups.ANIMALS)
                .name("hanging_corpse")
                .manual()
                .blocking(false)
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.stone()
                .group(ModGroups.ANIMALS)
                .name("bones_on_the_ground")
                .manual()
                .blocking(false)
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.coverShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.stone()
                .group(ModGroups.ANIMALS)
                .name("cow_patty")
                .manual()
                .blocking(false)
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.coverShape)
                .register(TypeList.of(ModelBlock.class));
    }
}
