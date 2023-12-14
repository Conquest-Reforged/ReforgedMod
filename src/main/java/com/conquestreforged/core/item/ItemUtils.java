package com.conquestreforged.core.item;

import com.conquestreforged.core.item.family.Family;
import com.conquestreforged.core.item.family.FamilyRegistry;
import com.conquestreforged.core.item.family.TypeFilter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class ItemUtils {

    public static final String BLOCK_STATE_TAG = "BlockStateTag";

    public static ItemStack fromState(BlockState state) {
        ItemStack stack = new ItemStack(state.getBlock());
        NbtCompound data = stack.getOrCreateSubNbt(BLOCK_STATE_TAG);
        for (Map.Entry<Property<?>, ?> e : state.getEntries().entrySet()) {
            data.putString(e.getKey().getName(), e.getValue().toString());
        }
        return stack;
    }

    public static ItemStack fromState(BlockState state, Property<?> property) {
        String value = state.get(property).toString();
        ItemStack stack = new ItemStack(state.getBlock());
        stack.getOrCreateSubNbt(BLOCK_STATE_TAG).putString(property.getName(), value);
        stack.setCustomName(Text.of(stack.toHoverableText().getString() + (property.getName() + "=" + value)));
        return stack;
    }

    public static ItemStack fromState(BlockState state, Collection<Property<?>> properties) {
        StringBuilder name = new StringBuilder("[");
        ItemStack stack = new ItemStack(state.getBlock());
        NbtCompound stateTag = stack.getOrCreateSubNbt(BLOCK_STATE_TAG);
        for (Property<?> property : properties) {
            if (state.contains(property)) {
                String value = state.get(property).toString();
                stateTag.putString(property.getName(), value);
                if (name.length() > 1) {
                    name.append(',');
                }
                name.append(property.getName()).append('=').append(value);
            }
        }
        if (name.length() > 1) {
            name.append("]");
            stack.setCustomName(Text.of(stack.toHoverableText().getString() + name.toString()));
        }
        return stack;
    }

    public static <T extends Item> Optional<T> toItem(Item item, Class<T> t) {
        return t.isInstance(item) ? Optional.of(t.cast(item)) : Optional.empty();
    }

    public static DefaultedList<ItemStack> getFamilyItems(ItemStack stack) {
        return getFamilyItems(stack, TypeFilter.ANY);
    }

    public static DefaultedList<ItemStack> getFamilyItems(ItemStack stack, TypeFilter filter) {
        DefaultedList<ItemStack> items = DefaultedList.of();
        getFamily(stack).addAllItems(ItemGroup.SEARCH, items, filter);
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
