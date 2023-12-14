package com.conquestreforged.content.entities.painting;

import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.api.painting.vanilla.VanillaArt;
import com.conquestreforged.content.entities.painting.art.ArtType;
import com.conquestreforged.content.entities.painting.art.ModArt;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public interface PaintingFactory<T extends AbstractDecorationEntity> {

    T create(World world, BlockPos pos, Direction side, String typeName, String artName);

    PaintingFactory<EntityPainting> MOD = (world, pos, side, typeName, artName) -> {
        ModPainting type = ModPainting.fromName(typeName);
        Art<ArtType> art = ModArt.fromName(artName);
        if (type == null || art == null) {
            return null;
        }
        return new EntityPainting(world, pos, side, type, art.getReference());
    };

    PaintingFactory<PaintingEntity> VANILLA = (world, pos, side, typeName, artName) -> {
        Art<PaintingVariant> art = VanillaArt.fromName(artName);
        if (art == null) {
            return new PaintingEntity(world, pos, side, Registry.PAINTING_VARIANT.createEntry(art.getReference()));
        } else {
            PaintingEntity painting = new PaintingEntity(world, pos, side, Registry.PAINTING_VARIANT.getEntry(Registry.PAINTING_VARIANT.getRawId(art.getReference())).get());
            // can only set the art after creation on the server side
            //painting.motive = art.getReference();
            // setPosition triggers a recalculation of the entity bounding box so should allow it to hang correctly
            painting.setPosition(pos.getX(), pos.getY(), pos.getZ());
            return painting;
        }
    };
}
