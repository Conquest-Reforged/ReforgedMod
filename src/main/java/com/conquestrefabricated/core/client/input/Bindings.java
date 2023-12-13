package com.conquestrefabricated.core.client.input;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

import java.util.LinkedList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class Bindings {

    private static final List<EventBinding> bindings = new LinkedList<>();

    public static KeyBinding createBasic(String description, String input, String category) {
        KeyBinding binding = new KeyBinding(description, InputUtil.fromTranslationKey(input).getCode(), category);
        KeyBindingHelper.registerKeyBinding(binding);
        return binding;
    }

    public static EventBinding create(String description, String input, String category) {
        EventBinding binding = new EventBinding(description, InputUtil.fromTranslationKey(input), category);
        bindings.add(binding);
        return binding;
    }

    public static EventBinding create(String description, String input, String category, BindListener listener) {
        EventBinding binding = new EventBinding(description, InputUtil.fromTranslationKey(input), category);
        binding.addListener(listener);
        bindings.add(binding);
        return binding;
    }

    public static void tick(MinecraftClient client) {
        for (EventBinding binding : bindings) {
            if (binding.checkPressed()) {
                return;
            }
            binding.checkHeld();
        }
    }
}
