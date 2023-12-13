package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

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

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public AxisFurniture(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        switch (rot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Direction.Axis) state.getValue(AXIS)) {
                    case X:
                        return state.setValue(AXIS, Direction.Axis.Z);
                    case Z:
                        return state.setValue(AXIS, Direction.Axis.X);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
    }
}