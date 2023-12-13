package com.conquestreforged.blocks.block.glass;

import com.conquestreforged.blocks.block.Slab;
import com.conquestreforged.blocks.block.Stairs;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;

import static com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape.DIRECTION;

@Assets(
        state = @State(name = "%s_stairs", template = "parent_stairs_cutout"),
        item = @Model(name = "item/%s_stairs", parent = "block/%s_stairs", template = "item/acacia_stairs"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_stairs", template = "block/parent_stairs_cutout"),
                @Model(name = "block/%s_stairs_outer", template = "block/parent_stairs_outer_cutout"),
                @Model(name = "block/%s_stairs_inner", template = "block/parent_stairs_inner_cutout"),
        }
)
public class StairsCutout extends Stairs {

    public StairsCutout(BlockState parent, Properties properties) {
        super(parent, properties);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (side == Direction.DOWN && state.getValue(HALF) == Half.BOTTOM) {
            if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.getValue(Slab.TYPE_UPDOWN) == Half.TOP) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.getValue(StairBlock.HALF) == Half.TOP ) {
                return true;
            }
        } else if (side == Direction.UP && state.getValue(HALF) == Half.TOP) {
            if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.getValue(Slab.TYPE_UPDOWN) == Half.BOTTOM) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.getValue(StairBlock.HALF) == Half.BOTTOM ) {
                return true;
            }
        }

        if (adjacentBlockState.getBlock() instanceof StairsCutout) {
            if (state.getValue(DIRECTION) == adjacentBlockState.getValue(DIRECTION) && (side != Direction.UP && side != Direction.DOWN) && (state.getValue(DIRECTION) != side) && (state.getValue(HALF) == adjacentBlockState.getValue(HALF))) {
                return true;
            }
        } else if (((adjacentBlockState.getBlock() instanceof GlassBlock) && (side != Direction.UP && side != Direction.DOWN))) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabCutout) && (adjacentBlockState.getValue(DIRECTION) == side)) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalCornerCutout) && (adjacentBlockState.getValue(DIRECTION) == side || adjacentBlockState.getValue(DIRECTION).getCounterClockWise() == side)) {
            return true;
        }
        return super.skipRendering(state, adjacentBlockState, side);
    }
}