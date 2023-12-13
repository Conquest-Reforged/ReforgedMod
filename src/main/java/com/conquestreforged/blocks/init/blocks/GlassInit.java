package com.conquestreforged.blocks.init.blocks;

import com.conquestreforged.blocks.block.glass.*;
import com.conquestreforged.blocks.block.tracery.GlassTracery;
import com.conquestreforged.blocks.block.tracery.VerticalCornerTracery;
import com.conquestreforged.blocks.block.tracery.VerticalQuarterTracery;
import com.conquestreforged.blocks.block.tracery.VerticalSlabTracery;
import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.core.block.builder.VanillaProps;
import com.conquestreforged.core.block.factory.TypeList;
import net.minecraft.world.level.block.Blocks;

public class GlassInit {

    public static void init() {
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("tree_decorated_window")
                .texture("middle", "block/2_advanced_refined/6_glass/tree_decorated_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/tree_decorated_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("arabian_arched_window")
                .texture("middle", "block/2_advanced_refined/6_glass/arabian_arched_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/arabian_arched_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("white_stained_glass")
                .texture("minecraft:block/white_stained_glass")
                .parent(Blocks.WHITE_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("orange_stained_glass")
                .texture("minecraft:block/orange_stained_glass")
                .parent(Blocks.ORANGE_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("magenta_stained_glass")
                .texture("minecraft:block/magenta_stained_glass")
                .parent(Blocks.MAGENTA_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("light_blue_stained_glass")
                .texture("minecraft:block/light_blue_stained_glass")
                .parent(Blocks.LIGHT_BLUE_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("yellow_stained_glass")
                .texture("minecraft:block/yellow_stained_glass")
                .parent(Blocks.YELLOW_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("lime_stained_glass")
                .texture("minecraft:block/lime_stained_glass")
                .parent(Blocks.LIME_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("pink_stained_glass")
                .texture("minecraft:block/pink_stained_glass")
                .parent(Blocks.PINK_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("gray_stained_glass")
                .texture("minecraft:block/gray_stained_glass")
                .parent(Blocks.GRAY_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("light_gray_stained_glass")
                .texture("minecraft:block/light_gray_stained_glass")
                .parent(Blocks.LIGHT_GRAY_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("cyan_stained_glass")
                .texture("minecraft:block/cyan_stained_glass")
                .parent(Blocks.CYAN_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("purple_stained_glass")
                .texture("minecraft:block/purple_stained_glass")
                .parent(Blocks.PURPLE_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("blue_stained_glass")
                .texture("minecraft:block/blue_stained_glass")
                .parent(Blocks.BLUE_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("brown_stained_glass")
                .texture("minecraft:block/brown_stained_glass")
                .parent(Blocks.BROWN_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("green_stained_glass")
                .texture("minecraft:block/green_stained_glass")
                .parent(Blocks.GREEN_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("red_stained_glass")
                .texture("minecraft:block/red_stained_glass")
                .parent(Blocks.RED_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("black_stained_glass")
                .texture("minecraft:block/black_stained_glass")
                .parent(Blocks.BLACK_STAINED_GLASS.defaultBlockState())
                .register(TypeList.of(PaneTranslucent.class, SlabTranslucent.class, StairsTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("circular_glass_1")
                .texture("middle", "minecraft:block/glass_middle")
                .texture("*","minecraft:block/glass")
                .parent(Blocks.GLASS.defaultBlockState())
                .register(TypeList.of(Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("circular_glass_2")
                .texture("middle", "minecraft:block/glass_middle")
                .texture("*","minecraft:block/glass")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class,  VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("straight_glass_1")
                .texture("middle", "block/2_advanced_refined/6_glass/straight_glass_middle")
                .texture("*","block/2_advanced_refined/6_glass/straight_glass")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("straight_glass_2")
                .texture("middle", "block/2_advanced_refined/6_glass/straight_glass_middle")
                .texture("*","block/2_advanced_refined/6_glass/straight_glass")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("fancy_dragon_border_glass")
                .texture("middle", "block/2_advanced_refined/6_glass/fancy_dragon_border_glass_middle")
                .texture("*","block/2_advanced_refined/6_glass/fancy_dragon_border_glass")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("fancy_sharp_arch_glass")
                .texture("middle", "block/2_advanced_refined/6_glass/fancy_sharp_arch_glass_middle")
                .texture("*","block/2_advanced_refined/6_glass/fancy_sharp_arch_glass")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("simple_brown_wooden_frame_window")
                .texture("block/2_advanced_refined/6_glass/simple_brown_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("elongated_brown_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/elongated_brown_wooden_frame_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/elongated_brown_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("arched_brown_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/arched_brown_wooden_frame_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/arched_brown_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("round_brown_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/round_brown_wooden_frame_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/round_brown_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("simple_yellow_wooden_frame_window")
                .texture("block/2_advanced_refined/6_glass/simple_yellow_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("elongated_yellow_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/elongated_yellow_wooden_frame_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/elongated_yellow_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("arched_yellow_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/arched_yellow_wooden_frame_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/arched_yellow_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("round_yellow_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/round_yellow_wooden_frame_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/round_yellow_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("simple_green_wooden_frame_window")
                .texture("block/2_advanced_refined/6_glass/simple_green_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("elongated_green_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/elongated_green_wooden_frame_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/elongated_green_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("arched_green_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/arched_green_wooden_frame_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/arched_green_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("round_green_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/round_green_wooden_frame_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/round_green_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("simple_white_wooden_frame_window")
                .texture("block/2_advanced_refined/6_glass/simple_white_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("elongated_white_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/elongated_white_wooden_frame_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/elongated_white_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("arched_white_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/arched_white_wooden_frame_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/arched_white_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("round_white_wooden_frame_window")
                .texture("middle", "block/2_advanced_refined/6_glass/round_white_wooden_frame_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/round_white_wooden_frame_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("asian_window")
                .texture("middle", "block/2_advanced_refined/6_glass/asian_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/asian_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("red_asian_window")
                .texture("middle", "block/2_advanced_refined/6_glass/red_asian_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/red_asian_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.planks()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("shoji")
                .texture("block/2_advanced_refined/7_wood/shoji")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.planks()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("damaged_shoji")
                .texture("block/2_advanced_refined/7_wood/damaged_shoji")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.planks()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("vertical_shoji")
                .texture("block/2_advanced_refined/7_wood/vertical_shoji")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.planks()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("vertical_damaged_shoji")
                .texture("block/2_advanced_refined/7_wood/vertical_damaged_shoji")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("small_diamond_pattern_glass_window")
                .texture("middle", "block/2_advanced_refined/6_glass/small_diamond_pattern_glass_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/small_diamond_pattern_glass_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("diagonal_square_pattern_glass_window")
                .texture("middle", "block/2_advanced_refined/6_glass/diagonal_square_pattern_glass_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/diagonal_square_pattern_glass_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("simple_square_pattern_glass_window")
                .texture("middle", "block/2_advanced_refined/6_glass/simple_square_pattern_glass_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/simple_square_pattern_glass_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("white_plaster_with_circular_window")
                .texture("block/2_advanced_refined/6_glass/white_plaster_with_circular_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("white_plaster_with_reinforced_circular_window")
                .texture("block/2_advanced_refined/6_glass/white_plaster_with_reinforced_circular_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("yellow_plaster_with_circular_window")
                .texture("block/2_advanced_refined/6_glass/yellow_plaster_with_circular_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("yellow_plaster_with_reinforced_circular_window")
                .texture("block/2_advanced_refined/6_glass/yellow_plaster_with_reinforced_circular_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("limestone_gothic_window")
                .texture("middle", "block/2_advanced_refined/6_glass/limestone_gothic_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/limestone_gothic_window")
                .register(TypeList.of(GlassTracery.class, Pane.class, VerticalSlabTracery.class, VerticalCornerTracery.class, VerticalQuarterTracery.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("light_limestone_gothic_window")
                .texture("middle", "block/2_advanced_refined/6_glass/light_limestone_gothic_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/light_limestone_gothic_window")
                .register(TypeList.of(GlassTracery.class, Pane.class, VerticalSlabTracery.class, VerticalCornerTracery.class, VerticalQuarterTracery.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("sandstone_gothic_window")
                .texture("middle", "block/2_advanced_refined/6_glass/sandstone_gothic_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/sandstone_gothic_window")
                .register(TypeList.of(GlassTracery.class, Pane.class, VerticalSlabTracery.class, VerticalCornerTracery.class, VerticalQuarterTracery.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("tan_sandstone_gothic_window")
                .texture("middle", "block/2_advanced_refined/6_glass/tan_sandstone_gothic_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/tan_sandstone_gothic_window")
                .register(TypeList.of(GlassTracery.class, Pane.class, VerticalSlabTracery.class, VerticalCornerTracery.class, VerticalQuarterTracery.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("granite_art_noveau_window")
                .texture("middle", "block/2_advanced_refined/6_glass/granite_art_noveau_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/granite_art_noveau_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("simple_arch_window")
                .texture("middle", "block/2_advanced_refined/6_glass/simple_arch_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/simple_arch_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("white_roundel_leaded_glass")
                .texture("*", "block/2_advanced_refined/6_glass/white_roundel_leaded_glass")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("stained_glass_gothic_window")
                .texture("middle","block/2_advanced_refined/6_glass/stained_glass_gothic_window_middle")
                .texture("*","block/2_advanced_refined/6_glass/stained_glass_gothic_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("lattice_window_panel")
                .texture("middle", "block/2_advanced_refined/6_glass/lattice_window_panel_middle")
                .texture("*", "block/2_advanced_refined/6_glass/lattice_window_panel")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("lattice_window_panel_1")
                .texture("block/2_advanced_refined/6_glass/lattice_window_panel_1")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.wood()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("wooden_arch_window")
                .texture("top", "block/2_advanced_refined/6_glass/wooden_window_frame_top")
                .texture("bottom", "block/2_advanced_refined/6_glass/wooden_window_frame_top")
                .texture("middle", "block/2_advanced_refined/6_glass/wooden_arch_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/wooden_arch_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.wood()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("wooden_gothic_window")
                .texture("top", "block/2_advanced_refined/6_glass/wooden_window_frame_top")
                .texture("bottom", "block/2_advanced_refined/6_glass/wooden_window_frame_top")
                .texture("middle", "block/2_advanced_refined/6_glass/wooden_gothic_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/wooden_gothic_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.wood()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("wooden_mullion_window")
                .texture("top", "block/2_advanced_refined/6_glass/wooden_window_frame_top")
                .texture("bottom", "block/2_advanced_refined/6_glass/wooden_window_frame_top")
                .texture("middle", "block/2_advanced_refined/6_glass/wooden_mullion_window_middle")
                .texture("*", "block/2_advanced_refined/6_glass/wooden_mullion_window")
                .register(TypeList.of(Glass.class, Pane.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("leaded_glass_window")
                .texture("*", "block/2_advanced_refined/6_glass/leaded_glass_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("gothic_sliding_window")
                .texture("*", "block/2_advanced_refined/6_glass/gothic_sliding_window")
                .register(TypeList.of(GlassTranslucent.class, PaneTranslucent.class, VerticalSlabTranslucent.class, VerticalCornerTranslucent.class, VerticalQuarterTranslucent.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("light_limestone_lattice_window")
                .texture("middle", "block/2_advanced_refined/6_glass/light_limestone_lattice_window")
                .texture("*","block/2_advanced_refined/6_glass/light_limestone_lattice_window")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("light_limestone_sun_lattice_window")
                .texture("middle", "block/2_advanced_refined/6_glass/light_limestone_sun_lattice_window")
                .texture("*","block/2_advanced_refined/6_glass/light_limestone_sun_lattice_window")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("limestone_lattice_window")
                .texture("middle", "block/2_advanced_refined/6_glass/limestone_lattice_window")
                .texture("*","block/2_advanced_refined/6_glass/limestone_lattice_window")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("limestone_sun_lattice_window")
                .texture("middle", "block/2_advanced_refined/6_glass/limestone_sun_lattice_window")
                .texture("*","block/2_advanced_refined/6_glass/limestone_sun_lattice_window")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));
        VanillaProps.glass()
                .group(ModGroups.WINDOWS_AND_GLASS)
                .name("square_byzantine_lattice_window")
                .texture("middle", "block/2_advanced_refined/6_glass/square_byzantine_lattice_window")
                .texture("*","block/2_advanced_refined/6_glass/square_byzantine_lattice_window")
                .register(TypeList.of(Glass.class, Pane.class, SlabCutout.class, StairsCutout.class, VerticalSlabCutout.class, VerticalCornerCutout.class, VerticalQuarterCutout.class));

    }
}
