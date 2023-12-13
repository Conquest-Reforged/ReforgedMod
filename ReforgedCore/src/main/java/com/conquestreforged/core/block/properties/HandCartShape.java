package com.conquestreforged.core.block.properties;

import net.minecraft.util.IStringSerializable;

public enum HandCartShape implements IStringSerializable {
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
    public String getName() {
        return this.name;
    }
}
