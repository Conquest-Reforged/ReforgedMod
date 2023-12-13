package com.conquestreforged.core.client.input;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;

import java.util.LinkedList;
import java.util.List;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class Bindings {

    private static final List<EventBinding> bindings = new LinkedList<>();

    public static KeyBinding createBasic(String description, String input, String category) {
        KeyBinding binding = new KeyBinding(description, KeyConflictContext.UNIVERSAL, InputMappings.getInputByName(input), category);
        ClientRegistry.registerKeyBinding(binding);
        return binding;
    }

    public static EventBinding create(String description, String input, String category) {
        EventBinding binding = new EventBinding(description, InputMappings.getInputByName(input), category);
        bindings.add(binding);
        return binding;
    }

    public static EventBinding create(String description, String input, String category, BindListener listener) {
        EventBinding binding = new EventBinding(description, InputMappings.getInputByName(input), category);
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
