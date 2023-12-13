package com.conquestreforged.core.block.data;

import com.conquestreforged.core.asset.annotation.Item;
import com.conquestreforged.core.util.cache.Cache;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;

public class ItemTypeCache extends Cache<Class<? extends Block>, Class<? extends net.minecraft.world.item.Item>> {

    private static final ItemTypeCache instance = new ItemTypeCache();

    public static ItemTypeCache getInstance() {
        return instance;
    }

    @Override
    public Class<? extends net.minecraft.world.item.Item> compute(Class<? extends Block> aClass) {
        Item type = aClass.getAnnotation(Item.class);
        if (type == null) {
            return BlockItem.class;
        }
        return type.value();
    }
}
