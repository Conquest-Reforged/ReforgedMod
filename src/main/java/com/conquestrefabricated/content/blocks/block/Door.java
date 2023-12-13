package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

@Render(RenderLayer.CUTOUT)
public class Door extends DoorBlock {

    public Door(Settings properties) {
        super(properties);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        state = state.cycle(OPEN);
        level.setBlockState(blockPos, state, 10);
        level.syncWorldEvent(player, state.get(OPEN) ? this.getOpenSoundEventId() : this.getCloseSoundEventId(), blockPos, 0);
        return ActionResult.SUCCESS;
    }

    private int getCloseSoundEventId() {
        return this.material == Material.METAL ? 1011 : 1012;
    }

    private int getOpenSoundEventId() {
        return this.material == Material.METAL ? 1005 : 1006;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        BlockState stateDown = reader.getBlockState(pos.down());
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            return true;
        } else {
            return stateDown.getBlock() == this;
        }
    }
}
