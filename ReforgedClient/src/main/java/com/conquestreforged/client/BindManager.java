package com.conquestreforged.client;

import com.conquestreforged.client.bind.PaintingBindListener;
import com.conquestreforged.client.bind.PaletteBindListener;
import com.conquestreforged.client.bind.SearchBindListener;
import com.conquestreforged.core.asset.lang.Translations;
import com.conquestreforged.core.client.input.Bindings;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BindManager {

    private static KeyMapping palette;

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        Log.info("Registering keybinds");
        String category = "key.category.conquest";
        Translations.getInstance().add(category, "Conquest Reforged");
        Bindings.create("Search", "key.keyboard.unknown", category, new SearchBindListener());
        palette = Bindings.create("Palette GUI", "key.keyboard.v", category)
                .addListener(new PaletteBindListener())
                .addListener(new PaintingBindListener());
    }

    public static KeyMapping getPaletteBind() {
        return palette;
    }

}
