package com.conquestreforged.content.blocks.block.arch;

import com.conquestreforged.core.block.properties.HalfArchShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ArchHalf extends HorizontalFacingBlock {

    public static final EnumProperty FORM = EnumProperty.of("shape", HalfArchShape.class);
    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);

    private static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);

    private static final VoxelShape ARCH_NORTH_R_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D));
    private static final VoxelShape ARCH_NORTH_L_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D));

    private static final VoxelShape ARCH_WEST_L_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape ARCH_WEST_R_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));

    private static final VoxelShape ARCH_EAST_R_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D));
    private static final VoxelShape ARCH_EAST_L_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D));

    private static final VoxelShape ARCH_SOUTH_L_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
    private static final VoxelShape ARCH_SOUTH_R_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));

    private static final VoxelShape ARCH_MIDDLE_SOUTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape ARCH_MIDDLE_NORTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape ARCH_MIDDLE_WEST_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape ARCH_MIDDLE_EAST_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D);

    private static final VoxelShape ARCH_NORTH_R_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D));
    private static final VoxelShape ARCH_NORTH_L_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D));

    private static final VoxelShape ARCH_WEST_L_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));
    private static final VoxelShape ARCH_WEST_R_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));

    private static final VoxelShape ARCH_EAST_R_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D));
    private static final VoxelShape ARCH_EAST_L_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D));

    private static final VoxelShape ARCH_SOUTH_L_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D), Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));
    private static final VoxelShape ARCH_SOUTH_R_BOTTOM_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));

    private static final VoxelShape ARCH_MIDDLE_SOUTH_BOTTOM_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D);
    private static final VoxelShape ARCH_MIDDLE_NORTH_BOTTOM_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape ARCH_MIDDLE_WEST_BOTTOM_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape ARCH_MIDDLE_EAST_BOTTOM_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D);


    public ArchHalf(Settings properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(TYPE_UPDOWN, BlockHalf.TOP).with(FORM, HalfArchShape.ONE).with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos pos = context.getBlockPos();
        Direction facing = context.getSide();

        if (facing == Direction.UP || facing == Direction.DOWN) {
            Direction horizontalFacing = context.getPlayerFacing();
            facing = getFacingUpDown(context, pos, horizontalFacing);
        }

        HalfArchShape shape = HalfArchShape.ONE;

        BlockHalf upDown = facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double) context.getBlockPos().getY() > 0.5D)) ? BlockHalf.BOTTOM : BlockHalf.TOP;

        return super.getPlacementState(context)
                .with(FACING, facing)
                .with(TYPE_UPDOWN, upDown)
                .with(FORM, shape);
    }

    private boolean isRightShape(ItemPlacementContext p_208073_1_) {
        BlockView iblockreader = p_208073_1_.getWorld();
        BlockPos blockpos = p_208073_1_.getBlockPos();
        Direction direction = p_208073_1_.getPlayerFacing();
        BlockPos blockpos1 = blockpos.up();
        Direction direction1 = direction.rotateYCounterclockwise();
        BlockPos blockpos2 = blockpos.offset(direction1);
        BlockState blockstate = iblockreader.getBlockState(blockpos2);
        BlockPos blockpos3 = blockpos1.offset(direction1);
        BlockState blockstate1 = iblockreader.getBlockState(blockpos3);
        Direction direction2 = direction.rotateYClockwise();
        BlockPos blockpos4 = blockpos.offset(direction2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos4);
        BlockPos blockpos5 = blockpos1.offset(direction2);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos5);
        int i = (blockstate.isOpaqueFullCube(iblockreader, blockpos2) ? -1 : 0) + (blockstate1.isOpaqueFullCube(iblockreader, blockpos3) ? -1 : 0) + (blockstate2.isOpaqueFullCube(iblockreader, blockpos4) ? 1 : 0) + (blockstate3.isOpaqueFullCube(iblockreader, blockpos5) ? 1 : 0);
        if (i <= 0) {
            if (i >= 0) {
                int j = direction.getOffsetX();
                int k = direction.getOffsetZ();
                Vec3d vec3d = p_208073_1_.getHitPos();
                double d0 = vec3d.x - (double) blockpos.getX();
                double d1 = vec3d.z - (double) blockpos.getZ();
                return (j >= 0 || !(d1 < 0.5D)) && (j <= 0 || !(d1 > 0.5D)) && (k >= 0 || !(d0 > 0.5D)) && (k <= 0 || !(d0 < 0.5D)) ? true : false;
            } else {
                return true;
            }
        } else {
            return false;
        }
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
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.TOP) {
            if (state.get(FORM) == HalfArchShape.ONE) {
                switch (state.get(FACING)) {
                    case NORTH:
                    default:
                        return NORTH_SHAPE;
                    case SOUTH:
                        return SOUTH_SHAPE;
                    case WEST:
                        return WEST_SHAPE;
                    case EAST:
                        return EAST_SHAPE;
                }
            } else if (state.get(FORM) == HalfArchShape.TWO_L || state.get(FORM) == HalfArchShape.THREE_L) {
                switch (state.get(FACING)) {
                    case NORTH:
                    default:
                        return ARCH_NORTH_L_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_L_SHAPE;
                    case WEST:
                        return ARCH_WEST_L_SHAPE;
                    case EAST:
                        return ARCH_EAST_L_SHAPE;
                }
            } else if (state.get(FORM) == HalfArchShape.TWO_R || state.get(FORM) == HalfArchShape.THREE_R) {
                switch (state.get(FACING)) {
                    case NORTH:
                    default:
                        return ARCH_NORTH_R_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_R_SHAPE;
                    case WEST:
                        return ARCH_WEST_R_SHAPE;
                    case EAST:
                        return ARCH_EAST_R_SHAPE;
                }
            } else {
                switch (state.get(FACING)) {
                    case NORTH:
                    default:
                        return ARCH_MIDDLE_NORTH_SHAPE;
                    case SOUTH:
                        return ARCH_MIDDLE_SOUTH_SHAPE;
                    case WEST:
                        return ARCH_MIDDLE_WEST_SHAPE;
                    case EAST:
                        return ARCH_MIDDLE_EAST_SHAPE;
                }
            }
        } else {
            if (state.get(FORM) == HalfArchShape.ONE) {
                switch (state.get(FACING)) {
                    case NORTH:
                    default:
                        return NORTH_SHAPE;
                    case SOUTH:
                        return SOUTH_SHAPE;
                    case WEST:
                        return WEST_SHAPE;
                    case EAST:
                        return EAST_SHAPE;
                }
            } else if (state.get(FORM) == HalfArchShape.TWO_L || state.get(FORM) == HalfArchShape.THREE_L) {
                switch (state.get(FACING)) {
                    case NORTH:
                    default:
                        return ARCH_NORTH_L_BOTTOM_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_L_BOTTOM_SHAPE;
                    case WEST:
                        return ARCH_WEST_L_BOTTOM_SHAPE;
                    case EAST:
                        return ARCH_EAST_L_BOTTOM_SHAPE;
                }
            } else if (state.get(FORM) == HalfArchShape.TWO_R || state.get(FORM) == HalfArchShape.THREE_R) {
                switch (state.get(FACING)) {
                    case NORTH:
                    default:
                        return ARCH_NORTH_R_BOTTOM_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_R_BOTTOM_SHAPE;
                    case WEST:
                        return ARCH_WEST_R_BOTTOM_SHAPE;
                    case EAST:
                        return ARCH_EAST_R_BOTTOM_SHAPE;
                }
            } else {
                switch (state.get(FACING)) {
                    case NORTH:
                    default:
                        return ARCH_MIDDLE_NORTH_BOTTOM_SHAPE;
                    case SOUTH:
                        return ARCH_MIDDLE_SOUTH_BOTTOM_SHAPE;
                    case WEST:
                        return ARCH_MIDDLE_WEST_BOTTOM_SHAPE;
                    case EAST:
                        return ARCH_MIDDLE_EAST_BOTTOM_SHAPE;
                }
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE_UPDOWN, FORM);
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