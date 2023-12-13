package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.Cube;
import com.conquestreforged.blocks.block.directional.HorizontalDirectional;
import com.conquestreforged.blocks.block.directional.LayerDirectional;
import com.conquestreforged.blocks.block.overlay_tinted.TintedOverlayLayer;
import com.conquestreforged.blocks.block.overlay_tinted.TintedOverlayStairs;
import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.world.level.block.Blocks;

public class DirtInit {

    public static void init(TypeList types, TypeList typesVanilla) {
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("light_cracked_dirt")
                .texture("block/8_topography/5_dirt/light_cracked_dirt")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("cracked_dirt")
                .texture("block/8_topography/5_dirt/cracked_dirt")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("gray_clay")
                .texture("minecraft:block/clay")
                .parent(Blocks.CLAY.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("dark_gray_clay")
                .texture("block/8_topography/3_sand_clay/dark_gray_clay")
                .register(types);
        VanillaProps.earth()
                .name("loamy_dirt")
                .texture("minecraft:block/dirt")
                .parent(Blocks.DIRT.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("directional_farmland")
                .manual()
                .with("hitBox", BlockVoxelShapes.cubeFullShape)
                .register(TypeList.of(HorizontalDirectional.class, LayerDirectional.class));
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("diagonally_plowed_farmland")
                .manual()
                .with("hitBox", BlockVoxelShapes.cubeFullShape)
                .register(TypeList.of(HorizontalDirectional.class, LayerDirectional.class));
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("unfertile_loamy_dirt")
                .texture("block/8_topography/5_dirt/unfertile_loamy_dirt")
                .register(TypeList.of(Cube.class));
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("loamy_dirt_with_bones")
                .texture("block/8_topography/5_dirt/loamy_dirt_with_bones")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("frozen_loamy_dirt")
                .texture("block/8_topography/5_dirt/frozen_loamy_dirt")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("rocky_soil")
                .texture("block/8_topography/5_dirt/rocky_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("mossy_soil")
                .texture("block/8_topography/5_dirt/mossy_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("silty_lorien_dirt")
                .texture("block/8_topography/5_dirt/silty_lorien_dirt")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("lichen_loamy_dirt")
                .texture("block/8_topography/5_dirt/lichen_loamy_dirt")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("cushion_moss_covered_loamy_dirt")
                .texture("block/8_topography/5_dirt/cushion_moss_covered_loamy_dirt")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("sandy_soil")
                .texture("block/8_topography/5_dirt/sandy_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("light_silt")
                .texture("block/8_topography/5_dirt/light_silt")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("chalky_soil")
                .texture("block/8_topography/5_dirt/chalky_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("rocky_sandy_soil")
                .texture("block/8_topography/5_dirt/rocky_sandy_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("dark_silt")
                .texture("block/8_topography/5_dirt/dark_silt")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("dark_sandy_soil")
                .texture("block/8_topography/5_dirt/dark_sandy_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("burnt_soil")
                .texture("block/8_topography/5_dirt/burnt_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("peat")
                .texture("top", "block/8_topography/5_dirt/peat_top")
                .texture("bottom", "block/8_topography/5_dirt/peat_top")
                .texture("*", "block/8_topography/5_dirt/peat")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("dark_fertile_soil")
                .texture("block/8_topography/5_dirt/dark_fertile_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("mud")
                .texture("block/8_topography/5_dirt/mud")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("clay_rich_mud")
                .texture("block/8_topography/5_dirt/clay_rich_mud")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("thick_mud")
                .texture("block/8_topography/5_dirt/thick_mud")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("ants_on_soil")
                .texture("block/8_topography/5_dirt/ants_on_soil")
                .register(types);
        VanillaProps.grassyEarth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("grassy_dirt")
                .texture("overlay", "block/8_topography/4_grass_leaves/grass_overlay")
                .texture("*", "block/8_topography/5_dirt/grassy_dirt")
                .parent(Blocks.COARSE_DIRT.defaultBlockState())
                .register(TypeList.of(TintedOverlayLayer.class, TintedOverlayStairs.class));
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("blue_soil")
                .texture("block/8_topography/5_dirt/blue_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("brown_earth")
                .texture("block/8_topography/5_dirt/brown_earth")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("copper_rich_soil")
                .texture("block/8_topography/5_dirt/copper_rich_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("ochre_soil")
                .texture("top", "block/8_topography/5_dirt/ochre_soil_top")
                .texture("bottom", "block/8_topography/5_dirt/ochre_soil_top")
                .texture("*", "block/8_topography/5_dirt/ochre_soil")
                .register(types);
        VanillaProps.earth()
                .group(ModGroups.GRASS_AND_DIRT)
                .name("red_earth")
                .texture("block/8_topography/5_dirt/red_earth")
                .register(types);
    }
}
