package com.conquestreforged.client.gui.intro;

import com.conquestreforged.client.BindManager;
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
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;


public class IntroScreen extends Screen {

    private static final Identifier LOGO = new Identifier("conquest:textures/gui/intro/logosmall.png");
    private static final int LOGO_HEIGHT = 100;
    private static final int LOGO_WIDTH = 100;

    private final Screen screen;
    private final ConfigSection section;
    private final CheckboxWidget check = new CheckboxWidget(0, 0, 0, 0, Text.translatable("conquest.intro.checkbox"), false);


    public IntroScreen(Screen parent, ConfigSection section) {
        super(Text.literal("Intro"));
        this.screen = parent;
        this.section = section;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public void close() {
        section.set("ignore_intro", check.isChecked());
        section.save();

        MinecraftClient.getInstance().setScreen(screen);
    }

    @Override
    protected void init() {
        Tutorials.intro = true;
        super.init();

        int center = width / 2;

        addDrawableChild(new ButtonWidget(center - 50, height - 24, 100, 20, Text.translatable("conquest.intro.Continue"), b -> close()));

        check.setWidth(20);
        //check.setHeight(20);
        check.y = height - 24;
        check.x = center + 50 + 8;
        addDrawableChild(check);
    }

    @Override
    public void render(MatrixStack matrixStack, int mx, int my, float ticks) {
        renderBackground(matrixStack);

        Text paletteKeyLetter = Text.literal(BindManager.getPaletteBind().getBoundKeyLocalizedText().getString().toUpperCase()).formatted(Formatting.GOLD);
        Text blockstateSelectorKeyLetter = Text.literal("CTRL+MIDDLE-MOUSE-BUTTON").formatted(Formatting.GOLD);
        Text welcomeString = Text.literal("Welcome to the Conquest Reforged for Fabric 1.19.2 Beta!").formatted(Formatting.GOLD);

        Text[] message = new Text[]{welcomeString,
                Text.literal("This screen will introduce you to keybinds for making building faster."),
                Text.literal(""),
                Text.literal("\"").append(paletteKeyLetter).append("\" - (Creative Mode only) shows texture shape variants in the block palette."),
                Text.literal("Works while hovering over a block in the creative menu or when selected in the hotbar."),
                Text.literal(""),
                Text.literal("\"").append(blockstateSelectorKeyLetter).append("\" - (Creative Mode only) press while looking at a block"),
                Text.literal("This gives the exact shape you're looking at as a block item in your hotbar.")
        };

        int dist = 12;

        RenderSystem.enableTexture();
        RenderSystem.setShaderTexture(0, LOGO);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        DrawableHelper.drawTexture(matrixStack, getImageLeft(35), 15, 35, 35, 0, 0, LOGO_WIDTH, LOGO_HEIGHT, LOGO_WIDTH, LOGO_HEIGHT);

        for(int i = 0; i < message.length; i++) {
            int titleWidth = textRenderer.getWidth(message[i]);
            int titleOffset = titleWidth / 2;
            textRenderer.drawWithShadow(matrixStack, message[i], width / 2F - titleOffset , 70 + i * dist, 0xFFFFFF);
        }

        super.render(matrixStack, mx, my, ticks);
    }

    private int getImageLeft(int imageWidth) {
        // find the left (x) pos of the image so that it is centered on screen
        return (width / 2) - (imageWidth / 2);
    }
}