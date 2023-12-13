package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.block.plants.BeanPole;
import com.conquestreforged.blocks.block.plants.Corn;
import com.conquestreforged.blocks.block.plants.Crops;
import com.conquestreforged.blocks.block.vanilla.BeetrootsVanilla;
import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.item.Items;

public class CropsInit {

    public static void init() {
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("hemp")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("tobacco")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("flax")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("barley")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("heirloom_wheat_crops")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("wild_wheat")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("rice")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("corn")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Corn.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("peas")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("common_beans")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("bean_pole")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(BeanPole.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("cabbage")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("turnips")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .name("wheat")
                .manual()
                .with("seeds", Items.WHEAT_SEEDS)
                .with("crop", Items.WHEAT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .render(RenderLayer.CUTOUT)
                .name("potatoes")
                .manual()
                .with("seeds", Items.POTATO)
                .with("crop", Items.POTATO)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .render(RenderLayer.CUTOUT)
                .name("carrots")
                .manual()
                .with("seeds", Items.CARROT)
                .with("crop", Items.CARROT)
                .randomTick(true)
                .register(TypeList.of(Crops.class));
        VanillaProps.plants()
                .group(ModGroups.CROPS)
                .render(RenderLayer.CUTOUT)
                .name("beetroots")
                .manual()
                .randomTick(true)
                .register(TypeList.of(BeetrootsVanilla.class));
    }
}
