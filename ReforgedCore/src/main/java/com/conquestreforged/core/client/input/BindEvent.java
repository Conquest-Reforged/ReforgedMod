package com.conquestreforged.core.client.input;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Optional;

public class BindEvent {

    public final KeyBinding binding;
    public final boolean inGame;
    public final boolean inGui;
    public final Optional<PlayerEntity> player;

    public BindEvent(KeyBinding binding) {
        this.binding = binding;
        this.inGame = Minecraft.getInstance().player != null;
        this.inGui = Minecraft.getInstance().currentScreen != null;
        this.player = Optional.ofNullable(Minecraft.getInstance().player);
    }
}
