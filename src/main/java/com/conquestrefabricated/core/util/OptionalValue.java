package com.conquestrefabricated.core.util;

public interface OptionalValue {

    default boolean isPresent() {
        return !isAbsent();
    }

    boolean isAbsent();
}
