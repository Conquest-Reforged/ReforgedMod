package com.conquestrefabricated.content.blocks.block.classical;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

@Assets(
        state = @State(name = "%s_capital", template = "parent_capital"),
        item = @Model(name = "item/%s_capital", parent = "block/%s_capital_down_flat", template = "item/parent_capital"),
        block = {
                @Model(name = "block/%s_capital_down_flat", template = "block/parent_capital_down_flat"),
                @Model(name = "block/%s_capital_down_side", template = "block/parent_capital_down_side"),
                @Model(name = "block/%s_capital_up_flat", template = "block/parent_capital_up_flat"),
                @Model(name = "block/%s_capital_up_side", template = "block/parent_capital_up_side"),
        }
)
public class CapitalPlinth extends WaterloggedShape {

    private static final VoxelShape TOP_FLAT_BIG = Block.createCuboidShape(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_FLAT_MIDDLE = Block.createCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_FLAT_SMALL = Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 4.0D, 10.0D);
    private static final VoxelShape TOP_FLAT = VoxelShapes.union(VoxelShapes.union(TOP_FLAT_BIG, TOP_FLAT_MIDDLE), TOP_FLAT_SMALL);

    public CapitalPlinth(Settings properties) {
        super(properties);

    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return TOP_FLAT;
    }

}
