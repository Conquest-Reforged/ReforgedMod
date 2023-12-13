package com.conquestreforged.client.gui.palette.texture;

import com.conquestreforged.core.util.log.Log;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TextureGroupManager {

    private static final Random random = new Random();
    private static final IModelData nodata = EmptyModelData.INSTANCE;
    private static final TextureGroupManager INSTANCE = new TextureGroupManager();

    private final Map<Item, ItemGroup> blockGroups = new HashMap<>();
    private final Map<String, TextureGroup> textureGroups = new HashMap<>();

    public ItemGroup getGroup(Block block) {
        return getGroup(block.asItem());
    }

    public ItemGroup getGroup(BlockState state) {
        return getGroup(state.getBlock());
    }

    public ItemGroup getGroup(ItemStack stack) {
        return getGroup(stack.getItem());
    }

    public ItemGroup getGroup(Item item) {
        return blockGroups.getOrDefault(item, ItemGroup.NONE);
    }

    private void rebuild() {
        textureGroups.clear();
        blockGroups.clear();
        for (Item item : ForgeRegistries.ITEMS) {
            if (item instanceof BlockItem) {
                BlockItem blockItem = (BlockItem) item;
                addState(item, blockItem.getBlock().getDefaultState());
            }
        }
    }

    private void addState(Item item, BlockState state) {
        Map<String, Integer> textures = getTextures(state);

        int count = Integer.MAX_VALUE;
        TextureGroup main = null;
        List<TextureGroup> itemGroups = new LinkedList<>();

        for (Map.Entry<String, Integer> entry : textures.entrySet()) {
            TextureGroup textureGroup = textureGroups.computeIfAbsent(entry.getKey(), TextureGroup::new);
            textureGroup.add(item);

            itemGroups.add(textureGroup);

            if (entry.getValue() < count) {
                main = textureGroup;
            }
        }

        if (main != null) {
            blockGroups.put(item, new ItemGroup(main, itemGroups));
        }
    }

    private static Map<String, Integer> getTextures(BlockState state) {
        IBakedModel model = Minecraft.getInstance().getModelManager().getBlockModelShapes().getModel(state);
        return getTextures(state, model);
    }

    private static Map<String, Integer> getTextures(BlockState state, @Nullable IBakedModel model) {
        if (model == null || model == Minecraft.getInstance().getModelManager().getMissingModel()) {
            return Collections.emptyMap();
        }

        List<BakedQuad> quads = model.getQuads(state, null, random, nodata);

        Map<String, Integer> textures = new HashMap<>();

        // add particle texture
        addTexture(model.getParticleTexture(nodata), textures);

        // add any other textures
        for (BakedQuad quad : quads) {
            addTexture(quad.func_187508_a(), textures);
        }

        return textures;
    }

    private static void addTexture(@Nullable TextureAtlasSprite sprite, Map<String, Integer> textures) {
        String texture = getTextureName(sprite);
        if (!texture.isEmpty()) {
            int count = textures.getOrDefault(texture, 0);
            textures.put(texture, count + 1);
        }
    }

    private static String getTextureName(@Nullable TextureAtlasSprite sprite) {
        if (sprite != null) {
            try {
                return getResourceName(sprite.getName());
            } catch (Throwable t) {
                return "";
            }
        }
        return "";
    }

    private static String getResourceName(@Nullable ResourceLocation location) {
        if (location != null) {
            return location.toString();
        }
        return "";
    }

    public static TextureGroupManager getInstance() {
        return INSTANCE;
    }

    //    @SubscribeEvent
    public static void reload(TextureStitchEvent.Post event) {
        Log.info("Reloading TextureGroupManager");
        getInstance().rebuild();
    }
}
