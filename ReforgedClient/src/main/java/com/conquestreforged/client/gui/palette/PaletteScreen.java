package com.conquestreforged.client.gui.palette;

import com.conquestreforged.client.BindManager;
import com.conquestreforged.client.gui.CustomCreativeScreen;
import com.conquestreforged.client.gui.palette.component.PaletteSettings;
import com.conquestreforged.client.gui.render.Render;
import com.conquestreforged.client.tutorial.Tutorials;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;

public class PaletteScreen extends CustomCreativeScreen<PaletteContainer> {

    private static final ResourceLocation WHEEL = new ResourceLocation("conquest:textures/gui/picker/wheel.png");

    private static final int EXIT = 256;
    private static final int SIZE = (PaletteContainer.RADIUS + 44) * 2;

    private final Screen previous;
    private final PaletteSettings settings = new PaletteSettings();

    private Slot hovered = null;

    public PaletteScreen(Player player, Inventory inventory, PaletteContainer container) {
        this(null, player, inventory, container);
    }

    public PaletteScreen(Screen previous, Player player, Inventory inventory, PaletteContainer container) {
        super(container, inventory, new TextComponent("Palette Screen"));
        this.previous = previous;
        this.passEvents = true;
        player.containerMenu = container;
    }

    @Override
    protected void init() {
        super.init();
        settings.init(minecraft, width, height);
        addRenderableOnly(settings);
        resize(width, height);
        Tutorials.openPalette = true;
    }

    //#setSize gone...replaced with #resize
    @Override
    public void resize(Minecraft minecraft, int width, int height) {
        super.resize(minecraft, width, height);
        resize(width, height);
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        renderBg(matrixStack, partialTicks, mouseX, mouseY);

        getMenu().updateStyle(settings);

        setupRender(matrixStack);
        {
            final int mx = mouseX - leftPos;
            final int my = mouseY - topPos;
            // render radial slots
            getMenu().visitRadius(mx, my, (slot, depth) -> {
                float scale = slot.getScale(mx, my, settings);
                renderSlotBackGround(matrixStack, slot, slot.getStyle(), depth, scale);
            });
            getMenu().visitRadius(mx, my, (slot, depth) -> {
                float scale = slot.getScale(mx, my, settings);
                renderSlot(matrixStack, slot, slot.getStyle(), mx, my, depth, scale);
            });
            // render center slot
            getMenu().visitCenter(slot -> {
                float scale = slot.getScale(mx, my, settings);
                RenderSystem.enableBlend();
                renderSlotBackGround(matrixStack, slot, slot.getStyle(), 1F, scale);
                renderSlot(matrixStack, slot, slot.getStyle(), mx, my, 1F, scale);
            });
            // render hotbar
            getMenu().visitHotbar(slot -> renderSlot(matrixStack, slot, mx, my, 1F, 1F));
            // render the dragged item
            renderDraggedItem(matrixStack, mx, my, 1F, getMenu().getDraggedStyle());
        }
        tearDownRender(matrixStack);

        settings.render(matrixStack, mouseX, mouseY, partialTicks);

        // render display text
        renderLabels(matrixStack, mouseX, mouseY);
    }

    @Override
    public void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        // translucent black background
        renderBackground(matrixStack);

        // Wheel texture
        Render.drawTexture(WHEEL, matrixStack, leftPos, topPos, SIZE, SIZE, 0, 0);

        // Render hotbar texture
        getMenu().getHotbar().renderBackground(this, matrixStack);
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        super.renderLabels(matrixStack, mouseX, mouseY);
        if (minecraft == null) {
            return;
        }

        ItemStack display = getMenu().getCarried();
        if (display.isEmpty()) {
            Slot slot = getMenu().getClosestSlot(mouseX - leftPos, mouseY - topPos, true);
            hovered = slot;
            if (slot == null) {
                return;
            }
            display = slot.getItem();
        }

        if (display.getItem() == Items.AIR) {
            return;
        }

        int top = (height - 32);
        int left = width / 2;
        int color = 0xFFFFFF;

        String text = display.getDisplayName().getString();
        drawCenteredString(matrixStack, minecraft.font, text, left, top, color);
    }

    @Override
    public boolean charTyped(char c, int code) {
        if (c >= '1' && c <= '9' && hovered != null && hovered.hasItem()) {
            menu.getHotbar().getInventory().setItem(c - '1', hovered.getItem());
            super.sendChanges();
            return true;
        }
        return super.charTyped(c, code);
    }

    @Override
    protected boolean isContainerSlot(Slot slot) {
        return slot.container == getMenu().getPaletteInventory();
    }

    @Override
    public void onClose() {
        settings.onClose();
        if (previous != null) {
            previous.init(Minecraft.getInstance(), width, height);
        }
        Minecraft.getInstance().setScreen(previous);
    }

    private void resize(int width, int height) {
        this.imageWidth = SIZE;
        this.imageHeight = SIZE;
        this.leftPos = (width - SIZE) / 2;
        this.topPos = (height - SIZE) / 2;
        getMenu().init(this);
    }

    public static boolean closesGui(int key) {
        return key == EXIT || key == BindManager.getPaletteBind().getKey().getValue();
    }
}
