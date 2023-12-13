package com.conquestreforged.core.block.properties;

import net.minecraft.util.StringRepresentable;

public enum SphereShape implements StringRepresentable {
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
    public String getSerializedName() {
        return this.name;
    }
}
