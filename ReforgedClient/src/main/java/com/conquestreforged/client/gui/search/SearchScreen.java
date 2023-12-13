package com.conquestreforged.client.gui.search;

import com.conquestreforged.client.gui.search.query.Index;
import com.conquestreforged.client.gui.search.query.Result;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class SearchScreen extends Screen implements Consumer<String> {

    private static final float scale = 2F;
    private static final LazyValue<Index<ItemStack>> index = new LazyValue<>(SearchScreen::buildIndex);

    private final TextFieldWidget search;
    private final Index<ItemStack> itemIndex;
    private final SearchList searchList;

    public SearchScreen() {
        super(new StringTextComponent("search"));
        this.search = new TextFieldWidget(Minecraft.getInstance().fontRenderer, 0, 0, 200, 20, "Search");
        this.search.setResponder(this);
        this.itemIndex = index.getValue();
        this.searchList = new SearchList(5, 6);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (!super.mouseClicked(mx, my, button)) {
            Minecraft.getInstance().displayGuiScreen(null);
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
        addButton(search);
        int centerX = width / 2;
        search.x = centerX - (search.getWidth() / 2);
        search.y = 100;
        children.add(searchList);
    }

    @Override
    public void render(int mx, int my, float ticks) {
        update();
        super.renderBackground();
        super.render(mx, my, ticks);
        searchList.render(mx, my, width, height, ticks);
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
        search.setFocused2(true);
        search.x = centerX - search.getWidth() / 2;
        search.y = Math.max(10, centerY - guiHeight / 2);

        searchList.x = centerX - searchList.getWidth() / 2F;
        searchList.y = search.y + search.getHeight() + pad;
        searchList.scale = scale;
    }

    private void check() {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player == null || !player.abilities.isCreativeMode) {
            Minecraft.getInstance().displayGuiScreen(null);
        }
    }

    private static Index<ItemStack> buildIndex() {
        Index.Builder<ItemStack> builder = Index.builder();
        for (Item item : ForgeRegistries.ITEMS.getValues()) {
            if (item == Items.AIR) {
                continue;
            }
            ItemStack stack = new ItemStack(item);
            builder.with(stack, stack.getDisplayName().getFormattedText(), getTags(item));
        }
        return builder.build();
    }

    private static Collection<String> getTags(Item item) {
        List<String> tags = new LinkedList<>();
        tags.add(item.getRegistryName().getPath());
        for (ResourceLocation tag : item.getTags()) {
            tags.add(tag.getPath());
        }
        return tags;
    }
}
