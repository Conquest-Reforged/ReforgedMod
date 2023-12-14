package com.conquestreforged.content.blocks.block.food;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.properties.PropertyVariant;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

@Render(RenderLayer.CUTOUT)
public class Plate extends CakeBlock implements PropertyVariant {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

    public Plate(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(BITES, Integer.valueOf(6)));
    }

    @Override
    public Property<?> getVariantProperty() {
        return CakeBlock.BITES;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getStackInHand(hand);
        if (!level.isClient) {
            if (this.eatActionResult(level, blockPos, state, itemstack, player) == ActionResult.SUCCESS) {
                return ActionResult.SUCCESS;
            }
            if (itemstack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return this.eatActionResult(level, blockPos, state, itemstack, player);
    }

    private ActionResult eatActionResult(World world, BlockPos pos, BlockState state, ItemStack itemStack, PlayerEntity playerEntity) {
        if (!playerEntity.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            playerEntity.incrementStat(Stats.EAT_CAKE_SLICE);
            playerEntity.getHungerManager().add(2, 0.1F);
            int i = state.get(BITES);
            if (itemStack.getItem().isFood() && state.get(BITES) != 0) {
                if (!playerEntity.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }
                world.setBlockState(pos, state.with(BITES, Integer.valueOf(state.get(BITES) - 1)), 3);
                return ActionResult.SUCCESS;
            } else if (i < 6) {
                world.setBlockState(pos, state.with(BITES, Integer.valueOf(i + 1)), 3);
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        }
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> items) {
        PropertyVariant.fillGroup(this, items);
    }
}
