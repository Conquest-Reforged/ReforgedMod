package com.conquestrefabricated.content.blocks.init.blocks;

import com.conquestrefabricated.content.blocks.block.Door;
import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import com.conquestrefabricated.core.util.RenderLayer;

public class DoorsInit {

    public static void init() {
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("oak_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("heavy_wooden_door")
                .manual()
                .render(RenderLayer.CUTOUT)
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("fancy_oak_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("elegant_birch_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("elegant_oak_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_red_painted_plank_door")
                .family("weathered_red_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("red_painted_plank_door")
                .family("red_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_light_red_painted_plank_door")
                .family("weathered_light_red_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("light_red_painted_plank_door")
                .family("light_red_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_orange_painted_plank_door")
                .family("weathered_orange_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("orange_painted_plank_door")
                .family("orange_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_yellow_painted_plank_door")
                .family("weathered_yellow_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("yellow_painted_plank_door")
                .family("yellow_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_green_painted_plank_door")
                .family("weathered_green_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("green_painted_plank_door")
                .family("green_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_light_green_painted_plank_door")
                .family("weathered_light_green_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("light_green_painted_plank_door")
                .family("light_green_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_cyan_painted_plank_door")
                .family("weathered_cyan_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("cyan_painted_plank_door")
                .family("cyan_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_dark_blue_painted_plank_door")
                .family("weathered_dark_blue_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("dark_blue_painted_plank_door")
                .family("dark_blue_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_blue_painted_plank_door")
                .family("weathered_blue_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_light_blue_painted_plank_door")
                .family("weathered_light_blue_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("light_blue_painted_plank_door")
                .family("light_blue_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("blue_painted_plank_door")
                .family("blue_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_purple_painted_plank_door")
                .family("weathered_purple_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("purple_painted_plank_door")
                .family("purple_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_brown_painted_plank_door")
                .family("weathered_brown_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("brown_painted_plank_door")
                .family("brown_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("weathered_white_painted_plank_door")
                .family("weathered_white_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("white_painted_plank_door")
                .family("white_painted_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("white_painted_horizontal_plank_door")
                .family("white_painted_horizontal_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                //.group(ModGroups.PLASTER_STUCCO_AND_PAINT)
                .name("gray_painted_horizontal_plank_door")
                .family("gray_painted_horizontal_planks")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("baroque_oak_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("tall_baroque_oak_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("tall_baroque_windowed_oak_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("tall_oxidized_bronze_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("green_wooden_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("white_wooden_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("gray_windowed_wooden_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("reinforced_prison_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("prison_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("spiked_iron_gate")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("tall_reinforced_oak_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("reinforced_oak_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("tall_oak_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("office_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.metal()
                .group(ModGroups.METAL)
                .name("blue_office_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("red_studded_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("black_studded_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("tall_gray_wooden_door")
                .manual()
                .register(TypeList.of(Door.class));
        VanillaProps.planks()
                .group(ModGroups.ADVANCED_CARPENTRY)
                .name("tall_old_oak_door")
                .manual()
                .register(TypeList.of(Door.class));
    }
}
