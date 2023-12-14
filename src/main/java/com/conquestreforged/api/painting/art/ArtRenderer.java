package com.conquestreforged.api.painting.art;

import com.conquestreforged.api.painting.Painting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;

public enum ArtRenderer {
    MOD {
        @Override
        public void render(Painting painting, Art<?> art, PoseStack matrixStack, int x, int y, int w, int h) {
            RenderSystem.setShaderTexture(0, painting.getRegistryName());
            DrawableHelper.drawTexture(matrixStack, x, y, w, h, art.u(), art.v(), art.width(), art.height(), art.textureWidth(), art.textureHeight());
        }
    },
    VANILLA {
        @Override
        public void render(Painting painting, Art<?> art, PoseStack matrixStack, int x, int y, int w, int h) {
            String artName = art.getName().replace("minecraft:", "");
            RenderSystem.setShaderTexture(0, new ResourceLocation("minecraft:textures/painting/" + artName + ".png"));
            DrawableHelper.drawTexture(matrixStack, x, y, w, h, art.u(), art.v(), art.width(), art.height(), art.textureWidth(), art.textureHeight());
        }
    },
    ;

    public abstract void render(Painting painting, Art<?> art, PoseStack matrixStack, int x, int y, int w, int h);
}
