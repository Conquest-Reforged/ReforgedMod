package com.conquestreforged.core.client.render.type;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;

import java.util.function.UnaryOperator;

/**
 * Transforms any incoming RenderTypes using the provided function
 */
public class ReplaceInjector extends RenderTypeInjector {

    private final UnaryOperator<RenderType> operator;

    public ReplaceInjector(IRenderTypeBuffer delegate, UnaryOperator<RenderType> operator) {
        super(delegate);
        this.operator = operator;
    }

    @Override
    protected RenderType getRenderType(RenderType type) {
        return operator.apply(type);
    }
}
