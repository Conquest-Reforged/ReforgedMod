package com.conquestreforged.client.events;

import com.conquestreforged.core.item.ItemUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockPicker {

    @SubscribeEvent
    public static void onPick(InputEvent.ClickInputEvent event) {
        if (event.getKeyBinding() != Minecraft.getInstance().options.keyPickItem) {
            return;
        }

        if (!Screen.hasControlDown()) {
            return;
        }

        Player player = Minecraft.getInstance().player;
        if (player == null || !player.getAbilities().instabuild) {
            return;
        }

        HitResult result = Minecraft.getInstance().hitResult;
        if (result == null || result.getType() != HitResult.Type.BLOCK) {
            return;
        }

        BlockPos pos = ((BlockHitResult) result).getBlockPos();
        BlockState state = player.level.getBlockState(pos);
        if (state.hasBlockEntity()) {
            return;
        }

        ItemStack stack = ItemUtils.fromState(state);
        player.getInventory().setPickedItem(stack);
        Minecraft.getInstance().gameMode.handleCreativeModeItemAdd(player.getItemInHand(InteractionHand.MAIN_HAND), 36 + player.getInventory().selected);
        event.setCanceled(true);
    }
}
