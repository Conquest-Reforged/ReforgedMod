package com.conquestreforged.content.blocks.block.glass;

import com.conquestreforged.content.blocks.block.Slab;
import com.conquestreforged.content.blocks.block.Stairs;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.Direction;

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

    public StairsCutout(BlockState parent, Settings properties) {
        super(parent, properties);
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (side == Direction.DOWN && state.get(HALF) == BlockHalf.BOTTOM) {
            if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.get(Slab.TYPE_UPDOWN) == BlockHalf.TOP) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.get(StairsBlock.HALF) == BlockHalf.TOP ) {
                return true;
            }
        } else if (side == Direction.UP && state.get(HALF) == BlockHalf.TOP) {
            if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.get(Slab.TYPE_UPDOWN) == BlockHalf.BOTTOM) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.get(StairsBlock.HALF) == BlockHalf.BOTTOM ) {
                return true;
            }
        }

        if (adjacentBlockState.getBlock() instanceof StairsCutout) {
            if (state.get(DIRECTION) == adjacentBlockState.get(DIRECTION) && (side != Direction.UP && side != Direction.DOWN) && (state.get(DIRECTION) != side) && (state.get(HALF) == adjacentBlockState.get(HALF))) {
                return true;
            }
        } else if (((adjacentBlockState.getBlock() instanceof GlassBlock) && (side != Direction.UP && side != Direction.DOWN))) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabCutout) && (adjacentBlockState.get(DIRECTION) == side)) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalCornerCutout) && (adjacentBlockState.get(DIRECTION) == side || adjacentBlockState.get(DIRECTION).rotateYCounterclockwise() == side)) {
            return true;
        }
        return super.isSideInvisible(state, adjacentBlockState, side);
    }
}