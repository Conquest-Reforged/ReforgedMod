package com.conquestreforged.client.gui.palette;

import com.conquestreforged.client.BindManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PaletteGuiEvents {

    @SubscribeEvent
    public static void onKeyPress(GuiScreenEvent.KeyboardKeyPressedEvent.Pre event) {
        if (event.getGui() instanceof ContainerScreen) {
            PlayerEntity player = Minecraft.getInstance().player;
            if (player == null || !player.abilities.isCreativeMode) {
                return;
            }

            ContainerScreen<?> screen = (ContainerScreen<?>) event.getGui();
            if (screen instanceof CreativeScreen) {
                // ignore search tab in creative inventory
                CreativeScreen creativeScreen = (CreativeScreen) screen;
                int tabIndex = creativeScreen.getSelectedTabIndex();
                if (tabIndex == ItemGroup.SEARCH.getIndex()) {
                    return;
                }
            }

            if (screen instanceof PaletteScreen) {
                // open previous screen or close if none
                if (PaletteScreen.closesGui(event.getKeyCode())) {
                    event.setCanceled(true);
                    event.getGui().onClose();
                    return;
                }

                // open creative gui regardless if was there previously
                if (event.getKeyCode() == Minecraft.getInstance().gameSettings.keyBindInventory.getKey().getKeyCode()) {
                    event.setCanceled(true);
                    Minecraft.getInstance().displayGuiScreen(new CreativeScreen(player));
                    return;
                }
            }

            // ignore everything else
            if (event.getKeyCode() != BindManager.getPaletteBind().getKey().getKeyCode()) {
                return;
            }

            Slot slot = screen.getSlotUnderMouse();
            if (slot == null || !slot.getHasStack()) {
                return;
            }

            ItemStack stack = slot.getStack();
            Optional<IInventory> palette = Palette.getPalette(stack);
            if (!palette.isPresent()) {
                return;
            }

            event.setCanceled(true);
            PaletteContainer container = new PaletteContainer(player.inventory, palette.get());
            PaletteScreen paletteScreen = new PaletteScreen(screen, player, player.inventory, container);
            Minecraft.getInstance().displayGuiScreen(paletteScreen);
        }
    }

    @SubscribeEvent
    public static void onRender(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            if (Minecraft.getInstance().currentScreen instanceof PaletteScreen) {
                event.setCanceled(true);
            }
        }
    }
}
