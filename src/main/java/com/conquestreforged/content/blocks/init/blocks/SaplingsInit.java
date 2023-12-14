package com.conquestreforged.content.blocks.init.blocks;

import com.conquestreforged.content.blocks.block.trees.Sapling;
import com.conquestreforged.content.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.block.sapling.*;

public class SaplingsInit {

    public static void init() {
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("alder_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("apple_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("aspen_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("cherry_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("downy_willow_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("gorse_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("grape_vine_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("horse_chestnut_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("larch_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("mallorn_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("orange_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("pear_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("pine_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("plum_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("rowan_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("willow_tree_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("oak_sapling")
                .manual()
                .with("tree", new OakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("birch_sapling")
                .manual()
                .with("tree", new BirchSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("spruce_sapling")
                .manual()
                .with("tree", new SpruceSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("jungle_sapling")
                .manual()
                .with("tree", new JungleSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("acacia_sapling")
                .manual()
                .with("tree", new AcaciaSaplingGenerator())
                .register(TypeList.of(Sapling.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("dark_oak_sapling")
                .manual()
                .with("tree", new DarkOakSaplingGenerator())
                .register(TypeList.of(Sapling.class));
    }
}
