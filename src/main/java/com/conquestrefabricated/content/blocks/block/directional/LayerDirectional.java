package com.conquestrefabricated.content.blocks.block.directional;


import com.conquestrefabricated.content.blocks.block.util.PlacementHelper;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s_layer", template = "parent_layer"),
        item = @Model(name = "item/%s_layer", parent = "block/%s_layer_height2", template = "item/snow"),
        block = {
                @Model(name = "block/%s_layer_height2", template = "block/snow_height2"),
                @Model(name = "block/%s_layer_height4", template = "block/snow_height4"),
                @Model(name = "block/%s_layer_height6", template = "block/snow_height6"),
                @Model(name = "block/%s_layer_height8", template = "block/snow_height8"),
                @Model(name = "block/%s_layer_height10", template = "block/snow_height10"),
                @Model(name = "block/%s_layer_height12", template = "block/snow_height12"),
                @Model(name = "block/%s_layer_height14", template = "block/snow_height14")
        }
)
public class LayerDirectional extends WaterloggedHorizontalDirectionalShape {

    public static final IntProperty LAYERS = Properties.LAYERS;
    private static final VoxelShape[] BOTTOM_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    private static final VoxelShape SPECIAL_FULL_SHAPE_COLLISION = Block.createCuboidShape(0.0D, 2.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public LayerDirectional(Props props) {
        super(props.toSettings());
        this.setDefaultState(this.stateManager.getDefaultState().with(LAYERS, 1).with(WATERLOGGED, false));
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        if (!PlacementHelper.replacingClickedOnBlock(context)) {
            return false;
        }

        ItemStack item = context.getStack();
        if (item.getItem() != this.asItem()) {
            return false;
        }


        return context.getSide() == Direction.UP;
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return BOTTOM_SHAPE[state.get(LAYERS) - 1];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(LAYERS) == 8) {
            return SPECIAL_FULL_SHAPE_COLLISION;
        }
        return BOTTOM_SHAPE[state.get(LAYERS) - 1];
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        if (state.getBlock() == this) {
            int i = state.get(LAYERS);

            return state.with(LAYERS, Math.min(8, i + 1));
        } else {
            FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
            BlockState state2 = super.getPlacementState(context).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);

            return state2;
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(LAYERS);
    }
}