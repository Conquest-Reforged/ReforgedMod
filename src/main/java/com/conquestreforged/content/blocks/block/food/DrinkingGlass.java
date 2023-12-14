package com.conquestreforged.content.blocks.block.food;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.properties.PropertyVariant;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Property;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

@Render(RenderLayer.CUTOUT)
public class DrinkingGlass extends Plate implements PropertyVariant {

    protected static final VoxelShape SHAPE = createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 11.0D, 10.0D);

    public DrinkingGlass(Settings properties) {
        super(properties);
    }

    @Override
    public Property<?> getVariantProperty() {
        return BITES;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> items) {
        PropertyVariant.fillGroup(this, items);
    }
}
