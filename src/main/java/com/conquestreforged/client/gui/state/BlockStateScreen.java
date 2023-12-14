package com.conquestreforged.client.gui.state;

import com.conquestreforged.client.gui.PickerScreen;
import com.conquestreforged.client.gui.render.Render;
import com.conquestreforged.core.item.ItemUtils;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Property;

import java.util.*;
import java.util.function.Predicate;

public class BlockStateScreen extends PickerScreen<BlockState> {

    private final Collection<Property<?>> properties;

    public BlockStateScreen(ItemStack stack, BlockState state, List<BlockState> states, Collection<Property<?>> properties) {
        super("State Selector", stack, state, states);
        this.properties = properties;
    }

    @Override
    public boolean match(BlockState a, BlockState b) {
        for (Property<?> property : properties) {
            if (!a.get(property).equals(b.get(property))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public int getYOffset() {
        return -30;
    }

    @Override
    public int getWidth(BlockState option) {
        return 1;
    }

    @Override
    public int getHeight(BlockState option) {
        return 1;
    }

    @Override
    public String getDisplayName(BlockState option) {
        StringBuilder sb = new StringBuilder();
        for (Property<?> property : properties) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(property.getName()).append('=').append(option.get(property));
        }
        return sb.toString();
    }

    @Override
    public void render(BlockState option, MatrixStack matrixStack, int x, int y, int width, int height, float scale) {
        matrixStack.push();
        matrixStack.translate(x + (width / 2F), y + (height / 2F), 0);
        matrixStack.scale(scale, scale, 1);
        Render.drawBlockModel(matrixStack, option, -8, -8, 1);
        matrixStack.pop();
    }

    @Override
    public ItemStack createItemStack(ItemStack original, BlockState value) {
        ItemStack stack = ItemUtils.fromState(value, properties);
        stack.setCount(original.getCount());
        return stack;
    }

    /**
     * @param stack  the current ItemStack
     * @param state  the BLockState derrived from the provided ItemStack
     * @param filter a filter of IProperties to ignore (true == ignore!)
     */
    public static Optional<BlockStateScreen> of(ItemStack stack, BlockState state, Predicate<Property<?>> filter) {
        Map<Property<?>, Object> defaults = new HashMap<>();
        Set<Property<?>> properties = new HashSet<>();

        for (Property<?> property : state.getProperties()) {
            if (filter.test(property)) {
                Object defValue = state.get(property);
                defaults.put(property, defValue);
            } else {
                properties.add(property);
            }
        }

        List<BlockState> states = new ArrayList<>();
        for (BlockState candidate : state.getBlock().getStateManager().getStates()) {
            boolean valid = true;
            for (Map.Entry<Property<?>, Comparable<?>> e : candidate.getEntries().entrySet()) {
                Object defValue = defaults.get(e.getKey());
                if (defValue != null && !defValue.equals(e.getValue())) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                states.add(candidate);
            }
        }

        if (states.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new BlockStateScreen(stack, state, states, properties));
    }
}
