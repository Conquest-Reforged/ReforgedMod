package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.block.directional.HorizontalDirectionalWaterlogged;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class HorizontalDirectionalWaterloggedToggle5 extends HorizontalDirectionalWaterlogged {

    public static final IntegerProperty TOGGLE = IntegerProperty.create("toggle", 1, 5);

    public HorizontalDirectionalWaterloggedToggle5(Props props) {
        super(props);
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(TOGGLE, 1);
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            level.setBlock(blockPos, state.cycle(TOGGLE), 3);
            return InteractionResult.SUCCESS;
        }
    }
}
