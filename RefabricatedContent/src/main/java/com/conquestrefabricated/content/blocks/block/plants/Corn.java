package com.conquestrefabricated.content.blocks.block.plants;

import com.conquestrefabricated.content.blocks.BlockVoxelShapes;
import com.conquestrefabricated.content.blocks.block.Layer;
import com.conquestrefabricated.content.blocks.block.Slab;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

@Render(RenderLayer.CUTOUT)
public class Corn extends Crops {

    public Corn(Props props) {
        super(props);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BlockVoxelShapes.pillarShape.get(0);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        super.scheduledTick(state, world, pos, rand);

        if (world.isRegionLoaded(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            if (world.getBaseLightLevel(pos.up(), 0) >= 9) {
                int i = this.getAge(state);

                if (i < this.getMaxAge()) {

                    if (world.isAir(pos.up())) {
                        int height;

                        for (height = 1; world.getBlockState(pos.down(height)).getBlock() == this; ++height) {
                        }

                        if (height < 3) {

                            float f = getAvailableMoisture(this, world, pos);
/*
                            if (ForgeHooks.onCropsGrowPre(world, pos, state, rand.nextInt((int) (25.0F / f) + 1) == 0)) {
                                world.setBlock(pos, this.getStateForAge(i + 1), 2);

                                world.setBlock(pos.above(), this.defaultBlockState().setValue(LAYERS, state.getValue(LAYERS)), 2);
                                ForgeHooks.onCropsGrowPost(world, pos, state);
                            }*/
                        }
                    }
                }
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockView iblockreader = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        BlockPos up = blockpos.up();
        BlockPos down = blockpos.down();
        BlockState blockStateUp = iblockreader.getBlockState(up);
        BlockState blockStateDown = iblockreader.getBlockState(down);
        int layerBlockState = 8;

        if (blockStateDown.contains(Layer.LAYERS) || blockStateDown.contains(Slab.LAYERS) || blockStateDown.contains(Bush.LAYERS)) {
            layerBlockState = blockStateDown.get(LAYERS);
        } else if (blockStateUp.contains(Layer.LAYERS) || blockStateUp.contains(Slab.LAYERS) || blockStateUp.contains(Bush.LAYERS)) {
            layerBlockState = blockStateUp.get(LAYERS);
        }

        return super.getPlacementState(context)
                .with(LAYERS, layerBlockState);
    }
}
