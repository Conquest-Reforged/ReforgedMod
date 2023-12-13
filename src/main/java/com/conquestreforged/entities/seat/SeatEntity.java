package com.conquestreforged.entities.seat;

import com.conquestreforged.blocks.block.decor.ChairHalf;
import com.conquestreforged.blocks.block.decor.ChairHalfSmall;
import com.conquestreforged.entities.EntityTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class SeatEntity extends Entity {

    private BlockState seat;

    public SeatEntity(EntityType<?> type, Level world) {
        super(type, world);
    }

    public SeatEntity(Level world) {
        this(EntityTypes.SEAT, world);
    }

    @Override
    public boolean canCollideWith(Entity entity) {
        return false;
    }

    @Override
    public double getPassengersRidingOffset() {
        if (getSeat().getBlock() instanceof ChairHalfSmall) {
            return 0.175D;
        } else if (getSeat().getBlock() instanceof ChairHalf) {
            return 0.30D;
        } else {
            return 0.45D;
        }
    }

    @Override
    public float getPickRadius() {
        return 0.0f;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + getSeat().hashCode();
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public void move(MoverType type, Vec3 pos) {

    }

    @Override
    public void playerTouch(Player player) {

    }


    @Override
    public boolean shouldRiderSit() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (level.isClientSide) {
            return;
        }
        if (getSeat().isAir() || !this.isVehicle()) {
            kill();
        }
    }

    @Override
    protected boolean canRide(Entity entity) {
        return entity instanceof Player;
    }

    @Override
    protected void checkInsideBlocks() {

    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_70037_1_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_213281_1_) {

    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public BlockState getSeat() {
        if (this.seat == null) {
            this.seat = getCommandSenderWorld().getBlockState(m_142538_());
        }
        return this.seat;
    }
}
