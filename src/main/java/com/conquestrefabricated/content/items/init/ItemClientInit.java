package com.conquestrefabricated.content.items.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class ItemClientInit {


    public static void setup(MinecraftClient client) {
        registerModel("conquest:painting", "conquest:painting", client);
        registerModel("conquest:vanilla_painting", "minecraft:painting", client);
    }

    private static void registerModel(String item, String model, MinecraftClient client) {
        registerModel(new Identifier(item), model, client);
    }

    private static void registerModel(Identifier item, String model, MinecraftClient client) {
        registerModel(Registry.ITEM.get(item), model,client);
    }

    private static void registerModel(Item item, String model, MinecraftClient client) {
        ModelIdentifier modelLocation = new ModelIdentifier(model, "inventory");
        client.getItemRenderer().getModels().putModel(item, modelLocation);
    }
}
