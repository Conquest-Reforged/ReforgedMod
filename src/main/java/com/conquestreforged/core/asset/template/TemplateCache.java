package com.conquestreforged.core.asset.template;

import com.conquestreforged.core.util.cache.Cache;

public class TemplateCache extends Cache<String, JsonTemplate> {

    private static final TemplateCache instance = new TemplateCache();

    private TemplateCache() {
    }

    @Override
    public JsonTemplate compute(String location) {
        return new JsonTemplate(location);
    }

    public static TemplateCache getInstance() {
        return instance;
    }
}
