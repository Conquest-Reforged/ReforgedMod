package com.conquestreforged.content.entities.painting;

import com.conquestreforged.api.painting.art.Art;
import com.conquestreforged.content.entities.EntityTypes;
import com.conquestreforged.content.entities.painting.art.ArtType;
import com.conquestreforged.content.entities.painting.art.ModArt;
import io.github.fabricators_of_create.porting_lib.entity.ExtraSpawnDataEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * @author dags <dags@dags.me>
 */
public class EntityPainting extends AbstractDecorationEntity implements ExtraSpawnDataEntity {
    private ModPainting type;
    private ArtType art = ArtType.A1x1_0;

    public EntityPainting(EntityType<EntityPainting> type, World world) {
        super(type, world);
    }

    public EntityPainting(World world, BlockPos pos, Direction facing, ModPainting type, ArtType art) {
        super(EntityTypes.PAINTING, world, pos);
        this.facing = facing;
        this.type = type;
        this.art = art;
        this.setFacing(facing);
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
        if (facing != null) {
            setFacing(facing);
        }
    }

    @Nullable
    @Override
    public ItemStack getPickBlockStack() {
        return type.createStack(ModArt.of(art));
    }

    @Override
    public void onBreak(@Nullable Entity brokenEntity) {
        if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
            this.playSound(SoundEvents.ENTITY_PAINTING_BREAK, 1.0F, 1.0F);

            if (brokenEntity instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity) brokenEntity;

                if (entityplayer.getAbilities().creativeMode) {
                    return;
                }
            }

            ItemStack drop = type.createStack(ModArt.of(art));
            ;
            if (drop != ItemStack.EMPTY) {
                this.dropStack(drop, 0.0F);
            }
        }
    }

    @Override
    public boolean canStayAttached() {
        return true;
    }

    @Override
    public int getWidthPixels() {
        return this.art.sizeX;
    }

    @Override
    public int getHeightPixels() {
        return this.art.sizeY;
    }

    @Override
    public void onPlace() {
        this.playSound(SoundEvents.ENTITY_PAINTING_PLACE, 1.0F, 1.0F);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound compound) {
        compound.putByte("Facing", (byte)this.facing.getHorizontal());
        super.writeCustomDataToNbt(compound);
        compound.putString(Art.TYPE_TAG, this.type.getName());
        compound.putInt(Art.ART_TAG, this.art.index());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound compound) {
        String type = compound.getString(Art.TYPE_TAG);
        int id = compound.getInt(Art.ART_TAG);
        this.type = ModPainting.fromId(type);
        this.art = ArtType.fromId(id);
        this.facing = Direction.fromHorizontal(compound.getByte("Facing"));
        super.readCustomDataFromNbt(compound);
        this.setFacing(this.facing);
    }

    @Override
    public void refreshPositionAndAngles(double x, double y, double z, float yaw, float pitch) {
        this.setPosition(x, y, z);
    }

    @Override
    public void updateTrackedPositionAndAngles(double x, double y, double z, float a, float b, int c, boolean d) {
        BlockPos pos = this.attachmentPos;//.add(x - getPosX(), y - getPosY(), z - getPosZ());
        this.setPosition(pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return ExtraSpawnDataEntity.createExtraDataSpawnPacket(this);
    }

    @Override
    public void writeSpawnData(PacketByteBuf buffer) {
        buffer.writeInt(attachmentPos.getX());
        buffer.writeInt(attachmentPos.getY());
        buffer.writeInt(attachmentPos.getZ());
        buffer.writeInt(facing.getHorizontal());
        buffer.writeString(getPaintingType().getName());
        buffer.writeString(getArt().shapeId);
    }

    @Override
    public void readSpawnData(PacketByteBuf additionalData) {
        int x = additionalData.readInt();
        int y = additionalData.readInt();
        int z = additionalData.readInt();
        int index = additionalData.readInt();
        String type = additionalData.readString();
        String art = additionalData.readString();
        this.type = ModPainting.fromId(type);
        this.art = ArtType.fromName(art);
        this.facing = Direction.fromHorizontal(index);
        this.setFacing(Direction.fromHorizontal(index));
        this.setPosition(x, y, z);
    }


}
