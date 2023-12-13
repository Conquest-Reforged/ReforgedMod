package com.conquestrefabricated.client.gui;

import com.conquestrefabricated.client.gui.palette.component.Style;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;


public abstract class CustomContainerScreen<T extends ScreenHandler> extends HandledScreen<T> {

    private Slot clickedSlot;
    private boolean isRightMouseClick;
    private boolean isOverSlot = false;

    public CustomContainerScreen(T screenContainer, PlayerInventory inv, Text titleIn) {
        super(screenContainer, inv, titleIn);
    }

    protected void onSlotClick(@Nullable Slot slot, int index, int button, SlotActionType type) {
        clickedSlot = slot;
        isRightMouseClick = button == 2; // ?
    }

    @Override
    protected void onMouseClick(@Nullable Slot slot, int index, int button, SlotActionType type) {
        super.onMouseClick(slot, index, button, type);
        onSlotClick(slot, index, button, type);
    }

    protected void setupRender(MatrixStack poseStack) {
        isOverSlot = false;
        RenderSystem.enableBlend();
        poseStack.push();
        poseStack.translate(x, y, 0.0F);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //RenderSystem.enableRescaleNormal();
        //RenderSystem.glMultiTexCoord2f(33986, 240.0F, 240.0F);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    protected void tearDownRender(MatrixStack poseStack) {
        poseStack.pop();
        RenderSystem.disableBlend();
    }

    public void renderDraggedItem(MatrixStack poseStack, int mx, int my, float depth, Style style) {
        int zlevel = 250;
        ItemStack held = getScreenHandler().getCursorStack();
        if (!held.isEmpty()) {
            this.setZOffset(zlevel);
            this.itemRenderer.zOffset = zlevel;

            MatrixStack posestack = RenderSystem.getModelViewStack(); //renderAndDecorateItem requires this special PoseStack
            posestack.push();
            RenderSystem.disableBlend();
            posestack.translate(x + mx, y + my, zlevel); //add leftPos and topPos since this PoseStack is separate from the rest
            RenderSystem.applyModelViewMatrix();

            //Render.drawItemStackHighlight(poseStack, held, -8, -8, style);

            this.itemRenderer.renderInGuiWithOverrides(held, -8, -8);
            this.itemRenderer.renderGuiItemOverlay(textRenderer, held, -8, -8);
            posestack.pop();
            RenderSystem.applyModelViewMatrix();

            this.setZOffset(0);
            this.itemRenderer.zOffset = 0F;

            RenderSystem.enableDepthTest();
        }
    }

    public void renderSlotBackGround(MatrixStack matrixStack, Slot slot, Style style, float depth, float scale) {
        int x = slot.x + 8;
        int y = slot.y + 8;

        matrixStack.push();
        matrixStack.translate(x, y, 1);
        matrixStack.scale(scale, scale, 1);

        // set z-level
        this.setZOffset(0);
        this.itemRenderer.zOffset = 0;

        if (style != null && style.background != null) {
            RenderSystem.setShaderTexture(0, style.background);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            DrawableHelper.drawTexture(matrixStack, -8, -6, 16, 16, 0, 0, 72, 72, 72, 72);
        }

        matrixStack.pop();
    }

    public void renderSlot(MatrixStack poseStack,Slot slot, int mx, int my, float depth, float scale) {
        renderSlot(poseStack, slot, null, mx, my, depth, scale);
    }

    public void renderSlot(MatrixStack poseStack, Slot slot, Style style, int mx, int my, float depth, float scale) {
        int x = slot.x + 8;
        int y = slot.y + 8;
        int zlevel = depth == 1 ? 60 : 0;
        ItemStack itemstack = slot.getStack();

        MatrixStack posestack = RenderSystem.getModelViewStack(); //renderAndDecorateItem requires this special PoseStack
        posestack.push();
        RenderSystem.disableBlend();
        posestack.translate(this.x + x, this.y + y, 1); //add leftPos and topPos since this PoseStack is separate from the rest
        posestack.scale(scale, scale, 1);
        RenderSystem.applyModelViewMatrix();

        // set z-level
        //this.setBlitOffset(zlevel);
        //this.itemRenderer.blitOffset = zlevel;

        /*if (style != null) {
            if (!isOverSlot && isMouseOver(slot, mx, my, 11, scale)) {
                isOverSlot = true;
                Render.drawItemStackHighlight(posestack, itemstack, -8, -8, style.highlightScale, style.hoveredColor);
            } else {
                Render.drawItemStackHighlight(posestack, itemstack, -8, -8, style.highlightScale, style.highlightColor);
            }
        }*/

        // draw item
        this.itemRenderer.renderInGuiWithOverrides(itemstack, -8, -8);
        this.itemRenderer.renderGuiItemOverlay(textRenderer, itemstack, -8, -8, null);

        posestack.pop();
        RenderSystem.applyModelViewMatrix();


        //this.itemRenderer.blitOffset = 0.0F;
        //this.setBlitOffset(0);

        RenderSystem.enableDepthTest();
    }

    public static boolean isMouseOver(Slot slot, int mx, int my, int size, float scale) {
        float delta = size * scale;
        return mx >= slot.x - delta && mx <= slot.x + delta && my >= slot.y - delta && my <= slot.y + delta;
    }

}
