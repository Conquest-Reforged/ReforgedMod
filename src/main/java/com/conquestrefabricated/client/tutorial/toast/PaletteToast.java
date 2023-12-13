package com.conquestrefabricated.client.tutorial.toast;

import com.conquestrefabricated.client.BindManager;
import com.conquestrefabricated.client.tutorial.Tutorials;
import com.conquestrefabricated.core.config.section.ConfigSection;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.toast.ToastManager;

public class PaletteToast extends AbstractToast {

    private static final String line1 = "Press '%s' whilst hovering over";
    private static final String line2 = "a block to see its variants!";

    private final ConfigSection section;

    public PaletteToast(ConfigSection section) {
        super(SUBTITLE, SUBTITLE);
        this.section = section;
    }

    @Override
    public boolean shouldRender(ToastManager gui) {
        return gui.getClient().currentScreen instanceof InventoryScreen && !Tutorials.openPalette;
    }

    @Override
    public Visibility getVisibility() {
        if (Tutorials.openPalette) {
            if (!section.getOrElse("block_palette", false)) {
                section.set("block_palette", true);
                section.save();
            }
            return Visibility.HIDE;
        }
        return Visibility.SHOW;
    }

    @Override
    public String getLine1() {
        return String.format(line1, BindManager.getPaletteBind().getBoundKeyLocalizedText().getString());
    }

    @Override
    public String getLine2() {
        return line2;
    }
}
