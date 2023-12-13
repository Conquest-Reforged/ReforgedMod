package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.block.builder.Props;

public class ModelBlockOffset extends ModelBlock {

    public ModelBlockOffset(Props props) {
        super(props);
    }

    //
    //@Override
    //public Vec3d getOffset(BlockState state, IBlockReader world, BlockPos pos) {
    //    long i = MathHelper.getCoordinateRandom(pos.getX(), 0, pos.getZ());
    //    double x = ((double) ((float) (i & 15L) / 15.0F) - 0.5D) * 0.5D;
    //    double z = ((double) ((float) (i >> 8 & 15L) / 15.0F) - 0.5D) * 0.5D;
    //    return new Vec3d(x, 0.0D, z);
    //}
}
