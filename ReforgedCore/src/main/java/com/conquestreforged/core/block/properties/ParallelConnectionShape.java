package com.conquestreforged.core.block.properties;

import net.minecraft.util.IStringSerializable;

public enum ParallelConnectionShape implements IStringSerializable {
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
    public String getName() {
        return this.name;
    }
}
