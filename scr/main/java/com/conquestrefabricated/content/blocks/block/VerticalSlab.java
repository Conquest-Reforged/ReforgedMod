package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.content.blocks.block.util.PlacementHelper;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

@Assets(
        state = @State(name = "%s_vertical_slab", template = "parent_vertical_slab"),
        item = @Model(name = "item/%s_vertical_slab", parent = "block/%s_vertical_slab_4", template = "item/parent_vertical_slab"),
        block = {
                @Model(name = "block/%s_vertical_slab_1", template = "block/parent_vertical_slab_1"),
                @Model(name = "block/%s_vertical_slab_2", template = "block/parent_vertical_slab_2"),
                @Model(name = "block/%s_vertical_slab_4", template = "block/parent_vertical_slab_4"),
                @Model(name = "block/%s_vertical_slab_6", template = "block/parent_vertical_slab_6"),
        }
)
public class VerticalSlab extends WaterloggedHorizontalDirectionalShape {

    public static final IntProperty LAYERS = IntProperty.of("layer", 1, 4);

    public static final VoxelShape[] EAST_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D),Block.createCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D)};
    public static final VoxelShape[] WEST_SHAPE = new VoxelShape[]{Block.createCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    public static final VoxelShape[] SOUTH_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D)};
    public static final VoxelShape[] NORTH_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D)};
    private Block fullBlock;


    public VerticalSlab(Props props) {
        super(props.toSettings());
        this.setDefaultState((this.stateManager.getDefaultState()).with(DIRECTION, Direction.NORTH).with(WATERLOGGED, false));
        this.fullBlock = props.getParent().getBlock();
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
            case NORTH:
            default:
                return NORTH_SHAPE[state.get(LAYERS) - 1];
            case SOUTH:
                return SOUTH_SHAPE[state.get(LAYERS) - 1];
            case WEST:
                return WEST_SHAPE[state.get(LAYERS) - 1];
            case EAST:
                return EAST_SHAPE[state.get(LAYERS) - 1];
        }
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        int i = state.get(LAYERS);
        if (context.getStack().getItem() == this.asItem() && i <= 4) {
            if (PlacementHelper.replacingClickedOnBlock(context)) {
                return context.getSide() == state.get(DIRECTION);
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            if (i == 4) {
                return fullBlock.getDefaultState();
            }
            return blockstate.with(LAYERS, Math.min(4, i + 1));
        } else {
            return super.getPlacementState(context);
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }
}
