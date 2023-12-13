package com.conquestrefabricated.client.gui.search;

import com.conquestrefabricated.client.gui.search.query.Index;
import com.conquestrefabricated.client.gui.search.query.Result;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.TagKey;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Lazy;
import net.minecraft.util.registry.Registry;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SearchScreen extends Screen implements Consumer<String> {

    private static final float scale = 2F;
    private static final Lazy<Index<ItemStack>> index = new Lazy<>(SearchScreen::buildIndex);

    private final TextFieldWidget search;
    private final Index<ItemStack> itemIndex;
    private final SearchList searchList;

    public SearchScreen() {
        super(Text.literal("search"));
        this.search = new TextFieldWidget(MinecraftClient.getInstance().textRenderer, 0, 0, 200, 20, Text.translatable("Search"));
        this.search.setChangedListener(this);
        this.itemIndex = index.get();
        this.searchList = new SearchList(5, 6);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (!super.mouseClicked(mx, my, button)) {
            MinecraftClient.getInstance().setScreen(null);
            return false;
        }
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        check();
    }

    @Override
    protected void init() {
        addDrawableChild(search);
        int centerX = width / 2;
        search.x = centerX - (search.getWidth() / 2);
        search.y = 100;
        addSelectableChild(searchList);
    }

    @Override
    public void render(MatrixStack matrixStack, int mx, int my, float ticks) {
        update();
        super.renderBackground(matrixStack);
        super.render(matrixStack, mx, my, ticks);
        searchList.render(matrixStack, mx, my, width, height, ticks);
    }

    @Override
    public void accept(String term) {
        searchList.clear();
        itemIndex.parallelSearch(term, searchList.maxSize()).sequential().map(Result::getResult).forEach(searchList::add);
        if (searchList.size() == 0) {
            search.y = height / 2 - search.getHeight() / 2;
        } else {
            search.y = 20;
        }
    }

    private void update() {
        int pad = 8;
        int centerX = width / 2;
        int centerY = height / 2;
        int guiHeight = search.getHeight() + pad + searchList.getHeight();

        setFocused(search);
        search.setTextFieldFocused(true);
        search.x = centerX - search.getWidth() / 2;
        search.y = Math.max(10, centerY - guiHeight / 2);

        searchList.x = centerX - searchList.getWidth() / 2F;
        searchList.y = search.y + search.getHeight() + pad;
        searchList.scale = scale;
    }

    private void check() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null || !player.getAbilities().creativeMode) {
            MinecraftClient.getInstance().setScreen(null);
        }
    }

    private static Index<ItemStack> buildIndex() {
        Index.Builder<ItemStack> builder = Index.builder();
        for (Item item : Registry.ITEM.stream().toList()) {
            if (item == Items.AIR) {
                continue;
            }
            ItemStack stack = new ItemStack(item);
            builder.with(stack, stack.toHoverableText().getString(), getTags(stack));
        }
        return builder.build();
    }

    private static Collection<String> getTags(ItemStack item) {
        List<String> tags = new LinkedList<>();
        tags.add(Registry.ITEM.getId(item.getItem()).getPath());
        List<TagKey<Item>> itemTags = item.streamTags().collect(Collectors.toList());
        for (TagKey<Item> tag : itemTags) {
            tags.add(tag.id().getPath());
        }

        return tags;
    }
}
