package com.conquestrefabricated.content.blocks.block.glass;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;

@Assets(
        state = @State(name = "%s_stairs", template = "parent_stairs_cutout"),
        item = @Model(name = "item/%s_stairs", parent = "block/%s_stairs", template = "item/acacia_stairs"),
        render = @Render(RenderLayer.TRANSLUCENT),
        block = {
                @Model(name = "block/%s_stairs", template = "block/parent_stairs_cutout"),
                @Model(name = "block/%s_stairs_outer", template = "block/parent_stairs_outer_cutout"),
                @Model(name = "block/%s_stairs_inner", template = "block/parent_stairs_inner_cutout"),
        }
)
public class StairsTranslucent extends StairsCutout {

    public StairsTranslucent(BlockState parent, AbstractBlock.Settings properties) {
        super(parent, properties);
    }

}