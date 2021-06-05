package com.conquestreforged.client.gui;

import com.conquestreforged.client.gui.palette.component.Style;
import com.conquestreforged.client.gui.render.Render;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;

public abstract class CustomContainerScreen<T extends Container> extends ContainerScreen<T> {

    private Slot clickedSlot;
    private boolean isRightMouseClick;
    private boolean isOverSlot = false;

    public CustomContainerScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn) {
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

    protected void setupRender() {
        isOverSlot = false;
        RenderSystem.enableBlend();
        RenderSystem.pushMatrix();
        RenderSystem.translatef(leftPos, topPos, 0.0F);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableRescaleNormal();
        RenderSystem.glMultiTexCoord2f(33986, 240.0F, 240.0F);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    protected void tearDownRender() {
        RenderSystem.popMatrix();
        RenderSystem.disableBlend();
    }

    public void renderDraggedItem(int mx, int my, float depth, Style style) {
        int zlevel = 250;
        ItemStack held = inventory.getCarried();
        if (!held.isEmpty()) {
            this.setBlitOffset(zlevel);
            this.itemRenderer.blitOffset = zlevel;
            RenderSystem.pushMatrix();
            RenderSystem.translatef(mx, my, zlevel);
            RenderSystem.enableDepthTest();

            Render.drawItemStackHighlight(held, -8, -8, style);

            this.itemRenderer.renderAndDecorateItem(inventory.player, held, -8, -8);
            this.itemRenderer.renderGuiItemDecorations(font, held, -8, -8, null);
            RenderSystem.popMatrix();
            this.setBlitOffset(0);
            this.itemRenderer.blitOffset = 0F;
        }
    }

    public void renderSlotBackGround(MatrixStack matrixStack, Slot slot, Style style, float depth, float scale) {
        int x = slot.x + 8;
        int y = slot.y + 8;

        RenderSystem.pushMatrix();
        RenderSystem.translatef(x, y, 1);
        RenderSystem.scalef(scale, scale, 1);

        // set z-level
        this.setBlitOffset(0);
        this.itemRenderer.blitOffset = 0;

        if (style != null && style.background != null) {
            Minecraft.getInstance().getTextureManager().bind(style.background);
            AbstractGui.blit(matrixStack, -8, -6, 16, 16, 0, 0, 72, 72, 72, 72);
        }

        RenderSystem.popMatrix();
    }

    public void renderSlot(Slot slot, int mx, int my, float depth, float scale) {
        renderSlot(slot, null, mx, my, depth, scale);
    }

    public void renderSlot(Slot slot, Style style, int mx, int my, float depth, float scale) {
        int x = slot.x + 8;
        int y = slot.y + 8;
        int zlevel = depth == 1 ? 60 : 0;
        ItemStack itemstack = slot.getItem();

        RenderSystem.pushMatrix();
        RenderSystem.disableBlend();
        RenderSystem.translatef(x, y, zlevel);
        RenderSystem.scalef(scale, scale, 1);

        // set z-level
        this.setBlitOffset(zlevel);
        this.itemRenderer.blitOffset = zlevel;

        if (style != null) {
            if (!isOverSlot && isMouseOver(slot, mx, my, 11, scale)) {
                isOverSlot = true;
                Render.drawItemStackHighlight(itemstack, -8, -8, style.highlightScale, style.hoveredColor);
            } else {
                Render.drawItemStackHighlight(itemstack, -8, -8, style.highlightScale, style.highlightColor);
            }
        }

        // draw item
        this.itemRenderer.renderAndDecorateItem(inventory.player, itemstack, -8, -8);
        this.itemRenderer.renderGuiItemDecorations(font, itemstack, -8, -8, null);

        RenderSystem.popMatrix();

        this.itemRenderer.blitOffset = 0.0F;
        this.setBlitOffset(0);
    }

    public static boolean isMouseOver(Slot slot, int mx, int my, int size, float scale) {
        float delta = size * scale;
        return mx >= slot.x - delta && mx <= slot.x + delta && my >= slot.y - delta && my <= slot.y + delta;
    }

}
