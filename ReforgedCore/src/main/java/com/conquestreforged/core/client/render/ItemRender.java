package com.conquestreforged.core.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class ItemRender {

    public static void render(ItemStack stack, int left, int top) {
        render(stack, left, top, 1F, 1F);
    }

    public static void render(ItemStack stack, int left, int top, float brightness, float alpha) {
        render(stack, left, top, brightness, alpha, 1F);
    }

    public static void render(ItemStack stack, int left, int top, float brightness, float alpha, float scale) {
//        RenderHelper.enableGUIStandardItemLighting(); <- 1.12 code, not sure what the equiv is!
        RenderSystem.setupGui3DDiffuseLighting(); // setupGuiFlatDiffuseLighting ?

        RenderSystem.pushMatrix();
        RenderSystem.translated(left, top, 0);
        RenderSystem.scaled(scale, scale, 1F);
        Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(stack, 0, 0);
        Minecraft.getInstance().getItemRenderer().renderItemOverlayIntoGUI(Minecraft.getInstance().fontRenderer, stack, 0, 0, null);
        RenderSystem.popMatrix();

//        RenderHelper.disableStandardItemLighting(); <- 1.12 ??
    }
}
