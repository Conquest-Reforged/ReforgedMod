package com.conquestreforged.core.block.factory;

import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;

import java.lang.reflect.Constructor;

public interface BlockType {

    Block create(Props props) throws InitializationException;

    interface Factory {

        BlockType create(Constructor<? extends Block> constructor);
    }
}
