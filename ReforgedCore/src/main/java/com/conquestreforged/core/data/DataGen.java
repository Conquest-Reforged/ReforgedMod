package com.conquestreforged.core.data;

import com.conquestreforged.core.asset.lang.VirtualLang;
import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.ResourcePackType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

    @SubscribeEvent
    public static void generate(GatherDataEvent event) {
        IResourceManager server = new DataResourceManager(ResourcePackType.SERVER_DATA, event.getExistingFileHelper());
        IResourceManager client = new DataResourceManager(ResourcePackType.CLIENT_RESOURCES, event.getExistingFileHelper());

        BlockDataRegistry.getInstance().getNamespaces().forEach(namespace -> {
            VirtualResourcepack.Builder data = VirtualResourcepack.builder(namespace).type(ResourcePackType.SERVER_DATA);
            VirtualResourcepack.Builder resources = VirtualResourcepack.builder(namespace).type(ResourcePackType.CLIENT_RESOURCES);

            BlockDataRegistry.getInstance().getData(namespace).forEach(block -> {
                block.addServerResources(data);
                block.addClientResources(resources);
            });

            resources.add(new VirtualLang(namespace));

            event.getGenerator().addProvider(new DataProvider(event.getGenerator(), data.build(server)));
            event.getGenerator().addProvider(new DataProvider(event.getGenerator(), resources.build(client)));
        });
    }
}
