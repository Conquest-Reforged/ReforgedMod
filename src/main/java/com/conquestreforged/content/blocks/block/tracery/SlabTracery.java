package com.conquestreforged.content.blocks.block.tracery;

import com.conquestreforged.content.blocks.block.SlabLessLayers;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import static com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape.DIRECTION;

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
public class SlabTracery extends SlabLessLayers {

    public SlabTracery(Props properties) {
        super(properties);
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (side == Direction.DOWN && state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            if (adjacentBlockState.getBlock() instanceof GlassTracery) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabTracery && adjacentBlockState.get(TYPE_UPDOWN) == BlockHalf.TOP) {
                return true;
            } /*else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.get(StairsBlock.HALF) == Half.TOP ) {
                return true;
            }*/
        } else if (side == Direction.UP && state.get(TYPE_UPDOWN) == BlockHalf.TOP) {
            if (adjacentBlockState.getBlock() instanceof GlassTracery) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabTracery && adjacentBlockState.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
                return true;
            }/* else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.get(StairsBlock.HALF) == Half.BOTTOM ) {
                return true;
            }*/
        }

        /*if (adjacentBlockState.getBlock() instanceof StairsCutout && state.get(LAYERS) == 3 && state.get(TYPE_UPDOWN) == adjacentBlockState.get(StairsBlock.HALF) && (side != Direction.UP && side != Direction.DOWN)) {
            return true;
        } else*/ if (adjacentBlockState.getBlock() instanceof SlabTracery && state.get(TYPE_UPDOWN) == adjacentBlockState.get(TYPE_UPDOWN) && state.get(LAYERS) <= adjacentBlockState.get(LAYERS) && (side != Direction.UP && side != Direction.DOWN)) {
            return true;
        } else if (((adjacentBlockState.getBlock() instanceof GlassTracery) && (side != Direction.UP && side != Direction.DOWN))) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabTracery) && (adjacentBlockState.get(DIRECTION) == side)) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalCornerTracery) && (adjacentBlockState.get(DIRECTION) == side || adjacentBlockState.get(DIRECTION).rotateYCounterclockwise() == side)) {
            return true;
        }
        return super.isSideInvisible(state, adjacentBlockState, side);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView reader, BlockPos pos) {
        return true;
    }

}
