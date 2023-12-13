package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT)
public class Crops extends AbstractCropsBlock {

    private final ItemLike seeds;
    private final ItemLike crop;

    public Crops(Props props) {
        super(props.toProperties());
        this.seeds = props.get("seeds", ItemLike.class);
        this.crop = props.get("crop", ItemLike.class);
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return Shapes.block();
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
}
