package com.conquestreforged.client;

import com.conquestreforged.core.config.ConfigBuildEvent;
import com.conquestreforged.core.config.section.ConfigSection;
import com.conquestreforged.core.config.section.ConfigSectionSpec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Secrets {

    private static ConfigSection section;

    @SubscribeEvent
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
