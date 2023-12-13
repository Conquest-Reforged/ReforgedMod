package com.conquestrefabricated.core.block.factory;

import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.Block;

import java.lang.reflect.Constructor;

public interface BlockType {

    Block create(Props props) throws InitializationException;

    interface Factory {

        BlockType create(Constructor<? extends Block> constructor);
    }
}
