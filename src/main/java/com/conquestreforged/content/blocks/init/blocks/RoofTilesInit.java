package com.conquestreforged.content.blocks.init.blocks;


import com.conquestreforged.content.blocks.block.*;
import com.conquestreforged.content.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class RoofTilesInit {

    public static void init(TypeList types, TypeList typesVanilla) {
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("dirty_blue_clay_beaver_tail_tiles", "dirty_blue_clay_beaver_tail_tile")
                .texture("minecraft:block/light_blue_terracotta")
                .parent(Blocks.LIGHT_BLUE_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("light_blue_clay_beaver_tail_tiles")
                .texture("block/1_basic_refined/2_roof/1_clay/light_blue_clay_beaver_tail_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("blue_clay_beaver_tail_tiles", "blue_clay_beaver_tail_tile")
                .texture("minecraft:block/blue_terracotta")
                .parent(Blocks.BLUE_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("blue_green_diamond_clay_shingles")
                .texture("block/1_basic_refined/2_roof/1_clay/blue_green_diamond_clay_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("overgrown_green_clay_shingles", "overgrown_green_clay_shingle")
                .texture("minecraft:block/lime_terracotta")
                .parent(Blocks.LIME_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("brown_gray_wood_shingles")
                .texture("block/1_basic_refined/2_roof/3_wood/brown_gray_wood_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("brown_red_wood_shingles")
                .texture("block/1_basic_refined/2_roof/3_wood/brown_red_wood_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("green_clay_shingles", "green_clay_shingle")
                .texture("minecraft:block/green_terracotta")
                .parent(Blocks.GREEN_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("pink_clay_tiles", "pink_clay_tile")
                .texture("minecraft:block/pink_terracotta")
                .parent(Blocks.PINK_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("red_clay_tiles")
                .texture("block/1_basic_refined/2_roof/1_clay/red_clay_tiles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("red_clay_beaver_tail_tiles")
                .texture("block/1_basic_refined/2_roof/1_clay/red_clay_beaver_tail_tiles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("brown_clay_beaver_tail_tiles")
                .texture("block/1_basic_refined/2_roof/1_clay/brown_clay_beaver_tail_tiles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("orange_clay_beaver_tail_tiles")
                .texture("block/1_basic_refined/2_roof/1_clay/orange_clay_beaver_tail_tiles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("pink_clay_beaver_tail_tiles")
                .texture("block/1_basic_refined/2_roof/1_clay/pink_clay_beaver_tail_tiles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("light_red_clay_beaver_tail_tiles")
                .texture("block/1_basic_refined/2_roof/1_clay/light_red_clay_beaver_tail_tiles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("light_cotswold_slate_tiles")
                .texture("block/1_basic_refined/2_roof/1_clay/light_cotswold_slate_tiles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("dark_red_diamond_clay_shingles")
                .texture("block/1_basic_refined/2_roof/1_clay/dark_red_diamond_clay_shingles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("dark_cotswold_slate_tiles")
                .texture("block/1_basic_refined/2_roof/1_clay/dark_cotswold_slate_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("terracotta_imbrices_and_tegulae")
                .texture("block/1_basic_refined/2_roof/1_clay/terracotta_imbrices_and_tegulae")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("old_slate_roof_tiles", "old_slate_roof_tile")
                .texture("minecraft:block/cyan_terracotta")
                .parent(Blocks.CYAN_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("dark_slate_roof_tiles")
                .texture("block/1_basic_refined/2_roof/dark_slate_roof_tiles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("blue_diamond_clay_shingles")
                .texture("block/1_basic_refined/2_roof/1_clay/blue_diamond_clay_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("gray_wood_diamond_shingles")
                .texture("block/1_basic_refined/2_roof/3_wood/gray_wood_diamond_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("brown_wood_diamond_shingles")
                .texture("block/1_basic_refined/2_roof/3_wood/brown_wood_diamond_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("gray_wood_shingles")
                .texture("block/1_basic_refined/2_roof/3_wood/gray_wood_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("brown_wood_shingles")
                .texture("block/1_basic_refined/2_roof/3_wood/brown_wood_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("orange_diamond_clay_shingles")
                .texture("block/1_basic_refined/2_roof/1_clay/orange_diamond_clay_shingles")
                .register(types);
        VanillaProps.metal()
                .group(ModGroups.ROOFING)
                .name("oxidized_copper_roof")
                .texture("block/1_basic_refined/2_roof/oxidized_copper_roof")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("red_diamond_clay_shingles")
                .texture("block/1_basic_refined/2_roof/1_clay/red_diamond_clay_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("red_diamond_slate_shingles")
                .texture("block/1_basic_refined/2_roof/1_clay/red_diamond_slate_shingles")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.ROOFING)
                .name("brown_diamond_clay_shingles")
                .texture("block/1_basic_refined/2_roof/1_clay/brown_diamond_clay_shingles")
                .register(types);
        VanillaProps.metal()
                .group(ModGroups.ROOFING)
                .name("cut_copper")
                .texture("minecraft:block/cut_copper")
                .parent(Blocks.WAXED_CUT_COPPER.getDefaultState())
                .register(TypeList.of(SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class, Capital.class));
        VanillaProps.metal()
                .group(ModGroups.ROOFING)
                .name("exposed_cut_copper")
                .texture("minecraft:block/exposed_cut_copper")
                .parent(Blocks.WAXED_EXPOSED_CUT_COPPER.getDefaultState())
                .register(TypeList.of(SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class, Capital.class));
        VanillaProps.metal()
                .group(ModGroups.ROOFING)
                .name("weathered_cut_copper")
                .texture("minecraft:block/weathered_cut_copper")
                .parent(Blocks.WAXED_WEATHERED_CUT_COPPER.getDefaultState())
                .register(TypeList.of(SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class, Capital.class));
        VanillaProps.metal()
                .group(ModGroups.ROOFING)
                .name("oxidized_cut_copper")
                .texture("minecraft:block/oxidized_cut_copper")
                .parent(Blocks.WAXED_OXIDIZED_CUT_COPPER.getDefaultState())
                .register(TypeList.of(SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class, Capital.class));
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("deepslate_tile")
                .texture("minecraft:block/deepslate_tiles")
                .parent(Blocks.DEEPSLATE_TILES.getDefaultState())
                .register(TypeList.of(SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Pillar.class, Capital.class));
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("cracked_deepslate_tile")
                .texture("minecraft:block/cracked_deepslate_tiles")
                .parent(Blocks.CRACKED_DEEPSLATE_TILES.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("brown_imbrices_and_tegulae")
                .texture("block/1_basic_refined/2_roof/1_clay/brown_imbrices_and_tegulae")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("dark_imbrices_and_tegulae")
                .texture("block/1_basic_refined/2_roof/1_clay/dark_imbrices_and_tegulae")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("dark_red_imbrices_and_tegulae")
                .texture("block/1_basic_refined/2_roof/1_clay/dark_red_imbrices_and_tegulae")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ROOFING)
                .name("red_imbrices_and_tegulae")
                .texture("block/1_basic_refined/2_roof/1_clay/red_imbrices_and_tegulae")
                .register(types);
    }
}