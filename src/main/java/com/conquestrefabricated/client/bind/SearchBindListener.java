package com.conquestrefabricated.client.bind;

import com.conquestrefabricated.client.gui.search.SearchScreen;
import com.conquestrefabricated.core.client.input.BindEvent;
import com.conquestrefabricated.core.client.input.BindListener;
import net.minecraft.client.MinecraftClient;

public class SearchBindListener implements BindListener {

    @Override
    public void onPress(BindEvent e) {
        if (e.inGame && !e.inGui && e.player.map(p -> p.getAbilities().creativeMode).orElse(false)) {
            MinecraftClient.getInstance().setScreen(new SearchScreen());
        }
    }
}
