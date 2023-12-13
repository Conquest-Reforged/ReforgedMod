package com.conquestrefabricated.content.blocks.block.arch;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s_small_arch_half", template = "parent_small_arch_half"),
        item = @Model(name = "item/%s_small_arch_half", parent = "block/%s_small_arch_half", template = "item/parent_segmental_arch"),
        block = {
                @Model(name = "block/%s_small_arch_half", template = "block/parent_small_arch_half")
        }
)
public class ArchSmallHalf extends WaterloggedHorizontalDirectionalShape {

    private static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_SHAPE = Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);

    public ArchSmallHalf(Settings properties) {
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

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }
}
