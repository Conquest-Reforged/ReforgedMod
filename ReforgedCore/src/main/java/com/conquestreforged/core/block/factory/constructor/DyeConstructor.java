package com.conquestreforged.core.block.factory.constructor;

import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.factory.InitializationException;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.Constructor;

public class DyeConstructor extends PropsConstructor {

    public DyeConstructor(Constructor<? extends Block> constructor) {
        super(constructor);
    }

    @Override
    public Block create(Props props) throws InitializationException {
        return newInstance(props.dye(), props.toProperties());
    }
}
