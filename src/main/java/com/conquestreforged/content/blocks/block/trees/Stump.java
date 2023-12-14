package com.conquestreforged.content.blocks.block.trees;

import com.conquestreforged.content.blocks.block.Layer;
import com.conquestreforged.content.blocks.block.Pillar;
import com.conquestreforged.content.blocks.block.Slab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;


@Assets(
        state = @State(name = "%s_stump", template = "parent_stump"),
        item = @Model(name = "item/%s_stump", parent = "block/%s_stump_4", template = "item/dragon_egg"),
        block = {
                @Model(name = "block/%s_stump_2", template = "block/parent_pillar_2"),
                @Model(name = "block/%s_stump_4", template = "block/parent_pillar_4"),
                @Model(name = "block/%s_stump_6", template = "block/parent_pillar_6"),
                @Model(name = "block/%s_stump_down_2", template = "block/parent_stump_down_2"),
                @Model(name = "block/%s_stump_down_4", template = "block/parent_stump_down_4"),
                @Model(name = "block/%s_stump_down_6", template = "block/parent_stump_down_6"),
        }
)
public class Stump extends Pillar {

    public static final BooleanProperty DOWN = Properties.DOWN;
    private Block fullBlock;

    public Stump(Props properties) {
        super(properties);
        this.fullBlock = properties.getParent().getBlock();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockState down = worldIn.getBlockState(currentPos.down());
        if (down.getBlock() instanceof Layer || (down.getBlock() instanceof Slab && down.get(Slab.TYPE_UPDOWN) == BlockHalf.BOTTOM)) {
            return stateIn.with(DOWN, true);
        } else {
            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }

    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();

        BlockPos blockposDown = blockpos.down();
        BlockState blockstateDown = iblockreader.getBlockState(blockposDown);

        boolean isDown = false;

        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());

        if (blockstateDown.getBlock() instanceof Layer || (blockstateDown.getBlock() instanceof Slab && blockstateDown.get(Slab.TYPE_UPDOWN) == BlockHalf.BOTTOM)) {
            isDown = true;
        }

        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            if (i == 3) {
                return fullBlock.getDefaultState();
            }
            return blockstate.with(LAYERS, Math.min(3, i + 1));
        } else {
            return super.getPlacementState(context).with(DOWN, isDown);
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS, DOWN);
    }

}
