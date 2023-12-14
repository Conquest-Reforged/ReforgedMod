package com.conquestreforged.core.client.render.type;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;

/**
 * Replace the first call to getBuffer's RenderType with our own.
 * Subsequent calls pass through unmodified
 */
public class ReplaceFirstInjector extends RenderTypeInjector {

    private final RenderLayer type;
    private volatile boolean first = true;

    public ReplaceFirstInjector(VertexConsumerProvider delegate, RenderLayer type) {
        super(delegate);
        this.type = type;
    }

    @Override
    protected RenderLayer getRenderType(RenderLayer type) {
        if (first) {
            first = false;
            return this.type;
        }
        return type;
    }
}
