package com.conquestrefabricated.core.block.data;

import com.conquestrefabricated.core.util.cache.Cache;

public class BlockTemplateCache extends Cache<Class<?>, BlockTemplate> {

    private static final BlockTemplateCache instance = new BlockTemplateCache();

    private BlockTemplateCache() {

    }

    @Override
    public BlockTemplate compute(Class<?> type) {
        return new BlockTemplate(type);
    }

    public static BlockTemplateCache getInstance() {
        return instance;
    }
}
