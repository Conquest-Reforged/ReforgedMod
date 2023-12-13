package com.conquestreforged.blocks.block.food;

import com.conquestreforged.core.block.properties.PropertyVariant;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GenericFood extends CakeBlock implements PropertyVariant {

    public GenericFood(Properties properties) {
        super(properties);
    }

    @Override
    public Property<?> getVariantProperty() {
        return CakeBlock.BITES;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_BITE[0];
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        PropertyVariant.fillGroup(this, items);
    }
}
