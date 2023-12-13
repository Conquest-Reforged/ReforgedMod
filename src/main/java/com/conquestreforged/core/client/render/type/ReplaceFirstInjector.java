package com.conquestreforged.core.client.render.type;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;

/**
 * Replace the first call to getBuffer's RenderType with our own.
 * Subsequent calls pass through unmodified
 */
public class ReplaceFirstInjector extends RenderTypeInjector {

    private final RenderType type;
    private volatile boolean first = true;

    public ReplaceFirstInjector(MultiBufferSource delegate, RenderType type) {
        super(delegate);
        this.type = type;
    }

    @Override
    protected RenderType getRenderType(RenderType type) {
        if (first) {
            first = false;
            return this.type;
        }
        return type;
    }
}
