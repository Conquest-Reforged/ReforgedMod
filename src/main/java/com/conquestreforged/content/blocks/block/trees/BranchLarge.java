package com.conquestreforged.content.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalConnectingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

@Assets(
        state = @State(name = "%s_large_branch", template = "parent_large_branch"),
        item = @Model(name = "item/%s_large_branch", parent = "block/%s_large_branch_post", template = "item/cobblestone_wall"),
        block = {
                @Model(name = "block/%s_large_branch_post", template = "block/parent_large_branch_post"),
                @Model(name = "block/%s_large_branch_n", template = "block/parent_large_branch_n"),
                @Model(name = "block/%s_large_branch_n_1", template = "block/parent_large_branch_n_1"),
                @Model(name = "block/%s_large_branch_ne", template = "block/parent_large_branch_ne"),
                @Model(name = "block/%s_large_branch_nse", template = "block/parent_large_branch_nse"),
                @Model(name = "block/%s_large_branch_ns", template = "block/parent_large_branch_ns"),
                @Model(name = "block/%s_large_branch_ns_up", template = "block/parent_large_branch_ns_up"),
                @Model(name = "block/%s_large_branch_nsew", template = "block/parent_large_branch_nsew"),
                @Model(name = "block/%s_large_branch_n_up", template = "block/parent_large_branch_n_up"),
                @Model(name = "block/%s_large_branch_n_up", template = "block/parent_large_branch_n_up_1"),
                @Model(name = "block/%s_large_branch_ne_up", template = "block/parent_large_branch_ne_up"),
                @Model(name = "block/%s_large_branch_nse_up", template = "block/parent_large_branch_nse_up"),
                @Model(name = "block/%s_large_branch_nsew_up", template = "block/parent_large_branch_nsew_up"),
        }
)
public class BranchLarge extends HorizontalConnectingBlock {

    public static final BooleanProperty UP = Properties.UP;
    private final VoxelShape[] wallUpShapes;
    private final VoxelShape[] wallRegularShapes;

    public BranchLarge(Settings properties) {
        super(0.0F, 3.0F, 8.0F, 16.0F, 16.0F, properties);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(UP, true)
                .with(NORTH, false)
                .with(EAST, false)
                .with(SOUTH, false)
                .with(WEST, false)
                .with(WATERLOGGED, false));
        this.wallUpShapes = this.makeUpShapes(4.0F, 3.0F, 16.0F, 8.0F, 16.0F);
        this.wallRegularShapes = this.makeRegularShapes(4.0F, 3.0F, 16.0F, 8.0F, 16.0F);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallUpShapes[this.getShapeIndex(state)] : this.wallRegularShapes[this.getShapeIndex(state)];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallUpShapes[this.getShapeIndex(state)] : this.wallRegularShapes[this.getShapeIndex(state)];
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        WorldView iworldreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockState blockstate = iworldreader.getBlockState(blockpos1);
        BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
        BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
        BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
        BlockState blockstateDown = context.getWorld().getBlockState(context.getBlockPos().down());

        boolean flagDown = false;
        if (blockstateDown.isOpaque()) {
            flagDown = true;
        }

        boolean flag = this.getConnection(blockstate);
        boolean flag1 = this.getConnection(blockstate1);
        boolean flag2 = this.getConnection(blockstate2);
        boolean flag3 = this.getConnection(blockstate3);
        return this.getDefaultState().with(UP, flagDown).with(NORTH, flag).with(EAST, flag1).with(SOUTH, flag2).with(WEST, flag3).with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    public boolean allowsMovement(BlockState state, BlockView worldIn, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        Direction direction = facing.getOpposite();

        if (stateIn.get(WATERLOGGED)) {
            worldIn.createAndScheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        if (facing == Direction.DOWN) {
            boolean flag =  ((facingState.isSideSolidFullSquare(worldIn, facingPos, direction) || (facingState.getBlock() instanceof BranchLarge) || (facingState.getBlock() instanceof Branch) || (facingState.getBlock() instanceof BranchSmall)));
            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos).with(UP, flag);
        } else {
            boolean flag = facing == Direction.NORTH ? this.getConnection(facingState) : stateIn.get(NORTH);
            boolean flag1 = facing == Direction.EAST ? this.getConnection(facingState) : stateIn.get(EAST);
            boolean flag2 = facing == Direction.SOUTH ? this.getConnection(facingState) : stateIn.get(SOUTH);
            boolean flag3 = facing == Direction.WEST ? this.getConnection(facingState) : stateIn.get(WEST);
            return stateIn.with(NORTH, flag).with(EAST, flag1).with(SOUTH, flag2).with(WEST, flag3);
        }
    }

    private boolean getConnection(BlockState p_220113_1_) {
        Block block = p_220113_1_.getBlock();
        boolean flag = block instanceof BranchLarge || block instanceof Branch || block instanceof BranchSmall;
        return flag;
    }

    protected VoxelShape[] makeUpShapes(float nodeWidth, float extensionWidth, float nodeHeight, float extensionBeginning, float extensionHeight) {
        float f = 8.0F - nodeWidth;
        float f1 = 8.0F + nodeWidth;
        float f2 = 8.0F - extensionWidth;
        float f3 = 8.0F + extensionWidth;
        VoxelShape voxelshape = Block.createCuboidShape(f, 0.0D, f, f1, nodeHeight, f1);
        VoxelShape voxelshape1 = Block.createCuboidShape(f2, extensionBeginning, 0.0D, f3, extensionHeight, f3);
        VoxelShape voxelshape2 = Block.createCuboidShape(f2, extensionBeginning, f2, f3, extensionHeight, 16.0D);
        VoxelShape voxelshape3 = Block.createCuboidShape(0.0D, extensionBeginning, f2, f3, extensionHeight, f3);
        VoxelShape voxelshape4 = Block.createCuboidShape(f2, extensionBeginning, f2, 16.0D, extensionHeight, f3);
        VoxelShape voxelshape5 = VoxelShapes.union(voxelshape1, voxelshape4);
        VoxelShape voxelshape6 = VoxelShapes.union(voxelshape2, voxelshape3);
        VoxelShape[] avoxelshape = new VoxelShape[]{voxelshape, voxelshape2, voxelshape3, voxelshape6, voxelshape1, VoxelShapes.union(voxelshape2, voxelshape1), VoxelShapes.union(voxelshape3, voxelshape1), VoxelShapes.union(voxelshape6, voxelshape1), voxelshape4, VoxelShapes.union(voxelshape2, voxelshape4), VoxelShapes.union(voxelshape3, voxelshape4), VoxelShapes.union(voxelshape6, voxelshape4), voxelshape5, VoxelShapes.union(voxelshape2, voxelshape5), VoxelShapes.union(voxelshape3, voxelshape5), VoxelShapes.union(voxelshape6, voxelshape5)};

        for(int i = 0; i < 16; ++i) {
            avoxelshape[i] = VoxelShapes.union(voxelshape, avoxelshape[i]);
        }

        return avoxelshape;
    }

    protected VoxelShape[] makeRegularShapes(float nodeWidth, float extensionWidth, float nodeHeight, float extensionBeginning, float extensionHeight) {
        float f = 8.0F - nodeWidth;
        float f1 = 8.0F + nodeWidth;
        float f2 = 8.0F - extensionWidth;
        float f3 = 8.0F + extensionWidth;
        VoxelShape voxelshape = Block.createCuboidShape(f, 0.0D, f, f1, nodeHeight, f1);
        VoxelShape voxelshape1 = Block.createCuboidShape(f2, extensionBeginning, 0.0D, f3, extensionHeight, f3);
        VoxelShape voxelshape2 = Block.createCuboidShape(f2, extensionBeginning, f2, f3, extensionHeight, 16.0D);
        VoxelShape voxelshape3 = Block.createCuboidShape(0.0D, extensionBeginning, f2, f3, extensionHeight, f3);
        VoxelShape voxelshape4 = Block.createCuboidShape(f2, extensionBeginning, f2, 16.0D, extensionHeight, f3);
        VoxelShape voxelshape5 = VoxelShapes.union(voxelshape1, voxelshape4);
        VoxelShape voxelshape6 = VoxelShapes.union(voxelshape2, voxelshape3);
        VoxelShape[] avoxelshape = new VoxelShape[]{voxelshape, voxelshape2, voxelshape3, voxelshape6, voxelshape1, VoxelShapes.union(voxelshape2, voxelshape1), VoxelShapes.union(voxelshape3, voxelshape1), VoxelShapes.union(voxelshape6, voxelshape1), voxelshape4, VoxelShapes.union(voxelshape2, voxelshape4), VoxelShapes.union(voxelshape3, voxelshape4), VoxelShapes.union(voxelshape6, voxelshape4), voxelshape5, VoxelShapes.union(voxelshape2, voxelshape5), VoxelShapes.union(voxelshape3, voxelshape5), VoxelShapes.union(voxelshape6, voxelshape5)};

        return avoxelshape;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
