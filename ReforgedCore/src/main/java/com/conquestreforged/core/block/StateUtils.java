package com.conquestreforged.core.block;

import com.conquestreforged.core.block.factory.InitializationException;
import com.conquestreforged.core.item.ItemUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Optional;

public class StateUtils {

    public static Optional<BlockState> getOrDefault(ItemStack stack) {
        return toItemBlock(stack.getItem()).map(item -> fromStack(stack, item).orElse(item.getBlock().getDefaultState()));
    }

    public static Optional<BlockState> fromStack(ItemStack stack) {
        return toItemBlock(stack.getItem()).flatMap(item -> fromStack(stack, item));
    }

    public static Optional<BlockState> fromStack(ItemStack stack, BlockItem item) {
        CompoundNBT stackTag = stack.getTag();
        if (stackTag == null) {
            return Optional.of(item.getBlock().getDefaultState());
        }

        CompoundNBT stateTag = stackTag.getCompound("BlockStateTag");
        if (stateTag.isEmpty()) {
            return Optional.of(item.getBlock().getDefaultState());
        }

        BlockState state = item.getBlock().getDefaultState();
        StateContainer<Block, BlockState> container = item.getBlock().getStateContainer();

        for (String key : stateTag.keySet()) {
            IProperty<?> property = container.getProperty(key);
            if (property != null) {
                String s1 = stateTag.get(key).getString();
                state = StateUtils.with(state, property, s1);
            }
        }

        if (state == item.getBlock().getDefaultState()) {
            return Optional.empty();
        }

        return Optional.of(state);
    }

    public static Optional<BlockItem> toItemBlock(Item item) {
        return ItemUtils.toItem(item, BlockItem.class);
    }

    public static BlockState parse(String input) {
        int domainEnd = input.indexOf(':');
        String domain = domainEnd == -1 ? "minecraft" : input.substring(0, domainEnd);

        int nameEnd = input.indexOf('[');
        String name = nameEnd == -1 ? input.substring(domainEnd + 1) : input.substring(domainEnd + 1, nameEnd);

        Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(domain, name));
        if (block == null) {
            throw new InitializationException("invalid block " + input);
        }

        BlockState state = block.getDefaultState();
        for (int i = nameEnd + 1; i < input.length(); i++) {
            int keyStart = i;
            int keyEnd = indexOf(input, keyStart, '=');
            if (keyEnd == -1) {
                break;
            }

            int valStart = keyEnd + 1;
            int valEnd = indexOf(input, valStart, ',', ']');
            if (valEnd == -1) {
                break;
            }

            String key = input.substring(keyStart, keyEnd);
            String value = input.substring(valStart, valEnd);
            state = with(state, key, value);
            i = valEnd + 1;
        }

        return state;
    }

    private static int indexOf(String string, int from, char... chars) {
        for (char c : chars) {
            int i = string.indexOf(c, from);
            if (i != -1) {
                return i;
            }
        }
        return -1;
    }

    private static BlockState with(BlockState state, String key, String value) {
        IProperty<? extends Comparable> property = state.getBlock().getStateContainer().getProperty(key);
        if (property == null) {
            return state;
        }
        return with(state, property, value);
    }

    public static <T extends Comparable<T>> BlockState with(BlockState state, IProperty<T> property, String value) {
        return property.parseValue(value).map(t -> state.with(property, t)).orElse(state);
    }
}
