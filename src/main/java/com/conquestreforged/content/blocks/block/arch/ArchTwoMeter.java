package com.conquestreforged.content.blocks.block.arch;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.content.blocks.block.directional.HalfDirectional;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s_two_meter_arch", template = "parent_arch_twometer"),
        item = @Model(name = "item/%s_two_meter_arch", parent = "block/%s_two_meter_arch", template = "item/parent_slab_quarter"),
        block = {
                @Model(name = "block/%s_two_meter_arch", template = "block/parent_arch_twometer"),
        }
)
public class ArchTwoMeter extends HalfDirectional {

    public ArchTwoMeter(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return BlockVoxelShapes.stairBottomShapes.get(0);
                case EAST:
                    return BlockVoxelShapes.stairBottomShapes.get(1);
                case SOUTH:
                    return BlockVoxelShapes.stairBottomShapes.get(2);
                case WEST:
                    return BlockVoxelShapes.stairBottomShapes.get(3);
            }
        } else {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return BlockVoxelShapes.stairTopShapes.get(0);
                case EAST:
                    return BlockVoxelShapes.stairTopShapes.get(1);
                case SOUTH:
                    return BlockVoxelShapes.stairTopShapes.get(2);
                case WEST:
                    return BlockVoxelShapes.stairTopShapes.get(3);
            }
        }
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }
}