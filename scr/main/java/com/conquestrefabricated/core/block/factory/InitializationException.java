package com.conquestrefabricated.core.block.factory;

import java.lang.reflect.Constructor;

public class InitializationException extends RuntimeException {

    public InitializationException(String message) {
        super(message);
    }

    public InitializationException(Throwable origin) {
        super(origin);
    }

    public InitializationException(Constructor constructor, Throwable origin) {
        super(constructor.getDeclaringClass().getName() + ":" + origin.getCause(), origin.getCause());
    }
}
