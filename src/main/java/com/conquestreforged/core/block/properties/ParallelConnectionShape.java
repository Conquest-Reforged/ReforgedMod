package com.conquestreforged.core.block.properties;

import net.minecraft.util.StringRepresentable;

public enum ParallelConnectionShape implements StringRepresentable {
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
    public String getSerializedName() {
        return this.name;
    }
}
