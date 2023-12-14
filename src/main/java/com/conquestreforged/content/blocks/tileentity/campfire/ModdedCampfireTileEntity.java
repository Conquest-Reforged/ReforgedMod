package com.conquestreforged.content.blocks.tileentity.campfire;

import com.conquestreforged.content.blocks.block.decor.Campfire;
import com.conquestreforged.content.blocks.tileentity.TileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Clearable;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.Optional;

public class ModdedCampfireTileEntity extends BlockEntity implements Clearable {

    private static final int BURN_COOL_SPEED = 2;
    private static final int NUM_SLOTS = 4;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(4, ItemStack.EMPTY);
    private final int[] cookingProgress = new int[4];
    private final int[] cookingTime = new int[4];

    public ModdedCampfireTileEntity(BlockPos pos, BlockState state) {
        super(TileEntityTypes.CAMPFIRE, pos, state);
    }

    public static void cookTick(World p_155307_, BlockPos p_155308_, BlockState p_155309_, ModdedCampfireTileEntity p_155310_) {
        boolean flag = false;

        for(int i = 0; i < p_155310_.items.size(); ++i) {
            ItemStack itemstack = p_155310_.items.get(i);
            if (!itemstack.isEmpty()) {
                flag = true;
                int j = p_155310_.cookingProgress[i]++;
                if (p_155310_.cookingProgress[i] >= p_155310_.cookingTime[i]) {
                    Inventory container = new SimpleInventory(itemstack);
                    ItemStack itemstack1 = p_155307_.getRecipeManager().getFirstMatch(RecipeType.CAMPFIRE_COOKING, container, p_155307_).map((p_155305_) -> {
                        return p_155305_.craft(container);
                    }).orElse(itemstack);
                    ItemScatterer.spawn(p_155307_, (double)p_155308_.getX(), (double)p_155308_.getY(), (double)p_155308_.getZ(), itemstack1);
                    p_155310_.items.set(i, ItemStack.EMPTY);
                    p_155307_.updateListeners(p_155308_, p_155309_, p_155309_, 3);
                }
            }
        }

        if (flag) {
            markDirty(p_155307_, p_155308_, p_155309_);
        }

    }

    public static void cooldownTick(World p_155314_, BlockPos p_155315_, BlockState p_155316_, ModdedCampfireTileEntity p_155317_) {
        boolean flag = false;

        for(int i = 0; i < p_155317_.items.size(); ++i) {
            if (p_155317_.cookingProgress[i] > 0) {
                flag = true;
                p_155317_.cookingProgress[i] = MathHelper.clamp(p_155317_.cookingProgress[i] - 2, 0, p_155317_.cookingTime[i]);
            }
        }

        if (flag) {
            markDirty(p_155314_, p_155315_, p_155316_);
        }

    }

    public static void particleTick(World p_155319_, BlockPos p_155320_, BlockState p_155321_, ModdedCampfireTileEntity p_155322_) {
        Random random = p_155319_.random;
        if (random.nextFloat() < 0.11F) {
            for(int i = 0; i < random.nextInt(2) + 2; ++i) {
                Campfire.spawnSmokeParticle(p_155319_, p_155320_, p_155321_.get(Campfire.SIGNAL_FIRE), false);
            }
        }

        int l = p_155321_.get(Campfire.FACING).getHorizontal();

        for(int j = 0; j < p_155322_.items.size(); ++j) {
            if (!p_155322_.items.get(j).isEmpty() && random.nextFloat() < 0.2F) {
                Direction direction = Direction.fromHorizontal(Math.floorMod(j + l, 4));
                float f = 0.3125F;
                double d0 = (double)p_155320_.getX() + 0.5D - (double)((float)direction.getOffsetX() * 0.3125F) + (double)((float)direction.rotateYClockwise().getOffsetX() * 0.3125F);
                double d1 = (double)p_155320_.getY() + 0.5D;
                double d2 = (double)p_155320_.getZ() + 0.5D - (double)((float)direction.getOffsetZ() * 0.3125F) + (double)((float)direction.rotateYClockwise().getOffsetZ() * 0.3125F);

                for(int k = 0; k < 4; ++k) {
                    p_155319_.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 5.0E-4D, 0.0D);
                }
            }
        }

    }

    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }

    public void readNbt(NbtCompound p_155312_) {
        super.readNbt(p_155312_);
        this.items.clear();
        Inventories.readNbt(p_155312_, this.items);
        if (p_155312_.contains("CookingTimes", 11)) {
            int[] aint = p_155312_.getIntArray("CookingTimes");
            System.arraycopy(aint, 0, this.cookingProgress, 0, Math.min(this.cookingTime.length, aint.length));
        }

        if (p_155312_.contains("CookingTotalTimes", 11)) {
            int[] aint1 = p_155312_.getIntArray("CookingTotalTimes");
            System.arraycopy(aint1, 0, this.cookingTime, 0, Math.min(this.cookingTime.length, aint1.length));
        }

    }

    protected void writeNbt(NbtCompound p_187486_) {
        super.writeNbt(p_187486_);
        Inventories.writeNbt(p_187486_, this.items, true);
        p_187486_.putIntArray("CookingTimes", this.cookingProgress);
        p_187486_.putIntArray("CookingTotalTimes", this.cookingTime);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound compoundtag = new NbtCompound();
        Inventories.writeNbt(compoundtag, this.items, true);
        return compoundtag;
    }

    public Optional<CampfireCookingRecipe> getCookableRecipe(ItemStack p_59052_) {
        return this.items.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.world.getRecipeManager().getFirstMatch(RecipeType.CAMPFIRE_COOKING, new SimpleInventory(p_59052_), this.world);
    }

    public boolean placeFood(ItemStack p_59054_, int p_59055_) {
        for(int i = 0; i < this.items.size(); ++i) {
            ItemStack itemstack = this.items.get(i);
            if (itemstack.isEmpty()) {
                this.cookingTime[i] = p_59055_;
                this.cookingProgress[i] = 0;
                this.items.set(i, p_59054_.split(1));
                this.markUpdated();
                return true;
            }
        }

        return false;
    }

    private void markUpdated() {
        this.markDirty();
        this.getWorld().updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), 3);
    }

    public void clear() {
        this.items.clear();
    }

    public void dowse() {
        if (this.world != null) {
            this.markUpdated();
        }

    }
}