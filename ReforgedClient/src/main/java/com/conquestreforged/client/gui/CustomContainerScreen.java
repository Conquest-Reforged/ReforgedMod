package com.conquestreforged.client.gui;

import com.conquestreforged.client.gui.palette.component.Style;
import com.conquestreforged.client.gui.render.Render;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public abstract class CustomContainerScreen<T extends AbstractContainerMenu> extends AbstractContainerScreen<T> {

    private Slot clickedSlot;
    private boolean isRightMouseClick;
    private boolean isOverSlot = false;

    public CustomContainerScreen(T screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }

    protected void onSlotClick(@Nullable Slot slot, int index, int button, ClickType type) {
        clickedSlot = slot;
        isRightMouseClick = button == 2; // ?
    }

    @Override
    protected void slotClicked(@Nullable Slot slot, int index, int button, ClickType type) {
        super.slotClicked(slot, index, button, type);
        onSlotClick(slot, index, button, type);
    }

    protected void setupRender(PoseStack poseStack) {
        isOverSlot = false;
        RenderSystem.enableBlend();
        poseStack.pushPose();
        poseStack.translate(leftPos, topPos, 0.0F);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //RenderSystem.enableRescaleNormal();
        //RenderSystem.glMultiTexCoord2f(33986, 240.0F, 240.0F);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    protected void tearDownRender(PoseStack poseStack) {
        poseStack.popPose();
        RenderSystem.disableBlend();
    }

    public void renderDraggedItem(PoseStack poseStack, int mx, int my, float depth, Style style) {
        int zlevel = 250;
        ItemStack held = getMenu().getCarried();
        if (!held.isEmpty()) {
            this.setBlitOffset(zlevel);
            this.itemRenderer.blitOffset = zlevel;
            poseStack.pushPose();
            poseStack.translate(mx, my, zlevel);
            RenderSystem.enableDepthTest();

            Render.drawItemStackHighlight(poseStack, held, -8, -8, style);

            this.itemRenderer.renderAndDecorateItem(held, -8, -8);
            this.itemRenderer.renderGuiItemDecorations(font, held, -8, -8, null);
            poseStack.popPose();
            this.setBlitOffset(0);
            this.itemRenderer.blitOffset = 0F;
        }
    }

    public void renderSlotBackGround(PoseStack matrixStack, Slot slot, Style style, float depth, float scale) {
        int x = slot.x + 8;
        int y = slot.y + 8;

        matrixStack.pushPose();
        matrixStack.translate(x, y, 1);
        matrixStack.scale(scale, scale, 1);

        // set z-level
        this.setBlitOffset(0);
        this.itemRenderer.blitOffset = 0;

        if (style != null && style.background != null) {
            Minecraft.getInstance().getTextureManager().bindForSetup(style.background);
            GuiComponent.blit(matrixStack, -8, -6, 16, 16, 0, 0, 72, 72, 72, 72);
        }

        matrixStack.popPose();
    }

    public void renderSlot(PoseStack poseStack,Slot slot, int mx, int my, float depth, float scale) {
        renderSlot(poseStack, slot, null, mx, my, depth, scale);
    }

    public void renderSlot(PoseStack poseStack, Slot slot, Style style, int mx, int my, float depth, float scale) {
        int x = slot.x + 8;
        int y = slot.y + 8;
        int zlevel = depth == 1 ? 60 : 0;
        ItemStack itemstack = slot.getItem();

        poseStack.pushPose();
        RenderSystem.disableBlend();
        poseStack.translate(x, y, zlevel);
        poseStack.scale(scale, scale, 1);

        // set z-level
        this.setBlitOffset(zlevel);
        this.itemRenderer.blitOffset = zlevel;

        if (style != null) {
            if (!isOverSlot && isMouseOver(slot, mx, my, 11, scale)) {
                isOverSlot = true;
                Render.drawItemStackHighlight(poseStack, itemstack, -8, -8, style.highlightScale, style.hoveredColor);
            } else {
                Render.drawItemStackHighlight(poseStack, itemstack, -8, -8, style.highlightScale, style.highlightColor);
            }
        }

        // draw item
        this.itemRenderer.renderAndDecorateItem(itemstack, -8, -8);
        this.itemRenderer.renderGuiItemDecorations(font, itemstack, -8, -8, null);

        poseStack.popPose();

        this.itemRenderer.blitOffset = 0.0F;
        this.setBlitOffset(0);
    }

    public static boolean isMouseOver(Slot slot, int mx, int my, int size, float scale) {
        float delta = size * scale;
        return mx >= slot.x - delta && mx <= slot.x + delta && my >= slot.y - delta && my <= slot.y + delta;
    }

}
