package com.conquestreforged.content.blocks.block;

import com.conquestreforged.content.blocks.block.classical.corinthian.CubeCapitalCorinthian;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.WallShape;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.Property;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

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
    private static final VoxelShape POST_TEST = Block.createCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape NORTH_TEST = Block.createCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape SOUTH_TEST = Block.createCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_TEST = Block.createCuboidShape(0.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape EAST_TEST = Block.createCuboidShape(7.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);

    public WallNew(Settings properties) {
        super(properties);
    }

    private boolean canAttachTo(BlockState blockState, boolean isSideSolid, Direction direction) {
        Block block = blockState.getBlock();
        boolean flag = blockState.isIn(BlockTags.WALLS) ||
                block instanceof FenceGateBlock && FenceGateBlock.canWallConnect(blockState, direction) ||
                block instanceof CubeCapitalCorinthian ||
                (block instanceof VerticalCorner && blockState.get(VerticalCorner.LAYERS) >= 3) ||
                (block instanceof VerticalCornerLessLayers && blockState.get(VerticalCornerLessLayers.LAYERS) >= 2) ||
                (block instanceof VerticalSlab && blockState.get(VerticalSlab.LAYERS) >= 3 && canAttachToVertSlab(blockState, direction)) ||
                (block instanceof VerticalSlabLessLayers && blockState.get(VerticalSlabLessLayers.LAYERS) >= 2 && canAttachToVertSlab(blockState, direction)) ||
                (block instanceof VerticalQuarter && blockState.get(VerticalQuarter.LAYERS) >= 3 && canAttachToVertQuarter(blockState, direction)) ||
                (block instanceof VerticalQuarterLessLayers && blockState.get(VerticalQuarterLessLayers.LAYERS) >= 2 && canAttachToVertQuarter(blockState, direction));
        return !cannotConnect(blockState) && isSideSolid || flag;
    }

    private boolean canAttachToVertQuarter(BlockState state, Direction direction) {
        return (state.get(VerticalQuarter.DIRECTION) != direction && state.get(VerticalQuarter.DIRECTION).rotateYCounterclockwise() != direction);
    }

    public final boolean canAttachToVertSlab(BlockState state, Direction direction) {
        return state.get(VerticalSlab.DIRECTION) != direction;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext p_196258_1_) {
        WorldView iworldreader = p_196258_1_.getWorld();
        BlockPos blockpos = p_196258_1_.getBlockPos();
        FluidState fluidstate = p_196258_1_.getWorld().getFluidState(p_196258_1_.getBlockPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockPos blockpos5 = blockpos.up();
        BlockState blockstate = iworldreader.getBlockState(blockpos1);
        BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
        BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
        BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
        BlockState blockstate4 = iworldreader.getBlockState(blockpos5);
        boolean flag = this.canAttachTo(blockstate, blockstate.isSideSolidFullSquare(iworldreader, blockpos1, Direction.SOUTH), Direction.SOUTH);
        boolean flag1 = this.canAttachTo(blockstate1, blockstate1.isSideSolidFullSquare(iworldreader, blockpos2, Direction.WEST), Direction.WEST);
        boolean flag2 = this.canAttachTo(blockstate2, blockstate2.isSideSolidFullSquare(iworldreader, blockpos3, Direction.NORTH), Direction.NORTH);
        boolean flag3 = this.canAttachTo(blockstate3, blockstate3.isSideSolidFullSquare(iworldreader, blockpos4, Direction.EAST), Direction.EAST);
        BlockState blockstate5 = this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER));
        return this.getStateWith(iworldreader, blockstate5, blockpos5, blockstate4, flag, flag1, flag2, flag3);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, WorldAccess p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        if (p_196271_1_.get(WATERLOGGED)) {
            p_196271_4_.createAndScheduleFluidTick(p_196271_5_, Fluids.WATER, Fluids.WATER.getTickRate(p_196271_4_));
        }

        if (p_196271_2_ == Direction.DOWN) {
            return super.getStateForNeighborUpdate(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
        } else {
            return p_196271_2_ == Direction.UP ? this.getStateAt(p_196271_4_, p_196271_1_, p_196271_6_, p_196271_3_) : this.getStateWithNeighbor(p_196271_4_, p_196271_5_, p_196271_1_, p_196271_6_, p_196271_3_, p_196271_2_);
        }
    }

    private static boolean isConnected(BlockState p_235629_0_, Property<WallShape> p_235629_1_) {
        return p_235629_0_.get(p_235629_1_) != WallShape.NONE;
    }

    private static boolean shouldUseTallShape(VoxelShape p_235632_0_, VoxelShape p_235632_1_) {
        return !VoxelShapes.matchesAnywhere(p_235632_1_, p_235632_0_, BooleanBiFunction.ONLY_FIRST);
    }

    private BlockState getStateAt(WorldView p_235625_1_, BlockState p_235625_2_, BlockPos p_235625_3_, BlockState p_235625_4_) {
        boolean flag = isConnected(p_235625_2_, NORTH_SHAPE);
        boolean flag1 = isConnected(p_235625_2_, EAST_SHAPE);
        boolean flag2 = isConnected(p_235625_2_, SOUTH_SHAPE);
        boolean flag3 = isConnected(p_235625_2_, WEST_SHAPE);
        return this.getStateWith(p_235625_1_, p_235625_2_, p_235625_3_, p_235625_4_, flag, flag1, flag2, flag3);
    }

    private BlockState getStateWithNeighbor(WorldView p_235627_1_, BlockPos p_235627_2_, BlockState p_235627_3_, BlockPos p_235627_4_, BlockState p_235627_5_, Direction p_235627_6_) {
        Direction direction = p_235627_6_.getOpposite();
        boolean flag = p_235627_6_ == Direction.NORTH ? this.canAttachTo(p_235627_5_, p_235627_5_.isSideSolidFullSquare(p_235627_1_, p_235627_4_, direction), direction) : isConnected(p_235627_3_, NORTH_SHAPE);
        boolean flag1 = p_235627_6_ == Direction.EAST ? this.canAttachTo(p_235627_5_, p_235627_5_.isSideSolidFullSquare(p_235627_1_, p_235627_4_, direction), direction) : isConnected(p_235627_3_, EAST_SHAPE);
        boolean flag2 = p_235627_6_ == Direction.SOUTH ? this.canAttachTo(p_235627_5_, p_235627_5_.isSideSolidFullSquare(p_235627_1_, p_235627_4_, direction), direction) : isConnected(p_235627_3_, SOUTH_SHAPE);
        boolean flag3 = p_235627_6_ == Direction.WEST ? this.canAttachTo(p_235627_5_, p_235627_5_.isSideSolidFullSquare(p_235627_1_, p_235627_4_, direction), direction) : isConnected(p_235627_3_, WEST_SHAPE);
        BlockPos blockpos = p_235627_2_.up();
        BlockState blockstate = p_235627_1_.getBlockState(blockpos);
        return this.getStateWith(p_235627_1_, p_235627_3_, blockpos, blockstate, flag, flag1, flag2, flag3);
    }

    private BlockState getStateWith(WorldView p_235626_1_, BlockState p_235626_2_, BlockPos p_235626_3_, BlockState p_235626_4_, boolean p_235626_5_, boolean p_235626_6_, boolean p_235626_7_, boolean p_235626_8_) {
        VoxelShape voxelshape = p_235626_4_.getCollisionShape(p_235626_1_, p_235626_3_).getFace(Direction.DOWN);
        BlockState blockstate = this.getStateWith(p_235626_2_, p_235626_5_, p_235626_6_, p_235626_7_, p_235626_8_, voxelshape);
        return blockstate.with(UP, Boolean.valueOf(this.shouldHavePost(blockstate, p_235626_4_, voxelshape)));
    }

    private boolean shouldHavePost(BlockState p_235628_1_, BlockState p_235628_2_, VoxelShape p_235628_3_) {
        boolean flag = p_235628_2_.getBlock() instanceof WallBlock && p_235628_2_.get(UP);
        if (flag) {
            return true;
        } else {
            WallShape wallheight = p_235628_1_.get(NORTH_SHAPE);
            WallShape wallheight1 = p_235628_1_.get(SOUTH_SHAPE);
            WallShape wallheight2 = p_235628_1_.get(EAST_SHAPE);
            WallShape wallheight3 = p_235628_1_.get(WEST_SHAPE);
            boolean flag1 = wallheight1 == WallShape.NONE;
            boolean flag2 = wallheight3 == WallShape.NONE;
            boolean flag3 = wallheight2 == WallShape.NONE;
            boolean flag4 = wallheight == WallShape.NONE;
            boolean flag5 = flag4 && flag1 && flag2 && flag3 || flag4 != flag1 || flag2 != flag3;
            if (flag5) {
                return true;
            } else {
                boolean flag6 = wallheight == WallShape.TALL && wallheight1 == WallShape.TALL || wallheight2 == WallShape.TALL && wallheight3 == WallShape.TALL;
                if (flag6) {
                    return false;
                } else {
                    return p_235628_2_.isIn(BlockTags.WALL_POST_OVERRIDE) || shouldUseTallShape(p_235628_3_, POST_TEST);
                }
            }
        }
    }

    private BlockState getStateWith(BlockState p_235630_1_, boolean p_235630_2_, boolean p_235630_3_, boolean p_235630_4_, boolean p_235630_5_, VoxelShape p_235630_6_) {
        return p_235630_1_.with(NORTH_SHAPE, this.getWallShape(p_235630_2_, p_235630_6_, NORTH_TEST)).with(EAST_SHAPE, this.getWallShape(p_235630_3_, p_235630_6_, EAST_TEST)).with(SOUTH_SHAPE, this.getWallShape(p_235630_4_, p_235630_6_, SOUTH_TEST)).with(WEST_SHAPE, this.getWallShape(p_235630_5_, p_235630_6_, WEST_TEST));
    }

    private WallShape getWallShape(boolean p_235633_1_, VoxelShape p_235633_2_, VoxelShape p_235633_3_) {
        if (p_235633_1_) {
            return shouldUseTallShape(p_235633_2_, p_235633_3_) ? WallShape.TALL : WallShape.LOW;
        } else {
            return WallShape.NONE;
        }
    }
}
