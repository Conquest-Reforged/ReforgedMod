package com.conquestreforged.client.bind;

import com.conquestreforged.client.BindManager;
import com.conquestreforged.client.Secrets;
import com.conquestreforged.client.gui.state.BlockStateScreen;
import com.conquestreforged.client.gui.state.PropertyFilter;
import com.conquestreforged.core.block.StateUtils;
import com.conquestreforged.core.capability.Capabilities;
import com.conquestreforged.core.client.input.BindEvent;
import com.conquestreforged.core.client.input.BindListener;
import com.conquestreforged.core.net.Channels;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class ToggleBindListener implements BindListener {

    @Override
    public void onPress(BindEvent e) {
        if (!e.inGame || !e.player.isPresent()) {
            return;
        }

        if (Secrets.useStatePicker()) {
            ItemStack stack = e.player.get().getHeldItemMainhand();
            StateUtils.getOrDefault(stack)
                    .flatMap(s -> BlockStateScreen.of(stack, s, PropertyFilter.INSTANCE))
                    .ifPresent(Minecraft.getInstance()::displayGuiScreen);
        } else {
            e.player.get().getCapability(Capabilities.TOGGLE).ifPresent(toggle -> {
                // increment the toggle value 0-8
                toggle.increment();

                // send the new toggle state to server
                Channels.TOGGLE.sendToServer(toggle);

                // display client toggle state
                if (toggle.getIndex() == 0) {
                    Minecraft.getInstance().ingameGUI.setOverlayMessage("You are now on Toggle #0. This is for default placement mechanics", false);
                } else {
                    Minecraft.getInstance().ingameGUI.setOverlayMessage("You are now on Toggle #" + toggle.getIndex() + ". To return to default placement press \"" + BindManager.getBlockToggleBind().getLocalizedName().toUpperCase() + "\" until you reach 0 again", false);
                }
            });
        }
    }
}
