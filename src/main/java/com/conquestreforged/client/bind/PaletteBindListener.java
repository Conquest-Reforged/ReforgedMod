package com.conquestreforged.client.bind;

import com.conquestreforged.client.gui.palette.Palette;
import com.conquestreforged.client.gui.palette.PaletteContainer;
import com.conquestreforged.client.gui.palette.PaletteScreen;
import com.conquestreforged.core.client.input.BindEvent;
import com.conquestreforged.core.client.input.BindListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class PaletteBindListener implements BindListener {

    @Override
    public void onPress(BindEvent e) {
        if (!e.inGame || e.inGui || !e.player.isPresent()) {
            return;
        }

        e.player.map(PlayerEntity::getMainHandStack).flatMap(Palette::getPalette).ifPresent(palette -> {
            PlayerEntity player = e.player.get();
            PaletteContainer container = new PaletteContainer(player.getInventory(), palette);
            PaletteScreen screen = new PaletteScreen(player, player.getInventory(), container);
            MinecraftClient.getInstance().setScreen(screen);
        });
    }
}
