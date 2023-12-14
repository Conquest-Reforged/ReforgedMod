package com.conquestreforged.content.blocks.block.decor;

import net.minecraft.block.BlockState;
import net.minecraft.block.ScaffoldingBlock;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class Scaffolding extends ScaffoldingBlock {

    public Scaffolding(Settings properties) {
        super(properties);
    }

    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        World level = context.getWorld();
        int i = getDistance1(level, blockpos);
        return this.getDefaultState().with(WATERLOGGED, level.getFluidState(blockpos).getFluid() == Fluids.WATER).with(DISTANCE, i).with(BOTTOM, this.shouldBeBottom(level, blockpos, i));
    }

    private boolean shouldBeBottom(BlockView blockGetter, BlockPos blockPos, int i) {
        return i > 0 && !blockGetter.getBlockState(blockPos.down()).isOf(this);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView levelReader, BlockPos blockPos) {
        return getDistance1(levelReader, blockPos) < 7;
    }

    public static int getDistance1(BlockView blockGetter, BlockPos blockPos) {
        BlockPos.Mutable blockpos$mutableblockpos = blockPos.mutableCopy().move(Direction.DOWN);
        BlockState blockstate = blockGetter.getBlockState(blockpos$mutableblockpos);
        int i = 7;
        if (blockstate.getBlock() instanceof ScaffoldingBlock) {
            i = blockstate.get(DISTANCE);
        } else if (blockstate.isSideSolidFullSquare(blockGetter, blockpos$mutableblockpos, Direction.UP)) {
            return 0;
        }

        for(Direction direction : Direction.Type.HORIZONTAL) {
            BlockState blockstate1 = blockGetter.getBlockState(blockpos$mutableblockpos.set(blockPos, direction));
            if (blockstate1.getBlock() instanceof ScaffoldingBlock) {
                i = Math.min(i, blockstate1.get(DISTANCE) + 1);
                if (i == 1) {
                    break;
                }
            }
        }

        return i;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld serverLevel, BlockPos blockPos, Random random) {
        int i = getDistance1(serverLevel, blockPos);
        BlockState blockstate = state.with(DISTANCE, Integer.valueOf(i)).with(BOTTOM, Boolean.valueOf(this.shouldBeBottom(serverLevel, blockPos, i)));
        if (blockstate.get(DISTANCE) == 7) {
            if (state.get(DISTANCE) == 7) {
                FallingBlockEntity.spawnFromBlock(serverLevel, blockPos, blockstate);
            } else {
                serverLevel.breakBlock(blockPos, true);
            }
        } else if (state != blockstate) {
            serverLevel.setBlockState(blockPos, blockstate, 3);
        }

    }


    public boolean isScaffolding(BlockState state, WorldView level, BlockPos pos, LivingEntity entity) {
        return true;
    }
}
