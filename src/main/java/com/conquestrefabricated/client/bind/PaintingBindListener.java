package com.conquestrefabricated.client.bind;

import com.conquestrefabricated.api.painting.Painting;
import com.conquestrefabricated.api.painting.PaintingHolder;
import com.conquestrefabricated.api.painting.art.Art;
import com.conquestrefabricated.api.painting.vanilla.VanillaArt;
import com.conquestrefabricated.api.painting.vanilla.VanillaPainting;
import com.conquestrefabricated.client.gui.painting.PaintingScreen;
import com.conquestrefabricated.core.client.input.BindEvent;
import com.conquestrefabricated.core.client.input.BindListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.decoration.painting.PaintingVariants;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

public class PaintingBindListener implements BindListener {

    @Override
    public void onPress(BindEvent e) {
        if (!e.inGame || e.inGui || !e.player.isPresent()) {
            return;
        }

        e.player.map(PlayerEntity::getMainHandStack).ifPresent(stack -> {
            if (stack.getItem() instanceof PaintingHolder) {
                PaintingHolder holder = (PaintingHolder) stack.getItem();
                Art<?> art = holder.getArt(stack);
                Painting type = holder.getType(stack);
                if (art == null || type == null) {
                    return;
                }
                PaintingScreen<?> screen = new PaintingScreen<>(stack, type, art);
                MinecraftClient.getInstance().setScreen(screen);
                return;
            }

            if (stack.getItem() == Items.PAINTING) {
                String name = PaintingVariants.ALBAN.getRegistry() + "";
                Art<?> art = VanillaArt.fromName(name);
                Painting type = VanillaPainting.INSTANCE;
                PaintingScreen<?> screen = new PaintingScreen<>(stack, type, art);
                MinecraftClient.getInstance().setScreen(screen);
            }
        });
    }
}
