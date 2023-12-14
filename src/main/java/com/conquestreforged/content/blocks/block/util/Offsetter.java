package com.conquestreforged.content.blocks.block.util;

public class Offsetter {

    private final int min;
    private final double[] offsets;

    private Offsetter(int min, double[] offsets) {
        this.min = min;
        this.offsets = offsets;
    }

    /**
     * Scans downwards from the given BlockPos to find the first different Block type to calculate the offset vector
     *
     * @param source - the Block type to ignore
     * @param reader - the BlockReader/World
     * @param pos    - the starting position of the source Block
     * @return the offset vector based on the first different block below source
     */
    //public Vector3d getOffset(Block source, IBlockReader reader, BlockPos pos) {
    //    try (BlockPos.Mutable position = BlockPos.Mutable.retain(pos.getX(), pos.getY() - 1, pos.getZ())) {
    //        while (reader.getBlockState(position).getBlock() == source) {
    //            position.setY(position.getY() - 1);
    //        }
    //        return getOffset(reader.getBlockState(position), pos);
    //    }
    //}

    /**
     * Get the offset vector from the block below
     *
     * @param state - the BlockState BELOW the position pos
     * @param pos   - the position of the Block we're getting the offset for
     * @return the offset vector based on the block below
     */
    //public Vector3d getOffset(BlockState state, BlockPos pos) {
    //    //if (isPartialBlock(state)) {
    //    //    return Vec3d.ZERO;
    //    //}
    //
    //    long i = MathHelper.getSeed(pos.getX(), 0, pos.getZ());
    //    double x = ((double) ((float) (i & 15L) / 15.0F) - 0.5D) * 0.5D;
    //    double z = ((double) ((float) (i >> 8 & 15L) / 15.0F) - 0.5D) * 0.5D;
    //
    //    int index = getOffsetIndex(state);
    //    if (index != -1) {
    //        return new Vector3d(x, offsets[index], z);
    //    }
    //
    //    return new Vector3d(x, ((double) ((float) (i >> 4 & 15L) / 15.0F) - 1.0D) * 0.05D, z);
    //}
    //
    //private int getOffsetIndex(BlockState state) {
    //    int layers = getLayerValue(state);
    //    if (layers < min) {
    //        return -1;
    //    }
    //
    //    int index = layers - min;
    //    if (index >= offsets.length) {
    //        return -1;
    //    }
    //    return index;
    //}

    //Got rid of PartialCubeCutout and DirectionalPartialCubeCutout since they're redundant. Also there were/are classes
    //that work similarly but aren't in this method.

    //private static boolean isPartialBlock(BlockState state) {
    //    return state.getBlock() instanceof PartialCubeCutout || state.getBlock() instanceof DirectionalPartialCubeCutout;
    //}

    //private static int getLayerValue(BlockState state) {
    //    if (state.has(BlockStateProperties.LAYERS_1_8)) {
    //        return state.getValue(BlockStateProperties.LAYERS_1_8);
    //    } else if (state.has(Slab.LAYERS)) {
    //        return state.get(Slab.LAYERS);
    //    } else if (state.has(Layer.LAYERS)) {
    //        return state.get(Layer.LAYERS);
    //    }
    //    return -1;
    //}
    //
    //public static Offsetter range(int layerMin, int layerMax, double start, double increment) {
    //    double[] offsets = new double[(layerMax + 1) - layerMin];
    //    for (int i = 0; i < offsets.length; i++) {
    //        offsets[i] = start + (i * increment);
    //    }
    //    return new Offsetter(layerMin, offsets);
    //}
    //
    //public static Offsetter fixed(int layerMin, double... offsets) {
    //    return new Offsetter(layerMin, offsets);
    //}
}