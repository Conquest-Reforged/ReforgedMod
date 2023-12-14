package com.conquestreforged.content.blocks.block;

import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

@Assets(
        state = @State(name = "%s_quarter_slab", template = "parent_slab_quarter"),
        item = @Model(name = "item/%s_quarter_slab", parent = "block/%s_slab_quarter_4", template = "item/parent_slab_quarter"),
        block = {
                @Model(name = "block/%s_slab_quarter_2", template = "block/parent_slab_quarter_2"),
                @Model(name = "block/%s_slab_quarter_4", template = "block/parent_slab_quarter_4"),
                @Model(name = "block/%s_slab_quarter_6", template = "block/parent_slab_quarter_6"),
                @Model(name = "block/%s_slab_quarter_2_top", template = "block/parent_slab_quarter_2_top"),
                @Model(name = "block/%s_slab_quarter_4_top", template = "block/parent_slab_quarter_4_top"),
                @Model(name = "block/%s_slab_quarter_6_top", template = "block/parent_slab_quarter_6_top")
        }
)
public class SlabQuarter extends WaterloggedHorizontalDirectionalShape {

    public static final IntProperty LAYERS = IntProperty.of("layer", 1, 3);


    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);
    public static final VoxelShape[] BOTTOM_SOUTH_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 4.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 12.0D)};
    public static final VoxelShape[] BOTTOM_NORTH_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 12.0D, 16.0D, 4.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 12.0D, 16.0D)};
    public static final VoxelShape[] BOTTOM_WEST_SHAPE = new VoxelShape[]{Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(4.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D)};
    public static final VoxelShape[] BOTTOM_EAST_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 4.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 12.0D, 16.0D)};
    public static final VoxelShape[] TOP_SOUTH_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 4.0D), Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 12.0D)};
    public static final VoxelShape[] TOP_NORTH_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 12.0D, 12.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 4.0D, 4.0D, 16.0D, 16.0D, 16.0D)};
    public static final VoxelShape[] TOP_WEST_SHAPE = new VoxelShape[]{Block.createCuboidShape(12.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(4.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    public static final VoxelShape[] TOP_EAST_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 12.0D, 0.0D, 4.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 4.0D, 0.0D, 12.0D, 16.0D, 16.0D)};

    private Block fullBlock;

    public SlabQuarter(Props props) {
        super(props.toSettings());
        this.fullBlock = props.getParent().getBlock();
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, false));
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        int i = state.get(LAYERS);
        if (context.getStack().getItem() == this.asItem() && i <= 3) {
            if (PlacementHelper.replacingClickedOnBlock(context)) {
                return context.getSide() == state.get(DIRECTION) || context.getSide() == state.get(DIRECTION).rotateYCounterclockwise();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        FluidState fluid = context.getWorld().getFluidState(blockpos);
        Direction facingHorizontal = context.getPlayerFacing().getOpposite();
        BlockState state2 = this.getDefaultState().with(DIRECTION, facingHorizontal).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
        Direction facing = context.getSide();
        BlockState blockstate = context.getWorld().getBlockState(blockpos);
        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            if (i == 3) {
                return fullBlock.getDefaultState();
            }
            return blockstate.with(LAYERS, Math.min(3, i + 1));
        }
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double)blockpos.getY() > 0.5D)) ? state2 : state2.with(TYPE_UPDOWN, BlockHalf.TOP);
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN, LAYERS);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return BOTTOM_NORTH_SHAPE[state.get(LAYERS) - 1];
                case SOUTH:
                    return BOTTOM_SOUTH_SHAPE[state.get(LAYERS) - 1];
                case WEST:
                    return BOTTOM_WEST_SHAPE[state.get(LAYERS) - 1];
                case EAST:
                    return BOTTOM_EAST_SHAPE[state.get(LAYERS) - 1];
            }
        } else {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return TOP_NORTH_SHAPE[state.get(LAYERS) - 1];
                case SOUTH:
                    return TOP_SOUTH_SHAPE[state.get(LAYERS) - 1];
                case WEST:
                    return TOP_WEST_SHAPE[state.get(LAYERS) - 1];
                case EAST:
                    return TOP_EAST_SHAPE[state.get(LAYERS) - 1];
            }
        }
    }
}