package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@Render(RenderLayer.CUTOUT)
public class RailingsCorner extends Railings {

    protected static final VoxelShape SOUTH_OPEN_AABB = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D));
    protected static final VoxelShape NORTH_OPEN_AABB = VoxelShapes.union(Block.createCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D));
    protected static final VoxelShape WEST_OPEN_AABB = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D), Block.createCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
    protected static final VoxelShape EAST_OPEN_AABB = VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D));

    public RailingsCorner(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        {
            switch (state.get(FACING)) {
                case NORTH:
                default:
                    return NORTH_SHAPE;
                case SOUTH:
                    return SOUTH_SHAPE;
                case WEST:
                    return WEST_SHAPE;
                case EAST:
                    return EAST_SHAPE;
            }
        }
    }
}
