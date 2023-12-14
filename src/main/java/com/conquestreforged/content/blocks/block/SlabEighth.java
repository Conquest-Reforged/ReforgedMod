package com.conquestreforged.content.blocks.block;

import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

@Assets(
        state = @State(name = "%s_eighth_slab", template = "parent_slab_eighth"),
        item = @Model(name = "item/%s_eighth_slab", parent = "block/%s_slab_eighth", template = "item/parent_slab_eighth"),
        block = {
                @Model(name = "block/%s_slab_eighth", template = "block/parent_slab_eighth"),
                @Model(name = "block/%s_slab_eighth_top", template = "block/parent_slab_eighth_top"),
        }
)
public class SlabEighth extends WaterloggedHorizontalDirectionalShape {

    private static final VoxelShape BOTTOM_QTR_EAST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_QTR_WEST_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D);
    private static final VoxelShape BOTTOM_QTR_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D);
    private static final VoxelShape BOTTOM_QTR_NORTH_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D);

    private static final VoxelShape TOP_QTR_EAST_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_QTR_WEST_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_QTR_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_QTR_NORTH_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);


    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);

    public SlabEighth(Settings properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, false));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch(state.get(DIRECTION)) {
                    case NORTH:
                        return state.with(DIRECTION, Direction.EAST);
                    case EAST:
                        return state.with(DIRECTION, Direction.NORTH);
                    case SOUTH:
                        return state.with(DIRECTION, Direction.WEST);
                    case WEST:
                        return state.with(DIRECTION, Direction.SOUTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch(state.get(DIRECTION)) {
                    case NORTH:
                        return state.with(DIRECTION, Direction.WEST);
                    case EAST:
                        return state.with(DIRECTION, Direction.SOUTH);
                    case SOUTH:
                        return state.with(DIRECTION, Direction.EAST);
                    case WEST:
                        return state.with(DIRECTION, Direction.NORTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
        }
        return super.mirror(state, mirrorIn);
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return BOTTOM_QTR_NORTH_SHAPE;
                case SOUTH:
                    return BOTTOM_QTR_SOUTH_SHAPE;
                case WEST:
                    return BOTTOM_QTR_WEST_SHAPE;
                case EAST:
                    return BOTTOM_QTR_EAST_SHAPE;
            }
        } else {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return TOP_QTR_NORTH_SHAPE;
                case SOUTH:
                    return TOP_QTR_SOUTH_SHAPE;
                case WEST:
                    return TOP_QTR_WEST_SHAPE;
                case EAST:
                    return TOP_QTR_EAST_SHAPE;
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos pos = context.getBlockPos();
        FluidState fluid = context.getWorld().getFluidState(pos);
        Direction facingHorizontal = PlacementHelper.getHitVecHorizontalAxisDirection(context.getPlayerFacing().getOpposite(), pos, context);
        BlockState state2 = getDefaultState().with(DIRECTION, facingHorizontal).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
        Direction facing = context.getSide();
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double)pos.getY() > 0.5D)) ? state2 : state2.with(TYPE_UPDOWN, BlockHalf.TOP);
    }
}