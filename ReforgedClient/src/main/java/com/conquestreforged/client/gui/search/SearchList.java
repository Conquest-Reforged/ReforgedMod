package com.conquestreforged.client.gui.search;

import com.conquestreforged.client.utils.CreativeUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.item.ItemStack;

public class SearchList implements IGuiEventListener {

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

    public void render(int mx, int my, int width, int height, float tick) {
        hovered = null;
        for (Slot slot : slots) {
            if (slot.col == 0 && slot.stack.isEmpty()) {
                break;
            }
            if (!slot.fitsOnScreen(width, height)) {
                break;
            }
            slot.render(mx, my);
        }

        if (hovered == null) {
            return;
        }

        String name = hovered.stack.getDisplayName().getFormattedText();
        int nameWidth = Minecraft.getInstance().fontRenderer.getStringWidth(name);
        int left = width / 2 - nameWidth / 2;
        Minecraft.getInstance().fontRenderer.drawString(name, left, height - 32, 0xFFFFFF);
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

    private class Slot extends AbstractGui {

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

        private void render(double mx, double my) {
            float top = top();
            float left = left();
            RenderSystem.pushMatrix();
            RenderSystem.translatef(left, top, 0);
            RenderSystem.scalef(scale, scale, scale);
            fill(0, 0, slotSize, slotSize, 0x55000000);
            if (mouseOver(mx, my)) {
                hovered = this;
                fill(1, 1, slotSize-1, slotSize-1, 0x55999999);
            }
            if (!stack.isEmpty()) {
                Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(stack, stackPad, stackPad);
            }
            RenderSystem.popMatrix();
        }

        private boolean click(double mx, double my) {
            if (mouseOver(mx, my)) {
                ClientPlayerEntity player = Minecraft.getInstance().player;
                if (player == null) {
                    return false;
                }
                if (CreativeUtils.addItemStack(stack.copy(), true)) {
                    Minecraft.getInstance().displayGuiScreen(null);
                    return true;
                }
            }
            return false;
        }
    }
}
