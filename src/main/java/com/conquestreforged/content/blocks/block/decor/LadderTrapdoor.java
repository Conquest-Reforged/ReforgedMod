package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.block.Trapdoor;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

@Render(RenderLayer.CUTOUT)
public class LadderTrapdoor extends Trapdoor {

    public LadderTrapdoor(Settings properties) {
        super(properties);
    }

    public boolean isLadder(BlockState state, WorldView reader, BlockPos pos, LivingEntity entity) {
        return state.get(Trapdoor.OPEN);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else {
            state = state.cycle(OPEN);
            world.setBlockState(pos, state, 2);
            if (state.get(WATERLOGGED)) {
                world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }

            this.playToggleSound(player, world, pos, state.get(OPEN));
            return ActionResult.success(world.isClient);
        }
    }
}
