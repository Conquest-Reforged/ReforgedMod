package com.conquestreforged.content.blocks.block.pipes;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.content.blocks.block.decor.HorizontalDirectionalWaterloggedToggle4;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class BallValve extends HorizontalDirectionalWaterloggedToggle4 {

    public static final IntProperty VALVE = IntProperty.of("valve", 1, 2);

    public BallValve(Props props) {
        super(props);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else if (player.isSneaking()) {
            level.setBlockState(blockPos, state.cycle(VALVE), 3);
            return ActionResult.SUCCESS;
        } else {
            level.setBlockState(blockPos, state.cycle(TOGGLE), 3);
            return ActionResult.SUCCESS;
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VALVE, TOGGLE);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TOGGLE) == 1) {
            return BlockVoxelShapes.pipeShape;
        } else {
            switch(state.get(DIRECTION)) {
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
