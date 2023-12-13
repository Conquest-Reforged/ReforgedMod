package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;

@Render(RenderLayer.CUTOUT)
public class Rail extends RailBlock {

    public Rail(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isFlexibleRail(BlockState state, BlockGetter world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canMakeSlopes(BlockState state, BlockGetter world, BlockPos pos) {
        return true;
    }

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isClientSide) {
            RailShape railshape = getRailDirection(state, worldIn, pos, null);
            this.updateState(state, worldIn, pos, blockIn);
        }
    }

}
