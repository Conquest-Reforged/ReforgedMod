package com.conquestreforged.content.items.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PlaceableOnWaterItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class LilypadItem extends PlaceableOnWaterItem {

    private Block blockIn;

    public LilypadItem(Block blockIn, Settings builder) {
        super(blockIn, builder);
        this.blockIn = blockIn;
    }

    @Override
    public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getStackInHand(handIn);
        HitResult raytraceresult = raycast(worldIn, playerIn, RaycastContext.FluidHandling.SOURCE_ONLY);
        if (raytraceresult.getType() == HitResult.Type.MISS) {
            return new TypedActionResult<>(ActionResult.PASS, itemstack);
        } else {
            if (raytraceresult.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockraytraceresult = (BlockHitResult) raytraceresult;
                BlockPos blockpos = blockraytraceresult.getBlockPos();
                Direction direction = blockraytraceresult.getSide();
                if (!worldIn.canPlayerModifyAt(playerIn, blockpos) || !playerIn.canPlaceOn(blockpos.offset(direction), direction, itemstack)) {
                    return new TypedActionResult<>(ActionResult.FAIL, itemstack);
                }

                BlockPos blockpos1 = blockpos.up();
                BlockState blockstate = worldIn.getBlockState(blockpos);
                Material material = blockstate.getMaterial();
                FluidState ifluidstate = worldIn.getFluidState(blockpos);
                if ((ifluidstate.getFluid() == Fluids.WATER || material == Material.ICE) && worldIn.isAir(blockpos1)) {

                    // special case for handling block placement with water lilies

                    //BlockSnapshot blocksnapshot = BlockSnapshot.create(worldIn.getRegistryKey(), worldIn, blockpos1);
                    worldIn.setBlockState(blockpos1, blockIn.getDefaultState(), 11);/*
                    if (net.minecraftforge.event.ForgeEventFactory.onBlockPlace(playerIn, blocksnapshot, Direction.UP)) {
                        blocksnapshot.restore(true, false);
                        return new InteractionResultHolder<ItemStack>(InteractionResult.FAIL, itemstack);
                    }*/

                    if (playerIn instanceof ServerPlayerEntity) {
                        Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) playerIn, blockpos1, itemstack);
                    }

                    if (!playerIn.getAbilities().creativeMode) {
                        itemstack.decrement(1);
                    }

                    playerIn.incrementStat(Stats.USED.getOrCreateStat(this));
                    worldIn.playSound(playerIn, blockpos, SoundEvents.BLOCK_LILY_PAD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return new TypedActionResult<>(ActionResult.SUCCESS, itemstack);
                }
                if (worldIn.isAir(blockpos1)) {
                    worldIn.setBlockState(blockpos1, blockIn.getDefaultState(), 11);
                    playerIn.incrementStat(Stats.USED.getOrCreateStat(this));
                    worldIn.playSound(playerIn, blockpos, SoundEvents.BLOCK_LILY_PAD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return new TypedActionResult<>(ActionResult.SUCCESS, itemstack);
                }
            }


            return new TypedActionResult<>(ActionResult.FAIL, itemstack);
        }
    }
}
