package com.conquestreforged.content.blocks.tileentity.enchantment;

import com.conquestreforged.content.blocks.tileentity.TileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ModdedEnchantingTableTileEntity extends BlockEntity implements Nameable {

    public int time;
    public float flip;
    public float oFlip;
    public float flipT;
    public float flipA;
    public float open;
    public float oOpen;
    public float rot;
    public float oRot;
    public float tRot;
    private static final Random RANDOM = new Random();
    private Text name;

    public ModdedEnchantingTableTileEntity(BlockPos pos, BlockState state) {
        super(TileEntityTypes.ENCHANTING_TABLE, pos, state);
    }

    @Override
    public void writeNbt(NbtCompound p_189515_1_) {
        super.writeNbt(p_189515_1_);
        if (this.hasCustomName()) {
            p_189515_1_.putString("CustomName", Text.Serializer.toJson(this.name));
        }
    }

    @Override
    public void readNbt(NbtCompound p_155312_) {
        super.readNbt(p_155312_);
        if (p_155312_.contains("CustomName", 8)) {
            this.name = Text.Serializer.fromJson(p_155312_.getString("CustomName"));
        }

    }

    public static void bookAnimationTick(World p_155504_, BlockPos p_155505_, BlockState p_155506_, ModdedEnchantingTableTileEntity p_155507_) {
        p_155507_.oOpen = p_155507_.open;
        p_155507_.oRot = p_155507_.rot;
        PlayerEntity player = p_155504_.getClosestPlayer((double)p_155505_.getX() + 0.5D, (double)p_155505_.getY() + 0.5D, (double)p_155505_.getZ() + 0.5D, 3.0D, false);
        if (player != null) {
            double d0 = player.getX() - ((double)p_155505_.getX() + 0.5D);
            double d1 = player.getZ() - ((double)p_155505_.getZ() + 0.5D);
            p_155507_.tRot = (float)MathHelper.atan2(d1, d0);
            p_155507_.open += 0.1F;
            if (p_155507_.open < 0.5F || RANDOM.nextInt(40) == 0) {
                float f1 = p_155507_.flipT;

                do {
                    p_155507_.flipT += (float)(RANDOM.nextInt(4) - RANDOM.nextInt(4));
                } while(f1 == p_155507_.flipT);
            }
        } else {
            p_155507_.tRot += 0.02F;
            p_155507_.open -= 0.1F;
        }

        while(p_155507_.rot >= (float)Math.PI) {
            p_155507_.rot -= ((float)Math.PI * 2F);
        }

        while(p_155507_.rot < -(float)Math.PI) {
            p_155507_.rot += ((float)Math.PI * 2F);
        }

        while(p_155507_.tRot >= (float)Math.PI) {
            p_155507_.tRot -= ((float)Math.PI * 2F);
        }

        while(p_155507_.tRot < -(float)Math.PI) {
            p_155507_.tRot += ((float)Math.PI * 2F);
        }

        float f2;
        for(f2 = p_155507_.tRot - p_155507_.rot; f2 >= (float)Math.PI; f2 -= ((float)Math.PI * 2F)) {
        }

        while(f2 < -(float)Math.PI) {
            f2 += ((float)Math.PI * 2F);
        }

        p_155507_.rot += f2 * 0.4F;
        p_155507_.open = MathHelper.clamp(p_155507_.open, 0.0F, 1.0F);
        ++p_155507_.time;
        p_155507_.oFlip = p_155507_.flip;
        float f = (p_155507_.flipT - p_155507_.flip) * 0.4F;
        float f3 = 0.2F;
        f = MathHelper.clamp(f, -0.2F, 0.2F);
        p_155507_.flipA += (f - p_155507_.flipA) * 0.9F;
        p_155507_.flip += p_155507_.flipA;
    }

    @Override
    public Text getName() {
        return this.name != null ? this.name : Text.translatable("container.enchant");
    }

    public void setCustomName(@Nullable Text name) {
        this.name = name;
    }

    @Override
    @Nullable
    public Text getCustomName() {
        return this.name;
    }
}

