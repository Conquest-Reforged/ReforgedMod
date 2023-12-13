package com.conquestrefabricated.client.gui.palette;

import com.conquestrefabricated.client.BindManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class PaletteGuiEvents {

   // @SubscribeEvent
    public static void onKeyPress(Screen currentScreen, int key, int scancode, int modifiers) {
        if (currentScreen instanceof HandledScreen<?> screen) {
            PlayerEntity player = MinecraftClient.getInstance().player;
            if (player == null || !player.getAbilities().creativeMode) {
                return;
            }

            if (screen instanceof CreativeInventoryScreen creativeScreen) {
                // ignore search tab in creative inventory
                int tabIndex = creativeScreen.getSelectedTab();
                if (tabIndex == ItemGroup.SEARCH.getIndex()) {
                    return;
                }
            }

            if (screen instanceof PaletteScreen) {
                // open previous screen or close if none
                if (PaletteScreen.closesGui(key)) {
                    screen.close();
                    return;
                }

                // open creative gui regardless if was there previously
                if (key == MinecraftClient.getInstance().options.inventoryKey.getDefaultKey().getCode()) {
                    MinecraftClient.getInstance().setScreen(new CreativeInventoryScreen(player));
                    return;
                }
            }

            // ignore everything else
            if (key != BindManager.getPaletteBind().getDefaultKey().getCode()) {
                return;
            }

            Slot slot = screen.focusedSlot;
            if (slot == null || !slot.hasStack()) {
                return;
            }

            ItemStack stack = slot.getStack();
            Optional<Inventory> palette = Palette.getPalette(stack);
            if (!palette.isPresent()) {
                return;
            }

            PaletteContainer container = new PaletteContainer(player.getInventory(), palette.get());
            PaletteScreen paletteScreen = new PaletteScreen(screen, player, player.getInventory(), container);
            MinecraftClient.getInstance().setScreen(paletteScreen);
        }
    }

/*
    public static void onRender() {
        if (event.getOverlay() == ForgeIngameGui.HOTBAR_ELEMENT) {
            if (Minecraft.getInstance().screen instanceof PaletteScreen) {
                event.setCanceled(true);
            }
        }
    }*/
}
