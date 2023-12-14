package com.conquestreforged.core.config;

import com.conquestreforged.core.util.log.Log;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class ConfigInit {

    public static final Marker marker = MarkerManager.getMarker("Config");
    public static final ConfigManager manager = new ConfigManager();

    public static ConfigBuildEvent setup() {
        Log.info(marker, "Registering mod configs");
        ConfigBuildEvent buildEvent = new ConfigBuildEvent(manager);

        return buildEvent;
    }
}
