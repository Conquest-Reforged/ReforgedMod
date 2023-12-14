package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.content.blocks.tileentity.campfire.ModdedCampfireTileEntity;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import com.conquestreforged.core.util.log.Log;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@Render(RenderLayer.CUTOUT)
public class Campfire extends CampfireBlock {

    public Campfire(Settings properties) {
        super(true, 1, properties);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (state.get(LIT)) {
            BlockEntity tileentity = level.getBlockEntity(blockPos);
            if (tileentity instanceof ModdedCampfireTileEntity) {
                ModdedCampfireTileEntity campfiretileentity = (ModdedCampfireTileEntity) tileentity;
                ItemStack itemstack = player.getStackInHand(hand);
                Optional<CampfireCookingRecipe> optional = campfiretileentity.getCookableRecipe(itemstack);
                if (optional.isPresent()) {
                    if (!level.isClient && campfiretileentity.placeFood(player.getAbilities().creativeMode ? itemstack.copy() : itemstack, optional.get().getCookTime())) {
                        player.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
                        return ActionResult.SUCCESS;
                    }

                    return ActionResult.CONSUME;
                }
            }
        }

        return ActionResult.PASS;
    }

    @Override
    public void onStateReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof ModdedCampfireTileEntity) {
                ItemScatterer.spawn(worldIn, pos, ((ModdedCampfireTileEntity) tileentity).getItems());
            }

            super.onStateReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.get(LIT)) {
            if (rand.nextInt(10) == 0) {
                worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 0.5F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.6F, false);
            }

            if (rand.nextInt(5) == 0) {
                for (int i = 0; i < rand.nextInt(1) + 1; ++i) {
                    worldIn.addParticle(ParticleTypes.LAVA, (double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), (double) (rand.nextFloat() / 2.0F), 5.0E-5D, (double) (rand.nextFloat() / 2.0F));
                }
            }

        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        Log.info("new campfire entity");
        ModdedCampfireTileEntity entity = new ModdedCampfireTileEntity(pos, state);
        return entity;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClient) {
            return state.get(LIT) ? checkType(blockEntityType, TileEntityTypes.CAMPFIRE, ModdedCampfireTileEntity::particleTick) : null;
        } else {
            return state.get(LIT) ? checkType(blockEntityType, TileEntityTypes.CAMPFIRE, ModdedCampfireTileEntity::cookTick) : checkType(blockEntityType, TileEntityTypes.CAMPFIRE, ModdedCampfireTileEntity::cooldownTick);
        }
    }
}
