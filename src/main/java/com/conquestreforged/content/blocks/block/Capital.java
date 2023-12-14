package com.conquestreforged.content.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedShape;
import com.conquestreforged.core.block.properties.CapitalDirection;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

@Assets(
        state = @State(name = "%s_capital", template = "parent_capital"),
        item = @Model(name = "item/%s_capital", parent = "block/%s_capital_down_flat", template = "item/parent_capital"),
        block = {
                @Model(name = "block/%s_capital_down_flat", template = "block/parent_capital_down_flat"),
                @Model(name = "block/%s_capital_down_side", template = "block/parent_capital_down_side"),
                @Model(name = "block/%s_capital_up_flat", template = "block/parent_capital_up_flat"),
                @Model(name = "block/%s_capital_up_side", template = "block/parent_capital_up_side"),
        }
)
public class Capital extends WaterloggedShape implements Waterloggable {

    public static final EnumProperty<CapitalDirection> FACING = EnumProperty.of("facing", CapitalDirection.class);
    public static final EnumProperty<BlockHalf> TYPE = EnumProperty.of("type", BlockHalf.class);

    private static final VoxelShape TOP_FLAT_BIG = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_FLAT_MIDDLE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_FLAT = VoxelShapes.union(TOP_FLAT_BIG, TOP_FLAT_MIDDLE);

    private static final VoxelShape BOTTOM_FLAT_BIG = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_FLAT_MIDDLE = Block.createCuboidShape(4.0D, 6.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final VoxelShape BOTTOM_FLAT = VoxelShapes.union(BOTTOM_FLAT_BIG, BOTTOM_FLAT_MIDDLE);

    private static final VoxelShape BOTTOM_SIDE_BIG = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_N = Block.createCuboidShape(3.0D, 6.0D, 0.0D, 13.0D, 12.0D, 13.0D);
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_S = Block.createCuboidShape(3.0D, 6.0D, 3.0D, 13.0D, 12.0D, 16.0D);
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_E = Block.createCuboidShape(3.0D, 6.0D, 3.0D, 16.0D, 12.0D, 13.0D);
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_W = Block.createCuboidShape(0.0D, 6.0D, 3.0D, 13.0D, 12.0D, 13.0D);
    private static final VoxelShape BOTTOM_SIDE_N = VoxelShapes.union(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_N);
    private static final VoxelShape BOTTOM_SIDE_S = VoxelShapes.union(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_S);
    private static final VoxelShape BOTTOM_SIDE_E = VoxelShapes.union(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_E);
    private static final VoxelShape BOTTOM_SIDE_W = VoxelShapes.union(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_W);

    private static final VoxelShape TOP_SIDE_BIG = Block.createCuboidShape(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_SIDE_MIDDLE_N = Block.createCuboidShape(12.0D, 4.0D, 0.0D, 16.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_SIDE_MIDDLE_S = Block.createCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 10.0D, 16.0D);
    private static final VoxelShape TOP_SIDE_MIDDLE_E = Block.createCuboidShape(4.0D, 4.0D, 4.0D, 16.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_SIDE_MIDDLE_W = Block.createCuboidShape(0.0D, 4.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_SIDE_N = VoxelShapes.union(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_N);
    private static final VoxelShape TOP_SIDE_S = VoxelShapes.union(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_S);
    private static final VoxelShape TOP_SIDE_E = VoxelShapes.union(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_E);
    private static final VoxelShape TOP_SIDE_W = VoxelShapes.union(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_W);

    public Capital(Settings properties) {
        super(properties);
        setDefaultState((stateManager.getDefaultState()).with(TYPE, BlockHalf.TOP).with(FACING, CapitalDirection.NORTH).with(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE) == BlockHalf.TOP) {
            if (state.get(FACING) == CapitalDirection.NORTH) {
                return TOP_SIDE_N;
            } else if (state.get(FACING) == CapitalDirection.SOUTH) {
                return TOP_SIDE_S;
            } else if (state.get(FACING) == CapitalDirection.EAST) {
                return TOP_SIDE_E;
            } else if (state.get(FACING) == CapitalDirection.WEST) {
                return TOP_SIDE_W;
            } else {
                return TOP_FLAT;
            }
        } else {
            if (state.get(FACING) == CapitalDirection.NORTH) {
                return BOTTOM_SIDE_N;
            } else if (state.get(FACING) == CapitalDirection.SOUTH) {
                return BOTTOM_SIDE_S;
            } else if (state.get(FACING) == CapitalDirection.EAST) {
                return BOTTOM_SIDE_E;
            } else if (state.get(FACING) == CapitalDirection.WEST) {
                return BOTTOM_SIDE_W;
            } else {
                return BOTTOM_FLAT;
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());
        Direction facing = context.getSide();

        CapitalDirection horizontalFacing;
        switch (facing) {
            default:
                horizontalFacing = CapitalDirection.FLAT;
                break;
            case NORTH:
                horizontalFacing = CapitalDirection.SOUTH;
                break;
            case SOUTH:
                horizontalFacing = CapitalDirection.NORTH;
                break;
            case WEST:
                horizontalFacing = CapitalDirection.EAST;
                break;
            case EAST:
                horizontalFacing = CapitalDirection.WEST;
                break;
        }

        BlockHalf verticalFacing;
        if (facing != Direction.DOWN && (facing == Direction.UP || context.getHitPos().y <= 0.5D)) {
            verticalFacing = BlockHalf.BOTTOM;
        } else {
            verticalFacing = BlockHalf.TOP;
        }

        return super.getPlacementState(context)
                .with(TYPE, verticalFacing)
                .with(FACING, horizontalFacing)
                .with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE, FACING);
    }
}
