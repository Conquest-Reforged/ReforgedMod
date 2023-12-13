package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

@Render(RenderLayer.CUTOUT)
public class Bed extends BedBlock {

    public Bed(Properties properties) {
        super(DyeColor.WHITE, properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49545_) {
        return RenderShape.MODEL;
    }

}