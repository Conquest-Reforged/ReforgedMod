package com.conquestrefabricated.content.blocks.init.blocks;


import com.conquestrefabricated.content.blocks.block.*;
import com.conquestrefabricated.content.blocks.block.decor.Rail;
import com.conquestrefabricated.content.blocks.block.windows.WindowSmall;
import com.conquestrefabricated.content.blocks.block.windows.WindowSmallHalf;
import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class PlanksInit {

    public static void init(TypeList types, TypeList typesHorizontal, TypeList typesVertical, TypeList typesVerticalCrossFence) {
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("oak_wood_planks", "oak_wood_plank")
                .texture("minecraft:block/oak_planks")
                .parent(Blocks.OAK_PLANKS.getDefaultState())
                .register(TypeList.of(WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("ash_wood_planks", "ash_wood_plank")
                .texture("block/1_basic_refined/3_wood/ash_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("ash_wood_plank_rail")
                .family("ash_wood_planks")
                .register(TypeList.of(Rail.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("narrow_oak_wood_planks", "narrow_oak_wood_plank")
                .texture("block/1_basic_refined/3_wood/oak/narrow_oak_wood_planks")
                .register(TypeList.of(Cube.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, BoardsHorizontal.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class, PlatformHorizontal.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("old_oak_wood_planks", "old_oak_wood_plank")
                .texture("block/1_basic_refined/3_wood/oak/old_oak_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("rustic_spruce_wood_planks", "rustic_spruce_wood_plank")
                .texture("block/1_basic_refined/3_wood/spruce/rustic_spruce_wood_planks")
                .register(TypeList.of(Cube.class, WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, BoardsHorizontal.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Stairs.class, Wall.class, Pillar.class, PlatformHorizontal.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("vertical_narrow_oak_wood_planks", "vertical_narrow_oak_wood_plank")
                .texture("block/1_basic_refined/3_wood/oak/vertical_narrow_oak_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("oak_platform")
                .texture("top", "block/1_basic_refined/3_wood/oak/oak_platform_top")
                .texture("*", "block/1_basic_refined/3_wood/oak/oak_platform")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("staves", "stave")
                .texture("block/1_basic_refined/3_wood/staves")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("spruce_wood_planks", "spruce_wood_plank")
                .texture("minecraft:block/spruce_planks")
                .parent(Blocks.SPRUCE_PLANKS.getDefaultState())
                .register(TypeList.of(WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("spruce_wood_plank_rail")
                .family("spruce_wood_plank_small_window")
                .register(TypeList.of(Rail.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("reinforced_spruce_wood_planks", "reinforced_spruce_wood_plank")
                .texture("block/1_basic_refined/3_wood/spruce/reinforced_spruce_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("spruce_platform")
                .texture("top", "block/1_basic_refined/3_wood/spruce/spruce_platform_top")
                .texture("*", "block/1_basic_refined/3_wood/spruce/spruce_platform")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("spruce_paneling")
                .texture("block/1_basic_refined/3_wood/spruce/spruce_paneling")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("birch_wood_planks", "birch_wood_plank")
                .texture("minecraft:block/birch_planks")
                .parent(Blocks.BIRCH_PLANKS.getDefaultState())
                .register(TypeList.of(WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("light_birch_wood_planks", "light_birch_wood_plank")
                .texture("block/1_basic_refined/3_wood/birch/light_birch_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("pine_wood_planks", "pine_wood_plank")
                .texture("block/1_basic_refined/3_wood/pine_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("wall_of_birch_logs")
                .texture("top", "minecraft:block/birch_planks")
                .texture("bottom", "minecraft:block/birch_planks")
                .texture("*", "block/1_basic_refined/3_wood/birch/wall_of_birch_logs")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("wall_of_spruce_logs")
                .texture("block/1_basic_refined/3_wood/spruce/wall_of_spruce_logs")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("wall_of_oak_logs")
                .texture("top", "block/1_basic_refined/3_wood/oak/wall_of_oak_logs_topbottom")
                .texture("bottom", "block/1_basic_refined/3_wood/oak/wall_of_oak_logs_topbottom")
                .texture("*", "block/1_basic_refined/3_wood/oak/wall_of_oak_logs")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("wall_of_old_spruce_logs")
                .texture("top", "block/1_basic_refined/3_wood/spruce/wall_of_old_spruce_logs_topbottom")
                .texture("bottom", "block/1_basic_refined/3_wood/spruce/wall_of_old_spruce_logs_topbottom")
                .texture("*", "block/1_basic_refined/3_wood/spruce/wall_of_old_spruce_logs")
                .register(types);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("rough_palm_wood_planks", "rough_palm_wood_plank")
                .texture("minecraft:block/jungle_planks")
                .parent(Blocks.JUNGLE_PLANKS.getDefaultState())
                .register(TypeList.of(WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("vertical_alder_wood_planks", "vertical_alder_wood_plank")
                .texture("block/1_basic_refined/3_wood/vertical_alder_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("acacia_wood_planks", "acacia_wood_plank")
                .texture("top", "minecraft:block/acacia_planks_top")
                .texture("*", "minecraft:block/acacia_planks")
                .parent(Blocks.ACACIA_PLANKS.getDefaultState())
                .register(TypeList.of(WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, FenceCross.class, Wall.class, Pillar.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("red_acacia_wood_planks", "red_acacia_wood_plank")
                .texture("top", "block/1_basic_refined/3_wood/red_acacia_wood_planks_top")
                .texture("*", "block/1_basic_refined/3_wood/red_acacia_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("dark_oak_wood_planks", "dark_oak_wood_plank")
                .texture("minecraft:block/dark_oak_planks")
                .parent(Blocks.DARK_OAK_PLANKS.getDefaultState())
                .register(TypeList.of(WindowSmall.class, WindowSmallHalf.class, Balustrade.class, Capital.class, Sphere.class, SlabLessLayers.class, SlabQuarter.class, SlabCorner.class, SlabEighth.class, VerticalSlabCorner.class, VerticalSlab.class, VerticalCorner.class, VerticalQuarter.class, Wall.class, Pillar.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("apple_wood_planks", "apple_wood_plank")
                .texture("block/1_basic_refined/3_wood/apple_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("alder_wood_planks", "alder_wood_plank")
                .texture("block/1_basic_refined/3_wood/alder_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("aspen_wood_planks", "aspen_wood_plank")
                .texture("block/1_basic_refined/3_wood/aspen_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("beech_wood_planks", "beech_wood_plank")
                .texture("block/1_basic_refined/3_wood/beech_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("goat_sallow_wood_planks", "goat_sallow_wood_plank")
                .texture("block/1_basic_refined/3_wood/goat_sallow_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("goat_sallow_wood_plank_rail")
                .family("goat_sallow_wood_planks")
                .register(TypeList.of(Rail.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("horse_chestnut_wood_planks", "horse_chestnut_wood_plank")
                .texture("block/1_basic_refined/3_wood/horse_chestnut_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("larch_wood_planks", "larch_wood_plank")
                .texture("block/1_basic_refined/3_wood/larch_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("mallorn_wood_planks", "mallorn_wood_plank")
                .texture("block/1_basic_refined/3_wood/mallorn_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("norway_spruce_wood_planks", "norway_spruce_wood_plank")
                .texture("block/1_basic_refined/3_wood/norway_spruce_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("rowan_wood_planks", "rowan_wood_plank")
                .texture("block/1_basic_refined/3_wood/rowan_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("willow_wood_planks", "willow_wood_plank")
                .texture("block/1_basic_refined/3_wood/willow_wood_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("willow_wood_plank_rail")
                .family("willow_wood_planks")
                .register(TypeList.of(Rail.class));
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("barnacle_covered_palm_wood_planks", "barnacle_covered_palm_wood_plank")
                .texture("block/1_basic_refined/3_wood/barnacle_covered_palm_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.PLANKS_AND_BEAMS)
                .name("mossy_palm_wood_planks", "mossy_palm_wood_plank")
                .texture("block/1_basic_refined/3_wood/mossy_palm_wood_planks")
                .register(typesVertical);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_red_painted_planks", "weathered_red_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_red_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("red_painted_planks", "red_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/red_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_light_red_painted_planks", "weathered_light_red_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_light_red_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("light_red_painted_planks", "light_red_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/light_red_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_orange_painted_planks", "weathered_orange_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_orange_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("orange_painted_planks", "orange_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/orange_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_yellow_painted_planks", "weathered_yellow_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_yellow_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("yellow_painted_planks", "yellow_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/yellow_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_green_painted_planks", "weathered_green_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_green_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("green_painted_planks", "green_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/green_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_light_green_painted_planks", "weathered_light_green_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_light_green_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("light_green_painted_planks", "light_green_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/light_green_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_cyan_painted_planks", "weathered_cyan_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_cyan_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("cyan_painted_planks", "cyan_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/cyan_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_dark_blue_painted_planks", "weathered_dark_blue_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_dark_blue_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("dark_blue_painted_planks", "dark_blue_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/dark_blue_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_blue_painted_planks", "weathered_blue_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_blue_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("blue_painted_planks", "blue_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/blue_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_light_blue_painted_planks", "weathered_light_blue_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_light_blue_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("light_blue_painted_planks", "light_blue_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/light_blue_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_purple_painted_planks", "weathered_purple_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_purple_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("purple_painted_planks", "purple_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/purple_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_brown_painted_planks", "weathered_brown_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_brown_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("brown_painted_planks", "brown_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/brown_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("weathered_white_painted_planks", "weathered_white_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/weathered_white_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("white_painted_planks", "white_painted_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/white_painted_planks")
                .register(typesVerticalCrossFence);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("white_painted_horizontal_planks", "white_painted_horizontal_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/white_painted_horizontal_planks")
                .register(typesHorizontal);
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("gray_painted_horizontal_planks", "gray_painted_horizontal_plank")
                .texture("block/2_advanced_refined/7_wood/1_painted/gray_painted_horizontal_planks")
                .register(typesHorizontal);

    }
}
