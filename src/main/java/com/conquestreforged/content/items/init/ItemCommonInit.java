package com.conquestreforged.content.items.init;

import com.conquestreforged.api.painting.vanilla.VanillaArt;
import com.conquestreforged.api.painting.vanilla.VanillaPainting;
import com.conquestreforged.content.entities.painting.ModPainting;
import com.conquestreforged.content.entities.painting.PaintingFactory;
import com.conquestreforged.content.entities.painting.art.ModArt;
import com.conquestreforged.content.items.item.PaintingItem;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ItemCommonInit {

    ///@SubscribeEvent
    public static void init() {
        Log.info("Registering items");

        PaintingItem painting1 = new PaintingItem(
                "painting",
                ModPainting::fromName,
                ModArt::fromName,
                PaintingFactory.MOD
        );
        Registry.register(Registry.ITEM, new Identifier("conquest", "painting"), painting1);

        PaintingItem painting2 = new PaintingItem(
                "vanilla_painting",
                VanillaPainting::fromName,
                VanillaArt::fromName,
                PaintingFactory.VANILLA
        );
        Registry.register(Registry.ITEM, new Identifier("conquest", "vanilla_painting"), painting2);
    }
}
