package com.conquestreforged.core.block.properties;

import net.minecraft.util.IStringSerializable;

public enum SphereShape implements IStringSerializable {
    EGG("egg"),
    SMALL("small"),
    LARGE("large");

    private final String name;

    SphereShape(String name) {
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
