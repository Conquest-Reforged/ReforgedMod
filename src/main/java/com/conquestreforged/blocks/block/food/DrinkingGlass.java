package com.conquestreforged.blocks.block.food;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.properties.PropertyVariant;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT)
public class DrinkingGlass extends Plate implements PropertyVariant {

    protected static final VoxelShape SHAPE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 11.0D, 10.0D);

    public DrinkingGlass(Properties properties) {
        super(properties);
    }

    @Override
    public Property<?> getVariantProperty() {
        return CakeBlock.BITES;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        PropertyVariant.fillGroup(this, items);
    }
}
