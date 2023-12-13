package com.conquestreforged.blocks.block.arch;

import com.conquestreforged.core.block.properties.HalfArchShape;
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
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ArchHalf extends HorizontalDirectionalBlock {

    public static final EnumProperty FORM = EnumProperty.create("shape", HalfArchShape.class);
    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);

    private static final VoxelShape EAST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_SHAPE = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);

    private static final VoxelShape ARCH_NORTH_R_SHAPE = Shapes.or(Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D));
    private static final VoxelShape ARCH_NORTH_L_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D));

    private static final VoxelShape ARCH_WEST_L_SHAPE = Shapes.or(Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape ARCH_WEST_R_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));

    private static final VoxelShape ARCH_EAST_R_SHAPE = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D));
    private static final VoxelShape ARCH_EAST_L_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D), Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D));

    private static final VoxelShape ARCH_SOUTH_L_SHAPE = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
    private static final VoxelShape ARCH_SOUTH_R_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D), Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));

    private static final VoxelShape ARCH_MIDDLE_SOUTH_SHAPE = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape ARCH_MIDDLE_NORTH_SHAPE = Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape ARCH_MIDDLE_WEST_SHAPE = Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape ARCH_MIDDLE_EAST_SHAPE = Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D);

    private static final VoxelShape ARCH_NORTH_R_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D));
    private static final VoxelShape ARCH_NORTH_L_BOTTOM_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D));

    private static final VoxelShape ARCH_WEST_L_BOTTOM_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));
    private static final VoxelShape ARCH_WEST_R_BOTTOM_SHAPE = Shapes.or(Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));

    private static final VoxelShape ARCH_EAST_R_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D), Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D));
    private static final VoxelShape ARCH_EAST_L_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D));

    private static final VoxelShape ARCH_SOUTH_L_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D), Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));
    private static final VoxelShape ARCH_SOUTH_R_BOTTOM_SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));

    private static final VoxelShape ARCH_MIDDLE_SOUTH_BOTTOM_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D);
    private static final VoxelShape ARCH_MIDDLE_NORTH_BOTTOM_SHAPE = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape ARCH_MIDDLE_WEST_BOTTOM_SHAPE = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape ARCH_MIDDLE_EAST_BOTTOM_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D);


    public ArchHalf(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(TYPE_UPDOWN, Half.TOP).setValue(FORM, HalfArchShape.ONE).setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();

        if (facing == Direction.UP || facing == Direction.DOWN) {
            Direction horizontalFacing = context.getHorizontalDirection();
            facing = getFacingUpDown(context, pos, horizontalFacing);
        }

        HalfArchShape shape = HalfArchShape.ONE;

        Half upDown = facing != Direction.DOWN && (facing == Direction.UP || !(context.getClickLocation().y - (double) context.getClickedPos().getY() > 0.5D)) ? Half.BOTTOM : Half.TOP;

        return super.getStateForPlacement(context)
                .setValue(FACING, facing)
                .setValue(TYPE_UPDOWN, upDown)
                .setValue(FORM, shape);
    }

    private boolean isRightShape(BlockPlaceContext p_208073_1_) {
        BlockGetter iblockreader = p_208073_1_.getLevel();
        BlockPos blockpos = p_208073_1_.getClickedPos();
        Direction direction = p_208073_1_.getHorizontalDirection();
        BlockPos blockpos1 = blockpos.above();
        Direction direction1 = direction.getCounterClockWise();
        BlockPos blockpos2 = blockpos.m_142300_(direction1);
        BlockState blockstate = iblockreader.getBlockState(blockpos2);
        BlockPos blockpos3 = blockpos1.m_142300_(direction1);
        BlockState blockstate1 = iblockreader.getBlockState(blockpos3);
        Direction direction2 = direction.getClockWise();
        BlockPos blockpos4 = blockpos.m_142300_(direction2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos4);
        BlockPos blockpos5 = blockpos1.m_142300_(direction2);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos5);
        int i = (blockstate.isSolidRender(iblockreader, blockpos2) ? -1 : 0) + (blockstate1.isSolidRender(iblockreader, blockpos3) ? -1 : 0) + (blockstate2.isSolidRender(iblockreader, blockpos4) ? 1 : 0) + (blockstate3.isSolidRender(iblockreader, blockpos5) ? 1 : 0);
        if (i <= 0) {
            if (i >= 0) {
                int j = direction.getStepX();
                int k = direction.getStepZ();
                Vec3 vec3d = p_208073_1_.getClickLocation();
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
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(TYPE_UPDOWN) == Half.TOP) {
            if (state.getValue(FORM) == HalfArchShape.ONE) {
                switch (state.getValue(FACING)) {
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
            } else if (state.getValue(FORM) == HalfArchShape.TWO_L || state.getValue(FORM) == HalfArchShape.THREE_L) {
                switch (state.getValue(FACING)) {
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
            } else if (state.getValue(FORM) == HalfArchShape.TWO_R || state.getValue(FORM) == HalfArchShape.THREE_R) {
                switch (state.getValue(FACING)) {
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
                switch (state.getValue(FACING)) {
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
            if (state.getValue(FORM) == HalfArchShape.ONE) {
                switch (state.getValue(FACING)) {
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
            } else if (state.getValue(FORM) == HalfArchShape.TWO_L || state.getValue(FORM) == HalfArchShape.THREE_L) {
                switch (state.getValue(FACING)) {
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
            } else if (state.getValue(FORM) == HalfArchShape.TWO_R || state.getValue(FORM) == HalfArchShape.THREE_R) {
                switch (state.getValue(FACING)) {
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
                switch (state.getValue(FACING)) {
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE_UPDOWN, FORM);
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