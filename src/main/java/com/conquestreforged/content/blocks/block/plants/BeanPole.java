package com.conquestreforged.content.blocks.block.plants;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.content.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

@Render(RenderLayer.CUTOUT)
public class BeanPole extends CropBlock {

    private final ItemConvertible seeds;
    private final ItemConvertible crop;

    public BeanPole(Props props) {
        super(props.toSettings());
        this.seeds = props.get("seeds", ItemConvertible.class);
        this.crop = props.get("crop", ItemConvertible.class);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BlockVoxelShapes.pillarShape.get(0);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.canPlaceAt(state, reader, pos);
        }
        return true;
    }

    @Override
    public boolean canPlantOnTop(BlockState state, BlockView reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.canPlantOnTop(state, reader, pos);
        }
        return true;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return seeds;
    }

    //protected IItemProvider getCropsItem() {
    //    return crop;
    //}

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(this);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        super.scheduledTick(state, world, pos, rand);

        if (world.isRegionLoaded(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            if (world.getBaseLightLevel(pos.up(), 0) >= 9) {
                int i = this.getAge(state);

                if (i < this.getMaxAge()) {
                    int height;

                    for (height = 1; world.getBlockState(pos.down(height)).getBlock() == this; ++height) {

                    }

                    if (height < 3) {
                        float f = getAvailableMoisture(this, world, pos);

                      /*  if (ForgeHooks.onCropsGrowPre(world, pos, state, rand.nextInt((int) (25.0F / f) + 1) == 0)) {
                            if ((world.getBlockState(pos.below()).getMaterial() != Material.PLANT) || (world.getBlockState(pos.below()).getValue(this.getAgeProperty()) > i)) {
                                world.setBlock(pos, this.getStateForAge(i + 1), 2);
                                //if (world.getBlockState(pos.up()).getBlock() == ExampleMod.wooden_pole) {
                                //    world.setBlockState(pos.up(), this.getDefaultState());
                                //}
                                ForgeHooks.onCropsGrowPost(world, pos, state);
                            }
                        }*/
                    }
                }
            }
        }
    }
}
