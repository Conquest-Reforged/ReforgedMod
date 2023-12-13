package com.conquestreforged.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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
public class BranchLarge extends CrossCollisionBlock {

    public static final BooleanProperty UP = BlockStateProperties.UP;
    private final VoxelShape[] wallUpShapes;
    private final VoxelShape[] wallRegularShapes;

    public BranchLarge(Properties properties) {
        super(0.0F, 3.0F, 8.0F, 16.0F, 16.0F, properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(UP, true)
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(WATERLOGGED, false));
        this.wallUpShapes = this.makeUpShapes(4.0F, 3.0F, 16.0F, 8.0F, 16.0F);
        this.wallRegularShapes = this.makeRegularShapes(4.0F, 3.0F, 16.0F, 8.0F, 16.0F);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(UP) ? this.wallUpShapes[this.getAABBIndex(state)] : this.wallRegularShapes[this.getAABBIndex(state)];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(UP) ? this.wallUpShapes[this.getAABBIndex(state)] : this.wallRegularShapes[this.getAABBIndex(state)];
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelReader iworldreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos blockpos1 = blockpos.m_142127_();
        BlockPos blockpos2 = blockpos.m_142126_();
        BlockPos blockpos3 = blockpos.m_142128_();
        BlockPos blockpos4 = blockpos.m_142125_();
        BlockState blockstate = iworldreader.getBlockState(blockpos1);
        BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
        BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
        BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
        BlockState blockstateDown = context.getLevel().getBlockState(context.getClickedPos().below());

        boolean flagDown = false;
        if (blockstateDown.canOcclude()) {
            flagDown = true;
        }

        boolean flag = this.getConnection(blockstate);
        boolean flag1 = this.getConnection(blockstate1);
        boolean flag2 = this.getConnection(blockstate2);
        boolean flag3 = this.getConnection(blockstate3);
        return this.defaultBlockState().setValue(UP, flagDown).setValue(NORTH, flag).setValue(EAST, flag1).setValue(SOUTH, flag2).setValue(WEST, flag3).setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
    }

    public boolean allowsMovement(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        Direction direction = facing.getOpposite();

        if (stateIn.getValue(WATERLOGGED)) {
            worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        if (facing == Direction.DOWN) {
            boolean flag =  ((facingState.isFaceSturdy(worldIn, facingPos, direction) || (facingState.getBlock() instanceof BranchLarge) || (facingState.getBlock() instanceof Branch) || (facingState.getBlock() instanceof BranchSmall)));
            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos).setValue(UP, flag);
        } else {
            boolean flag = facing == Direction.NORTH ? this.getConnection(facingState) : stateIn.getValue(NORTH);
            boolean flag1 = facing == Direction.EAST ? this.getConnection(facingState) : stateIn.getValue(EAST);
            boolean flag2 = facing == Direction.SOUTH ? this.getConnection(facingState) : stateIn.getValue(SOUTH);
            boolean flag3 = facing == Direction.WEST ? this.getConnection(facingState) : stateIn.getValue(WEST);
            return stateIn.setValue(NORTH, flag).setValue(EAST, flag1).setValue(SOUTH, flag2).setValue(WEST, flag3);
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
        VoxelShape voxelshape = Block.box(f, 0.0D, f, f1, nodeHeight, f1);
        VoxelShape voxelshape1 = Block.box(f2, extensionBeginning, 0.0D, f3, extensionHeight, f3);
        VoxelShape voxelshape2 = Block.box(f2, extensionBeginning, f2, f3, extensionHeight, 16.0D);
        VoxelShape voxelshape3 = Block.box(0.0D, extensionBeginning, f2, f3, extensionHeight, f3);
        VoxelShape voxelshape4 = Block.box(f2, extensionBeginning, f2, 16.0D, extensionHeight, f3);
        VoxelShape voxelshape5 = Shapes.or(voxelshape1, voxelshape4);
        VoxelShape voxelshape6 = Shapes.or(voxelshape2, voxelshape3);
        VoxelShape[] avoxelshape = new VoxelShape[]{voxelshape, voxelshape2, voxelshape3, voxelshape6, voxelshape1, Shapes.or(voxelshape2, voxelshape1), Shapes.or(voxelshape3, voxelshape1), Shapes.or(voxelshape6, voxelshape1), voxelshape4, Shapes.or(voxelshape2, voxelshape4), Shapes.or(voxelshape3, voxelshape4), Shapes.or(voxelshape6, voxelshape4), voxelshape5, Shapes.or(voxelshape2, voxelshape5), Shapes.or(voxelshape3, voxelshape5), Shapes.or(voxelshape6, voxelshape5)};

        for(int i = 0; i < 16; ++i) {
            avoxelshape[i] = Shapes.or(voxelshape, avoxelshape[i]);
        }

        return avoxelshape;
    }

    protected VoxelShape[] makeRegularShapes(float nodeWidth, float extensionWidth, float nodeHeight, float extensionBeginning, float extensionHeight) {
        float f = 8.0F - nodeWidth;
        float f1 = 8.0F + nodeWidth;
        float f2 = 8.0F - extensionWidth;
        float f3 = 8.0F + extensionWidth;
        VoxelShape voxelshape = Block.box(f, 0.0D, f, f1, nodeHeight, f1);
        VoxelShape voxelshape1 = Block.box(f2, extensionBeginning, 0.0D, f3, extensionHeight, f3);
        VoxelShape voxelshape2 = Block.box(f2, extensionBeginning, f2, f3, extensionHeight, 16.0D);
        VoxelShape voxelshape3 = Block.box(0.0D, extensionBeginning, f2, f3, extensionHeight, f3);
        VoxelShape voxelshape4 = Block.box(f2, extensionBeginning, f2, 16.0D, extensionHeight, f3);
        VoxelShape voxelshape5 = Shapes.or(voxelshape1, voxelshape4);
        VoxelShape voxelshape6 = Shapes.or(voxelshape2, voxelshape3);
        VoxelShape[] avoxelshape = new VoxelShape[]{voxelshape, voxelshape2, voxelshape3, voxelshape6, voxelshape1, Shapes.or(voxelshape2, voxelshape1), Shapes.or(voxelshape3, voxelshape1), Shapes.or(voxelshape6, voxelshape1), voxelshape4, Shapes.or(voxelshape2, voxelshape4), Shapes.or(voxelshape3, voxelshape4), Shapes.or(voxelshape6, voxelshape4), voxelshape5, Shapes.or(voxelshape2, voxelshape5), Shapes.or(voxelshape3, voxelshape5), Shapes.or(voxelshape6, voxelshape5)};

        return avoxelshape;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
