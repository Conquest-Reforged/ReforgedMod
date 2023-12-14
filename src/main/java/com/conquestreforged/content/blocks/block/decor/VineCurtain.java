package com.conquestreforged.content.blocks.block.decor;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.VineBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class VineCurtain extends VineBlock {

    public VineCurtain(Settings properties) {
        super(properties);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        return true;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        return stateIn;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext useContext) {
        if (useContext.getStack().getItem() == this.asItem()) {
            return true;
        }
        return false;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        boolean flag = blockstate.getBlock() == this;
        BlockState blockstate1 = flag ? blockstate : this.getDefaultState();

        for(Direction direction : context.getPlacementDirections()) {
            if (direction != Direction.DOWN) {
                BooleanProperty booleanproperty = getFacingProperty(direction);
                boolean flag1 = flag && blockstate.get(booleanproperty);
                if (!flag1) {
                    return blockstate1.with(booleanproperty, true);
                }
            } else if (direction == Direction.DOWN) {
                Direction direction1 = context.getPlayerFacing();
                BooleanProperty booleanproperty = getFacingProperty(direction1);
                boolean flag1 = flag && blockstate.get(booleanproperty);
                if (!flag1) {
                    return blockstate1.with(booleanproperty, true);
                }
            }
        }
        return flag ? blockstate1 : null;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }
}
