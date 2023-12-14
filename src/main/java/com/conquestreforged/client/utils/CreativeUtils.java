package com.conquestreforged.client.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryListener;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;

public class CreativeUtils {

    public static boolean replaceItemStack(ItemStack original, ItemStack stack) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null || !player.getAbilities().creativeMode) {
            return false;
        }

        int slot = player.getInventory().getSlotWithStack(original);
        CreativeInventoryListener listener = new CreativeInventoryListener(MinecraftClient.getInstance());
        player.playerScreenHandler.addListener(listener);
        player.getInventory().setStack(slot, stack);
        player.playerScreenHandler.sendContentUpdates();
        player.playerScreenHandler.removeListener(listener);
        return true;
    }

    public static boolean addItemStack(ItemStack stack) {
        return addItemStack(stack, false);
    }

    public static boolean addItemStack(ItemStack stack, boolean pick) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null || !player.getAbilities().creativeMode) {
            return false;
        }

        int slot = player.getInventory().getSwappableHotbarSlot();
        CreativeInventoryListener listener = new CreativeInventoryListener(MinecraftClient.getInstance());
        player.playerScreenHandler.addListener(listener);
        player.getInventory().setStack(slot, stack);
        player.playerScreenHandler.sendContentUpdates();
        player.playerScreenHandler.removeListener(listener);
        if (pick) {
            player.getInventory().selectedSlot = slot;
        }
        return true;
    }
}
