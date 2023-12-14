package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RailBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

@Render(RenderLayer.CUTOUT)
public class Rail extends RailBlock {

    public Rail(Settings properties) {
        super(properties);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        return true;
    }


    public boolean isFlexibleRail(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }


    public boolean canMakeSlopes(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public void neighborUpdate(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isClient) {
            VoxelShape railshape = getOutlineShape(state, worldIn, pos, null);
            this.updateBlockState(state, worldIn, pos, blockIn);
        }
    }

}
