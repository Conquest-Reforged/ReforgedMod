package com.conquestreforged.blocks.block.arch;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.core.block.properties.ArchShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Arch extends HorizontalDirectionalBlock {

    public static final EnumProperty<ArchShape> FORM = EnumProperty.create("shape", ArchShape.class);

    private static final VoxelShape ARCH_MIDDLE_SHAPE = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public Arch(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FORM, ArchShape.ONE).setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(FORM) == ArchShape.ONE) {
            return Shapes.block();
        } else if ((state.getValue(FORM) == ArchShape.THREE_MIDDLE)) {
            return ARCH_MIDDLE_SHAPE;
        } else {
            switch (state.getValue(FACING)) {
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
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();

        if (facing == Direction.UP || facing == Direction.DOWN) {
            Direction horizontalFacing = context.getHorizontalDirection();
            facing = getFacingUpDown(context, pos, horizontalFacing);
        }

        ArchShape shape = ArchShape.ONE;
        return super.getStateForPlacement(context)
                .setValue(FACING, facing)
                .setValue(FORM, shape);
    }

    private Direction getFacingUpDown(BlockPlaceContext context, BlockPos pos, Direction horizontalFacing) {
        switch (horizontalFacing) {
            case NORTH: {
                return (!(context.getClickLocation().x - (double) pos.getX() > 0.5D)) ? horizontalFacing.getClockWise() : horizontalFacing.getCounterClockWise();
            }
            case SOUTH: {
                return (!(context.getClickLocation().x - (double) pos.getX() < 0.5D)) ? horizontalFacing.getClockWise() : horizontalFacing.getCounterClockWise();
            }
            case EAST: {
                return (!(context.getClickLocation().z - (double) pos.getZ() > 0.5D)) ? horizontalFacing.getClockWise() : horizontalFacing.getCounterClockWise();
            }
            default: {
                return (!(context.getClickLocation().z - (double) pos.getZ() < 0.5D)) ? horizontalFacing.getClockWise() : horizontalFacing.getCounterClockWise();
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, FORM);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            level.setBlock(blockPos, state.cycle(FORM), 3);
            return InteractionResult.SUCCESS;
        }
    }
}