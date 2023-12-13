package com.conquestreforged.client.gui.dependency;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DependencyList {

    private final List<Dependency> dependencies;

    public DependencyList(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    public List<Dependency> getMissingDependencies() {
        List<Dependency> result = new ArrayList<>();
        for (Dependency dependency : dependencies) {
            if (!dependency.getType().isAvailable(dependency)) {
                result.add(dependency);
            }
        }
        return result;
    }

    public static DependencyList load() {
        try (Reader reader = new BufferedReader(new InputStreamReader(DependencyList.class.getResourceAsStream("/dependencies.json")))) {
            JsonElement element = new JsonParser().parse(reader);
            if (element.isJsonArray()) {
                List<Dependency> dependencies = new ArrayList<>();
                for (JsonElement e : element.getAsJsonArray()) {
                    if (e.isJsonObject()) {
                        JsonObject root = e.getAsJsonObject();
                        DependencyType type = DependencyType.of(root.get("type").getAsString());
                        String id = root.get("id").getAsString();
                        String name = root.get("name").getAsString();
                        String url = root.get("url").getAsString();
                        dependencies.add(new Dependency(type, id, name, url));
                    }
                }
                return new DependencyList(dependencies);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DependencyList(Collections.emptyList());
    }
}
