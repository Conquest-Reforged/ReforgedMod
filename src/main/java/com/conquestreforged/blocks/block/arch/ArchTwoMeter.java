package com.conquestreforged.blocks.block.arch;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.directional.HalfDirectional;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_two_meter_arch", template = "parent_arch_twometer"),
        item = @Model(name = "item/%s_two_meter_arch", parent = "block/%s_two_meter_arch", template = "item/parent_slab_quarter"),
        block = {
                @Model(name = "block/%s_two_meter_arch", template = "block/parent_arch_twometer"),
        }
)
public class ArchTwoMeter extends HalfDirectional {

    public ArchTwoMeter(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TYPE_UPDOWN) == Half.BOTTOM) {
            switch (state.getValue(DIRECTION)) {
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
            switch (state.getValue(DIRECTION)) {
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
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return Shapes.empty();
    }
}