package com.conquestreforged.blocks.init;

import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.blocks.init.blocks.LiliesInit;
import com.conquestreforged.blocks.init.blocks.ScaffoldingInit;
import com.conquestreforged.core.block.factory.TypeList;
import com.conquestreforged.core.item.family.FamilyRegistry;
import com.conquestreforged.core.item.family.block.BlockFamily;
import com.conquestreforged.core.item.group.ConquestItemGroup;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlockGroupInit {
    
    public static void init() {
        //COBBLE_AND_BRICK
        register(ModGroups.COBBLE_AND_BRICK, Blocks.GRAY_GLAZED_TERRACOTTA);
        //ADVANCED_MASONRY_AND_CERAMICS
        register(ModGroups.ADVANCED_MASONRY_AND_CERAMICS, Blocks.LAPIS_BLOCK);
        register(ModGroups.ADVANCED_MASONRY_AND_CERAMICS, Blocks.DISPENSER);
        register(ModGroups.ADVANCED_MASONRY_AND_CERAMICS, Blocks.DROPPER);
        register(ModGroups.ADVANCED_MASONRY_AND_CERAMICS, Blocks.DISPENSER);
        register(ModGroups.ADVANCED_MASONRY_AND_CERAMICS, Blocks.WITHER_SKELETON_SKULL);
        //MOSAICS_TILES_AND_FLOORS
        register(ModGroups.MOSAICS_TILES_AND_FLOORS, Blocks.MAGENTA_GLAZED_TERRACOTTA);
        register(ModGroups.MOSAICS_TILES_AND_FLOORS, Blocks.BROWN_GLAZED_TERRACOTTA);
        register(ModGroups.MOSAICS_TILES_AND_FLOORS, Blocks.GREEN_GLAZED_TERRACOTTA);
        register(ModGroups.MOSAICS_TILES_AND_FLOORS, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        register(ModGroups.MOSAICS_TILES_AND_FLOORS, Blocks.BLACK_GLAZED_TERRACOTTA);
        register(ModGroups.MOSAICS_TILES_AND_FLOORS, Blocks.RED_GLAZED_TERRACOTTA);
        register(ModGroups.MOSAICS_TILES_AND_FLOORS, Blocks.YELLOW_GLAZED_TERRACOTTA);
        register(ModGroups.MOSAICS_TILES_AND_FLOORS, Blocks.ORANGE_GLAZED_TERRACOTTA);
        register(ModGroups.MOSAICS_TILES_AND_FLOORS, Blocks.WHITE_GLAZED_TERRACOTTA);
        //PLASTER_STUCCO_AND_PAINT
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.LIME_GLAZED_TERRACOTTA);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.PURPLE_GLAZED_TERRACOTTA);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.BLUE_GLAZED_TERRACOTTA);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.PINK_GLAZED_TERRACOTTA);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.CYAN_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.MAGENTA_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.GRAY_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.BLACK_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.ORANGE_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.BLUE_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.PURPLE_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.LIGHT_GRAY_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.LIGHT_BLUE_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.RED_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.WHITE_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.PINK_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.BROWN_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.LIME_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.GREEN_CONCRETE_POWDER);
        register(ModGroups.PLASTER_STUCCO_AND_PAINT, Blocks.YELLOW_CONCRETE_POWDER);
        //PLANKS_AND_BEAMS
        register(ModGroups.PLANKS_AND_BEAMS, Blocks.SCAFFOLDING);
        register(ModGroups.PLANKS_AND_BEAMS, ScaffoldingInit.WOOD_SCAFFOLDING);
        //ADVANCED_CARPENTRY
        register(ModGroups.ADVANCED_CARPENTRY, Blocks.OAK_DOOR);
        register(ModGroups.ADVANCED_CARPENTRY, Blocks.SPRUCE_DOOR);
        register(ModGroups.ADVANCED_CARPENTRY, Blocks.BIRCH_DOOR);
        register(ModGroups.ADVANCED_CARPENTRY, Blocks.JUNGLE_DOOR);
        register(ModGroups.ADVANCED_CARPENTRY, Blocks.ACACIA_DOOR);
        register(ModGroups.ADVANCED_CARPENTRY, Blocks.DARK_OAK_DOOR);
        //METAL
        register(ModGroups.METAL, Blocks.END_PORTAL_FRAME);
        register(ModGroups.METAL, Blocks.CYAN_GLAZED_TERRACOTTA);
        register(ModGroups.METAL, Blocks.GOLD_BLOCK);
        register(ModGroups.METAL, Blocks.EMERALD_BLOCK);
        register(ModGroups.METAL, Blocks.REDSTONE_BLOCK);
        register(ModGroups.METAL, Blocks.HOPPER);
        register(ModGroups.METAL, Blocks.IRON_DOOR);
        register(ModGroups.METAL, Blocks.IRON_TRAPDOOR);
        register(ModGroups.METAL, Blocks.BELL);
        register(ModGroups.METAL, ScaffoldingInit.METAL_SCAFFOLDING);
        //DECORATIONS
        register(ModGroups.DECORATIONS, Blocks.FLOWER_POT);
        //LIGHTING
        register(ModGroups.LIGHTING, Blocks.REDSTONE_LAMP);
        register(ModGroups.LIGHTING, Blocks.LANTERN);
        register(ModGroups.LIGHTING, Blocks.CAMPFIRE);
        register(ModGroups.LIGHTING, Blocks.TORCH);
        //TOOL_BLOCKS
        register(ModGroups.TOOL_BLOCKS, Blocks.DAYLIGHT_DETECTOR);
        register(ModGroups.TOOL_BLOCKS, Blocks.TRIPWIRE_HOOK);
        register(ModGroups.TOOL_BLOCKS, Blocks.ANVIL);
        register(ModGroups.TOOL_BLOCKS, Blocks.CONDUIT);
        register(ModGroups.TOOL_BLOCKS, Blocks.COMPARATOR);
        register(ModGroups.TOOL_BLOCKS, Blocks.REPEATER);
        register(ModGroups.TOOL_BLOCKS, Blocks.REDSTONE_TORCH);
        register(ModGroups.TOOL_BLOCKS, Blocks.REDSTONE_WIRE);
        register(ModGroups.TOOL_BLOCKS, Blocks.HOPPER);
        register(ModGroups.TOOL_BLOCKS, Blocks.LADDER);
        register(ModGroups.TOOL_BLOCKS, Blocks.OBSERVER);
        //FOOD_BLOCKS
        register(ModGroups.FOOD_BLOCKS, Blocks.CAKE);
        register(ModGroups.FOOD_BLOCKS, Blocks.MELON);
        register(ModGroups.FOOD_BLOCKS, Blocks.PUMPKIN);
        //STONE
        register(ModGroups.STONE, Blocks.GOLD_ORE);
        register(ModGroups.STONE, Blocks.IRON_ORE);
        register(ModGroups.STONE, Blocks.COAL_ORE);
        register(ModGroups.STONE, Blocks.LAPIS_ORE);
        register(ModGroups.STONE, Blocks.DIAMOND_ORE);
        register(ModGroups.STONE, Blocks.REDSTONE_ORE);
        register(ModGroups.STONE, Blocks.EMERALD_ORE);
        register(ModGroups.STONE, Blocks.NETHER_QUARTZ_ORE);
        //FURNITURE
        register(ModGroups.FURNITURE, Blocks.RED_BED);
        register(ModGroups.FURNITURE, Blocks.JUKEBOX);
        //APPLIANCES
        register(ModGroups.APPLIANCES, Blocks.CRAFTING_TABLE);
        register(ModGroups.APPLIANCES, Blocks.FURNACE);
        register(ModGroups.APPLIANCES, Blocks.BLAST_FURNACE);
        register(ModGroups.APPLIANCES, Blocks.LOOM);
        register(ModGroups.APPLIANCES, Blocks.SMOKER);
        register(ModGroups.APPLIANCES, Blocks.CARTOGRAPHY_TABLE);
        register(ModGroups.APPLIANCES, Blocks.FLETCHING_TABLE);
        register(ModGroups.APPLIANCES, Blocks.GRINDSTONE);
        register(ModGroups.APPLIANCES, Blocks.LECTERN);
        register(ModGroups.APPLIANCES, Blocks.SMITHING_TABLE);
        register(ModGroups.APPLIANCES, Blocks.STONECUTTER);
        register(ModGroups.APPLIANCES, Blocks.BEEHIVE);
        register(ModGroups.APPLIANCES, Blocks.CAULDRON);
        //STORAGE
        register(ModGroups.STORAGE, Blocks.CHEST);
        register(ModGroups.STORAGE, Blocks.TRAPPED_CHEST);
        register(ModGroups.STORAGE, Blocks.ENDER_CHEST);
        register(ModGroups.STORAGE, Blocks.BARREL);
        //LEAVES
        register(ModGroups.LEAVES, Blocks.OAK_LEAVES);
        register(ModGroups.LEAVES, Blocks.DARK_OAK_LEAVES);
        register(ModGroups.LEAVES, Blocks.BIRCH_LEAVES);
        register(ModGroups.LEAVES, Blocks.SPRUCE_LEAVES);
        register(ModGroups.LEAVES, Blocks.JUNGLE_LEAVES);
        register(ModGroups.LEAVES, Blocks.ACACIA_LEAVES);
        register(ModGroups.LEAVES, Blocks.OAK_SAPLING);
        register(ModGroups.LEAVES, Blocks.DARK_OAK_SAPLING);
        register(ModGroups.LEAVES, Blocks.BIRCH_SAPLING);
        register(ModGroups.LEAVES, Blocks.SPRUCE_SAPLING);
        register(ModGroups.LEAVES, Blocks.JUNGLE_SAPLING);
        register(ModGroups.LEAVES, Blocks.ACACIA_SAPLING);
        //GRASSES_AND_SHRUBS
        register(ModGroups.GRASSES_AND_SHRUBS, Blocks.VINE);
        register(ModGroups.GRASSES_AND_SHRUBS, Blocks.BROWN_MUSHROOM_BLOCK);
        register(ModGroups.GRASSES_AND_SHRUBS, Blocks.RED_MUSHROOM_BLOCK);
        register(ModGroups.GRASSES_AND_SHRUBS, Blocks.MUSHROOM_STEM);
        register(ModGroups.GRASSES_AND_SHRUBS, LiliesInit.DUCKWEED);
        register(ModGroups.GRASSES_AND_SHRUBS, Blocks.LILY_PAD);
        register(ModGroups.GRASSES_AND_SHRUBS, LiliesInit.BIG_WATER_LILIES);
        register(ModGroups.GRASSES_AND_SHRUBS, Blocks.BAMBOO);
        register(ModGroups.GRASSES_AND_SHRUBS, Blocks.SWEET_BERRY_BUSH);
        register(ModGroups.GRASSES_AND_SHRUBS, Blocks.KELP);
        //CROPS
        register(ModGroups.CROPS, Blocks.SUGAR_CANE);
        register(ModGroups.CROPS, Blocks.COCOA);
        //WATER_AND_AIR
        register(ModGroups.WATER_AND_AIR, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        register(ModGroups.WATER_AND_AIR, LiliesInit.FLOATING_ICE);
        //ANIMALS
        register(ModGroups.ANIMALS, Blocks.BEE_NEST);
        register(ModGroups.ANIMALS, Blocks.HONEY_BLOCK);
        register(ModGroups.ANIMALS, Blocks.HONEYCOMB_BLOCK);
        register(ModGroups.ANIMALS, Blocks.DEAD_TUBE_CORAL);
        register(ModGroups.ANIMALS, Blocks.DEAD_BRAIN_CORAL);
        register(ModGroups.ANIMALS, Blocks.DEAD_BUBBLE_CORAL);
        register(ModGroups.ANIMALS, Blocks.DEAD_FIRE_CORAL);
        register(ModGroups.ANIMALS, Blocks.DEAD_HORN_CORAL);
        register(ModGroups.ANIMALS, Blocks.DEAD_TUBE_CORAL_BLOCK);
        register(ModGroups.ANIMALS, Blocks.DEAD_BRAIN_CORAL_BLOCK);
        register(ModGroups.ANIMALS, Blocks.DEAD_BUBBLE_CORAL_BLOCK);
        register(ModGroups.ANIMALS, Blocks.DEAD_FIRE_CORAL_BLOCK);
        register(ModGroups.ANIMALS, Blocks.DEAD_HORN_CORAL_BLOCK);
        register(ModGroups.ANIMALS, Blocks.DEAD_TUBE_CORAL_FAN);
        register(ModGroups.ANIMALS, Blocks.DEAD_BRAIN_CORAL_FAN);
        register(ModGroups.ANIMALS, Blocks.DEAD_BUBBLE_CORAL_FAN);
        register(ModGroups.ANIMALS, Blocks.DEAD_FIRE_CORAL_FAN);
        register(ModGroups.ANIMALS, Blocks.DEAD_HORN_CORAL_FAN);
        register(ModGroups.ANIMALS, Blocks.SPONGE);
        register(ModGroups.ANIMALS, Blocks.WET_SPONGE);
        register(ModGroups.ANIMALS, Blocks.TURTLE_EGG);
        //BREWING
        register(ModGroups.BREWING, Blocks.BREWING_STAND);
        //UTILITY
        register(ModGroups.UTILITY, Blocks.BARRIER);

        register(ModGroups.GRASSES_AND_SHRUBS, Blocks.SHROOMLIGHT);
    }

    private static void register(ConquestItemGroup group, Block... blocks) {
        BlockFamily family = new BlockFamily(group, TypeList.EMPTY);
        for (Block block : blocks) {
            family.add(block);
            FamilyRegistry.BLOCKS.register(block, family);
        }
    }
}
