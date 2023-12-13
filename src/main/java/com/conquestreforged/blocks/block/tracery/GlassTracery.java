package com.conquestreforged.blocks.block.tracery;

import com.conquestreforged.blocks.block.Slab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape.DIRECTION;

@Assets(
        state = @State(name = "%s", template = "parent_cube", plural = true),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/parent_cube", plural = true),
        render = @Render(RenderLayer.CUTOUT),
        block = @Model(name = "block/%s", template = "block/parent_cube", plural = true)
)
public class GlassTracery extends AbstractGlassBlock {

    public GlassTracery(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (adjacentBlockState.getBlock() instanceof GlassTracery) {
            return true;
        } else if (side == Direction.DOWN && adjacentBlockState.getBlock() instanceof SlabTracery && adjacentBlockState.getValue(Slab.TYPE_UPDOWN) == Half.TOP) {
            return true;
        } else if (side == Direction.UP && adjacentBlockState.getBlock() instanceof SlabTracery && adjacentBlockState.getValue(Slab.TYPE_UPDOWN) == Half.BOTTOM) {
            return true;
        } /* else if ((adjacentBlockState.getBlock() instanceof StairsCutout) && (adjacentBlockState.get(DIRECTION) == side.getOpposite()) && adjacentBlockState.get(StairsBlock.SHAPE) == StairsShape.STRAIGHT) {
            return true;
        }*/ else if ((adjacentBlockState.getBlock() instanceof VerticalSlabTracery) && (adjacentBlockState.getValue(DIRECTION) == side)) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalCornerTracery) && (adjacentBlockState.getValue(DIRECTION) == side || adjacentBlockState.getValue(DIRECTION).getCounterClockWise() == side)) {
            return true;
        }
        return super.skipRendering(state, adjacentBlockState, side);
    }
}
