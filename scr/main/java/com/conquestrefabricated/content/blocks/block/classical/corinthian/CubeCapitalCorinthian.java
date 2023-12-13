package com.conquestrefabricated.content.blocks.block.classical.corinthian;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Map;

@Assets(
        state = @State(name = "%s", template = "parent_doric_capital", plural = true),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/parent_cube", plural = true),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {
                @Model(name = "block/%s", template = "block/parent_doric_capital_full", plural = true),
                @Model(name = "block/%s_n", template = "block/parent_doric_capital_n", plural = true),
                @Model(name = "block/%s_ne", template = "block/parent_doric_capital_ne", plural = true),
                @Model(name = "block/%s_nse", template = "block/parent_doric_capital_nse", plural = true),
                @Model(name = "block/%s_fullplain", template = "block/parent_doric_capital_fullplain", plural = true),
                @Model(name = "block/%s_ns", template = "block/parent_doric_capital_ns", plural = true),
                @Model(name = "block/%s_ns_1", template = "block/parent_doric_capital_ns_1", plural = true)
        }
)
public class CubeCapitalCorinthian extends Block {

    public static final BooleanProperty NORTH = ConnectingBlock.NORTH;
    public static final BooleanProperty EAST = ConnectingBlock.EAST;
    public static final BooleanProperty SOUTH = ConnectingBlock.SOUTH;
    public static final BooleanProperty WEST = ConnectingBlock.WEST;
    private static final VoxelShape SHAPE = Block.createCuboidShape(0.1D, 0.1D, 0.1D, 15.9D, 15.9D, 15.9D);
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ConnectingBlock.FACING_PROPERTIES.entrySet().stream().filter((p_52346_) -> {
        return p_52346_.getKey().getAxis().isHorizontal();
    }).collect(Util.toMap());
    public CubeCapitalCorinthian(Settings properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(NORTH, false).with(EAST, false).with(SOUTH, false).with(WEST, false));
    }

    public boolean canConnect(BlockState state, boolean flag, Direction direction) {
        return state.getBlock() instanceof CubeCapitalCorinthian;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockState blockstate = iblockreader.getBlockState(blockpos1);
        BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos4);
        return super.getPlacementState(context)
                .with(NORTH, this.canConnect(blockstate, blockstate.isSideSolidFullSquare(iblockreader, blockpos1, Direction.SOUTH), Direction.SOUTH))
                .with(EAST, this.canConnect(blockstate1, blockstate1.isSideSolidFullSquare(iblockreader, blockpos2, Direction.WEST), Direction.WEST))
                .with(SOUTH, this.canConnect(blockstate2, blockstate2.isSideSolidFullSquare(iblockreader, blockpos3, Direction.NORTH), Direction.NORTH))
                .with(WEST, this.canConnect(blockstate3, blockstate3.isSideSolidFullSquare(iblockreader, blockpos4, Direction.EAST), Direction.EAST));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        return facing.getAxis().getType() == Direction.Type.HORIZONTAL ? stateIn.with(PROPERTY_BY_DIRECTION.get(facing), this.canConnect(facingState, facingState.isSideSolidFullSquare(world, facingPos, facing.getOpposite()), facing.getOpposite())) : super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH);
    }
}