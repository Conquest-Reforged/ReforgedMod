package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.block.VerticalSlab;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class DiagonalBeam extends WaterloggedHorizontalDirectionalShape {

    public static final EnumProperty<DoorHinge> HINGE = Properties.DOOR_HINGE;

    public DiagonalBeam(Settings properties) {
        super(properties);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        Direction facingHorizontal = context.getPlayerFacing().getOpposite();
        BlockState state2 = getDefaultState().with(DIRECTION, facingHorizontal).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
        return state2.with(HINGE, this.getHingeSide(context));
    }

    private DoorHinge getHingeSide(ItemPlacementContext p_208073_1_) {
        BlockView iblockreader = p_208073_1_.getWorld();
        BlockPos blockpos = p_208073_1_.getBlockPos();
        Direction direction = p_208073_1_.getPlayerFacing();
        BlockPos blockpos1 = blockpos.up();
        Direction direction1 = direction.rotateYCounterclockwise();
        BlockPos blockpos2 = blockpos.offset(direction1);
        BlockState blockstate = iblockreader.getBlockState(blockpos2);
        BlockPos blockpos3 = blockpos1.offset(direction1);
        BlockState blockstate1 = iblockreader.getBlockState(blockpos3);
        Direction direction2 = direction.rotateYClockwise();
        BlockPos blockpos4 = blockpos.offset(direction2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos4);
        BlockPos blockpos5 = blockpos1.offset(direction2);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos5);
        int i = (blockstate.isFullCube(iblockreader, blockpos2) ? -1 : 0) + (blockstate1.isFullCube(iblockreader, blockpos3) ? -1 : 0) + (blockstate2.isFullCube(iblockreader, blockpos4) ? 1 : 0) + (blockstate3.isFullCube(iblockreader, blockpos5) ? 1 : 0);
        if (i <= 0) {
            if (i >= 0) {
                int j = direction.getOffsetX();
                int k = direction.getOffsetZ();
                Vec3d vec3d = p_208073_1_.getHitPos();
                double d0 = vec3d.x - (double) blockpos.getX();
                double d1 = vec3d.z - (double) blockpos.getZ();
                return (j >= 0 || !(d1 < 0.5D)) && (j <= 0 || !(d1 > 0.5D)) && (k >= 0 || !(d0 > 0.5D)) && (k <= 0 || !(d0 < 0.5D)) ? DoorHinge.RIGHT : DoorHinge.LEFT;
            } else {
                return DoorHinge.RIGHT;
            }
        } else {
            return DoorHinge.LEFT;
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(HINGE);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
            case NORTH:
                return VerticalSlab.NORTH_SHAPE[1];
            case SOUTH:
                return VerticalSlab.SOUTH_SHAPE[1];
            case EAST:
                return VerticalSlab.EAST_SHAPE[1];
            default:
                return VerticalSlab.WEST_SHAPE[1];
        }
    }
}
