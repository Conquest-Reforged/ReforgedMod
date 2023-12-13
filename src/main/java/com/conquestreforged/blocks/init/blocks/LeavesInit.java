package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.SaplingTypes;
import com.conquestreforged.blocks.block.directional.HorizontalDirectional;
import com.conquestreforged.blocks.block.plants.Bush;
import com.conquestreforged.blocks.block.trees.Leaves;
import com.conquestreforged.blocks.block.trees.LeavesFruit;
import com.conquestreforged.blocks.block.trees.LeavesLightToggle;
import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class LeavesInit {

    public static void init() {
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("beech_tree_leaves")
                .manual()
                .foliageColor()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(LeavesLightToggle.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("bright_autumnal_beech_tree_leaves")
                .manual()
                .with("sapling", SaplingTypes.mallorn())
                .register(TypeList.of(LeavesLightToggle.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("faded_autumnal_beech_tree_leaves")
                .manual()
                .with("sapling", SaplingTypes.mallorn())
                .register(TypeList.of(LeavesLightToggle.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("autumnal_beech_tree_leaves")
                .manual()
                .with("sapling", SaplingTypes.mallorn())
                .register(TypeList.of(LeavesLightToggle.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("ash_tree_leaves")
                .manual()
                .foliageColor()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("dead_deciduous_branches")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("dead_pine_needles")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("dead_spruce_needles")
                .manual()
                .with("sapling", Blocks.SPRUCE_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("light_spruce_needles")
                .manual()
                .with("sapling", Blocks.SPRUCE_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("dark_spruce_needles")
                .manual()
                .with("sapling", Blocks.SPRUCE_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("pine_needles")
                .manual()
                .foliageColor()
                .with("sapling", SaplingTypes.pine())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("autumnal_oak_leaves")
                .manual()
                .with("sapling", SaplingTypes.aspen())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("autumnal_birch_leaves")
                .manual()
                .with("sapling", SaplingTypes.aspen())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("autumnal_maple_leaves")
                .manual()
                .with("sapling", SaplingTypes.aspen())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("autumnal_horse_chestnut_leaves")
                .manual()
                .with("sapling", SaplingTypes.aspen())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("diseased_horse_chestnut_leaves")
                .manual()
                .with("sapling", SaplingTypes.aspen())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("aspen_leaves")
                .manual()
                .with("sapling", SaplingTypes.aspen())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("autumnal_aspen_leaves")
                .manual()
                .with("sapling", SaplingTypes.aspen())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("rowan_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("mistletoe_garland")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("gorse_leaves")
                .manual()
                .with("sapling", SaplingTypes.gorse())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("weeping_willow_leaves")
                .manual()
                .with("sapling", SaplingTypes.willow())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("autumnal_weeping_willow_leaves")
                .manual()
                .with("sapling", SaplingTypes.willow())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("bright_autumnal_weeping_willow_leaves")
                .manual()
                .with("sapling", SaplingTypes.willow())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("yellow_autumnal_weeping_willow_leaves")
                .manual()
                .with("sapling", SaplingTypes.willow())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("downy_willow_leaves")
                .manual()
                .with("sapling", SaplingTypes.downyWillow())
                .register(TypeList.of(Leaves.class));
        VanillaProps.plants()
                .group(ModGroups.LEAVES)
                .name("downy_willow_leaves_tip")
                .manual()
                .family("downy_willow_leaves")
                .register(TypeList.of(Bush.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("horse_chestnut_leaves")
                .manual()
                .with("sapling", SaplingTypes.chestNut())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("goat_willow_leaves")
                .manual()
                .with("sapling", SaplingTypes.goatWillow())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("larch_needles")
                .manual()
                .with("sapling", SaplingTypes.larch())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("yellow_autumnal_larch_needles")
                .manual()
                .with("sapling", SaplingTypes.larch())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("orange_autumnal_larch_needles")
                .manual()
                .with("sapling", SaplingTypes.larch())
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("lilac")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("pink_cherry_blossoms")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("white_cherry_blossoms")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("red_cherry_blossoms")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("purple_cherry_blossoms")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("dark_beech_tree_leaves")
                .manual()
                .foliageColor()
                .with("sapling", Items.APPLE)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("apple_tree_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("cherry_tree_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("holly_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("orange_tree_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("pear_tree_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("plum_tree_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("grape_vine_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("lemon_tree_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("olive_tree_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leafLike()
                .group(ModGroups.LEAVES)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("caribbean_royal_palm_leaves")
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.leafLike()
                .group(ModGroups.LEAVES)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("caribbean_royal_palm_leaves_corner")
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.leafLike()
                .group(ModGroups.LEAVES)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("old_caribbean_royal_palm_leaves")
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.leafLike()
                .group(ModGroups.LEAVES)
                .render(RenderLayer.CUTOUT_MIPPED)
                .name("old_caribbean_royal_palm_leaves_corner")
                .manual()
                .with("hitBox", BlockVoxelShapes.cubePartialShape)
                .register(TypeList.of(HorizontalDirectional.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("date_palm_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("banana_tree_leaves")
                .manual()
                .with("fruit", Items.APPLE)
                .randomTick(true)
                .register(TypeList.of(LeavesFruit.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("wisteria_leaves")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("wisteria_blossoms")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("joshua_tree_leaves")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("bushy_joshua_tree_leaves")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
        VanillaProps.leaves()
                .group(ModGroups.LEAVES)
                .name("dark_deciduous_leaves")
                .manual()
                .with("sapling", Blocks.OAK_SAPLING)
                .register(TypeList.of(Leaves.class));
    }
}
