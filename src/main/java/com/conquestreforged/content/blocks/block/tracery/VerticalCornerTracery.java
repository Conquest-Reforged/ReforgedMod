package com.conquestreforged.content.blocks.block.tracery;

import com.conquestreforged.content.blocks.block.VerticalCorner;
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
        state = @State(name = "%s_vertical_corner", template = "parent_vertical_corner_transparent"),
        item = @Model(name = "item/%s_vertical_corner", parent = "block/%s_vertical_corner_4", template = "item/parent_vertical_corner"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_vertical_corner_1", template = "block/parent_vertical_corner_transparent_1"),
                @Model(name = "block/%s_vertical_corner_2", template = "block/parent_vertical_corner_transparent_2"),
                @Model(name = "block/%s_vertical_corner_4", template = "block/parent_vertical_corner_transparent_4"),
                @Model(name = "block/%s_vertical_corner_6", template = "block/parent_vertical_corner_transparent_6"),
        }
)
public class VerticalCornerTracery extends VerticalCorner {

    public VerticalCornerTracery(Props properties) {
        super(properties);
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return false;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (side == Direction.UP || side == Direction.DOWN) {
            if (adjacentBlockState.getBlock() instanceof GlassTracery || (adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && state.get(DIRECTION) == adjacentBlockState.get(DIRECTION))) {
                return true;
            }
        }

        if (state.get(DIRECTION) == Direction.EAST) {
            if (side == Direction.NORTH || side == Direction.EAST) {
                return false;
            } else if (adjacentBlockState.getBlock() instanceof GlassTracery
                    || (((adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.SOUTH && (adjacentBlockState.get(DIRECTION) == Direction.WEST || adjacentBlockState.get(DIRECTION) == Direction.SOUTH))))) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof GlassTracery
                    || (((adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.WEST && (adjacentBlockState.get(DIRECTION) == Direction.WEST || adjacentBlockState.get(DIRECTION) == Direction.SOUTH))))) {
                return true;
            } else if (((adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.SOUTH && adjacentBlockState.get(DIRECTION) == Direction.SOUTH))) {
                return true;
            } else if (((adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.WEST && adjacentBlockState.get(DIRECTION) == Direction.WEST))) {
                return true;
            } else {
                super.isSideInvisible(state, adjacentBlockState, side);
            }
        }

        if (state.get(DIRECTION) == Direction.WEST) {
            if (side == Direction.SOUTH || side == Direction.WEST) {
                return false;
            } else if (adjacentBlockState.getBlock() instanceof GlassTracery
                    || (((adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.NORTH && (adjacentBlockState.get(DIRECTION) == Direction.EAST || adjacentBlockState.get(DIRECTION) == Direction.NORTH))))) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof GlassTracery
                    || (((adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.EAST && (adjacentBlockState.get(DIRECTION) == Direction.EAST || adjacentBlockState.get(DIRECTION) == Direction.SOUTH))))) {
                return true;
            } else if (((adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.NORTH && adjacentBlockState.get(DIRECTION) == Direction.NORTH))) {
                return true;
            } else if (((adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.EAST && adjacentBlockState.get(DIRECTION) == Direction.EAST))) {
                return true;
            } else {
                super.isSideInvisible(state, adjacentBlockState, side);
            }
        }

        if (state.get(DIRECTION) == Direction.SOUTH) {
            if (side == Direction.SOUTH || side == Direction.EAST) {
                return false;
            } else if (adjacentBlockState.getBlock() instanceof GlassTracery
                    || (((adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.NORTH && (adjacentBlockState.get(DIRECTION) == Direction.EAST || adjacentBlockState.get(DIRECTION) == Direction.NORTH))))) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof GlassTracery
                    || (((adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.WEST && (adjacentBlockState.get(DIRECTION) == Direction.WEST || adjacentBlockState.get(DIRECTION) == Direction.NORTH))))) {
                return true;
            } else if (((adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.NORTH && adjacentBlockState.get(DIRECTION) == Direction.NORTH))) {
                return true;
            } else if (((adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.WEST && adjacentBlockState.get(DIRECTION) == Direction.WEST))) {
                return true;
            } else {
                super.isSideInvisible(state, adjacentBlockState, side);
            }
        }

        if (state.get(DIRECTION) == Direction.NORTH) {
            if (side == Direction.NORTH || side == Direction.WEST) {
                return false;
            } else if (adjacentBlockState.getBlock() instanceof GlassTracery
                    || ((adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.SOUTH && (adjacentBlockState.get(DIRECTION) == Direction.WEST || adjacentBlockState.get(DIRECTION) == Direction.SOUTH)))) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof GlassTracery
                    || ((adjacentBlockState.getBlock() instanceof VerticalCornerTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.EAST && (adjacentBlockState.get(DIRECTION) == Direction.EAST || adjacentBlockState.get(DIRECTION) == Direction.SOUTH)))) {
                return true;
            } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.SOUTH && adjacentBlockState.get(DIRECTION) == Direction.SOUTH)) {
                return true;
            } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabTracery && adjacentBlockState.get(LAYERS) >= state.get(LAYERS) && side == Direction.EAST && adjacentBlockState.get(DIRECTION) == Direction.EAST)) {
                return true;
            } else {
                super.isSideInvisible(state, adjacentBlockState, side);
            }
        }
        return super.isSideInvisible(state, adjacentBlockState, side);
    }
}