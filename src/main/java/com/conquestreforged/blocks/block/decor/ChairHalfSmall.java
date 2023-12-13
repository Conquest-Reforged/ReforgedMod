package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.tileentity.seat.SeatTileEntity;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

@Render(RenderLayer.CUTOUT)
public class ChairHalfSmall extends ChairHalf {

    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

    public ChairHalfSmall(Block.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SeatTileEntity(blockPos, blockState);
    }
}
