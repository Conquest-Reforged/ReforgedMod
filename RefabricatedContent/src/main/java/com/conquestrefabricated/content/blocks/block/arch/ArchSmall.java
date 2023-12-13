package com.conquestrefabricated.content.blocks.block.arch;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedBidirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s_small_arch", template = "parent_small_arch"),
        item = @Model(name = "item/%s_small_arch", parent = "block/%s_small_arch", template = "item/parent_segmental_arch"),
        block = {
                @Model(name = "block/%s_small_arch", template = "block/parent_small_arch")
        }
)
public class ArchSmall extends WaterloggedBidirectionalShape {

    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public ArchSmall(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }
}
