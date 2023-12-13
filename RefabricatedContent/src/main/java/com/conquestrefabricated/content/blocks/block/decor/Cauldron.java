package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.*;
import net.minecraft.block.entity.BannerBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.List;

@Render(RenderLayer.CUTOUT)
public class Cauldron extends Block {

    public static final IntProperty LEVEL = IntProperty.of("level", 0, 3);
    private final List<VoxelShape> hitBox;

    public Cauldron(Props props) {
        super(props.toSettings());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return hitBox.get(0);
    }

    public void onEntityCollision(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
        int i = p_196262_1_.get(LEVEL);
        float f = (float)p_196262_3_.getY() + (6.0F + (float)(3 * i)) / 16.0F;
        if (!p_196262_2_.isClient && p_196262_4_.isOnFire() && i > 0 && p_196262_4_.getY() <= (double)f) {
            p_196262_4_.extinguish();
            p_196262_2_.setBlockState(p_196262_3_, p_196262_1_.with(LEVEL, i - 1));
        }

    }

    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getStackInHand(hand);
        if (itemstack.isEmpty()) {
            return ActionResult.PASS;
        } else {
            int i = state.get(LEVEL);
            Item item = itemstack.getItem();
            if (item == Items.WATER_BUCKET) {
                if (i < 3 && !level.isClient) {
                    if (!player.getAbilities().creativeMode) {
                        player.setStackInHand(hand, new ItemStack(Items.BUCKET));
                    }

                    player.incrementStat(Stats.FILL_CAULDRON);
                    level.setBlockState(blockPos, state.with(LEVEL,3));
                    level.playSound((PlayerEntity)null, blockPos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return ActionResult.success(level.isClient);
            } else if (item == Items.BUCKET) {
                if (i == 3 && !level.isClient) {
                    if (!player.getAbilities().creativeMode) {
                        itemstack.decrement(1);
                        if (itemstack.isEmpty()) {
                            player.setStackInHand(hand, new ItemStack(Items.WATER_BUCKET));
                        } else if (!player.getInventory().insertStack(new ItemStack(Items.WATER_BUCKET))) {
                            player.dropItem(new ItemStack(Items.WATER_BUCKET), false);
                        }
                    }

                    player.incrementStat(Stats.USE_CAULDRON);
                    level.setBlockState(blockPos, state.with(LEVEL,0));
                    level.playSound((PlayerEntity)null, blockPos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return ActionResult.success(level.isClient);
            } else if (item == Items.GLASS_BOTTLE) {
                if (i > 0 && !level.isClient) {
                    if (!player.getAbilities().creativeMode) {
                        ItemStack itemstack4 = PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER);
                        player.incrementStat(Stats.USE_CAULDRON);
                        itemstack.decrement(1);
                        if (itemstack.isEmpty()) {
                            player.setStackInHand(hand, itemstack4);
                        } else if (!player.getInventory().insertStack(itemstack4)) {
                            player.dropItem(itemstack4, false);
                        } else if (player instanceof ServerPlayerEntity) {
                            ((ServerPlayerEntity)player).playerScreenHandler.syncState();
                        }
                    }

                    level.playSound((PlayerEntity)null, blockPos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    level.setBlockState(blockPos, state.with(LEVEL,i - 1));
                }

                return ActionResult.success(level.isClient);
            } else if (item == Items.POTION && PotionUtil.getPotion(itemstack) == Potions.WATER) {
                if (i < 3 && !level.isClient) {
                    if (!player.getAbilities().creativeMode) {
                        ItemStack itemstack3 = new ItemStack(Items.GLASS_BOTTLE);
                        player.incrementStat(Stats.USE_CAULDRON);
                        player.setStackInHand(hand, itemstack3);
                        if (player instanceof ServerPlayerEntity) {
                            ((ServerPlayerEntity)player).playerScreenHandler.syncState();
                        }
                    }

                    level.playSound((PlayerEntity) null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    level.setBlockState(blockPos, state.with(LEVEL, i + 1));
                }

                return ActionResult.success(level.isClient);
            } else {
                if (i > 0 && item instanceof DyeableArmorItem) {
                    DyeableArmorItem idyeablearmoritem = (DyeableArmorItem)item;
                    if (idyeablearmoritem.hasColor(itemstack) && !level.isClient) {
                        idyeablearmoritem.removeColor(itemstack);
                        level.setBlockState(blockPos, state.with(LEVEL, i - 1));
                        player.incrementStat(Stats.CLEAN_ARMOR);
                        return ActionResult.SUCCESS;
                    }
                }

                if (i > 0 && item instanceof BannerItem) {
                    if (BannerBlockEntity.getPatternCount(itemstack) > 0 && !level.isClient) {
                        ItemStack itemstack2 = itemstack.copy();
                        itemstack2.setCount(1);
                        BannerBlockEntity.loadFromItemStack(itemstack2);
                        player.incrementStat(Stats.CLEAN_BANNER);
                        if (!player.getAbilities().creativeMode) {
                            itemstack.decrement(1);
                            level.setBlockState(blockPos, state.with(LEVEL, i - 1));
                        }

                        if (itemstack.isEmpty()) {
                            player.setStackInHand(hand, itemstack2);
                        } else if (!player.getInventory().insertStack(itemstack2)) {
                            player.dropItem(itemstack2, false);
                        } else if (player instanceof ServerPlayerEntity) {
                            ((ServerPlayerEntity)player).playerScreenHandler.syncState();
                        }
                    }

                    return ActionResult.success(level.isClient);
                } else if (i > 0 && item instanceof BlockItem) {
                    Block block = ((BlockItem)item).getBlock();
                    if (block instanceof ShulkerBoxBlock && !level.isClient()) {
                        ItemStack itemstack1 = new ItemStack(Blocks.SHULKER_BOX, 1);
                        if (itemstack.hasNbt()) {
                            itemstack1.setNbt(itemstack.getNbt().copy());
                        }

                        player.setStackInHand(hand, itemstack1);
                        level.setBlockState(blockPos, state.with(LEVEL, i - 1));
                        player.incrementStat(Stats.CLEAN_SHULKER_BOX);
                        return ActionResult.SUCCESS;
                    } else {
                        return ActionResult.CONSUME;
                    }
                } else {
                    return ActionResult.PASS;
                }
            }
        }
    }


    public void precipitationTick(BlockState p_152450_, World p_152451_, BlockPos p_152452_, Biome.Precipitation p_152453_) {
        if (p_152451_.random.nextInt(20) == 1) {
            float f = p_152451_.getBiome(p_152452_).comp_349().getTemperature();
            if (!(f < 0.15F)) {
                BlockState blockstate = p_152451_.getBlockState(p_152452_);
                if (blockstate.get(LEVEL) < 3) {
                    p_152451_.setBlockState(p_152452_, blockstate.cycle(LEVEL), 2);
                }

            }
        }
    }

    public boolean hasComparatorOutput(BlockState p_149740_1_) {
        return true;
    }

    public int getComparatorOutput(BlockState p_153530_, World p_153531_, BlockPos p_153532_) {
        return p_153530_.get(LEVEL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(LEVEL);
    }

    public boolean canPathfindThrough(BlockState p_151959_, BlockView p_151960_, BlockPos p_151961_, NavigationType p_151962_) {
        return false;
    }
}
