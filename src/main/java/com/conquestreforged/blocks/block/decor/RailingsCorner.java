package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT)
public class RailingsCorner extends Railings {

    protected static final VoxelShape SOUTH_OPEN_AABB = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D));
    protected static final VoxelShape NORTH_OPEN_AABB = Shapes.or(Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D));
    protected static final VoxelShape WEST_OPEN_AABB = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D), Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
    protected static final VoxelShape EAST_OPEN_AABB = Shapes.or(Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D));

    public RailingsCorner(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        {
            switch (state.getValue(FACING)) {
                case NORTH:
                default:
                    return NORTH_OPEN_AABB;
                case SOUTH:
                    return SOUTH_OPEN_AABB;
                case WEST:
                    return WEST_OPEN_AABB;
                case EAST:
                    return EAST_OPEN_AABB;
            }
        }
    }
}
