package com.conquestreforged.items.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemClientInit {

    @SubscribeEvent
    public static void setup(FMLClientSetupEvent event) {
        registerModel("conquest:painting", "conquest:painting");
        registerModel("conquest:vanilla_painting", "minecraft:painting");
    }

    private static void registerModel(String item, String model) {
        registerModel(new ResourceLocation(item), model);
    }

    private static void registerModel(ResourceLocation item, String model) {
        registerModel(ForgeRegistries.ITEMS.getValue(item), model);
    }

    private static void registerModel(Item item, String model) {
        ModelResourceLocation modelLocation = new ModelResourceLocation(model, "inventory");
        Minecraft.getInstance().getItemRenderer().getItemModelShaper().register(item, modelLocation);
    }
}
