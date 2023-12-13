package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.tileentity.TileEntityTypes;
import com.conquestreforged.blocks.tileentity.campfire.ModdedCampfireTileEntity;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.util.RenderLayer;
import com.conquestreforged.core.util.log.Log;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

@Render(RenderLayer.CUTOUT)
public class Campfire extends CampfireBlock {

    public Campfire(Properties properties) {
        super(true, 1, properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (state.getValue(LIT)) {
            BlockEntity tileentity = level.getBlockEntity(blockPos);
            if (tileentity instanceof ModdedCampfireTileEntity) {
                ModdedCampfireTileEntity campfiretileentity = (ModdedCampfireTileEntity) tileentity;
                ItemStack itemstack = player.getItemInHand(hand);
                Optional<CampfireCookingRecipe> optional = campfiretileentity.getCookableRecipe(itemstack);
                if (optional.isPresent()) {
                    if (!level.isClientSide && campfiretileentity.placeFood(player.getAbilities().instabuild ? itemstack.copy() : itemstack, optional.get().getCookingTime())) {
                        player.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                        return InteractionResult.SUCCESS;
                    }

                    return InteractionResult.CONSUME;
                }
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof ModdedCampfireTileEntity) {
                Containers.dropContents(worldIn, pos, ((ModdedCampfireTileEntity) tileentity).getItems());
            }

            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void m_7100_(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        if (stateIn.getValue(LIT)) {
            if (rand.nextInt(10) == 0) {
                worldIn.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.6F, false);
            }

            if (rand.nextInt(5) == 0) {
                for (int i = 0; i < rand.nextInt(1) + 1; ++i) {
                    worldIn.addParticle(ParticleTypes.LAVA, (double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), (double) (rand.nextFloat() / 2.0F), 5.0E-5D, (double) (rand.nextFloat() / 2.0F));
                }
            }

        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        Log.info("new campfire entity");
        ModdedCampfireTileEntity entity = new ModdedCampfireTileEntity(pos, state);
        return entity;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide) {
            return state.getValue(LIT) ? createTickerHelper(blockEntityType, TileEntityTypes.CAMPFIRE, ModdedCampfireTileEntity::particleTick) : null;
        } else {
            return state.getValue(LIT) ? createTickerHelper(blockEntityType, TileEntityTypes.CAMPFIRE, ModdedCampfireTileEntity::cookTick) : createTickerHelper(blockEntityType, TileEntityTypes.CAMPFIRE, ModdedCampfireTileEntity::cooldownTick);
        }
    }
}
