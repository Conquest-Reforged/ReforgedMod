package com.conquestrefabricated.core.mixin;

import com.conquestrefabricated.core.interfaces.PackRepositoryAddPackFinder;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProvider;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Set;

@Mixin(ResourcePackManager.class)
public class PackRepositoryMixin implements PackRepositoryAddPackFinder {
    @Shadow @Final private Set<ResourcePackProvider> providers;

    @Override
    public synchronized void addPackFinder(ResourcePackProvider packFinder) {
        this.providers.add(packFinder);
    }
}
