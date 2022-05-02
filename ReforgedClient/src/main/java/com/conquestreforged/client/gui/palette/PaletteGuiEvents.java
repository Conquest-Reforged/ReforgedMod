package com.conquestreforged.client.gui.palette;

import com.conquestreforged.client.BindManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PaletteGuiEvents {

    @SubscribeEvent
    public static void onKeyPress(ScreenEvent.KeyboardKeyPressedEvent.Pre event) {
        if (event.getScreen() instanceof AbstractContainerScreen) {
            Player player = Minecraft.getInstance().player;
            if (player == null || !player.getAbilities().instabuild) {
                return;
            }

            AbstractContainerScreen<?> screen = (AbstractContainerScreen<?>) event.getScreen();
            if (screen instanceof CreativeModeInventoryScreen) {
                // ignore search tab in creative inventory
                CreativeModeInventoryScreen creativeScreen = (CreativeModeInventoryScreen) screen;
                int tabIndex = creativeScreen.getSelectedTab();
                if (tabIndex == CreativeModeTab.TAB_SEARCH.getId()) {
                    return;
                }
            }

            if (screen instanceof PaletteScreen) {
                // open previous screen or close if none
                if (PaletteScreen.closesGui(event.getKeyCode())) {
                    event.setCanceled(true);
                    event.getScreen().onClose();
                    return;
                }

                // open creative gui regardless if was there previously
                if (event.getKeyCode() == Minecraft.getInstance().options.keyInventory.getKey().getValue()) {
                    event.setCanceled(true);
                    Minecraft.getInstance().setScreen(new CreativeModeInventoryScreen(player));
                    return;
                }
            }

            // ignore everything else
            if (event.getKeyCode() != BindManager.getPaletteBind().getKey().getValue()) {
                return;
            }

            Slot slot = screen.getSlotUnderMouse();
            if (slot == null || !slot.hasItem()) {
                return;
            }

            ItemStack stack = slot.getItem();
            Optional<Container> palette = Palette.getPalette(stack);
            if (!palette.isPresent()) {
                return;
            }

            event.setCanceled(true);
            PaletteContainer container = new PaletteContainer(player.getInventory(), palette.get());
            PaletteScreen paletteScreen = new PaletteScreen(screen, player, player.getInventory(), container);
            Minecraft.getInstance().setScreen(paletteScreen);
        }
    }

    @SubscribeEvent
    public static void onRender(RenderGameOverlayEvent.PreLayer event) {
        if (event.getOverlay() == ForgeIngameGui.HOTBAR_ELEMENT) {
            if (Minecraft.getInstance().screen instanceof PaletteScreen) {
                event.setCanceled(true);
            }
        }
    }
}
