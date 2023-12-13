package com.conquestreforged.items.init;

import com.conquestreforged.api.painting.vanilla.VanillaArt;
import com.conquestreforged.api.painting.vanilla.VanillaPainting;
import com.conquestreforged.core.util.log.Log;
import com.conquestreforged.entities.painting.ModPainting;
import com.conquestreforged.entities.painting.PaintingFactory;
import com.conquestreforged.entities.painting.art.ModArt;
import com.conquestreforged.items.item.PaintingItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemCommonInit {

    @SubscribeEvent
    public static void init(RegistryEvent.Register<Item> event) {
        Log.info("Registering items");
        event.getRegistry().register(new PaintingItem(
                "painting",
                ModPainting::fromName,
                ModArt::fromName,
                PaintingFactory.MOD
        ));

        event.getRegistry().register(new PaintingItem(
                "vanilla_painting",
                VanillaPainting::fromName,
                VanillaArt::fromName,
                PaintingFactory.VANILLA
        ));
    }
}
