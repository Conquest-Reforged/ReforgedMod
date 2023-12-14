package com.conquestreforged.content.blocks.init;

import com.conquestreforged.content.blocks.group.ModGroups;
import com.conquestreforged.content.blocks.init.blocks.LiliesInit;
import com.conquestreforged.content.blocks.init.blocks.ScaffoldingInit;
import com.conquestreforged.content.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.content.blocks.tileentity.enchantment.ModdedTileEntityEnchanterRenderer;
import com.conquestreforged.core.client.color.BlockColors;
import com.conquestreforged.core.item.family.DeferredFamilyRegistry;
import com.conquestreforged.core.item.family.FamilyGroup;
import com.conquestreforged.core.item.group.manager.GroupType;
import com.conquestreforged.core.item.group.manager.ItemGroupManager;
import com.conquestreforged.core.util.log.Log;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;

import static net.minecraft.block.Blocks.*;

@Environment(EnvType.CLIENT)
public class BlockClientInit {

    public static void client() {
        Log.info("Initializing ModItemGroups");
        ModGroups.initGroups();
        BlockRenderLayerMap.INSTANCE.putBlock(ScaffoldingInit.METAL_SCAFFOLDING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ScaffoldingInit.WOOD_SCAFFOLDING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LiliesInit.BIG_WATER_LILIES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LiliesInit.DUCKWEED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LiliesInit.FLOATING_ICE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(INFESTED_MOSSY_STONE_BRICKS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MOSSY_STONE_BRICKS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MOSSY_STONE_BRICK_STAIRS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ANVIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CHIPPED_ANVIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DAMAGED_ANVIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WHITE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ORANGE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MAGENTA_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(YELLOW_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LIME_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PINK_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LIGHT_GRAY_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PURPLE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RED_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BLACK_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BLUE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BROWN_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CYAN_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GRAY_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GREEN_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LIGHT_BLUE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ENCHANTING_TABLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WHITE_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ORANGE_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MAGENTA_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(YELLOW_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LIME_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PINK_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LIGHT_GRAY_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PURPLE_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RED_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BLACK_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BLUE_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BROWN_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CYAN_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GRAY_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GREEN_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LIGHT_BLUE_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CANDLE, RenderLayer.getCutout());
    }

    //@SubscribeEvent
    public static void  clientBlockEntities() {
        BlockEntityRendererRegistry.register(TileEntityTypes.ENCHANTING_TABLE, ModdedTileEntityEnchanterRenderer::new);
    }

    //@SubscribeEvent
    public static void common() {
        Log.info("Initializing Block/Item families");
        BlockGroupInit.init();
        BlockFamilyInit.init();
        DeferredFamilyRegistry.BLOCKS.registerAll();
    }

    //@SubscribeEvent
    public static void complete() {
        Log.info("Setting up GroupManager");
        FamilyGroup.setAddRootItems();
        ItemGroupManager.getInstance().setVisibleItemGroups(GroupType.CONQUEST, GroupType.OTHER);
    }

    //@SubscribeEvent
    public static void blockColors() {
        Log.info("Registering additional vanilla block colors");
        ColorProviderRegistry.BLOCK.register(BlockColors.GRASS, INFESTED_MOSSY_STONE_BRICKS, MOSSY_STONE_BRICKS, MOSSY_STONE_BRICK_SLAB, MOSSY_STONE_BRICK_STAIRS);
    }

    //@SubscribeEvent
    public static void items(net.minecraft.client.color.block.BlockColors blockColors) {
        Log.info("Registering additional vanilla item colors");
       ColorProviderRegistry.ITEM.register(BlockColors.toItemColor(blockColors), INFESTED_MOSSY_STONE_BRICKS, MOSSY_STONE_BRICKS, MOSSY_STONE_BRICK_SLAB, MOSSY_STONE_BRICK_STAIRS);
    }
}
