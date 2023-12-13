package com.conquestrefabricated.core.client.input;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Optional;

public class BindEvent {

    public final KeyBinding binding;
    public final boolean inGame;
    public final boolean inGui;
    public final Optional<PlayerEntity> player;

    public BindEvent(KeyBinding binding) {
        this.binding = binding;
        this.inGame = MinecraftClient.getInstance().player != null;
        //currentScreen = screen?
        this.inGui = MinecraftClient.getInstance().currentScreen != null;
        this.player = Optional.ofNullable(MinecraftClient.getInstance().player);
    }
}
