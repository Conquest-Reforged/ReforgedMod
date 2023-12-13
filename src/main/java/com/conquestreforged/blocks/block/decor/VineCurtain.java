package com.conquestreforged.blocks.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class VineCurtain extends VineBlock {

    public VineCurtain(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return true;
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return stateIn;
    }

    @Override
    public void m_7458_(BlockState state, ServerLevel world, BlockPos pos, Random random) {
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        if (useContext.getItemInHand().getItem() == this.asItem()) {
            return true;
        }
        return false;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        boolean flag = blockstate.getBlock() == this;
        BlockState blockstate1 = flag ? blockstate : this.defaultBlockState();

        for(Direction direction : context.getNearestLookingDirections()) {
            if (direction != Direction.DOWN) {
                BooleanProperty booleanproperty = getPropertyForFace(direction);
                boolean flag1 = flag && blockstate.getValue(booleanproperty);
                if (!flag1) {
                    return blockstate1.setValue(booleanproperty, true);
                }
            } else if (direction == Direction.DOWN) {
                Direction direction1 = context.getHorizontalDirection();
                BooleanProperty booleanproperty = getPropertyForFace(direction1);
                boolean flag1 = flag && blockstate.getValue(booleanproperty);
                if (!flag1) {
                    return blockstate1.setValue(booleanproperty, true);
                }
            }
        }
        return flag ? blockstate1 : null;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }
}
