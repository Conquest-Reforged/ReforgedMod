package com.conquestreforged.entities.painting.render;

import com.conquestreforged.core.client.render.type.RenderTypeInjector;
import com.conquestreforged.core.client.render.type.ReplaceFirstInjector;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import net.minecraft.world.entity.decoration.Painting;

/**
 * An alternative renderer for vanilla paintings that enables cut-out rendering
 */
public class VanillaPaintingRenderer extends PaintingRenderer {

    public VanillaPaintingRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public void render(Painting entity, float yaw, float ticks, PoseStack stack, MultiBufferSource buffer, int light) {
        // injects our custom render type (cutout) the first time it is used in the super method allowing us to replace
        // vanilla's use of the entity_solid render type which breaks paintings that should have transparency
        RenderTypeInjector injector = new ReplaceFirstInjector(buffer, RenderType.entityCutout(getTextureLocation(entity)));

        // the super method does the actual rendering (saves us copy-pasting huge chunks of vanilla code)
        super.render(entity, yaw, ticks, stack, injector, light);
    }
}
