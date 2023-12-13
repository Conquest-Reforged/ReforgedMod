package com.conquestreforged.core.block.data;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Ingredient;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Recipe;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.asset.override.EmptyOverride;
import com.conquestreforged.core.asset.override.MapOverride;
import com.conquestreforged.core.asset.override.SingleOverride;
import com.conquestreforged.core.asset.pack.Locations;
import com.conquestreforged.core.asset.pack.VirtualResourcepack;
import com.conquestreforged.core.asset.template.JsonOverride;
import com.conquestreforged.core.asset.template.JsonTemplate;
import com.conquestreforged.core.asset.template.TemplateCache;
import com.conquestreforged.core.asset.template.TemplateResource;
import com.conquestreforged.core.block.builder.BlockName;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.builder.Textures;
import com.conquestreforged.core.client.render.RenderLayerHelper;
import com.conquestreforged.core.util.RenderLayer;
import com.conquestreforged.core.util.log.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BlockTemplate {

    private final State state;
    private final Model itemModel;
    private final Model[] blockModels;
    private final Recipe[] recipes;
    private final Render render;
    private final boolean plural;

    BlockTemplate(Class<?> type) {
        Assets assets = type.getAnnotation(Assets.class);
        this.state = assets != null ? assets.state() : null;
        this.itemModel = assets != null ? assets.item() : null;
        this.blockModels = assets != null ? assets.block() : null;
        this.recipes = assets != null ? assets.recipe() : null;
        this.render = BlockTemplate.getRender(type, assets);
        this.plural = state != null && state.plural();
    }

    public RenderLayer getRenderLayer() {
        if (render == null) {
            return RenderLayer.UNDEFINED;
        }
        return render.value();
    }

    public ResourceLocation getRegistryName(BlockName name) {
        if (state == null) {
            return new ResourceLocation(name.getNamespace(), name.format("%s", plural));
        }
        return new ResourceLocation(name.getNamespace(), name.format(state.name(), plural));
    }

    public void addClientResources(VirtualResourcepack.Builder builder, BlockName name, Textures textures, ResourceLocation regName) {
        addState(builder, name, regName);
        addItem(builder, name, regName);
        addModel(builder, name, textures, regName);
    }

    public void registerRenders(Block block, Props props) {
        if (props.getRenderLayer() != RenderLayer.UNDEFINED) {
            RenderLayerHelper.register(block, props.getRenderLayer());
            return;
        }

        if (render != null) {
            RenderLayer layer = render.value();
            RenderLayerHelper.register(block, layer);
        }
    }

    public void addServerResources(VirtualResourcepack.Builder builder, BlockName name, ResourceLocation regName) {
        addRecipe(builder, name, regName);
    }

    private void addState(VirtualResourcepack.Builder builder, BlockName name, ResourceLocation regName) {
        if (state == null) {
            Log.debug("No state template for {}", regName);
            return;
        }

        Log.debug("Generating state for {}", regName);

        String templateName = state.template();
        String virtualName = name.namespaceFormat(state.name(), state.plural());

        String templatePath = Locations.statePath(new ResourceLocation(templateName));
        String virtualPath = Locations.statePath(new ResourceLocation(virtualName));

        JsonTemplate template = TemplateCache.getInstance().get(templatePath);
        JsonOverride overrides = getOverrides(name, blockModels);
        builder.add(TemplateResource.asset(name.getNamespace(), virtualPath, overrides, template));
    }

    private void addModel(VirtualResourcepack.Builder builder, BlockName name, Textures textures, ResourceLocation regName) {
        if (blockModels == null) {
            Log.debug("No model template for {}", regName);
            return;
        }

        Log.debug("Generating model(s) for {}", regName);
        for (Model model : blockModels) {
            String templateName = model.template();
            String virtualName = name.namespaceFormat(model.name(), model.plural());

            String templatePath = Locations.modelPath(new ModelResourceLocation(templateName));
            String virtualPath = Locations.modelPath(new ModelResourceLocation(virtualName));

            JsonTemplate template = TemplateCache.getInstance().get(templatePath);
            builder.add(TemplateResource.asset(name.getNamespace(), virtualPath, textures, template));
        }
    }

    private void addItem(VirtualResourcepack.Builder builder, BlockName name, ResourceLocation regName) {
        if (itemModel == null) {
            Log.debug("No item model template for {}", regName);
            return;
        }

        Log.debug("Generating item model for {}", regName);
        String templateName = itemModel.template();
        String itemModelName = name.namespaceFormat(itemModel.name(), plural);
        String parentModelName = name.namespaceFormat(itemModel.parent(), plural);

        String templatePath = Locations.modelPath(new ModelResourceLocation(templateName));
        String virtualPath = Locations.modelPath(new ModelResourceLocation(itemModelName));

        JsonOverride overrides = new SingleOverride("parent", new JsonPrimitive(parentModelName));
        JsonTemplate template = TemplateCache.getInstance().get(templatePath);
        builder.add(TemplateResource.asset(name.getNamespace(), virtualPath, overrides, template));
    }

    private void addRecipe(VirtualResourcepack.Builder builder, BlockName name, ResourceLocation regName) {
        if (recipes == null || recipes.length != 1) {
            Log.debug("No recipe template for {}", regName);
            return;
        }

        Recipe recipe = recipes[0];
        String templateName = recipe.template();
        String recipeName = name.namespaceFormat(recipe.name(), plural);

        String output = recipe.output().isEmpty() ? recipe.template() : recipe.output();
        String item = new ResourceLocation(output).toString();
        Ingredient result = createIngredient(recipe.name(), item, plural);

        Ingredient[] ingredients = push(recipe.ingredients(), result);
        String templatePath = Locations.recipePath(new ResourceLocation(templateName));
        String virtualPath = Locations.recipePath(new ResourceLocation(recipeName));
        JsonOverride overrides = getOverrides(name, ingredients);
        if (overrides == EmptyOverride.EMPTY) {
            Log.error("Unable to generate recipe for {} (invalid ingredients)", regName);
            return;
        }

        Log.debug("Generating recipe for {}", regName);
        JsonTemplate template = TemplateCache.getInstance().get(templatePath);
        builder.add(TemplateResource.data(name.getNamespace(), virtualPath, overrides, template));
    }

    private JsonOverride getOverrides(BlockName name, Model[] replacements) {
        if (replacements.length == 0) {
            return EmptyOverride.EMPTY;
        }

        if (replacements.length == 1) {
            String find = replacements[0].template();
            String replace = name.namespaceFormat(replacements[0].name(), plural);
            return new SingleOverride("model", new JsonPrimitive(find), new JsonPrimitive(replace));
        }

        Map<JsonElement, JsonElement> overrides = new HashMap<>(replacements.length);
        for (Model model : replacements) {
            String find = model.template();
            String replace = name.namespaceFormat(model.name(), model.plural());
            overrides.put(new JsonPrimitive(find), new JsonPrimitive(replace));
        }

        return new MapOverride("model", overrides);
    }

    private JsonOverride getOverrides(BlockName name, Ingredient[] ingredients) {
        if (ingredients.length == 0) {
            return EmptyOverride.EMPTY;
        }

        if (ingredients.length == 1) {
            String find = ingredients[0].template();
            String replace = getIngredient(name, ingredients[0]);
            if (replace.isEmpty()) {
                return EmptyOverride.EMPTY;
            }
            return new SingleOverride("item", new JsonPrimitive(find), new JsonPrimitive(replace));
        }

        Map<JsonElement, JsonElement> overrides = new HashMap<>(ingredients.length);
        for (Ingredient ingredient : ingredients) {
            String find = new ResourceLocation(ingredient.template()).toString();
            String replace = getIngredient(name, ingredient);
            if (replace.isEmpty()) {
                return EmptyOverride.EMPTY;
            }
            overrides.put(new JsonPrimitive(find), new JsonPrimitive(replace));
        }

        return new MapOverride("item", overrides);
    }

    private String getIngredient(BlockName name, Ingredient ingredient) {
        String itemName = name.format(ingredient.name(), ingredient.plural());
        if (ForgeRegistries.ITEMS.containsKey(new ResourceLocation(name.getNamespace(), itemName))) {
            Log.debug(" Found ingredient {}:{}", name.getNamespace(), itemName);
            return name.getNamespace() + ':' + itemName;
        }
        if (ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName))) {
            Log.debug(" Found vanilla ingredient minecraft:{}", itemName);
            return "minecraft:" + itemName;
        }
        Log.error(" Unknown ingredient {}", itemName);
        return "";
    }

    private <T> T[] push(T[] t, T value) {
        T[] array = Arrays.copyOf(t, t.length + 1);
        array[array.length - 1] = value;
        return array;
    }

    private static Render getRender(Class<?> type, @Nullable Assets assets) {
        while (type != Object.class) {
            // annotation on the class overrides any in the assets annotation
            Render render = type.getAnnotation(Render.class);
            if (render != null) {
                return render;
            }

            // if assets exists and render has been defined, use it
            if (assets != null && assets.render().value() != RenderLayer.UNDEFINED) {
                return assets.render();
            }

            // get super class & it's Asset annotation
            type = type.getSuperclass();
            assets = type.getAnnotation(Assets.class);
        }
        return null;
    }

    private static Ingredient createIngredient(String name, String template, boolean plrual) {
        return new Ingredient() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return Ingredient.class;
            }

            @Override
            public String name() {
                return name;
            }

            @Override
            public String template() {
                return template;
            }

            @Override
            public boolean plural() {
                return plrual;
            }
        };
    }
}
