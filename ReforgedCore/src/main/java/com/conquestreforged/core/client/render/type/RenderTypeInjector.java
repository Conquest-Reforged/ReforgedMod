package com.conquestreforged.core.client.render.type;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;

public class RenderTypeInjector implements MultiBufferSource {

    protected final MultiBufferSource delegate;

    public RenderTypeInjector(MultiBufferSource delegate) {
        this.delegate = delegate;
    }

    @Override
    public VertexConsumer getBuffer(RenderType type) {
        return delegate.getBuffer(getRenderType(type));
    }

    protected RenderType getRenderType(RenderType type) {
        return type;
    }
}
