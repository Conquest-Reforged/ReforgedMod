package com.conquestreforged.core.net;

import com.conquestreforged.core.capability.toggle.Toggle;
import com.conquestreforged.core.init.Context;
import com.conquestreforged.core.util.log.Log;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Channels {

    public static final Channel TOGGLE = Channel.create(Context.getInstance().getNamespace(), Toggle.PROTOCOL_NAME, Toggle.PROTOCOL_VERSION);

    @SubscribeEvent
    public static void common(FMLCommonSetupEvent event) {
        Log.info("Registering network channels");
    }
}
