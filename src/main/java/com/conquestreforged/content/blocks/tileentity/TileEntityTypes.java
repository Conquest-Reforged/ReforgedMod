package com.conquestreforged.content.blocks.tileentity;

import com.conquestreforged.content.blocks.tileentity.campfire.ModdedCampfireTileEntity;
import com.conquestreforged.content.blocks.tileentity.enchantment.ModdedEnchantingTableTileEntity;
import com.conquestreforged.content.blocks.tileentity.furnace.ModdedFurnaceTileEntity;
import com.conquestreforged.content.blocks.tileentity.seat.SeatTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

// should not have any event listeners to avoid class-loading before blocks are registered
public class TileEntityTypes {

    public static void init() {

    }

    public static final BlockEntityType<ModdedEnchantingTableTileEntity> ENCHANTING_TABLE = create(
            ModdedEnchantingTableTileEntity::new,
            "conquest:enchanter",
            "conquest:enchantment_table", "conquest:floating_book"
    );

    public static final BlockEntityType<ModdedCampfireTileEntity> CAMPFIRE = create(
            ModdedCampfireTileEntity::new,
            "conquest:campfire",
            "conquest:campfire"
    );

    public static final BlockEntityType<ModdedFurnaceTileEntity> FURNACE = create(
            ModdedFurnaceTileEntity::new,
            "conquest:oven",
            "conquest:sandstone_oven", "conquest:iron_oven"
    );

    public static final BlockEntityType<AnimalTileEntity> ANIMAL = create(
            AnimalTileEntity::new,
            "conquest:animal",
            "conquest:raven", "conquest:hawk", "conquest:bluejay", "conquest:pigeon", "conquest:duck",
            "conquest:puffin", "conquest:seagull", "conquest:owl", "conquest:bat", "conquest:rat", "conquest:toad"
    );

    public static final BlockEntityType<SeatTileEntity> SEAT = create(
            SeatTileEntity::new,
            "conquest:seat",
            "conquest:spruce_chair", "conquest:fancy_chair", "conquest:oak_chair", "conquest:spruce_wood_stool", "conquest:round_wooden_stool",
            "conquest:wicker_stool", "conquest:small_wicker_stool", "conquest:red_cushion_stool", "conquest:small_red_cushion_stool",
            "conquest:small_old_leather_stool", "conquest:small_oak_wood_stool", "conquest:small_green_cushion_stool", "conquest:small_fancy_stool_base",
            "conquest:small_fancy_leather_stool", "conquest:small_burlap_stool", "conquest:small_blue_cushion_stool",
            "conquest:old_leather_stool", "conquest:oak_wood_stool", "conquest:green_cushion_stool", "conquest:fancy_stool_base",
            "conquest:burlap_stool", "conquest:fancy_leather_stool", "conquest:blue_cushion_stool"
    );

    private static <T extends BlockEntity> BlockEntityType<T> create(BlockEntityType.BlockEntityFactory<T> factory, String name, String... blockNames) {
        Block[] blocks = new Block[blockNames.length];
        for (int i = 0; i < blockNames.length; i++) {
            Block block = Registry.BLOCK.get(new Identifier(blockNames[i]));
            if (block == null || block == Blocks.AIR) {
                throw new IllegalArgumentException("Block passed into tile entity registration is not registered correctly");
            }
            blocks[i] = block;
        }
        BlockEntityType<T> type = BlockEntityType.Builder.create(factory, blocks).build(null);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, name, type);
        return type;
    }
}
