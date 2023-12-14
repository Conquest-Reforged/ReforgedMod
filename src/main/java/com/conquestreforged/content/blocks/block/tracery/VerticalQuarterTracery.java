package com.conquestreforged.content.blocks.block.tracery;

import com.conquestreforged.content.blocks.block.VerticalQuarter;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;

@Assets(
        state = @State(name = "%s_vertical_quarter", template = "parent_vertical_quarter"),
        item = @Model(name = "item/%s_vertical_quarter", parent = "block/%s_vertical_quarter_4", template = "item/parent_vertical_quarter"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_vertical_quarter_1", template = "block/parent_vertical_quarter_1"),
                @Model(name = "block/%s_vertical_quarter_2", template = "block/parent_vertical_quarter_2"),
                @Model(name = "block/%s_vertical_quarter_4", template = "block/parent_vertical_quarter_4"),
                @Model(name = "block/%s_vertical_quarter_6", template = "block/parent_vertical_quarter_6"),
        }
)
public class VerticalQuarterTracery extends VerticalQuarter {

    public VerticalQuarterTracery(Props properties) {
        super(properties);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (side == Direction.UP || side == Direction.DOWN) {
            if (adjacentBlockState.getBlock() instanceof GlassTracery) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalQuarterTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && (state.get(DIRECTION) == adjacentBlockState.get(DIRECTION))) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && (state.get(DIRECTION) == adjacentBlockState.get(DIRECTION) || state.get(DIRECTION) == adjacentBlockState.get(DIRECTION).rotateYClockwise())) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && (state.get(DIRECTION) == adjacentBlockState.get(DIRECTION) || state.get(DIRECTION) == adjacentBlockState.get(DIRECTION).rotateYClockwise() || state.get(DIRECTION) == adjacentBlockState.get(DIRECTION).rotateYCounterclockwise())) {
                return true;
            } else {
                return false;
            }
        }
        if (side == state.get(DIRECTION) || side == state.get(DIRECTION).rotateYCounterclockwise()) {
            return false;
        } else if (adjacentBlockState.getBlock() instanceof GlassTracery) {
            return true;
        } else if (adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && (((state.get(DIRECTION).getOpposite() == adjacentBlockState.get(DIRECTION) || state.get(DIRECTION) == adjacentBlockState.get(DIRECTION).rotateYClockwise()) && side == state.get(DIRECTION).getOpposite()) || ((state.get(DIRECTION) == adjacentBlockState.get(DIRECTION) || state.get(DIRECTION) == adjacentBlockState.get(DIRECTION).rotateYCounterclockwise()) && side == state.get(DIRECTION).rotateYClockwise()))) {
            return true;
        } else if (adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && ((adjacentBlockState.get(DIRECTION) != state.get(DIRECTION).rotateYClockwise() && side == state.get(DIRECTION).getOpposite()) || (adjacentBlockState.get(DIRECTION) != state.get(DIRECTION).rotateYCounterclockwise() && side == state.get(DIRECTION).rotateYClockwise()))) {
            return true;
        } else if (adjacentBlockState.getBlock() instanceof VerticalQuarterTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && ((adjacentBlockState.get(DIRECTION) == state.get(DIRECTION).rotateYCounterclockwise() && side == state.get(DIRECTION).getOpposite()) || (adjacentBlockState.get(DIRECTION) == state.get(DIRECTION).rotateYClockwise() && side == state.get(DIRECTION).rotateYClockwise()))) {
            return true;
        }
        return super.isSideInvisible(state, adjacentBlockState, side);
    }
}