package com.conquestreforged.client.gui;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;

import javax.annotation.Nullable;

public abstract class AbstractContainer extends Container {

    protected AbstractContainer(@Nullable ContainerType<?> type, int id) {
        super(type, id);
    }

    @Override
    public Slot addSlot(Slot slot) {
        return super.addSlot(slot);
    }
}
