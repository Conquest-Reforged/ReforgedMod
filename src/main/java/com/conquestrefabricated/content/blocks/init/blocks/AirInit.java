package com.conquestrefabricated.content.blocks.init.blocks;

import com.conquestrefabricated.content.blocks.BlockVoxelShapes;
import com.conquestrefabricated.content.blocks.block.decor.ModelBlock;
import com.conquestrefabricated.content.blocks.block.glass.*;
import com.conquestrefabricated.content.blocks.block.topography.Cloud;
import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;


public class AirInit {

    public static final BlockSoundGroup WATER = new BlockSoundGroup(1.0F, 1.0F, SoundEvents.ITEM_BUCKET_EMPTY, SoundEvents.ITEM_BUCKET_EMPTY, SoundEvents.ITEM_BUCKET_EMPTY, SoundEvents.ITEM_BUCKET_EMPTY, SoundEvents.ITEM_BUCKET_EMPTY);

    public static void init() {
        VanillaProps.glass()
                .group(ModGroups.WATER_AND_AIR)
                .name("cloud")
                .sound(BlockSoundGroup.WOOL)
                .texture("block/8_topography/7_ice_snow/cloud/cloud")
                .blocking(false)
                .solid(false)
                .render(RenderLayer.TRANSLUCENT)
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WATER_AND_AIR)
                .name("thick_cloud")
                .sound(BlockSoundGroup.WOOL)
                .texture("block/8_topography/7_ice_snow/cloud/thick_cloud")
                .blocking(false)
                .solid(false)
                .render(RenderLayer.TRANSLUCENT)
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WATER_AND_AIR)
                .name("thin_cloud")
                .sound(BlockSoundGroup.WOOL)
                .texture("block/8_topography/7_ice_snow/cloud/thin_cloud")
                .blocking(false)
                .solid(false)
                .render(RenderLayer.TRANSLUCENT)
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.stone()
                .group(ModGroups.WATER_AND_AIR)
                .name("white_cloud")
                .sound(BlockSoundGroup.WOOL)
                .blocking(false)
                .solid(false)
                .manual()
                .register(TypeList.of(Cloud.class));
        VanillaProps.stone()
                .group(ModGroups.WATER_AND_AIR)
                .name("steam")
                .sound(BlockSoundGroup.WOOL)
                .manual()
                .blocking(false)
                .render(RenderLayer.CUTOUT)
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(ModelBlock.class));
        VanillaProps.stone()
                .group(ModGroups.WATER_AND_AIR)
                .name("smoke")
                .sound(BlockSoundGroup.WOOL)
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
