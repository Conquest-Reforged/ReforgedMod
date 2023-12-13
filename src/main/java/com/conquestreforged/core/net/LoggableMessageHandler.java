package com.conquestreforged.core.net;

import com.conquestreforged.core.util.log.Loggable;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public abstract class LoggableMessageHandler<T> implements MessageHandler<T>, Loggable {

    private final Marker marker;

    public LoggableMessageHandler(String name) {
        this.marker = MarkerManager.getMarker(name);
    }

    @Override
    public Marker getMarker() {
        return marker;
    }
}
