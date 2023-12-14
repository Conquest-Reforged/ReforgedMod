package com.conquestreforged.content.blocks.block.plants;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@Render(RenderLayer.CUTOUT_MIPPED)
public class Crops extends AbstractCropsBlock {

    private final ItemConvertible seeds;
    private final ItemConvertible crop;

    public Crops(Props props) {
        super(props.toSettings());
        this.seeds = props.get("seeds", ItemConvertible.class);
        this.crop = props.get("crop", ItemConvertible.class);
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.fullCube();
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
}
