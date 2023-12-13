package com.conquestreforged.core.block.base;

import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.StateDefinition;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

/**
 * A non full-cube shape that can be 'waterlogged'
 */
public abstract class WaterloggedShape extends Shape implements Waterloggable {

    public WaterloggedShape(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        BlockState base = super.getStateForPlacement(context);
        if (base == null) {
            base = defaultBlockState();
        }
        return base.setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected final void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
        addProperties(builder);
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {

    }
}
