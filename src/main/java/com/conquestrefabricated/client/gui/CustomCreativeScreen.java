package com.conquestrefabricated.client.gui;

import net.minecraft.client.gui.screen.ingame.CreativeInventoryListener;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;


public abstract class CustomCreativeScreen<T extends ScreenHandler> extends CustomContainerScreen<T> {

    private boolean clickedOutside = false;
    private CreativeInventoryListener listener;

    public CustomCreativeScreen(T screenContainer, PlayerInventory inv, Text titleIn) {
        super(screenContainer, inv, titleIn);
    }

    protected abstract boolean isContainerSlot(Slot slot);

    protected void sendChanges() {
        if (this.client != null && client.player != null) {
            client.player.playerScreenHandler.sendContentUpdates();
        }
    }

    @Override
    protected void init() {
        super.init();
        if (this.client != null && client.player != null) {
            client.player.playerScreenHandler.removeListener(listener);
            listener = new CreativeInventoryListener(client);
            client.player.playerScreenHandler.addListener(listener);
        }
    }

    @Override
    public void removed() {
        super.removed();
        if (client != null) {
            if (client.player != null && client.player.getInventory() != null) {
                client.player.playerScreenHandler.removeListener(this.listener);
            }
            client.keyboard.setRepeatEvents(false);
        }
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        clickedOutside = super.isClickOutsideBounds(mx, my, x, y, button);
        return super.mouseClicked(mx, my, button);
    }

    @Override
    protected void onMouseClick(@Nullable Slot slot, int index, int button, SlotActionType type) {
        if (client == null || client.player == null || client.interactionManager == null) {
            return;
        }

        onSlotClick(slot, index, button, type);

        if (slot == null && type != SlotActionType.QUICK_CRAFT) {
            if (!this.handler.getCursorStack().isEmpty()) {
                if (!clickedOutside) {
                    this.handler.setCursorStack(ItemStack.EMPTY);
                    this.client.player.playerScreenHandler.sendContentUpdates();
                    return;
                }

                if (button == 0) {
                    this.client.player.dropItem(this.handler.getCursorStack(), true);
                    this.client.interactionManager.dropCreativeStack(this.handler.getCursorStack());
                    this.handler.setCursorStack(ItemStack.EMPTY);
                }

                if (button == 1) {
                    ItemStack stack = this.handler.getCursorStack().split(1);
                    this.client.player.dropItem(stack, true);
                    this.client.interactionManager.dropCreativeStack(stack);
                }
            }
            return;
        }

        boolean quickMove = type == SlotActionType.QUICK_MOVE;
        type = index == -999 && type == SlotActionType.PICKUP ? SlotActionType.THROW : type;

        if (type != SlotActionType.QUICK_CRAFT && isContainerSlot(slot)) {
            ItemStack heldStack = this.handler.getCursorStack();
            ItemStack slotStack = slot.getStack();
            if (type == SlotActionType.SWAP) {
                if (!slotStack.isEmpty() && button >= 0 && button < 9) {
                    ItemStack stack = slotStack.copy();
                    stack.setCount(stack.getMaxCount());
                    client.player.getInventory().setStack(button, stack);
                    client.player.playerScreenHandler.sendContentUpdates();
                }

                return;
            }

            if (type == SlotActionType.CLONE) {
                if (this.handler.getCursorStack().isEmpty() && slot.hasStack()) {
                    ItemStack stack = slot.getStack().copy();
                    stack.setCount(stack.getMaxCount());
                    this.handler.setCursorStack(stack);
                }

                return;
            }

            if (type == SlotActionType.THROW) {
                if (!slotStack.isEmpty()) {
                    ItemStack stack = slotStack.copy();
                    stack.setCount(button == 0 ? 1 : stack.getMaxCount());
                    this.client.player.dropItem(stack, true);
                    this.client.interactionManager.dropCreativeStack(stack);
                }

                return;
            }

            if (!heldStack.isEmpty() && !slotStack.isEmpty() && heldStack.isItemEqualIgnoreDamage(slotStack) && ItemStack.areNbtEqual(heldStack, slotStack)) {
                if (button == 0) {
                    if (quickMove) {
                        heldStack.setCount(heldStack.getMaxCount());
                    } else if (heldStack.getCount() < heldStack.getMaxCount()) {
                        heldStack.increment(1);
                    }
                } else {
                    heldStack.decrement(1);
                }
            } else if (!slotStack.isEmpty() && heldStack.isEmpty()) {
                this.handler.setCursorStack(slotStack.copy());
                heldStack = this.handler.getCursorStack();
                if (quickMove) {
                    heldStack.setCount(heldStack.getMaxCount());
                }
            } else if (button == 0) {
                this.handler.setCursorStack(ItemStack.EMPTY);
            } else {
                this.handler.getCursorStack().decrement(1);
            }
        } else if (this.handler != null) {
            ItemStack slotStack = slot == null ? ItemStack.EMPTY : this.handler.getSlot(slot.id).getStack();
            this.handler.onSlotClick(slot == null ? index : slot.id, button, type, this.client.player);
            if (ScreenHandler.unpackQuickCraftStage(button) == 2) {
                int start = this.handler.slots.size() - 9;
                for (int k = 0; k < 9; ++k) {
                    this.client.interactionManager.clickCreativeStack(this.handler.getSlot(start + k).getStack(), 36 + k);
                }
            } else if (slot != null) {
                ItemStack itemstack4 = this.handler.getSlot(slot.id).getStack();
                this.client.interactionManager.clickCreativeStack(itemstack4, slot.id - (this.handler).slots.size() + 9 + 36);
                int i = 45 + button;
                if (type == SlotActionType.SWAP) {
                    this.client.interactionManager.clickCreativeStack(slotStack, i - (this.handler).slots.size() + 9 + 36);
                } else if (type == SlotActionType.THROW && !slotStack.isEmpty()) {
                    ItemStack stack = slotStack.copy();
                    stack.setCount(button == 0 ? 1 : stack.getMaxCount());
                    this.client.player.dropItem(stack, true);
                    this.client.interactionManager.dropCreativeStack(stack);
                }

                this.client.player.playerScreenHandler.sendContentUpdates();
            }
        }
    }
}
