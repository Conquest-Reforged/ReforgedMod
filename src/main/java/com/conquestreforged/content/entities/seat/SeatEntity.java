package com.conquestreforged.content.entities.seat;

import com.conquestreforged.content.blocks.block.decor.ChairHalf;
import com.conquestreforged.content.blocks.block.decor.ChairHalfSmall;
import com.conquestreforged.content.entities.EntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SeatEntity extends Entity {

    private BlockState seat;

    public SeatEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    public SeatEntity(World world) {
        this(EntityTypes.SEAT, world);
    }

    @Override
    public boolean collidesWith(Entity entity) {
        return false;
    }

    @Override
    public double getMountedHeightOffset() {
        if (getSeat().getBlock() instanceof ChairHalfSmall) {
            return 0.175D;
        } else if (getSeat().getBlock() instanceof ChairHalf) {
            return 0.30D;
        } else {
            return 0.45D;
        }
    }

    @Override
    public float getTargetingMargin() {
        return 0.0f;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + getSeat().hashCode();
    }

    @Override
    public boolean canHit() {
        return false;
    }

    @Override
    public void move(MovementType type, Vec3d pos) {

    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {

    }


    public boolean shouldRiderSit() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (world.isClient) {
            return;
        }
        if (getSeat().isAir() || !this.hasPassengers()) {
            kill();
        }
    }

    @Override
    protected boolean canStartRiding(Entity entity) {
        return entity instanceof PlayerEntity;
    }

    @Override
    protected void checkBlockCollision() {

    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound p_70037_1_) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound p_213281_1_) {

    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    public BlockState getSeat() {
        if (this.seat == null) {
            this.seat = getEntityWorld().getBlockState(getBlockPos());
        }
        return this.seat;
    }
}
