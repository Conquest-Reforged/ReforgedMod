package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s_slab", template = "parent_slab"),
        item = @Model(name = "item/%s_slab", parent = "block/%s_slab_bottom_4", template = "item/acacia_slab"),
        block = {
                @Model(name = "block/%s_slab_bottom_1", template = "block/parent_slab_bottom_1"),
                @Model(name = "block/%s_slab_bottom_2", template = "block/parent_slab_bottom_2"),
                @Model(name = "block/%s_slab_bottom_3", template = "block/parent_slab_bottom_3"),
                @Model(name = "block/%s_slab_bottom_4", template = "block/parent_slab_bottom_4"),
                @Model(name = "block/%s_slab_bottom_5", template = "block/parent_slab_bottom_5"),
                @Model(name = "block/%s_slab_bottom_6", template = "block/parent_slab_bottom_6"),
                @Model(name = "block/%s_slab_bottom_7", template = "block/parent_slab_bottom_7"),
                @Model(name = "block/%s_slab_top_1", template = "block/parent_slab_top_1"),
                @Model(name = "block/%s_slab_top_2", template = "block/parent_slab_top_2"),
                @Model(name = "block/%s_slab_top_3", template = "block/parent_slab_top_3"),
                @Model(name = "block/%s_slab_top_4", template = "block/parent_slab_top_4"),
                @Model(name = "block/%s_slab_top_5", template = "block/parent_slab_top_5"),
                @Model(name = "block/%s_slab_top_6", template = "block/parent_slab_top_6"),
                @Model(name = "block/%s_slab_top_7", template = "block/parent_slab_top_7"),
                @Model(name = "block/%s", template = "block/parent_cube")
        }
)
public class Slab extends WaterloggedShape {

    public static final IntProperty LAYERS = Properties.LAYERS;

    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);
    public static final VoxelShape[] BOTTOM_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    public static final VoxelShape[] TOP_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 6.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 2.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public Slab(Props props) {
        super(props.toSettings());
        this.setDefaultState((this.stateManager.getDefaultState()).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, false));
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        Direction facing = context.getSide();

        ItemStack item = context.getStack();
        if (item.getItem() != this.asItem() || state.get(LAYERS) == 8) {
            return false;
        }

        if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            return facing == Direction.UP;
        } else {
            return facing == Direction.DOWN;
        }
    }

    @Override
    public boolean isTranslucent(BlockState p_200123_1_, BlockView p_200123_2_, BlockPos p_200123_3_) {
        return false;
    }


    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.TOP) {
            return TOP_SHAPE[state.get(LAYERS) - 1];
        } else {
            return BOTTOM_SHAPE[state.get(LAYERS) - 1];
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(LAYERS) == 8) {
            return Layer.SPECIAL_FULL_SHAPE_COLLISION;
        } else {
            if (state.get(TYPE_UPDOWN) == BlockHalf.TOP) {
                return TOP_SHAPE[state.get(LAYERS) - 1];
            } else {
                return BOTTOM_SHAPE[state.get(LAYERS) - 1];
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        if (state.getBlock() == this) {
            int i = state.get(LAYERS);
            return state.with(LAYERS, Math.min(8, i + 1));
        } else {
            FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
            BlockState state2 = this.getDefaultState().with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);

            Direction facing = context.getSide();
            return facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double) blockpos.getY() > 0.5D)) ? state2 : state2.with(TYPE_UPDOWN, BlockHalf.TOP);
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN).add(LAYERS);
    }
}