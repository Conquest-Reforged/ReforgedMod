package com.conquestreforged.content.blocks.init.blocks;


import com.conquestreforged.content.blocks.block.*;
import com.conquestreforged.content.blocks.block.windows.ArrowSlit;
import com.conquestreforged.content.blocks.block.windows.WindowSmall;
import com.conquestreforged.content.blocks.block.windows.WindowSmallHalf;
import com.conquestreforged.content.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class LargeStoneSlabsInit {

    public static void init(TypeList types, TypeList typesVanilla, TypeList typesVanillaNoStairs) {
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_limestone_block")
                .texture("top", "block/1_basic_refined/1_stone/3_limestone/large_limestone_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/3_limestone/large_limestone_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/3_limestone/large_limestone_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_white_marble_block")
                .texture("top", "block/1_basic_refined/1_stone/4_marble/large_white_marble_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/4_marble/large_white_marble_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/4_marble/large_white_marble_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("smooth_large_white_marble_block")
                .texture("top", "block/1_basic_refined/1_stone/4_marble/large_white_marble_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/4_marble/large_white_marble_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/4_marble/smooth_large_white_marble_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_sandstone_block")
                .texture("top", "block/1_basic_refined/1_stone/5_sandstone/large_sandstone_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/5_sandstone/large_sandstone_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/5_sandstone/large_sandstone_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_inscribed_sandstone_block")
                .texture("top", "block/1_basic_refined/1_stone/5_sandstone/large_sandstone_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/5_sandstone/large_sandstone_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/5_sandstone/large_inscribed_sandstone_block")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("smooth_large_sandstone_block")
                .texture("top", "block/1_basic_refined/1_stone/5_sandstone/large_sandstone_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/5_sandstone/large_sandstone_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/5_sandstone/smooth_large_sandstone_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("smooth_large_inscribed_sandstone_block")
                .texture("top", "block/1_basic_refined/1_stone/5_sandstone/large_sandstone_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/5_sandstone/large_sandstone_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/5_sandstone/smooth_large_inscribed_sandstone_block")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_tan_sandstone_block")
                .texture("top", "block/1_basic_refined/1_stone/5_sandstone/large_tan_sandstone_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/5_sandstone/large_tan_sandstone_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/5_sandstone/large_tan_sandstone_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_andesite_brick")
                .texture("block/1_basic_refined/1_stone/large_andesite_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_eroded_pentelic_marble_block")
                .texture("block/1_basic_refined/1_stone/4_marble/large_eroded_pentelic_marble_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_weathered_pentelic_marble_block")
                .texture("block/1_basic_refined/1_stone/4_marble/large_weathered_pentelic_marble_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_pentelic_marble_block")
                .texture("block/1_basic_refined/1_stone/4_marble/large_pentelic_marble_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("large_black_painted_block")
                .texture("top", "block/1_basic_refined/1_stone/large_black_painted_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/large_black_painted_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/large_black_painted_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("large_inscribed_black_painted_block")
                .texture("top", "block/1_basic_refined/1_stone/large_black_painted_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/large_black_painted_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/large_inscribed_black_painted_block")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("smooth_large_black_painted_block")
                .texture("top", "block/1_basic_refined/1_stone/large_black_painted_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/large_black_painted_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/smooth_large_black_painted_block")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("smooth_large_inscribed_black_painted_block")
                .texture("top", "block/1_basic_refined/1_stone/large_black_painted_block_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/large_black_painted_block_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/smooth_large_inscribed_black_painted_block")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("concrete_wall")
                .texture("minecraft:block/light_gray_concrete")
                .parent(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("damaged_concrete_wall")
                .texture("block/2_advanced_refined/8_concrete/damaged_concrete_wall")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("white_concrete")
                .texture("minecraft:block/white_concrete")
                .parent(Blocks.WHITE_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("orange_concrete")
                .texture("minecraft:block/orange_concrete")
                .parent(Blocks.ORANGE_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("light_blue_concrete")
                .texture("minecraft:block/light_blue_concrete")
                .parent(Blocks.LIGHT_BLUE_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("yellow_concrete")
                .texture("minecraft:block/yellow_concrete")
                .parent(Blocks.YELLOW_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("green_concrete")
                .texture("minecraft:block/green_concrete")
                .parent(Blocks.GREEN_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("pink_concrete")
                .texture("minecraft:block/pink_concrete")
                .parent(Blocks.PINK_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("gray_concrete")
                .texture("minecraft:block/gray_concrete")
                .parent(Blocks.GRAY_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.METAL)
                .name("carbonite_paneling")
                .texture("minecraft:block/purpur_block")
                .parent(Blocks.PURPUR_BLOCK.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("purple_concrete")
                .texture("minecraft:block/purple_concrete")
                .parent(Blocks.PURPLE_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("brown_concrete")
                .texture("minecraft:block/brown_concrete")
                .parent(Blocks.BROWN_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_andesite_masonry")
                .texture("minecraft:block/polished_andesite")
                .parent(Blocks.POLISHED_ANDESITE.getDefaultState())
                .register(typesVanillaNoStairs);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_granite_brick")
                .texture("minecraft:block/polished_granite")
                .parent(Blocks.POLISHED_GRANITE.getDefaultState())
                .register(typesVanillaNoStairs);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_light_limestone_brick")
                .texture("minecraft:block/polished_diorite")
                .parent(Blocks.POLISHED_DIORITE.getDefaultState())
                .register(typesVanillaNoStairs);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("large_marble_blocks")
                .texture("minecraft:block/quartz_bricks")
                .parent(Blocks.QUARTZ_BRICKS.getDefaultState())
                .register(typesVanillaNoStairs);
    }
}
