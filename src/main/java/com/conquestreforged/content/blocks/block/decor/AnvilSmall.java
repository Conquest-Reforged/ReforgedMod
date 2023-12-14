package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

@Render(RenderLayer.CUTOUT)
public class AnvilSmall extends Anvil {

    private static final VoxelShape PART_BASE = createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 10.0D, 14.0D);


    public AnvilSmall(Settings builder) {
        super(builder);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return PART_BASE;
    }
}
