package com.conquestreforged.core.block.properties;

import net.minecraft.util.StringIdentifiable;

public enum ParallelConnectionShape implements StringIdentifiable {
    ONE("one"),
    EDGE("edge"),
    MIDDLE("middle");

    private final String name;

    ParallelConnectionShape(String name) {
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
