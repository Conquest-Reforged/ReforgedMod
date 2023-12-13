package com.conquestreforged.blocks.block.windows;

import com.conquestreforged.blocks.block.arch.Arch;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_small_window", template = "parent_window_small"),
        item = @Model(name = "item/%s_small_window", parent = "block/%s_window_small", template = "item/parent_window_small"),
        block = {
                @Model(name = "block/%s_window_small", template = "block/parent_window_small"),
                @Model(name = "block/%s_window_small_down", template = "block/parent_window_small_down"),
                @Model(name = "block/%s_window_small_up", template = "block/parent_window_small_up"),
                @Model(name = "block/%s_window_small_updown", template = "block/parent_window_small_updown"),
        }
)
public class WindowSmall extends Block implements Waterloggable {

    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;

    private static final VoxelShape TOPLEFT = Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0D);
    private static final VoxelShape TOPRIGHT = Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
    private static final VoxelShape BOTTOMLEFT = Block.box(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape BOTTOMRIGHT = Block.box(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);

    private static final VoxelShape TOP_SOUTH = Block.box(4.0D, 13.5D, 12.0D, 12.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_WEST = Block.box(0.0D, 13.5D, 4.0D, 4.0D, 16.0D, 12.0D);
    private static final VoxelShape TOP_NORTH = Block.box(4.0D, 13.5D, 0.0D, 12.0D, 16.0D, 4.0D);
    private static final VoxelShape TOP_EAST = Block.box(12.0D, 13.5D, 4.0D, 16.0D, 16.0D, 12.0D);

    private static final VoxelShape BOTTOM_SOUTH = Block.box(4.0D, 0.0D, 12.0D, 12.0D, 2.5D, 16.0D);
    private static final VoxelShape BOTTOM_WEST = Block.box(0.0D, 0.0D, 4.0D, 4.0D, 2.5D, 12.0D);
    private static final VoxelShape BOTTOM_NORTH = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 2.5D, 4.0D);
    private static final VoxelShape BOTTOM_EAST = Block.box(12.0D, 0.0D, 4.0D, 16.0D, 2.5D, 12.0D);

    private static final VoxelShape TOP_SHAPE = Shapes.or(TOPLEFT, TOPRIGHT);
    private static final VoxelShape BOTTOM_SHAPE = Shapes.or(BOTTOMLEFT, BOTTOMRIGHT);
    private static final VoxelShape SHAPE = Shapes.or(TOP_SHAPE, BOTTOM_SHAPE);

    private static final VoxelShape UP_NESW = Shapes.or(TOP_NORTH, Shapes.or(TOP_EAST, Shapes.or(TOP_SOUTH, TOP_WEST)));
    private static final VoxelShape DOWN_NESW = Shapes.or(BOTTOM_NORTH, Shapes.or(BOTTOM_EAST, Shapes.or(BOTTOM_SOUTH, BOTTOM_WEST)));

    private static final VoxelShape UP_SHAPE = Shapes.or(SHAPE, UP_NESW);
    private static final VoxelShape DOWN_SHAPE = Shapes.or(SHAPE, DOWN_NESW);
    private static final VoxelShape UPDOWN_SHAPE = Shapes.or(SHAPE, Shapes.or(UP_NESW, DOWN_NESW));

    public WindowSmall(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, false).setValue(DOWN, false).setValue(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(DOWN) == true && state.getValue(UP) == true) {
            return SHAPE;
        } else if (state.getValue(DOWN) == false && state.getValue(UP) == true) {
            return DOWN_SHAPE;
        } else if (state.getValue(DOWN) == true && state.getValue(UP) == false) {
            return UP_SHAPE;
        } else {
            return UPDOWN_SHAPE;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos up = blockpos.above();
        BlockPos down = blockpos.below();

        BlockState BlockStateUp = iblockreader.getBlockState(up);
        BlockState BlockStateDown = iblockreader.getBlockState(down);
        return super.getStateForPlacement(context)
                .setValue(UP, this.attachesTo(BlockStateUp))
                .setValue(DOWN, this.attachesTo(BlockStateDown))
                .setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        boolean flag = this.canConnectTo(world, currentPos.above());
        boolean flag1 = this.canConnectTo(world, currentPos.below());
        return stateIn.setValue(UP, flag).setValue(DOWN, flag1);
    }

    private boolean attachesTo(BlockState blockstate) {
        Block block = blockstate.getBlock();
        return block != Blocks.BARRIER && (!(block != this && (!(block instanceof WindowSmall || block instanceof Arch))));
    }

    private boolean canConnectTo(LevelAccessor world, BlockPos pos) {
        BlockState BlockState = world.getBlockState(pos);
        Block block = BlockState.getBlock();
        return block != Blocks.BARRIER && (!(block != this && !(block instanceof WindowSmall || block instanceof Arch)));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}
