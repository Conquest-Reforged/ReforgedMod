package com.conquestrefabricated.api.painting.art;

import com.conquestrefabricated.api.painting.Painting;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public enum ArtRenderer {
    MOD {
        @Override
        public void render(Painting painting, Art<?> art, MatrixStack matrixStack, int x, int y, int w, int h) {
            RenderSystem.setShaderTexture(0, painting.getRegistryName());
            DrawableHelper.drawTexture(matrixStack, x, y, w, h, art.u(), art.v(), art.width(), art.height(), art.textureWidth(), art.textureHeight());
        }
    },
    VANILLA {
        @Override
        public void render(Painting painting, Art<?> art, MatrixStack matrixStack, int x, int y, int w, int h) {
            String artName = art.getName().replace("minecraft:", "");
            RenderSystem.setShaderTexture(0, new Identifier("minecraft:textures/painting/" + artName + ".png"));
            DrawableHelper.drawTexture(matrixStack, x, y, w, h, art.u(), art.v(), art.width(), art.height(), art.textureWidth(), art.textureHeight());
        }
    },
    ;

    public abstract void render(Painting painting, Art<?> art, MatrixStack matrixStack, int x, int y, int w, int h);
}
