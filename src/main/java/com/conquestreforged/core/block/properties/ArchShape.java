package com.conquestreforged.core.block.properties;

import net.minecraft.util.StringRepresentable;

public enum ArchShape implements StringRepresentable {
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
    public String getSerializedName() {
        return this.name;
    }
}
