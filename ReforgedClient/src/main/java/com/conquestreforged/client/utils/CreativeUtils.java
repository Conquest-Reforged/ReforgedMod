package com.conquestreforged.client.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.gui.screens.inventory.CreativeInventoryListener;
import net.minecraft.world.item.ItemStack;

public class CreativeUtils {

    public static boolean replaceItemStack(ItemStack original, ItemStack stack) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null || !player.getAbilities().instabuild) {
            return false;
        }

        int slot = player.getInventory().findSlotMatchingItem(original);
        CreativeInventoryListener listener = new CreativeInventoryListener(Minecraft.getInstance());
        player.inventoryMenu.addSlotListener(listener);
        player.getInventory().setItem(slot, stack);
        player.inventoryMenu.broadcastChanges();
        player.inventoryMenu.removeSlotListener(listener);
        return true;
    }

    public static boolean addItemStack(ItemStack stack) {
        return addItemStack(stack, false);
    }

    public static boolean addItemStack(ItemStack stack, boolean pick) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null || !player.getAbilities().instabuild) {
            return false;
        }

        int slot = player.getInventory().getSuitableHotbarSlot();
        CreativeInventoryListener listener = new CreativeInventoryListener(Minecraft.getInstance());
        player.inventoryMenu.addSlotListener(listener);
        player.getInventory().setItem(slot, stack);
        player.inventoryMenu.broadcastChanges();
        player.inventoryMenu.removeSlotListener(listener);
        if (pick) {
            player.getInventory().selected = slot;
        }
        return true;
    }
}
