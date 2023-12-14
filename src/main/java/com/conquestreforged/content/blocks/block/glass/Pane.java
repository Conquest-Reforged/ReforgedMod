package com.conquestreforged.content.blocks.block.glass;

import com.conquestreforged.content.blocks.block.*;
import com.conquestreforged.content.blocks.block.arch.Arch;
import com.conquestreforged.content.blocks.block.arch.ArchHalf;
import com.conquestreforged.content.blocks.block.arch.ArchSmall;
import com.conquestreforged.content.blocks.block.arch.ArchTwoMeter;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.*;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.block.enums.StairShape;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

@Assets(
        state = @State(name = "%s_pane", template = "parent_pane"),
        item = @Model(name = "item/%s_pane", parent = "block/%s_pane_ns", template = "item/parent_pane"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_pane_n", template = "block/parent_flatpane_n"),
                @Model(name = "block/%s_pane_ne", template = "block/parent_flatpane_ne"),
                @Model(name = "block/%s_pane_ns", template = "block/parent_flatpane_ns"),
                @Model(name = "block/%s_pane_nse", template = "block/parent_flatpane_nse"),
                @Model(name = "block/%s_pane_nsew", template = "block/parent_flatpane_nsew"),
                @Model(name = "block/%s_pane_post", template = "block/parent_flatpane_post"),
                @Model(name = "block/%s_pane_n_up", template = "block/parent_flatpane_n_up"),
                @Model(name = "block/%s_pane_ne_up", template = "block/parent_flatpane_ne_up"),
                @Model(name = "block/%s_pane_ns_up", template = "block/parent_flatpane_ns_up"),
                @Model(name = "block/%s_pane_nse_up", template = "block/parent_flatpane_nse_up"),
                @Model(name = "block/%s_pane_nsew_up", template = "block/parent_flatpane_nsew_up"),
                @Model(name = "block/%s_pane_post_up", template = "block/parent_flatpane_post_up"),
                @Model(name = "block/%s_pane_n_updown", template = "block/parent_flatpane_n_updown"),
                @Model(name = "block/%s_pane_ne_updown", template = "block/parent_flatpane_ne_updown"),
                @Model(name = "block/%s_pane_ns_updown", template = "block/parent_flatpane_ns_updown"),
                @Model(name = "block/%s_pane_nse_updown", template = "block/parent_flatpane_nse_updown"),
                @Model(name = "block/%s_pane_nsew_updown", template = "block/parent_flatpane_nsew_updown"),
                @Model(name = "block/%s_pane_post_updown", template = "block/parent_flatpane_post_updown"),
                @Model(name = "block/%s_pane_n_down", template = "block/parent_flatpane_n_down"),
                @Model(name = "block/%s_pane_ne_down", template = "block/parent_flatpane_ne_down"),
                @Model(name = "block/%s_pane_ns_down", template = "block/parent_flatpane_ns_down"),
                @Model(name = "block/%s_pane_nse_down", template = "block/parent_flatpane_nse_down"),
                @Model(name = "block/%s_pane_nsew_down", template = "block/parent_flatpane_nsew_down"),
                @Model(name = "block/%s_pane_post_down", template = "block/parent_flatpane_post_down")
        }
)
public class Pane extends PaneBlock {

    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty DOWN = Properties.DOWN;

    public Pane(Settings properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return facing.getAxis().isHorizontal() ? stateIn.with(FACING_PROPERTIES.get(facing),
                this.canAttach(facingState, facingState.isSideSolidFullSquare(world, facingPos, facing.getOpposite()), facing.getOpposite()))
                .with(UP, canAttachAbove(world, currentPos.up(), stateIn))
                .with(DOWN, canAttachBelow(world, currentPos.down(), stateIn)) :

                super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos)
                        .with(UP, canAttachAbove(world, currentPos.up(), stateIn))
                        .with(DOWN, canAttachBelow(world, currentPos.down(), stateIn));

    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());
        BlockPos blockposNorth = blockpos.north();
        BlockPos blockposSouth = blockpos.south();
        BlockPos blockposWest = blockpos.west();
        BlockPos blockposEast = blockpos.east();
        BlockState blockstateNorth = iblockreader.getBlockState(blockposNorth);
        BlockState blockstateSouth = iblockreader.getBlockState(blockposSouth);
        BlockState blockstateWest = iblockreader.getBlockState(blockposWest);
        BlockState blockstateEast = iblockreader.getBlockState(blockposEast);

        BlockPos blockposUp = blockpos.up();
        BlockState blockstateUp = iblockreader.getBlockState(blockposUp);
        BlockPos blockposDown = blockpos.down();
        BlockState blockstateDown = iblockreader.getBlockState(blockposDown);

        boolean attachedNorth = this.canAttach(blockstateNorth, blockstateNorth.isSideSolidFullSquare(iblockreader, blockposNorth, Direction.SOUTH), Direction.SOUTH);
        boolean attachedEast = this.canAttach(blockstateEast, blockstateEast.isSideSolidFullSquare(iblockreader, blockposEast, Direction.WEST), Direction.WEST);
        boolean attachedSouth = this.canAttach(blockstateSouth, blockstateSouth.isSideSolidFullSquare(iblockreader, blockposSouth, Direction.NORTH), Direction.NORTH);
        boolean attachedWest = this.canAttach(blockstateWest, blockstateWest.isSideSolidFullSquare(iblockreader, blockposWest, Direction.EAST), Direction.EAST);

        return this.getDefaultState()
                .with(NORTH, attachedNorth)
                .with(EAST, attachedEast)
                .with(SOUTH, attachedSouth)
                .with(WEST, attachedWest)
                .with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER)
                .with(UP, this.canAttachAbove(blockstateUp, attachedNorth, attachedEast, attachedSouth, attachedWest))
                .with(DOWN, this.canAttachBelow(blockstateDown, attachedNorth, attachedEast, attachedSouth, attachedWest));
    }

    public final boolean canAttachAbove(BlockState state, boolean attachedNorth, boolean attachedEast, boolean attachedSouth, boolean attachedWest) {
        Block block = state.getBlock();
        return ((block instanceof StairsBlock && state.get(StairsBlock.HALF) == BlockHalf.TOP && state.get(StairsBlock.SHAPE) == StairShape.STRAIGHT && (canAttachToStair(state, attachedNorth, attachedEast, attachedSouth, attachedWest))) ||
                (block instanceof SlabLessLayers && state.get(SlabLessLayers.TYPE_UPDOWN) == BlockHalf.TOP) ||
                (block instanceof Slab && state.get(Slab.TYPE_UPDOWN) == BlockHalf.TOP) ||
                (block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.TOP) ||
                block instanceof Arch ||
                block instanceof ArchSmall ||
                block instanceof ArchTwoMeter ||
                block instanceof ArchHalf);
    }

    public final boolean canAttachBelow(BlockState state, boolean attachedNorth, boolean attachedEast, boolean attachedSouth, boolean attachedWest) {
        Block block = state.getBlock();
        return ((block instanceof StairsBlock && state.get(StairsBlock.HALF) == BlockHalf.BOTTOM && state.get(StairsBlock.SHAPE) == StairShape.STRAIGHT && (canAttachToStair(state, attachedNorth, attachedEast, attachedSouth, attachedWest))) ||
                (block instanceof SlabLessLayers && state.get(SlabLessLayers.TYPE_UPDOWN) == BlockHalf.BOTTOM) ||
                (block instanceof Slab && state.get(Slab.TYPE_UPDOWN) == BlockHalf.BOTTOM) ||
                (block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
                block instanceof Arch ||
                block instanceof ArchSmall ||
                block instanceof ArchTwoMeter ||
                block instanceof ArchHalf);
    }

    private boolean canAttachToStair(BlockState state, boolean attachedNorth, boolean attachedEast, boolean attachedSouth, boolean attachedWest) {
        switch (state.get(StairsBlock.FACING)) {
            default:
            case NORTH:
            case SOUTH: {
                return !attachedEast && !attachedWest;
            }
            case EAST:
            case WEST:
                return !attachedNorth && !attachedSouth;
        }
    }

    private boolean canAttachToStair(BlockState state, BlockState stateIn) {
        switch (state.get(StairsBlock.FACING)) {
            default:
            case NORTH:
            case SOUTH: {
                return !stateIn.get(PaneBlock.EAST) && !stateIn.get(PaneBlock.WEST);
            }
            case EAST:
            case WEST:
                return !stateIn.get(PaneBlock.NORTH) && !stateIn.get(PaneBlock.SOUTH);
        }
    }

    public final boolean canAttachAbove(WorldAccess world, BlockPos pos, BlockState stateIn) {
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        return ((block instanceof StairsBlock && state.get(StairsBlock.HALF) == BlockHalf.TOP && state.get(StairsBlock.SHAPE) == StairShape.STRAIGHT && canAttachToStair(state, stateIn)) ||
                (block instanceof SlabLessLayers && state.get(SlabLessLayers.TYPE_UPDOWN) == BlockHalf.TOP) ||
                (block instanceof Slab && state.get(Slab.TYPE_UPDOWN) == BlockHalf.TOP) ||
                (block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.TOP) ||
                block instanceof Arch ||
                block instanceof ArchSmall ||
                block instanceof ArchTwoMeter ||
                block instanceof ArchHalf);
    }

    public final boolean canAttachBelow(WorldAccess world, BlockPos pos, BlockState stateIn) {
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        return ((block instanceof StairsBlock && state.get(StairsBlock.HALF) == BlockHalf.BOTTOM && state.get(StairsBlock.SHAPE) == StairShape.STRAIGHT && canAttachToStair(state, stateIn)) ||
                (block instanceof SlabLessLayers && state.get(SlabLessLayers.TYPE_UPDOWN) == BlockHalf.BOTTOM) ||
                (block instanceof Slab && state.get(Slab.TYPE_UPDOWN) == BlockHalf.BOTTOM) ||
                (block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
                block instanceof Arch ||
                block instanceof ArchSmall ||
                block instanceof ArchTwoMeter ||
                block instanceof ArchHalf);
    }

    public final boolean canAttach(BlockState state, boolean bool, Direction direction) {
        Block block = state.getBlock();
        return !cannotConnect(state) && bool ||
                block instanceof PaneBlock ||
                (block instanceof VerticalCorner && state.get(VerticalCorner.LAYERS) >= 3) ||
                (block instanceof VerticalCornerLessLayers && state.get(VerticalCornerLessLayers.LAYERS) >= 2) ||
                (block instanceof VerticalSlab && state.get(VerticalSlab.LAYERS) >= 3 && canAttachToVertSlab(state, direction)) ||
                (block instanceof VerticalSlabLessLayers && state.get(VerticalSlabLessLayers.LAYERS) >= 2 && canAttachToVertSlab(state, direction)) ||
                (block instanceof VerticalQuarter && state.get(VerticalQuarter.LAYERS) >= 3 && canAttachToVertQuarter(state, direction)) ||
                (block instanceof VerticalQuarterLessLayers && state.get(VerticalQuarterLessLayers.LAYERS) >= 2 && canAttachToVertQuarter(state, direction)) ||
                block instanceof StairsBlock ||
                block instanceof Slab ||
                block instanceof SlabBlock ||
                block instanceof Arch ||
                block instanceof ArchSmall ||
                block instanceof ArchTwoMeter ||
                block instanceof ArchHalf;
    }

    private boolean canAttachToVertQuarter(BlockState state, Direction direction) {
        return (state.get(VerticalQuarter.DIRECTION) != direction && state.get(VerticalQuarter.DIRECTION).rotateYCounterclockwise() != direction);
    }

    public final boolean canAttachToVertSlab(BlockState state, Direction direction) {
        return state.get(VerticalSlab.DIRECTION) != direction;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, UP, DOWN, WATERLOGGED);
    }
}
