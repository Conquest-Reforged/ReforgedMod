package com.conquestreforged.blocks.tileentity.seat;

import com.conquestreforged.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.entities.seat.SeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SeatTileEntity extends BlockEntity {

    private double height;

    public SeatTileEntity(BlockPos blockPos, BlockState blockState) {
        super(TileEntityTypes.SEAT, blockPos, blockState);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
    }

    public boolean rideSeat(Player player) {
        if(level.isClientSide)
            return false;
        final var seat = new SeatEntity(this.level);
        seat.absMoveTo(
                this.worldPosition.getX() + 0.5D,
                this.worldPosition.getY(),
                this.worldPosition.getZ() + 0.5D,
                getBlockState().hasProperty(HorizontalDirectionalBlock.FACING) ?
                        getBlockState().getValue(HorizontalDirectionalBlock.FACING).toYRot() : 0,
                0.0f);
        this.level.addFreshEntity(seat);
        player.startRiding(seat, true);
        return true;
    }

}
