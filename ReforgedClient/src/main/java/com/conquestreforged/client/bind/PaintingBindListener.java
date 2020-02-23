package com.conquestreforged.client.bind;

import com.conquestreforged.api.painting.Painting;
import com.conquestreforged.api.painting.PaintingHolder;
import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.api.painting.vanilla.VanillaArt;
import com.conquestreforged.api.painting.vanilla.VanillaPainting;
import com.conquestreforged.client.gui.painting.PaintingScreen2;
import com.conquestreforged.core.client.input.BindEvent;
import com.conquestreforged.core.client.input.BindListener;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;

public class PaintingBindListener implements BindListener {
    @Override
    public void onPress(BindEvent e) {
        if (!e.inGame || e.inGui || !e.player.isPresent()) {
            return;
        }

        e.player.map(PlayerEntity::getHeldItemMainhand).ifPresent(stack -> {
            if (stack.getItem() instanceof PaintingHolder) {
                PaintingHolder holder = (PaintingHolder) stack.getItem();
                Art<?> art = holder.getArt(stack);
                Painting type = holder.getType(stack);
                if (art == null || type == null) {
                    return;
                }
                PaintingScreen2<?> screen = new PaintingScreen2<>(stack, type, art);
                Minecraft.getInstance().displayGuiScreen(screen);
                return;
            }

            if (stack.getItem() == Items.PAINTING) {
                String name = PaintingType.ALBAN.getRegistryName() + "";
                Art<?> art = VanillaArt.fromName(name);
                Painting type = VanillaPainting.INSTANCE;
                PaintingScreen2<?> screen = new PaintingScreen2<>(stack, type, art);
                Minecraft.getInstance().displayGuiScreen(screen);
            }
        });
    }
}
