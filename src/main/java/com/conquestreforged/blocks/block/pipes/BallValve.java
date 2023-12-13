package com.conquestreforged.blocks.block.pipes;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.decor.HorizontalDirectionalWaterloggedToggle4;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BallValve extends HorizontalDirectionalWaterloggedToggle4 {

    public static final IntegerProperty VALVE = IntegerProperty.create("valve", 1, 2);

    public BallValve(Props props) {
        super(props);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else if (player.isShiftKeyDown()) {
            level.setBlock(blockPos, state.cycle(VALVE), 3);
            return InteractionResult.SUCCESS;
        } else {
            level.setBlock(blockPos, state.cycle(TOGGLE), 3);
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VALVE, TOGGLE);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TOGGLE) == 1) {
            return BlockVoxelShapes.pipeShape;
        } else {
            switch(state.getValue(DIRECTION)) {
                default:
                case NORTH:
                case SOUTH:
                    return BlockVoxelShapes.pipeShapeHorizontal_NS;
                case EAST:
                case WEST:
                    return BlockVoxelShapes.pipeShapeHorizontal_EW;
            }
        }

    }
}
