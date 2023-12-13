package com.conquestreforged.blocks.block.decor;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class Smoke extends Block {

    public static final IntegerProperty SMOKE_0_2 = IntegerProperty.create("smoke", 0, 2);

    public Smoke(Block.Properties propertiesIn) {
        super(propertiesIn);
        this.registerDefaultState(this.stateDefinition.any().setValue(SMOKE_0_2, 0));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @OnlyIn(Dist.CLIENT)
    public float getAmbientOcclusionLightValue(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 1.0F;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void m_7100_(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        Random random = worldIn.m_5822_();
        if (stateIn.getValue(SMOKE_0_2) == 0) {
            worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
        } else if (stateIn.getValue(SMOKE_0_2) == 1) {
            worldIn.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
        } else {
            worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
        }
        ItemStack itemstack = Minecraft.getInstance().player.getMainHandItem();
        boolean flag = !itemstack.isEmpty() && itemstack.getItem() == this.asItem();
        if (flag) {
            for (int i = 0; i < 2; i++) {
                worldIn.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0, 0.00001, 0);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SMOKE_0_2);
    }
}