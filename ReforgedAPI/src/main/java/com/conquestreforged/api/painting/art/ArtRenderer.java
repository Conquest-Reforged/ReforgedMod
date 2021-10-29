package com.conquestreforged.api.painting.art;

import com.conquestreforged.api.painting.Painting; 
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.item.PaintingType;

/**
* @dev Render painting
* @notice Render 'Painting painting'
* @param Minecraft.getInstance().getTextureManager().bindTexture(painting.getRegistryName()) 
*        location of painting
* @param AbstractGui.blit(x, y, w, h, art.u(), art.v(), art.width(), art.height(), art.textureWidth(), art.textureHeight()) 
*        get the location of the painting to render
*/
public enum ArtRenderer {
    MOD {
        @Override
        public void render(Painting painting, Art<?> art, int x, int y, int w, int h) {
            Minecraft.getInstance().getTextureManager().bindTexture(painting.getRegistryName());
            AbstractGui.blit(x, y, w, h, art.u(), art.v(), art.width(), art.height(), art.textureWidth(), art.textureHeight());
        }
    },
    VANILLA {
        @Override
        public void render(Painting painting, Art<?> art, int x, int y, int w, int h) {
            PaintingType type = (PaintingType) art.getReference();
            TextureAtlasSprite sprite = Minecraft.getInstance().getPaintingSpriteUploader().getSpriteForPainting(type);
            sprite.getAtlasTexture().bindTexture();
            AbstractGui.blit(x, y, 0, w, h, sprite);
        }
    },
    ;

    public abstract void render(Painting painting, Art<?> art, int x, int y, int w, int h);
}
