package com.conquestreforged.core.block.factory;

import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.factory.constructor.*;
import com.conquestreforged.core.util.cache.Cache;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.DyeColor;

import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

public class BlockTypeCache extends Cache<Class<? extends Block>, BlockType> {

    private static final BlockTypeCache instance = new BlockTypeCache();

    private final List<Entry> entries = new LinkedList<>();

    private BlockTypeCache() {
        register(PropsConstructor::new, Props.class);
        register(BaseConstructor::new, Block.Settings.class);
        register(DyeConstructor::new, DyeColor.class, Block.Settings.class);
        register(BlockConstructor::new, Block.class, Block.Settings.class);
        register(StateConstructor::new, BlockState.class, Block.Settings.class);
    }

    @Override
    public BlockType compute(Class<? extends Block> type) {
        for (Entry factory : entries) {
            try {
                Constructor<? extends Block> constructor = type.getConstructor(factory.argTypes);
                constructor.setAccessible(true);
                return factory.factory.create(constructor);
            } catch (NoSuchMethodException ignored) {

            }
        }
        throw new InitializationException("constructor not found for type " + type);
    }

    public void register(BlockType.Factory factory, Class<?>... argTypes) {
        entries.add(new Entry(factory, argTypes));
    }

    public static BlockTypeCache getInstance() {
        return instance;
    }

    private static class Entry {

        private final Class<?>[] argTypes;
        private final BlockType.Factory factory;

        private Entry(BlockType.Factory factory, Class<?>[] argTypes) {
            this.argTypes = argTypes;
            this.factory = factory;
        }
    }
}
