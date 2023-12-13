package com.conquestrefabricated.content.entities.painting.render;

import com.conquestrefabricated.core.client.render.type.RenderTypeInjector;
import com.conquestrefabricated.core.client.render.type.ReplaceFirstInjector;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PaintingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.painting.PaintingEntity;

/**
 * An alternative renderer for vanilla paintings that enables cut-out rendering
 */
public class VanillaPaintingRenderer extends PaintingEntityRenderer {

    public VanillaPaintingRenderer(EntityRendererFactory.Context manager) {
        super(manager);
    }

    @Override
    public void render(PaintingEntity entity, float yaw, float ticks, MatrixStack stack, VertexConsumerProvider buffer, int light) {
        // injects our custom render type (cutout) the first time it is used in the super method allowing us to replace
        // vanilla's use of the entity_solid render type which breaks paintings that should have transparency
        RenderTypeInjector injector = new ReplaceFirstInjector(buffer, RenderLayer.getEntityCutout(getTexture(entity)));

        // the super method does the actual rendering (saves us copy-pasting huge chunks of vanilla code)
        super.render(entity, yaw, ticks, stack, injector, light);
    }
}
