package com.conquestrefabricated.client.tutorial.toast;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.toast.Toast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.client.util.math.MatrixStack;


public abstract class AbstractToast implements Toast {

    protected static final int TITLE = -11534256;
    protected static final int SUBTITLE = -16777216;

    private final int line1Color;
    private final int line2Color;

    public AbstractToast(int line1Color, int line2Color) {
        this.line1Color = line1Color;
        this.line2Color = line2Color;
    }

    @Override
    public Visibility draw(MatrixStack matrixStack, ToastManager toastGui, long delta) {
        if (shouldRender(toastGui)) {
            RenderSystem.setShaderTexture(0, TEXTURE);
            //used to be color3f?
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            toastGui.drawTexture(matrixStack, 0, 0, 0, 96, 160, 32);

            if (getLine2().isEmpty()) {
                toastGui.getClient().textRenderer.draw(matrixStack, getLine1(), 5.0F, 12.0F, line1Color);
            } else {
                toastGui.getClient().textRenderer.draw(matrixStack, getLine1(), 5.0F, 7.0F, line1Color);
                toastGui.getClient().textRenderer.draw(matrixStack, getLine2(), 5.0F, 18.0F, line2Color);
            }
        }
        return getVisibility();
    }

    public abstract String getLine1();

    public abstract String getLine2();

    public abstract boolean shouldRender(ToastManager gui);

    public abstract Visibility getVisibility();
}
