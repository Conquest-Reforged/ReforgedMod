package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.block.Trapdoor;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

@Render(RenderLayer.CUTOUT)
public class LadderTrapdoor extends Trapdoor {

    public LadderTrapdoor(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isLadder(BlockState state, LevelReader reader, BlockPos pos, LivingEntity entity) {
        return state.getValue(Trapdoor.OPEN);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            state = state.cycle(OPEN);
            world.setBlock(pos, state, 2);
            if (state.getValue(WATERLOGGED)) {
                world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
            }

            this.playSound(player, world, pos, state.getValue(OPEN));
            return InteractionResult.sidedSuccess(world.isClientSide);
        }
    }
}
