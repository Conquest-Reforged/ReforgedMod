package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class DiagonalBeamCentered extends WaterloggedHorizontalDirectionalShape {

    public static final VoxelShape EAST_WEST_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    public static final VoxelShape NORTH_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);

    public DiagonalBeamCentered(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(DIRECTION) == Direction.NORTH || state.get(DIRECTION) == Direction.SOUTH) {
            return NORTH_SOUTH_SHAPE;
        } else {
            return EAST_WEST_SHAPE;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction facing = getDirection(context.getPlayerFacing().getOpposite(), context.getBlockPos(), context);
        return super.getPlacementState(context).with(DIRECTION, facing);
    }

    public static Direction getDirection(Direction facing, BlockPos pos, ItemPlacementContext context) {
        switch (facing) {
            case NORTH: {
                return (!(context.getHitPos().x - (double) pos.getX() > 0.5D)) ? facing.getOpposite() : facing;
            }
            case SOUTH: {
                return (!(context.getHitPos().x - (double) pos.getX() < 0.5D)) ? facing.getOpposite() : facing;
            }
            case EAST: {
                return (!(context.getHitPos().z - (double) pos.getZ() > 0.5D)) ? facing.getOpposite() : facing;
            }
            default: {
                return (!(context.getHitPos().z - (double) pos.getZ() < 0.5D)) ? facing.getOpposite() : facing;
            }
        }
    }
}
