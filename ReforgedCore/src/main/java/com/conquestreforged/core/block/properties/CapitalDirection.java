package com.conquestreforged.core.block.properties;

import net.minecraft.util.IStringSerializable;

public enum CapitalDirection implements IStringSerializable {
    FLAT("flat"),
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west");

    private final String name;

    CapitalDirection(String name) {
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
