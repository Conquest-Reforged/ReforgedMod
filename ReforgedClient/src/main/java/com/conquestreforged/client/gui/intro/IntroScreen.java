package com.conquestreforged.client.gui.intro;

import com.conquestreforged.client.BindManager;
import com.conquestreforged.client.tutorial.Tutorials;
import com.conquestreforged.core.config.section.ConfigSection;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import static net.minecraft.util.text.TextFormatting.GOLD;

public class IntroScreen extends Screen {

    private static final ResourceLocation LOGO = new ResourceLocation("conquest:textures/gui/intro/logosmall.png");
    private static final int LOGO_HEIGHT = 100;
    private static final int LOGO_WIDTH = 100;

    private final Screen screen;
    private final ConfigSection section;
    private final CheckboxButton check = new CheckboxButton(0, 0, 0, 0, "Do not show again", false);


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
        section.set("ignore_intro", check.isChecked());
        section.save();

        Minecraft.getInstance().displayGuiScreen(screen);
    }

    @Override
    public void init(Minecraft mc, int width, int height) {
        Tutorials.intro = true;
        super.init(mc, width, height);

        int center = width / 2;

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

        ITextComponent paletteKeyLetter = new StringTextComponent(BindManager.getPaletteBind().getLocalizedName().toUpperCase()).applyTextStyles(GOLD);
        //ITextComponent toggleKeyLetter = new StringTextComponent(BindManager.getBlockToggleBind().getLocalizedName().toUpperCase()).applyTextStyles(GOLD);
        ITextComponent blockstateSelectorKeyLetter = new StringTextComponent("CTRL+MIDDLE-MOUSE-BUTTON").applyTextStyles(GOLD);
        ITextComponent welcomeString = new StringTextComponent("Welcome to the Conquest Reforged 1.15.2 Beta!").applyTextStyles(GOLD);

        String[] message = new String[]{welcomeString.getFormattedText(),
                "This screen will introduce you to keybinds for making building faster.",
                "",
                "\"" + paletteKeyLetter.getFormattedText() + "\" - (Creative Mode only) shows texture shape variants in the block palette.",
                "Works while hovering over a block in the creative menu or when selected in the hotbar.",
                "",
                //"\"" + toggleKeyLetter.getFormattedText() + "\" - cycles through and locks blockstates while building.",
                //"Used for blocks with varying sizes (slabs, layers, vert stairs, arches, etc).",
                //"",
                "\"" + blockstateSelectorKeyLetter.getFormattedText() + "\" - (Creative Mode only) press while looking at a block",
                "This gives the exact shape you're looking at as a block item in your hotbar."
        };

        int dist = 12;

        RenderSystem.enableTexture();
        Minecraft.getInstance().getTextureManager().bindTexture(LOGO);
        AbstractGui.blit(getImageLeft(35), 15, 35, 35, 0, 0, LOGO_WIDTH, LOGO_HEIGHT, LOGO_WIDTH, LOGO_HEIGHT);

        for(int i = 0; i < message.length; i++) {
            int titleWidth = font.getStringWidth(message[i]);
            int titleOffset = titleWidth / 2;
            font.drawStringWithShadow(message[i], width / 2F - titleOffset , 70 + i * dist, 0xFFFFFF);
        }

        super.render(mx, my, ticks);
    }

    private int getImageLeft(int imageWidth) {
        // find the left (x) pos of the image so that it is centered on screen
        return (width / 2) - (imageWidth / 2);
    }
}
