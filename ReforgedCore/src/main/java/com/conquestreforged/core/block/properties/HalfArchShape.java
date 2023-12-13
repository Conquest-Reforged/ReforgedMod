package com.conquestreforged.core.block.properties;

import net.minecraft.util.IStringSerializable;

public enum HalfArchShape implements IStringSerializable {
    ONE("one"),
    TWO_L("two_l"),
    TWO_R("two_r"),
    THREE_L("three_l"),
    THREE_R("three_r"),
    THREE_MIDDLE("three_middle");

    private final String name;

    HalfArchShape(String name) {
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
