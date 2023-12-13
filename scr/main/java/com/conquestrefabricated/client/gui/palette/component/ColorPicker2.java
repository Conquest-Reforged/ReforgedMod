package com.conquestrefabricated.client.gui.palette.component;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.ParentElement;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.OptionSliderWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ColorPicker2 extends ClickableWidget implements ParentElement, Drawable {

    private static final ButtonWidget.PressAction NONE = btn -> {};
    private static final int VERT_SPACING = 2;

    //private final ForgeSlider red;
    //private final ForgeSlider green;
    //private final ForgeSlider blue;
    private final List<OptionSliderWidget> sliders;
    private final Consumer<Integer> consumer;

    public int x = 0;
    public int y = 0;
    private boolean dragging = false;
    private Element focused;

    // (int xPos, int yPos, int width, int height, String prefix, String suf, double minVal, double maxVal, double currentVal, boolean showDec, boolean drawStr, IPressable handler)
    public ColorPicker2(Text name, int color, Consumer<Integer> consumer) {
        super(0, 0, 0, 0, name);
        int[] rgb = getComponents(color);
        this.consumer = consumer;
        this.sliders = Arrays.asList(
                //this.red = new ForgeSlider(0, 0, new TranslatableComponent("red"), 0, 255, rgb[0], NONE, this),
                //this.green = new ForgeSlider(0, 0, new TranslatableComponent("red"), 0, 255, rgb[1], NONE, this),
                //this.blue = new ForgeSlider(0, 0, new TranslatableComponent("red"), 0, 255, rgb[2], NONE, this)
        );
    }

    @Override
    public void render(MatrixStack matrixStack, int mx, int my, float ticks) {
        int top = y;
        for (OptionSliderWidget slider : sliders) {
            slider.x = x;
            slider.y = top;
            slider.render(matrixStack, mx, my, ticks);
            top += slider.getHeight() + VERT_SPACING;
        }
    }

   // @Override
    public void setHeight(int value) {
        int totalSpacing = VERT_SPACING * (sliders.size() - 1);
        int sliderHeight = (value - totalSpacing) / 3;
        for (OptionSliderWidget slider : sliders) {
            //slider.setHeight(sliderHeight);
        }
    }

    @Override
    public void setWidth(int width) {
        for (OptionSliderWidget slider : sliders) {
            slider.setWidth(width);
        }
    }

    @Override
    public List<? extends Element> children() {
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
    public Element getFocused() {
        return focused;
    }

    @Override
    public void setFocused(@Nullable Element focused) {
        this.focused = focused;
    }

    private static int[] getComponents(int i) {
        Color color = new Color(i);
        return new int[]{color.getRed(), color.getGreen(), color.getBlue()};
    }

    private static int combine(int r, int g, int b) {
        return new Color(r, g, b).getRGB();
    }

    @Override
    public void appendNarrations(NarrationMessageBuilder p_169152_) {

    }
}
