package com.conquestreforged.core.capability;

import com.conquestreforged.core.capability.toggle.Toggle;
import com.conquestreforged.core.net.Channels;
import com.conquestreforged.core.util.Dummy;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * Holds all the player capabilities
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Capabilities {

    //@CapabilityInject(Toggle.class)
    public static final Capability<Toggle> TOGGLE = Dummy.dummy();

    @SubscribeEvent
    public static void common(FMLCommonSetupEvent event) {
        Channels.TOGGLE.register(Player.class, Toggle.class, () -> TOGGLE);
    }
}
