package com.conquestrefabricated.content.blocks.tileentity.seat;

import com.conquestrefabricated.content.blocks.tileentity.TileEntityTypes;
import com.conquestrefabricated.content.entities.seat.SeatEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class SeatTileEntity extends BlockEntity {

    private double height;

    public SeatTileEntity(BlockPos blockPos, BlockState blockState) {
        super(TileEntityTypes.SEAT, blockPos, blockState);
    }

    @Override
    public void markRemoved() {
        super.markRemoved();
    }

    public boolean rideSeat(PlayerEntity player) {
        if(world.isClient)
            return false;
        final var seat = new SeatEntity(this.world);
        seat.updatePositionAndAngles(
                this.pos.getX() + 0.5D,
                this.pos.getY(),
                this.pos.getZ() + 0.5D,
                getCachedState().contains(HorizontalFacingBlock.FACING) ?
                        getCachedState().get(HorizontalFacingBlock.FACING).asRotation() : 0,
                0.0f);
        this.world.spawnEntity(seat);
        player.startRiding(seat, true);
        return true;
    }

}
