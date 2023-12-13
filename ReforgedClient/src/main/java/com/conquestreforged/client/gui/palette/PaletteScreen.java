package com.conquestreforged.client.gui.palette;

import com.conquestreforged.client.BindManager;
import com.conquestreforged.client.gui.CustomCreativeScreen;
import com.conquestreforged.client.gui.palette.component.PaletteSettings;
import com.conquestreforged.client.gui.render.Render;
import com.conquestreforged.client.tutorial.Tutorials;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

public class PaletteScreen extends CustomCreativeScreen<PaletteContainer> {

    private static final ResourceLocation WHEEL = new ResourceLocation("conquest:textures/gui/picker/wheel.png");

    private static final int EXIT = 256;
    private static final int SIZE = (PaletteContainer.RADIUS + 44) * 2;

    private final Screen previous;
    private final PaletteSettings settings = new PaletteSettings();

    private Slot hovered = null;

    public PaletteScreen(PlayerEntity player, PlayerInventory inventory, PaletteContainer container) {
        this(null, player, inventory, container);
    }

    public PaletteScreen(Screen previous, PlayerEntity player, PlayerInventory inventory, PaletteContainer container) {
        super(container, inventory, new StringTextComponent("Palette Screen"));
        this.previous = previous;
        this.passEvents = true;
        player.openContainer = container;
    }

    @Override
    public void init(Minecraft mc, int width, int height) {
        super.init(mc, width, height);
        settings.init(minecraft, width, height);
        children.add(settings);
        resize(width, height);
        Tutorials.openPalette = true;
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        resize(width, height);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);

        getContainer().updateStyle(settings);

        setupRender();
        {
            final int mx = mouseX - guiLeft;
            final int my = mouseY - guiTop;
            // render radial slots
            getContainer().visitRadius(mx, my, (slot, depth) -> {
                float scale = slot.getScale(mx, my, settings);
                renderSlotBackGround(slot, slot.getStyle(), depth, scale);
            });
            getContainer().visitRadius(mx, my, (slot, depth) -> {
                float scale = slot.getScale(mx, my, settings);
                renderSlot(slot, slot.getStyle(), mx, my, depth, scale);
            });
            // render center slot
            getContainer().visitCenter(slot -> {
                float scale = slot.getScale(mx, my, settings);
                RenderSystem.enableBlend();
                renderSlotBackGround(slot, slot.getStyle(), 1F, scale);
                renderSlot(slot, slot.getStyle(), mx, my, 1F, scale);
            });
            // render hotbar
            getContainer().visitHotbar(slot -> renderSlot(slot, mx, my, 1F, 1F));
            // render the dragged item
            renderDraggedItem(mx, my, 1F, getContainer().getDraggedStyle());
        }
        tearDownRender();

        settings.render(mouseX, mouseY, partialTicks);

        // render display text
        drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        // translucent black background
        renderBackground();

        // Wheel texture
        Render.drawTexture(WHEEL, guiLeft, guiTop, SIZE, SIZE, 0, 0);

        // Render hotbar texture
        getContainer().getHotbar().renderBackground(this);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        if (minecraft == null) {
            return;
        }

        ItemStack display = playerInventory.getItemStack();
        if (display.isEmpty()) {
            Slot slot = getContainer().getClosestSlot(mouseX - guiLeft, mouseY - guiTop, true);
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

        String text = display.getDisplayName().getFormattedText();
        drawCenteredString(minecraft.fontRenderer, text, left, top, color);
    }

    @Override
    public boolean charTyped(char c, int code) {
        if (c >= '1' && c <= '9' && hovered != null && hovered.getHasStack()) {
            container.getHotbar().getInventory().setInventorySlotContents(c - '1', hovered.getStack());
            super.sendChanges();
            return true;
        }
        return super.charTyped(c, code);
    }

    @Override
    protected boolean isContainerSlot(Slot slot) {
        return slot.inventory == getContainer().getPaletteInventory();
    }

    @Override
    public void onClose() {
        settings.onClose();
        if (previous != null) {
            previous.init(Minecraft.getInstance(), width, height);
        }
        Minecraft.getInstance().displayGuiScreen(previous);
    }

    private void resize(int width, int height) {
        this.xSize = SIZE;
        this.ySize = SIZE;
        this.guiLeft = (width - SIZE) / 2;
        this.guiTop = (height - SIZE) / 2;
        getContainer().init(this);
    }

    public static boolean closesGui(int key) {
        return key == EXIT || key == BindManager.getPaletteBind().getKey().getKeyCode();
    }
}
