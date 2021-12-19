package com.conquestreforged.client.tutorial;

import com.conquestreforged.client.tutorial.toast.PaletteToast;
import com.conquestreforged.core.config.ConfigBuildEvent;
import com.conquestreforged.core.config.section.ConfigSection;
import com.conquestreforged.core.config.section.ConfigSectionSpec;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PaletteTutorial {

    private final ConfigSection tutorials;

    public PaletteTutorial(ConfigSection tutorials) {
        this.tutorials = tutorials;
    }

    @SubscribeEvent
    public static void config(ConfigBuildEvent event) {
        Log.info("Adding tutorial config section!");
        try (ConfigSectionSpec spec = event.client("tutorials", "Tutorial progression state")) {
            spec.getBuilder().define("block_palette", false).next();

            MinecraftForge.EVENT_BUS.register(new PaletteTutorial(spec.getSection()));
        }
    }

    @SubscribeEvent
    public void openScreen(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof ContainerScreen) {
            MinecraftForge.EVENT_BUS.unregister(this);

            if (Tutorials.openPalette || tutorials.getOrElse("block_palette", false)) {
                Log.info("BYPASS");
                return;
            }

            Minecraft.getInstance().getToasts().addToast(new PaletteToast(tutorials));
        }
    }
}
