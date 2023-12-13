package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.properties.ParallelConnectionShape2;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT)
public class TableParallelConnecting extends WaterloggedHorizontalDirectionalShape {

    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public static final EnumProperty<ParallelConnectionShape2> FORM = EnumProperty.create("shape", ParallelConnectionShape2.class);

    public TableParallelConnecting(Props props) {
        super(props.toProperties());
        this.registerDefaultState(this.stateDefinition.any().setValue(FORM, ParallelConnectionShape2.ONE).setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        if (stateIn.getBlock() == this) {

            //random wall code copy
            BlockState north = world.getBlockState(currentPos.m_142127_());
            BlockState east = world.getBlockState(currentPos.m_142126_());
            BlockState south = world.getBlockState(currentPos.m_142128_());
            BlockState west = world.getBlockState(currentPos.m_142125_());

            Direction stateInDirection = stateIn.getValue(DIRECTION);

            switch (stateInDirection) {
                case NORTH:
                    if (attachesTo(east, stateInDirection)) {
                        if (attachesTo(west, stateInDirection)) {
                            return stateIn.setValue(FORM, ParallelConnectionShape2.MIDDLE);
                        } else {
                            return stateIn.setValue(FORM, ParallelConnectionShape2.EDGE_R);
                        }
                    } else if (attachesTo(west, stateInDirection)) {
                        return stateIn.setValue(FORM, ParallelConnectionShape2.EDGE_L);
                    } else {
                        return stateIn.setValue(FORM, ParallelConnectionShape2.ONE);
                    }
                case SOUTH:
                    if (attachesTo(west, stateInDirection)) {
                        if (attachesTo(east, stateInDirection)) {
                            return stateIn.setValue(FORM, ParallelConnectionShape2.MIDDLE);
                        } else {
                            return stateIn.setValue(FORM, ParallelConnectionShape2.EDGE_R);
                        }
                    } else if (attachesTo(east, stateInDirection)) {
                        return stateIn.setValue(FORM, ParallelConnectionShape2.EDGE_L);
                    } else {
                        return stateIn.setValue(FORM, ParallelConnectionShape2.ONE);
                    }
                case EAST:
                    if (attachesTo(north, stateInDirection)) {
                        if (attachesTo(south, stateInDirection)) {
                            return stateIn.setValue(FORM, ParallelConnectionShape2.MIDDLE);
                        } else {
                            return stateIn.setValue(FORM, ParallelConnectionShape2.EDGE_L);
                        }
                    } else if (attachesTo(south, stateInDirection)) {
                        return stateIn.setValue(FORM, ParallelConnectionShape2.EDGE_R);
                    } else {
                        return stateIn.setValue(FORM, ParallelConnectionShape2.ONE);
                    }
                case WEST:
                    if (attachesTo(south, stateInDirection)) {
                        if (attachesTo(north, stateInDirection)) {
                            return stateIn.setValue(FORM, ParallelConnectionShape2.MIDDLE);
                        } else {
                            return stateIn.setValue(FORM, ParallelConnectionShape2.EDGE_L);
                        }
                    } else if (attachesTo(north, stateInDirection)) {
                        return stateIn.setValue(FORM, ParallelConnectionShape2.EDGE_R);
                    } else {
                        return stateIn.setValue(FORM, ParallelConnectionShape2.ONE);
                    }
            }
        }
        return stateIn;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {

        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());

        BlockPos pos = context.getClickedPos();
        BlockGetter iblockreader = context.getLevel();
        BlockState north = iblockreader.getBlockState(pos.m_142127_());
        BlockState east = iblockreader.getBlockState(pos.m_142126_());
        BlockState south = iblockreader.getBlockState(pos.m_142128_());
        BlockState west = iblockreader.getBlockState(pos.m_142125_());

        Direction facing = context.getHorizontalDirection().getOpposite();

        BlockState stateDefault = this.defaultBlockState()
                .setValue(DIRECTION, facing)
                .setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);

        BlockState stateOne = stateDefault.setValue(FORM, ParallelConnectionShape2.ONE);
        BlockState stateMiddle = stateDefault.setValue(FORM, ParallelConnectionShape2.MIDDLE);
        BlockState stateRight = stateDefault.setValue(FORM, ParallelConnectionShape2.EDGE_R);
        BlockState stateLeft = stateDefault.setValue(FORM, ParallelConnectionShape2.EDGE_L);

        switch (facing) {
            default:
            case NORTH:
                if (attachesTo(east, facing)) {
                    if (attachesTo(west, facing)) {
                        return stateMiddle;
                    } else {
                        return stateRight;
                    }
                } else if (attachesTo(west, facing)) {
                    return stateLeft;
                } else {
                    return stateOne;
                }
            case SOUTH:
                if (attachesTo(west, facing)) {
                    if (attachesTo(east, facing)) {
                        return stateMiddle;
                    } else {
                        return stateRight;
                    }
                } else if (attachesTo(east, facing)) {
                    return stateLeft;
                } else {
                    return stateOne;
                }
            case EAST:
                if (attachesTo(north, facing)) {
                    if (attachesTo(south, facing)) {
                        return stateMiddle;
                    } else {
                        return stateLeft;
                    }
                } else if (attachesTo(south, facing)) {
                    return stateRight;
                } else {
                    return stateOne;
                }
            case WEST:
                if (attachesTo(south, facing)) {
                    if (attachesTo(north, facing)) {
                        return stateMiddle;
                    } else {
                        return stateLeft;
                    }
                } else if (attachesTo(north, facing)) {
                    return stateRight;
                } else {
                    return stateOne;
                }
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FORM);
    }


    protected boolean attachesTo(BlockState state, Direction facing) {
        Block block = state.getBlock();
        return block == this && state.getValue(DIRECTION) == facing;
    }
}
