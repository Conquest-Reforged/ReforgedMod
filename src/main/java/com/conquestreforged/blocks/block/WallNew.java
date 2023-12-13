package com.conquestreforged.blocks.block;

import com.conquestreforged.blocks.block.classical.corinthian.CubeCapitalCorinthian;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_wall", template = "parent_wall"),
        item = @Model(name = "item/%s_wall", parent = "block/%s_wall_inventory", template = "item/cobblestone_wall"),
        block = {
                @Model(name = "block/%s_wall_post", template = "block/parent_wall_post"),
                @Model(name = "block/%s_wall_side", template = "block/parent_wall_side"),
                @Model(name = "block/%s_wall_side_tall", template = "block/parent_wall_side_tall"),
                @Model(name = "block/%s_wall_inventory", template = "block/parent_wall_inventory"),
        }
)
public class WallNew extends WallBlock {

    //TODO - clean up
    private static final VoxelShape POST_TEST = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape NORTH_TEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape SOUTH_TEST = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_TEST = Block.box(0.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape EAST_TEST = Block.box(7.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);

    public WallNew(Properties properties) {
        super(properties);
    }

    private boolean canAttachTo(BlockState blockState, boolean isSideSolid, Direction direction) {
        Block block = blockState.getBlock();
        boolean flag = blockState.is(BlockTags.WALLS) ||
                block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(blockState, direction) ||
                block instanceof CubeCapitalCorinthian ||
                (block instanceof VerticalCorner && blockState.getValue(VerticalCorner.LAYERS) >= 3) ||
                (block instanceof VerticalCornerLessLayers && blockState.getValue(VerticalCornerLessLayers.LAYERS) >= 2) ||
                (block instanceof VerticalSlab && blockState.getValue(VerticalSlab.LAYERS) >= 3 && canAttachToVertSlab(blockState, direction)) ||
                (block instanceof VerticalSlabLessLayers && blockState.getValue(VerticalSlabLessLayers.LAYERS) >= 2 && canAttachToVertSlab(blockState, direction)) ||
                (block instanceof VerticalQuarter && blockState.getValue(VerticalQuarter.LAYERS) >= 3 && canAttachToVertQuarter(blockState, direction)) ||
                (block instanceof VerticalQuarterLessLayers && blockState.getValue(VerticalQuarterLessLayers.LAYERS) >= 2 && canAttachToVertQuarter(blockState, direction));
        return !isExceptionForConnection(blockState) && isSideSolid || flag;
    }

    private boolean canAttachToVertQuarter(BlockState state, Direction direction) {
        return (state.getValue(VerticalQuarter.DIRECTION) != direction && state.getValue(VerticalQuarter.DIRECTION).getCounterClockWise() != direction);
    }

    public final boolean canAttachToVertSlab(BlockState state, Direction direction) {
        return state.getValue(VerticalSlab.DIRECTION) != direction;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
        LevelReader iworldreader = p_196258_1_.getLevel();
        BlockPos blockpos = p_196258_1_.getClickedPos();
        FluidState fluidstate = p_196258_1_.getLevel().getFluidState(p_196258_1_.getClickedPos());
        BlockPos blockpos1 = blockpos.m_142127_();
        BlockPos blockpos2 = blockpos.m_142126_();
        BlockPos blockpos3 = blockpos.m_142128_();
        BlockPos blockpos4 = blockpos.m_142125_();
        BlockPos blockpos5 = blockpos.above();
        BlockState blockstate = iworldreader.getBlockState(blockpos1);
        BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
        BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
        BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
        BlockState blockstate4 = iworldreader.getBlockState(blockpos5);
        boolean flag = this.canAttachTo(blockstate, blockstate.isFaceSturdy(iworldreader, blockpos1, Direction.SOUTH), Direction.SOUTH);
        boolean flag1 = this.canAttachTo(blockstate1, blockstate1.isFaceSturdy(iworldreader, blockpos2, Direction.WEST), Direction.WEST);
        boolean flag2 = this.canAttachTo(blockstate2, blockstate2.isFaceSturdy(iworldreader, blockpos3, Direction.NORTH), Direction.NORTH);
        boolean flag3 = this.canAttachTo(blockstate3, blockstate3.isFaceSturdy(iworldreader, blockpos4, Direction.EAST), Direction.EAST);
        BlockState blockstate5 = this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
        return this.updateShape(iworldreader, blockstate5, blockpos5, blockstate4, flag, flag1, flag2, flag3);
    }

    @Override
    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, LevelAccessor p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        if (p_196271_1_.getValue(WATERLOGGED)) {
            p_196271_4_.scheduleTick(p_196271_5_, Fluids.WATER, Fluids.WATER.getTickDelay(p_196271_4_));
        }

        if (p_196271_2_ == Direction.DOWN) {
            return super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
        } else {
            return p_196271_2_ == Direction.UP ? this.topUpdate(p_196271_4_, p_196271_1_, p_196271_6_, p_196271_3_) : this.sideUpdate(p_196271_4_, p_196271_5_, p_196271_1_, p_196271_6_, p_196271_3_, p_196271_2_);
        }
    }

    private static boolean isConnected(BlockState p_235629_0_, Property<WallSide> p_235629_1_) {
        return p_235629_0_.getValue(p_235629_1_) != WallSide.NONE;
    }

    private static boolean isCovered(VoxelShape p_235632_0_, VoxelShape p_235632_1_) {
        return !Shapes.joinIsNotEmpty(p_235632_1_, p_235632_0_, BooleanOp.ONLY_FIRST);
    }

    private BlockState topUpdate(LevelReader p_235625_1_, BlockState p_235625_2_, BlockPos p_235625_3_, BlockState p_235625_4_) {
        boolean flag = isConnected(p_235625_2_, NORTH_WALL);
        boolean flag1 = isConnected(p_235625_2_, EAST_WALL);
        boolean flag2 = isConnected(p_235625_2_, SOUTH_WALL);
        boolean flag3 = isConnected(p_235625_2_, WEST_WALL);
        return this.updateShape(p_235625_1_, p_235625_2_, p_235625_3_, p_235625_4_, flag, flag1, flag2, flag3);
    }

    private BlockState sideUpdate(LevelReader p_235627_1_, BlockPos p_235627_2_, BlockState p_235627_3_, BlockPos p_235627_4_, BlockState p_235627_5_, Direction p_235627_6_) {
        Direction direction = p_235627_6_.getOpposite();
        boolean flag = p_235627_6_ == Direction.NORTH ? this.canAttachTo(p_235627_5_, p_235627_5_.isFaceSturdy(p_235627_1_, p_235627_4_, direction), direction) : isConnected(p_235627_3_, NORTH_WALL);
        boolean flag1 = p_235627_6_ == Direction.EAST ? this.canAttachTo(p_235627_5_, p_235627_5_.isFaceSturdy(p_235627_1_, p_235627_4_, direction), direction) : isConnected(p_235627_3_, EAST_WALL);
        boolean flag2 = p_235627_6_ == Direction.SOUTH ? this.canAttachTo(p_235627_5_, p_235627_5_.isFaceSturdy(p_235627_1_, p_235627_4_, direction), direction) : isConnected(p_235627_3_, SOUTH_WALL);
        boolean flag3 = p_235627_6_ == Direction.WEST ? this.canAttachTo(p_235627_5_, p_235627_5_.isFaceSturdy(p_235627_1_, p_235627_4_, direction), direction) : isConnected(p_235627_3_, WEST_WALL);
        BlockPos blockpos = p_235627_2_.above();
        BlockState blockstate = p_235627_1_.getBlockState(blockpos);
        return this.updateShape(p_235627_1_, p_235627_3_, blockpos, blockstate, flag, flag1, flag2, flag3);
    }

    private BlockState updateShape(LevelReader p_235626_1_, BlockState p_235626_2_, BlockPos p_235626_3_, BlockState p_235626_4_, boolean p_235626_5_, boolean p_235626_6_, boolean p_235626_7_, boolean p_235626_8_) {
        VoxelShape voxelshape = p_235626_4_.getCollisionShape(p_235626_1_, p_235626_3_).getFaceShape(Direction.DOWN);
        BlockState blockstate = this.updateSides(p_235626_2_, p_235626_5_, p_235626_6_, p_235626_7_, p_235626_8_, voxelshape);
        return blockstate.setValue(UP, Boolean.valueOf(this.shouldRaisePost(blockstate, p_235626_4_, voxelshape)));
    }

    private boolean shouldRaisePost(BlockState p_235628_1_, BlockState p_235628_2_, VoxelShape p_235628_3_) {
        boolean flag = p_235628_2_.getBlock() instanceof WallBlock && p_235628_2_.getValue(UP);
        if (flag) {
            return true;
        } else {
            WallSide wallheight = p_235628_1_.getValue(NORTH_WALL);
            WallSide wallheight1 = p_235628_1_.getValue(SOUTH_WALL);
            WallSide wallheight2 = p_235628_1_.getValue(EAST_WALL);
            WallSide wallheight3 = p_235628_1_.getValue(WEST_WALL);
            boolean flag1 = wallheight1 == WallSide.NONE;
            boolean flag2 = wallheight3 == WallSide.NONE;
            boolean flag3 = wallheight2 == WallSide.NONE;
            boolean flag4 = wallheight == WallSide.NONE;
            boolean flag5 = flag4 && flag1 && flag2 && flag3 || flag4 != flag1 || flag2 != flag3;
            if (flag5) {
                return true;
            } else {
                boolean flag6 = wallheight == WallSide.TALL && wallheight1 == WallSide.TALL || wallheight2 == WallSide.TALL && wallheight3 == WallSide.TALL;
                if (flag6) {
                    return false;
                } else {
                    return p_235628_2_.is(BlockTags.WALL_POST_OVERRIDE) || isCovered(p_235628_3_, POST_TEST);
                }
            }
        }
    }

    private BlockState updateSides(BlockState p_235630_1_, boolean p_235630_2_, boolean p_235630_3_, boolean p_235630_4_, boolean p_235630_5_, VoxelShape p_235630_6_) {
        return p_235630_1_.setValue(NORTH_WALL, this.makeWallState(p_235630_2_, p_235630_6_, NORTH_TEST)).setValue(EAST_WALL, this.makeWallState(p_235630_3_, p_235630_6_, EAST_TEST)).setValue(SOUTH_WALL, this.makeWallState(p_235630_4_, p_235630_6_, SOUTH_TEST)).setValue(WEST_WALL, this.makeWallState(p_235630_5_, p_235630_6_, WEST_TEST));
    }

    private WallSide makeWallState(boolean p_235633_1_, VoxelShape p_235633_2_, VoxelShape p_235633_3_) {
        if (p_235633_1_) {
            return isCovered(p_235633_2_, p_235633_3_) ? WallSide.TALL : WallSide.LOW;
        } else {
            return WallSide.NONE;
        }
    }
}
