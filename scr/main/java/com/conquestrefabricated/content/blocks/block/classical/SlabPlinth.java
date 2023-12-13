package com.conquestrefabricated.content.blocks.block.classical;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Map;

//only used for variant name
@Assets(
        state = @State(name = "%s_slab", template = "parent_doric_base_vertical_slab"),
        item = @Model(name = "item/%s_vertical_slab", parent = "block/%s_vertical_slab", template = "item/parent_vertical_slab"),
        block = {
                @Model(name = "block/%s_vertical_slab", template = "block/parent_doric_base_vertical_slab"),
        }
)
public class SlabPlinth extends WaterloggedShape {

    public static final BooleanProperty NORTH = ConnectingBlock.NORTH;
    public static final BooleanProperty EAST = ConnectingBlock.EAST;
    public static final BooleanProperty SOUTH = ConnectingBlock.SOUTH;
    public static final BooleanProperty WEST = ConnectingBlock.WEST;
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ConnectingBlock.FACING_PROPERTIES.entrySet().stream().filter((p_52346_) -> {
        return p_52346_.getKey().getAxis().isHorizontal();
    }).collect(Util.toMap());
    private static final VoxelShape BOTTOM_SHAPE = Block.createCuboidShape(0.1D, 0.1D, 0.1D, 15.9D, 8.0D, 15.9D);
    private static final VoxelShape TOP_SHAPE = Block.createCuboidShape(0.1D, 8.0D, 0.1D, 15.9D, 15.9D, 15.9D);
    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);

    public SlabPlinth(Settings properties) {
        super(properties);
        this.setDefaultState((this.stateManager.getDefaultState()).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, false));
    }

    @Override
    public boolean isTranslucent(BlockState p_200123_1_, BlockView p_200123_2_, BlockPos p_200123_3_) {
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.TOP) {
            return TOP_SHAPE;
        } else {
            return BOTTOM_SHAPE;
        }
    }

    public boolean func_220111_a(BlockState state, BlockState stateOriginal) {
        Block block = state.getBlock();
        boolean flag1 = block instanceof CubeCapital || (block instanceof SlabPlinth && state.get(TYPE_UPDOWN) == stateOriginal.get(TYPE_UPDOWN));
        return flag1;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {

        return facing.getAxis().getType() == Direction.Type.HORIZONTAL ? stateIn.with(PROPERTY_BY_DIRECTION.get(facing), this.func_220111_a(facingState, stateIn)) : super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos);
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

        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        BlockState state2 = this.getDefaultState().with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
        Direction facing = context.getSide();
        BlockState halfState = facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double) blockpos.getY() > 0.5D)) ? state2 : state2.with(TYPE_UPDOWN, BlockHalf.TOP);
        BlockState finalState = halfState.with(NORTH, this.func_220111_a(blockstate, halfState)).with(EAST, this.func_220111_a(blockstate1, halfState)).with(SOUTH, this.func_220111_a(blockstate2, halfState)).with(WEST, this.func_220111_a(blockstate3, halfState));
        return finalState;
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN).add(NORTH).add(WEST).add(SOUTH).add(EAST);
    }
}
