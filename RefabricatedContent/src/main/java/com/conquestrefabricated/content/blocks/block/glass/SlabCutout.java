package com.conquestrefabricated.content.blocks.block.glass;

import com.conquestrefabricated.content.blocks.block.SlabLessLayers;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import static com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape.DIRECTION;

@Assets(
        state = @State(name = "%s_slab", template = "parent_slab_lesslayers"),
        item = @Model(name = "item/%s_slab", parent = "block/%s_slab_bottom_4", template = "item/acacia_slab"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_slab_bottom_1", template = "block/parent_slab_bottom_1"),
                @Model(name = "block/%s_slab_bottom_2", template = "block/parent_slab_bottom_2"),
                @Model(name = "block/%s_slab_bottom_4", template = "block/parent_slab_bottom_4"),
                @Model(name = "block/%s_slab_bottom_6", template = "block/parent_slab_bottom_6"),
                @Model(name = "block/%s_slab_top_1", template = "block/parent_slab_top_1"),
                @Model(name = "block/%s_slab_top_2", template = "block/parent_slab_top_2"),
                @Model(name = "block/%s_slab_top_4", template = "block/parent_slab_top_4"),
                @Model(name = "block/%s_slab_top_6", template = "block/parent_slab_top_6"),
        }
)
public class SlabCutout extends SlabLessLayers {

    public SlabCutout(Props properties) {
        super(properties);
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (side == Direction.DOWN && state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.get(TYPE_UPDOWN) == BlockHalf.TOP) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.get(StairsBlock.HALF) == BlockHalf.TOP ) {
                return true;
            }
        } else if (side == Direction.UP && state.get(TYPE_UPDOWN) == BlockHalf.TOP) {
            if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.get(StairsBlock.HALF) == BlockHalf.BOTTOM ) {
                return true;
            }
        }

        if (adjacentBlockState.getBlock() instanceof StairsCutout && state.get(LAYERS) == 3 && state.get(TYPE_UPDOWN) == adjacentBlockState.get(StairsBlock.HALF) && (side != Direction.UP && side != Direction.DOWN)) {
            return true;
        } else if (adjacentBlockState.getBlock() instanceof SlabCutout && state.get(TYPE_UPDOWN) == adjacentBlockState.get(TYPE_UPDOWN) && state.get(LAYERS) <= adjacentBlockState.get(LAYERS) && (side != Direction.UP && side != Direction.DOWN)) {
            return true;
        } else if (((adjacentBlockState.getBlock() instanceof GlassBlock) && (side != Direction.UP && side != Direction.DOWN))) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabCutout) && (adjacentBlockState.get(DIRECTION) == side)) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalCornerCutout) && (adjacentBlockState.get(DIRECTION) == side || adjacentBlockState.get(DIRECTION).rotateYCounterclockwise() == side)) {
            return true;
        }
        return super.isSideInvisible(state, adjacentBlockState, side);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView reader, BlockPos pos) {
        return true;
    }

}
