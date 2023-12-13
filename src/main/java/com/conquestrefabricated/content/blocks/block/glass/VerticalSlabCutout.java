package com.conquestrefabricated.content.blocks.block.glass;

import com.conquestrefabricated.content.blocks.block.VerticalSlab;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.util.math.Direction;


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
    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        {
            if (side == Direction.UP || side == Direction.DOWN) {
                if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                    return true;
                } else if (adjacentBlockState.getBlock() instanceof VerticalSlabCutout && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && state.get(DIRECTION) == adjacentBlockState.get(DIRECTION)) {
                    return true;
                } else if (adjacentBlockState.getBlock() instanceof VerticalCornerCutout && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && (state.get(DIRECTION) == adjacentBlockState.get(DIRECTION) || state.get(DIRECTION) == adjacentBlockState.get(DIRECTION).rotateYCounterclockwise())) {
                    return true;
                } else {
                    return false;
                }
            }
            if (side == state.get(DIRECTION)) {
                return false;
            } else if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabCutout) && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && ((state.get(DIRECTION) == adjacentBlockState.get(DIRECTION).getOpposite() && state.get(DIRECTION).getOpposite() == side))) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalSlabCutout && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && ((state.get(DIRECTION) == adjacentBlockState.get(DIRECTION) && (state.get(DIRECTION).rotateYClockwise() == side || state.get(DIRECTION).rotateYCounterclockwise() == side))
                    || ((state.get(DIRECTION).rotateYClockwise() == side || state.get(DIRECTION).rotateYCounterclockwise() == side) && adjacentBlockState.get(DIRECTION) == side)
                    || (state.get(DIRECTION) == adjacentBlockState.get(DIRECTION).getOpposite() && state.get(DIRECTION).getOpposite() == side))) {
                return true;
            } else if ((adjacentBlockState.getBlock() instanceof VerticalCornerCutout && adjacentBlockState.get(LAYERS) >= state.get(LAYERS)) && (adjacentBlockState.get(DIRECTION) == state.get(DIRECTION).getOpposite() || adjacentBlockState.get(DIRECTION) == state.get(DIRECTION).rotateYCounterclockwise()) && side == state.get(DIRECTION).getOpposite()) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalCornerCutout && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && (adjacentBlockState.get(DIRECTION) != state.get(DIRECTION).rotateYCounterclockwise() && side == state.get(DIRECTION).rotateYClockwise()
                    || (adjacentBlockState.get(DIRECTION) == state.get(DIRECTION).getOpposite() || adjacentBlockState.get(DIRECTION) == state.get(DIRECTION).rotateYCounterclockwise()) && side == state.get(DIRECTION).getOpposite()
                    || adjacentBlockState.get(DIRECTION) != state.get(DIRECTION).getOpposite() && side == state.get(DIRECTION).rotateYCounterclockwise())) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof VerticalQuarterCutout && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && ((adjacentBlockState.get(DIRECTION).rotateYCounterclockwise() == side && adjacentBlockState.get(DIRECTION) == state.get(DIRECTION)) || (adjacentBlockState.get(DIRECTION) == side && adjacentBlockState.get(DIRECTION) == state.get(DIRECTION).rotateYClockwise()))) {
                return true;
            }
        }


        return super.isSideInvisible(state, adjacentBlockState, side);
    }
}
