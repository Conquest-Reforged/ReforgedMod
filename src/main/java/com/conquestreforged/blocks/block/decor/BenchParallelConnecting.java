package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.tileentity.seat.SeatTileEntity;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.properties.ParallelConnectionShape2;
import com.conquestreforged.core.util.RenderLayer;
import com.conquestreforged.entities.seat.SeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Render(RenderLayer.CUTOUT)
public class BenchParallelConnecting extends TableParallelConnecting implements EntityBlock {

    protected static final VoxelShape SHAPE = Block.box(1.0D, 10.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public static final VoxelShape SHAPE_NORTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 12.0D, 12.0D);
    public static final VoxelShape SHAPE_EAST = Block.box(4.0D, 0.0D, 0.0D, 12.0D, 12.0D, 16.0D);

    public static final EnumProperty<ParallelConnectionShape2> FORM = EnumProperty.create("shape", ParallelConnectionShape2.class);

    public BenchParallelConnecting(Props props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(DIRECTION)) {
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
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        final var seat = (SeatTileEntity) level.getBlockEntity(blockPos);
        if (!player.isShiftKeyDown() && !level.isClientSide) {
            List<SeatEntity> seats = level.getEntitiesOfClass(SeatEntity.class, new AABB(blockPos));
            if(!seats.isEmpty()) {
                SeatEntity seatEntity = seats.get(0);
                List<Entity> passengers = seatEntity.getPassengers();
                if (!passengers.isEmpty() && passengers.get(0) instanceof Player) {
                    return super.use(state, level, blockPos, player, hand, hitResult);
                }
                seatEntity.ejectPassengers();
                final boolean success = player.startRiding(seatEntity);
                if (success) {
                    level.blockUpdated(blockPos, this);
                    seat.setChanged();
                }
                return success ? InteractionResult.SUCCESS : InteractionResult.PASS;
            }
            final boolean success = seat.rideSeat(player);
            if (success) {
                level.blockUpdated(blockPos, this);
                seat.setChanged();
            }
            return success ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }
        return super.use(state, level, blockPos, player, hand, hitResult);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SeatTileEntity(blockPos, blockState);
    }
}
