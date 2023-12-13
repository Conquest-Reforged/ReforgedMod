package com.conquestreforged.blocks.block.vanilla;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BambooBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class BambooVanilla extends BambooBlock {

    public BambooVanilla(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
        FluidState fluidstate = p_196258_1_.getLevel().getFluidState(p_196258_1_.getClickedPos());
        if (!fluidstate.isEmpty()) {
            return null;
        } else {
            BlockState blockstate = p_196258_1_.getLevel().getBlockState(p_196258_1_.getClickedPos().below());
            if (blockstate.is(BlockTags.BAMBOO_PLANTABLE_ON)) {
                if (blockstate.is(Blocks.BAMBOO_SAPLING)) {
                    return this.defaultBlockState().setValue(AGE, Integer.valueOf(0));
                } else if (blockstate.is(Blocks.BAMBOO)) {
                    int i = blockstate.getValue(AGE) > 0 ? 1 : 0;
                    return this.defaultBlockState().setValue(AGE, Integer.valueOf(i));
                } else {
                    BlockState blockstate1 = p_196258_1_.getLevel().getBlockState(p_196258_1_.getClickedPos().above());
                    return !blockstate1.is(Blocks.BAMBOO) && !blockstate1.is(Blocks.BAMBOO_SAPLING) ? this.defaultBlockState().setValue(AGE, Integer.valueOf(0)) : this.defaultBlockState().setValue(AGE, blockstate1.getValue(AGE));
                }
            } else {
                return null;
            }
        }
    }
}
