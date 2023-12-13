package com.conquestrefabricated.core.client.render.type;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;

public class RenderTypeInjector implements VertexConsumerProvider {

    protected final VertexConsumerProvider delegate;

    public RenderTypeInjector(VertexConsumerProvider delegate) {
        this.delegate = delegate;
    }

    @Override
    public VertexConsumer getBuffer(RenderLayer type) {
        return delegate.getBuffer(getRenderType(type));
    }

    protected RenderLayer getRenderType(RenderLayer type) {
        return type;
    }
}
