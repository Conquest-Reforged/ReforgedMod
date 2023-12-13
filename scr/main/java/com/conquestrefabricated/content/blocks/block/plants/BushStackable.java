package com.conquestrefabricated.content.blocks.block.plants;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.properties.Waterloggable;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.StateManager;

@Render(RenderLayer.CUTOUT)
public class BushStackable extends AbstractBush implements Waterloggable {

    public BushStackable(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));

    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XYZ;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return Waterloggable.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }
}
