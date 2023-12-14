package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Cabinets extends WaterloggedHorizontalDirectionalShape {


    public static final EnumProperty<DoorHinge> HINGE = Properties.DOOR_HINGE;

    public Cabinets(Props props) {
        super(props.toSettings());
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
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
    public BlockState getPlacementState(ItemPlacementContext context) {
        return super.getPlacementState(context).with(HorizontalDirectionalWaterloggedToggle3.TOGGLE, 1).with(DIRECTION, context.getPlayerFacing().getOpposite()).with(HINGE, this.getHingeSide(context));
    }

    private DoorHinge getHingeSide(ItemPlacementContext p_208073_1_) {
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
        int i = (blockstate.isFullCube(iblockreader, blockpos2) ? -1 : 0) + (blockstate1.isFullCube(iblockreader, blockpos3) ? -1 : 0) + (blockstate2.isFullCube(iblockreader, blockpos4) ? 1 : 0) + (blockstate3.isFullCube(iblockreader, blockpos5) ? 1 : 0);
        if (i <= 0) {
            if (i >= 0) {
                int j = direction.getOffsetX();
                int k = direction.getOffsetZ();
                Vec3d vec3d = p_208073_1_.getHitPos();
                double d0 = vec3d.x - (double) blockpos.getX();
                double d1 = vec3d.z - (double) blockpos.getZ();
                return (j >= 0 || !(d1 < 0.5D)) && (j <= 0 || !(d1 > 0.5D)) && (k >= 0 || !(d0 > 0.5D)) && (k <= 0 || !(d0 < 0.5D)) ? DoorHinge.RIGHT : DoorHinge.LEFT;
            } else {
                return DoorHinge.RIGHT;
            }
        } else {
            return DoorHinge.LEFT;
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HINGE).add(HorizontalDirectionalWaterloggedToggle3.TOGGLE);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else {
            level.setBlockState(blockPos, state.cycle(HorizontalDirectionalWaterloggedToggle3.TOGGLE), 3);
            return ActionResult.SUCCESS;
        }
    }
}
