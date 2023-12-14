package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class DoubleToggleBlock extends DoubleBlock {
    public static final BooleanProperty OPEN = BooleanProperty.of("open");

    public DoubleToggleBlock(Props props) {
        super(props);
        this.setDefaultState(this.stateManager.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(OPEN, Boolean.valueOf(false)));
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (state.get(OPEN)) {
            state = state.with(OPEN, Boolean.valueOf(false));
            level.setBlockState(blockPos, state, 10);
        } else {
            state = state.with(OPEN, Boolean.valueOf(true));
            level.setBlockState(blockPos, state, 10);
        }

        boolean flag = state.get(OPEN);
        level.syncWorldEvent(player, flag ? 1008 : 1014, blockPos, 0);
        level.emitGameEvent(player, flag ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
        return ActionResult.success(level.isClient);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HALF, OPEN);
    }
}
