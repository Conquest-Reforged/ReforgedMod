package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

@Assets(
        state = @State(name = "%s_vertical_corner_slab", template = "parent_vertical_corner_slab"),
        item = @Model(name = "item/%s_vertical_corner_slab", parent = "block/%s_vertical_corner_slab_left", template = "item/parent_slab_corner"),
        block = {
                @Model(name = "block/%s_vertical_corner_slab_left", template = "block/parent_vertical_corner_slab_left"),
                @Model(name = "block/%s_vertical_corner_slab_bottom_left", template = "block/parent_vertical_corner_slab_bottom_left"),
                @Model(name = "block/%s_vertical_corner_slab_right", template = "block/parent_vertical_corner_slab_right"),
                @Model(name = "block/%s_vertical_corner_slab_bottom_right", template = "block/parent_vertical_corner_slab_bottom_right"),
        }
)
public class VerticalSlabCorner extends WaterloggedHorizontalDirectionalShape {

    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);
    public static final EnumProperty<DoorHinge> HINGE = Properties.DOOR_HINGE;

    private static final VoxelShape ARCH_NORTH_R_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D));
    private static final VoxelShape ARCH_NORTH_L_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D));

    private static final VoxelShape ARCH_WEST_L_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape ARCH_WEST_R_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));

    private static final VoxelShape ARCH_EAST_R_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D));
    private static final VoxelShape ARCH_EAST_L_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D));

    private static final VoxelShape ARCH_SOUTH_L_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
    private static final VoxelShape ARCH_SOUTH_R_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));

    private static final VoxelShape ARCH_NORTH_R_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D));
    private static final VoxelShape ARCH_NORTH_L_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D));

    private static final VoxelShape ARCH_WEST_L_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));
    private static final VoxelShape ARCH_WEST_R_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));

    private static final VoxelShape ARCH_EAST_R_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D));
    private static final VoxelShape ARCH_EAST_L_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D));

    private static final VoxelShape ARCH_SOUTH_L_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D), Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));
    private static final VoxelShape ARCH_SOUTH_R_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));

    public VerticalSlabCorner(Settings properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        FluidState fluid = context.getWorld().getFluidState(blockpos);
        Direction facingHorizontal = context.getPlayerFacing().getOpposite();
        BlockState state2 = getDefaultState().with(DIRECTION, facingHorizontal).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
        Direction facing = context.getSide();
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double)context.getBlockPos().getY() > 0.5D)) ? state2.with(HINGE, this.getHingeSide(facingHorizontal, blockpos, context)) : state2.with(TYPE_UPDOWN, BlockHalf.TOP).with(HINGE, this.getHingeSide(facingHorizontal, blockpos, context));
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rot) {
        switch (rot) {
            case CLOCKWISE_90:
                switch(state.get(DIRECTION)) {
                    case EAST:
                    case WEST:
                        return state.cycle(HINGE).with(DIRECTION, rot.rotate(state.get(DIRECTION)));
                    case NORTH:
                    case SOUTH:
                    default:
                        return state.with(DIRECTION, rot.rotate(state.get(DIRECTION)));
                }
            case CLOCKWISE_180:
                switch(state.get(DIRECTION)) {
                    case NORTH:
                    case SOUTH:
                    case EAST:
                    case WEST:
                        return state.cycle(HINGE).with(DIRECTION, rot.rotate(state.get(DIRECTION)));
                    default:
                        return state.with(DIRECTION, rot.rotate(state.get(DIRECTION)));
                }
            case COUNTERCLOCKWISE_90:
                switch(state.get(DIRECTION)) {
                    case NORTH:
                    case SOUTH:
                        return state.cycle(HINGE).with(DIRECTION, rot.rotate(state.get(DIRECTION)));
                    case EAST:
                    case WEST:
                        return state.with(DIRECTION, rot.rotate(state.get(DIRECTION)));
                }
            default:
                return state;
        }
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch(state.get(DIRECTION)) {
                    case NORTH:
                    case SOUTH:
                        return state.cycle(HINGE);
                    case EAST:
                    case WEST:
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch(state.get(DIRECTION)) {
                    case WEST:
                    case EAST:
                        return state.cycle(HINGE);
                    case SOUTH:
                    case NORTH:
                    default:
                        return super.mirror(state, mirrorIn);
                }
        }
        return super.mirror(state, mirrorIn);
    }

    private DoorHinge getHingeSide(Direction facing, BlockPos pos, ItemPlacementContext context) {
        switch (facing) {
            case NORTH: {
                return (!(context.getHitPos().x - (double) pos.getX() > 0.5D)) ? DoorHinge.RIGHT : DoorHinge.LEFT;
            }
            case SOUTH: {
                return (!(context.getHitPos().x - (double) pos.getX() < 0.5D)) ? DoorHinge.LEFT : DoorHinge.RIGHT;
            }
            case EAST: {
                return (!(context.getHitPos().z - (double) pos.getZ() > 0.5D)) ? DoorHinge.RIGHT : DoorHinge.LEFT;
            }
            default: {
                return (!(context.getHitPos().z - (double) pos.getZ() < 0.5D)) ? DoorHinge.LEFT : DoorHinge.RIGHT;
            }
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN).add(HINGE);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.TOP) {
            if (state.get(HINGE) == DoorHinge.LEFT) {
                switch (state.get(DIRECTION)) {
                    case NORTH:
                    default:
                        return ARCH_NORTH_L_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_L_SHAPE;
                    case WEST:
                        return ARCH_WEST_L_SHAPE;
                    case EAST:
                        return ARCH_EAST_L_SHAPE;
                }
            } else {
                switch (state.get(DIRECTION)) {
                    case NORTH:
                    default:
                        return ARCH_NORTH_R_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_R_SHAPE;
                    case WEST:
                        return ARCH_WEST_R_SHAPE;
                    case EAST:
                        return ARCH_EAST_R_SHAPE;
                }
            }
        } else {
            if (state.get(HINGE) == DoorHinge.LEFT) {
                switch (state.get(DIRECTION)) {
                    case NORTH:
                    default:
                        return ARCH_NORTH_L_BOTTOM_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_L_BOTTOM_SHAPE;
                    case WEST:
                        return ARCH_WEST_L_BOTTOM_SHAPE;
                    case EAST:
                        return ARCH_EAST_L_BOTTOM_SHAPE;
                }
            } else {
                switch (state.get(DIRECTION)) {
                    case NORTH:
                    default:
                        return ARCH_NORTH_R_BOTTOM_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_R_BOTTOM_SHAPE;
                    case WEST:
                        return ARCH_WEST_R_BOTTOM_SHAPE;
                    case EAST:
                        return ARCH_EAST_R_BOTTOM_SHAPE;
                }
            }
        }
    }
}