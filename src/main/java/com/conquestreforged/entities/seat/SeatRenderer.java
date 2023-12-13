package com.conquestreforged.entities.seat;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SeatRenderer extends EntityRenderer<SeatEntity> {

    public SeatRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager);
    }

    @Override
    public void render(SeatEntity seat, float yaw, float ticks, PoseStack matrix, MultiBufferSource buffer, int light) {

    }

    @Override
    public ResourceLocation getTextureLocation(SeatEntity p_110775_1_) {
        return null;
    }
}
