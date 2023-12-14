package com.conquestreforged.core.data;

import com.conquestreforged.core.asset.lang.VirtualLang;
import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import com.conquestreforged.core.util.log.Log;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraftforge.common.data.ExistingFileHelper;


public class DataGen implements DataGeneratorEntrypoint {

    public static void generate(FabricDataGenerator fabricDataGenerator) {
        ResourceManager server = new DataResourceManager(ResourceType.SERVER_DATA, ExistingFileHelper.standard());
        ResourceManager client = new DataResourceManager(ResourceType.CLIENT_RESOURCES, ExistingFileHelper.standard());

        BlockDataRegistry.getInstance().getNamespaces().forEach(namespace -> {
            Log.info(namespace
            );
            VirtualResourcepack.Builder data = VirtualResourcepack.builder(namespace).type(ResourceType.SERVER_DATA);
            VirtualResourcepack.Builder resources = VirtualResourcepack.builder(namespace).type(ResourceType.CLIENT_RESOURCES);

           

            BlockDataRegistry.getInstance().getData(namespace).forEach(block -> {
                block.addServerResources(data);
                block.addClientResources(resources);
            });

            resources.add(new VirtualLang(namespace));
            fabricDataGenerator.addProvider(new DataProviderCR(fabricDataGenerator, data.build(server)));
            fabricDataGenerator.addProvider(new DataProviderCR(fabricDataGenerator, resources.build(client)));
        });

    }


    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        generate(fabricDataGenerator);
    }
}
