package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.decor.ModelBlock;
import com.conquestreforged.blocks.block.glass.*;
import com.conquestreforged.blocks.block.topography.Cloud;
import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.sounds.SoundEvents;


public class AirInit {

    public static final SoundType WATER = new SoundType(1.0F, 1.0F, SoundEvents.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY);

    public static void init() {
        VanillaProps.glass()
                .group(ModGroups.WATER_AND_AIR)
                .name("cloud")
                .sound(SoundType.WOOL)
                .texture("block/8_topography/7_ice_snow/cloud/cloud")
                .blocking(false)
                .solid(false)
                .render(RenderLayer.TRANSLUCENT)
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WATER_AND_AIR)
                .name("thick_cloud")
                .sound(SoundType.WOOL)
                .texture("block/8_topography/7_ice_snow/cloud/thick_cloud")
                .blocking(false)
                .solid(false)
                .render(RenderLayer.TRANSLUCENT)
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WATER_AND_AIR)
                .name("thin_cloud")
                .sound(SoundType.WOOL)
                .texture("block/8_topography/7_ice_snow/cloud/thin_cloud")
                .blocking(false)
                .solid(false)
                .render(RenderLayer.TRANSLUCENT)
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.stone()
                .group(ModGroups.WATER_AND_AIR)
                .name("white_cloud")
                .sound(SoundType.WOOL)
                .blocking(false)
                .solid(false)
                .manual()
                .register(TypeList.of(Cloud.class));
        VanillaProps.stone()
                .group(ModGroups.WATER_AND_AIR)
                .name("steam")
                .sound(SoundType.WOOL)
                .manual()
                .blocking(false)
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.stone()
                .group(ModGroups.WATER_AND_AIR)
                .name("smoke")
                .sound(SoundType.WOOL)
                .manual()
                .blocking(false)
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.stone()
                .group(ModGroups.WATER_AND_AIR)
                .name("waterfall")
                .sound(WATER)
                .texture("block/8_topography/7_ice_snow/waterfall")
                .blocking(false)
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));

    }
}
