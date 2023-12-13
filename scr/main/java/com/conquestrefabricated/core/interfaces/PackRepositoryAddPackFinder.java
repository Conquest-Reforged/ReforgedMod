package com.conquestrefabricated.core.interfaces;

import net.minecraft.resource.ResourcePackProvider;

public interface PackRepositoryAddPackFinder {

    default void addPackFinder(ResourcePackProvider packFinder) {}

}
