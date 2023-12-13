package com.conquestrefabricated.content.blocks.init.blocks;


import com.conquestrefabricated.content.blocks.block.*;
import com.conquestrefabricated.content.blocks.block.trees.Log;
import com.conquestrefabricated.content.blocks.block.windows.ArrowSlit;
import com.conquestrefabricated.content.blocks.block.windows.WindowSmall;
import com.conquestrefabricated.content.blocks.block.windows.WindowSmallHalf;
import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class SmoothNaturalRockInit {

    public static void init(TypeList types, TypeList typesRocks, TypeList typesVanillaNoWall, TypeList typesVanilla) {
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("limestone")
                .texture("minecraft:block/stone")
                .parent(Blocks.STONE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("pink_limestone")
                .texture("block/8_topography/1_stone/pink_limestone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("smooth_red_granite")
                .texture("block/8_topography/1_stone/smooth_red_granite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("light_limestone")
                .texture("minecraft:block/diorite")
                .parent(Blocks.DIORITE.getDefaultState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("dark_limestone")
                .texture("block/8_topography/1_stone/dark_limestone")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("andesite")
                .texture("minecraft:block/andesite")
                .parent(Blocks.ANDESITE.getDefaultState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("porous_andesite")
                .texture("block/8_topography/1_stone/porous_andesite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("warped_slate")
                .texture("block/8_topography/1_stone/warped_slate")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("coastal_warped_slate")
                .texture("block/8_topography/1_stone/coastal_warped_slate")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("wet_slate")
                .texture("block/8_topography/1_stone/wet_slate")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("slate")
                .texture("block/8_topography/1_stone/slate")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("columnal_basalt")
                .texture("top", "block/8_topography/1_stone/columnal_basalt_top")
                .texture("bottom", "block/8_topography/1_stone/columnal_basalt_top")
                .texture("end", "block/8_topography/1_stone/columnal_basalt_top")
                .texture("*", "block/8_topography/1_stone/columnal_basalt")
                .register(TypeList.of(Log.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("dark_rough_marble")
                .texture("block/8_topography/1_stone/dark_rough_marble")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("rough_marble")
                .texture("block/8_topography/1_stone/rough_marble")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("light_limestone_boulders")
                .texture("block/8_topography/1_stone/light_limestone_boulders")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("mossy_light_limestone_boulders")
                .texture("block/8_topography/1_stone/mossy_light_limestone_boulders")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("warped_sandstone")
                .texture("block/8_topography/1_stone/warped_sandstone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("granite")
                .texture("minecraft:block/granite")
                .parent(Blocks.GRANITE.getDefaultState())
                .register(typesVanillaNoWall);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("dripstone")
                .texture("top", "block/8_topography/1_stone/dripstone_topbottom")
                .texture("bottom", "block/8_topography/1_stone/dripstone_topbottom")
                .texture("*", "block/8_topography/1_stone/dripstone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("calcite")
                .texture("block/8_topography/1_stone/calcite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("smooth_obsidian")
                .texture("block/8_topography/1_stone/smooth_obsidian")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("smooth_tuff")
                .texture("block/8_topography/1_stone/smooth_tuff")
                .register(typesRocks);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("smooth_serpentinite")
                .texture("block/8_topography/1_stone/smooth_serpentinite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("smooth_anorthosite")
                .texture("block/8_topography/1_stone/smooth_anorthosite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("basalt")
                .texture("top", "minecraft::block/basalt_top")
                .texture("bottom", "minecraft::block/basalt_top")
                .texture("*", "minecraft::block/basalt_side")
                .register(TypeList.of(ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("columnar_andesite")
                .texture("top", "block/8_topography/1_stone/columnar_andesite_top")
                .texture("bottom", "block/8_topography/1_stone/columnar_andesite_top")
                .texture("end", "block/8_topography/1_stone/columnar_andesite_top")
                .texture("*", "block/8_topography/1_stone/columnar_andesite")
                .register(TypeList.of(Log.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("columnar_dacite")
                .texture("top", "block/8_topography/1_stone/columnar_dacite_top")
                .texture("bottom", "block/8_topography/1_stone/columnar_dacite_top")
                .texture("end", "block/8_topography/1_stone/columnar_dacite_top")
                .texture("*", "block/8_topography/1_stone/columnar_dacite")
                .register(TypeList.of(Log.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("columnar_rhyolite")
                .texture("top", "block/8_topography/1_stone/columnar_rhyolite_top")
                .texture("bottom", "block/8_topography/1_stone/columnar_rhyolite_top")
                .texture("end", "block/8_topography/1_stone/columnar_rhyolite_top")
                .texture("*", "block/8_topography/1_stone/columnar_rhyolite")
                .register(TypeList.of(Log.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));

        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("smooth_basalt")
                .texture("block/8_topography/1_stone/smooth_basalt")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("porous_basalt")
                .texture("block/8_topography/1_stone/porous_basalt")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("dacite")
                .texture("block/8_topography/1_stone/dacite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("porous_dacite")
                .texture("block/8_topography/1_stone/porous_dacite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("rhyolite")
                .texture("block/8_topography/1_stone/rhyolite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("porous_rhyolite")
                .texture("block/8_topography/1_stone/porous_rhyolite")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("tan_limestone")
                .texture("block/8_topography/1_stone/tan_limestone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("stained_tan_limestone")
                .texture("block/8_topography/1_stone/stained_tan_limestone")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.STONE)
                .name("smooth_end_stone")
                .texture("block/8_topography/1_stone/smooth_end_stone")
                .register(types);

    }
}
