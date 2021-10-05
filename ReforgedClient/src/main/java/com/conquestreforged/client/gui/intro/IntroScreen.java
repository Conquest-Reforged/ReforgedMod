package com.conquestreforged.client.gui.intro;

import com.conquestreforged.client.BindManager;
import com.conquestreforged.client.tutorial.Tutorials;
import com.conquestreforged.core.config.section.ConfigSection;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class IntroScreen extends Screen {

    private static final ResourceLocation LOGO = new ResourceLocation("conquest:textures/gui/intro/logosmall.png");
    private static final int LOGO_HEIGHT = 100;
    private static final int LOGO_WIDTH = 100;

    private final Screen screen;
    private final ConfigSection section;
    private final CheckboxButton check = new CheckboxButton(0, 0, 0, 0, new TranslationTextComponent("conquest.intro.checkbox"), false);


    public IntroScreen(Screen parent, ConfigSection section) {
        super(new StringTextComponent("Intro"));
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
    public void init(Minecraft mc, int width, int height) {
        Tutorials.intro = true;
        super.init(mc, width, height);

        int center = width / 2;

        addButton(new Button(center - 50, height - 24, 100, 20, new TranslationTextComponent("conquest.intro.Continue"), b -> onClose()));

        check.setWidth(20);
        check.setHeight(20);
        check.y = height - 24;
        check.x = center + 50 + 8;
        addButton(check);
    }

    @Override
    public void render(MatrixStack matrixStack, int mx, int my, float ticks) {
        renderBackground(matrixStack);

        ITextComponent paletteKeyLetter = new StringTextComponent(BindManager.getPaletteBind().getTranslatedKeyMessage().getString().toUpperCase()).withStyle(TextFormatting.GOLD);
        ITextComponent blockstateSelectorKeyLetter = new StringTextComponent("CTRL+MIDDLE-MOUSE-BUTTON").withStyle(TextFormatting.GOLD);
        ITextComponent welcomeString = new StringTextComponent("Welcome to the Conquest Reforged 1.16.5 Alpha!").withStyle(TextFormatting.GOLD);

        ITextComponent[] message = new ITextComponent[]{welcomeString,
                new StringTextComponent("This screen will introduce you to keybinds for making building faster."),
                new StringTextComponent(""),
                new StringTextComponent("\"").append(paletteKeyLetter).append("\" - (Creative Mode only) shows texture shape variants in the block palette."),
                new StringTextComponent("Works while hovering over a block in the creative menu or when selected in the hotbar."),
                new StringTextComponent(""),
                new StringTextComponent("\"").append(blockstateSelectorKeyLetter).append("\" - (Creative Mode only) press while looking at a block"),
                new StringTextComponent("This gives the exact shape you're looking at as a block item in your hotbar.")
        };

        int dist = 12;

        RenderSystem.enableTexture();
        Minecraft.getInstance().getTextureManager().bind(LOGO);
        AbstractGui.blit(matrixStack, getImageLeft(35), 15, 35, 35, 0, 0, LOGO_WIDTH, LOGO_HEIGHT, LOGO_WIDTH, LOGO_HEIGHT);

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
