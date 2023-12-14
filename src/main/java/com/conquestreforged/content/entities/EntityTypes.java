package com.conquestreforged.content.entities;

import com.conquestreforged.content.entities.painting.EntityPainting;
import com.conquestreforged.content.entities.seat.SeatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public class EntityTypes {

    public static void entityTypesInit() {

    }

    public static final EntityType<EntityPainting> PAINTING = build(
            "conquest:painting",
            EntityType.Builder.<EntityPainting>create(EntityPainting::new, SpawnGroup.MISC).setDimensions(0.5F, 0.5F)
    );

    public static final EntityType<SeatEntity> SEAT = build(
            "conquest:seat",
            EntityType.Builder.<SeatEntity>create(SeatEntity::new, SpawnGroup.MISC).setDimensions(0, 0)
    );

    private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder) {
        EntityType<T> type = builder.build(name);
        return type;
    }
}
