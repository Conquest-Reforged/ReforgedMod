package com.conquestreforged.client.gui.search;

import com.conquestreforged.client.utils.CreativeUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;

public class SearchList implements GuiEventListener, NarratableEntry {

    private static final int slotSize = 20;
    private static final int stackSize = 16;
    private static final int stackPad = (slotSize - stackSize) / 2;

    public float x;
    public float y;
    public float scale = 1;

    private int count = 0;
    private int maxRow = 0;
    private final int rows;
    private final int columns;
    private final Slot[] slots;

    private Slot hovered = null;

    public SearchList(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.slots = new Slot[columns * rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                int i = c + r * columns;
                slots[i] = new Slot(c, r);
            }
        }
    }

    public int getHeight() {
        if (count == 0) {
            return 0;
        }
        return Math.round(rows * slotSize * scale);
    }

    public int getWidth() {
        return Math.round(columns * slotSize * scale);
    }

    public int size() {
        return count;
    }

    public int maxSize() {
        return rows * columns;
    }

    public synchronized void add(ItemStack stack) {
        Slot slot = slots[count++];
        slot.stack = stack;
        maxRow = slot.row;
    }

    public synchronized void clear() {
        count = 0;
        maxRow = 0;
        for (Slot slot : slots) {
            slot.stack = ItemStack.EMPTY;
        }
    }

    public void render(PoseStack matrixStack, int mx, int my, int width, int height, float tick) {
        hovered = null;
        for (Slot slot : slots) {
            if (slot.col == 0 && slot.stack.isEmpty()) {
                break;
            }
            if (!slot.fitsOnScreen(width, height)) {
                break;
            }
            slot.render(matrixStack, mx, my);
        }

        if (hovered == null) {
            return;
        }

        String name = hovered.stack.getDisplayName().getString();
        int nameWidth = Minecraft.getInstance().font.width(name);
        int left = width / 2 - nameWidth / 2;
        Minecraft.getInstance().font.draw(matrixStack, name, left, height - 32, 0xFFFFFF);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        for (Slot slot : slots) {
            if (slot.click(mx, my)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateNarration(NarrationElementOutput p_169152_) {
        return;
    }

    @Override
    public NarrationPriority narrationPriority() {
        return NarrationPriority.NONE;
    }

    @Override
    public boolean isActive() {
        return NarratableEntry.super.isActive();
    }

    private class Slot extends GuiComponent {

        private final int col;
        private final int row;

        private ItemStack stack = ItemStack.EMPTY;

        private Slot(int col, int row) {
            this.row = row;
            this.col = col;
        }

        private float left() {
            return x + col * slotSize * scale;
        }

        private float top() {
            return y + row * slotSize * scale;
        }

        private boolean mouseOver(double mx, double my) {
            float l = left();
            float t = top();
            float size = slotSize * scale;
            return mx >= l && mx <= l + size && my >= t && my <= t + size;
        }

        private boolean fitsOnScreen(int width, int height) {
            float right = left() + slotSize * scale;
            float bottom = top() + slotSize * scale;
            return right < width && bottom < height - 32;
        }

        private void render(PoseStack matrixStack, double mx, double my) {
            float top = top();
            float left = left();
            PoseStack posestack = RenderSystem.getModelViewStack();
            posestack.pushPose();
            posestack.translate(left, top, 0);
            posestack.scale(scale, scale, scale);
            RenderSystem.applyModelViewMatrix();
            if (!stack.isEmpty()) {
                Minecraft.getInstance().getItemRenderer().renderGuiItem(stack, stackPad, stackPad);
            }
            posestack.popPose();
            RenderSystem.applyModelViewMatrix();

            matrixStack.pushPose();
            matrixStack.translate(left, top, 0);
            matrixStack.scale(scale, scale, scale);
            fill(matrixStack, 0, 0, slotSize, slotSize, 0x55000000);
            if (mouseOver(mx, my)) {
                hovered = this;
                fill(matrixStack, 1, 1, slotSize-1, slotSize-1, 0x55999999);
            }
            matrixStack.popPose();


            RenderSystem.enableDepthTest();
        }

        private boolean click(double mx, double my) {
            if (mouseOver(mx, my)) {
                LocalPlayer player = Minecraft.getInstance().player;
                if (player == null) {
                    return false;
                }
                if (CreativeUtils.addItemStack(stack.copy(), true)) {
                    Minecraft.getInstance().setScreen(null);
                    return true;
                }
            }
            return false;
        }
    }
}
