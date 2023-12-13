package com.conquestreforged.core.block.properties;

import net.minecraft.util.StringRepresentable;

public enum HandCartShape implements StringRepresentable {
    ONE("one"),
    LEFT("left"),
    RIGHT("right"),
    MIDDLE("middle");

    private final String name;

    HandCartShape(String name) {
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
