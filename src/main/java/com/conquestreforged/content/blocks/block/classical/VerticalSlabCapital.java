package com.conquestreforged.content.blocks.block.classical;

import com.conquestreforged.content.blocks.block.VerticalSlabLessLayers;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

@Assets(
        state = @State(name = "%s_vertical_slab", template = "parent_doric_capital_vertical_slab"),
        item = @Model(name = "item/%s_vertical_slab", parent = "block/%s_vertical_slab_4", template = "item/parent_vertical_slab"),
        block = {
                @Model(name = "block/%s_vertical_slab_2", template = "block/parent_doric_capital_vertical_slab_2"),
                @Model(name = "block/%s_vertical_slab_2_e", template = "block/parent_doric_capital_vertical_slab_2_e"),
                @Model(name = "block/%s_vertical_slab_2_es", template = "block/parent_doric_capital_vertical_slab_2_es"),
                @Model(name = "block/%s_vertical_slab_2_ew", template = "block/parent_doric_capital_vertical_slab_2_ew"),
                @Model(name = "block/%s_vertical_slab_2_esw", template = "block/parent_doric_capital_vertical_slab_2_esw"),
                @Model(name = "block/%s_vertical_slab_2_s", template = "block/parent_doric_capital_vertical_slab_2_s"),
                @Model(name = "block/%s_vertical_slab_2_sw", template = "block/parent_doric_capital_vertical_slab_2_sw"),
                @Model(name = "block/%s_vertical_slab_2_w", template = "block/parent_doric_capital_vertical_slab_2_w"),
                @Model(name = "block/%s_vertical_slab_4", template = "block/parent_doric_capital_vertical_slab_4"),
                @Model(name = "block/%s_vertical_slab_4_e", template = "block/parent_doric_capital_vertical_slab_4_e"),
                @Model(name = "block/%s_vertical_slab_4_es", template = "block/parent_doric_capital_vertical_slab_4_es"),
                @Model(name = "block/%s_vertical_slab_4_ew", template = "block/parent_doric_capital_vertical_slab_4_ew"),
                @Model(name = "block/%s_vertical_slab_4_esw", template = "block/parent_doric_capital_vertical_slab_4_esw"),
                @Model(name = "block/%s_vertical_slab_4_s", template = "block/parent_doric_capital_vertical_slab_4_s"),
                @Model(name = "block/%s_vertical_slab_4_sw", template = "block/parent_doric_capital_vertical_slab_4_sw"),
                @Model(name = "block/%s_vertical_slab_4_w", template = "block/parent_doric_capital_vertical_slab_4_w"),
                @Model(name = "block/%s_vertical_slab_6", template = "block/parent_doric_capital_vertical_slab_6"),
                @Model(name = "block/%s_vertical_slab_6_e", template = "block/parent_doric_capital_vertical_slab_6_e"),
                @Model(name = "block/%s_vertical_slab_6_es", template = "block/parent_doric_capital_vertical_slab_6_es"),
                @Model(name = "block/%s_vertical_slab_6_ew", template = "block/parent_doric_capital_vertical_slab_6_ew"),
                @Model(name = "block/%s_vertical_slab_6_esw", template = "block/parent_doric_capital_vertical_slab_6_esw"),
                @Model(name = "block/%s_vertical_slab_6_s", template = "block/parent_doric_capital_vertical_slab_6_s"),
                @Model(name = "block/%s_vertical_slab_6_sw", template = "block/parent_doric_capital_vertical_slab_6_sw"),
                @Model(name = "block/%s_vertical_slab_6_w", template = "block/parent_doric_capital_vertical_slab_6_w"),
        }
)
public class VerticalSlabCapital extends VerticalSlabLessLayers {

    public static final BooleanProperty EAST = BooleanProperty.of("e");
    public static final BooleanProperty SOUTH = BooleanProperty.of("s");
    public static final BooleanProperty WEST = BooleanProperty.of("w");

    public VerticalSlabCapital(Props properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(EAST, false).with(SOUTH, false).with(WEST, false).with(WATERLOGGED, false));
    }

    public boolean canConnectTo(BlockState state) {
        Block block = state.getBlock();
        boolean flag1 = block instanceof CubeCapital || block instanceof VerticalSlabCapital || block instanceof VerticalCornerCapital;
        return flag1;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        Direction facing = context.getPlayerFacing().getOpposite();
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        BlockPos blockpos2;
        BlockPos blockpos3;
        BlockPos blockpos4;
        switch (facing) {
            default:
                blockpos2 = blockpos.east();
                blockpos3 = blockpos.south();
                blockpos4 = blockpos.west();
                break;
            case SOUTH:
                blockpos2 = blockpos.west();
                blockpos3 = blockpos.north();
                blockpos4 = blockpos.east();
                break;
            case EAST:
                blockpos2 = blockpos.south();
                blockpos3 = blockpos.west();
                blockpos4 = blockpos.north();
                break;
            case WEST:
                blockpos2 = blockpos.north();
                blockpos3 = blockpos.east();
                blockpos4 = blockpos.south();
                break;
        }
        BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos4);

        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            if (i == 3) {
                return fullBlock.getDefaultState();
            }
        }
        return super.getPlacementState(context).with(EAST, this.canConnectTo(blockstate1)).with(SOUTH, this.canConnectTo(blockstate2)).with(WEST, this.canConnectTo(blockstate3));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        Direction stateDirection = stateIn.get(DIRECTION);
        if (stateDirection == Direction.NORTH) {
            if (facing == Direction.NORTH) {
                return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.SOUTH) {
                return stateIn.with(SOUTH, canConnectTo(facingState));
            } else if (facing == Direction.EAST) {
                return stateIn.with(EAST, canConnectTo(facingState));
            } else if (facing == Direction.WEST) {
                return stateIn.with(WEST, canConnectTo(facingState));
            }
        }

        if (stateDirection == Direction.EAST) {
            if (facing == Direction.EAST) {
                return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.WEST) {
                return stateIn.with(SOUTH, canConnectTo(facingState));
            } else if (facing == Direction.SOUTH) {
                return stateIn.with(EAST, canConnectTo(facingState));
            } else if (facing == Direction.NORTH) {
                return stateIn.with(WEST, canConnectTo(facingState));
            }
        }

        if (stateDirection == Direction.SOUTH) {
            if (facing == Direction.SOUTH) {
                return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.NORTH) {
                return stateIn.with(SOUTH, canConnectTo(facingState));
            } else if (facing == Direction.WEST) {
                return stateIn.with(EAST, canConnectTo(facingState));
            } else if (facing == Direction.EAST) {
                return stateIn.with(WEST, canConnectTo(facingState));
            }
        }

        if (stateDirection == Direction.WEST) {
            if (facing == Direction.WEST) {
                return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.EAST) {
                return stateIn.with(SOUTH, canConnectTo(facingState));
            } else if (facing == Direction.NORTH) {
                return stateIn.with(EAST, canConnectTo(facingState));
            } else if (facing == Direction.SOUTH) {
                return stateIn.with(WEST, canConnectTo(facingState));
            }
        }
        return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS, EAST, WEST, SOUTH);
    }
}
