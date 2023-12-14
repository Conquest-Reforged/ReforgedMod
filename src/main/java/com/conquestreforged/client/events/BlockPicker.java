package com.conquestreforged.client.events;

import com.conquestreforged.core.item.ItemUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlockPicker {

    public static ItemStack onPick() {
        if (!Screen.hasControlDown()) {
            return ItemStack.EMPTY;
        }

        Player player = Minecraft.getInstance().player;
        if (player == null || !player.getAbilities().instabuild) {
            return ItemStack.EMPTY;
        }

        HitResult result = Minecraft.getInstance().hitResult;
        if (result == null) {
            return ItemStack.EMPTY;
        }

        BlockPos pos = new BlockPos((int) result.getLocation().x, (int) result.getLocation().y, (int) result.getLocation().z));
        BlockState state = player.level().getBlockState(pos);
        if (state.hasBlockEntity()) {
            return ItemStack.EMPTY;
        }

        ItemStack stack = ItemUtils.fromState(state);
        player.getInventory().add(stack);
        Minecraft.getInstance().gameMode.handleCreativeModeItemAdd(player.getItemInHand(InteractionHand.MAIN_HAND), 36 + player.getInventory().selected);
        return stack;
    }
}
