package com.conquestreforged.blocks.block;


import com.conquestreforged.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

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
                @Model(name = "block/%s_layer_height14", template = "block/snow_height14"),
                @Model(name = "block/%s_layer_height16", template = "block/parent_cube")
        }
)
public class Layer extends WaterloggedShape {

    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS;
    private static final VoxelShape[] BOTTOM_SHAPE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    public static final VoxelShape SPECIAL_FULL_SHAPE_COLLISION = Block.box(0.0D, 2.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public Layer(Props props) {
        super(props.toProperties());
        this.registerDefaultState((this.stateDefinition.any()).setValue(LAYERS, 1).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }


    @Override
    public VoxelShape getShape(BlockState state) {
        return BOTTOM_SHAPE[state.getValue(LAYERS) - 1];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(LAYERS) == 8) {
            return SPECIAL_FULL_SHAPE_COLLISION;
        }
        return BOTTOM_SHAPE[state.getValue(LAYERS) - 1];
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (!PlacementHelper.replacingClickedOnBlock(context)) {
            return false;
        }

        ItemStack item = context.getItemInHand();
        if (item.getItem() != this.asItem() || state.getValue(LAYERS) == 8) {
            return false;
        }


        return context.getClickedFace() == Direction.UP;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (state.getBlock() == this) {
            int i = state.getValue(LAYERS);
            return state.setValue(LAYERS, Math.min(8, i + 1));
        } else {
            FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
            BlockState state2 = this.defaultBlockState().setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);

            return state2;
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(LAYERS);
    }
}