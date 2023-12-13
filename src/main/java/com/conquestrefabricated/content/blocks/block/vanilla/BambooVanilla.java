package com.conquestrefabricated.content.blocks.block.vanilla;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.tag.BlockTags;

public class BambooVanilla extends BambooBlock {

    public BambooVanilla(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState());
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext p_196258_1_) {
        FluidState fluidstate = p_196258_1_.getWorld().getFluidState(p_196258_1_.getBlockPos());
        if (!fluidstate.isEmpty()) {
            return null;
        } else {
            BlockState blockstate = p_196258_1_.getWorld().getBlockState(p_196258_1_.getBlockPos().down());
            if (blockstate.isIn(BlockTags.BAMBOO_PLANTABLE_ON)) {
                if (blockstate.isOf(Blocks.BAMBOO_SAPLING)) {
                    return this.getDefaultState().with(AGE, Integer.valueOf(0));
                } else if (blockstate.isOf(Blocks.BAMBOO)) {
                    int i = blockstate.get(AGE) > 0 ? 1 : 0;
                    return this.getDefaultState().with(AGE, Integer.valueOf(i));
                } else {
                    BlockState blockstate1 = p_196258_1_.getWorld().getBlockState(p_196258_1_.getBlockPos().up());
                    return !blockstate1.isOf(Blocks.BAMBOO) && !blockstate1.isOf(Blocks.BAMBOO_SAPLING) ? this.getDefaultState().with(AGE, Integer.valueOf(0)) : this.getDefaultState().with(AGE, blockstate1.get(AGE));
                }
            } else {
                return null;
            }
        }
    }
}
