package com.conquestreforged.client.gui.dependency;

public class Dependency {

    private final DependencyType type;
    private final String displayName;
    private final String id;
    private final String url;

    public Dependency(DependencyType type, String id, String displayName, String url) {
        this.type = type;
        this.id = id;
        this.url = url;
        this.displayName = displayName;
    }

    public DependencyType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getURL() {
        return url;
    }
}
