package com.conquestreforged.blocks.block.glass;

import com.conquestreforged.blocks.block.SlabLessLayers;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;

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
public class SlabCutout extends SlabLessLayers {

    public SlabCutout(Props properties) {
        super(properties);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (side == Direction.DOWN && state.getValue(TYPE_UPDOWN) == Half.BOTTOM) {
            if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.getValue(TYPE_UPDOWN) == Half.TOP) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.getValue(StairBlock.HALF) == Half.TOP ) {
                return true;
            }
        } else if (side == Direction.UP && state.getValue(TYPE_UPDOWN) == Half.TOP) {
            if (adjacentBlockState.getBlock() instanceof GlassBlock) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.getValue(TYPE_UPDOWN) == Half.BOTTOM) {
                return true;
            } else if (adjacentBlockState.getBlock() instanceof StairsCutout && adjacentBlockState.getValue(StairBlock.HALF) == Half.BOTTOM ) {
                return true;
            }
        }

        if (adjacentBlockState.getBlock() instanceof StairsCutout && state.getValue(LAYERS) == 3 && state.getValue(TYPE_UPDOWN) == adjacentBlockState.getValue(StairBlock.HALF) && (side != Direction.UP && side != Direction.DOWN)) {
            return true;
        } else if (adjacentBlockState.getBlock() instanceof SlabCutout && state.getValue(TYPE_UPDOWN) == adjacentBlockState.getValue(TYPE_UPDOWN) && state.getValue(LAYERS) <= adjacentBlockState.getValue(LAYERS) && (side != Direction.UP && side != Direction.DOWN)) {
            return true;
        } else if (((adjacentBlockState.getBlock() instanceof GlassBlock) && (side != Direction.UP && side != Direction.DOWN))) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabCutout) && (adjacentBlockState.getValue(DIRECTION) == side)) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalCornerCutout) && (adjacentBlockState.getValue(DIRECTION) == side || adjacentBlockState.getValue(DIRECTION).getCounterClockWise() == side)) {
            return true;
        }
        return super.skipRendering(state, adjacentBlockState, side);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

}
