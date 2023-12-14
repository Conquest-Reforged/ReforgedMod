package com.conquestreforged.client.gui.dependency.screen;

import com.conquestreforged.client.gui.dependency.Dependency;
import com.conquestreforged.client.tutorial.Tutorials;
import com.conquestreforged.core.config.section.ConfigSection;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class DependencyScreen extends Screen {

    private static final Identifier CTM = new Identifier("conquest:textures/gui/dependency/ctm.png");
    private static final int CTM_HEIGHT = 256;
    private static final int CTM_WIDTH = 432;

    private static final int LIST_HEIGHT = 64;
    private static final int TITLE_HEIGHT = 22;
    private static final int MARGIN_TOP = 10;
    private static final int MARGIN_BOTTOM = 28;

    private final Screen screen;
    private final ConfigSection section;
    private final List<Dependency> missing;
    private final CheckboxWidget check = new CheckboxWidget(0, 0, 0, 0, Text.translatable("conquest.dependency.checkbox"), false);

    public DependencyScreen(Screen parent, ConfigSection section, List<Dependency> missing) {
        super(Text.of("Dependencies"));
        this.screen = parent;
        this.section = section;
        this.missing = missing;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public void close() {
        section.set("ignore_dependencies", check.isChecked());
        section.save();
        MinecraftClient.getInstance().setScreen(screen);
    }

    @Override
    protected void init() {
        Tutorials.dependencies = true;
        super.init();

        int center = width / 2;

        int imageHeight = getImageHeight();
        int imageWidth = getImageWidth(imageHeight);
        int paddingTop = getPaddingTop(imageHeight);
        int listTop = paddingTop + imageHeight;
        int listBottom = listTop + TITLE_HEIGHT + LIST_HEIGHT;

        //listWidget = new ListWidget(this, imageWidth, listTop, TITLE_HEIGHT, listBottom);
        //listWidget.setLeftPos(center - (imageWidth / 2));
        //children.add(listWidget);

        int buttonHeightDifference = 94;

        for (Dependency dependency : missing) {
            addDrawableChild(createButton(dependency, height - buttonHeightDifference, center));
            buttonHeightDifference -= 24;
        }

        //for (Dependency dependency : missing) {
        //    Button button = createButton(dependency);
        //    listWidget.add(button);
        //    addButton(button);
        //}

        addDrawableChild(new ButtonWidget(center - 50, height - 24, 100, 20, Text.translatable("conquest.dependency.close"), b -> close()));

        check.setWidth(20);
        /*todo*/
        //check.setHeight(20);
        check.y = height - 24;
        check.x = center + 50 + 8;
        addDrawableChild(check);
    }

    @Override
    public void render(MatrixStack matrixStack, int mx, int my, float ticks) {
        renderBackground(matrixStack);

        //listWidget.render(mx, my, ticks);

        int imageHeight = getImageHeight();
        int imageWidth = getImageWidth(imageHeight);
        int imageLeft = getImageLeft(imageWidth);
        int paddingTop = getPaddingTop(imageHeight);

        RenderSystem.enableTexture();
        RenderSystem.setShaderTexture(0, CTM);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        DrawableHelper.drawTexture(matrixStack, imageLeft, paddingTop, imageWidth, imageHeight, 0, 0, CTM_WIDTH, CTM_HEIGHT, CTM_WIDTH, CTM_HEIGHT);

        String message = "Missing Dependencies:";
        int titleWidth = textRenderer.getWidth(message);
        int titleOffset = titleWidth / 2;
        textRenderer.drawWithShadow(matrixStack, message, (width / 2F) - titleOffset, paddingTop + imageHeight + 8, 0xFFFFFF);

        super.render(matrixStack, mx, my, ticks);
    }

    private int getImageHeight() {
        // scale the iamge to the remaining vertical height after subtracting static height elements
        return Math.min(CTM_HEIGHT, height - MARGIN_TOP - TITLE_HEIGHT - LIST_HEIGHT - MARGIN_BOTTOM);
    }

    private int getImageWidth(int imageHeight) {
        // scale image width proportionally to the image height
        return Math.round(CTM_WIDTH * (((float) imageHeight) / CTM_HEIGHT));
    }

    private int getImageLeft(int imageWidth) {
        // find the left (x) pos of the image so that it is centered on screen
        return (width / 2) - (imageWidth / 2);
    }

    private int getPaddingTop(int imageHeight) {
        // adjust the top margin to ensure all content fits on screen without overlapping
        // attempt to center content vertically before receding upwards to accommodate larger gui scales

        int elementsHeight = imageHeight + TITLE_HEIGHT + LIST_HEIGHT;
        int paddingTop = (height - elementsHeight) / 2;
        int dif = height - (paddingTop + elementsHeight);
        if (dif < MARGIN_BOTTOM) {
            paddingTop -= dif;
            paddingTop = Math.max(paddingTop, 2);
        }
        return paddingTop;
    }

    private static ButtonWidget createButton(Dependency dependency, int heightIn, int center) {
        return new ButtonWidget(center - 85, heightIn, 170, 20, Text.translatable(dependency.getDisplayName()), btn -> {
            try {
                Util.getOperatingSystem().open(new URL(dependency.getURL()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }
}
