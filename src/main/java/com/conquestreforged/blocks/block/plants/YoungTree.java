package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT)
public class YoungTree extends Bush {

    public YoungTree(Properties props) {
        super(props);

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return BlockVoxelShapes.pillarShape.get(0);
    }

    @Override
    public OffsetType m_5858_() {
        return OffsetType.NONE;
    }
}
