package com.conquestrefabricated.client.gui.palette.texture;

import io.github.fabricators_of_create.porting_lib.model.data.ModelData;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.texture.Sprite;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@Environment(EnvType.CLIENT)
public class TextureGroupManager {

    private static final Random random = Random.create();
    private static final ModelData nodata = ModelData.EMPTY;
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
        for (Item item : Registry.ITEM) {
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
        BakedModel model = MinecraftClient.getInstance().getBlockRenderManager().getModels().getModel(state);
        return getTextures(state, model);
    }

    private static Map<String, Integer> getTextures(BlockState state, @Nullable BakedModel model) {
        if (model == null || model == MinecraftClient.getInstance().getBakedModelManager().getMissingModel()) {
            return Collections.emptyMap();
        }

        List<BakedQuad> quads = model.getQuads(state, null, random);

        Map<String, Integer> textures = new HashMap<>();

        // add particle texture
        addTexture(model.getParticleSprite(), textures);

        // add any other textures
        for (BakedQuad quad : quads) {
            addTexture(quad.getSprite(), textures);
        }

        return textures;
    }

    private static void addTexture(@Nullable Sprite sprite, Map<String, Integer> textures) {
        String texture = getTextureName(sprite);
        if (!texture.isEmpty()) {
            int count = textures.getOrDefault(texture, 0);
            textures.put(texture, count + 1);
        }
    }

    private static String getTextureName(@Nullable Sprite sprite) {
        if (sprite != null) {
            try {
                return getResourceName(sprite.getId());
            } catch (Throwable t) {
                return "";
            }
        }
        return "";
    }

    private static String getResourceName(@Nullable Identifier location) {
        if (location != null) {
            return location.toString();
        }
        return "";
    }

    public static TextureGroupManager getInstance() {
        return INSTANCE;
    }
/*
    //    @SubscribeEvent
    public static void reload(TextureStitchEvent.Post event) {
        Log.info("Reloading TextureGroupManager");
        getInstance().rebuild();
    }*/
}
