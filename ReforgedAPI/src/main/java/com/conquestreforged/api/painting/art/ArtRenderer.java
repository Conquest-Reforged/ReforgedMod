package com.conquestreforged.api.painting.art;

import com.conquestreforged.api.painting.Painting;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.entity.decoration.Motive;

public enum ArtRenderer {
    MOD {
        @Override
        public void render(Painting painting, Art<?> art, PoseStack matrixStack, int x, int y, int w, int h) {
            Minecraft.getInstance().getTextureManager().bindForSetup(painting.getRegistryName());
            GuiComponent.blit(matrixStack, x, y, w, h, art.u(), art.v(), art.width(), art.height(), art.textureWidth(), art.textureHeight());
        }
    },
    VANILLA {
        @Override
        public void render(Painting painting, Art<?> art, PoseStack matrixStack, int x, int y, int w, int h) {
            Motive type = (Motive) art.getReference();
            TextureAtlasSprite sprite = Minecraft.getInstance().getPaintingTextures().get(type);
            sprite.atlas().bind();
            GuiComponent.blit(matrixStack, x, y, 0, w, h, sprite);
        }
    },
    ;

    public abstract void render(Painting painting, Art<?> art, PoseStack matrixStack, int x, int y, int w, int h);
}
