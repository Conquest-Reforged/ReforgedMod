package com.conquestreforged.blocks.block.overlay_wall;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.level.block.Block;

@Assets(
        state = @State(name = "%s", template = "parent_cube_overlay", plural = true),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/parent_cube", plural = true),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = @Model(name = "block/%s", template = "block/parent_cube_overlay", plural = true)
)
public class OverlayCube extends Block {

    public OverlayCube(Properties properties) {
        super(properties);
    }
}