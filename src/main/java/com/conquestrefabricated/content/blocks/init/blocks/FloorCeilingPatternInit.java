package com.conquestrefabricated.content.blocks.init.blocks;

import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class FloorCeilingPatternInit {

    public static void init(TypeList types, TypeList typesVanilla) {
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("tan_clay_tiles")
                .texture("block/1_basic_refined/1_stone/1_clay/tan_clay_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("mixed_clay_tiles")
                .texture("block/1_basic_refined/1_stone/1_clay/mixed_clay_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("light_clay_tiles")
                .texture("block/1_basic_refined/1_stone/1_clay/light_clay_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("red_painted_angled_tiles", "red_painted_angled_tile")
                .texture("minecraft:block/magenta_concrete")
                .parent(Blocks.MAGENTA_CONCRETE.getDefaultState())
                .register(typesVanilla);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("circular_carved_limestone_design")
                .texture("block/2_advanced_refined/1_stone/2_limestone/circular_carved_limestone_design")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("gray_angled_tiles")
                .texture("block/2_advanced_refined/1_stone/gray_angled_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("circular_carved_granite_design")
                .texture("block/2_advanced_refined/1_stone/1_granite/circular_carved_granite_design")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("woven_granite_design")
                .texture("top", "block/2_advanced_refined/1_stone/1_granite/woven_granite_design_top")
                .texture("bottom", "block/2_advanced_refined/1_stone/1_granite/woven_granite_design_top")
                .texture("*", "block/2_advanced_refined/1_stone/1_granite/woven_granite_design")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("complex_sandstone_design")
                .texture("block/2_advanced_refined/1_stone/5_sandstone/complex_sandstone_design")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("black_square_marble_pattern")
                .texture("block/2_advanced_refined/1_stone/3_marble/black_square_marble_pattern")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("black_marble_diagonal_checker_pattern")
                .texture("block/2_advanced_refined/1_stone/3_marble/black_marble_diagonal_checker_pattern")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("small_marble_checker_pattern")
                .texture("block/2_advanced_refined/1_stone/3_marble/small_marble_checker_pattern")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("red_square_marble_pattern")
                .texture("block/2_advanced_refined/1_stone/3_marble/red_square_marble_pattern")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("red_square_border_marble_pattern")
                .texture("block/2_advanced_refined/1_stone/3_marble/red_square_border_marble_pattern")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("yellow_diamond_marble_pattern")
                .texture("block/2_advanced_refined/1_stone/3_marble/yellow_diamond_marble_pattern")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("black_diamond_marble_pattern")
                .texture("block/2_advanced_refined/1_stone/3_marble/black_diamond_marble_pattern")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("marble_checker_pattern")
                .texture("block/2_advanced_refined/1_stone/3_marble/marble_checker_pattern")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("meander_bordered_mosaic")
                .texture("block/2_advanced_refined/1_stone/4_painted/meander_bordered_mosaic")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("fancy_oriental_mosaic")
                .texture("block/2_advanced_refined/1_stone/4_painted/fancy_oriental_mosaic")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("andalusian_mosaic")
                .texture("block/2_advanced_refined/1_stone/4_painted/andalusian_mosaic")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("black_and_white_tesserae")
                .texture("block/2_advanced_refined/1_stone/4_painted/black_and_white_tesserae")
                .register(types);
        VanillaProps.mosaic()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("blue_roman_mosaic")
                .texture("block/2_advanced_refined/1_stone/4_painted/blue_roman_mosaic")
                .register(types);
        VanillaProps.mosaic()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("dark_blue_roman_mosaic")
                .texture("block/2_advanced_refined/1_stone/4_painted/dark_blue_roman_mosaic")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("brown_sandstone_comb_pattern")
                .texture("top", "block/2_advanced_refined/1_stone/5_sandstone/brown_sandstone_comb_pattern_top")
                .texture("bottom", "block/2_advanced_refined/1_stone/5_sandstone/brown_sandstone_comb_pattern_top")
                .texture("*", "block/2_advanced_refined/1_stone/5_sandstone/brown_sandstone_comb_pattern")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("gold_blue_arabian_mosaic")
                .texture("block/2_advanced_refined/1_stone/4_painted/gold_blue_arabian_mosaic")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("gothic_sandstone_floor_tiles")
                .texture("block/2_advanced_refined/1_stone/5_sandstone/gothic_sandstone_floor_tiles")
                .register(types);
        VanillaProps.stone()
                .group(ModGroups.MOSAICS_TILES_AND_FLOORS)
                .name("chiseled_polished_blackstone")
                .texture("minecraft:block/chiseled_polished_blackstone")
                .parent(Blocks.CHISELED_POLISHED_BLACKSTONE.getDefaultState())
                .register(typesVanilla);
    }
}
