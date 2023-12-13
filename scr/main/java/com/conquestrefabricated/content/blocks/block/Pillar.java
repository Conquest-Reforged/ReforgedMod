package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.content.blocks.block.util.PlacementHelper;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;


@Assets(
        state = @State(name = "%s_pillar", template = "parent_pillar"),
        item = @Model(name = "item/%s_pillar", parent = "block/%s_pillar_4", template = "item/dragon_egg"),
        block = {
                @Model(name = "block/%s_pillar_2", template = "block/parent_pillar_2"),
                @Model(name = "block/%s_pillar_4", template = "block/parent_pillar_4"),
                @Model(name = "block/%s_pillar_6", template = "block/parent_pillar_6"),
        }
)
public class Pillar extends WaterloggedShape {

    public static final IntProperty LAYERS = IntProperty.of("layer", 1, 3);
    protected static final VoxelShape[] SHAPE = new VoxelShape[]{Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D), Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D), Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D)};

    private Block fullBlock;

    public Pillar(Props properties) {
        super(properties.toSettings());
        setDefaultState((this.stateManager.getDefaultState()).with(WATERLOGGED, false));
        this.fullBlock = properties.getParent().getBlock();
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE[state.get(LAYERS) - 1];
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        // This allows people to place pillars/columns on top of one another
        int i = state.get(LAYERS);
        Direction facing = context.getSide();
        if (context.getStack().getItem() == this.asItem() && i <= 4) {
            if (PlacementHelper.replacingClickedOnBlock(context)) {
                return facing != Direction.UP && facing != Direction.DOWN;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            if (i == 3) {
                return fullBlock.getDefaultState();
            }
            return blockstate.with(LAYERS, Math.min(3, i + 1));
        } else {
            return super.getPlacementState(context);
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }

}
