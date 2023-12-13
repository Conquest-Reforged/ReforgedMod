package com.conquestreforged.blocks.block.trees;

import com.conquestreforged.blocks.block.Layer;
import com.conquestreforged.blocks.block.Pillar;
import com.conquestreforged.blocks.block.Slab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Half;


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

    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    private Block fullBlock;

    public Stump(Props properties) {
        super(properties);
        this.fullBlock = properties.getParent().getBlock();
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockState down = worldIn.getBlockState(currentPos.below());
        if (down.getBlock() instanceof Layer || (down.getBlock() instanceof Slab && down.getValue(Slab.TYPE_UPDOWN) == Half.BOTTOM)) {
            return stateIn.setValue(DOWN, true);
        } else {
            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }

    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();

        BlockPos blockposDown = blockpos.below();
        BlockState blockstateDown = iblockreader.getBlockState(blockposDown);

        boolean isDown = false;

        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());

        if (blockstateDown.getBlock() instanceof Layer || (blockstateDown.getBlock() instanceof Slab && blockstateDown.getValue(Slab.TYPE_UPDOWN) == Half.BOTTOM)) {
            isDown = true;
        }

        if (blockstate.getBlock() == this) {
            int i = blockstate.getValue(LAYERS);
            if (i == 3) {
                return fullBlock.defaultBlockState();
            }
            return blockstate.setValue(LAYERS, Math.min(3, i + 1));
        } else {
            return super.getStateForPlacement(context).setValue(DOWN, isDown);
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYERS, DOWN);
    }

}
