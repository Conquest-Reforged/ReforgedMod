package com.conquestreforged.client;


import com.conquestreforged.core.config.ConfigBuildEvent;
import com.conquestreforged.core.config.section.ConfigSection;
import com.conquestreforged.core.config.section.ConfigSectionSpec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Secrets {

    private static ConfigSection section;

    public static void config(ConfigBuildEvent event) {
        try (ConfigSectionSpec spec = event.client("secrets")) {
            spec.getBuilder().define("state_picker_gui", false).next();
            section = spec.getSection();
        }
    }

    public static boolean useStatePicker() {
        return section.getOrElse("state_picker_gui", false);
    }
}