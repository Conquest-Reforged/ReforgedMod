package com.conquestreforged.content.blocks.init.blocks;


import com.conquestreforged.content.blocks.block.*;
import com.conquestreforged.content.blocks.block.damage.DamageBlock;
import com.conquestreforged.content.blocks.block.damage.DamageBlockLayer;
import com.conquestreforged.content.blocks.block.overlay_top.*;
import com.conquestreforged.content.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class RoughNaturalRockInit {

    public static void init(TypeList types, TypeList typesRocks, TypeList typesVanilla, TypeList typesRocksVanilla) {
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("prismarine")
                .texture("minecraft:block/prismarine")
                .parent(Blocks.PRISMARINE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("red_granite")
                .texture("block/8_topography/1_stone/red_granite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("gray_quartzite")
                .texture("block/8_topography/1_stone/gray_quartzite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("pink_quartzite")
                .texture("block/8_topography/1_stone/pink_quartzite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("yellow_quartzite")
                .texture("block/8_topography/1_stone/yellow_quartzite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("icy_limestone")
                .texture("block/8_topography/1_stone/icy_limestone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("mossy_limestone")
                .texture("block/8_topography/1_stone/mossy_limestone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("blue_schist")
                .texture("top", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("bottom", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("*", "block/8_topography/1_stone/blue_schist")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("lichen_blue_schist")
                .texture("top", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("bottom", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("*", "block/8_topography/1_stone/lichen_blue_schist")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("mossy_blue_schist")
                .texture("top", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("bottom", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("*", "block/8_topography/1_stone/mossy_blue_schist")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("weathered_blue_schist")
                .texture("top", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("bottom", "block/8_topography/1_stone/blue_schist_topbottom")
                .texture("*", "block/8_topography/1_stone/weathered_blue_schist")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("green_schist")
                .texture("top", "block/8_topography/1_stone/green_schist_topbottom")
                .texture("bottom", "block/8_topography/1_stone/green_schist_topbottom")
                .texture("*", "block/8_topography/1_stone/green_schist")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("serpentinite")
                .texture("block/8_topography/1_stone/serpentinite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("gneiss")
                .texture("block/8_topography/1_stone/gneiss")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("eroded_gneiss")
                .texture("block/8_topography/1_stone/eroded_gneiss")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("shale")
                .texture("top", "block/8_topography/1_stone/shale_topbottom")
                .texture("bottom", "block/8_topography/1_stone/shale_topbottom")
                .texture("*", "block/8_topography/1_stone/shale")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("graywacke")
                .texture("top", "block/8_topography/1_stone/graywacke_topbottom")
                .texture("bottom", "block/8_topography/1_stone/graywacke_topbottom")
                .texture("*", "block/8_topography/1_stone/graywacke")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("chalk")
                .texture("block/8_topography/1_stone/chalk")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("layered_chalk")
                .texture("block/8_topography/1_stone/layered_chalk")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("weathered_andesite")
                .texture("block/8_topography/1_stone/weathered_andesite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("weathered_granite")
                .texture("block/8_topography/1_stone/weathered_granite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("snowy_granite")
                .texture("block/8_topography/1_stone/snowy_granite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("orange_sandstone")
                .texture("top", "block/8_topography/1_stone/orange_sandstone_topbottom")
                .texture("bottom", "block/8_topography/1_stone/orange_sandstone_topbottom")
                .texture("*", "block/8_topography/1_stone/orange_sandstone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("mudstone")
                .texture("top", "block/8_topography/1_stone/mudstone_topbottom")
                .texture("bottom", "block/8_topography/1_stone/mudstone_topbottom")
                .texture("*", "block/8_topography/1_stone/mudstone")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("coastal_red_sandstone")
                .texture("top", "block/8_topography/1_stone/coastal_red_sandstone_topbottom")
                .texture("bottom", "block/8_topography/1_stone/coastal_red_sandstone_topbottom")
                .texture("*", "block/8_topography/1_stone/coastal_red_sandstone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("red_sandstone")
                .texture("top", "block/8_topography/1_stone/red_sandstone_topbottom")
                .texture("bottom", "block/8_topography/1_stone/red_sandstone_topbottom")
                .texture("*", "block/8_topography/1_stone/red_sandstone")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("mossy_red_sandstone")
                .texture("top", "block/8_topography/1_stone/mossy_red_sandstone_topbottom")
                .texture("bottom", "block/8_topography/1_stone/mossy_red_sandstone_topbottom")
                .texture("*", "block/8_topography/1_stone/mossy_red_sandstone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("tan_sandstone")
                .texture("top", "block/8_topography/1_stone/tan_sandstone_topbottom")
                .texture("bottom", "block/8_topography/1_stone/tan_sandstone_topbottom")
                .texture("*", "block/8_topography/1_stone/tan_sandstone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("brown_sandstone")
                .texture("top", "block/8_topography/1_stone/brown_sandstone_topbottom")
                .texture("bottom", "block/8_topography/1_stone/brown_sandstone_topbottom")
                .texture("*", "block/8_topography/1_stone/brown_sandstone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("light_brown_mudstone")
                .texture("block/8_topography/1_stone/light_brown_mudstone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("umbre_mudstone")
                .texture("minecraft:block/terracotta")
                .parent(Blocks.TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("light_mudstone")
                .texture("minecraft:block/white_terracotta")
                .parent(Blocks.WHITE_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("orange_mudstone")
                .texture("minecraft:block/orange_terracotta")
                .parent(Blocks.ORANGE_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("yellow_mudstone")
                .texture("minecraft:block/yellow_terracotta")
                .parent(Blocks.YELLOW_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("gray_cave_silt")
                .texture("minecraft:block/gray_terracotta")
                .parent(Blocks.GRAY_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("brown_mudstone")
                .texture("minecraft:block/brown_terracotta")
                .parent(Blocks.BROWN_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("red_mudstone")
                .texture("minecraft:block/red_terracotta")
                .parent(Blocks.RED_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("red_clay")
                .texture("block/8_topography/1_stone/red_clay")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("black_hardened_clay")
                .texture("minecraft:block/black_terracotta")
                .parent(Blocks.BLACK_TERRACOTTA.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("pahoehoe")
                .texture("block/8_topography/1_stone/pahoehoe")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("magma")
                .texture("minecraft:block/magma")
                .parent(Blocks.MAGMA_BLOCK.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("obsidian")
                .texture("minecraft:block/obsidian")
                .parent(Blocks.OBSIDIAN.getDefaultState())
                .register(typesRocksVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("rough_calcite")
                .texture("top", "block/8_topography/1_stone/rough_calcite_topbottom")
                .texture("bottom", "block/8_topography/1_stone/rough_calcite_topbottom")
                .texture("*", "block/8_topography/1_stone/rough_calcite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("end_stone")
                .texture("minecraft:block/end_stone")
                .parent(Blocks.END_STONE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("peridotite")
                .texture("minecraft:block/bedrock")
                .parent(Blocks.BEDROCK.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("snow_covered_icy_limestone")
                .manual()
                .register(TypeList.of(TopOverlayCube.class, TopOverlaySlab.class, TopOverlaySlabQuarter.class, TopOverlaySlabCorner.class, TopOverlaySlabEighth.class, TopOverlayVerticalSlabCorner.class, TopOverlayVerticalSlab.class, TopOverlayVerticalCorner.class, TopOverlayVerticalQuarter.class, TopOverlayStairs.class));
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("moss_covered_limestone")
                .texture("top", "block/8_topography/1_stone/moss_covered_limestone_top")
                .texture("bottom", "block/8_topography/1_stone/mossy_limestone")
                .texture("*", "block/8_topography/1_stone/moss_covered_limestone")
                .register(types);
        VanillaProps.ice()
                .group(ModGroups.WATER_AND_AIR)
                .name("dirty_glacier_ice")
                .texture("block/8_topography/7_ice_snow/dirty_glacier_ice")
                .register(types);
        VanillaProps.ice()
                .group(ModGroups.WATER_AND_AIR)
                .name("glacier_ice")
                .texture("block/8_topography/7_ice_snow/glacier_ice")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ANIMALS)
                .name("wall_of_skulls_and_bones")
                .texture("top", "block/9_organic/6_waste/bone_wall_with_skeleton_top")
                .texture("bottom", "block/9_organic/6_waste/bone_wall_with_skeleton_top")
                .texture("*", "block/9_organic/6_waste/wall_of_skulls_and_bones")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.ANIMALS)
                .name("bone_wall_with_skeleton")
                .texture("top", "block/9_organic/6_waste/bone_wall_with_skeleton_top")
                .texture("bottom", "block/9_organic/6_waste/bone_wall_with_skeleton_top")
                .texture("*", "block/9_organic/6_waste/bone_wall_with_skeleton")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("stack_of_coal")
                .texture("minecraft:block/coal_block")
                .parent(Blocks.COAL_BLOCK.getDefaultState())
                .register(TypeList.of(Layer.class));
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("stack_of_glowing_embers")
                .texture("block/8_topography/2_ores_crystals/stack_of_glowing_embers")
                .light(state -> 6)
                .register(TypeList.of(DamageBlock.class, DamageBlockLayer.class));
        VanillaProps.stone()
                .group(ModGroups.WATER_AND_AIR)
                .name("snow")
                .texture("minecraft:block/snow")
                .parent(Blocks.SNOW_BLOCK.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("tuff")
                .texture("*", "block/8_topography/1_stone/tuff")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("dark_tuff")
                .texture("*", "block/8_topography/1_stone/dark_tuff")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("light_tuff")
                .texture("*", "block/8_topography/1_stone/light_tuff")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("dark_obsidian")
                .texture("*", "block/8_topography/1_stone/dark_obsidian")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("rough_anorthosite")
                .texture("*", "block/8_topography/1_stone/rough_anorthosite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("weathered_anorthosite")
                .texture("*", "block/8_topography/1_stone/weathered_anorthosite")
                .register(types);

        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("blackstone")
                .texture("top", "minecraft:block/blackstone_top")
                .texture("bottom", "minecraft:block/blackstone_top")
                .texture("*", "minecraft:block/blackstone")
                .parent(Blocks.BLACKSTONE.getDefaultState())
                .register(TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("gilded_blackstone")
                .texture("*", "minecraft:block/gilded_blackstone")
                .parent(Blocks.GILDED_BLACKSTONE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("crying_obsidian")
                .texture("*", "minecraft:block/crying_obsidian")
                .parent(Blocks.CRYING_OBSIDIAN.getDefaultState())
                .register(typesVanilla);

        VanillaProps.stone()
                .group(ModGroups.ANIMALS)
                .name("crimson_shell_planks")
                .texture("*", "minecraft:block/crimson_planks")
                .register(TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.stone()
                .group(ModGroups.ANIMALS)
                .name("warped_planks")
                .texture("*", "minecraft:block/warped_planks")
                .register(TypeList.of(Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));

        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("weathered_basalt")
                .texture("*", "block/8_topography/1_stone/weathered_basalt")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("weathered_dacite")
                .texture("*", "block/8_topography/1_stone/weathered_dacite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("weathered_rhyolite")
                .texture("*", "block/8_topography/1_stone/weathered_rhyolite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("sulfur_pools")
                .texture("block/8_topography/3_sand_clay/sulfur_pools")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("raw_copper")
                .texture("minecraft:block/raw_copper_block")
                .parent(Blocks.RAW_COPPER_BLOCK.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("raw_gold")
                .texture("minecraft:block/raw_gold_block")
                .parent(Blocks.RAW_GOLD_BLOCK.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("raw_iron")
                .texture("minecraft:block/raw_iron_block")
                .parent(Blocks.RAW_IRON_BLOCK.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("calcite_and_limestone")
                .texture("minecraft:block/calcite")
                .parent(Blocks.CALCITE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("pumice")
                .texture("minecraft:block/smooth_basalt")
                .parent(Blocks.SMOOTH_BASALT.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("rough_end_stone")
                .texture("block/8_topography/1_stone/rough_end_stone")
                .register(types);
    }
}
