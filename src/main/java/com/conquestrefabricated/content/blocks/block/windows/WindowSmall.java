package com.conquestrefabricated.content.blocks.block.windows;

import com.conquestrefabricated.content.blocks.block.arch.Arch;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.properties.Waterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

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

    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty DOWN = Properties.DOWN;

    private static final VoxelShape TOPLEFT = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0D);
    private static final VoxelShape TOPRIGHT = Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
    private static final VoxelShape BOTTOMLEFT = Block.createCuboidShape(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape BOTTOMRIGHT = Block.createCuboidShape(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);

    private static final VoxelShape TOP_SOUTH = Block.createCuboidShape(4.0D, 13.5D, 12.0D, 12.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_WEST = Block.createCuboidShape(0.0D, 13.5D, 4.0D, 4.0D, 16.0D, 12.0D);
    private static final VoxelShape TOP_NORTH = Block.createCuboidShape(4.0D, 13.5D, 0.0D, 12.0D, 16.0D, 4.0D);
    private static final VoxelShape TOP_EAST = Block.createCuboidShape(12.0D, 13.5D, 4.0D, 16.0D, 16.0D, 12.0D);

    private static final VoxelShape BOTTOM_SOUTH = Block.createCuboidShape(4.0D, 0.0D, 12.0D, 12.0D, 2.5D, 16.0D);
    private static final VoxelShape BOTTOM_WEST = Block.createCuboidShape(0.0D, 0.0D, 4.0D, 4.0D, 2.5D, 12.0D);
    private static final VoxelShape BOTTOM_NORTH = Block.createCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 2.5D, 4.0D);
    private static final VoxelShape BOTTOM_EAST = Block.createCuboidShape(12.0D, 0.0D, 4.0D, 16.0D, 2.5D, 12.0D);

    private static final VoxelShape TOP_SHAPE = VoxelShapes.union(TOPLEFT, TOPRIGHT);
    private static final VoxelShape BOTTOM_SHAPE = VoxelShapes.union(BOTTOMLEFT, BOTTOMRIGHT);
    private static final VoxelShape SHAPE = VoxelShapes.union(TOP_SHAPE, BOTTOM_SHAPE);

    private static final VoxelShape UP_NESW = VoxelShapes.union(TOP_NORTH, VoxelShapes.union(TOP_EAST, VoxelShapes.union(TOP_SOUTH, TOP_WEST)));
    private static final VoxelShape DOWN_NESW = VoxelShapes.union(BOTTOM_NORTH, VoxelShapes.union(BOTTOM_EAST, VoxelShapes.union(BOTTOM_SOUTH, BOTTOM_WEST)));

    private static final VoxelShape UP_SHAPE = VoxelShapes.union(SHAPE, UP_NESW);
    private static final VoxelShape DOWN_SHAPE = VoxelShapes.union(SHAPE, DOWN_NESW);
    private static final VoxelShape UPDOWN_SHAPE = VoxelShapes.union(SHAPE, VoxelShapes.union(UP_NESW, DOWN_NESW));

    public WindowSmall(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(UP, false).with(DOWN, false).with(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(DOWN) == true && state.get(UP) == true) {
            return SHAPE;
        } else if (state.get(DOWN) == false && state.get(UP) == true) {
            return DOWN_SHAPE;
        } else if (state.get(DOWN) == true && state.get(UP) == false) {
            return UP_SHAPE;
        } else {
            return UPDOWN_SHAPE;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());
        BlockPos up = blockpos.up();
        BlockPos down = blockpos.down();

        BlockState BlockStateUp = iblockreader.getBlockState(up);
        BlockState BlockStateDown = iblockreader.getBlockState(down);
        return super.getPlacementState(context)
                .with(UP, this.attachesTo(BlockStateUp))
                .with(DOWN, this.attachesTo(BlockStateDown))
                .with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        boolean flag = this.canConnectTo(world, currentPos.up());
        boolean flag1 = this.canConnectTo(world, currentPos.down());
        return stateIn.with(UP, flag).with(DOWN, flag1);
    }

    private boolean attachesTo(BlockState blockstate) {
        Block block = blockstate.getBlock();
        return block != Blocks.BARRIER && (!(block != this && (!(block instanceof WindowSmall || block instanceof Arch))));
    }

    private boolean canConnectTo(WorldAccess world, BlockPos pos) {
        BlockState BlockState = world.getBlockState(pos);
        Block block = BlockState.getBlock();
        return block != Blocks.BARRIER && (!(block != this && !(block instanceof WindowSmall || block instanceof Arch)));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
}
