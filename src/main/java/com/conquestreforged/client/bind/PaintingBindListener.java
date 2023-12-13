package com.conquestreforged.client.bind;

import com.conquestreforged.api.painting.Painting;
import com.conquestreforged.api.painting.PaintingHolder;
import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.api.painting.vanilla.VanillaArt;
import com.conquestreforged.api.painting.vanilla.VanillaPainting;
import com.conquestreforged.client.gui.painting.PaintingScreen;
import com.conquestreforged.core.client.input.BindEvent;
import com.conquestreforged.core.client.input.BindListener;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;

public class PaintingBindListener implements BindListener {

    @Override
    public void onPress(BindEvent e) {
        if (!e.inGame || e.inGui || !e.player.isPresent()) {
            return;
        }

        e.player.map(Player::getMainHandItem).ifPresent(stack -> {
            if (stack.getItem() instanceof PaintingHolder) {
                PaintingHolder holder = (PaintingHolder) stack.getItem();
                Art<?> art = holder.getArt(stack);
                Painting type = holder.getType(stack);
                if (art == null || type == null) {
                    return;
                }
                PaintingScreen<?> screen = new PaintingScreen<>(stack, type, art);
                Minecraft.getInstance().setScreen(screen);
                return;
            }

            if (stack.getItem() == Items.PAINTING) {
                String name = Motive.f_31868_.getRegistryName() + "";
                Art<?> art = VanillaArt.fromName(name);
                Painting type = VanillaPainting.INSTANCE;
                PaintingScreen<?> screen = new PaintingScreen<>(stack, type, art);
                Minecraft.getInstance().setScreen(screen);
            }
        });
    }
}
