package com.conquestreforged.client.gui.palette;

import com.conquestreforged.client.BindManager;
import com.conquestreforged.client.gui.CustomCreativeScreen;
import com.conquestreforged.client.gui.palette.component.PaletteSettings;
import com.conquestreforged.client.gui.render.Render;
import com.conquestreforged.client.tutorial.Tutorials;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class PaletteScreen extends CustomCreativeScreen<PaletteContainer> {

    private static final Identifier WHEEL = new Identifier("conquest:textures/gui/picker/wheel.png");

    private static final int EXIT = 256;
    private static final int SIZE = (PaletteContainer.RADIUS + 44) * 2;

    private final Screen previous;
    private final PaletteSettings settings = new PaletteSettings();

    private Slot hovered = null;

    public PaletteScreen(PlayerEntity player, PlayerInventory inventory, PaletteContainer container) {
        this(null, player, inventory, container);
    }

    public PaletteScreen(Screen previous, PlayerEntity player, PlayerInventory inventory, PaletteContainer container) {
        super(container, inventory, Text.literal("Palette Screen"));
        this.previous = previous;
        this.passEvents = true;
        player.currentScreenHandler = container;
    }

    @Override
    protected void init() {
        super.init();
        settings.init(client, width, height);
        addDrawable(settings);
        resize(client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight());
        Tutorials.openPalette = true;
    }

    //#setSize gone...replaced with #resize
    @Override
    public void resize(MinecraftClient minecraft, int width, int height) {
        super.resize(minecraft, width, height);
        resize(width, height);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        drawBackground(matrixStack, partialTicks, mouseX, mouseY);

        getScreenHandler().updateStyle(settings);

        setupRender(matrixStack);
        {
            final int mx = mouseX - x;
            final int my = mouseY - y;
            // render radial slots
            getScreenHandler().visitRadius(mx, my, (slot, depth) -> {
                float scale = slot.getScale(mx, my, settings);
                renderSlotBackGround(matrixStack, slot, slot.getStyle(), depth, scale);
            });
            getScreenHandler().visitRadius(mx, my, (slot, depth) -> {
                float scale = slot.getScale(mx, my, settings);
                renderSlot(matrixStack, slot, slot.getStyle(), mx, my, depth, scale);
            });
            // render center slot
            getScreenHandler().visitCenter(slot -> {
                float scale = slot.getScale(mx, my, settings);
                RenderSystem.enableBlend();
                renderSlotBackGround(matrixStack, slot, slot.getStyle(), 1F, scale);
                renderSlot(matrixStack, slot, slot.getStyle(), mx, my, 1F, scale);
            });
            // render hotbar
            getScreenHandler().visitHotbar(slot -> renderSlot(matrixStack, slot, mx, my, 1F, 1F));
            // render the dragged item
            renderDraggedItem(matrixStack, mx, my, 1F, getScreenHandler().getDraggedStyle());
        }
        tearDownRender(matrixStack);

        settings.render(matrixStack, mouseX, mouseY, partialTicks);

        // render display text
        drawForeground(matrixStack, mouseX, mouseY);
    }

    @Override
    public void drawBackground(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        // translucent black background
        renderBackground(matrixStack);

        // Wheel texture
        Render.drawTexture(WHEEL, matrixStack, x, y, SIZE, SIZE, 0, 0);

        // Render hotbar texture
        getScreenHandler().getHotbar().renderBackground(this, matrixStack);
    }

    @Override
    protected void drawForeground(MatrixStack matrixStack, int mouseX, int mouseY) {
        super.drawForeground(matrixStack, mouseX, mouseY);
        if (client == null) {
            return;
        }

        ItemStack display = getScreenHandler().getCursorStack();
        if (display.isEmpty()) {
            Slot slot = getScreenHandler().getClosestSlot(mouseX - this.x, mouseY - this.y, true);
            hovered = slot;
            if (slot == null) {
                return;
            }
            display = slot.getStack();
        }

        if (display.getItem() == Items.AIR) {
            return;
        }

        int top = (height - 32);
        int left = width / 2;
        int color = 0xFFFFFF;

        String text = display.getName().getString();
        drawCenteredText(matrixStack, client.textRenderer, text, left, top, color);
    }

    @Override
    public boolean charTyped(char c, int code) {
        if (c >= '1' && c <= '9' && hovered != null && hovered.hasStack()) {
            handler.getHotbar().getInventory().setStack(c - '1', hovered.getStack());
            super.sendChanges();
            return true;
        }
        return super.charTyped(c, code);
    }

    @Override
    protected boolean isContainerSlot(Slot slot) {
        return slot.inventory == getScreenHandler().getPaletteInventory();
    }

    @Override
    public void close() {
        settings.close();
        if (previous != null) {
            previous.init(MinecraftClient.getInstance(), width, height);
        }
        MinecraftClient.getInstance().setScreen(previous);
    }

    private void resize(int width, int height) {
        this.backgroundWidth = width;
        this.backgroundHeight = height;
        this.x = (width - SIZE) / 2;
        this.y = (height - SIZE) / 2;
        getScreenHandler().init(this);
    }

    public static boolean closesGui(int key) {
        return key == EXIT || key == BindManager.getPaletteBind().getDefaultKey().getCode();
    }
}
