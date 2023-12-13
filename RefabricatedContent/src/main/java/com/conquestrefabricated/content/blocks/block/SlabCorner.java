package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.content.blocks.block.util.PlacementHelper;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestrefabricated.core.block.properties.Waterloggable;
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
import net.minecraft.util.shape.VoxelShapes;

@Assets(
        state = @State(name = "%s_corner_slab", template = "parent_slab_corner"),
        item = @Model(name = "item/%s_corner_slab", parent = "block/%s_slab_corner", template = "item/parent_slab_corner"),
        block = {
                @Model(name = "block/%s_slab_corner", template = "block/parent_slab_corner"),
                @Model(name = "block/%s_slab_corner_top", template = "block/parent_slab_corner_top"),
        }
)
public class SlabCorner extends WaterloggedHorizontalDirectionalShape implements Waterloggable {

    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);
    private static final VoxelShape BOTTOM_QTR_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_MAIN_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D);
    private static final VoxelShape BOTTOM_SOUTH_SHAPE = VoxelShapes.union(BOTTOM_QTR_SOUTH_SHAPE, BOTTOM_MAIN_SOUTH_SHAPE);
    private static final VoxelShape BOTTOM_QTR_NORTH_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D);
    private static final VoxelShape BOTTOM_MAIN_NORTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_NORTH_SHAPE = VoxelShapes.union(BOTTOM_QTR_NORTH_SHAPE, BOTTOM_MAIN_NORTH_SHAPE);
    private static final VoxelShape BOTTOM_QTR_WEST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D);
    private static final VoxelShape BOTTOM_MAIN_WEST_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_WEST_SHAPE = VoxelShapes.union(BOTTOM_QTR_WEST_SHAPE, BOTTOM_MAIN_WEST_SHAPE);
    private static final VoxelShape BOTTOM_QTR_EAST_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_MAIN_EAST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_EAST_SHAPE = VoxelShapes.union(BOTTOM_QTR_EAST_SHAPE, BOTTOM_MAIN_EAST_SHAPE);
    private static final VoxelShape TOP_QTR_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_MAIN_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_SOUTH_SHAPE = VoxelShapes.union(TOP_QTR_SOUTH_SHAPE, TOP_MAIN_SOUTH_SHAPE);
    private static final VoxelShape TOP_QTR_NORTH_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_MAIN_NORTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_NORTH_SHAPE = VoxelShapes.union(TOP_QTR_NORTH_SHAPE, TOP_MAIN_NORTH_SHAPE);
    private static final VoxelShape TOP_QTR_WEST_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D);
    private static final VoxelShape TOP_MAIN_WEST_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_WEST_SHAPE = VoxelShapes.union(TOP_QTR_WEST_SHAPE, TOP_MAIN_WEST_SHAPE);
    private static final VoxelShape TOP_QTR_EAST_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_MAIN_EAST_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_EAST_SHAPE = VoxelShapes.union(TOP_QTR_EAST_SHAPE, TOP_MAIN_EAST_SHAPE);

    public SlabCorner(Settings properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, false));
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
                    return BOTTOM_NORTH_SHAPE;
                case SOUTH:
                    return BOTTOM_SOUTH_SHAPE;
                case WEST:
                    return BOTTOM_WEST_SHAPE;
                case EAST:
                    return BOTTOM_EAST_SHAPE;
            }
        } else {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return TOP_NORTH_SHAPE;
                case SOUTH:
                    return TOP_SOUTH_SHAPE;
                case WEST:
                    return TOP_WEST_SHAPE;
                case EAST:
                    return TOP_EAST_SHAPE;
            }
        }
    }
}