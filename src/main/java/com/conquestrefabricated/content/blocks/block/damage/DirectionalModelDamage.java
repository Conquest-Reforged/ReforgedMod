package com.conquestrefabricated.content.blocks.block.damage;

import com.conquestrefabricated.content.blocks.BlockVoxelShapes;
import com.conquestrefabricated.content.blocks.block.trees.Log;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

@Render(RenderLayer.CUTOUT)
public class DirectionalModelDamage extends Log {

    public DirectionalModelDamage(Settings properties) {
        super(properties);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.FOX && entityIn.getType() != EntityType.BEE) {
            entityIn.slowMovement(state, new Vec3d((double)0.8F, 0.75D, (double)0.8F));
            if (!worldIn.isClient && (entityIn.lastRenderX != entityIn.getX() || entityIn.lastRenderZ != entityIn.getZ())) {
                double d0 = Math.abs(entityIn.getX() - entityIn.lastRenderX);
                double d1 = Math.abs(entityIn.getZ() - entityIn.lastRenderZ);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    entityIn.damage(DamageSource.SWEET_BERRY_BUSH, 1.0F);
                }
            }

        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BlockVoxelShapes.cubePartialShape.get(0);
    }
}