package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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

    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);
    public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;

    private static final VoxelShape ARCH_NORTH_R_SHAPE = Shapes.or(Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D));
    private static final VoxelShape ARCH_NORTH_L_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D));

    private static final VoxelShape ARCH_WEST_L_SHAPE = Shapes.or(Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape ARCH_WEST_R_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));

    private static final VoxelShape ARCH_EAST_R_SHAPE = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D));
    private static final VoxelShape ARCH_EAST_L_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D), Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D));

    private static final VoxelShape ARCH_SOUTH_L_SHAPE = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
    private static final VoxelShape ARCH_SOUTH_R_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D), Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));

    private static final VoxelShape ARCH_NORTH_R_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D));
    private static final VoxelShape ARCH_NORTH_L_BOTTOM_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D));

    private static final VoxelShape ARCH_WEST_L_BOTTOM_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));
    private static final VoxelShape ARCH_WEST_R_BOTTOM_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));

    private static final VoxelShape ARCH_EAST_R_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D), Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D));
    private static final VoxelShape ARCH_EAST_L_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D));

    private static final VoxelShape ARCH_SOUTH_L_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D), Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));
    private static final VoxelShape ARCH_SOUTH_R_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));

    public VerticalSlabCorner(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(DIRECTION, Direction.NORTH).setValue(TYPE_UPDOWN, Half.BOTTOM).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluid = context.getLevel().getFluidState(blockpos);
        Direction facingHorizontal = context.getHorizontalDirection().getOpposite();
        BlockState state2 = defaultBlockState().setValue(DIRECTION, facingHorizontal).setValue(TYPE_UPDOWN, Half.BOTTOM).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
        Direction facing = context.getClickedFace();
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getClickLocation().y - (double)context.getClickedPos().getY() > 0.5D)) ? state2.setValue(HINGE, this.getHingeSide(facingHorizontal, blockpos, context)) : state2.setValue(TYPE_UPDOWN, Half.TOP).setValue(HINGE, this.getHingeSide(facingHorizontal, blockpos, context));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        switch (rot) {
            case CLOCKWISE_90:
                switch(state.getValue(DIRECTION)) {
                    case EAST:
                    case WEST:
                        return state.cycle(HINGE).setValue(DIRECTION, rot.rotate(state.getValue(DIRECTION)));
                    case NORTH:
                    case SOUTH:
                    default:
                        return state.setValue(DIRECTION, rot.rotate(state.getValue(DIRECTION)));
                }
            case CLOCKWISE_180:
                switch(state.getValue(DIRECTION)) {
                    case NORTH:
                    case SOUTH:
                    case EAST:
                    case WEST:
                        return state.cycle(HINGE).setValue(DIRECTION, rot.rotate(state.getValue(DIRECTION)));
                    default:
                        return state.setValue(DIRECTION, rot.rotate(state.getValue(DIRECTION)));
                }
            case COUNTERCLOCKWISE_90:
                switch(state.getValue(DIRECTION)) {
                    case NORTH:
                    case SOUTH:
                        return state.cycle(HINGE).setValue(DIRECTION, rot.rotate(state.getValue(DIRECTION)));
                    case EAST:
                    case WEST:
                        return state.setValue(DIRECTION, rot.rotate(state.getValue(DIRECTION)));
                }
            default:
                return state;
        }
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch(state.getValue(DIRECTION)) {
                    case NORTH:
                    case SOUTH:
                        return state.cycle(HINGE);
                    case EAST:
                    case WEST:
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch(state.getValue(DIRECTION)) {
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

    private DoorHingeSide getHingeSide(Direction facing, BlockPos pos, BlockPlaceContext context) {
        switch (facing) {
            case NORTH: {
                return (!(context.getClickLocation().x - (double) pos.getX() > 0.5D)) ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT;
            }
            case SOUTH: {
                return (!(context.getClickLocation().x - (double) pos.getX() < 0.5D)) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            }
            case EAST: {
                return (!(context.getClickLocation().z - (double) pos.getZ() > 0.5D)) ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT;
            }
            default: {
                return (!(context.getClickLocation().z - (double) pos.getZ() < 0.5D)) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            }
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN).add(HINGE);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TYPE_UPDOWN) == Half.TOP) {
            if (state.getValue(HINGE) == DoorHingeSide.LEFT) {
                switch (state.getValue(DIRECTION)) {
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
                switch (state.getValue(DIRECTION)) {
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
            if (state.getValue(HINGE) == DoorHingeSide.LEFT) {
                switch (state.getValue(DIRECTION)) {
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
                switch (state.getValue(DIRECTION)) {
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