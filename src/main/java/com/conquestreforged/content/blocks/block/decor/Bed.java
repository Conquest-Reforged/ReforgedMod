package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.util.DyeColor;

@Render(RenderLayer.CUTOUT)
public class Bed extends BedBlock {

    public Bed(Settings properties) {
        super(DyeColor.WHITE, properties);
    }

    @Override
    public BlockRenderType getRenderType(BlockState p_49545_) {
        return BlockRenderType.MODEL;
    }

}