package com.conquestreforged.blocks.block.overlay_wall;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT)
public class OverlayVerticalQuarterThin extends WaterloggedHorizontalDirectionalShape {

    private static final VoxelShape NORTH_SHAPE = Block.box(13.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 3.0D);
    private static final VoxelShape EAST_SHAPE = Block.box(0.0D, 0.0D, 13.0D, 3.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_SHAPE = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);

    public OverlayVerticalQuarterThin(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(DIRECTION)) {
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
