package com.conquestreforged.content.blocks.block.directional;

import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

public class HalfDirectionalWaterlogged extends WaterloggedHorizontalDirectionalShape implements Waterloggable {

    private final List<VoxelShape> hitBox;

    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);

    public HalfDirectionalWaterlogged(Props props) {
        super(props.toSettings());
        this.hitBox = props.get("hitBox", List.class);
        this.setDefaultState(this.stateManager.getDefaultState().with(DIRECTION, Direction.NORTH).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluid = context.getWorld().getFluidState(context.getBlockPos());
        Direction facingHorizontal = context.getPlayerFacing().getOpposite();
        BlockState state2 = this.getDefaultState().with(DIRECTION, facingHorizontal).with(TYPE_UPDOWN, BlockHalf.BOTTOM).with(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
        Direction facing = context.getSide();
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double) context.getBlockPos().getY() > 0.5D)) ? state2 : state2.with(TYPE_UPDOWN, BlockHalf.TOP);
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> container) {
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
                if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
                    return hitBox.get(0);
                } else {
                    return hitBox.get(1);
                }
            case 8:
                if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
                    switch (state.get(DIRECTION)) {
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
                    switch (state.get(DIRECTION)) {
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