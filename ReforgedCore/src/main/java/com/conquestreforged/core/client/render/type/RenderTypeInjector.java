package com.conquestreforged.core.client.render.type;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;

public class RenderTypeInjector implements IRenderTypeBuffer {

    protected final IRenderTypeBuffer delegate;

    public RenderTypeInjector(IRenderTypeBuffer delegate) {
        this.delegate = delegate;
    }

    @Override
    public IVertexBuilder getBuffer(RenderType type) {
        return delegate.getBuffer(getRenderType(type));
    }

    protected RenderType getRenderType(RenderType type) {
        return type;
    }
}
