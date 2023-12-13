package com.conquestrefabricated.client.gui.render;

import com.conquestrefabricated.client.gui.palette.component.Style;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

/**
 * @author dags <dags@dags.me>
 */
public class Render {

    private static final int HIDE_MOUSE_MODE = 212995;
    private static final int SHOW_MOUSE_MODE = 212993;

    public static void hideMouse() {
        double mx = MinecraftClient.getInstance().mouse.getX();
        double my = MinecraftClient.getInstance().mouse.getY();
        InputUtil.setCursorParameters(MinecraftClient.getInstance().getWindow().getHandle(), HIDE_MOUSE_MODE, mx, my);
    }

    public static void showMouse() {
        double mx = MinecraftClient.getInstance().getWindow().getWidth() / 2D;
        double my = MinecraftClient.getInstance().getWindow().getHeight() / 2D;
        InputUtil.setCursorParameters(MinecraftClient.getInstance().getWindow().getHandle(), SHOW_MOUSE_MODE, mx, my);
    }

    public static void drawTexture(Identifier texture, MatrixStack matrixStack, int left, int top, int width, int height, float u, float v) {
        drawTexture(texture, matrixStack, left, top, width, height, u, v, width, height);
    }

    public static void drawTexture(Identifier texture, MatrixStack matrixStack, int left, int top, int width, int height, float u, float v, int umax, int vmax) {
        RenderSystem.setShaderTexture(0, texture);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        DrawableHelper.drawTexture(matrixStack, left, top, u, v, width, height, umax, vmax);
    }

    public static void drawTexture(Identifier texture, MatrixStack matrixStack, int left, int top, int blitOffset, float u, float v, int umax, int vmax) {
        RenderSystem.setShaderTexture(0, texture);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        DrawableHelper.drawTexture(matrixStack, left, top, blitOffset, u, v, umax, vmax, 256, 256);
    }

    public static void drawItemStackHighlight(MatrixStack poseStack, ItemStack stack, int x, int y, Style style) {
        drawItemStackHighlight(poseStack, stack, x, y, style.highlightScale, style.highlightColor);
    }

    public static void drawItemStackHighlight(MatrixStack poseStack, ItemStack stack, int x, int y, float scale, int color) {
        poseStack.push();
        //RenderSystem.setupOutline();
        poseStack.scale(scale, scale, 1F);
        BakedModel model = MinecraftClient.getInstance().getItemRenderer().getModels().getModel(stack);
        ModelRender.renderModel(poseStack, model, x, y, color);
        //RenderSystem.teardownOutline();
        poseStack.pop();
    }

    public static void drawBlockModel(MatrixStack poseStack, BlockState state, int x, int y, float scale) {
        poseStack.push();
        poseStack.translate(x, y, 0);
        poseStack.scale(scale, scale, 1F);
        BakedModel model = MinecraftClient.getInstance().getBlockRenderManager().getModel(state);
        ModelRender.renderModel(poseStack, state, model, 0, 0, 0x00FFFFFF);
        poseStack.pop();
    }
}
