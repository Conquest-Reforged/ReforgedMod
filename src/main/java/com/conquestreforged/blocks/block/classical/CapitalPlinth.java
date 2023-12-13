package com.conquestreforged.blocks.block.classical;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedShape;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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

    private static final VoxelShape TOP_FLAT_BIG = Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape TOP_FLAT_MIDDLE = Block.box(4.0D, 4.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    private static final VoxelShape TOP_FLAT_SMALL = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 4.0D, 10.0D);
    private static final VoxelShape TOP_FLAT = Shapes.or(Shapes.or(TOP_FLAT_BIG, TOP_FLAT_MIDDLE), TOP_FLAT_SMALL);

    public CapitalPlinth(Properties properties) {
        super(properties);

    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return TOP_FLAT;
    }

}
