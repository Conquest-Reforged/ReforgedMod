package com.conquestreforged.client.gui.palette.component;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.components.events.ContainerEventHandler;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.fmlclient.gui.widget.Slider;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ColorPicker2 extends AbstractWidget implements ContainerEventHandler, Widget, Slider.ISlider {

    private static final Button.OnPress NONE = btn -> {};
    private static final int VERT_SPACING = 2;

    private final Slider red;
    private final Slider green;
    private final Slider blue;
    private final List<Slider> sliders;
    private final Consumer<Integer> consumer;

    public int x = 0;
    public int y = 0;
    private boolean dragging = false;
    private GuiEventListener focused;

    // (int xPos, int yPos, int width, int height, String prefix, String suf, double minVal, double maxVal, double currentVal, boolean showDec, boolean drawStr, IPressable handler)
    public ColorPicker2(Component name, int color, Consumer<Integer> consumer) {
        super(0, 0, 0, 0, name);
        int[] rgb = getComponents(color);
        this.consumer = consumer;
        this.sliders = Arrays.asList(
                this.red = new Slider(0, 0, new TranslatableComponent("red"), 0, 255, rgb[0], NONE, this),
                this.green = new Slider(0, 0, new TranslatableComponent("red"), 0, 255, rgb[1], NONE, this),
                this.blue = new Slider(0, 0, new TranslatableComponent("red"), 0, 255, rgb[2], NONE, this)
        );
    }

    @Override
    public void render(PoseStack matrixStack, int mx, int my, float ticks) {
        int top = y;
        for (Slider slider : sliders) {
            slider.x = x;
            slider.y = top;
            slider.render(matrixStack, mx, my, ticks);
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
    public List<? extends GuiEventListener> children() {
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
    public GuiEventListener getFocused() {
        return focused;
    }

    @Override
    public void setFocused(@Nullable GuiEventListener focused) {
        this.focused = focused;
    }

    private static int[] getComponents(int i) {
        Color color = new Color(i);
        return new int[]{color.getRed(), color.getGreen(), color.getBlue()};
    }

    private static int combine(int r, int g, int b) {
        return new Color(r, g, b).getRGB();
    }

    //todo dont know wtf this is for lol
    @Override
    public void updateNarration(NarrationElementOutput p_169152_) {

    }
}
