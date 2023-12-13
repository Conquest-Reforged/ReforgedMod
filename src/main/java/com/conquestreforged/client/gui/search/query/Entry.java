package com.conquestreforged.client.gui.search.query;

/**
 * @author dags <dags@dags.me>
 */
public class Entry<T> {

    private final T value;
    private final String name;
    private final String tags;

    public Entry(T value, String name, String tags) {
        this.value = value;
        this.name = name.toLowerCase();
        this.tags = tags;
    }

    public T getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getTags() {
        return tags;
    }
}
