package com.conquestrefabricated.content.blocks.block.topography;

import com.conquestrefabricated.content.blocks.block.Layer;
import com.conquestrefabricated.content.blocks.block.Slab;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

@Assets(
        state = @State(name = "%s_rocks", template = "parent_rocks"),
        item = @Model(name = "item/%s_rocks", parent = "block/%s_rocks_1_8", template = "item/parent_round_arch"),
        block = {
                @Model(name = "block/%s_rocks_1_1", template = "block/parent_rocks_1_1"),
                @Model(name = "block/%s_rocks_1_2", template = "block/parent_rocks_1_2"),
                @Model(name = "block/%s_rocks_1_3", template = "block/parent_rocks_1_3"),
                @Model(name = "block/%s_rocks_1_4", template = "block/parent_rocks_1_4"),
                @Model(name = "block/%s_rocks_1_5", template = "block/parent_rocks_1_5"),
                @Model(name = "block/%s_rocks_1_6", template = "block/parent_rocks_1_6"),
                @Model(name = "block/%s_rocks_1_7", template = "block/parent_rocks_1_7"),
                @Model(name = "block/%s_rocks_1_8", template = "block/parent_rocks_1_8"),
                @Model(name = "block/%s_rocks_2_8", template = "block/parent_rocks_2_8"),
                @Model(name = "block/%s_rocks_2_ne_8", template = "block/parent_rocks_2_ne_8"),
                @Model(name = "block/%s_rocks_2_none_1", template = "block/parent_rocks_2_none_1"),
                @Model(name = "block/%s_rocks_2_none_2", template = "block/parent_rocks_2_none_2"),
                @Model(name = "block/%s_rocks_2_none_3", template = "block/parent_rocks_2_none_3"),
                @Model(name = "block/%s_rocks_2_none_4", template = "block/parent_rocks_2_none_4"),
                @Model(name = "block/%s_rocks_2_none_5", template = "block/parent_rocks_2_none_5"),
                @Model(name = "block/%s_rocks_2_none_6", template = "block/parent_rocks_2_none_6"),
                @Model(name = "block/%s_rocks_2_none_7", template = "block/parent_rocks_2_none_7"),
                @Model(name = "block/%s_rocks_2_none_8", template = "block/parent_rocks_2_none_8"),
                @Model(name = "block/%s_rocks_2_nse_8", template = "block/parent_rocks_2_nse_8"),
                @Model(name = "block/%s_rocks_3_8", template = "block/parent_rocks_3_8"),
                @Model(name = "block/%s_rocks_3_n_8", template = "block/parent_rocks_3_n_8"),
                @Model(name = "block/%s_rocks_3_ne_8", template = "block/parent_rocks_3_ne_8"),
                @Model(name = "block/%s_rocks_3_none_1", template = "block/parent_rocks_3_none_1"),
                @Model(name = "block/%s_rocks_3_none_2", template = "block/parent_rocks_3_none_2"),
                @Model(name = "block/%s_rocks_3_none_3", template = "block/parent_rocks_3_none_3"),
                @Model(name = "block/%s_rocks_3_none_4", template = "block/parent_rocks_3_none_4"),
                @Model(name = "block/%s_rocks_3_none_5", template = "block/parent_rocks_3_none_5"),
                @Model(name = "block/%s_rocks_3_none_6", template = "block/parent_rocks_3_none_6"),
                @Model(name = "block/%s_rocks_3_none_7", template = "block/parent_rocks_3_none_7"),
                @Model(name = "block/%s_rocks_3_none_8", template = "block/parent_rocks_3_none_8"),
                @Model(name = "block/%s_rocks_4_8", template = "block/parent_rocks_4_8"),
                @Model(name = "block/%s_rocks_5_8", template = "block/parent_rocks_5_8"),
                @Model(name = "block/%s_rocks_5_ne_8", template = "block/parent_rocks_5_ne_8"),
                @Model(name = "block/%s_rocks_5_none_1", template = "block/parent_rocks_5_none_1"),
                @Model(name = "block/%s_rocks_5_none_2", template = "block/parent_rocks_5_none_2"),
                @Model(name = "block/%s_rocks_5_none_3", template = "block/parent_rocks_5_none_3"),
                @Model(name = "block/%s_rocks_5_none_4", template = "block/parent_rocks_5_none_4"),
                @Model(name = "block/%s_rocks_5_none_5", template = "block/parent_rocks_5_none_5"),
                @Model(name = "block/%s_rocks_5_none_6", template = "block/parent_rocks_5_none_6"),
                @Model(name = "block/%s_rocks_5_none_7", template = "block/parent_rocks_5_none_7"),
                @Model(name = "block/%s_rocks_5_none_8", template = "block/parent_rocks_5_none_8"),
                @Model(name = "block/%s_rocks_5_nse_8", template = "block/parent_rocks_5_nse_8"),
                @Model(name = "block/%s_rocks_6", template = "block/parent_rocks_6"),
                @Model(name = "block/%s_rocks_6_n", template = "block/parent_rocks_6_n"),
                @Model(name = "block/%s_rocks_6_ne", template = "block/parent_rocks_6_ne"),
                @Model(name = "block/%s_rocks_6_nse", template = "block/parent_rocks_6_nse"),
                @Model(name = "block/%s_rocks_7", template = "block/parent_rocks_7"),
                @Model(name = "block/%s_rocks_7_n", template = "block/parent_rocks_7_n"),
                @Model(name = "block/%s_rocks_7_ne", template = "block/parent_rocks_7_ne"),
                @Model(name = "block/%s_rocks_7_none_1", template = "block/parent_rocks_7_none_1"),
                @Model(name = "block/%s_rocks_7_none_2", template = "block/parent_rocks_7_none_2"),
                @Model(name = "block/%s_rocks_7_none_3", template = "block/parent_rocks_7_none_3"),
                @Model(name = "block/%s_rocks_7_none_4", template = "block/parent_rocks_7_none_4"),
                @Model(name = "block/%s_rocks_7_none_5", template = "block/parent_rocks_7_none_5"),
                @Model(name = "block/%s_rocks_7_none_6", template = "block/parent_rocks_7_none_6"),
                @Model(name = "block/%s_rocks_7_none_7", template = "block/parent_rocks_7_none_7"),
                @Model(name = "block/%s_rocks_7_none", template = "block/parent_rocks_7_none"),
                @Model(name = "block/%s_rocks_7_ns", template = "block/parent_rocks_7_ns"),
                @Model(name = "block/%s_rocks_7_nse", template = "block/parent_rocks_7_nse"),
                @Model(name = "block/%s_rocks_8", template = "block/parent_rocks_8"),
                @Model(name = "block/%s_rocks_8_n", template = "block/parent_rocks_8_n"),
                @Model(name = "block/%s_rocks_8_ne", template = "block/parent_rocks_8_ne"),
                @Model(name = "block/%s_rocks_8_none_1", template = "block/parent_rocks_8_none_1"),
                @Model(name = "block/%s_rocks_8_none_2", template = "block/parent_rocks_8_none_2"),
                @Model(name = "block/%s_rocks_8_none_3", template = "block/parent_rocks_8_none_3"),
                @Model(name = "block/%s_rocks_8_none_4", template = "block/parent_rocks_8_none_4"),
                @Model(name = "block/%s_rocks_8_none_5", template = "block/parent_rocks_8_none_5"),
                @Model(name = "block/%s_rocks_8_none_6", template = "block/parent_rocks_8_none_6"),
                @Model(name = "block/%s_rocks_8_none_7", template = "block/parent_rocks_8_none_7"),
                @Model(name = "block/%s_rocks_8_none", template = "block/parent_rocks_8_none")
        }
)
public class Rocks extends WaterloggedShape {

    public static final BooleanProperty NORTH = ConnectingBlock.NORTH;
    public static final BooleanProperty EAST = ConnectingBlock.EAST;
    public static final BooleanProperty SOUTH = ConnectingBlock.SOUTH;
    public static final BooleanProperty WEST = ConnectingBlock.WEST;
    public static final IntProperty LAYERS = Properties.LAYERS;
    private static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);

    public Rocks(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(NORTH, false)
                .with(EAST, false)
                .with(SOUTH, false)
                .with(WEST, false)
                .with(WATERLOGGED, false)
                .with(LAYERS, 8));
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess world, BlockPos currentPos, BlockPos facingPos) {
        BlockPos down = currentPos.down();
        BlockState blockStateDown = world.getBlockState(down);

        if (blockStateDown.contains(Layer.LAYERS) || blockStateDown.contains(Slab.LAYERS)) {
            return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos)
                    .with(NORTH, canConnectTo(world, currentPos.north().down()))
                    .with(EAST, canConnectTo(world, currentPos.east().down()))
                    .with(SOUTH, canConnectTo(world, currentPos.south().down()))
                    .with(WEST, canConnectTo(world, currentPos.west().down()))
                    .with(LAYERS, blockStateDown.get(LAYERS));
        } else {
            return super.getStateForNeighborUpdate(stateIn, facing, facingState, world, currentPos, facingPos)
                    .with(NORTH, canConnectTo(world, currentPos.north().down()))
                    .with(EAST, canConnectTo(world, currentPos.east().down()))
                    .with(SOUTH, canConnectTo(world, currentPos.south().down()))
                    .with(WEST, canConnectTo(world, currentPos.west().down()))
                    .with(LAYERS, 8);
        }
    }

    private boolean canConnectTo(WorldAccess world, BlockPos pos) {
        BlockState blockstate = world.getBlockState(pos);
        return blockstate.isOpaque();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState ifluidstate = context.getWorld().getFluidState(context.getBlockPos());

        BlockPos pos = context.getBlockPos();
        BlockView iblockreader = context.getWorld();
        BlockState north = iblockreader.getBlockState(pos.north().down());
        BlockState east = iblockreader.getBlockState(pos.east().down());
        BlockState south = iblockreader.getBlockState(pos.south().down());
        BlockState west = iblockreader.getBlockState(pos.west().down());

        BlockPos down = pos.down();
        BlockState blockStateDown = iblockreader.getBlockState(down);

        if (blockStateDown.contains(Layer.LAYERS) || blockStateDown.contains(Slab.LAYERS)) {
            return super.getPlacementState(context)
                    .with(NORTH, north.isOpaque())
                    .with(EAST, east.isOpaque())
                    .with(SOUTH, south.isOpaque())
                    .with(WEST, west.isOpaque())
                    .with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER)
                    .with(LAYERS, blockStateDown.get(LAYERS));
        } else {
            return super.getPlacementState(context)
                    .with(NORTH, north.isOpaque())
                    .with(EAST, east.isOpaque())
                    .with(SOUTH, south.isOpaque())
                    .with(WEST, west.isOpaque())
                    .with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER)
                    .with(LAYERS, 8);
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, LAYERS);
    }


    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }
}