package com.conquestreforged.content.blocks.block.arch;

import com.conquestreforged.content.blocks.block.VerticalSlabCorner;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s_two_meter_arch_half", template = "parent_arch_twometer_half"),
        item = @Model(name = "item/%s_two_meter_arch_half", parent = "block/%s_two_meter_arch_half_right", template = "item/parent_slab_quarter"),
        block = {
                @Model(name = "block/%s_two_meter_arch_half_right", template = "block/parent_arch_twometer_half_right"),
                @Model(name = "block/%s_two_meter_arch_half_left", template = "block/parent_arch_twometer_half_left"),
        }
)
public class ArchTwoMeterHalf extends VerticalSlabCorner {

    public ArchTwoMeterHalf(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }
}