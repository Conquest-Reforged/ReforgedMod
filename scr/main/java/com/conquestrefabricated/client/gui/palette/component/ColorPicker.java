package com.conquestrefabricated.client.gui.palette.component;



import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import java.awt.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ColorPicker extends ButtonWidget {

    private static final int pickerWidth = 128;
    private static final int pickerHeight = 32;
    private static final int sliderWidth = pickerWidth;
    private static final int sliderHeight = 10;
    private static final int padding = 1;
    private static final int titleHeight = 10;
    private static final int lineColor = 0x99FFFFFF;
    private static final float hueOffset = 0.68F;

    private float hue = 0F;
    private float saturation = 0.5F;
    private float brightness = 1F;
    private boolean dirty = true;

    private final String title;
    private final Consumer<Integer> consumer;
    private final NativeImageBackedTexture picker = new NativeImageBackedTexture(new NativeImage(pickerWidth, pickerHeight, false));
    private final NativeImageBackedTexture slider = new NativeImageBackedTexture(new NativeImage(sliderWidth, sliderHeight, false));

    public ColorPicker(String title, int initial, Consumer<Integer> consumer) {
        super(0, 0, pickerWidth, titleHeight + pickerHeight + sliderHeight + padding, Text.translatable(""), button -> {});
        this.title = title;
        this.consumer = consumer;
        float[] hsb = new Color(initial).getColorComponents(new float[3]);
        hue = hsb[0];
        saturation = hsb[1];
        brightness = hsb[2];
    }

    @Override
    public void render(MatrixStack matrixStack, int mx, int my, float ticks) {
        if (dirty) {
            renderImage();
        }

        int top = y;
        int left = x;
        MinecraftClient.getInstance().textRenderer.drawWithShadow(matrixStack, "TEST", top, left, 0xFFFFFF);

        top += 10;
        picker.bindTexture();
        DrawableHelper.drawTexture(matrixStack, left, top, pickerWidth, pickerHeight, 0, 0, pickerWidth, pickerHeight, pickerWidth, pickerHeight);

        top += pickerHeight + padding;
        slider.bindTexture();
        DrawableHelper.drawTexture(matrixStack, left, top, sliderWidth, sliderHeight, 0, 0, sliderWidth, sliderHeight, sliderWidth, sliderHeight);
    }

    @Override
    public boolean mouseDragged(double x1, double y1, int button, double x2, double y2) {
        if (interact(x2, y2)) {
            return true;
        }
        return super.mouseDragged(x1, y1, button, x2, y2);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (interact(mx, my - titleHeight)) {
            return super.mouseClicked(mx, my, button);
        }
        return false;
    }

    public void dispose() {
        picker.close();
        slider.close();
    }

    private boolean interact(double mx, double my) {
        boolean color = click(mx, my, x, y, picker, (x, y) -> {
            this.hue = x;
            this.saturation = y;
            this.consumer.accept(getRGB(hue, saturation, brightness));
            this.dirty = true;
        });

        if (color) {
            return true;
        }

        return click(mx, my, x, y + pickerHeight + 1, slider, (x1, y1) -> {
            this.brightness = x1;
            this.consumer.accept(getRGB(hue, saturation, brightness));
            this.dirty = true;
        });
    }

    private boolean click(double mx, double my, int left, int top, NativeImageBackedTexture texture, BiConsumer<Float, Float> consumer) {
        NativeImage image = texture.getImage();
        if (image == null) {
            return false;
        }

        if (mx >= left && mx < left + image.getWidth() && my >= top && my < top + image.getHeight()) {
            float dx = (int) mx - left;
            float dy = (int) my - top;
            float x = dx / image.getWidth();
            float y = dy / image.getHeight();
            consumer.accept(x, y);
            return true;
        }

        return false;
    }


    private void renderImage() {
        renderColor();
        renderBrightness();
        picker.upload();
        slider.upload();
    }

    private void renderColor() {
        NativeImage picker = this.picker.getImage();
        if (picker == null) {
            return;
        }

        int crosshairX = (int) (picker.getWidth() * hue);
        int crosshairY = (int) (picker.getHeight() * saturation);
        float displayBrightness = 0.5F + (0.5F * brightness);
        for (int y = 0; y < picker.getHeight(); y++) {
            float sat = ((float) y) / pickerHeight;
            for (int x = 0; x < picker.getWidth(); x++) {
                float hue = (((float) x) / pickerWidth);
                int rgb = Color.HSBtoRGB(hue, sat, displayBrightness);
                picker.setColor(x, y, rgb);

                if (x == crosshairX || y == crosshairY) {
                    //picker.blendPixel(x, y, lineColor);
                }
            }
        }
    }

    private void renderBrightness() {
        NativeImage slider = this.slider.getImage();
        if (slider == null) {
            return;
        }

        int slidebarX = (int) (slider.getWidth() * brightness);
        for (int x = 0; x < slider.getWidth(); x++) {
            float brightness = ((float) x) / slider.getWidth();
            for (int y = 0; y < slider.getHeight(); y++) {
                int rgb = Color.HSBtoRGB(hue, saturation, brightness);
                slider.setColor(x, y, rgb);

                if (x == slidebarX) {
                    //slider.blendPixel(x, y, lineColor);
                }
            }
        }
    }

    private static int getRGB(float hue, float saturation, float brightness) {
        Color rgb = Color.getHSBColor(hue, saturation, brightness);
        return NativeImage.packColor(255, rgb.getBlue(), rgb.getGreen(), rgb.getRed());
    }
}
