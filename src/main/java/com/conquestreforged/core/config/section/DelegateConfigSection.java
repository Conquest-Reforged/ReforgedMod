package com.conquestreforged.core.config.section;


import com.conquestreforged.core.config.Config;
import com.electronwill.nightconfig.core.CommentedConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class DelegateConfigSection implements ConfigSection {

    private final String name;
    private final Supplier<Config> supplier;

    private Config config = null;

    public DelegateConfigSection(String name, Supplier<Config> supplier) {
        this.name = name;
        this.supplier = supplier;
    }

    @Override
    public void save() {
        getConfig().save();
    }

    @Override
    public CommentedConfig getRoot() {
        return getConfig().getRoot();
    }

    @Override
    public List<String> getPath(String path) {
        return Arrays.asList(name, path);
    }

    @Override
    public List<String> getPath(List<String> path) {
        List<String> list = new ArrayList<>(path.size() + 1);
        list.add(name);
        list.addAll(path);
        return list;
    }

    private Config getConfig() {
        if (config == null) {
            config = supplier.get();
        }
        return config;
    }
}
