package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.properties.Waterloggable;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;

@Render(RenderLayer.CUTOUT)
public class BushStackable extends AbstractBush implements Waterloggable {

    public BushStackable(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));

    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XYZ;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return Waterloggable.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }
}
