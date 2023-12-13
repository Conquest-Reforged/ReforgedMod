package com.conquestreforged.core.block.properties;

import net.minecraft.util.IStringSerializable;

public enum ArchShape implements IStringSerializable {
    ONE("one"),
    TWO("two"),
    THREE("three"),
    THREE_MIDDLE("three_middle");

    private final String name;

    ArchShape(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
