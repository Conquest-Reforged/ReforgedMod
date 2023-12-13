package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedShape;
import com.conquestreforged.core.block.properties.CapitalDirection;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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

    public static final EnumProperty<CapitalDirection> FACING = EnumProperty.create("facing", CapitalDirection.class);
    public static final EnumProperty<Half> TYPE = EnumProperty.create("type", Half.class);

    private static final VoxelShape TOP_FLAT_BIG = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_FLAT_MIDDLE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_FLAT = Shapes.or(TOP_FLAT_BIG, TOP_FLAT_MIDDLE);

    private static final VoxelShape BOTTOM_FLAT_BIG = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_FLAT_MIDDLE = Block.box(4.0D, 6.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final VoxelShape BOTTOM_FLAT = Shapes.or(BOTTOM_FLAT_BIG, BOTTOM_FLAT_MIDDLE);

    private static final VoxelShape BOTTOM_SIDE_BIG = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_N = Block.box(3.0D, 6.0D, 0.0D, 13.0D, 12.0D, 13.0D);
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_S = Block.box(3.0D, 6.0D, 3.0D, 13.0D, 12.0D, 16.0D);
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_E = Block.box(3.0D, 6.0D, 3.0D, 16.0D, 12.0D, 13.0D);
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_W = Block.box(0.0D, 6.0D, 3.0D, 13.0D, 12.0D, 13.0D);
    private static final VoxelShape BOTTOM_SIDE_N = Shapes.or(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_N);
    private static final VoxelShape BOTTOM_SIDE_S = Shapes.or(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_S);
    private static final VoxelShape BOTTOM_SIDE_E = Shapes.or(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_E);
    private static final VoxelShape BOTTOM_SIDE_W = Shapes.or(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_W);

    private static final VoxelShape TOP_SIDE_BIG = Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_SIDE_MIDDLE_N = Block.box(12.0D, 4.0D, 0.0D, 16.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_SIDE_MIDDLE_S = Block.box(4.0D, 4.0D, 4.0D, 12.0D, 10.0D, 16.0D);
    private static final VoxelShape TOP_SIDE_MIDDLE_E = Block.box(4.0D, 4.0D, 4.0D, 16.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_SIDE_MIDDLE_W = Block.box(0.0D, 4.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_SIDE_N = Shapes.or(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_N);
    private static final VoxelShape TOP_SIDE_S = Shapes.or(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_S);
    private static final VoxelShape TOP_SIDE_E = Shapes.or(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_E);
    private static final VoxelShape TOP_SIDE_W = Shapes.or(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_W);

    public Capital(Properties properties) {
        super(properties);
        registerDefaultState((stateDefinition.any()).setValue(TYPE, Half.TOP).setValue(FACING, CapitalDirection.NORTH).setValue(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TYPE) == Half.TOP) {
            if (state.getValue(FACING) == CapitalDirection.NORTH) {
                return TOP_SIDE_N;
            } else if (state.getValue(FACING) == CapitalDirection.SOUTH) {
                return TOP_SIDE_S;
            } else if (state.getValue(FACING) == CapitalDirection.EAST) {
                return TOP_SIDE_E;
            } else if (state.getValue(FACING) == CapitalDirection.WEST) {
                return TOP_SIDE_W;
            } else {
                return TOP_FLAT;
            }
        } else {
            if (state.getValue(FACING) == CapitalDirection.NORTH) {
                return BOTTOM_SIDE_N;
            } else if (state.getValue(FACING) == CapitalDirection.SOUTH) {
                return BOTTOM_SIDE_S;
            } else if (state.getValue(FACING) == CapitalDirection.EAST) {
                return BOTTOM_SIDE_E;
            } else if (state.getValue(FACING) == CapitalDirection.WEST) {
                return BOTTOM_SIDE_W;
            } else {
                return BOTTOM_FLAT;
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        Direction facing = context.getClickedFace();

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

        Half verticalFacing;
        if (facing != Direction.DOWN && (facing == Direction.UP || context.getClickLocation().y <= 0.5D)) {
            verticalFacing = Half.BOTTOM;
        } else {
            verticalFacing = Half.TOP;
        }

        return super.getStateForPlacement(context)
                .setValue(TYPE, verticalFacing)
                .setValue(FACING, horizontalFacing)
                .setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, FACING);
    }
}
