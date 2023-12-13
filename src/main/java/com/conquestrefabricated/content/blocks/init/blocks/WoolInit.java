package com.conquestrefabricated.content.blocks.init.blocks;

import com.conquestrefabricated.content.blocks.group.ModGroups;
import com.conquestrefabricated.core.block.builder.VanillaProps;
import com.conquestrefabricated.core.block.factory.TypeList;
import net.minecraft.block.Blocks;

public class WoolInit {

    public static void init(TypeList types) {
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("white_wool")
                .texture("minecraft:block/white_wool")
                .parent(Blocks.WHITE_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("orange_wool")
                .texture("minecraft:block/orange_wool")
                .parent(Blocks.ORANGE_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("magenta_wool")
                .texture("minecraft:block/magenta_wool")
                .parent(Blocks.MAGENTA_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("light_blue_wool")
                .texture("minecraft:block/light_blue_wool")
                .parent(Blocks.LIGHT_BLUE_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("yellow_wool")
                .texture("minecraft:block/yellow_wool")
                .parent(Blocks.YELLOW_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("lime_wool")
                .texture("minecraft:block/lime_wool")
                .parent(Blocks.LIME_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("pink_wool")
                .texture("minecraft:block/pink_wool")
                .parent(Blocks.PINK_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("gray_wool")
                .texture("minecraft:block/gray_wool")
                .parent(Blocks.GRAY_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("light_gray_wool")
                .texture("minecraft:block/light_gray_wool")
                .parent(Blocks.LIGHT_GRAY_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("cyan_wool")
                .texture("minecraft:block/cyan_wool")
                .parent(Blocks.CYAN_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("purple_wool")
                .texture("minecraft:block/purple_wool")
                .parent(Blocks.PURPLE_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("blue_wool")
                .texture("minecraft:block/blue_wool")
                .parent(Blocks.BLUE_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("brown_wool")
                .texture("minecraft:block/brown_wool")
                .parent(Blocks.BROWN_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("green_wool")
                .texture("minecraft:block/green_wool")
                .parent(Blocks.GREEN_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("red_wool")
                .texture("minecraft:block/red_wool")
                .parent(Blocks.RED_WOOL.getDefaultState())
                .register(types);
        VanillaProps.cloth()
                .group(ModGroups.CLOTH_AND_FIBERS)
                .name("black_wool")
                .texture("minecraft:block/black_wool")
                .parent(Blocks.BLACK_WOOL.getDefaultState())
                .register(types);
    }
}
