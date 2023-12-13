package com.conquestreforged.entities.painting;

import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.entities.EntityTypes;
import com.conquestreforged.entities.painting.art.ArtType;
import com.conquestreforged.entities.painting.art.ModArt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

/**
 * @author dags <dags@dags.me>
 */
public class EntityPainting extends HangingEntity implements IEntityAdditionalSpawnData {

    private ModPainting type;
    private ArtType art = ArtType.A1x1_0;

    public EntityPainting(EntityType<EntityPainting> type, Level world) {
        super(type, world);
    }

    public EntityPainting(Level world, BlockPos pos, Direction facing, ModPainting type, ArtType art) {
        super(EntityTypes.PAINTING, world, pos);
        this.direction = facing;
        this.type = type;
        this.art = art;
        this.setDirection(facing);
    }

    public ModPainting getPaintingType() {
        return type;
    }

    public ArtType getArt() {
        return art;
    }

    public void setType(ModPainting type) {
        this.type = type;
    }

    public void setArt(ArtType art) {
        this.art = art;
        if (direction != null) {
            setDirection(direction);
        }
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        return type.createStack(ModArt.of(art));
    }

    @Override
    public void dropItem(@Nullable Entity brokenEntity) {
        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            this.playSound(SoundEvents.PAINTING_BREAK, 1.0F, 1.0F);

            if (brokenEntity instanceof Player) {
                Player entityplayer = (Player) brokenEntity;

                if (entityplayer.getAbilities().instabuild) {
                    return;
                }
            }

            ItemStack drop = type.createStack(ModArt.of(art));
            ;
            if (drop != ItemStack.EMPTY) {
                this.spawnAtLocation(drop, 0.0F);
            }
        }
    }

    @Override
    public boolean survives() {
        return true;
    }

    @Override
    public int getWidth() {
        return this.art.sizeX;
    }

    @Override
    public int getHeight() {
        return this.art.sizeY;
    }

    @Override
    public void playPlacementSound() {
        this.playSound(SoundEvents.PAINTING_PLACE, 1.0F, 1.0F);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putByte("Facing", (byte)this.direction.get2DDataValue());
        super.addAdditionalSaveData(compound);
        compound.putString(Art.TYPE_TAG, this.type.getName());
        compound.putInt(Art.ART_TAG, this.art.index());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        String type = compound.getString(Art.TYPE_TAG);
        int id = compound.getInt(Art.ART_TAG);
        this.type = ModPainting.fromId(type);
        this.art = ArtType.fromId(id);
        this.direction = Direction.from2DDataValue(compound.getByte("Facing"));
        super.readAdditionalSaveData(compound);
        this.setDirection(this.direction);
    }

    @Override
    public void moveTo(double x, double y, double z, float yaw, float pitch) {
        this.setPos(x, y, z);
    }

    @Override
    public void lerpTo(double x, double y, double z, float a, float b, int c, boolean d) {
        BlockPos pos = this.pos;//.add(x - getPosX(), y - getPosY(), z - getPosZ());
        this.setPos(pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void writeSpawnData(FriendlyByteBuf buffer) {
        buffer.writeInt(pos.getX());
        buffer.writeInt(pos.getY());
        buffer.writeInt(pos.getZ());
        buffer.writeInt(direction.get2DDataValue());
        buffer.writeUtf(getPaintingType().getName());
        buffer.writeUtf(getArt().shapeId);
    }

    @Override
    public void readSpawnData(FriendlyByteBuf additionalData) {
        int x = additionalData.readInt();
        int y = additionalData.readInt();
        int z = additionalData.readInt();
        int index = additionalData.readInt();
        String type = additionalData.readUtf();
        String art = additionalData.readUtf();
        this.type = ModPainting.fromId(type);
        this.art = ArtType.fromName(art);
        this.direction = Direction.from2DDataValue(index);
        this.setDirection(Direction.from2DDataValue(index));
        this.setPos(x, y, z);
    }
}
