package com.conquestreforged.content.blocks.block.glass;

import com.conquestreforged.content.blocks.block.Slab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.math.Direction;

import static com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape.DIRECTION;

@Assets(
        state = @State(name = "%s", template = "parent_cube", plural = true),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/parent_cube", plural = true),
        render = @Render(RenderLayer.CUTOUT),
        block = @Model(name = "block/%s", template = "block/parent_cube", plural = true)
)
public class Glass extends GlassBlock {

    public Glass(Settings properties) {
        super(properties);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (adjacentBlockState.getBlock() instanceof GlassBlock) {
            return true;
        } else if (side == Direction.DOWN && adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.get(Slab.TYPE_UPDOWN) == BlockHalf.TOP) {
            return true;
        } else if (side == Direction.UP && adjacentBlockState.getBlock() instanceof SlabCutout && adjacentBlockState.get(Slab.TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof StairsCutout) && (adjacentBlockState.get(DIRECTION) == side.getOpposite()) && adjacentBlockState.get(StairsBlock.SHAPE) == StairShape.STRAIGHT) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalSlabCutout) && (adjacentBlockState.get(DIRECTION) == side)) {
            return true;
        } else if ((adjacentBlockState.getBlock() instanceof VerticalCornerCutout) && (adjacentBlockState.get(DIRECTION) == side || adjacentBlockState.get(DIRECTION).rotateYCounterclockwise() == side)) {
            return true;
        }
        return super.isSideInvisible(state, adjacentBlockState, side);
    }
}
