package com.conquestreforged.client.gui;

import com.conquestreforged.client.gui.render.Render;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;

public class Hotbar {

    private static final ResourceLocation HOTBAR = new ResourceLocation("minecraft:textures/gui/widgets.png");

    private final PlayerInventory inventory;

    public Hotbar(PlayerInventory inventory) {
        this.inventory = inventory;
    }

    public PlayerInventory getInventory() {
        return inventory;
    }

    public int getSlotSize() {
        return 20;
    }

    public int getHeight() {
        return getSlotSize() - 1;
    }

    public void renderBackground(Screen screen) {
        int u = 0;
        int v = 0;
        int uMax = 182;
        int vMax = 22;
        int left = (screen.width / 2) - (uMax / 2);
        int top = screen.height - vMax;
        RenderSystem.enableBlend();
        Render.drawTexture(HOTBAR, left, top, screen.getBlitOffset(), u, v, uMax, vMax);
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
