package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DiagonalBeamCentered extends WaterloggedHorizontalDirectionalShape {

    public static final VoxelShape EAST_WEST_SHAPE = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    public static final VoxelShape NORTH_SOUTH_SHAPE = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);

    public DiagonalBeamCentered(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(DIRECTION) == Direction.NORTH || state.getValue(DIRECTION) == Direction.SOUTH) {
            return NORTH_SOUTH_SHAPE;
        } else {
            return EAST_WEST_SHAPE;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = getDirection(context.getHorizontalDirection().getOpposite(), context.getClickedPos(), context);
        return super.getStateForPlacement(context).setValue(DIRECTION, facing);
    }

    public static Direction getDirection(Direction facing, BlockPos pos, BlockPlaceContext context) {
        switch (facing) {
            case NORTH: {
                return (!(context.getClickLocation().x - (double) pos.getX() > 0.5D)) ? facing.getOpposite() : facing;
            }
            case SOUTH: {
                return (!(context.getClickLocation().x - (double) pos.getX() < 0.5D)) ? facing.getOpposite() : facing;
            }
            case EAST: {
                return (!(context.getClickLocation().z - (double) pos.getZ() > 0.5D)) ? facing.getOpposite() : facing;
            }
            default: {
                return (!(context.getClickLocation().z - (double) pos.getZ() < 0.5D)) ? facing.getOpposite() : facing;
            }
        }
    }
}
