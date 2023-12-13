package com.conquestreforged.client.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.inventory.CreativeCraftingListener;
import net.minecraft.item.ItemStack;

public class CreativeUtils {

    public static boolean replaceItemStack(ItemStack original, ItemStack stack) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player == null || !player.abilities.isCreativeMode) {
            return false;
        }

        int slot = player.inventory.getSlotFor(original);
        CreativeCraftingListener listener = new CreativeCraftingListener(Minecraft.getInstance());
        player.container.addListener(listener);
        player.inventory.setInventorySlotContents(slot, stack);
        player.container.detectAndSendChanges();
        player.container.removeListener(listener);
        return true;
    }

    public static boolean addItemStack(ItemStack stack) {
        return addItemStack(stack, false);
    }

    public static boolean addItemStack(ItemStack stack, boolean pick) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player == null || !player.abilities.isCreativeMode) {
            return false;
        }

        int slot = player.inventory.getBestHotbarSlot();
        CreativeCraftingListener listener = new CreativeCraftingListener(Minecraft.getInstance());
        player.container.addListener(listener);
        player.inventory.setInventorySlotContents(slot, stack);
        player.container.detectAndSendChanges();
        player.container.removeListener(listener);
        if (pick) {
            player.inventory.currentItem = slot;
        }
        return true;
    }
}
