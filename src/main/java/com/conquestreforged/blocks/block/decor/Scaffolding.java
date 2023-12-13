package com.conquestreforged.blocks.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

import java.util.Random;

public class Scaffolding extends ScaffoldingBlock {

    public Scaffolding(Properties properties) {
        super(properties);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        int i = getDistance1(level, blockpos);
        return this.defaultBlockState().setValue(WATERLOGGED, level.getFluidState(blockpos).getType() == Fluids.WATER).setValue(DISTANCE, i).setValue(BOTTOM, this.isBottom(level, blockpos, i));
    }

    private boolean isBottom(BlockGetter blockGetter, BlockPos blockPos, int i) {
        return i > 0 && !blockGetter.getBlockState(blockPos.below()).is(this);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos blockPos) {
        return getDistance1(levelReader, blockPos) < 7;
    }

    public static int getDistance1(BlockGetter blockGetter, BlockPos blockPos) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = blockPos.mutable().move(Direction.DOWN);
        BlockState blockstate = blockGetter.getBlockState(blockpos$mutableblockpos);
        int i = 7;
        if (blockstate.getBlock() instanceof ScaffoldingBlock) {
            i = blockstate.getValue(DISTANCE);
        } else if (blockstate.isFaceSturdy(blockGetter, blockpos$mutableblockpos, Direction.UP)) {
            return 0;
        }

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate1 = blockGetter.getBlockState(blockpos$mutableblockpos.setWithOffset(blockPos, direction));
            if (blockstate1.getBlock() instanceof ScaffoldingBlock) {
                i = Math.min(i, blockstate1.getValue(DISTANCE) + 1);
                if (i == 1) {
                    break;
                }
            }
        }

        return i;
    }

    @Override
    public void m_7458_(BlockState state, ServerLevel serverLevel, BlockPos blockPos, Random random) {
        int i = getDistance1(serverLevel, blockPos);
        BlockState blockstate = state.setValue(DISTANCE, Integer.valueOf(i)).setValue(BOTTOM, Boolean.valueOf(this.isBottom(serverLevel, blockPos, i)));
        if (blockstate.getValue(DISTANCE) == 7) {
            if (state.getValue(DISTANCE) == 7) {
                FallingBlockEntity.fall(serverLevel, blockPos, blockstate);
            } else {
                serverLevel.destroyBlock(blockPos, true);
            }
        } else if (state != blockstate) {
            serverLevel.setBlock(blockPos, blockstate, 3);
        }

    }

    @Override
    public boolean isScaffolding(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
        return true;
    }
}
