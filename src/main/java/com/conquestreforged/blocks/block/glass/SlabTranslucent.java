package com.conquestreforged.blocks.block.glass;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.level.block.state.BlockState;

@Assets(
        state = @State(name = "%s_slab", template = "parent_slab_lesslayers"),
        item = @Model(name = "item/%s_slab", parent = "block/%s_slab_bottom_4", template = "item/acacia_slab"),
        render = @Render(RenderLayer.TRANSLUCENT),
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
public class SlabTranslucent extends SlabCutout {

    public SlabTranslucent(Props properties) {
        super(properties);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }

}
