package com.conquestreforged.core.item;

import com.conquestreforged.core.item.family.Family;
import com.conquestreforged.core.item.family.FamilyRegistry;
import com.conquestreforged.core.item.family.TypeFilter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.TextComponent;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class ItemUtils {

    public static final String BLOCK_STATE_TAG = "BlockStateTag";

    public static ItemStack fromState(BlockState state) {
        ItemStack stack = new ItemStack(state.getBlock());
        CompoundTag data = stack.getOrCreateTagElement(BLOCK_STATE_TAG);
        for (Map.Entry<Property<?>, ?> e : state.getValues().entrySet()) {
            data.putString(e.getKey().getName(), e.getValue().toString());
        }
        return stack;
    }

    public static ItemStack fromState(BlockState state, Property<?> property) {
        String value = state.getValue(property).toString();
        ItemStack stack = new ItemStack(state.getBlock());
        stack.getOrCreateTagElement(BLOCK_STATE_TAG).putString(property.getName(), value);
        stack.setHoverName(new TextComponent(stack.getDisplayName() + (property.getName() + "=" + value)));
        return stack;
    }

    public static ItemStack fromState(BlockState state, Collection<Property<?>> properties) {
        StringBuilder name = new StringBuilder("[");
        ItemStack stack = new ItemStack(state.getBlock());
        CompoundTag stateTag = stack.getOrCreateTagElement(BLOCK_STATE_TAG);
        for (Property<?> property : properties) {
            if (state.hasProperty(property)) {
                String value = state.getValue(property).toString();
                stateTag.putString(property.getName(), value);
                if (name.length() > 1) {
                    name.append(',');
                }
                name.append(property.getName()).append('=').append(value);
            }
        }
        if (name.length() > 1) {
            name.append("]");
            stack.setHoverName(new TextComponent(stack.getDisplayName() + name.toString()));
        }
        return stack;
    }

    public static <T extends Item> Optional<T> toItem(Item item, Class<T> t) {
        return t.isInstance(item) ? Optional.of(t.cast(item)) : Optional.empty();
    }

    public static NonNullList<ItemStack> getFamilyItems(ItemStack stack) {
        return getFamilyItems(stack, TypeFilter.ANY);
    }

    public static NonNullList<ItemStack> getFamilyItems(ItemStack stack, TypeFilter filter) {
        NonNullList<ItemStack> items = NonNullList.create();
        getFamily(stack).addAllItems(CreativeModeTab.TAB_SEARCH, items, filter);
        if (items.isEmpty()) {
            items.add(stack);
        }
        return items;
    }

    public static Family<Block> getFamily(ItemStack stack) {
        Item item = stack.getItem();
        Block block = Blocks.AIR;
        if (item instanceof BlockItem) {
            block = ((BlockItem) item).getBlock();
        }
        return FamilyRegistry.BLOCKS.getFamily(block);
    }
}
