package com.conquestreforged.core.capability;

import com.conquestreforged.core.capability.toggle.Toggle;
import com.conquestreforged.core.capability.toggle.ToggleHandler;
import com.conquestreforged.core.networking.Channels;
import com.conquestreforged.core.util.Dummy;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * Holds all the player capabilities
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Capabilities {

    @CapabilityInject(Toggle.class)
    public static final Capability<Toggle> TOGGLE = Dummy.dummy();

    @SubscribeEvent
    public static void common(FMLCommonSetupEvent event) {
        CapabilityHelper.register(() -> TOGGLE, Channels.TOGGLE, PlayerEntity.class, Toggle.class, new ToggleHandler());
    }
}
