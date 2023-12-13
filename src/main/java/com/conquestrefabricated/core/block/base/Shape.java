package com.conquestrefabricated.core.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public abstract class Shape extends Block {

    public Shape(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return getShape(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        if (this.collidable == false) {
            return VoxelShapes.empty();
        } else {
            return getShape(state);
        }
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView worldIn, BlockPos pos) {
        if (this.collidable == false) {
            return VoxelShapes.empty();
        } else {
            return getShape(state);
        }
    }

    public abstract VoxelShape getShape(BlockState state);
}
