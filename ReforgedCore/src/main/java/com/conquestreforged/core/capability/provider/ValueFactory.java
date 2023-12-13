package com.conquestreforged.core.capability.provider;

@FunctionalInterface
public interface ValueFactory<T> {

    Value<T> create();
}
