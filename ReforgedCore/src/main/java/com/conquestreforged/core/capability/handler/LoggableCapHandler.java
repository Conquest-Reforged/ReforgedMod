package com.conquestreforged.core.capability.handler;

import com.conquestreforged.core.net.LoggableMessageHandler;

public abstract class LoggableCapHandler<T> extends LoggableMessageHandler<T> implements com.conquestreforged.core.net.MessageHandler<T> {

    public LoggableCapHandler(String name) {
        super(name);
    }
}
