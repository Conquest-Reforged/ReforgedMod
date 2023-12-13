package com.conquestrefabricated.core.block.properties;

import net.minecraft.util.StringIdentifiable;

public enum ArchShape implements StringIdentifiable {
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
    public String asString() {
        return this.name;
    }
}
