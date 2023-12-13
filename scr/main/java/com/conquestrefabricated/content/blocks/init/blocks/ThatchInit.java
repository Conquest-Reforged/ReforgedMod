package com.conquestrefabricated.content.blocks.init.blocks;


import com.conquestrefabricated.content.blocks.block.*;
import com.conquestrefabricated.content.blocks.block.trees.Log;
import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class ThatchInit {

    public static void init(TypeList types) {
        VanillaProps.plantLike()
                .group(ModGroups.CROPS)
                .name("bundled_hay")
                .texture("top", "minecraft:block/hay_block_top")
                .texture("bottom", "minecraft:block/hay_block_top")
                .texture("*", "minecraft:block/hay_block_side")
                .parent(Blocks.HAY_BLOCK.getDefaultState())
                .register(TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class));
        VanillaProps.plantLike()
                .group(ModGroups.CROPS)
                .name("hay_bale")
                .texture("end", "block/1_basic_refined/2_roof/2_thatch/hay_bale_topbottom")
                .texture("top", "block/1_basic_refined/2_roof/2_thatch/hay_bale_topbottom")
                .texture("bottom", "block/1_basic_refined/2_roof/2_thatch/hay_bale_topbottom")
                .texture("*", "block/1_basic_refined/2_roof/2_thatch/hay_bale")
                .register(TypeList.of(Log.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class));
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("dark_brown_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/dark_brown_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("dark_brown_thatch_tracery")
                .texture("bottom","block/1_basic_refined/2_roof/2_thatch/dark_brown_thatch")
                .texture("top","block/1_basic_refined/2_roof/2_thatch/dark_brown_thatch")
                .texture("*","block/1_basic_refined/2_roof/2_thatch/dark_brown_thatch_tracery")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("mossy_dark_brown_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/mossy_dark_brown_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("overgrown_mossy_dark_brown_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/overgrown_mossy_dark_brown_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("dark_gray_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/dark_gray_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("dark_gray_thatch_tracery")
                .texture("bottom","block/1_basic_refined/2_roof/2_thatch/dark_gray_thatch")
                .texture("top","block/1_basic_refined/2_roof/2_thatch/dark_gray_thatch")
                .texture("*","block/1_basic_refined/2_roof/2_thatch/dark_gray_thatch_tracery")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("overgrown_mossy_dark_gray_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/overgrown_mossy_dark_gray_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("dark_yellow_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/dark_yellow_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("dark_yellow_thatch_tracery")
                .texture("bottom","block/1_basic_refined/2_roof/2_thatch/dark_yellow_thatch")
                .texture("top","block/1_basic_refined/2_roof/2_thatch/dark_yellow_thatch")
                .texture("*","block/1_basic_refined/2_roof/2_thatch/dark_yellow_thatch_tracery")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("mossy_dark_yellow_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/mossy_dark_yellow_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("yellow_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/yellow_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("mossy_yellow_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/mossy_yellow_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("yellow_thatch_tracery")
                .texture("bottom","block/1_basic_refined/2_roof/2_thatch/yellow_thatch")
                .texture("top","block/1_basic_refined/2_roof/2_thatch/yellow_thatch")
                .texture("*","block/1_basic_refined/2_roof/2_thatch/yellow_thatch_tracery")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("brown_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/brown_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("mossy_brown_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/mossy_brown_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("brown_thatch_tracery")
                .texture("bottom","block/1_basic_refined/2_roof/2_thatch/brown_thatch")
                .texture("top","block/1_basic_refined/2_roof/2_thatch/brown_thatch")
                .texture("*","block/1_basic_refined/2_roof/2_thatch/brown_thatch_tracery")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("gray_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/gray_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("mossy_gray_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/mossy_gray_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("overgrown_mossy_gray_thatch")
                .texture("block/1_basic_refined/2_roof/2_thatch/overgrown_mossy_gray_thatch")
                .register(types);
        VanillaProps.plantLike()
                .group(ModGroups.ROOFING)
                .name("gray_thatch_tracery")
                .texture("bottom","block/1_basic_refined/2_roof/2_thatch/gray_thatch")
                .texture("top","block/1_basic_refined/2_roof/2_thatch/gray_thatch")
                .texture("*","block/1_basic_refined/2_roof/2_thatch/gray_thatch_tracery")
                .register(types);
    }
}
