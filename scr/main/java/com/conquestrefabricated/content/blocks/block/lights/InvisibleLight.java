package com.conquestrefabricated.content.blocks.block.lights;

import com.conquestrefabricated.content.blocks.block.Cube;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class InvisibleLight extends Cube {

    public InvisibleLight(Settings properties) {
        super(ensureNotSolid(properties));
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView reader, BlockPos pos) {
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public void randomDisplayTick(BlockState stateIn, World world, BlockPos pos, Random rand) {
        ItemStack itemstack = MinecraftClient.getInstance().player.getMainHandStack();
        boolean flag = !itemstack.isEmpty() && itemstack.getItem() == this.asItem();
        if (flag) {
            for (int i = 0; i < 2; i++) {
                world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK_MARKER, stateIn), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0, 0.00001, 0);
            }
        }
    }

    private static AbstractBlock.Settings ensureNotSolid(AbstractBlock.Settings properties) {
        properties.noCollision();
        return properties;
    }
}
