package com.conquestreforged.client.gui.intro;

import com.conquestreforged.client.BindManager;
import com.conquestreforged.client.tutorial.Tutorials;
import com.conquestreforged.core.config.section.ConfigSection;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class IntroScreen extends Screen {

    private static final ResourceLocation LOGO = new ResourceLocation("conquest:textures/gui/intro/logosmall.png");
    private static final int LOGO_HEIGHT = 100;
    private static final int LOGO_WIDTH = 100;

    private final Screen screen;
    private final ConfigSection section;
    private final Checkbox check = new Checkbox(0, 0, 0, 0, new TranslatableComponent("conquest.intro.checkbox"), false);


    public IntroScreen(Screen parent, ConfigSection section) {
        super(new TextComponent("Intro"));
        this.screen = parent;
        this.section = section;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public void onClose() {
        section.set("ignore_intro", check.selected());
        section.save();

        Minecraft.getInstance().setScreen(screen);
    }

    @Override
    protected void init() {
        Tutorials.intro = true;
        super.init();

        int center = width / 2;

        addRenderableWidget(new Button(center - 50, height - 24, 100, 20, new TranslatableComponent("conquest.intro.Continue"), b -> onClose()));

        check.setWidth(20);
        check.setHeight(20);
        check.y = height - 24;
        check.x = center + 50 + 8;
        addRenderableWidget(check);
    }

    @Override
    public void render(PoseStack matrixStack, int mx, int my, float ticks) {
        renderBackground(matrixStack);

        TextComponent paletteKeyLetter = (TextComponent) new TextComponent(BindManager.getPaletteBind().getTranslatedKeyMessage().getString().toUpperCase()).withStyle(ChatFormatting.GOLD);
        TextComponent blockstateSelectorKeyLetter = (TextComponent) new TextComponent("CTRL+MIDDLE-MOUSE-BUTTON").withStyle(ChatFormatting.GOLD);
        TextComponent welcomeString = (TextComponent) new TextComponent("Welcome to the Conquest Reforged 1.16.5 Alpha!").withStyle(ChatFormatting.GOLD);

        TextComponent[] message = new TextComponent[]{welcomeString,
                new TextComponent("This screen will introduce you to keybinds for making building faster."),
                new TextComponent(""),
                (TextComponent) new TextComponent("\"").append(paletteKeyLetter).append("\" - (Creative Mode only) shows texture shape variants in the block palette."),
                new TextComponent("Works while hovering over a block in the creative menu or when selected in the hotbar."),
                new TextComponent(""),
                (TextComponent) new TextComponent("\"").append(blockstateSelectorKeyLetter).append("\" - (Creative Mode only) press while looking at a block"),
                new TextComponent("This gives the exact shape you're looking at as a block item in your hotbar.")
        };

        int dist = 12;

        RenderSystem.enableTexture();
        RenderSystem.setShaderTexture(0, LOGO);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        GuiComponent.blit(matrixStack, getImageLeft(35), 15, 35, 35, 0, 0, LOGO_WIDTH, LOGO_HEIGHT, LOGO_WIDTH, LOGO_HEIGHT);

        for(int i = 0; i < message.length; i++) {
            int titleWidth = font.width(message[i]);
            int titleOffset = titleWidth / 2;
            font.drawShadow(matrixStack, message[i], width / 2F - titleOffset , 70 + i * dist, 0xFFFFFF);
        }

        super.render(matrixStack, mx, my, ticks);
    }

    private int getImageLeft(int imageWidth) {
        // find the left (x) pos of the image so that it is centered on screen
        return (width / 2) - (imageWidth / 2);
    }
}
