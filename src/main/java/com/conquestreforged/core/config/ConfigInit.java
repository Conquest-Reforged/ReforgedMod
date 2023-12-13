package com.conquestreforged.core.config;

import com.conquestreforged.core.util.log.Log;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigInit {

    private static final Marker marker = MarkerManager.getMarker("Config");
    private static final ConfigManager manager = new ConfigManager();

    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent event) {
        Log.info(marker, "Registering mod configs");
        ConfigBuildEvent buildEvent = new ConfigBuildEvent(manager);
        FMLJavaModLoadingContext.get().getModEventBus().post(buildEvent);

        buildEvent.forEach((type, builder) -> {
            Config config = new Config(type, builder.build());
            manager.addConfig(config);
            Log.info(marker, "Registered config: {}, empty: {}", type, config.getRoot().isEmpty());
        });
    }
}
