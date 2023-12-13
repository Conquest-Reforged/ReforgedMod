package com.conquestreforged.blocks.block.windows;

import com.conquestreforged.blocks.block.arch.Arch;
import com.conquestreforged.blocks.block.arch.ArchHalf;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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

    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;

    private static final VoxelShape TOPLEFT = Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0D);
    private static final VoxelShape TOPRIGHT = Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
    private static final VoxelShape BOTTOMLEFT = Block.box(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape BOTTOMRIGHT = Block.box(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);

    public static final VoxelShape SOUTH_SHAPE = Shapes.or(TOPLEFT, TOPRIGHT);
    public static final VoxelShape WEST_SHAPE = Shapes.or(BOTTOMRIGHT, TOPRIGHT);
    public static final VoxelShape NORTH_SHAPE = Shapes.or(BOTTOMLEFT, BOTTOMRIGHT);
    public static final VoxelShape EAST_SHAPE = Shapes.or(BOTTOMLEFT, TOPLEFT);

    private static final VoxelShape TOP_NORTH = Block.box(4.0D, 13.5D, 12.0D, 12.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_EAST = Block.box(0.0D, 13.5D, 4.0D, 4.0D, 16.0D, 12.0D);
    private static final VoxelShape TOP_SOUTH = Block.box(4.0D, 13.5D, 0.0D, 12.0D, 16.0D, 4.0D);
    private static final VoxelShape TOP_WEST = Block.box(12.0D, 13.5D, 4.0D, 16.0D, 16.0D, 12.0D);

    private static final VoxelShape BOTTOM_NORTH = Block.box(4.0D, 0.0D, 12.0D, 12.0D, 2.5D, 16.0D);
    private static final VoxelShape BOTTOM_EAST = Block.box(0.0D, 0.0D, 4.0D, 4.0D, 2.5D, 12.0D);
    private static final VoxelShape BOTTOM_SOUTH = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 2.5D, 4.0D);
    private static final VoxelShape BOTTOM_WEST = Block.box(12.0D, 0.0D, 4.0D, 16.0D, 2.5D, 12.0D);

    private static final VoxelShape UP_SOUTH_SHAPE = Shapes.or(SOUTH_SHAPE, TOP_SOUTH);
    private static final VoxelShape UP_WEST_SHAPE = Shapes.or(WEST_SHAPE, TOP_WEST);
    private static final VoxelShape UP_NORTH_SHAPE = Shapes.or(NORTH_SHAPE, TOP_NORTH);
    private static final VoxelShape UP_EAST_SHAPE = Shapes.or(EAST_SHAPE, TOP_EAST);

    private static final VoxelShape DOWN_SOUTH_SHAPE = Shapes.or(SOUTH_SHAPE, BOTTOM_SOUTH);
    private static final VoxelShape DOWN_WEST_SHAPE = Shapes.or(WEST_SHAPE, BOTTOM_WEST);
    private static final VoxelShape DOWN_NORTH_SHAPE = Shapes.or(NORTH_SHAPE, BOTTOM_NORTH);
    private static final VoxelShape DOWN_EAST_SHAPE = Shapes.or(EAST_SHAPE, BOTTOM_EAST);

    private static final VoxelShape UPDOWN_SOUTH_SHAPE = Shapes.or(SOUTH_SHAPE, Shapes.or(TOP_SOUTH, BOTTOM_SOUTH));
    private static final VoxelShape UPDOWN_WEST_SHAPE = Shapes.or(WEST_SHAPE, Shapes.or(TOP_WEST, BOTTOM_WEST));
    private static final VoxelShape UPDOWN_NORTH_SHAPE = Shapes.or(NORTH_SHAPE, Shapes.or(TOP_NORTH, BOTTOM_NORTH));
    private static final VoxelShape UPDOWN_EAST_SHAPE = Shapes.or(EAST_SHAPE, Shapes.or(TOP_EAST, BOTTOM_EAST));

    public WindowSmallHalf(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(DIRECTION, Direction.NORTH).setValue(UP, false).setValue(DOWN, false).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(DOWN) && state.getValue(UP)) {
            switch (state.getValue(DIRECTION)) {
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
        } else if (!state.getValue(DOWN) && state.getValue(UP)) {
            switch (state.getValue(DIRECTION)) {
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
        } else if (state.getValue(DOWN) && !state.getValue(UP)) {
            switch (state.getValue(DIRECTION)) {
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
            switch (state.getValue(DIRECTION)) {
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
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN);
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

        Direction facing = context.getHorizontalDirection().getOpposite();
        return super.getStateForPlacement(context)
                .setValue(DIRECTION, facing)
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
        return block != Blocks.BARRIER && (!(block != this && !(block instanceof WindowSmallHalf || block instanceof Arch || block instanceof ArchHalf)));
    }

    private boolean canConnectTo(LevelAccessor world, BlockPos pos) {
        BlockState BlockState = world.getBlockState(pos);
        Block block = BlockState.getBlock();
        return block != Blocks.BARRIER && (!(block != this && !(block instanceof WindowSmallHalf || block instanceof Arch || block instanceof ArchHalf)));
    }
}
