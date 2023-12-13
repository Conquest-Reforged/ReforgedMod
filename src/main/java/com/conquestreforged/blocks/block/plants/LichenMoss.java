package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import java.util.Map;
import java.util.Objects;

public class LichenMoss extends AbstractBush implements Waterloggable {

    public static final BooleanProperty DOWN = PipeBlock.DOWN;
    public static final BooleanProperty NORTH = PipeBlock.NORTH;
    public static final BooleanProperty EAST = PipeBlock.EAST;
    public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
    public static final BooleanProperty WEST = PipeBlock.WEST;
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((p_199775_0_) -> p_199775_0_.getKey().getAxis().isHorizontal()).collect(Util.toMap());

    public LichenMoss(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos blockpos1 = blockpos.m_142127_();
        BlockPos blockpos2 = blockpos.m_142126_();
        BlockPos blockpos3 = blockpos.m_142128_();
        BlockPos blockpos4 = blockpos.m_142125_();
        BlockPos blockposDown = blockpos.below();
        BlockState blockstate = iblockreader.getBlockState(blockpos1);
        BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos4);
        BlockState blockstateDown = iblockreader.getBlockState(blockposDown);
        return Objects.requireNonNull(super.getStateForPlacement(context)).setValue(NORTH, blockstate.isFaceSturdy(iblockreader, blockpos1, Direction.SOUTH)).setValue(EAST, blockstate1.isFaceSturdy(iblockreader, blockpos1, Direction.WEST)).setValue(SOUTH, blockstate2.isFaceSturdy(iblockreader, blockpos3, Direction.NORTH)).setValue(WEST, blockstate3.isFaceSturdy(iblockreader, blockpos4, Direction.EAST)).setValue(DOWN, blockstateDown.isFaceSturdy(iblockreader, blockposDown, Direction.DOWN)).setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? stateIn.setValue(PROPERTY_BY_DIRECTION.get(facing), facingState.isFaceSturdy(world, facingPos, facing.getOpposite())) : super.updateShape(stateIn, facing, facingState, world, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, DOWN, WATERLOGGED);
    }
}
