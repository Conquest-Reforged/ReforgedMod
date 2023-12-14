package com.conquestreforged.core.block.properties;

import net.minecraft.util.StringIdentifiable;

public enum HandCartShape implements StringIdentifiable {
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
    public String asString() {
        return this.name;
    }
}
