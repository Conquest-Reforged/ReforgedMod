package com.conquestreforged.client.gui.palette.component;

import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.INestedGuiEventHandler;
import net.minecraft.client.gui.IRenderable;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraftforge.fml.client.gui.widget.Slider;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ColorPicker2 extends Widget implements INestedGuiEventHandler, IRenderable, Slider.ISlider {

    private static final Button.IPressable NONE = btn -> {};
    private static final int VERT_SPACING = 2;

    private final Slider red;
    private final Slider green;
    private final Slider blue;
    private final List<Slider> sliders;
    private final Consumer<Integer> consumer;

    public int x = 0;
    public int y = 0;
    private boolean dragging = false;
    private IGuiEventListener focused;

    // (int xPos, int yPos, int width, int height, String prefix, String suf, double minVal, double maxVal, double currentVal, boolean showDec, boolean drawStr, IPressable handler)
    public ColorPicker2(String name, int color, Consumer<Integer> consumer) {
        super(0, 0, name);
        int[] rgb = getComponents(color);
        this.consumer = consumer;
        this.sliders = Arrays.asList(
                this.red = new Slider(0, 0, "red", 0, 255, rgb[0], NONE, this),
                this.green = new Slider(0, 0, "red", 0, 255, rgb[1], NONE, this),
                this.blue = new Slider(0, 0, "red", 0, 255, rgb[2], NONE, this)
        );
    }

    @Override
    public void render(int mx, int my, float ticks) {
        int top = y;
        for (Slider slider : sliders) {
            slider.x = x;
            slider.y = top;
            slider.render(mx, my, ticks);
            top += slider.getHeight() + VERT_SPACING;
        }
    }

    @Override
    public void onChangeSliderValue(Slider slider) {
        int r = red.getValueInt();
        int g = green.getValueInt();
        int b = blue.getValueInt();
        consumer.accept(combine(r, g, b));
    }

    @Override
    public void setHeight(int value) {
        int totalSpacing = VERT_SPACING * (sliders.size() - 1);
        int sliderHeight = (value - totalSpacing) / 3;
        for (Slider slider : sliders) {
            slider.setHeight(sliderHeight);
        }
    }

    @Override
    public void setWidth(int width) {
        for (Slider slider : sliders) {
            slider.setWidth(width);
        }
    }

    @Override
    public List<? extends IGuiEventListener> children() {
        return sliders;
    }

    @Override
    public boolean isDragging() {
        return dragging;
    }

    @Override
    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    @Nullable
    @Override
    public IGuiEventListener getFocused() {
        return focused;
    }

    @Override
    public void setFocused(@Nullable IGuiEventListener focused) {
        this.focused = focused;
    }

    private static int[] getComponents(int i) {
        Color color = new Color(i);
        return new int[]{color.getRed(), color.getGreen(), color.getBlue()};
    }

    private static int combine(int r, int g, int b) {
        return new Color(r, g, b).getRGB();
    }
}
