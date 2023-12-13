package com.conquestrefabricated.client.gui.palette.texture;

import com.conquestrefabricated.core.util.OptionalValue;

import java.util.Collections;
import java.util.List;

public class ItemGroup implements OptionalValue {

    protected static final ItemGroup NONE = new ItemGroup(TextureGroup.NONE, Collections.emptyList());

    private final TextureGroup main;
    private final List<TextureGroup> groups;

    public ItemGroup(TextureGroup main, List<TextureGroup> groups) {
        this.main = main;
        this.groups = Collections.unmodifiableList(groups);
    }

    public TextureGroup getMain() {
        return main;
    }

    public List<TextureGroup> getGroups() {
        return groups;
    }

    @Override
    public boolean isAbsent() {
        return this == NONE;
    }
}
