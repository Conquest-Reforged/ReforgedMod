package com.conquestreforged.core.block.properties;

import net.minecraft.util.StringRepresentable;

public enum BidirectionalShape implements StringRepresentable {
    NORTH_SOUTH("northsouth"),
    EAST_WEST("eastwest");

    private final String name;

    BidirectionalShape(String name) {
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
