package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.Layer;
import com.conquestreforged.blocks.block.Slab;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

@Render(RenderLayer.CUTOUT)
public class Corn extends Crops {

    public Corn(Props props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return BlockVoxelShapes.pillarShape.get(0);
    }

    @Override
    public void m_7455_(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
        super.m_7458_(state, world, pos, rand);

        if (world.isAreaLoaded(pos, 1)) {
            if (world.getRawBrightness(pos.above(), 0) >= 9) {
                int i = this.getAge(state);

                if (i < this.getMaxAge()) {

                    if (world.isEmptyBlock(pos.above())) {
                        int height;

                        for (height = 1; world.getBlockState(pos.below(height)).getBlock() == this; ++height) {
                        }

                        if (height < 3) {

                            float f = getGrowthSpeed(this, world, pos);

                            if (ForgeHooks.onCropsGrowPre(world, pos, state, rand.nextInt((int) (25.0F / f) + 1) == 0)) {
                                world.setBlock(pos, this.getStateForAge(i + 1), 2);

                                world.setBlock(pos.above(), this.defaultBlockState().setValue(LAYERS, state.getValue(LAYERS)), 2);
                                ForgeHooks.onCropsGrowPost(world, pos, state);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos up = blockpos.above();
        BlockPos down = blockpos.below();
        BlockState blockStateUp = iblockreader.getBlockState(up);
        BlockState blockStateDown = iblockreader.getBlockState(down);
        int layerBlockState = 8;

        if (blockStateDown.hasProperty(Layer.LAYERS) || blockStateDown.hasProperty(Slab.LAYERS) || blockStateDown.hasProperty(Bush.LAYERS)) {
            layerBlockState = blockStateDown.getValue(LAYERS);
        } else if (blockStateUp.hasProperty(Layer.LAYERS) || blockStateUp.hasProperty(Slab.LAYERS) || blockStateUp.hasProperty(Bush.LAYERS)) {
            layerBlockState = blockStateUp.getValue(LAYERS);
        }

        return super.getStateForPlacement(context)
                .setValue(LAYERS, layerBlockState);
    }
}
