package com.conquestreforged.blocks.block.tracery;

import com.conquestreforged.blocks.block.VerticalQuarter;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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
    @OnlyIn(Dist.CLIENT)
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (side == Direction.UP || side == Direction.DOWN) {
            if (adjacentBlockState.getBlock() instanceof GlassTracery) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalQuarterTracery && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && (state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION))) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && (state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION) || state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION).getClockWise())) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && (state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION) || state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION).getClockWise() || state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION).getCounterClockWise())) {
                return true;
            } else {
                return false;
            }
        }
        if (side == state.getValue(DIRECTION) || side == state.getValue(DIRECTION).getCounterClockWise()) {
            return false;
        } else if (adjacentBlockState.getBlock() instanceof GlassTracery) {
            return true;
        } else if (adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && (((state.getValue(DIRECTION).getOpposite() == adjacentBlockState.getValue(DIRECTION) || state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION).getClockWise()) && side == state.getValue(DIRECTION).getOpposite()) || ((state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION) || state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION).getCounterClockWise()) && side == state.getValue(DIRECTION).getClockWise()))) {
            return true;
        } else if (adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && ((adjacentBlockState.getValue(DIRECTION) != state.getValue(DIRECTION).getClockWise() && side == state.getValue(DIRECTION).getOpposite()) || (adjacentBlockState.getValue(DIRECTION) != state.getValue(DIRECTION).getCounterClockWise() && side == state.getValue(DIRECTION).getClockWise()))) {
            return true;
        } else if (adjacentBlockState.getBlock() instanceof VerticalQuarterTracery && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && ((adjacentBlockState.getValue(DIRECTION) == state.getValue(DIRECTION).getCounterClockWise() && side == state.getValue(DIRECTION).getOpposite()) || (adjacentBlockState.getValue(DIRECTION) == state.getValue(DIRECTION).getClockWise() && side == state.getValue(DIRECTION).getClockWise()))) {
            return true;
        }
        return super.skipRendering(state, adjacentBlockState, side);
    }
}
