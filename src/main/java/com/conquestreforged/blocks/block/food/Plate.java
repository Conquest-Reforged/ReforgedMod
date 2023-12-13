package com.conquestreforged.blocks.block.food;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.properties.PropertyVariant;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT)
public class Plate extends CakeBlock implements PropertyVariant {

    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

    public Plate(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, Integer.valueOf(6)));
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
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            if (this.eatActionResult(level, blockPos, state, itemstack, player) == InteractionResult.SUCCESS) {
                return InteractionResult.SUCCESS;
            }
            if (itemstack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return this.eatActionResult(level, blockPos, state, itemstack, player);
    }

    private InteractionResult eatActionResult(Level world, BlockPos pos, BlockState state, ItemStack itemStack, Player playerEntity) {
        if (!playerEntity.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            playerEntity.awardStat(Stats.EAT_CAKE_SLICE);
            playerEntity.getFoodData().eat(2, 0.1F);
            int i = state.getValue(BITES);
            if (itemStack.getItem().isEdible() && state.getValue(BITES) != 0) {
                if (!playerEntity.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                world.setBlock(pos, state.setValue(BITES, Integer.valueOf(state.getValue(BITES) - 1)), 3);
                return InteractionResult.SUCCESS;
            } else if (i < 6) {
                world.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
                return InteractionResult.SUCCESS;
            }

            return InteractionResult.PASS;
        }
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        PropertyVariant.fillGroup(this, items);
    }
}
