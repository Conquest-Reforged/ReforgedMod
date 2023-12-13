package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.block.*;
import com.conquestreforged.blocks.block.arch.ArchSmall;
import com.conquestreforged.blocks.block.arch.ArchSmallHalf;
import com.conquestreforged.blocks.block.arch.ArchTwoMeter;
import com.conquestreforged.blocks.block.arch.ArchTwoMeterHalf;
import com.conquestreforged.blocks.block.overlay_top.inverted.*;
import com.conquestreforged.blocks.block.windows.ArrowSlit;
import com.conquestreforged.blocks.block.windows.WindowSmall;
import com.conquestreforged.blocks.block.windows.WindowSmallHalf;
import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.world.level.block.Blocks;

public class RefinedStoneCobbleBrickInit {

    public static void init(TypeList types, TypeList typesVanilla, TypeList typesVanillaNoWall, TypeList typesOverlayTop) {
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("lime_mortar_masonry")
                .texture("top", "block/1_basic_refined/1_stone/3_limestone/lime_mortar_masonry_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/3_limestone/lime_mortar_masonry_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/3_limestone/lime_mortar_masonry")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("muddy_limestone_fanpattern_setts")
                .texture("top", "block/1_basic_refined/1_stone/3_limestone/muddy_limestone_fanpattern_setts_top")
                .texture("*", "block/1_basic_refined/1_stone/3_limestone/muddy_limestone_fanpattern_setts")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("limestone_cobble")
                .texture("minecraft:block/cobblestone")
                .parent(Blocks.COBBLESTONE.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("limestone_bricks", "limestone_brick")
                .texture("minecraft:block/stone_bricks")
                .parent(Blocks.STONE_BRICKS.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.grassyStone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mossy_limestone_bricks", "mossy_limestone_brick")
                .manual()
                .grassColor()
                .parent(Blocks.MOSSY_STONE_BRICKS.defaultBlockState())
                .register(TypeList.of(ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, TopOverlayInvertedArrowSlit.class, TopOverlayInvertedWindowSmall.class, TopOverlayInvertedWindowSmallHalf.class, TopOverlayInvertedBalustrade.class, TopOverlayInvertedCapital.class, Sphere.class, TopOverlayInvertedSlab.class, TopOverlayInvertedSlabQuarter.class, TopOverlayInvertedSlabCorner.class, TopOverlayInvertedSlabEighth.class, TopOverlayInvertedVerticalSlabCorner.class, TopOverlayInvertedVerticalSlab.class, TopOverlayInvertedVerticalCorner.class, TopOverlayInvertedVerticalQuarter.class, TopOverlayInvertedStairs.class, Wall.class, TopOverlayInvertedPillar.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("cracked_limestone_bricks", "cracked_limestone_brick")
                .texture("minecraft:block/cracked_stone_bricks")
                .parent(Blocks.CRACKED_STONE_BRICKS.defaultBlockState())
                .register(TypeList.of(ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("clay_bricks", "clay_brick")
                .texture("top", "minecraft:block/bricks_topbottom")
                .texture("bottom", "minecraft:block/bricks_topbottom")
                .texture("*", "minecraft:block/bricks")
                .parent(Blocks.BRICKS.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("red_sandstone_cobble")
                .texture("top", "minecraft:block/red_sandstone_top")
                .texture("bottom", "minecraft:block/red_sandstone_bottom")
                .texture("minecraft:block/red_sandstone")
                .parent(Blocks.RED_SANDSTONE.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("sandstone")
                .texture("top", "minecraft:block/sandstone_top")
                .texture("bottom", "minecraft:block/sandstone_bottom")
                .texture("minecraft:block/sandstone")
                .parent(Blocks.SANDSTONE.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("marble_bricks", "marble_brick")
                .texture("top", "minecraft:block/quartz_block_top")
                .texture("bottom", "minecraft:block/quartz_block_bottom")
                .texture("minecraft:block/quartz_block_side")
                .parent(Blocks.QUARTZ_BLOCK.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("prismarine_bricks", "prismarine_brick")
                .texture("minecraft:block/prismarine_bricks")
                .parent(Blocks.PRISMARINE_BRICKS.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("dark_prismarine")
                .texture("minecraft:block/dark_prismarine")
                .parent(Blocks.DARK_PRISMARINE.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("end_stone_bricks", "end_stone_brick")
                .texture("minecraft:block/end_stone_bricks")
                .parent(Blocks.END_STONE_BRICKS.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("carved_limestone")
                .texture("block/1_basic_refined/1_stone/3_limestone/carved_limestone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("dry_limestone_wall")
                .texture("top", "block/1_basic_refined/1_stone/3_limestone/dry_limestone_wall_top")
                .texture("*", "block/1_basic_refined/1_stone/3_limestone/dry_limestone_wall")
                .register(types);
        VanillaProps.grassyStone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("heavily_overgrown_limestone_cobble")
                .texture("top", "block/1_basic_refined/1_stone/3_limestone/heavily_overgrown_limestone_cobble_top")
                .texture("bottom", "block/1_basic_refined/1_stone/3_limestone/heavily_overgrown_limestone_cobble_bottom")
                .texture("*", "block/1_basic_refined/1_stone/3_limestone/heavily_overgrown_limestone_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("light_limestone_brick")
                .texture("block/1_basic_refined/1_stone/3_limestone/light_limestone_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("light_limestone_cobble")
                .texture("block/1_basic_refined/1_stone/3_limestone/light_limestone_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("light_small_limestone_brick")
                .texture("block/1_basic_refined/1_stone/3_limestone/light_small_limestone_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("loose_small_limestones")
                .texture("block/1_basic_refined/1_stone/3_limestone/loose_small_limestones")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mossy_limestone_cobble")
                .texture("minecraft:block/mossy_cobblestone")
                .parent(Blocks.MOSSY_COBBLESTONE.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.grassyStone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("overgrown_limestone_cobble")
                .manual()
                .grassColor()
                .register(typesOverlayTop);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("overgrown_small_limestones")
                .texture("block/1_basic_refined/1_stone/3_limestone/overgrown_small_limestones")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("patterned_limestone_brick")
                .texture("block/1_basic_refined/1_stone/3_limestone/patterned_limestone_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("snow_covered_limestone_cobble")
                .texture("top", "block/1_basic_refined/1_stone/3_limestone/snow_covered_limestone_cobble_top")
                .texture("*", "block/1_basic_refined/1_stone/3_limestone/snow_covered_limestone_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("weathered_limestone_brick")
                .texture("block/1_basic_refined/1_stone/3_limestone/weathered_limestone_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("worn_light_limestone_cobble")
                .texture("block/1_basic_refined/1_stone/3_limestone/worn_light_limestone_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("lime_mortar_clay_brick")
                .texture("block/1_basic_refined/1_stone/1_clay/lime_mortar_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("lime_mortar_orange_clay_brick")
                .texture("block/1_basic_refined/1_stone/1_clay/lime_mortar_orange_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("vertical_lime_mortar_orange_clay_brick")
                .texture("block/1_basic_refined/1_stone/1_clay/vertical_lime_mortar_orange_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("lime_mortar_red_clay_brick")
                .texture("top", "block/1_basic_refined/1_stone/1_clay/lime_mortar_red_clay_brick_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/1_clay/lime_mortar_red_clay_brick_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/1_clay/lime_mortar_red_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mossy_clay_brick")
                .texture("top", "block/1_basic_refined/1_stone/1_clay/mossy_clay_brick_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/1_clay/mossy_clay_brick_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/1_clay/mossy_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mossy_lime_mortar_red_clay_brick")
                .texture("top", "block/1_basic_refined/1_stone/1_clay/mossy_lime_mortar_red_clay_brick_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/1_clay/mossy_lime_mortar_red_clay_brick_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/1_clay/mossy_lime_mortar_red_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mossy_red_clay_brick")
                .texture("top", "block/1_basic_refined/1_stone/1_clay/mossy_red_clay_brick_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/1_clay/mossy_red_clay_brick_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/1_clay/mossy_red_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("red_clay_brick")
                .texture("top", "block/1_basic_refined/1_stone/1_clay/red_clay_brick_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/1_clay/red_clay_brick_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/1_clay/red_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("roman_clay_brick")
                .texture("block/1_basic_refined/1_stone/1_clay/roman_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("roman_orange_clay_brick")
                .texture("block/1_basic_refined/1_stone/1_clay/roman_orange_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("vertical_roman_orange_clay_brick")
                .texture("block/1_basic_refined/1_stone/1_clay/vertical_roman_orange_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("roman_tan_clay_brick")
                .texture("block/1_basic_refined/1_stone/1_clay/roman_tan_clay_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("granite_brick")
                .texture("block/1_basic_refined/1_stone/2_granite/granite_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("granite_cobble")
                .texture("block/1_basic_refined/1_stone/2_granite/granite_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("granite_cyclopean_masonry")
                .texture("top", "block/1_basic_refined/1_stone/2_granite/granite_cyclopean_masonry_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/2_granite/granite_cyclopean_masonry_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/2_granite/granite_cyclopean_masonry")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("dokimeion_blue_marble")
                .texture("block/1_basic_refined/1_stone/4_marble/dokimeion_blue_marble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("carrara_white_marble")
                .texture("block/1_basic_refined/1_stone/4_marble/carrara_white_marble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("fior_de_bosco_gray_marble")
                .texture("block/1_basic_refined/1_stone/4_marble/fior_de_bosco_gray_marble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("nero_africano_black_marble")
                .texture("block/1_basic_refined/1_stone/4_marble/nero_africano_black_marble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("portasanta_pink_marble")
                .texture("block/1_basic_refined/1_stone/4_marble/portasanta_pink_marble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("rosso_antico_red_marble")
                .texture("block/1_basic_refined/1_stone/4_marble/rosso_antico_red_marble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("travertine_brick")
                .texture("block/1_basic_refined/1_stone/4_marble/travertine_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("travertine_slab")
                .texture("top", "block/1_basic_refined/1_stone/4_marble/travertine_slab_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/4_marble/travertine_slab_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/4_marble/travertine_slab")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ADVANCED_MASONRY_AND_CERAMICS)
                .name("verde_antico_green_marble")
                .texture("block/1_basic_refined/1_stone/4_marble/verde_antico_green_marble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("brown_sandstone_brick")
                .texture("block/1_basic_refined/1_stone/5_sandstone/brown_sandstone_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("tan_sandstone_cobble")
                .texture("block/1_basic_refined/1_stone/5_sandstone/tan_sandstone_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("brown_sandstone_cobble")
                .texture("top", "minecraft:block/red_sandstone_top")
                .texture("bottom", "minecraft:block/red_sandstone_top")
                .texture("*", "block/1_basic_refined/1_stone/5_sandstone/brown_sandstone_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("irregular_sandstone_tiles")
                .texture("block/1_basic_refined/1_stone/5_sandstone/irregular_sandstone_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mossy_sandstone")
                .texture("top", "block/1_basic_refined/1_stone/5_sandstone/mossy_sandstone_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/5_sandstone/mossy_sandstone_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/5_sandstone/mossy_sandstone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("orange_sandstone_cobble")
                .texture("block/1_basic_refined/1_stone/5_sandstone/orange_sandstone_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("red_sandstone_brick")
                .texture("block/1_basic_refined/1_stone/5_sandstone/red_sandstone_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("sandstone_brick")
                .texture("block/1_basic_refined/1_stone/5_sandstone/sandstone_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("small_brown_sandstone_brick")
                .texture("block/1_basic_refined/1_stone/5_sandstone/small_brown_sandstone_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("tan_sandstone_brick")
                .texture("block/1_basic_refined/1_stone/5_sandstone/tan_sandstone_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("dry_slate_wall")
                .texture("top", "block/1_basic_refined/1_stone/6_slate/dry_slate_wall_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/6_slate/dry_slate_wall_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/6_slate/dry_slate_wall")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mixed_slate_wall")
                .texture("block/1_basic_refined/1_stone/6_slate/mixed_slate_wall")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("slate_light_mortar_wall")
                .texture("block/1_basic_refined/1_stone/6_slate/slate_light_mortar_wall")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("slate_mortar_wall")
                .texture("top", "block/1_basic_refined/1_stone/6_slate/slate_mortar_wall_topbottom")
                .texture("bottom", "block/1_basic_refined/1_stone/6_slate/slate_mortar_wall_topbottom")
                .texture("*", "block/1_basic_refined/1_stone/6_slate/slate_mortar_wall")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("broken_reticulated_brick")
                .texture("block/1_basic_refined/1_stone/broken_reticulated_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("reticulated_brick")
                .texture("block/1_basic_refined/1_stone/reticulated_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("graywacke_mortar_wall")
                .texture("block/1_basic_refined/1_stone/graywacke_mortar_wall")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("irregular_andesite_stone_wall")
                .texture("block/1_basic_refined/1_stone/irregular_andesite_stone_wall")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("mud_brick")
                .texture("block/1_basic_refined/1_stone/mud_brick")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("red_granite_cobble")
                .texture("block/1_basic_refined/1_stone/2_granite/red_granite_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("graywacke_cobble")
                .texture("block/1_basic_refined/1_stone/graywacke_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("green_schist_cobble")
                .texture("block/1_basic_refined/1_stone/green_schist_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("blue_schist_cobble")
                .texture("block/1_basic_refined/1_stone/blue_schist_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("cliffstone_cobble")
                .texture("block/1_basic_refined/1_stone/cliffstone_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("light_red_sandstone_bricks", "light_red_sandstone_brick")
                .texture("block/1_basic_refined/1_stone/5_sandstone/light_red_sandstone_bricks")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("brown_oven_tiles")
                .texture("block/1_basic_refined/1_stone/1_clay/brown_oven_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("green_oven_tiles")
                .texture("block/1_basic_refined/1_stone/1_clay/green_oven_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("polished_blackstone")
                .texture("minecraft:block/polished_blackstone")
                .parent(Blocks.POLISHED_BLACKSTONE.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("polished_blackstone_bricks")
                .texture("minecraft:block/polished_blackstone_bricks")
                .parent(Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("cracked_polished_blackstone_bricks")
                .texture("minecraft:block/polished_blackstone_bricks")
                .parent(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState())
                .register(TypeList.of(ArchSmall.class, ArchSmallHalf.class, ArchTwoMeter.class, ArchTwoMeterHalf.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, Stairs.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("polished_deepslate")
                .texture("minecraft:block/polished_deepslate")
                .parent(Blocks.POLISHED_DEEPSLATE.defaultBlockState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("light_granite_cobble")
                .texture("block/1_basic_refined/1_stone/2_granite/light_granite_cobble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("tan_limestone_bricks")
                .texture("block/1_basic_refined/1_stone/3_limestone/tan_limestone_bricks")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("white_limestone_bricks")
                .texture("block/1_basic_refined/1_stone/3_limestone/white_limestone_bricks")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("medium_light_red_sandstone_bricks", "medium_light_red_sandstone_brick")
                .texture("block/1_basic_refined/1_stone/5_sandstone/medium_light_red_sandstone_bricks")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.COBBLE_AND_BRICK)
                .name("dark_light_red_sandstone_bricks", "dark_light_red_sandstone_brick")
                .texture("block/1_basic_refined/1_stone/5_sandstone/dark_light_red_sandstone_bricks")
                .register(types);
    }
}
