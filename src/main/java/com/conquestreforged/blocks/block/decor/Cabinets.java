package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Cabinets extends WaterloggedHorizontalDirectionalShape {


    public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;

    public Cabinets(Props props) {
        super(props.toProperties());
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(DIRECTION)) {
                case SOUTH:
                default:
                    return BlockVoxelShapes.verticalSlabShapes.get(2);
                case NORTH:
                    return BlockVoxelShapes.verticalSlabShapes.get(0);
                case EAST:
                    return BlockVoxelShapes.verticalSlabShapes.get(1);
                case WEST:
                    return BlockVoxelShapes.verticalSlabShapes.get(3);
            }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(HorizontalDirectionalWaterloggedToggle3.TOGGLE, 1).setValue(DIRECTION, context.getHorizontalDirection().getOpposite()).setValue(HINGE, this.getHingeSide(context));
    }

    private DoorHingeSide getHingeSide(BlockPlaceContext p_208073_1_) {
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
        int i = (blockstate.isCollisionShapeFullBlock(iblockreader, blockpos2) ? -1 : 0) + (blockstate1.isCollisionShapeFullBlock(iblockreader, blockpos3) ? -1 : 0) + (blockstate2.isCollisionShapeFullBlock(iblockreader, blockpos4) ? 1 : 0) + (blockstate3.isCollisionShapeFullBlock(iblockreader, blockpos5) ? 1 : 0);
        if (i <= 0) {
            if (i >= 0) {
                int j = direction.getStepX();
                int k = direction.getStepZ();
                Vec3 vec3d = p_208073_1_.getClickLocation();
                double d0 = vec3d.x - (double) blockpos.getX();
                double d1 = vec3d.z - (double) blockpos.getZ();
                return (j >= 0 || !(d1 < 0.5D)) && (j <= 0 || !(d1 > 0.5D)) && (k >= 0 || !(d0 > 0.5D)) && (k <= 0 || !(d0 < 0.5D)) ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT;
            } else {
                return DoorHingeSide.RIGHT;
            }
        } else {
            return DoorHingeSide.LEFT;
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HINGE).add(HorizontalDirectionalWaterloggedToggle3.TOGGLE);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            level.setBlock(blockPos, state.cycle(HorizontalDirectionalWaterloggedToggle3.TOGGLE), 3);
            return InteractionResult.SUCCESS;
        }
    }
}
