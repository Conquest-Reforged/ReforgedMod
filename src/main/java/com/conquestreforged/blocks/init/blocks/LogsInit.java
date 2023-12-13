package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.block.Pillar;
import com.conquestreforged.blocks.block.VerticalCorner;
import com.conquestreforged.blocks.block.VerticalQuarter;
import com.conquestreforged.blocks.block.VerticalSlab;
import com.conquestreforged.blocks.block.trees.Bark;
import com.conquestreforged.blocks.block.trees.Log;
import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.world.level.block.Blocks;

public class LogsInit {

    public static void init(TypeList types, TypeList typesVanilla) {
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("apple_log")
                .texture("end", "block/9_organic/1_wood/apple_log_top")
                .texture("*", "block/9_organic/1_wood/apple_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_apple_log")
                .texture("end", "block/9_organic/1_wood/mossy_apple_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_apple_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("ash_log")
                .texture("end", "block/9_organic/1_wood/ash_log_top")
                .texture("*", "block/9_organic/1_wood/ash_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_ash_log")
                .texture("end", "block/9_organic/1_wood/mossy_ash_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_ash_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("oak_log")
                .texture("end", "minecraft:block/oak_log_top")
                .texture("*", "minecraft:block/oak_log")
                .parent(Blocks.OAK_LOG.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_oak_log")
                .texture("end", "block/9_organic/1_wood/mossy_oak_log_topbottom")
                .texture("*", "block/9_organic/1_wood/mossy_oak_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("ivy_covered_oak_log")
                .texture("end", "minecraft:block/oak_log_top")
                .texture("*", "block/9_organic/1_wood/ivy_covered_oak_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("dark_spruce_log")
                .texture("end", "minecraft:block/spruce_log_top")
                .texture("*", "minecraft:block/spruce_log")
                .parent(Blocks.SPRUCE_LOG.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_dark_spruce_log")
                .texture("end", "block/9_organic/1_wood/mossy_dark_spruce_log_topbottom")
                .texture("*", "block/9_organic/1_wood/mossy_dark_spruce_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("norway_spruce_log")
                .texture("end", "block/9_organic/1_wood/norway_spruce_log_top")
                .texture("*", "block/9_organic/1_wood/norway_spruce_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_norway_spruce_log")
                .texture("end", "block/9_organic/1_wood/mossy_norway_spruce_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_norway_spruce_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("pine_log")
                .texture("end", "block/9_organic/1_wood/pine_log_top")
                .texture("*", "block/9_organic/1_wood/pine_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_pine_log")
                .texture("end", "block/9_organic/1_wood/mossy_dark_spruce_log_topbottom")
                .texture("*", "block/9_organic/1_wood/mossy_pine_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("transition_pine_log")
                .texture("end", "block/9_organic/1_wood/pine_log_top")
                .texture("*", "block/9_organic/1_wood/transition_pine_log")
                .register(TypeList.of(Log.class, Bark.class, Pillar.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_transition_pine_log")
                .texture("end", "block/9_organic/1_wood/mossy_dark_spruce_log_topbottom")
                .texture("*", "block/9_organic/1_wood/mossy_transition_pine_log")
                .register(TypeList.of(Log.class, Bark.class, Pillar.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class));
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("orange_pine_log")
                .texture("end", "block/9_organic/1_wood/pine_log_top")
                .texture("*", "block/9_organic/1_wood/orange_pine_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_orange_pine_log")
                .texture("end", "block/9_organic/1_wood/mossy_dark_spruce_log_topbottom")
                .texture("*", "block/9_organic/1_wood/mossy_orange_pine_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("birch_log")
                .texture("end", "minecraft:block/birch_log_top")
                .texture("*", "minecraft:block/birch_log")
                .parent(Blocks.BIRCH_LOG.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_birch_log")
                .texture("end", "block/9_organic/1_wood/mossy_birch_log_topbottom")
                .texture("*", "block/9_organic/1_wood/mossy_birch_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("aspen_log")
                .texture("end", "block/9_organic/1_wood/aspen_log_top")
                .texture("*", "block/9_organic/1_wood/aspen_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_aspen_log")
                .texture("end", "block/9_organic/1_wood/mossy_aspen_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_aspen_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("palm_log")
                .texture("end", "minecraft:block/jungle_log_top")
                .texture("*", "minecraft:block/jungle_log")
                .parent(Blocks.JUNGLE_LOG.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_palm_log")
                .texture("end", "block/9_organic/1_wood/mossy_palm_log_topbottom")
                .texture("*", "block/9_organic/1_wood/mossy_palm_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("goat_sallow_log")
                .texture("end", "block/9_organic/1_wood/goat_sallow_log_top")
                .texture("*", "block/9_organic/1_wood/goat_sallow_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_goat_sallow_log")
                .texture("end", "block/9_organic/1_wood/mossy_goat_sallow_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_goat_sallow_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("acacia_log")
                .texture("end", "minecraft:block/acacia_log_top")
                .texture("*", "minecraft:block/acacia_log")
                .parent(Blocks.ACACIA_LOG.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_acacia_log")
                .texture("end", "block/9_organic/1_wood/mossy_acacia_log_topbottom")
                .texture("*", "block/9_organic/1_wood/mossy_acacia_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("dark_oak_log")
                .texture("end", "minecraft:block/dark_oak_log_top")
                .texture("*", "minecraft:block/dark_oak_log")
                .parent(Blocks.DARK_OAK_LOG.defaultBlockState())
                .register(typesVanilla);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_dark_oak_log")
                .texture("end", "block/9_organic/1_wood/mossy_dark_oak_log_topbottom")
                .texture("*", "block/9_organic/1_wood/mossy_dark_oak_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("beech_log")
                .texture("end", "block/9_organic/1_wood/beech_log_top")
                .texture("*", "block/9_organic/1_wood/beech_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_beech_log")
                .texture("end", "block/9_organic/1_wood/mossy_beech_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_beech_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("burnt_log")
                .texture("end", "block/9_organic/1_wood/burnt_log_top")
                .texture("*", "block/9_organic/1_wood/burnt_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("horse_chestnut_log")
                .texture("end", "block/9_organic/1_wood/horse_chestnut_log_top")
                .texture("*", "block/9_organic/1_wood/horse_chestnut_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_horse_chestnut_log")
                .texture("end", "block/9_organic/1_wood/mossy_horse_chestnut_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_horse_chestnut_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mallorn_log")
                .texture("end", "block/9_organic/1_wood/mallorn_log_top")
                .texture("*", "block/9_organic/1_wood/mallorn_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_mallorn_log")
                .texture("end", "block/9_organic/1_wood/mossy_mallorn_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_mallorn_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("larch_log")
                .texture("end", "block/9_organic/1_wood/larch_log_top")
                .texture("*", "block/9_organic/1_wood/larch_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_larch_log")
                .texture("end", "block/9_organic/1_wood/mossy_larch_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_larch_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("rowan_log")
                .texture("end", "block/9_organic/1_wood/rowan_log_top")
                .texture("*", "block/9_organic/1_wood/rowan_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_rowan_log")
                .texture("end", "block/9_organic/1_wood/mossy_rowan_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_rowan_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("willow_log")
                .texture("end", "block/9_organic/1_wood/willow_log_top")
                .texture("*", "block/9_organic/1_wood/willow_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_willow_log")
                .texture("end", "block/9_organic/1_wood/mossy_willow_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_willow_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("olive_log")
                .texture("end", "block/9_organic/1_wood/olive_log_top")
                .texture("*", "block/9_organic/1_wood/olive_log")
                .register(types);
        VanillaProps.logs()
                .group(ModGroups.LOGS)
                .name("mossy_olive_log")
                .texture("end", "block/9_organic/1_wood/mossy_olive_log_top")
                .texture("*", "block/9_organic/1_wood/mossy_olive_log")
                .register(types);


    }
}
