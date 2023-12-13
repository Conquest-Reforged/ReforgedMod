package com.conquestrefabricated.content.blocks.init.blocks;


import com.conquestrefabricated.content.blocks.block.*;
import com.conquestrefabricated.content.blocks.block.grass.Grass;
import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class GrassGroundInit {

    public static void init(TypeList types) {
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("grass_covered_limestone")
                .manual()
                .grassColor()
                .register(TypeList.of(Grass.class));
        VanillaProps.grassLike()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("grass_covered_limestone")
                .family("grass_covered_limestone")
                .parent(Blocks.GRASS_BLOCK.getDefaultState())
                .manual()
                .grassColor()
                .register(TypeList.of(Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.grassLike()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("grass_block")
                .manual()
                .parent(Blocks.GRASS_BLOCK.getDefaultState())
                .grassColor()
                .register(TypeList.of(Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("clover_covered_grass")
                .manual()
                .grassColor()
                .register(TypeList.of(Grass.class));
        VanillaProps.grassLike()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("clover_covered_grass")
                .family("clover_covered_grass")
                .parent(Blocks.GRASS_BLOCK.getDefaultState())
                .manual()
                .grassColor()
                .register(TypeList.of(Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("brown_sphagnum_moss_block")
                .texture("block/8_topography/4_grass_leaves/brown_sphagnum_moss")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("green_sphagnum_moss_block")
                .texture("block/8_topography/4_grass_leaves/green_sphagnum_moss")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("light_green_sphagnum_moss_block")
                .texture("block/8_topography/4_grass_leaves/light_green_sphagnum_moss")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("red_sphagnum_moss_block")
                .texture("block/8_topography/4_grass_leaves/red_sphagnum_moss")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("yellow_sphagnum_moss_block")
                .texture("block/8_topography/4_grass_leaves/yellow_sphagnum_moss")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("mycelium")
                .texture("top", "minecraft:block/mycelium_top")
                .texture("bottom", "minecraft:block/dirt")
                .texture("texture", "minecraft:block/mycelium_top")
                .texture("*", "minecraft:block/mycelium_side")
                .parent(Blocks.MYCELIUM.getDefaultState())
                .register(TypeList.of(Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("vibrant_autumnal_forest_floor")
                .texture("top", "minecraft:block/podzol_top")
                .texture("bottom", "minecraft:block/dirt")
                .texture("texture", "minecraft:block/podzol_top")
                .texture("*", "minecraft:block/podzol_side")
                .parent(Blocks.PODZOL.getDefaultState())
                .register(TypeList.of(Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("taiga_forest_floor")
                .texture("top", "block/8_topography/4_grass_leaves/taiga_forest_floor")
                .texture("bottom", "minecraft:block/dirt")
                .texture("texture", "block/8_topography/4_grass_leaves/taiga_forest_floor")
                .texture("*", "block/8_topography/4_grass_leaves/taiga_forest_floor_side")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("fir_forest_floor")
                .texture("bottom", "minecraft:block/dirt")
                .texture("*", "block/8_topography/4_grass_leaves/fir_forest_floor")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("autumnal_forest_floor_with_roots")
                .texture("bottom", "minecraft:block/dirt")
                .texture("*", "block/8_topography/4_grass_leaves/autumnal_forest_floor_with_roots")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("mossy_forest_floor_with_roots")
                .texture("bottom", "minecraft:block/dirt")
                .texture("*", "block/8_topography/4_grass_leaves/mossy_forest_floor_with_roots")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("muddy_autumnal_forest_floor")
                .texture("bottom", "minecraft:block/dirt")
                .texture("*", "block/8_topography/4_grass_leaves/muddy_autumnal_forest_floor")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("autumnal_forest_floor")
                .texture("bottom", "minecraft:block/dirt")
                .texture("*", "block/8_topography/4_grass_leaves/autumnal_forest_floor")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("lorien_forest_floor")
                .texture("bottom", "minecraft:block/dirt")
                .texture("*", "block/8_topography/4_grass_leaves/lorien_forest_floor")
                .register(types);
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("mossy_lorien_forest_floor")
                .texture("bottom", "minecraft:block/dirt")
                .texture("*", "block/8_topography/4_grass_leaves/mossy_lorien_forest_floor")
                .register(types);

        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("crimson_nylium")
                .texture("top", "minecraft:block/crimson_nylium")
                .texture("bottom", "minecraft:block/soul_sand")
                .texture("texture", "minecraft:block/crimson_nylium")
                .texture("*", "minecraft:block/crimson_nylium_side")
                .parent(Blocks.CRIMSON_NYLIUM.getDefaultState())
                .register(TypeList.of(Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("warped_nylium")
                .texture("top", "minecraft:block/warped_nylium")
                .texture("bottom", "minecraft:block/soul_sand")
                .texture("texture", "minecraft:block/warped_nylium")
                .texture("*", "minecraft:block/warped_nylium_side")
                .parent(Blocks.WARPED_NYLIUM.getDefaultState())
                .register(TypeList.of(Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.earth()
                .group(ModGroups.GRASSES_AND_SHRUBS)
                .name("nether_wart_block")
                .texture("*", "minecraft:block/nether_wart_block")
                .parent(Blocks.NETHER_WART_BLOCK.getDefaultState())
                .register(TypeList.of(Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.earth()
                .group(ModGroups.GRASSES_AND_SHRUBS)
                .name("warped_wart_block")
                .texture("*", "minecraft:block/warped_wart_block")
                .parent(Blocks.WARPED_WART_BLOCK.getDefaultState())
                .register(TypeList.of(Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.logs()
                .group(ModGroups.GRASSES_AND_SHRUBS)
                .name("crimson_stem")
                .texture("*", "minecraft:block/crimson_stem")
                .parent(Blocks.CRIMSON_HYPHAE.getDefaultState())
                .register(TypeList.of(VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.logs()
                .group(ModGroups.GRASSES_AND_SHRUBS)
                .name("stripped_crimson_stem")
                .texture("*", "minecraft:block/stripped_crimson_stem")
                .parent(Blocks.STRIPPED_CRIMSON_HYPHAE.getDefaultState())
                .register(TypeList.of(VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.logs()
                .group(ModGroups.GRASSES_AND_SHRUBS)
                .name("warped_stem")
                .texture("*", "minecraft:block/warped_stem")
                .parent(Blocks.WARPED_HYPHAE.getDefaultState())
                .register(TypeList.of(VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.logs()
                .group(ModGroups.GRASSES_AND_SHRUBS)
                .name("stripped_warped_stem")
                .texture("*", "minecraft:block/stripped_warped_stem")
                .parent(Blocks.STRIPPED_WARPED_HYPHAE.getDefaultState())
                .register(TypeList.of(VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.grass()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("taiga_grass")
                .manual()
                .grassColor()
                .register(TypeList.of(Grass.class));
        VanillaProps.grassLike()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("taiga_grass")
                .family("taiga_grass")
                .parent(Blocks.GRASS_BLOCK.getDefaultState())
                .manual()
                .grassColor()
                .register(TypeList.of(Layer.class, Stairs.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.grassLike()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("shredded_leaves")
                .texture("block/8_topography/4_grass_leaves/shredded_leaves")
                .register(types);
    }
}
