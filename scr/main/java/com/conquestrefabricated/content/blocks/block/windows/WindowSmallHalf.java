package com.conquestrefabricated.content.blocks.block.windows;

import com.conquestrefabricated.content.blocks.block.arch.Arch;
import com.conquestrefabricated.content.blocks.block.arch.ArchHalf;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
        state = @State(name = "%s_small_window_half", template = "parent_window_small_half"),
        item = @Model(name = "item/%s_small_window_half", parent = "block/%s_window_small_half_updown", template = "item/parent_window_small_half"),
        block = {
                @Model(name = "block/%s_window_small_half", template = "block/parent_window_small_half"),
                @Model(name = "block/%s_window_small_half_down", template = "block/parent_window_small_half_down"),
                @Model(name = "block/%s_window_small_half_up", template = "block/parent_window_small_half_up"),
                @Model(name = "block/%s_window_small_half_updown", template = "block/parent_window_small_half_updown"),
        }
)
public class WindowSmallHalf extends WaterloggedHorizontalDirectionalShape {

    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty DOWN = Properties.DOWN;

    private static final VoxelShape TOPLEFT = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0D);
    private static final VoxelShape TOPRIGHT = Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
    private static final VoxelShape BOTTOMLEFT = Block.createCuboidShape(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape BOTTOMRIGHT = Block.createCuboidShape(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);

    public static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(TOPLEFT, TOPRIGHT);
    public static final VoxelShape WEST_SHAPE = VoxelShapes.union(BOTTOMRIGHT, TOPRIGHT);
    public static final VoxelShape NORTH_SHAPE = VoxelShapes.union(BOTTOMLEFT, BOTTOMRIGHT);
    public static final VoxelShape EAST_SHAPE = VoxelShapes.union(BOTTOMLEFT, TOPLEFT);

    private static final VoxelShape TOP_NORTH = Block.createCuboidShape(4.0D, 13.5D, 12.0D, 12.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_EAST = Block.createCuboidShape(0.0D, 13.5D, 4.0D, 4.0D, 16.0D, 12.0D);
    private static final VoxelShape TOP_SOUTH = Block.createCuboidShape(4.0D, 13.5D, 0.0D, 12.0D, 16.0D, 4.0D);
    private static final VoxelShape TOP_WEST = Block.createCuboidShape(12.0D, 13.5D, 4.0D, 16.0D, 16.0D, 12.0D);

    private static final VoxelShape BOTTOM_NORTH = Block.createCuboidShape(4.0D, 0.0D, 12.0D, 12.0D, 2.5D, 16.0D);
    private static final VoxelShape BOTTOM_EAST = Block.createCuboidShape(0.0D, 0.0D, 4.0D, 4.0D, 2.5D, 12.0D);
    private static final VoxelShape BOTTOM_SOUTH = Block.createCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 2.5D, 4.0D);
    private static final VoxelShape BOTTOM_WEST = Block.createCuboidShape(12.0D, 0.0D, 4.0D, 16.0D, 2.5D, 12.0D);

    private static final VoxelShape UP_SOUTH_SHAPE = VoxelShapes.union(SOUTH_SHAPE, TOP_SOUTH);
    private static final VoxelShape UP_WEST_SHAPE = VoxelShapes.union(WEST_SHAPE, TOP_WEST);
    private static final VoxelShape UP_NORTH_SHAPE = VoxelShapes.union(NORTH_SHAPE, TOP_NORTH);
    private static final VoxelShape UP_EAST_SHAPE = VoxelShapes.union(EAST_SHAPE, TOP_EAST);

    private static final VoxelShape DOWN_SOUTH_SHAPE = VoxelShapes.union(SOUTH_SHAPE, BOTTOM_SOUTH);
    private static final VoxelShape DOWN_WEST_SHAPE = VoxelShapes.union(WEST_SHAPE, BOTTOM_WEST);
    private static final VoxelShape DOWN_NORTH_SHAPE = VoxelShapes.union(NORTH_SHAPE, BOTTOM_NORTH);
    private static final VoxelShape DOWN_EAST_SHAPE = VoxelShapes.union(EAST_SHAPE, BOTTOM_EAST);

    private static final VoxelShape UPDOWN_SOUTH_SHAPE = VoxelShapes.union(SOUTH_SHAPE, VoxelShapes.union(TOP_SOUTH, BOTTOM_SOUTH));
    private static final VoxelShape UPDOWN_WEST_SHAPE = VoxelShapes.union(WEST_SHAPE, VoxelShapes.union(TOP_WEST, BOTTOM_WEST));
    private static final VoxelShape UPDOWN_NORTH_SHAPE = VoxelShapes.union(NORTH_SHAPE, VoxelShapes.union(TOP_NORTH, BOTTOM_NORTH));
    private static final VoxelShape UPDOWN_EAST_SHAPE = VoxelShapes.union(EAST_SHAPE, VoxelShapes.union(TOP_EAST, BOTTOM_EAST));

    public WindowSmallHalf(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(DIRECTION, Direction.NORTH).with(UP, false).with(DOWN, false).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(DOWN) && state.get(UP)) {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return NORTH_SHAPE;
                case SOUTH:
                    return SOUTH_SHAPE;
                case WEST:
                    return WEST_SHAPE;
                case EAST:
                    return EAST_SHAPE;
            }
        } else if (!state.get(DOWN) && state.get(UP)) {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return DOWN_NORTH_SHAPE;
                case SOUTH:
                    return DOWN_SOUTH_SHAPE;
                case WEST:
                    return DOWN_WEST_SHAPE;
                case EAST:
                    return DOWN_EAST_SHAPE;
            }
        } else if (state.get(DOWN) && !state.get(UP)) {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return UP_NORTH_SHAPE;
                case SOUTH:
                    return UP_SOUTH_SHAPE;
                case WEST:
                    return UP_WEST_SHAPE;
                case EAST:
                    return UP_EAST_SHAPE;
            }
        } else {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return UPDOWN_NORTH_SHAPE;
                case SOUTH:
                    return UPDOWN_SOUTH_SHAPE;
                case WEST:
                    return UPDOWN_WEST_SHAPE;
                case EAST:
                    return UPDOWN_EAST_SHAPE;
            }
        }

    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN);
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

        Direction facing = context.getPlayerFacing().getOpposite();
        return super.getPlacementState(context)
                .with(DIRECTION, facing)
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
        return block != Blocks.BARRIER && (!(block != this && !(block instanceof WindowSmallHalf || block instanceof Arch || block instanceof ArchHalf)));
    }

    private boolean canConnectTo(WorldAccess world, BlockPos pos) {
        BlockState BlockState = world.getBlockState(pos);
        Block block = BlockState.getBlock();
        return block != Blocks.BARRIER && (!(block != this && !(block instanceof WindowSmallHalf || block instanceof Arch || block instanceof ArchHalf)));
    }
}
