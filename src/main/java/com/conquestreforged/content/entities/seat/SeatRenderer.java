package com.conquestreforged.content.entities.seat;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SeatRenderer extends EntityRenderer<SeatEntity> {

    public SeatRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager);
    }

    @Override
    public void render(SeatEntity seat, float yaw, float ticks, MatrixStack matrix, VertexConsumerProvider buffer, int light) {

    }

    @Override
    public Identifier getTexture(SeatEntity p_110775_1_) {
        return null;
    }
}
