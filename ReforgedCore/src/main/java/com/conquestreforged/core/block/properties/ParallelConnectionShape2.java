package com.conquestreforged.core.block.properties;

import net.minecraft.util.StringRepresentable;

public enum ParallelConnectionShape2 implements StringRepresentable {
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
    public String getSerializedName() {
        return this.name;
    }
}
