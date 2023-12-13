package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.block.properties.ParallelConnectionShape2;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

@Render(RenderLayer.CUTOUT)
public class TableParallelConnecting extends WaterloggedHorizontalDirectionalShape {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public static final EnumProperty<ParallelConnectionShape2> FORM = EnumProperty.of("shape", ParallelConnectionShape2.class);

    public TableParallelConnecting(Props props) {
        super(props.toSettings());
        this.setDefaultState(this.stateManager.getDefaultState().with(FORM, ParallelConnectionShape2.ONE).with(DIRECTION, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if (stateIn.getBlock() == this) {

            //random wall code copy
            BlockState north = world.getBlockState(currentPos.north());
            BlockState east = world.getBlockState(currentPos.east());
            BlockState south = world.getBlockState(currentPos.south());
            BlockState west = world.getBlockState(currentPos.west());

            Direction stateInDirection = stateIn.get(DIRECTION);

            switch (stateInDirection) {
                case NORTH:
                    if (attachesTo(east, stateInDirection)) {
                        if (attachesTo(west, stateInDirection)) {
                            return stateIn.with(FORM, ParallelConnectionShape2.MIDDLE);
                        } else {
                            return stateIn.with(FORM, ParallelConnectionShape2.EDGE_R);
                        }
                    } else if (attachesTo(west, stateInDirection)) {
                        return stateIn.with(FORM, ParallelConnectionShape2.EDGE_L);
                    } else {
                        return stateIn.with(FORM, ParallelConnectionShape2.ONE);
                    }
                case SOUTH:
                    if (attachesTo(west, stateInDirection)) {
                        if (attachesTo(east, stateInDirection)) {
                            return stateIn.with(FORM, ParallelConnectionShape2.MIDDLE);
                        } else {
                            return stateIn.with(FORM, ParallelConnectionShape2.EDGE_R);
                        }
                    } else if (attachesTo(east, stateInDirection)) {
                        return stateIn.with(FORM, ParallelConnectionShape2.EDGE_L);
                    } else {
                        return stateIn.with(FORM, ParallelConnectionShape2.ONE);
                    }
                case EAST:
                    if (attachesTo(north, stateInDirection)) {
                        if (attachesTo(south, stateInDirection)) {
                            return stateIn.with(FORM, ParallelConnectionShape2.MIDDLE);
                        } else {
                            return stateIn.with(FORM, ParallelConnectionShape2.EDGE_L);
                        }
                    } else if (attachesTo(south, stateInDirection)) {
                        return stateIn.with(FORM, ParallelConnectionShape2.EDGE_R);
                    } else {
                        return stateIn.with(FORM, ParallelConnectionShape2.ONE);
                    }
                case WEST:
                    if (attachesTo(south, stateInDirection)) {
                        if (attachesTo(north, stateInDirection)) {
                            return stateIn.with(FORM, ParallelConnectionShape2.MIDDLE);
                        } else {
                            return stateIn.with(FORM, ParallelConnectionShape2.EDGE_L);
                        }
                    } else if (attachesTo(north, stateInDirection)) {
                        return stateIn.with(FORM, ParallelConnectionShape2.EDGE_R);
                    } else {
                        return stateIn.with(FORM, ParallelConnectionShape2.ONE);
                    }
            }
        }
        return stateIn;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {

        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());

        BlockPos pos = context.getBlockPos();
        BlockView iblockreader = context.getWorld();
        BlockState north = iblockreader.getBlockState(pos.north());
        BlockState east = iblockreader.getBlockState(pos.east());
        BlockState south = iblockreader.getBlockState(pos.south());
        BlockState west = iblockreader.getBlockState(pos.west());

        Direction facing = context.getPlayerFacing().getOpposite();

        BlockState stateDefault = this.getDefaultState()
                .with(DIRECTION, facing)
                .with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);

        BlockState stateOne = stateDefault.with(FORM, ParallelConnectionShape2.ONE);
        BlockState stateMiddle = stateDefault.with(FORM, ParallelConnectionShape2.MIDDLE);
        BlockState stateRight = stateDefault.with(FORM, ParallelConnectionShape2.EDGE_R);
        BlockState stateLeft = stateDefault.with(FORM, ParallelConnectionShape2.EDGE_L);

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
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FORM);
    }


    protected boolean attachesTo(BlockState state, Direction facing) {
        Block block = state.getBlock();
        return block == this && state.get(DIRECTION) == facing;
    }
}
