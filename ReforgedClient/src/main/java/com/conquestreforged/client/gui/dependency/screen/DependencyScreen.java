package com.conquestreforged.client.gui.dependency.screen;

import com.conquestreforged.client.gui.dependency.Dependency;
import com.conquestreforged.client.tutorial.Tutorials;
import com.conquestreforged.core.config.section.ConfigSection;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
    private final CheckboxButton check = new CheckboxButton(0, 0, 0, 0, "Do not show again", false);

    private ListWidget listWidget;

    public DependencyScreen(Screen parent, ConfigSection section, List<Dependency> missing) {
        super(new StringTextComponent("Dependencies"));
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
        section.set("ignore_dependencies", check.isChecked());
        section.save();
        Minecraft.getInstance().displayGuiScreen(screen);
    }

    @Override
    public void init(Minecraft mc, int width, int height) {
        Tutorials.dependencies = true;
        super.init(mc, width, height);

        int center = width / 2;

        int imageHeight = getImageHeight();
        int imageWidth = getImageWidth(imageHeight);
        int paddingTop = getPaddingTop(imageHeight);
        int listTop = paddingTop + imageHeight;
        int listBottom = listTop + TITLE_HEIGHT + LIST_HEIGHT;

        listWidget = new ListWidget(this, imageWidth, listTop, TITLE_HEIGHT, listBottom);
        listWidget.setLeftPos(center - (imageWidth / 2));
        children.add(listWidget);

        for (Dependency dependency : missing) {
            Button button = createButton(dependency);
            listWidget.add(button);
            children.add(button);
        }

        addButton(new Button(center - 50, height - 24, 100, 20, "Continue", b -> onClose()));

        check.setWidth(20);
        check.setHeight(20);
        check.y = height - 24;
        check.x = center + 50 + 8;
        addButton(check);
    }

    @Override
    public void render(int mx, int my, float ticks) {
        renderBackground();

        listWidget.render(mx, my, ticks);

        int imageHeight = getImageHeight();
        int imageWidth = getImageWidth(imageHeight);
        int imageLeft = getImageLeft(imageWidth);
        int paddingTop = getPaddingTop(imageHeight);

        RenderSystem.enableTexture();
        Minecraft.getInstance().getTextureManager().bindTexture(CTM);
        AbstractGui.blit(imageLeft, paddingTop, imageWidth, imageHeight, 0, 0, CTM_WIDTH, CTM_HEIGHT, CTM_WIDTH, CTM_HEIGHT);

        String message = "Missing Dependencies:";
        int titleWidth = font.getStringWidth(message);
        int titleOffset = titleWidth / 2;
        font.drawStringWithShadow(message, (width / 2F) - titleOffset, paddingTop + imageHeight + 8, 0xFFFFFF);

        super.render(mx, my, ticks);
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

    private static Button createButton(Dependency dependency) {
        return new Button(0, 0, 0, 0, dependency.getDisplayName(), btn -> {
            try {
                Util.getOSType().openURL(new URL(dependency.getURL()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }
}
