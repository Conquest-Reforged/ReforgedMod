package com.conquestreforged.blocks.block.glass;

import com.conquestreforged.blocks.block.VerticalSlab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@Assets(
        state = @State(name = "%s_vertical_slab", template = "parent_vertical_slab"),
        item = @Model(name = "item/%s_vertical_slab", parent = "block/%s_vertical_slab_4", template = "item/parent_vertical_slab"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_vertical_slab_1", template = "block/parent_vertical_slab_1"),
                @Model(name = "block/%s_vertical_slab_2", template = "block/parent_vertical_slab_2"),
                @Model(name = "block/%s_vertical_slab_4", template = "block/parent_vertical_slab_4"),
                @Model(name = "block/%s_vertical_slab_6", template = "block/parent_vertical_slab_6"),
        }
)
public class VerticalSlabCutout extends VerticalSlab {

    public VerticalSlabCutout(Props properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        {
            if (side == Direction.UP || side == Direction.DOWN) {
                if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                    return true;
                } else if (adjacentBlockState.getBlock() instanceof VerticalSlabCutout && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION)) {
                    return true;
                } else if (adjacentBlockState.getBlock() instanceof VerticalCornerCutout && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && (state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION) || state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION).getCounterClockWise())) {
                    return true;
                } else {
                    return false;
                }
            }
            if (side == state.getValue(DIRECTION)) {
                return false;
            } else if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabCutout) && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && ((state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION).getOpposite() && state.getValue(DIRECTION).getOpposite() == side))) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalSlabCutout && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && ((state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION) && (state.getValue(DIRECTION).getClockWise() == side || state.getValue(DIRECTION).getCounterClockWise() == side))
                    || ((state.getValue(DIRECTION).getClockWise() == side || state.getValue(DIRECTION).getCounterClockWise() == side) && adjacentBlockState.getValue(DIRECTION) == side)
                    || (state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION).getOpposite() && state.getValue(DIRECTION).getOpposite() == side))) {
                return true;
            } else if ((adjacentBlockState.getBlock() instanceof VerticalCornerCutout && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS)) && (adjacentBlockState.getValue(DIRECTION) == state.getValue(DIRECTION).getOpposite() || adjacentBlockState.getValue(DIRECTION) == state.getValue(DIRECTION).getCounterClockWise()) && side == state.getValue(DIRECTION).getOpposite()) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalCornerCutout && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && (adjacentBlockState.getValue(DIRECTION) != state.getValue(DIRECTION).getCounterClockWise() && side == state.getValue(DIRECTION).getClockWise()
                    || (adjacentBlockState.getValue(DIRECTION) == state.getValue(DIRECTION).getOpposite() || adjacentBlockState.getValue(DIRECTION) == state.getValue(DIRECTION).getCounterClockWise()) && side == state.getValue(DIRECTION).getOpposite()
                    || adjacentBlockState.getValue(DIRECTION) != state.getValue(DIRECTION).getOpposite() && side == state.getValue(DIRECTION).getCounterClockWise())) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalQuarterCutout && adjacentBlockState.getValue(LAYERS) >= state.getValue(LAYERS) && ((adjacentBlockState.getValue(DIRECTION).getCounterClockWise() == side && adjacentBlockState.getValue(DIRECTION) == state.getValue(DIRECTION)) || (adjacentBlockState.getValue(DIRECTION) == side && adjacentBlockState.getValue(DIRECTION) == state.getValue(DIRECTION).getClockWise()))) {
                return true;
            }
        }


        return super.skipRendering(state, adjacentBlockState, side);
    }
}
