package com.conquestreforged.core.client.input;

import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.ClientRegistry;

import java.util.LinkedList;
import java.util.List;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class Bindings {

    private static final List<EventBinding> bindings = new LinkedList<>();

    public static KeyMapping createBasic(String description, String input, String category) {
        KeyMapping binding = new KeyMapping(description, KeyConflictContext.UNIVERSAL, InputConstants.getKey(input), category);
        ClientRegistry.registerKeyBinding(binding);
        return binding;
    }

    public static EventBinding create(String description, String input, String category) {
        EventBinding binding = new EventBinding(description, InputConstants.getKey(input), category);
        bindings.add(binding);
        return binding;
    }

    public static EventBinding create(String description, String input, String category, BindListener listener) {
        EventBinding binding = new EventBinding(description, InputConstants.getKey(input), category);
        binding.addListener(listener);
        bindings.add(binding);
        return binding;
    }

    @SubscribeEvent
    public static void tick(TickEvent.ClientTickEvent event) {
        for (EventBinding binding : bindings) {
            if (binding.checkPressed()) {
                return;
            }
            binding.checkHeld();
        }
    }
}
