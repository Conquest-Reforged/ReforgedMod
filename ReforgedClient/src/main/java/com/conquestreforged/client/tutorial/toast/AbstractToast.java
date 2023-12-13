package com.conquestreforged.client.tutorial.toast;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.client.gui.toasts.ToastGui;

public abstract class AbstractToast implements IToast {

    protected static final int TITLE = -11534256;
    protected static final int SUBTITLE = -16777216;

    private final int line1Color;
    private final int line2Color;

    public AbstractToast(int line1Color, int line2Color) {
        this.line1Color = line1Color;
        this.line2Color = line2Color;
    }

    @Override
    public Visibility draw(ToastGui toastGui, long delta) {
        if (shouldRender(toastGui)) {
            toastGui.getMinecraft().getTextureManager().bindTexture(TEXTURE_TOASTS);
            RenderSystem.color3f(1.0F, 1.0F, 1.0F);
            toastGui.blit(0, 0, 0, 96, 160, 32);

            if (getLine2().isEmpty()) {
                toastGui.getMinecraft().fontRenderer.drawString(getLine1(), 5.0F, 12.0F, line1Color);
            } else {
                toastGui.getMinecraft().fontRenderer.drawString(getLine1(), 5.0F, 7.0F, line1Color);
                toastGui.getMinecraft().fontRenderer.drawString(getLine2(), 5.0F, 18.0F, line2Color);
            }
        }
        return getVisibility();
    }

    public abstract String getLine1();

    public abstract String getLine2();

    public abstract boolean shouldRender(ToastGui gui);

    public abstract Visibility getVisibility();
}
