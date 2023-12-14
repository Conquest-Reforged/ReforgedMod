package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

@Assets(
        state = @State(name = "%s", template = "parent_log_furniture"),
        item = @Model(name = "item/%s", parent = "block/%s", template = "item/acacia_log"),
        block = {
                @Model(name = "block/%s", template = "block/acacia_log"),
                @Model(name = "block/%s_side", template = "block/parent_log_furniture_side_2"),
                @Model(name = "block/%s_side_1", template = "block/parent_log_furniture_side_1")
        }
)
//this doesnt extend rotatedpillarblock as optifine would think this has log CTM
public class AxisFurniture extends Block {

    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;

    public AxisFurniture(Settings properties) {
        super(properties);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rot) {
        switch (rot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Direction.Axis) state.get(AXIS)) {
                    case X:
                        return state.with(AXIS, Direction.Axis.Z);
                    case Z:
                        return state.with(AXIS, Direction.Axis.X);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(AXIS, context.getSide().getAxis());
    }
}