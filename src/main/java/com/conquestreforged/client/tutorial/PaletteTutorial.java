package com.conquestreforged.client.tutorial;

import com.conquestreforged.core.config.ConfigBuildEvent;
import com.conquestreforged.core.config.section.ConfigSection;
import com.conquestreforged.core.config.section.ConfigSectionSpec;
import com.conquestreforged.core.util.log.Log;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class PaletteTutorial {

    private static ConfigSection tutorials = null;

    public PaletteTutorial(ConfigSection tutorials) {
        PaletteTutorial.tutorials = tutorials;
    }

    public static void config(ConfigBuildEvent event) {
        Log.info("Adding tutorial config section!");
        try (ConfigSectionSpec spec = event.client("tutorials", "Tutorial progression state")) {
            spec.getBuilder().define("block_palette", false).next();

           tutorials = spec.getSection();
        }
    }
    /*
    public void openScreen() {
        if (event.getScreen() instanceof ContainerScreen) {
            MinecraftForge.EVENT_BUS.unregister(this);

            if (Tutorials.openPalette || tutorials.getOrElse("block_palette", false)) {
                Log.info("BYPASS");
                return;
            }

            Minecraft.getInstance().getToasts().addToast(new PaletteToast(tutorials));
        }
    }*/
}