package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

@Assets(
        state = @State(name = "%s", template = "parent_pane_old"),
        item = @Model(name = "item/%s", parent = "block/%s_pane_ns", template = "item/parent_pane"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_pane_n", template = "block/parent_flatpane_n"),
                @Model(name = "block/%s_pane_ne", template = "block/parent_flatpane_ne"),
                @Model(name = "block/%s_pane_ns", template = "block/parent_flatpane_ns"),
                @Model(name = "block/%s_pane_nse", template = "block/parent_flatpane_nse"),
                @Model(name = "block/%s_pane_nsew", template = "block/parent_flatpane_nsew"),
                @Model(name = "block/%s_pane_post", template = "block/parent_flatpane_post")
        }
)
public class LadderPane extends PaneBlock {

    public LadderPane(Settings properties) {
        super(properties);
    }

    public boolean isLadder(BlockState state, WorldView reader, BlockPos pos, LivingEntity entity) {
        return true;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }
}
