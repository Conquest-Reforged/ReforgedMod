package com.conquestreforged.core.util.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Log {

    private static final Logger logger = LogManager.getLogger("ReforgedCore");
    private static final Marker MARKER = MarkerManager.getMarker("Core");

    private Log() {
    }

    public static void info(String format, Object... args) {
        info(MARKER, format, args);
    }

    public static void info(Marker marker, String format, Object... args) {
        logger.info(marker, format, args);
    }

    public static void debug(String format, Object... args) {
        debug(MARKER, format, args);
    }

    public static void debug(Marker marker, String format, Object... args) {
        logger.debug(marker, format, args);
    }

    public static void trace(String format, Object... args) {
        trace(MARKER, format, args);
    }

    public static void trace(Marker marker, String format, Object... args) {
        logger.trace(marker, format, args);
    }

    public static void error(String format, Object... args) {
        error(MARKER, format, args);
    }

    public static void error(Marker marker, String format, Object... args) {
        logger.error(marker, format, args);
    }

    public static void warn(String format, Object... args) {
        warn(MARKER, format, args);
    }

    public static void warn(Marker marker, String format, Object... args) {
        logger.warn(marker, format, args);
    }
}
