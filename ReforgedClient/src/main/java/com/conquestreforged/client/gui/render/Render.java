package com.conquestreforged.client.gui.render;

import com.conquestreforged.client.gui.palette.component.Style;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.resources.model.BakedModel;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

/**
 * @author dags <dags@dags.me>
 */
public class Render {

    private static final int HIDE_MOUSE_MODE = 212995;
    private static final int SHOW_MOUSE_MODE = 212993;

    public static void hideMouse() {
        double mx = Minecraft.getInstance().mouseHandler.xpos();
        double my = Minecraft.getInstance().mouseHandler.ypos();
        InputConstants.grabOrReleaseMouse(Minecraft.getInstance().getWindow().getWindow(), HIDE_MOUSE_MODE, mx, my);
    }

    public static void showMouse() {
        double mx = Minecraft.getInstance().getWindow().getWidth() / 2D;
        double my = Minecraft.getInstance().getWindow().getHeight() / 2D;
        InputConstants.grabOrReleaseMouse(Minecraft.getInstance().getWindow().getWindow(), SHOW_MOUSE_MODE, mx, my);
    }

    public static void drawTexture(ResourceLocation texture, PoseStack matrixStack, int left, int top, int width, int height, float u, float v) {
        drawTexture(texture, matrixStack, left, top, width, height, u, v, width, height);
    }

    public static void drawTexture(ResourceLocation texture, PoseStack matrixStack, int left, int top, int width, int height, float u, float v, int umax, int vmax) {
        Minecraft.getInstance().getTextureManager().bindForSetup(texture);
        GuiComponent.blit(matrixStack, left, top, u, v, width, height, umax, vmax);
    }

    public static void drawTexture(ResourceLocation texture, PoseStack matrixStack, int left, int top, int blitOffset, float u, float v, int umax, int vmax) {
        Minecraft.getInstance().getTextureManager().bindForSetup(texture);
        GuiComponent.blit(matrixStack, left, top, blitOffset, u, v, umax, vmax, 256, 256);
    }

    public static void drawItemStackHighlight(PoseStack poseStack, ItemStack stack, int x, int y, Style style) {
        drawItemStackHighlight(poseStack, stack, x, y, style.highlightScale, style.highlightColor);
    }

    public static void drawItemStackHighlight(PoseStack poseStack, ItemStack stack, int x, int y, float scale, int color) {
        poseStack.pushPose();
        //RenderSystem.setupOutline();
        poseStack.scale(scale, scale, 1F);
        BakedModel model = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getItemModel(stack);
        ModelRender.renderModel(poseStack, model, x, y, color);
        //RenderSystem.teardownOutline();
        poseStack.popPose();
    }

    public static void drawBlockModel(PoseStack poseStack,BlockState state, int x, int y, float scale) {
        poseStack.pushPose();
        poseStack.translate(x, y, 0);
        poseStack.scale(scale, scale, 1F);
        BakedModel model = Minecraft.getInstance().getBlockRenderer().getBlockModel(state);
        ModelRender.renderModel(poseStack, state, model, 0, 0, 0x00FFFFFF);
        poseStack.popPose();
    }
}
