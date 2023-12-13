package com.conquestrefabricated.content.blocks.init.blocks;

import com.conquestrefabricated.content.blocks.block.plants.BeanPole;
import com.conquestrefabricated.content.blocks.block.plants.Corn;
import com.conquestrefabricated.content.blocks.block.plants.Crops;
import com.conquestrefabricated.content.blocks.block.vanilla.BeetrootsVanilla;
import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.item.Items;

public class CropsInit {

    public static void init() {
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("hemp")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("tobacco")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("flax")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("barley")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("heirloom_wheat_crops")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("wild_wheat")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("rice")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("corn")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Corn.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("peas")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("common_beans")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("bean_pole")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(BeanPole.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("cabbage")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("turnips")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("wheat")
                .render(RenderLayer.CUTOUT_MIPPED)
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("potatoes")
                .manual()
                .with("seeds", Items.POTATO)
                .with("crop", Items.POTATO)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("carrots")
                .manual()
                .with("seeds", Items.CARROT)
                .with("crop", Items.CARROT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("beetroots")
                .manual()
                .randomTick(true)
                .register(TypeList.of(BeetrootsVanilla.class));
    }
}
