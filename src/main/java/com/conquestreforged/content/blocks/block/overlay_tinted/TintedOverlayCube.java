package com.conquestreforged.content.blocks.block.overlay_tinted;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s", template = "parent_cube_overlay_tinted", plural = true),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/parent_cube", plural = true),
        render = @Render(RenderLayer.TRANSLUCENT),
        block = @Model(name = "block/%s", template = "block/parent_cube_overlay_tinted", plural = true)
)
public class TintedOverlayCube extends Block {

    public TintedOverlayCube(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }
}