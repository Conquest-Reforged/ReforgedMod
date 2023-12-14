package com.conquestreforged.content.blocks.init.blocks;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.content.blocks.block.*;
import com.conquestreforged.content.blocks.block.decor.ModelBlock;
import com.conquestreforged.content.blocks.block.directional.DirectionalWaterlogged;
import com.conquestreforged.content.blocks.block.directional.HalfDirectionalWaterlogged;
import com.conquestreforged.content.blocks.block.directional.HorizontalDirectional;
import com.conquestreforged.content.blocks.block.directional.SlabDirectionalWaterlogged;
import com.conquestreforged.content.blocks.block.pipes.*;
import com.conquestreforged.content.blocks.block.trees.Log;
import com.conquestreforged.content.blocks.block.windows.ArrowSlit;
import com.conquestreforged.content.blocks.block.windows.WindowSmall;
import com.conquestreforged.content.blocks.block.windows.WindowSmallHalf;
import com.conquestreforged.content.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Blocks;

public class MetalInit {
    public static void init() {
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_rusted_metal_tiles", "old_rusted_metal_tile")
                .texture("minecraft:block/nether_bricks")
                .parent(Blocks.NETHER_BRICKS.getDefaultState())
                .register(TypeList.of(ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_rusted_metal_block")
                .texture("minecraft:block/red_nether_bricks")
                .parent(Blocks.RED_NETHER_BRICKS.getDefaultState())
                .register(TypeList.of(ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_rusted_large_metal_brick")
                .texture("block/2_advanced_refined/2_metal/old_rusted_large_metal_brick")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("large_red_painted_tile")
                .texture("block/2_advanced_refined/1_stone/large_red_painted_tile")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("metal_plating")
                .texture("block/2_advanced_refined/2_metal/metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/rusted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("black_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/black_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusted_black_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/rusted_black_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("blue_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/blue_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusted_blue_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/rusted_blue_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("gray_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/gray_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusted_gray_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/rusted_gray_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("light_gray_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/light_gray_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusted_light_gray_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/rusted_light_gray_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("red_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/red_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusted_red_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/rusted_red_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("white_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/white_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusted_white_painted_metal_plating")
                .texture("block/2_advanced_refined/2_metal/rusted_white_painted_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("iron_artillery_block")
                .manual()
                .register(TypeList.of(Log.class, SlabDirectionalWaterlogged.class, SlabQuarterNoLayers.class, SlabEighth.class, Stairs.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("iron_artillery_block_vertical_slab")
                .family("iron_artillery_block")
                .manual()
                .with("hitBox", BlockVoxelShapes.verticalSlabShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("iron_artillery_block_vertical_quarter")
                .family("iron_artillery_block")
                .manual()
                .with("hitBox", BlockVoxelShapes.verticalQuarterShapes)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("blue_shipping_container")
                .texture("block/2_advanced_refined/2_metal/blue_shipping_container")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("green_shipping_container")
                .texture("block/2_advanced_refined/2_metal/green_shipping_container")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("red_shipping_container")
                .texture("block/2_advanced_refined/2_metal/red_shipping_container")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("tan_shipping_container")
                .texture("block/2_advanced_refined/2_metal/tan_shipping_container")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("yellow_shipping_container")
                .texture("block/2_advanced_refined/2_metal/yellow_shipping_container")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("black_shipping_container")
                .texture("block/2_advanced_refined/2_metal/black_shipping_container")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("gray_shipping_container")
                .texture("block/2_advanced_refined/2_metal/gray_shipping_container")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("white_shipping_container")
                .texture("block/2_advanced_refined/2_metal/white_shipping_container")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("cross_hatched_metal_plating")
                .texture("block/2_advanced_refined/2_metal/cross_hatched_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusted_cross_hatched_metal_plating")
                .texture("block/2_advanced_refined/2_metal/rusted_cross_hatched_metal_plating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("corrugated_metal")
                .texture("block/2_advanced_refined/2_metal/corrugated_metal")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("damaged_corrugated_metal")
                .texture("block/2_advanced_refined/2_metal/damaged_corrugated_metal")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("rusted_corrugated_metal")
                .texture("block/2_advanced_refined/2_metal/rusted_corrugated_metal")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("steel_grating")
                .texture("block/2_advanced_refined/2_metal/steel_grating")
                .register(TypeList.of(Cube.class, ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("pipe")
                .name("mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("pipe")
                .name("6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("pipe")
                .name("5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("pipe")
                .name("3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("pipe")
                .name("elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("pipe")
                .name("gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("pipe")
                .name("ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("pipe")
                .name("4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("pipe")
                .name("cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("pipe")
                .name("t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("old_pipe")
                .name("old_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("black_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("black_pipe")
                .name("black_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_black_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("old_black_pipe")
                .name("old_black_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("blue_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("blue_pipe")
                .name("blue_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_blue_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("old_blue_pipe")
                .name("old_blue_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("green_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("green_pipe")
                .name("green_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_green_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("old_green_pipe")
                .name("old_green_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("red_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("red_pipe")
                .name("red_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_red_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("old_red_pipe")
                .name("old_red_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("yellow_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("yellow_pipe")
                .name("yellow_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_yellow_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("old_yellow_pipe")
                .name("old_yellow_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("brown_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("brown_pipe")
                .name("brown_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));

        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_brown_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(Pipe.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_mounted_pipe")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_6_way_flange")
                .with("hitBox", BlockVoxelShapes.sixWayFlangeShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_5_way_flange")
                .with("hitBox", BlockVoxelShapes.fiveWayFlangeShapes)
                .register(TypeList.of(DirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_3_way_flange")
                .with("hitBox", BlockVoxelShapes.threeWayFlangeShapes)
                .register(TypeList.of(HalfDirectionalWaterlogged.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_elbow_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(ElbowFlange.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_gate_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(MountedPipe.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_ball_valve")
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(BallValve.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_4_way_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(FourWayFlange.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_cross_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(CrossFlange.class));
        VanillaProps.metal()
                .family("old_brown_pipe")
                .name("old_brown_t_flange")
                .with("hitBox", BlockVoxelShapes.pillarShape)
                .register(TypeList.of(t_Flange.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("old_rusted_metal_panel")
                .texture("minecraft:block/chiseled_nether_bricks")
                .parent(Blocks.CHISELED_NETHER_BRICKS.getDefaultState())
                .register(TypeList.of(ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("cracked_old_rusted_metal")
                .texture("minecraft:block/cracked_nether_bricks")
                .parent(Blocks.CRACKED_NETHER_BRICKS.getDefaultState())
                .register(TypeList.of(ArrowSlit.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Slab.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class));

    }
}
