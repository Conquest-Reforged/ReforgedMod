package com.conquestrefabricated.content.blocks.block.classical.corinthian;

import com.conquestrefabricated.content.blocks.block.VerticalQuarterLessLayers;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;
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
        state = @State(name = "%s_vertical_quarter", template = "parent_doric_capital_vertical_quarter"),
        item = @Model(name = "item/%s_vertical_quarter", parent = "block/%s_vertical_quarter_4", template = "item/parent_vertical_quarter"),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s_vertical_quarter_2", template = "block/parent_doric_capital_vertical_quarter_2"),
                @Model(name = "block/%s_vertical_quarter_2_e", template = "block/parent_doric_capital_vertical_quarter_2_e"),
                @Model(name = "block/%s_vertical_quarter_2_es", template = "block/parent_doric_capital_vertical_quarter_2_es"),
                @Model(name = "block/%s_vertical_quarter_2_s", template = "block/parent_doric_capital_vertical_quarter_2_s"),
                @Model(name = "block/%s_vertical_quarter_4", template = "block/parent_doric_capital_vertical_quarter_4"),
                @Model(name = "block/%s_vertical_quarter_4_e", template = "block/parent_doric_capital_vertical_quarter_4_e"),
                @Model(name = "block/%s_vertical_quarter_4_es", template = "block/parent_doric_capital_vertical_quarter_4_es"),
                @Model(name = "block/%s_vertical_quarter_4_s", template = "block/parent_doric_capital_vertical_quarter_4_s"),
                @Model(name = "block/%s_vertical_quarter_6", template = "block/parent_doric_capital_vertical_quarter_6"),
                @Model(name = "block/%s_vertical_quarter_6_e", template = "block/parent_doric_capital_vertical_quarter_6_e"),
                @Model(name = "block/%s_vertical_quarter_6_es", template = "block/parent_doric_capital_vertical_quarter_6_es"),
                @Model(name = "block/%s_vertical_quarter_6_s", template = "block/parent_doric_capital_vertical_quarter_6_s"),
        }
)
public class VerticalQuarterCapitalCorinthian extends VerticalQuarterLessLayers {

    public static final BooleanProperty EAST = BooleanProperty.of("e");
    public static final BooleanProperty SOUTH = BooleanProperty.of("s");

    public VerticalQuarterCapitalCorinthian(Props properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(EAST, false).with(SOUTH, false).with(WATERLOGGED, false));
    }

    public boolean canConnectTo(BlockState state, Direction stateDirectionOriginal) {
        Block block = state.getBlock();
        boolean flag1 = block instanceof CubeCapitalCorinthian || block instanceof VerticalSlabCapitalCorinthian || block instanceof VerticalCornerCapitalCorinthian;
        boolean flag2 = block instanceof VerticalQuarterCapitalCorinthian && (state.get(DIRECTION) == stateDirectionOriginal.rotateYClockwise() || state.get(DIRECTION) == stateDirectionOriginal.rotateYCounterclockwise());
        return flag2 || flag1;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        Direction facing = context.getPlayerFacing().getOpposite();
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        BlockPos blockpos2;
        BlockPos blockpos3;
        switch (facing) {
            default:
                blockpos2 = blockpos.east();
                blockpos3 = blockpos.south();
                break;
            case SOUTH:
                blockpos2 = blockpos.west();
                blockpos3 = blockpos.north();
                break;
            case EAST:
                blockpos2 = blockpos.south();
                blockpos3 = blockpos.west();
                break;
            case WEST:
                blockpos2 = blockpos.north();
                blockpos3 = blockpos.east();
                break;
        }
        BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            if (i == 3) {
                return fullBlock.getDefaultState();
            }
        }
        return super.getPlacementState(context).with(EAST, this.canConnectTo(blockstate1, facing)).with(SOUTH, this.canConnectTo(blockstate2, facing));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        Direction stateDirection = stateIn.get(DIRECTION);
        if (stateDirection == Direction.NORTH) {
            if (facing == Direction.NORTH) {
                return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.SOUTH) {
                return stateIn.with(SOUTH, canConnectTo(facingState, stateDirection));
            } else if (facing == Direction.EAST) {
                return stateIn.with(EAST, canConnectTo(facingState, stateDirection));
            }
        }

        if (stateDirection == Direction.EAST) {
            if (facing == Direction.EAST) {
                return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.WEST) {
                return stateIn.with(SOUTH, canConnectTo(facingState, stateDirection));
            } else if (facing == Direction.SOUTH) {
                return stateIn.with(EAST, canConnectTo(facingState, stateDirection));
            }
        }

        if (stateDirection == Direction.SOUTH) {
            if (facing == Direction.SOUTH) {
                return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.NORTH) {
                return stateIn.with(SOUTH, canConnectTo(facingState, stateDirection));
            } else if (facing == Direction.WEST) {
                return stateIn.with(EAST, canConnectTo(facingState, stateDirection));
            }
        }

        if (stateDirection == Direction.WEST) {
            if (facing == Direction.WEST) {
                return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.EAST) {
                return stateIn.with(SOUTH, canConnectTo(facingState, stateDirection));
            } else if (facing == Direction.NORTH) {
                return stateIn.with(EAST, canConnectTo(facingState, stateDirection));
            }
        }
        return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS, EAST, SOUTH);
    }
}
