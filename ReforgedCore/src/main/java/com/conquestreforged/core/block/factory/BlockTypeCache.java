package com.conquestreforged.core.block.factory;

import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.factory.constructor.BaseConstructor;
import com.conquestreforged.core.block.factory.constructor.BlockConstructor;
import com.conquestreforged.core.block.factory.constructor.DyeConstructor;
import com.conquestreforged.core.block.factory.constructor.PropsConstructor;
import com.conquestreforged.core.block.factory.constructor.StateConstructor;
import com.conquestreforged.core.util.cache.Cache;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.DyeColor;

import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

public class BlockTypeCache extends Cache<Class<? extends Block>, BlockType> {

    private static final BlockTypeCache instance = new BlockTypeCache();

    private final List<Entry> entries = new LinkedList<>();

    private BlockTypeCache() {
        register(PropsConstructor::new, Props.class);
        register(BaseConstructor::new, Block.Properties.class);
        register(DyeConstructor::new, DyeColor.class, Block.Properties.class);
        register(BlockConstructor::new, Block.class, Block.Properties.class);
        register(StateConstructor::new, BlockState.class, Block.Properties.class);
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
