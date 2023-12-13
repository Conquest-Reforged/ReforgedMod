package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.*;
import com.conquestreforged.blocks.block.classical.*;
import com.conquestreforged.blocks.block.directional.HorizontalDirectional;
import com.conquestreforged.blocks.block.directional.SlabDirectionalWaterlogged;
import com.conquestreforged.blocks.block.trees.Log;
import com.conquestreforged.blocks.block.windows.ArrowSlit;
import com.conquestreforged.blocks.block.windows.WindowSmall;
import com.conquestreforged.blocks.block.windows.WindowSmallHalf;
import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.world.level.block.Blocks;

public class IrregularBlocksInit {

    public static void init() {
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("simple_rune_carvings_1")
                .texture("*", "block/2_advanced_refined/1_stone/simple_rune_carvings")
                .register(TypeList.of(Cube.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("simple_rune_carvings_2")
                .family("simple_rune_carvings_1")
                .texture("*", "block/2_advanced_refined/1_stone/simple_rune_carvings")
                .register(TypeList.of(Cube.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("roman_orange_clay_brick_with_sandstone_base")
                .texture("top", "block/1_basic_refined/1_stone/1_clay/roman_orange_clay_brick")
                .texture("bottom", "minecraft:block/sandstone_bottom")
                .texture("*", "block/1_basic_refined/1_stone/1_clay/roman_orange_clay_brick_with_sandstone_base")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("portcullis_groove")
                .texture("top", "block/2_advanced_refined/1_stone/portcullis_groove_top")
                .texture("bottom", "block/2_advanced_refined/1_stone/portcullis_groove_top")
                .texture("*", "block/2_advanced_refined/1_stone/portcullis_groove")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, SlabBasic.class, SlabQuarterNoLayers.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("fancy_blue_schist_dwarven_design")
                .texture("top", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("bottom", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("*", "block/2_advanced_refined/1_stone/6_schist/fancy_blue_schist_dwarven_design")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, SlabBasic.class, SlabQuarterNoLayers.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("fancy_granite_dwarven_design")
                .texture("top", "minecraft:block/granite")
                .texture("bottom", "minecraft:block/granite")
                .texture("*", "block/2_advanced_refined/1_stone/1_granite/fancy_granite_dwarven_design")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, SlabBasic.class, SlabQuarterNoLayers.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("fancy_dark_rough_marble_dwarven_design")
                .texture("top", "block/8_topography/1_stone/dark_rough_marble")
                .texture("bottom", "block/8_topography/1_stone/dark_rough_marble")
                .texture("*", "block/2_advanced_refined/1_stone/3_marble/fancy_dark_rough_marble_dwarven_design")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, SlabBasic.class, SlabQuarterNoLayers.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("horizontally_carved_oak_wood")
                .texture("top", "block/1_basic_refined/3_wood/oak/wall_of_oak_logs_topbottom")
                .texture("bottom", "block/1_basic_refined/3_wood/oak/wall_of_oak_logs_topbottom")
                .texture("*", "block/2_advanced_refined/7_wood/horizontally_carved_oak_wood")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, SlabBasic.class, SlabQuarterNoLayers.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("irregular_andesite_stone_wall_stone_brick_quoins")
                .texture("top", "block/1_basic_refined/1_stone/irregular_andesite_stone_wall")
                .texture("bottom", "block/1_basic_refined/1_stone/irregular_andesite_stone_wall")
                .texture("*", "block/1_basic_refined/1_stone/irregular_andesite_stone_wall_stone_brick_quoins")
                .register(TypeList.of(Cube.class, VerticalSlab.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("limestone_cobble_with_quoins")
                .texture("top", "minecraft:block/stone_bricks")
                .texture("bottom", "minecraft:block/stone_bricks")
                .texture("*", "block/1_basic_refined/1_stone/3_limestone/limestone_cobble_with_quoins")
                .register(TypeList.of(Cube.class, VerticalSlab.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mossy_limestone_cobble_with_quoins")
                .texture("block/1_basic_refined/1_stone/3_limestone/mossy_limestone_cobble_with_quoins")
                .register(TypeList.of(Cube.class, VerticalSlab.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("limestone_cobble_clay_brick_quoins")
                .texture("top", "minecraft:block/cobblestone")
                .texture("bottom", "minecraft:block/cobblestone")
                .texture("*", "block/1_basic_refined/1_stone/3_limestone/limestone_cobble_clay_brick_quoins")
                .register(TypeList.of(Cube.class, VerticalSlab.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("blue_schist_dwarven_design")
                .texture("top", "block/2_advanced_refined/1_stone/6_schist/blue_schist_dwarven_design_topbottom")
                .texture("bottom", "block/2_advanced_refined/1_stone/6_schist/blue_schist_dwarven_design_topbottom")
                .texture("*", "block/2_advanced_refined/1_stone/6_schist/blue_schist_dwarven_design")
                .register(TypeList.of(Cube.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("granite_dwarven_design")
                .texture("top", "minecraft:block/granite")
                .texture("bottom", "minecraft:block/granite")
                .texture("*", "block/2_advanced_refined/1_stone/1_granite/granite_dwarven_design")
                .register(TypeList.of(Cube.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("dark_rough_marble_dwarven_design")
                .texture("top", "block/8_topography/1_stone/dark_rough_marble")
                .texture("bottom", "block/8_topography/1_stone/dark_rough_marble")
                .texture("*", "block/2_advanced_refined/1_stone/3_marble/dark_rough_marble_dwarven_design")
                .register(TypeList.of(Cube.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("lapis_lazuli_sandstone_border")
                .texture("block/2_advanced_refined/1_stone/5_sandstone/lapis_lazuli_sandstone_border")
                .register(TypeList.of(Cube.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("iron_block")
                .texture("minecraft:block/iron_block")
                .parent(Blocks.IRON_BLOCK.defaultBlockState())
                .register(TypeList.of(ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("iron_block_2")
                .texture("minecraft:block/iron_block")
                .register(TypeList.of(Cube.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusty_iron_block")
                .texture("block/2_advanced_refined/2_metal/rusty_iron_block")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_iron_block")
                .texture("block/2_advanced_refined/2_metal/old_iron_block")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class, FenceVanilla.class, FenceGate.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("sandstone_frieze")
                .texture("top", "block/2_advanced_refined/1_stone/5_sandstone/complex_sandstone_design")
                .texture("bottom", "block/2_advanced_refined/1_stone/5_sandstone/complex_sandstone_design")
                .texture("*", "block/2_advanced_refined/1_stone/5_sandstone/sandstone_frieze")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("sandstone_frieze")
                .family("sandstone_frieze")
                .texture("top", "block/2_advanced_refined/1_stone/5_sandstone/complex_sandstone_design")
                .texture("bottom", "block/2_advanced_refined/1_stone/5_sandstone/complex_sandstone_design")
                .texture("*", "block/2_advanced_refined/1_stone/5_sandstone/sandstone_frieze_slab")
                .parent(Blocks.COBBLESTONE.defaultBlockState())
                .register(TypeList.of(SlabBasic.class, Stairs.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("sandstone_cornice")
                .manual()
                .register(TypeList.of(CubeCapital.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("sandstone_architrave")
                .manual()
                .register(TypeList.of(CubeCapital.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("sandstone_plinth")
                .manual()
                .register(TypeList.of(CubeCapital.class, SlabPlinth.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, PillarCapital.class, Stairs.class, Wall.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("sandstone_plinth_1")
                .family("sandstone_plinth")
                .manual()
                .parent(Blocks.COBBLESTONE.defaultBlockState())
                .register(TypeList.of(SlabPlinth.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("sandstone_plinth_flat")
                .family("sandstone_plinth")
                .texture("top", "block/8_topography/1_stone/mudstone_topbottom")
                .texture("bottom", "block/8_topography/1_stone/mudstone_topbottom")
                .texture("*", "block/2_advanced_refined/1_stone/5_sandstone/sandstone_plinth")
                .register(TypeList.of(Cube.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("marble_and_sandstone_plinth")
                .manual()
                .register(TypeList.of(CubeCapital.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, PillarCapital.class, Stairs.class, Wall.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("marble_and_sandstone_plinth_flat")
                .texture("top", "minecraft:block/quartz_block_top")
                .texture("bottom", "block/2_advanced_refined/1_stone/5_sandstone/complex_sandstone_design")
                .texture("*", "block/2_advanced_refined/1_stone/3_marble/marble_and_sandstone_plinth")
                .register(TypeList.of(Cube.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("marble_cornice")
                .manual()
                .register(TypeList.of(CubeCapital.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("marble_architrave")
                .manual()
                .register(TypeList.of(CubeCapital.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("marble_plinth")
                .manual()
                .register(TypeList.of(CubeCapital.class, SlabPlinth.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, PillarCapital.class, Stairs.class, Wall.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("marble_plinth_1")//slab
                .family("marble_plinth")
                .manual()
                .parent(Blocks.COBBLESTONE.defaultBlockState())
                .register(TypeList.of(SlabPlinth.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("marble_plinth_flat")
                .family("marble_plinth")
                .texture("top", "minecraft:block/quartz_block_top")
                .texture("bottom", "minecraft:block/quartz_block_top")
                .texture("*", "block/2_advanced_refined/1_stone/3_marble/marble_plinth")
                .register(TypeList.of(Cube.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("fancy_gilded_pattern")
                .texture("top", "block/2_advanced_refined/2_metal/fancy_gilded_pattern_topbottom")
                .texture("bottom", "block/2_advanced_refined/2_metal/fancy_gilded_pattern_topbottom")
                .texture("*", "block/2_advanced_refined/2_metal/fancy_gilded_pattern")
                .register(TypeList.of(Cube.class, SlabLessLayers.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Cover.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("bronze_block")
                .texture("block/2_advanced_refined/2_metal/bronze_block")
                .register(TypeList.of(Cube.class, Balustrade.class, Capital.class, Sphere.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, SlabLessLayers.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("bronze_block_with_dragon_design")
                .texture("top", "block/2_advanced_refined/2_metal/bronze_block")
                .texture("bottom", "block/2_advanced_refined/2_metal/bronze_block")
                .texture("*", "block/2_advanced_refined/2_metal/bronze_block_with_dragon_design")
                .register(TypeList.of(Cube.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("gold_bar_pile")
                .texture("top", "block/2_advanced_refined/2_metal/gold_bar_pile_topbottom")
                .texture("bottom", "block/2_advanced_refined/2_metal/gold_bar_pile_topbottom")
                .texture("*", "block/2_advanced_refined/2_metal/gold_bar_pile")
                .register(TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class));
        VanillaProps.stone()
                //.group(ModGroups.CLOTH_AND_FIBERS)
                .name("rope_wrapped_around_log")
                .texture("end", "block/2_advanced_refined/7_wood/rope_wrapped_around_log_topbottom")
                .texture("*", "block/2_advanced_refined/7_wood/rope_wrapped_around_log")
                .register(TypeList.of(Log.class));
        VanillaProps.stone()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("pile_of_rope")
                .family("rope_wrapped_around_log")
                .texture("block/2_advanced_refined/7_wood/rope_wrapped_around_log")
                .register(TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                //.group(ModGroups.METAL)
                .name("chain_wrapped_around_log")
                .texture("end", "block/2_advanced_refined/7_wood/chain_wrapped_around_log_topbottom")
                .texture("*", "block/2_advanced_refined/7_wood/chain_wrapped_around_log")
                .register(TypeList.of(Log.class));
        VanillaProps.stone()
                .group(ModGroups.METAL)
                .name("pile_of_chains")
                .family("chain_wrapped_around_log")
                .texture("block/2_advanced_refined/7_wood/chain_wrapped_around_log")
                .register(TypeList.of(Cube.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("dirt_path")
                .texture("minecraft:block/coarse_dirt")
                .parent(Blocks.COARSE_DIRT.defaultBlockState())
                .register(TypeList.of(Layer.class));
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("loamy_dirt_with_cobblestone_border")
                .texture("top", "block/8_topography/5_dirt/loamy_dirt_with_cobblestone_border")
                .texture("bottom", "block/8_topography/5_dirt/loamy_dirt_with_cobblestone_border")
                .texture("*", "minecraft:block/cobblestone")
                .register(TypeList.of(Cube.class, Slab.class));
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("loamy_dirt_with_log_border")
                .texture("top", "block/8_topography/5_dirt/loamy_dirt_with_log_border")
                .texture("bottom", "block/8_topography/5_dirt/loamy_dirt_with_log_border")
                .texture("*", "block/1_basic_refined/3_wood/bundled_firewood")
                .register(TypeList.of(Cube.class, Slab.class));
        VanillaProps.logs()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("bundled_firewood")
                .texture("top", "block/1_basic_refined/3_wood/bundled_firewood_topbottom")
                .texture("bottom", "block/1_basic_refined/3_wood/bundled_firewood_topbottom")
                .texture("end", "block/1_basic_refined/3_wood/bundled_firewood_topbottom")
                .texture("*", "block/1_basic_refined/3_wood/bundled_firewood")
                .register(TypeList.of(Log.class, Wall.class, Pillar.class, SlabLessLayers.class, SlabQuarterNoLayers.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class));
        VanillaProps.logs()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("stacked_firewood")
                .texture("top", "block/1_basic_refined/3_wood/bundled_firewood_topbottom")
                .texture("bottom", "block/1_basic_refined/3_wood/bundled_firewood_topbottom")
                .texture("end", "block/1_basic_refined/3_wood/bundled_firewood_topbottom")
                .texture("*", "block/1_basic_refined/3_wood/stacked_firewood")
                .register(TypeList.of(Log.class, Wall.class, Pillar.class, SlabLessLayers.class, SlabQuarterNoLayers.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class));
        VanillaProps.logs()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("horizontally_bundled_firewood")
                .family("bundled_firewood")
                .manual()
                .register(TypeList.of(SlabDirectionalWaterlogged.class, SlabQuarterNoLayers.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalQuarter.class, Stairs.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("marble_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .family("marble_cornice_model")
                .name("marble_cornice_model_corner")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairInnerCornerTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .family("marble_cornice_model")
                .name("marble_cornice_model_quarter")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairOuterCornerTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("limestone_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("limestone_cornice_model_corner")
                .family("limestone_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairInnerCornerTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .name("limestone_cornice_model_quarter")
                .family("limestone_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairOuterCornerTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("caution_stripes")
                .texture("block/2_advanced_refined/8_concrete/caution_stripes")
                .register(TypeList.of(Cube.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));


        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("dark_sandstone_cornice")
                .manual()
                .register(TypeList.of(CubeCapital.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("dark_sandstone_architrave")
                .manual()
                .register(TypeList.of(CubeCapital.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("dark_sandstone_plinth")
                .manual()
                .register(TypeList.of(CubeCapital.class, SlabPlinth.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, PillarCapital.class, Stairs.class, Wall.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("dark_sandstone_plinth_1")
                .family("dark_sandstone_plinth")
                .manual()
                .parent(Blocks.COBBLESTONE.defaultBlockState())
                .register(TypeList.of(SlabPlinth.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("dark_sandstone_plinth_flat")
                .family("dark_sandstone_plinth")
                .texture("top", "block/1_basic_refined/1_stone/5_sandstone/brown_sandstone_brick")
                .texture("bottom", "block/1_basic_refined/1_stone/5_sandstone/brown_sandstone_brick")
                .texture("*", "block/2_advanced_refined/1_stone/5_sandstone/dark_sandstone_plinth")
                .register(TypeList.of(Cube.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("dark_sandstone_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("dark_sandstone_cornice_model_corner")
                .family("dark_sandstone_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairInnerCornerTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .name("dark_sandstone_cornice_model_quarter")
                .family("dark_sandstone_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairOuterCornerTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));

        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("limestone_cornice")
                .manual()
                .register(TypeList.of(CubeCapital.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("limestone_architrave")
                .manual()
                .register(TypeList.of(CubeCapital.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("limestone_plinth")
                .manual()
                .register(TypeList.of(CubeCapital.class, SlabPlinth.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, PillarCapital.class, Stairs.class, Wall.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("limestone_plinth_1")
                .family("limestone_plinth")
                .manual()
                .parent(Blocks.COBBLESTONE.defaultBlockState())
                .register(TypeList.of(SlabPlinth.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("limestone_plinth_flat")
                .family("limestone_plinth")
                .texture("top", "minecraft:block/stone")
                .texture("bottom", "minecraft:block/stone")
                .texture("*", "block/2_advanced_refined/1_stone/2_limestone/limestone_plinth")
                .register(TypeList.of(Cube.class));

        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("travertine_cornice")
                .manual()
                .register(TypeList.of(CubeCapital.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("travertine_architrave")
                .manual()
                .register(TypeList.of(CubeCapital.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, Pillar.class, Wall.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("travertine_plinth")
                .manual()
                .register(TypeList.of(CubeCapital.class, SlabPlinth.class, Balustrade.class, CapitalPlinth.class, VerticalSlabCapital.class, VerticalCornerCapital.class, VerticalQuarterCapital.class, PillarCapital.class, Stairs.class, Wall.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("travertine_plinth_1")
                .family("travertine_plinth")
                .manual()
                .parent(Blocks.COBBLESTONE.defaultBlockState())
                .register(TypeList.of(SlabPlinth.class));
        VanillaProps.stone()
                //.group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("travertine_plinth_flat")
                .family("travertine_plinth")
                .texture("top", "block/1_basic_refined/1_stone/4_marble/travertine_slab_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/4_marble/travertine_slab_topbottom")
                .texture("*", "block/2_advanced_refined/1_stone/3_marble/travertine_plinth")
                .register(TypeList.of(Cube.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("travertine_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .group(ModGroups.COLUMNS)
                .name("travertine_cornice_model_corner")
                .family("travertine_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairInnerCornerTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.stone()
                .name("travertine_cornice_model_quarter")
                .family("travertine_cornice_model")
                .manual()
                .solid(false)
                .with("hitBox", BlockVoxelShapes.stairOuterCornerTopShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("copper")
                .texture("minecraft:block/copper_block")
                .parent(Blocks.WAXED_COPPER_BLOCK.defaultBlockState())
                .register(TypeList.of(Balustrade.class, Capital.class, Sphere.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, SlabLessLayers.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("exposed_copper")
                .texture("minecraft:block/exposed_copper")
                .parent(Blocks.WAXED_EXPOSED_COPPER.defaultBlockState())
                .register(TypeList.of(Balustrade.class, Capital.class, Sphere.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, SlabLessLayers.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("weathered_copper")
                .texture("minecraft:block/weathered_copper")
                .parent(Blocks.WAXED_WEATHERED_COPPER.defaultBlockState())
                .register(TypeList.of(Balustrade.class, Capital.class, Sphere.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, SlabLessLayers.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("oxidized_copper")
                .texture("minecraft:block/oxidized_copper")
                .parent(Blocks.WAXED_OXIDIZED_COPPER.defaultBlockState())
                .register(TypeList.of(Balustrade.class, Capital.class, Sphere.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, SlabLessLayers.class));

    }
}
