package com.conquestrefabricated.content.blocks.block.plants;

import com.conquestrefabricated.content.blocks.BlockVoxelShapes;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

@Render(RenderLayer.CUTOUT)
public class YoungTree extends Bush {

    public YoungTree(Settings props) {
        super(props);

    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BlockVoxelShapes.pillarShape.get(0);
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }
}
