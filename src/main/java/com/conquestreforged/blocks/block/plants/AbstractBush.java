package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.util.PlacementHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class AbstractBush extends BushBlock {

    protected AbstractBush(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.mayPlaceOn(state, reader, pos);
        }
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return BlockVoxelShapes.cubeMediumLargePartialShape.get(0);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.canSurvive(state, reader, pos);
        }
        return true;
    }
}
