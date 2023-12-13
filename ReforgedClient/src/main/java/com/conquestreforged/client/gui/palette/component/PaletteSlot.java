package com.conquestreforged.client.gui.palette.component;

import com.conquestreforged.client.gui.palette.PaletteContainer;
import com.conquestreforged.client.gui.palette.shape.Bounds;
import com.conquestreforged.client.gui.palette.shape.Point;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class PaletteSlot extends Slot {

    private static final ResourceLocation SLOT = new ResourceLocation("conquest:textures/gui/picker/slot.png");

    private final Style style;
    private final Bounds bounds;

    public PaletteSlot(IInventory inventory, Style style, Bounds bounds, int index, int x, int y) {
        super(inventory, index, x - 8, y - 8);
        this.style = style;
        this.bounds = bounds;
        setBackground(SLOT, SLOT);
    }

    public Style getStyle() {
        return style;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public boolean isMouseOver(int mx, int my) {
        return mx >= xPos - 11 && mx <= xPos + 11 && my >= yPos - 11 && my <= yPos + 11;
    }

    public ResourceLocation getBackground() {
        return SLOT;
    }

    @Override
    public ItemStack getStack() {
        return super.getStack().copy();
    }

    @Override
    public void putStack(ItemStack stack) {
//        super.putStack(stack);
    }

    @Override
    public ItemStack decrStackSize(int amount) {
        return getStack();
    }

    public float getScale(int mx, int my, PaletteSettings settings) {
        if (!style.fixedScale) {
            float d2 = Point.distance2(xPos, yPos, mx, my);
            float radius = PaletteContainer.RADIUS;
            float rad2 = radius * radius;
            float alpha = (rad2 - d2) / rad2;
            float scale = style.scale;
            if (alpha > (1 - settings.zoomSpread)) {
                scale += Math.min(Math.max(settings.zoomCurve.apply(alpha) * settings.zoomScale, 0), 2.5F);
            }
            return scale;
        }
        return style.scale;
    }
}
