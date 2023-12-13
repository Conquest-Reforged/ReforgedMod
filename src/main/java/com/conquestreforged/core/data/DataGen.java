package com.conquestreforged.core.data;

import com.conquestreforged.core.asset.lang.VirtualLang;
import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.block.data.BlockDataRegistry;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

    @SubscribeEvent
    public static void generate(GatherDataEvent event) {
        ResourceManager server = new DataResourceManager(PackType.SERVER_DATA, event.getExistingFileHelper());
        ResourceManager client = new DataResourceManager(PackType.CLIENT_RESOURCES, event.getExistingFileHelper());

        BlockDataRegistry.getInstance().getNamespaces().forEach(namespace -> {
            VirtualResourcepack.Builder data = VirtualResourcepack.builder(namespace).type(PackType.SERVER_DATA);
            VirtualResourcepack.Builder resources = VirtualResourcepack.builder(namespace).type(PackType.CLIENT_RESOURCES);

            BlockDataRegistry.getInstance().getData(namespace).forEach(block -> {
                block.addServerResources(data);
                block.addClientResources(resources);
            });

            resources.add(new VirtualLang(namespace));

            event.getGenerator().m_123914_(new DataProviderCR(event.getGenerator(), data.build(server)));
            event.getGenerator().m_123914_(new DataProviderCR(event.getGenerator(), resources.build(client)));
        });
    }
}
