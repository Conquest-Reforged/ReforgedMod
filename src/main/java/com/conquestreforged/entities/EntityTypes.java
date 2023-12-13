package com.conquestreforged.entities;

import com.conquestreforged.entities.painting.EntityPainting;
import com.conquestreforged.entities.seat.SeatEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;

public class EntityTypes {

    private EntityTypes() {

    }

    public static final EntityType<EntityPainting> PAINTING = build(
            "conquest:painting",
            EntityType.Builder.<EntityPainting>of(EntityPainting::new, MobCategory.MISC).sized(0.5F, 0.5F)
    );

    public static final EntityType<SeatEntity> SEAT = build(
            "conquest:seat",
            EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC).sized(0, 0)
    );

    private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder) {
        EntityType<T> type = builder.build(name);
        type.setRegistryName(name);
        return type;
    }
}
