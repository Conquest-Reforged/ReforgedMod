package com.conquestreforged.entities.painting;

import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.api.painting.vanilla.VanillaArt;
import com.conquestreforged.entities.painting.art.ArtType;
import com.conquestreforged.entities.painting.art.ModArt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.level.Level;

public interface PaintingFactory<T extends HangingEntity> {

    T create(Level world, BlockPos pos, Direction side, String typeName, String artName);

    PaintingFactory<EntityPainting> MOD = (world, pos, side, typeName, artName) -> {
        ModPainting type = ModPainting.fromName(typeName);
        Art<ArtType> art = ModArt.fromName(artName);
        if (type == null || art == null) {
            return null;
        }
        return new EntityPainting(world, pos, side, type, art.getReference());
    };

    PaintingFactory<Painting> VANILLA = (world, pos, side, typeName, artName) -> {
        Art<Motive> art = VanillaArt.fromName(artName);
        if (art == null) {
            return new Painting(world, pos, side);
        } else {
            Painting painting = new Painting(world, pos, side);
            // can only set the art after creation on the server side
            painting.f_31902_ = art.getReference();
            // setPosition triggers a recalculation of the entity bounding box so should allow it to hang correctly
            painting.setPos(pos.getX(), pos.getY(), pos.getZ());
            return painting;
        }
    };
}
