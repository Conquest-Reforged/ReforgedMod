package com.conquestreforged.client.events;

import com.conquestreforged.core.item.ItemUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class BlockPicker {

    public static ItemStack onPick() {
        if (!Screen.hasControlDown()) {
            return ItemStack.EMPTY;
        }

        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null || !player.getAbilities().creativeMode) {
            return ItemStack.EMPTY;
        }

        HitResult result = MinecraftClient.getInstance().crosshairTarget;
        if (result == null) {
            return ItemStack.EMPTY;
        }

        BlockPos pos = new BlockPos(result.getPos());
        BlockState state = player.world.getBlockState(pos);
        if (state.hasBlockEntity()) {
            return ItemStack.EMPTY;
        }

        ItemStack stack = ItemUtils.fromState(state);
        player.getInventory().addPickBlock(stack);
        MinecraftClient.getInstance().interactionManager.clickCreativeStack(player.getStackInHand(Hand.MAIN_HAND), 36 + player.getInventory().selectedSlot);
        return stack;
    }
}
