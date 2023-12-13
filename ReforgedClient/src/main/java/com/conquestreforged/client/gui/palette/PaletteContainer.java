package com.conquestreforged.client.gui.palette;

import com.conquestreforged.client.gui.AbstractContainer;
import com.conquestreforged.client.gui.Hotbar;
import com.conquestreforged.client.gui.palette.component.PaletteSettings;
import com.conquestreforged.client.gui.palette.component.PaletteSlot;
import com.conquestreforged.client.gui.palette.component.Style;
import com.conquestreforged.client.gui.palette.shape.Bounds;
import com.conquestreforged.client.gui.palette.shape.FloatMath;
import com.conquestreforged.client.gui.palette.shape.Point;
import com.conquestreforged.client.gui.palette.shape.Polygon;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class PaletteContainer extends AbstractContainer {

    public static final ContainerType<PaletteContainer> TYPE = new ContainerType<>(PaletteContainer::new);
    private static final ResourceLocation BACKGROUND = new ResourceLocation("conquest:textures/gui/picker/slot.png");

    public static final int RADIUS = 65;
    private static final int EDGES = 6;
    private static final int PADDING = 40;
    private static final int ANGLE_OFFSET = -90;

    private final int radialCount;
    private final Style centerStyle;
    private final Style radialStyle;
    private final Style draggedStyle;
    private final IInventory paletteInventory;

    private final Hotbar hotbar;

    private PaletteContainer(int id, PlayerInventory inventory) {
        super(TYPE, id);
        this.radialCount = 0;
        this.hotbar = new Hotbar(inventory);
        this.paletteInventory = inventory;
        this.centerStyle = Style.center(BACKGROUND);
        this.draggedStyle = Style.center(BACKGROUND);
        this.radialStyle = Style.radial(0, BACKGROUND);
    }

    public PaletteContainer(PlayerInventory inventory, IInventory palette) {
        super(TYPE, 0);
        this.radialCount = palette.getSizeInventory() - 1;
        this.hotbar = new Hotbar(inventory);
        this.paletteInventory = palette;
        this.centerStyle = Style.center(BACKGROUND);
        this.draggedStyle = Style.center(BACKGROUND);
        this.radialStyle = Style.radial(radialCount, BACKGROUND);
    }

    public void updateStyle(PaletteSettings settings) {
        draggedStyle.highlightScale = settings.highlightScale;
        draggedStyle.highlightColor = settings.highlightColor;
        draggedStyle.highlightColor = settings.selectedColor;

        radialStyle.highlightScale = settings.highlightScale;
        radialStyle.highlightColor = settings.highlightColor;
        radialStyle.hoveredColor = settings.hoveredColor;

        centerStyle.highlightScale = settings.highlightScale;
        centerStyle.highlightColor = settings.highlightColor;
        centerStyle.hoveredColor = settings.hoveredColor;
    }

    public Style getDraggedStyle() {
        return draggedStyle;
    }

    public void init(ContainerScreen<?> screen) {
        int centerX = screen.getXSize() / 2;
        int centerY = screen.getYSize() / 2;

        inventorySlots.clear();

        // add the central slot first
        addSlot(new PaletteSlot(paletteInventory, centerStyle, Bounds.NONE, 0, centerX, centerY));

        Polygon polygon = new Polygon(EDGES, RADIUS, PADDING, PADDING);
        polygon.init(centerX, centerY);

        float spacing = 360F / radialCount;
        float halfSpacing = spacing / 2F;
        for (int slotIndex = 1; slotIndex < paletteInventory.getSizeInventory(); slotIndex++) {
            int posIndex = slotIndex - 1;
            float angle = FloatMath.clampAngle((posIndex * spacing) + ANGLE_OFFSET);
            Point pos = polygon.getPosition(angle);
            Bounds bounds = polygon.getBounds(angle, halfSpacing);
            // add each radial slot
            addSlot(new PaletteSlot(paletteInventory, radialStyle, bounds, slotIndex, pos.x, pos.y));

            if (slotIndex >= paletteInventory.getSizeInventory()) {
                throw new UnsupportedOperationException();
            }
        }

        // screens art translated to guiTop so need to calc the bottom relative to y=guiTop rather than y=0
        int screenBottom = screen.height - screen.getGuiTop();
        int top = screenBottom - hotbar.getHeight();
        hotbar.addTo(this, centerX, top);
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity player, int index) {
        if (index >= inventorySlots.size() - 9 && index < inventorySlots.size()) {
            Slot slot = inventorySlots.get(index);
            if (slot != null && slot.getHasStack()) {
                slot.putStack(ItemStack.EMPTY);
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canDragIntoSlot(Slot slot) {
        return slot.inventory != paletteInventory;
    }

    @Override
    public boolean canMergeSlot(ItemStack stack, Slot slot) {
        return slot.inventory != paletteInventory;
    }

    @Override
    public boolean canInteractWith(PlayerEntity player) {
        return player.isCreative();
    }

    public Hotbar getHotbar() {
        return hotbar;
    }

    public IInventory getPaletteInventory() {
        return paletteInventory;
    }

    public void visitHotbar(Consumer<Slot> consumer) {
        for (int i = inventorySlots.size() - 9; i < inventorySlots.size(); i++) {
            consumer.accept(getSlot(i));
        }
    }

    public void visitCenter(Consumer<PaletteSlot> consumer) {
        PaletteSlot slot = (PaletteSlot) getSlot(0);
        consumer.accept(slot);
    }

    public void visitRadius(int mouseX, int mouseY, BiConsumer<PaletteSlot, Float> consumer) {
        final Slot closest = getClosestSlot(mouseX, mouseY, false);
        if (closest == null) {
            return;
        }

        final int index = (closest.slotNumber - 1);
        visitRadialSlot(index, 0, consumer);

        for (int i = 1, visited = 0; visited < radialCount; i++, visited += 2) {
            if (visited + 1 >= radialCount) {
                break;
            }

            visitRadialSlot(index - i, i, consumer);

            if (visited + 2 >= radialCount) {
                break;
            }

            visitRadialSlot(index + i, i, consumer);
        }
    }

    private void visitRadialSlot(int index, int relativeIndex, BiConsumer<PaletteSlot, Float> consumer) {
        int slotIndex = wrapSlotIndex(index);
        float depth = getRelativeDepth(relativeIndex);
        PaletteSlot slot = (PaletteSlot) getSlot(slotIndex + 1); // slot 0 == center slot so add 1
        consumer.accept(slot, depth);
    }

    private int wrapSlotIndex(int index) {
        if (index < 0) {
            return radialCount + index;
        } else if (index >= radialCount) {
            return index - radialCount;
        } else {
            return index;
        }
    }

    private float getRelativeDepth(float i) {
        if (i == 0F) {
            return 1F;
        }
        return 0F;
    }

    @Nullable
    public Slot getClosestSlot(int mouseX, int mouseY, boolean all) {
        Slot nearest = null;
        int dist2 = Integer.MAX_VALUE;
        for (Slot slot : inventorySlots) {
            if (!all) {
                // ignore centre slot
                if (slot.getSlotIndex() == 0) {
                    continue;
                }

                // ignore hotbar slots
                if (slot.inventory != paletteInventory) {
                    continue;
                }
            }

            int dx = slot.xPos + 8 - mouseX;
            int dy = slot.yPos + 8 - mouseY;
            int d2 = dx * dx + dy * dy;
            if (nearest == null || d2 < dist2) {
                nearest = slot;
                dist2 = d2;
            }
        }
        return nearest;
    }
}