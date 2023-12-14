package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.block.directional.HorizontalDirectionalWaterlogged;
import com.conquestreforged.content.blocks.tileentity.seat.SeatTileEntity;
import com.conquestreforged.content.entities.seat.SeatEntity;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Render(RenderLayer.CUTOUT)
public class ChairNoToggle extends HorizontalDirectionalWaterlogged implements BlockEntityProvider {

    public ChairNoToggle(Props properties) {
        super(properties);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        final var seat = (SeatTileEntity) level.getBlockEntity(blockPos);
        if (!player.isSneaking() && !level.isClient) {
            List<SeatEntity> seats = level.getNonSpectatingEntities(SeatEntity.class, new Box(blockPos));
            if(!seats.isEmpty()) {
                SeatEntity seatEntity = seats.get(0);
                List<Entity> passengers = seatEntity.getPassengerList();
                if (!passengers.isEmpty() && passengers.get(0) instanceof PlayerEntity) {
                    return super.onUse(state, level, blockPos, player, hand, hitResult);
                }
                seatEntity.removeAllPassengers();
                final boolean success = player.startRiding(seatEntity);
                if (success) {
                    level.updateNeighbors(blockPos, this);
                    seat.markDirty();
                }
                return success ? ActionResult.SUCCESS : ActionResult.PASS;
            }
            final boolean success = seat.rideSeat(player);
            if (success) {
                level.updateNeighbors(blockPos, this);
                seat.markDirty();
            }
            return success ? ActionResult.SUCCESS : ActionResult.PASS;
        }
        return super.onUse(state, level, blockPos, player, hand, hitResult);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SeatTileEntity(blockPos, blockState);
    }
}