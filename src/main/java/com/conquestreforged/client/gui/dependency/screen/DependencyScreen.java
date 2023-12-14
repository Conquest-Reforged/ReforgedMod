package com.conquestreforged.client.gui.dependency.screen;

import com.conquestreforged.client.gui.dependency.Dependency;
import com.conquestreforged.client.tutorial.Tutorials;
import com.conquestreforged.core.config.section.ConfigSection;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.function.Supplier;

public class DependencyScreen extends Screen {

    private static final ResourceLocation CTM = new ResourceLocation("conquest:textures/gui/dependency/ctm.png");
    private static final int CTM_HEIGHT = 256;
    private static final int CTM_WIDTH = 432;

    private static final int LIST_HEIGHT = 64;
    private static final int TITLE_HEIGHT = 22;
    private static final int MARGIN_TOP = 10;
    private static final int MARGIN_BOTTOM = 28;

    private final Screen screen;
    private final ConfigSection section;
    private final List<Dependency> missing;
    private final Checkbox check = Checkbox.builder(Component.translatable("conquest.dependency.checkbox"), null).selected(false).pos(0, 0).build();

    public DependencyScreen(Screen parent, ConfigSection section, List<Dependency> missing) {
        super(Component.literal("Dependencies"));
        this.screen = parent;
        this.section = section;
        this.missing = missing;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public void onClose() {
        section.set("ignore_dependencies", check.selected());
        section.save();
        Minecraft.getInstance().setScreen(screen);
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
            addRenderableWidget(createButton(dependency, height - buttonHeightDifference, center));
            buttonHeightDifference -= 24;
        }

        //for (Dependency dependency : missing) {
        //    Button button = createButton(dependency);
        //    listWidget.add(button);
        //    addButton(button);
        //}

        addRenderableWidget(Button.builder(Component.translatable("conquest.dependency.close"), b -> clearFocus()).bounds(center - 50, height - 24, 100, 20).build());

        check.setWidth(20);
        /*todo*/
        //check.setHeight(20);
        check.setHeight(height - 24);
        check.setWidth(center + 50 + 8);
        addRenderableWidget(check);
    }

    @Override
    public void render(PoseStack matrixStack, int mx, int my, float ticks) {
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

    private static Button createButton(Dependency dependency, int heightIn, int center) {
        return Button.builder(Component.translatable(dependency.getDisplayName()), btn -> {
            try {
                Util.getPlatform().openUrl(new URL(dependency.getURL()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }).bounds(center - 85, heightIn, 170, 20).build();
    }
}
