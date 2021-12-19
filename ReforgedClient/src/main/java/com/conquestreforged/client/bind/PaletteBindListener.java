package com.conquestreforged.client.bind;

import com.conquestreforged.client.gui.palette.Palette;
import com.conquestreforged.client.gui.palette.PaletteContainer;
import com.conquestreforged.client.gui.palette.PaletteScreen;
import com.conquestreforged.core.client.input.BindEvent;
import com.conquestreforged.core.client.input.BindListener;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class PaletteBindListener implements BindListener {

    @Override
    public void onPress(BindEvent e) {
        if (!e.inGame || e.inGui || !e.player.isPresent()) {
            return;
        }

        e.player.map(Player::getMainHandItem).flatMap(Palette::getPalette).ifPresent(palette -> {
            Player player = e.player.get();
            PaletteContainer container = new PaletteContainer(player.getInventory(), palette);
            PaletteScreen screen = new PaletteScreen(player, player.getInventory(), container);
            Minecraft.getInstance().setScreen(screen);
        });
    }
}
