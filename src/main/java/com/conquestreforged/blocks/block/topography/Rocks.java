package com.conquestreforged.blocks.block.topography;

import com.conquestreforged.blocks.block.Layer;
import com.conquestreforged.blocks.block.Slab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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

    public static final BooleanProperty NORTH = PipeBlock.NORTH;
    public static final BooleanProperty EAST = PipeBlock.EAST;
    public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
    public static final BooleanProperty WEST = PipeBlock.WEST;
    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS;
    private static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);

    public Rocks(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(WATERLOGGED, false)
                .setValue(LAYERS, 8));
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        BlockPos down = currentPos.below();
        BlockState blockStateDown = world.getBlockState(down);

        if (blockStateDown.hasProperty(Layer.LAYERS) || blockStateDown.hasProperty(Slab.LAYERS)) {
            return super.updateShape(stateIn, facing, facingState, world, currentPos, facingPos)
                    .setValue(NORTH, canConnectTo(world, currentPos.m_142127_().below()))
                    .setValue(EAST, canConnectTo(world, currentPos.m_142126_().below()))
                    .setValue(SOUTH, canConnectTo(world, currentPos.m_142128_().below()))
                    .setValue(WEST, canConnectTo(world, currentPos.m_142125_().below()))
                    .setValue(LAYERS, blockStateDown.getValue(LAYERS));
        } else {
            return super.updateShape(stateIn, facing, facingState, world, currentPos, facingPos)
                    .setValue(NORTH, canConnectTo(world, currentPos.m_142127_().below()))
                    .setValue(EAST, canConnectTo(world, currentPos.m_142126_().below()))
                    .setValue(SOUTH, canConnectTo(world, currentPos.m_142128_().below()))
                    .setValue(WEST, canConnectTo(world, currentPos.m_142125_().below()))
                    .setValue(LAYERS, 8);
        }
    }

    private boolean canConnectTo(LevelAccessor world, BlockPos pos) {
        BlockState blockstate = world.getBlockState(pos);
        return blockstate.canOcclude();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());

        BlockPos pos = context.getClickedPos();
        BlockGetter iblockreader = context.getLevel();
        BlockState north = iblockreader.getBlockState(pos.m_142127_().below());
        BlockState east = iblockreader.getBlockState(pos.m_142126_().below());
        BlockState south = iblockreader.getBlockState(pos.m_142128_().below());
        BlockState west = iblockreader.getBlockState(pos.m_142125_().below());

        BlockPos down = pos.below();
        BlockState blockStateDown = iblockreader.getBlockState(down);

        if (blockStateDown.hasProperty(Layer.LAYERS) || blockStateDown.hasProperty(Slab.LAYERS)) {
            return super.getStateForPlacement(context)
                    .setValue(NORTH, north.canOcclude())
                    .setValue(EAST, east.canOcclude())
                    .setValue(SOUTH, south.canOcclude())
                    .setValue(WEST, west.canOcclude())
                    .setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER)
                    .setValue(LAYERS, blockStateDown.getValue(LAYERS));
        } else {
            return super.getStateForPlacement(context)
                    .setValue(NORTH, north.canOcclude())
                    .setValue(EAST, east.canOcclude())
                    .setValue(SOUTH, south.canOcclude())
                    .setValue(WEST, west.canOcclude())
                    .setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER)
                    .setValue(LAYERS, 8);
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, LAYERS);
    }

    @Override
    public Block.OffsetType m_5858_() {
        return Block.OffsetType.XZ;
    }
}