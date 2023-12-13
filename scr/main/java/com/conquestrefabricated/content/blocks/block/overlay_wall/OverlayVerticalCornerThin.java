package com.conquestrefabricated.content.blocks.block.overlay_wall;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

@Render(RenderLayer.CUTOUT)
public class OverlayVerticalCornerThin extends WaterloggedHorizontalDirectionalShape {

    private static final VoxelShape EAST = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
    private static final VoxelShape QTR_EAST = Block.createCuboidShape(3.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SHAPE = VoxelShapes.union(EAST, QTR_EAST);

    private static final VoxelShape WEST = Block.createCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape QTR_WEST = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 13.0D, 16.0D, 3.0D);
    private static final VoxelShape WEST_SHAPE = VoxelShapes.union(WEST, QTR_WEST);

    private static final VoxelShape NORTH = Block.createCuboidShape(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape QTR_NORTH = Block.createCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 13.0D);
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.union(NORTH, QTR_NORTH);

    private static final VoxelShape SOUTH = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    private static final VoxelShape QTR_SOUTH = Block.createCuboidShape(0.0D, 0.0D, 3.0D, 3.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(SOUTH, QTR_SOUTH);


    public OverlayVerticalCornerThin(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
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
