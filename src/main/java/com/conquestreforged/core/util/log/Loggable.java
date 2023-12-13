package com.conquestreforged.core.util.log;

import org.apache.logging.log4j.Marker;

public interface Loggable {

    Marker getMarker();

    default void info(String format, Object... args) {
        Log.info(getMarker(), format, args);
    }

    default void debug(String format, Object... args) {
        Log.debug(getMarker(), format, args);
    }

    default void trace(String format, Object... args) {
        Log.trace(getMarker(), format, args);
    }

    default void error(String format, Object... args) {
        Log.error(getMarker(), format, args);
    }

    default void warn(String format, Object... args) {
        Log.warn(getMarker(), format, args);
    }
}
