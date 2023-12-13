package com.conquestreforged.client.gui;

import net.minecraft.client.gui.screen.inventory.CreativeCraftingListener;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;

public abstract class CustomCreativeScreen<T extends Container> extends CustomContainerScreen<T> {

    private boolean clickedOutside = false;
    private CreativeCraftingListener listener;

    public CustomCreativeScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    protected abstract boolean isContainerSlot(Slot slot);

    protected void sendChanges() {
        if (this.minecraft != null && minecraft.player != null) {
            minecraft.player.container.detectAndSendChanges();
        }
    }

    @Override
    protected void init() {
        super.init();
        if (this.minecraft != null && minecraft.player != null) {
            minecraft.player.container.removeListener(listener);
            listener = new CreativeCraftingListener(minecraft);
            minecraft.player.container.addListener(listener);
        }
    }

    @Override
    public void removed() {
        super.removed();
        if (minecraft != null) {
            if (minecraft.player != null && minecraft.player.inventory != null) {
                minecraft.player.container.removeListener(this.listener);
            }
            minecraft.keyboardListener.enableRepeatEvents(false);
        }
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        clickedOutside = super.hasClickedOutside(mx, my, guiLeft, guiTop, button);
        return super.mouseClicked(mx, my, button);
    }

    @Override
    protected void handleMouseClick(@Nullable Slot slot, int index, int button, ClickType type) {
        if (minecraft == null || minecraft.player == null || minecraft.playerController == null) {
            return;
        }

        onSlotClick(slot, index, button, type);

        if (slot == null && type != ClickType.QUICK_CRAFT) {
            PlayerInventory playerInventory = this.minecraft.player.inventory;
            if (!playerInventory.getItemStack().isEmpty()) {
                if (!clickedOutside) {
                    playerInventory.setItemStack(ItemStack.EMPTY);
                    this.minecraft.player.container.detectAndSendChanges();
                    return;
                }

                if (button == 0) {
                    this.minecraft.player.dropItem(playerInventory.getItemStack(), true);
                    this.minecraft.playerController.sendPacketDropItem(playerInventory.getItemStack());
                    playerInventory.setItemStack(ItemStack.EMPTY);
                }

                if (button == 1) {
                    ItemStack stack = playerInventory.getItemStack().split(1);
                    this.minecraft.player.dropItem(stack, true);
                    this.minecraft.playerController.sendPacketDropItem(stack);
                }
            }
            return;
        }

        boolean quickMove = type == ClickType.QUICK_MOVE;
        type = index == -999 && type == ClickType.PICKUP ? ClickType.THROW : type;

        if (type != ClickType.QUICK_CRAFT && isContainerSlot(slot)) {
            PlayerInventory playerinventory = minecraft.player.inventory;
            ItemStack heldStack = playerinventory.getItemStack();
            ItemStack slotStack = slot.getStack();
            if (type == ClickType.SWAP) {
                if (!slotStack.isEmpty() && button >= 0 && button < 9) {
                    ItemStack stack = slotStack.copy();
                    stack.setCount(stack.getMaxStackSize());
                    minecraft.player.inventory.setInventorySlotContents(button, stack);
                    minecraft.player.container.detectAndSendChanges();
                }

                return;
            }

            if (type == ClickType.CLONE) {
                if (playerinventory.getItemStack().isEmpty() && slot.getHasStack()) {
                    ItemStack stack = slot.getStack().copy();
                    stack.setCount(stack.getMaxStackSize());
                    playerinventory.setItemStack(stack);
                }

                return;
            }

            if (type == ClickType.THROW) {
                if (!slotStack.isEmpty()) {
                    ItemStack stack = slotStack.copy();
                    stack.setCount(button == 0 ? 1 : stack.getMaxStackSize());
                    this.minecraft.player.dropItem(stack, true);
                    this.minecraft.playerController.sendPacketDropItem(stack);
                }

                return;
            }

            if (!heldStack.isEmpty() && !slotStack.isEmpty() && heldStack.isItemEqual(slotStack) && ItemStack.areItemStackTagsEqual(heldStack, slotStack)) {
                if (button == 0) {
                    if (quickMove) {
                        heldStack.setCount(heldStack.getMaxStackSize());
                    } else if (heldStack.getCount() < heldStack.getMaxStackSize()) {
                        heldStack.grow(1);
                    }
                } else {
                    heldStack.shrink(1);
                }
            } else if (!slotStack.isEmpty() && heldStack.isEmpty()) {
                playerinventory.setItemStack(slotStack.copy());
                heldStack = playerinventory.getItemStack();
                if (quickMove) {
                    heldStack.setCount(heldStack.getMaxStackSize());
                }
            } else if (button == 0) {
                playerinventory.setItemStack(ItemStack.EMPTY);
            } else {
                playerinventory.getItemStack().shrink(1);
            }
        } else if (this.container != null) {
            ItemStack slotStack = slot == null ? ItemStack.EMPTY : this.container.getSlot(slot.slotNumber).getStack();
            this.container.slotClick(slot == null ? index : slot.slotNumber, button, type, this.minecraft.player);
            if (Container.getDragEvent(button) == 2) {
                int start = this.container.inventorySlots.size() - 9;
                for (int k = 0; k < 9; ++k) {
                    this.minecraft.playerController.sendSlotPacket(this.container.getSlot(start + k).getStack(), 36 + k);
                }
            } else if (slot != null) {
                ItemStack itemstack4 = this.container.getSlot(slot.slotNumber).getStack();
                this.minecraft.playerController.sendSlotPacket(itemstack4, slot.slotNumber - (this.container).inventorySlots.size() + 9 + 36);
                int i = 45 + button;
                if (type == ClickType.SWAP) {
                    this.minecraft.playerController.sendSlotPacket(slotStack, i - (this.container).inventorySlots.size() + 9 + 36);
                } else if (type == ClickType.THROW && !slotStack.isEmpty()) {
                    ItemStack stack = slotStack.copy();
                    stack.setCount(button == 0 ? 1 : stack.getMaxStackSize());
                    this.minecraft.player.dropItem(stack, true);
                    this.minecraft.playerController.sendPacketDropItem(stack);
                }

                this.minecraft.player.container.detectAndSendChanges();
            }
        }
    }
}
