package com.conquestreforged.blocks.block.classical.corinthian;

import com.conquestreforged.blocks.block.VerticalQuarterLessLayers;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

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

    public static final BooleanProperty EAST = BooleanProperty.create("e");
    public static final BooleanProperty SOUTH = BooleanProperty.create("s");

    public VerticalQuarterCapitalCorinthian(Props properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(DIRECTION, Direction.NORTH).setValue(EAST, false).setValue(SOUTH, false).setValue(WATERLOGGED, false));
    }

    public boolean canConnectTo(BlockState state, Direction stateDirectionOriginal) {
        Block block = state.getBlock();
        boolean flag1 = block instanceof CubeCapitalCorinthian || block instanceof VerticalSlabCapitalCorinthian || block instanceof VerticalCornerCapitalCorinthian;
        boolean flag2 = block instanceof VerticalQuarterCapitalCorinthian && (state.getValue(DIRECTION) == stateDirectionOriginal.getClockWise() || state.getValue(DIRECTION) == stateDirectionOriginal.getCounterClockWise());
        return flag2 || flag1;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        Direction facing = context.getHorizontalDirection().getOpposite();
        BlockGetter iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos2;
        BlockPos blockpos3;
        switch (facing) {
            default:
                blockpos2 = blockpos.m_142126_();
                blockpos3 = blockpos.m_142128_();
                break;
            case SOUTH:
                blockpos2 = blockpos.m_142125_();
                blockpos3 = blockpos.m_142127_();
                break;
            case EAST:
                blockpos2 = blockpos.m_142128_();
                blockpos3 = blockpos.m_142125_();
                break;
            case WEST:
                blockpos2 = blockpos.m_142127_();
                blockpos3 = blockpos.m_142126_();
                break;
        }
        BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
        if (blockstate.getBlock() == this) {
            int i = blockstate.getValue(LAYERS);
            if (i == 3) {
                return fullBlock.defaultBlockState();
            }
        }
        return super.getStateForPlacement(context).setValue(EAST, this.canConnectTo(blockstate1, facing)).setValue(SOUTH, this.canConnectTo(blockstate2, facing));
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        Direction stateDirection = stateIn.getValue(DIRECTION);
        if (stateDirection == Direction.NORTH) {
            if (facing == Direction.NORTH) {
                return super.updateShape(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.SOUTH) {
                return stateIn.setValue(SOUTH, canConnectTo(facingState, stateDirection));
            } else if (facing == Direction.EAST) {
                return stateIn.setValue(EAST, canConnectTo(facingState, stateDirection));
            }
        }

        if (stateDirection == Direction.EAST) {
            if (facing == Direction.EAST) {
                return super.updateShape(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.WEST) {
                return stateIn.setValue(SOUTH, canConnectTo(facingState, stateDirection));
            } else if (facing == Direction.SOUTH) {
                return stateIn.setValue(EAST, canConnectTo(facingState, stateDirection));
            }
        }

        if (stateDirection == Direction.SOUTH) {
            if (facing == Direction.SOUTH) {
                return super.updateShape(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.NORTH) {
                return stateIn.setValue(SOUTH, canConnectTo(facingState, stateDirection));
            } else if (facing == Direction.WEST) {
                return stateIn.setValue(EAST, canConnectTo(facingState, stateDirection));
            }
        }

        if (stateDirection == Direction.WEST) {
            if (facing == Direction.WEST) {
                return super.updateShape(stateIn, facing, facingState, world, currentPos, facingPos);
            } else if (facing == Direction.EAST) {
                return stateIn.setValue(SOUTH, canConnectTo(facingState, stateDirection));
            } else if (facing == Direction.NORTH) {
                return stateIn.setValue(EAST, canConnectTo(facingState, stateDirection));
            }
        }
        return super.updateShape(stateIn, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYERS, EAST, SOUTH);
    }
}
