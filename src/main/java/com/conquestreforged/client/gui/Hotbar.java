package com.conquestreforged.client.gui;

import com.conquestreforged.client.gui.render.Render;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;

public class Hotbar {

    private static final Identifier HOTBAR = new Identifier("minecraft:textures/gui/widgets.png");

    private final Inventory inventory;

    public Hotbar(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getSlotSize() {
        return 20;
    }

    public int getHeight() {
        return getSlotSize() - 1;
    }

    public void renderBackground(Screen screen, MatrixStack matrixStack) {
        int u = 0;
        int v = 0;
        int uMax = 182;
        int vMax = 22;
        int left = (screen.width / 2) - (uMax / 2);
        int top = screen.height - vMax;
        RenderSystem.enableBlend();
        Render.drawTexture(HOTBAR, matrixStack, left, top, screen.getZOffset(), u, v, uMax, vMax);
        RenderSystem.disableBlend();
    }

    public void addTo(AbstractContainer container, int left, int top) {
        int hotbarWidth = (9 * getSlotSize());
        int x = left - (hotbarWidth / 2) + 2;
        for (int i = 0; i < 9; ++i) {
            int dx = i * getSlotSize();
            container.addSlot(new Slot(inventory, i, x + dx, top));
        }
    }
}
