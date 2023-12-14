package com.conquestreforged.core.client.render.type;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;

import java.util.function.UnaryOperator;

/**
 * Transforms any incoming RenderTypes using the provided function
 */
public class ReplaceInjector extends RenderTypeInjector {

    private final UnaryOperator<RenderLayer> operator;

    public ReplaceInjector(VertexConsumerProvider delegate, UnaryOperator<RenderLayer> operator) {
        super(delegate);
        this.operator = operator;
    }

    @Override
    protected RenderLayer getRenderType(RenderLayer type) {
        return operator.apply(type);
    }
}
