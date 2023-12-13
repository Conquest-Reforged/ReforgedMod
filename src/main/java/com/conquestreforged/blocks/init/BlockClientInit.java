package com.conquestreforged.blocks.init;

import com.conquestreforged.blocks.group.ModGroups;
import com.conquestreforged.blocks.init.blocks.LiliesInit;
import com.conquestreforged.blocks.init.blocks.ScaffoldingInit;
import com.conquestreforged.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.blocks.tileentity.enchantment.ModdedTileEntityEnchanterRenderer;
import com.conquestreforged.core.client.color.BlockColors;
import com.conquestreforged.core.item.family.DeferredFamilyRegistry;
import com.conquestreforged.core.item.family.FamilyGroup;
import com.conquestreforged.core.item.group.manager.GroupType;
import com.conquestreforged.core.item.group.manager.ItemGroupManager;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import static net.minecraft.world.level.block.Blocks.*;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockClientInit {

    @SubscribeEvent
    public static void client(FMLClientSetupEvent event) {
        Log.info("Initializing ModItemGroups");
        ModGroups.initGroups();
        ItemBlockRenderTypes.setRenderLayer(ScaffoldingInit.METAL_SCAFFOLDING, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ScaffoldingInit.WOOD_SCAFFOLDING, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LiliesInit.BIG_WATER_LILIES, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LiliesInit.DUCKWEED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LiliesInit.FLOATING_ICE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(INFESTED_MOSSY_STONE_BRICKS, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MOSSY_STONE_BRICKS, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MOSSY_STONE_BRICK_STAIRS, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ANVIL, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CHIPPED_ANVIL, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DAMAGED_ANVIL, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WHITE_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ORANGE_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MAGENTA_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(YELLOW_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LIME_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PINK_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_GRAY_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PURPLE_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RED_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BLACK_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BLUE_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BROWN_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CYAN_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GRAY_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GREEN_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_BLUE_BED, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ENCHANTING_TABLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WHITE_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ORANGE_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MAGENTA_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(YELLOW_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LIME_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PINK_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_GRAY_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PURPLE_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RED_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BLACK_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BLUE_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BROWN_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CYAN_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GRAY_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GREEN_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_BLUE_CANDLE, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CANDLE, RenderType.cutout());
    }

    @SubscribeEvent
    public static void clientBlockEntities(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(TileEntityTypes.ENCHANTING_TABLE, ModdedTileEntityEnchanterRenderer::new);
    }

    @SubscribeEvent
    public static void common(FMLCommonSetupEvent event) {
        Log.info("Initializing Block/Item families");
        BlockGroupInit.init();
        BlockFamilyInit.init();
        DeferredFamilyRegistry.BLOCKS.registerAll();
    }

    @SubscribeEvent
    public static void complete(FMLLoadCompleteEvent event) {
        Log.info("Setting up GroupManager");
        FamilyGroup.setAddRootItems();
        ItemGroupManager.getInstance().setVisibleItemGroups(GroupType.CONQUEST, GroupType.OTHER);
    }

    @SubscribeEvent
    public static void blockColors(ColorHandlerEvent.Block event) {
        Log.info("Registering additional vanilla block colors");
        event.getBlockColors().register(BlockColors.GRASS, INFESTED_MOSSY_STONE_BRICKS, MOSSY_STONE_BRICKS, MOSSY_STONE_BRICK_SLAB, MOSSY_STONE_BRICK_STAIRS);
    }

    @SubscribeEvent
    public static void items(ColorHandlerEvent.Item event) {
        Log.info("Registering additional vanilla item colors");
        event.getItemColors().register(BlockColors.toItemColor(event.getBlockColors()), INFESTED_MOSSY_STONE_BRICKS, MOSSY_STONE_BRICKS, MOSSY_STONE_BRICK_SLAB, MOSSY_STONE_BRICK_STAIRS);
    }
}
