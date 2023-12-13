package com.conquestrefabricated.content.items.init;

import com.conquestrefabricated.api.painting.vanilla.VanillaArt;
import com.conquestrefabricated.api.painting.vanilla.VanillaPainting;
import com.conquestrefabricated.content.entities.painting.ModPainting;
import com.conquestrefabricated.content.entities.painting.PaintingFactory;
import com.conquestrefabricated.content.entities.painting.art.ModArt;
import com.conquestrefabricated.content.items.item.PaintingItem;
import com.conquestrefabricated.core.util.log.Log;
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
