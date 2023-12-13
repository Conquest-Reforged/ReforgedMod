package com.conquestreforged.client.gui;

import com.conquestreforged.client.gui.render.Render;
import com.conquestreforged.client.utils.CreativeUtils;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.StringTextComponent;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public abstract class PickerScreen<T> extends Screen {

    private final ItemStack stack;
    private final T selected;
    private final List<T> options;

    private int index = -1;

    public PickerScreen(String title, ItemStack stack, T selected, List<T> options) {
        super(new StringTextComponent(title));
        this.stack = stack;
        this.options = options;
        this.selected = selected;
    }

    public boolean match(T a, T b) {
        return a.equals(b);
    }

    @Override
    public void init(Minecraft mc, int width, int height) {
        super.init(mc, width, height);
        this.index = indexOf(selected, options);
        Render.hideMouse();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        Minecraft.getInstance().displayGuiScreen(null);
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean keyPressed(int typedChar, int keyCode, int what) {
        if (typedChar == GLFW.GLFW_KEY_LEFT) {
            if (--index < 0) {
                index = options.size() - 1;
            }
        }
        if (typedChar == GLFW.GLFW_KEY_RIGHT) {
            if (++index >= options.size()) {
                index = 0;
            }
        }
        return super.keyPressed(typedChar, keyCode, what);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        renderBackground();

        int centerX = width / 2;
        int centerY = height / 2;

        GlStateManager.enableAlphaTest();
        GlStateManager.enableTexture();

        int maxWidth = (options.size()) / 2;
        int size = Math.min(maxWidth, getSize());
        for (int i = size, visited = 0; i >= 0; i--) {
            if (i == 0) {
                renderOption(centerX, centerY, i);
            } else {
                renderOption(centerX, centerY, +i);
                if (++visited >= (options.size() - 1)) {
                    continue;
                }
                renderOption(centerX, centerY, -i);
            }
        }
        drawLabel(centerX, centerY);
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double scroll) {
        if (scroll > 0) {
            if (--index < 0) {
                index = options.size() - 1;
            }
        }
        if (scroll < 0) {
            if (++index >= options.size()) {
                index = 0;
            }
        }
        return false;
    }

    @Override
    public void removed() {
        Render.showMouse();

        if (minecraft == null || minecraft.player == null || !minecraft.player.isCreative()) {
            return;
        }

        T option = options.get(index);
        CreativeUtils.replaceItemStack(stack, createItemStack(this.stack, option));
    }

    private void renderOption(int cx, int cy, int di) {
        int index = this.index + di;

        if (index < 0) {
            index += (options.size());
        }

        if (index >= options.size()) {
            index -= options.size();
        }

        if (index < 0 || index >= options.size()) {
            return;
        }

        float scale = 2F - ((Math.abs(di)) / 4F);
        float count = (getSize() * 2) + 1;
        int size = Math.round((this.width / count) * scale);
        int left = cx + 1 + (di * (size + 1)) - (size / 2);
        int top = cy - (size / 2);

        T option = options.get(index);
        float w = 1F;
        float h = 1F;
        int width = getWidth(option);
        int height = getHeight(option);
        if (width != height) {
            float scale1 = 1F / Math.max(width, height);
            w = width * scale1;
            h = height * scale1;
        }

        int tw = Math.round(size * w);
        int th = Math.round(size * h);
        int tl = left + ((size - tw) / 2);
        int tt = top + ((size - th) / 2);

        float alpha = Math.min(1F, 0.4F + Math.max(0, 1F - (Math.abs(di) / 2F)));
        RenderSystem.color4f(alpha, alpha, alpha, 1F);
        RenderSystem.pushMatrix();
        RenderSystem.translatef(0, 0, scale * 50);
        render(option, tl, tt, tw, th, scale);
        RenderSystem.popMatrix();
    }

    private void drawLabel(int centerX, int centerY) {
        if (index < 0 || index >= options.size()) {
            return;
        }

        int height = (this.width / ((getSize() * 2) + 1)) + 10;

        int barWidth = 150;
        int barLeft = (this.width / 2) - (barWidth / 2);
        int barTop = centerY + height + getYOffset();
        int barRight = barLeft + barWidth;
        int barBottom = barTop + 3;

        float position = ((float) index) / (options.size() - 1);
        int posLeft = barLeft + Math.round(position * barWidth) - 1;
        int posRight = posLeft + 2;
        fillGradient(barLeft, barTop, barRight, barBottom, 0x44000000, 0x44000000);
        fillGradient(posLeft, barTop, posRight, barBottom, 0x66FFFFFF, 0x66FFFFFF);

        T option = options.get(index);
        String text = getDisplayName(option);
        int width = font.getStringWidth(text);
        float top = barTop + 15;
        float left = centerX - (width / 2F);
        font.drawStringWithShadow(text, left, top, 0xFFFFFF);
    }

    private int indexOf(T value, List<T> options) {
        for (int i = 0; i < options.size(); i++) {
            if (match(value, options.get(i))) {
                return i;
            }
        }
        return 0;
    }

    public int getSize() {
        return 5;
    }

    public int getYOffset() {
        return 0;
    }

    public abstract int getWidth(T option);

    public abstract int getHeight(T option);

    public abstract String getDisplayName(T option);

    public abstract void render(T option, int x, int y, int width, int height, float scale);

    public abstract ItemStack createItemStack(ItemStack original, T value);
}
