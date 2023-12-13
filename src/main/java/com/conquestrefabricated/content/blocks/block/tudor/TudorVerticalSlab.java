package com.conquestrefabricated.content.blocks.block.tudor;

import com.conquestrefabricated.content.blocks.block.VerticalSlabLessLayers;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.block.properties.Waterloggable;

@Assets(
        state = @State(name = "%s_vertical_slab", template = "parent_vertical_slab_tudor"),
        item = @Model(name = "item/%s_vertical_slab", parent = "block/%s_vertical_slab_4", template = "item/parent_vertical_slab_tudor"),
        block = {
                @Model(name = "block/%s_vertical_slab_2", template = "block/parent_vertical_slab_tudor_2"),
                @Model(name = "block/%s_vertical_slab_4", template = "block/parent_vertical_slab_tudor_4"),
                @Model(name = "block/%s_vertical_slab_6", template = "block/parent_vertical_slab_tudor_6"),
        }
)
public class TudorVerticalSlab extends VerticalSlabLessLayers implements Waterloggable {

    public TudorVerticalSlab(Props properties) {
        super(properties);
    }
}
