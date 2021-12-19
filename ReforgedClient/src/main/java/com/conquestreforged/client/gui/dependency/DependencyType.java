package com.conquestreforged.client.gui.dependency;

import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.repository.Pack;
import net.minecraftforge.fml.ModList;

import java.io.IOException;

public enum DependencyType {
    UNKNOWN {
        @Override
        public boolean isAvailable(Dependency dependency) {
            return true;
        }
    },
    MOD {
        @Override
        public boolean isAvailable(Dependency dependency) {
            return ModList.get().isLoaded(dependency.getId());
        }
    },
    LIB {
        @Override
        public boolean isAvailable(Dependency dependency) {
            try {
                Class.forName(dependency.getId());
                return true;
            } catch (ClassNotFoundException e) {
                return false;
            }
        }
    },
    RESOURCEPACK {
        @Override
        public boolean isAvailable(Dependency dependency) {
            for (Pack pack : Minecraft.getInstance().getResourcePackRepository().getSelectedPacks()) {
                try {
                    Object packId = pack.open().getMetadataSection(PackIdDeserializer.INSTANCE);
                    if (dependency.getId().equalsIgnoreCase(packId + "")) {
                        return true;
                    }
                } catch (IOException ignored) {

                }
            }
            return false;
        }
    },
    ;

    public abstract boolean isAvailable(Dependency dependency);

    static DependencyType of(String name) {
        for (DependencyType type : DependencyType.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
