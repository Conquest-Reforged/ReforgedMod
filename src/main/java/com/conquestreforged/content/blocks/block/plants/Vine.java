package com.conquestreforged.content.blocks.block.plants;

import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class Vine extends VineBlock {

    public Vine(Settings properties) {
        super(properties);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        return true;
    }

    @Override
    public float getMaxHorizontalModelOffset() {
        return 0.0F;
    }

    @Override
    public float getVerticalModelOffsetMultiplier() {
        return 0.0F;
    }
}
