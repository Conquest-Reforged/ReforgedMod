package com.conquestreforged.core.block.properties;

import net.minecraft.util.IStringSerializable;

public enum ParallelConnectionShape2 implements IStringSerializable {
    ONE("one"),
    EDGE_L("edge_l"),
    EDGE_R("edge_r"),
    MIDDLE("middle");

    private final String name;

    ParallelConnectionShape2(String name) {
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
