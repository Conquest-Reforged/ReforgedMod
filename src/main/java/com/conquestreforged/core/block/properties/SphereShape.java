package com.conquestreforged.core.block.properties;

import net.minecraft.util.StringIdentifiable;

public enum SphereShape implements StringIdentifiable {
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
    public String asString() {
        return this.name;
    }
}
