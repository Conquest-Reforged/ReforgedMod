package com.conquestreforged.core.networking;

import com.conquestreforged.core.capability.toggle.Toggle;
import com.conquestreforged.core.init.Context;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Channels {

    public static final SimpleChannel TOGGLE = NetworkRegistry.newSimpleChannel(
            Context.getInstance().newResourceLocation(Toggle.PROTOCOL_NAME),
            () -> Toggle.PROTOCOL_VERSION,
            Toggle.PROTOCOL_VERSION::equals,
            Toggle.PROTOCOL_VERSION::equals
    );

    @SubscribeEvent
    public static void common(FMLCommonSetupEvent event) {
        // register stuff
    }
}