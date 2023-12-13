package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CauldronBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

@Render(RenderLayer.CUTOUT)
public class Cauldron extends Block {

    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 3);
    private final List<VoxelShape> hitBox;

    public Cauldron(Props props) {
        super(props.toProperties());
        this.hitBox = props.get("hitBox", List.class);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return hitBox.get(0);
    }

    public void entityInside(BlockState p_196262_1_, Level p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
        int i = p_196262_1_.getValue(LEVEL);
        float f = (float)p_196262_3_.getY() + (6.0F + (float)(3 * i)) / 16.0F;
        if (!p_196262_2_.isClientSide && p_196262_4_.isOnFire() && i > 0 && p_196262_4_.getY() <= (double)f) {
            p_196262_4_.clearFire();
            p_196262_2_.setBlockAndUpdate(p_196262_3_, p_196262_1_.setValue(LEVEL, i - 1));
        }

    }

    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.isEmpty()) {
            return InteractionResult.PASS;
        } else {
            int i = state.getValue(LEVEL);
            Item item = itemstack.getItem();
            if (item == Items.WATER_BUCKET) {
                if (i < 3 && !level.isClientSide) {
                    if (!player.getAbilities().instabuild) {
                        player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                    }

                    player.awardStat(Stats.FILL_CAULDRON);
                    level.setBlockAndUpdate(blockPos, state.setValue(LEVEL,3));
                    level.playSound((Player)null, blockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if (item == Items.BUCKET) {
                if (i == 3 && !level.isClientSide) {
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.setItemInHand(hand, new ItemStack(Items.WATER_BUCKET));
                        } else if (!player.getInventory().add(new ItemStack(Items.WATER_BUCKET))) {
                            player.drop(new ItemStack(Items.WATER_BUCKET), false);
                        }
                    }

                    player.awardStat(Stats.USE_CAULDRON);
                    level.setBlockAndUpdate(blockPos, state.setValue(LEVEL,0));
                    level.playSound((Player)null, blockPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if (item == Items.GLASS_BOTTLE) {
                if (i > 0 && !level.isClientSide) {
                    if (!player.getAbilities().instabuild) {
                        ItemStack itemstack4 = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
                        player.awardStat(Stats.USE_CAULDRON);
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.setItemInHand(hand, itemstack4);
                        } else if (!player.getInventory().add(itemstack4)) {
                            player.drop(itemstack4, false);
                        } else if (player instanceof ServerPlayer) {
                            ((ServerPlayer)player).inventoryMenu.sendAllDataToRemote();
                        }
                    }

                    level.playSound((Player)null, blockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(blockPos, state.setValue(LEVEL,i - 1));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if (item == Items.POTION && PotionUtils.getPotion(itemstack) == Potions.WATER) {
                if (i < 3 && !level.isClientSide) {
                    if (!player.getAbilities().instabuild) {
                        ItemStack itemstack3 = new ItemStack(Items.GLASS_BOTTLE);
                        player.awardStat(Stats.USE_CAULDRON);
                        player.setItemInHand(hand, itemstack3);
                        if (player instanceof ServerPlayer) {
                            ((ServerPlayer)player).inventoryMenu.sendAllDataToRemote();
                        }
                    }

                    level.playSound((Player) null, blockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlockAndUpdate(blockPos, state.setValue(LEVEL, i + 1));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                if (i > 0 && item instanceof DyeableArmorItem) {
                    DyeableArmorItem idyeablearmoritem = (DyeableArmorItem)item;
                    if (idyeablearmoritem.hasCustomColor(itemstack) && !level.isClientSide) {
                        idyeablearmoritem.clearColor(itemstack);
                        level.setBlockAndUpdate(blockPos, state.setValue(LEVEL, i - 1));
                        player.awardStat(Stats.CLEAN_ARMOR);
                        return InteractionResult.SUCCESS;
                    }
                }

                if (i > 0 && item instanceof BannerItem) {
                    if (BannerBlockEntity.getPatternCount(itemstack) > 0 && !level.isClientSide) {
                        ItemStack itemstack2 = itemstack.copy();
                        itemstack2.setCount(1);
                        BannerBlockEntity.removeLastPattern(itemstack2);
                        player.awardStat(Stats.CLEAN_BANNER);
                        if (!player.getAbilities().instabuild) {
                            itemstack.shrink(1);
                            level.setBlockAndUpdate(blockPos, state.setValue(LEVEL, i - 1));
                        }

                        if (itemstack.isEmpty()) {
                            player.setItemInHand(hand, itemstack2);
                        } else if (!player.getInventory().add(itemstack2)) {
                            player.drop(itemstack2, false);
                        } else if (player instanceof ServerPlayer) {
                            ((ServerPlayer)player).inventoryMenu.sendAllDataToRemote();
                        }
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else if (i > 0 && item instanceof BlockItem) {
                    Block block = ((BlockItem)item).getBlock();
                    if (block instanceof ShulkerBoxBlock && !level.isClientSide()) {
                        ItemStack itemstack1 = new ItemStack(Blocks.SHULKER_BOX, 1);
                        if (itemstack.hasTag()) {
                            itemstack1.setTag(itemstack.getTag().copy());
                        }

                        player.setItemInHand(hand, itemstack1);
                        level.setBlockAndUpdate(blockPos, state.setValue(LEVEL, i - 1));
                        player.awardStat(Stats.CLEAN_SHULKER_BOX);
                        return InteractionResult.SUCCESS;
                    } else {
                        return InteractionResult.CONSUME;
                    }
                } else {
                    return InteractionResult.PASS;
                }
            }
        }
    }


    public void handlePrecipitation(BlockState p_152450_, Level p_152451_, BlockPos p_152452_, Biome.Precipitation p_152453_) {
        if (p_152451_.random.nextInt(20) == 1) {
            float f = p_152451_.getBiome(p_152452_).value().getBaseTemperature();
            if (!(f < 0.15F)) {
                BlockState blockstate = p_152451_.getBlockState(p_152452_);
                if (blockstate.getValue(LEVEL) < 3) {
                    p_152451_.setBlock(p_152452_, blockstate.cycle(LEVEL), 2);
                }

            }
        }
    }

    public boolean hasAnalogOutputSignal(BlockState p_149740_1_) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState p_153530_, Level p_153531_, BlockPos p_153532_) {
        return p_153530_.getValue(LEVEL);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(LEVEL);
    }

    public boolean isPathfindable(BlockState p_151959_, BlockGetter p_151960_, BlockPos p_151961_, PathComputationType p_151962_) {
        return false;
    }
}
