package com.conquestreforged.content.blocks.block;

import com.conquestreforged.content.blocks.block.directional.SlabDirectionalWaterlogged;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

@Assets(
        state = @State(name = "%s_boards", template = "parent_boards_horizontal"),
        item = @Model(name = "item/%s_boards", parent = "block/%s_boards_lower", template = "item/acacia_slab"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_boards_lower", template = "block/parent_boards_horizontal_lower"),
                @Model(name = "block/%s_boards_upper", template = "block/parent_boards_horizontal_upper"),
        }
)
public class BoardsHorizontal extends SlabDirectionalWaterlogged {

    private static final VoxelShape BOTTOM_NORTHSOUTH_SHAPE = Block.createCuboidShape(-6.0D, 0.0D, 0.0D, 22.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_EASTWEST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, -6.0D, 16.0D, 8.0D, 22.0D);
    private static final VoxelShape TOP_NORTHSOUTH_SHAPE = Block.createCuboidShape(-6.0D, 8.0D, 0.0D, 22.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_EASTWEST_SHAPE = Block.createCuboidShape(0.0D, 8.0D, -6.0D, 16.0D, 16.0D, 22.0D);

    public BoardsHorizontal(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            if (state.get(DIRECTION) == Direction.NORTH || state.get(DIRECTION) == Direction.SOUTH) {
                return BOTTOM_NORTHSOUTH_SHAPE;
            } else {
                return BOTTOM_EASTWEST_SHAPE;
            }
        } else {
            if (state.get(DIRECTION) == Direction.NORTH || state.get(DIRECTION) == Direction.SOUTH) {
                return TOP_NORTHSOUTH_SHAPE;
            } else {
                return TOP_EASTWEST_SHAPE;
            }
        }
    }
}