package com.conquestreforged.blocks.group;

import com.conquestreforged.core.item.family.FamilyGroup;
import com.conquestreforged.core.item.group.ConquestItemGroup;
import com.conquestreforged.core.item.group.manager.ItemGroupManager;
import com.conquestreforged.core.util.Provider;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ModGroups {

    //Page 1 (9 tabs)
    public static final ConquestItemGroup COBBLE_AND_BRICK = new FamilyGroup(0, "cobble_and_brick", block("conquest:lime_mortar_masonry"));
    public static final ConquestItemGroup ADVANCED_MASONRY_AND_CERAMICS = new FamilyGroup(1, "advanced_masonry", block("conquest:schist_dragon_head"));
    public static final ConquestItemGroup COLUMNS = new FamilyGroup(2, "columns", block("minecraft:chiseled_stone_bricks"));
    public static final ConquestItemGroup MOSAICS_TILES_AND_FLOORS = new FamilyGroup(3, "mosaics_tiles_and_floors", block("conquest:andalusian_mosaic"));
    public static final ConquestItemGroup PLASTER_STUCCO_AND_PAINT = new FamilyGroup(4, "plaster_stucco_and_paint", block("conquest:etruscan_wall_design_1"));
    public static final ConquestItemGroup HALF_TIMBERED_WALLS = new FamilyGroup(5, "half_timbered_walls", block("conquest:tudor_cross_frame"));
    public static final ConquestItemGroup ROOFING = new FamilyGroup(6, "roofing", block("conquest:terracotta_imbrices_and_tegulae"));
    public static final ConquestItemGroup PLANKS_AND_BEAMS = new FamilyGroup(7, "planks_and_beams", block("minecraft:oak_planks"));
    public static final ConquestItemGroup ADVANCED_CARPENTRY = new FamilyGroup(8, "advanced_carpentry", block("conquest:carved_oak_wood"));

    //Page 2 (10 tabs)
    public static final ConquestItemGroup METAL = new FamilyGroup(9, "metal", block("minecraft:iron_block"));
    public static final ConquestItemGroup WINDOWS_AND_GLASS = new FamilyGroup(10, "windows_and_glass", block("minecraft:glass"));
    public static final ConquestItemGroup CLOTH_AND_FIBERS = new FamilyGroup(11, "cloth_and_fibers", block("conquest:magenta_carpet"));
    public static final ConquestItemGroup FURNITURE = new FamilyGroup(12, "furniture", block("conquest:old_rustic_bed"));
    public static final ConquestItemGroup APPLIANCES = new FamilyGroup(13, "appliances", block("minecraft:loom"));
    public static final ConquestItemGroup STORAGE = new FamilyGroup(14, "storage", block("conquest:rounded_chest"));
    public static final ConquestItemGroup DECORATIONS = new FamilyGroup(15, "decor", block("conquest:towel_rack"));
    public static final ConquestItemGroup LIGHTING = new FamilyGroup(16, "lighting", block("conquest:small_lantern"));
    public static final ConquestItemGroup TOOL_BLOCKS = new FamilyGroup(17, "tool_blocks", block("conquest:rack_of_pitchforks_scythes_and_flails"));
    public static final ConquestItemGroup FOOD_BLOCKS = new FamilyGroup(18, "food_blocks", block("conquest:big_bread"));

    //Page 3 (10 tabs)
    public static final ConquestItemGroup STONE = new FamilyGroup(19, "stone", block("conquest:mudstone"));
    public static final ConquestItemGroup GRASS_AND_DIRT = new FamilyGroup(20, "grass_and_dirt", block("minecraft:grass_block"));
    public static final ConquestItemGroup SAND_AND_GRAVEL = new FamilyGroup(21, "sand_and_gravel", block("conquest:small_stones"));
    public static final ConquestItemGroup LOGS = new FamilyGroup(22, "logs", block("minecraft:oak_log"));
    public static final ConquestItemGroup LEAVES = new FamilyGroup(23, "leaves", block("minecraft:dark_oak_leaves"));
    public static final ConquestItemGroup GRASSES_AND_SHRUBS = new FamilyGroup(24, "grasses_and_shrubs", block("minecraft:grass"));
    public static final ConquestItemGroup FLOWERS = new FamilyGroup(25, "flowers", block("conquest:hanging_dandelions"));
    public static final ConquestItemGroup CROPS = new FamilyGroup(26, "crops_and_herbs", block("conquest:wild_wheat"));
    public static final ConquestItemGroup WATER_AND_AIR = new FamilyGroup(27, "water_and_air", block("conquest:steam"));
    public static final ConquestItemGroup ANIMALS = new FamilyGroup(28, "animals", block("conquest:owl"));

    //Page 4 (6 tabs)
    public static final ConquestItemGroup ARMOR = new FamilyGroup(29, "armor", item("minecraft:chainmail_chestplate"));
    public static final ConquestItemGroup WEAPONS_AND_TOOLS = new FamilyGroup(30, "weapons_and_tools", item("minecraft:iron_axe"));
    public static final ConquestItemGroup FOOD_AND_CONSUMABLES = new FamilyGroup(31, "food_and_consumables", item("minecraft:bread"));
    public static final ConquestItemGroup BREWING = new FamilyGroup(32, "brewing", block("minecraft:brewing_stand"));
    public static final ConquestItemGroup MISCELLANEOUS = new FamilyGroup(33, "miscellaneous", item("minecraft:music_disc_strad"));
    public static final ConquestItemGroup UTILITY = new FamilyGroup(34, "utility", block("minecraft:barrier"));

    public static void initGroups() {
        FamilyGroup.stream().forEach(ItemGroupManager.getInstance()::register);
    }

    private static Supplier<ItemStack> block(String name) {
        return Provider.block(name).toStack();
    }

    private static Supplier<ItemStack> item(String name) {
        return Provider.item(name).toStack();
    }
}
