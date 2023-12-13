package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

@Render(RenderLayer.CUTOUT)
public class Door extends DoorBlock {

    public Door(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        state = state.cycle(OPEN);
        level.setBlock(blockPos, state, 10);
        level.levelEvent(player, state.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), blockPos, 0);
        return InteractionResult.SUCCESS;
    }

    private int getCloseSound() {
        return this.material == Material.METAL ? 1011 : 1012;
    }

    private int getOpenSound() {
        return this.material == Material.METAL ? 1005 : 1006;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockState stateDown = reader.getBlockState(pos.below());
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return true;
        } else {
            return stateDown.getBlock() == this;
        }
    }
}
