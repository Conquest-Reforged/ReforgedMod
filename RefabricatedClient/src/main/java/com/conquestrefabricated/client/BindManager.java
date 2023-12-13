package com.conquestrefabricated.client;

import com.conquestrefabricated.client.bind.PaintingBindListener;
import com.conquestrefabricated.client.bind.PaletteBindListener;
import com.conquestrefabricated.client.bind.SearchBindListener;
import com.conquestrefabricated.core.asset.lang.Translations;
import com.conquestrefabricated.core.client.input.Bindings;
import com.conquestrefabricated.core.util.log.Log;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.KeyBinding;


@Environment(EnvType.CLIENT)
public class BindManager {

    private static KeyBinding palette;

    public static void init() {
        Log.info("Registering keybinds");
        String category = "key.category.conquest";
        Translations.getInstance().add(category, "Conquest Reforged");
        Bindings.create("Search", "key.keyboard.unknown", category, new SearchBindListener());
        palette = Bindings.create("Palette GUI", "key.keyboard.v", category)
                .addListener(new PaletteBindListener())
                .addListener(new PaintingBindListener());
    }

    public static KeyBinding getPaletteBind() {
        return palette;
    }

}
