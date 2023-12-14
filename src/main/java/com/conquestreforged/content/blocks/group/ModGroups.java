package com.conquestreforged.content.blocks.group;

import com.conquestreforged.core.item.family.FamilyGroup;
import com.conquestreforged.core.item.group.ConquestItemGroup;
import com.conquestreforged.core.item.group.manager.ItemGroupManager;
import com.conquestreforged.core.util.Provider;
import net.fabricmc.fabric.impl.item.group.ItemGroupExtensions;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModGroups {

    public static int originalGroupsLength = ItemGroup.GROUPS.length;

    //Page 1 (9 tabs)
    public static final ConquestItemGroup COBBLE_AND_BRICK = createFamilyGroup(0, "cobble_and_brick", block("conquest:lime_mortar_masonry"));
    public static final ConquestItemGroup ADVANCED_MASONRY_AND_CERAMICS = createFamilyGroup(1, "advanced_masonry", block("conquest:schist_dragon_head"));
    public static final ConquestItemGroup COLUMNS = createFamilyGroup(2, "columns", block("minecraft:chiseled_stone_bricks"));
    public static final ConquestItemGroup MOSAICS_TILES_AND_FLOORS = createFamilyGroup(3, "mosaics_tiles_and_floors", block("conquest:andalusian_mosaic"));
    public static final ConquestItemGroup PLASTER_STUCCO_AND_PAINT = createFamilyGroup(4, "plaster_stucco_and_paint", block("conquest:etruscan_wall_design_1"));
    public static final ConquestItemGroup HALF_TIMBERED_WALLS = createFamilyGroup(5, "half_timbered_walls", block("conquest:tudor_cross_frame"));
    public static final ConquestItemGroup ROOFING = createFamilyGroup(6, "roofing", block("conquest:terracotta_imbrices_and_tegulae"));
    public static final ConquestItemGroup PLANKS_AND_BEAMS = createFamilyGroup(7, "planks_and_beams", block("minecraft:oak_planks"));
    public static final ConquestItemGroup ADVANCED_CARPENTRY = createFamilyGroup(8, "advanced_carpentry", block("conquest:carved_oak_wood"));

    //Page 2 (10 tabs)
    public static final ConquestItemGroup METAL = createFamilyGroup(9, "metal", block("minecraft:iron_block"));
    public static final ConquestItemGroup WINDOWS_AND_GLASS = createFamilyGroup(10, "windows_and_glass", block("minecraft:glass"));
    public static final ConquestItemGroup CLOTH_AND_FIBERS = createFamilyGroup(11, "cloth_and_fibers", block("conquest:magenta_carpet"));
    public static final ConquestItemGroup FURNITURE = createFamilyGroup(12, "furniture", block("conquest:old_rustic_bed"));
    public static final ConquestItemGroup APPLIANCES = createFamilyGroup(13, "appliances", block("minecraft:loom"));
    public static final ConquestItemGroup STORAGE = createFamilyGroup(14, "storage", block("conquest:rounded_chest"));
    public static final ConquestItemGroup DECORATIONS = createFamilyGroup(15, "decor", block("conquest:towel_rack"));
    public static final ConquestItemGroup LIGHTING = createFamilyGroup(16, "lighting", block("conquest:small_lantern"));
    public static final ConquestItemGroup TOOL_BLOCKS = createFamilyGroup(17, "tool_blocks", block("conquest:rack_of_pitchforks_scythes_and_flails"));
    public static final ConquestItemGroup FOOD_BLOCKS = createFamilyGroup(18, "food_blocks", block("conquest:big_bread"));

    //Page 3 (10 tabs)
    public static final ConquestItemGroup STONE = createFamilyGroup(19, "stone", block("conquest:mudstone"));
    public static final ConquestItemGroup GRASS_AND_DIRT = createFamilyGroup(20, "grass_and_dirt", block("minecraft:grass_block"));
    public static final ConquestItemGroup SAND_AND_GRAVEL = createFamilyGroup(21, "sand_and_gravel", block("conquest:small_stones"));
    public static final ConquestItemGroup LOGS = createFamilyGroup(22, "logs", block("minecraft:oak_log"));
    public static final ConquestItemGroup LEAVES = createFamilyGroup(23, "leaves", block("minecraft:dark_oak_leaves"));
    public static final ConquestItemGroup GRASSES_AND_SHRUBS = createFamilyGroup(24, "grasses_and_shrubs", block("minecraft:grass"));
    public static final ConquestItemGroup FLOWERS = createFamilyGroup(25, "flowers", block("conquest:hanging_dandelions"));
    public static final ConquestItemGroup CROPS = createFamilyGroup(26, "crops_and_herbs", block("conquest:wild_wheat"));
    public static final ConquestItemGroup WATER_AND_AIR = createFamilyGroup(27, "water_and_air", block("conquest:steam"));
    public static final ConquestItemGroup ANIMALS = createFamilyGroup(28, "animals", block("conquest:owl"));

    //Page 4 (6 tabs)
    public static final ConquestItemGroup ARMOR = createFamilyGroup(29, "armor", item("minecraft:chainmail_chestplate"));
    public static final ConquestItemGroup WEAPONS_AND_TOOLS = createFamilyGroup(30, "weapons_and_tools", item("minecraft:iron_axe"));
    public static final ConquestItemGroup FOOD_AND_CONSUMABLES = createFamilyGroup(31, "food_and_consumables", item("minecraft:bread"));
    public static final ConquestItemGroup BREWING = createFamilyGroup(32, "brewing", block("minecraft:brewing_stand"));
    public static final ConquestItemGroup MISCELLANEOUS = createFamilyGroup(33, "miscellaneous", item("minecraft:music_disc_strad"));
    public static final ConquestItemGroup UTILITY = createFamilyGroup(34, "utility", block("minecraft:barrier"));

    public static void initGroups() {
        FamilyGroup.stream().forEach(familyGroup -> {
            ItemGroupManager.getInstance().register(familyGroup);
        });
    }

    private static Supplier<ItemStack> block(String name) {
        return Provider.block(name).toStack();
    }

    private static Supplier<ItemStack> item(String name) {
        return Provider.item(name).toStack();
    }

    private static FamilyGroup createFamilyGroup(int order, String label, Supplier<ItemStack> icon) {
        ((ItemGroupExtensions) ItemGroup.BUILDING_BLOCKS).fabric_expandArray();
        return new FamilyGroup(order + originalGroupsLength, label, icon);
    }
}
