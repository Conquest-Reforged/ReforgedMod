package com.conquestreforged.content.blocks.block.arch;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.core.block.properties.ArchShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Arch extends HorizontalFacingBlock {

    public static final EnumProperty<ArchShape> FORM = EnumProperty.of("shape", ArchShape.class);

    private static final VoxelShape ARCH_MIDDLE_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public Arch(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(FORM, ArchShape.ONE).with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(FORM) == ArchShape.ONE) {
            return VoxelShapes.fullCube();
        } else if ((state.get(FORM) == ArchShape.THREE_MIDDLE)) {
            return ARCH_MIDDLE_SHAPE;
        } else {
            switch (state.get(FACING)) {
                default:
                    return BlockVoxelShapes.stairTopShapes.get(0);
                case EAST:
                    return BlockVoxelShapes.stairTopShapes.get(1);
                case SOUTH:
                    return BlockVoxelShapes.stairTopShapes.get(2);
                case WEST:
                    return BlockVoxelShapes.stairTopShapes.get(3);
            }
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos pos = context.getBlockPos();
        Direction facing = context.getSide();

        if (facing == Direction.UP || facing == Direction.DOWN) {
            Direction horizontalFacing = context.getPlayerFacing();
            facing = getFacingUpDown(context, pos, horizontalFacing);
        }

        ArchShape shape = ArchShape.ONE;
        return super.getPlacementState(context)
                .with(FACING, facing)
                .with(FORM, shape);
    }

    private Direction getFacingUpDown(ItemPlacementContext context, BlockPos pos, Direction horizontalFacing) {
        switch (horizontalFacing) {
            case NORTH: {
                return (!(context.getHitPos().x - (double) pos.getX() > 0.5D)) ? horizontalFacing.rotateYClockwise() : horizontalFacing.rotateYCounterclockwise();
            }
            case SOUTH: {
                return (!(context.getHitPos().x - (double) pos.getX() < 0.5D)) ? horizontalFacing.rotateYClockwise() : horizontalFacing.rotateYCounterclockwise();
            }
            case EAST: {
                return (!(context.getHitPos().z - (double) pos.getZ() > 0.5D)) ? horizontalFacing.rotateYClockwise() : horizontalFacing.rotateYCounterclockwise();
            }
            default: {
                return (!(context.getHitPos().z - (double) pos.getZ() < 0.5D)) ? horizontalFacing.rotateYClockwise() : horizontalFacing.rotateYCounterclockwise();
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, FORM);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else {
            level.setBlockState(blockPos, state.cycle(FORM), 3);
            return ActionResult.SUCCESS;
        }
    }
}