package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class DoubleToggleBlock extends DoubleBlock {
    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    public DoubleToggleBlock(Props props) {
        super(props);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(OPEN, Boolean.valueOf(false)));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (state.getValue(OPEN)) {
            state = state.setValue(OPEN, Boolean.valueOf(false));
            level.setBlock(blockPos, state, 10);
        } else {
            state = state.setValue(OPEN, Boolean.valueOf(true));
            level.setBlock(blockPos, state, 10);
        }

        boolean flag = state.getValue(OPEN);
        level.levelEvent(player, flag ? 1008 : 1014, blockPos, 0);
        level.gameEvent(player, flag ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, OPEN);
    }
}
