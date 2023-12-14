package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.tileentity.seat.SeatTileEntity;
import com.conquestreforged.content.entities.seat.SeatEntity;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.properties.ParallelConnectionShape2;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Render(RenderLayer.CUTOUT)
public class BenchParallelConnecting extends TableParallelConnecting implements BlockEntityProvider {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 10.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 12.0D, 12.0D);
    public static final VoxelShape SHAPE_EAST = Block.createCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 12.0D, 16.0D);

    public static final EnumProperty<ParallelConnectionShape2> FORM = EnumProperty.of("shape", ParallelConnectionShape2.class);

    public BenchParallelConnecting(Props props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
            default:
            case NORTH:
            case SOUTH:
                return SHAPE_NORTH;
            case EAST:
            case WEST:
                return SHAPE_EAST;
        }
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
