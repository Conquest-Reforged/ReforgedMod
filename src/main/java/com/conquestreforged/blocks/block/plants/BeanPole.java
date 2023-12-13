package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.blocks.block.util.PlacementHelper;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

@Render(RenderLayer.CUTOUT)
public class BeanPole extends CropBlock {

    private final ItemLike seeds;
    private final ItemLike crop;

    public BeanPole(Props props) {
        super(props.toProperties());
        this.seeds = props.get("seeds", ItemLike.class);
        this.crop = props.get("crop", ItemLike.class);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return BlockVoxelShapes.pillarShape.get(0);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.canSurvive(state, reader, pos);
        }
        return true;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter reader, BlockPos pos) {
        if (PlacementHelper.isDuringWorldGen(reader)) {
            return super.mayPlaceOn(state, reader, pos);
        }
        return true;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return seeds;
    }

    //protected IItemProvider getCropsItem() {
    //    return crop;
    //}

    @Override
    public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
        return new ItemStack(this);
    }

    @Override
    public void m_7458_(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
        super.m_7458_(state, world, pos, rand);

        if (world.isAreaLoaded(pos, 1)) {
            if (world.getRawBrightness(pos.above(), 0) >= 9) {
                int i = this.getAge(state);

                if (i < this.getMaxAge()) {
                    int height;

                    for (height = 1; world.getBlockState(pos.below(height)).getBlock() == this; ++height) {

                    }

                    if (height < 3) {
                        float f = getGrowthSpeed(this, world, pos);

                        if (ForgeHooks.onCropsGrowPre(world, pos, state, rand.nextInt((int) (25.0F / f) + 1) == 0)) {
                            if ((world.getBlockState(pos.below()).getMaterial() != Material.PLANT) || (world.getBlockState(pos.below()).getValue(this.getAgeProperty()) > i)) {
                                world.setBlock(pos, this.getStateForAge(i + 1), 2);
                                //if (world.getBlockState(pos.up()).getBlock() == ExampleMod.wooden_pole) {
                                //    world.setBlockState(pos.up(), this.getDefaultState());
                                //}
                                ForgeHooks.onCropsGrowPost(world, pos, state);
                            }
                        }
                    }
                }
            }
        }
    }
}
