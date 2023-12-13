package com.conquestrefabricated.content.blocks.block.plants;

import com.conquestrefabricated.content.blocks.BlockVoxelShapes;
import com.conquestrefabricated.content.blocks.block.util.PlacementHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public abstract class AbstractBush extends PlantBlock {

    protected AbstractBush(Settings properties) {
        super(properties);
    }

    @Override
    public boolean canPlantOnTop(BlockState state, BlockView reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.canPlantOnTop(state, reader, pos);
        }
        return true;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return BlockVoxelShapes.cubeMediumLargePartialShape.get(0);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.canPlaceAt(state, reader, pos);
        }
        return true;
    }
}
