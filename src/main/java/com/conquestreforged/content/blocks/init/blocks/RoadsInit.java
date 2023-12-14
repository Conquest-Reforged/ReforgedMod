package com.conquestreforged.content.blocks.init.blocks;


import com.conquestreforged.content.blocks.block.*;
import com.conquestreforged.content.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class RoadsInit {

    public static void init(TypeList types) {
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("limestone_fanpattern_setts")
                .texture("block/1_basic_refined/1_stone/3_limestone/limestone_fanpattern_setts")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mixed_fanpattern_setts")
                .texture("block/1_basic_refined/1_stone/mixed_fanpattern_setts")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("clay_brick_fanpattern_setts")
                .texture("block/1_basic_refined/1_stone/1_clay/clay_brick_fanpattern_setts")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("chiseled_deepslate")
                .texture("top", "minecraft:block/chiseled_deepslate_top")
                .texture("bottom", "minecraft:block/chiseled_deepslate")
                .texture("minecraft:block/chiseled_deepslate")
                .parent(Blocks.CHISELED_DEEPSLATE.getDefaultState())
                .register(TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class));
    }
}
