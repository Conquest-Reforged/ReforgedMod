package com.conquestreforged.blocks.block.directional;

import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class HalfDirectionalWaterlogged extends WaterloggedHorizontalDirectionalShape implements Waterloggable {

    private final List<VoxelShape> hitBox;

    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);

    public HalfDirectionalWaterlogged(Props props) {
        super(props.toProperties());
        this.hitBox = props.get("hitBox", List.class);
        this.registerDefaultState(this.stateDefinition.any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE_UPDOWN, Half.BOTTOM).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        Direction facingHorizontal = context.getHorizontalDirection().getOpposite();
        BlockState state2 = this.defaultBlockState().setValue(DIRECTION, facingHorizontal).setValue(TYPE_UPDOWN, Half.BOTTOM).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
        Direction facing = context.getClickedFace();
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getClickLocation().y - (double) context.getClickedPos().getY() > 0.5D)) ? state2 : state2.setValue(TYPE_UPDOWN, Half.TOP);
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        int shapesAmount = hitBox.size();

        switch (shapesAmount) {
            default:
            case 0:
                return hitBox.get(0);
            case 2:
                if (state.getValue(TYPE_UPDOWN) == Half.BOTTOM) {
                    return hitBox.get(0);
                } else {
                    return hitBox.get(1);
                }
            case 8:
                if (state.getValue(TYPE_UPDOWN) == Half.BOTTOM) {
                    switch (state.getValue(DIRECTION)) {
                        default:
                        case NORTH:
                            return hitBox.get(0);
                        case EAST:
                            return hitBox.get(1);
                        case SOUTH:
                            return hitBox.get(2);
                        case WEST:
                            return hitBox.get(3);
                    }
                } else {
                    switch (state.getValue(DIRECTION)) {
                        default:
                        case NORTH:
                            return hitBox.get(4);
                        case EAST:
                            return hitBox.get(5);
                        case SOUTH:
                            return hitBox.get(6);
                        case WEST:
                            return hitBox.get(7);
                    }
                }
        }
    }
}