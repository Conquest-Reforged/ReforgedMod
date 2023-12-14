package com.conquestreforged.content.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.Arrays;
import java.util.List;

public class BlockVoxelShapes {

    public static final VoxelShape pipeShape = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    public static final VoxelShape pipeShapeHorizontal_EW = Block.createCuboidShape(5, 5, 0, 11, 11, 16);
    public static final VoxelShape pipeShapeHorizontal_NS = Block.createCuboidShape(0, 5, 5, 16, 11, 11);

    public static final List<VoxelShape> crossFlangeShapes = Arrays.asList(
            VoxelShapes.union(pipeShape, pipeShapeHorizontal_NS),
            VoxelShapes.union(pipeShape, pipeShapeHorizontal_EW),
            VoxelShapes.union(pipeShapeHorizontal_EW, pipeShapeHorizontal_NS)
    );

    public static final List<VoxelShape> urnShape = Arrays.asList(
            VoxelShapes.union(Block.createCuboidShape(0, 14, 0, 16, 16, 16), VoxelShapes.union(
                    Block.createCuboidShape(3, 5.5, 3, 13, 13, 13), VoxelShapes.union(
                            Block.createCuboidShape(1.5, 7, 1.5, 14.5, 12, 14.5), VoxelShapes.union(
                                    Block.createCuboidShape(2, 13, 2, 14, 14, 14), VoxelShapes.union(
                                            Block.createCuboidShape(5, 3.5, 5, 11, 5.5, 11), VoxelShapes.union(
                                                    Block.createCuboidShape(5, 3.5, 5, 11, 5.5, 11), VoxelShapes.union(
                                                            Block.createCuboidShape(5, 3.5, 5, 11, 5.5, 11), VoxelShapes.union(
                                                                    Block.createCuboidShape(2, 0, 2, 14, 2, 14), Block.createCuboidShape(4, 2, 4, 12, 3.5, 12))
                            ))))))));

    public static final VoxelShape TOP_NORTHSOUTH_SHAPE = Block.createCuboidShape(-10.5D, 8.0D, 0.0D, 26.5D, 16.0D, 16.0D);
    public static final VoxelShape TOP_EASTWEST_SHAPE = Block.createCuboidShape(0.0D, 8.0D, -10.5D, 16.0D, 16.0D, 26.5D);

    public static final List<VoxelShape> tableShapes = Arrays.asList(TOP_NORTHSOUTH_SHAPE, TOP_EASTWEST_SHAPE, TOP_NORTHSOUTH_SHAPE, TOP_EASTWEST_SHAPE);

    public static final List<VoxelShape> fiveWayFlangeShapes = Arrays.asList(
            VoxelShapes.union(pipeShape, VoxelShapes.union(pipeShapeHorizontal_NS, Block.createCuboidShape(5, 5, 8, 11, 11, 16))),
            VoxelShapes.union(pipeShape, VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 8, 11, 11), pipeShapeHorizontal_EW)),
            VoxelShapes.union(pipeShape, VoxelShapes.union(pipeShapeHorizontal_NS, Block.createCuboidShape(5, 5, 0, 11, 11, 8))),
            VoxelShapes.union(pipeShape, VoxelShapes.union(Block.createCuboidShape(8, 5, 5, 16, 11, 11), pipeShapeHorizontal_EW)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D), VoxelShapes.union(pipeShapeHorizontal_NS, pipeShapeHorizontal_EW)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 8.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(pipeShapeHorizontal_NS, pipeShapeHorizontal_EW))
    );

    public static final List<VoxelShape> threeWayFlangeShapes = Arrays.asList(
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(8, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 8, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 8, 11, 11), Block.createCuboidShape(5, 5, 8, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 8, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 8))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(8, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 8))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(8, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 8, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 8, 11, 11), Block.createCuboidShape(5, 5, 8, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 8, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 8))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(8, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 8)))
    );

    public static final List<VoxelShape> elbowFlangeShapes = Arrays.asList(
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(5, 5, 8, 11, 11, 16)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(0, 5, 5, 8, 11, 11)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(5, 5, 0, 11, 11, 8)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(8, 5, 5, 16, 11, 11)),

            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Block.createCuboidShape(5, 5, 8, 11, 11, 16)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Block.createCuboidShape(0, 5, 5, 8, 11, 11)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Block.createCuboidShape(5, 5, 0, 11, 11, 8)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Block.createCuboidShape(8, 5, 5, 16, 11, 11)),

            VoxelShapes.union(Block.createCuboidShape(5, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 8, 11, 11, 16)),
            VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 11, 11, 11), Block.createCuboidShape(5, 5, 8, 11, 11, 16)),
            VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 11, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 8)),
            VoxelShapes.union(Block.createCuboidShape(5, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 8))
    );

    public static final List<VoxelShape> fourWayFlangeShapes = Arrays.asList(
            VoxelShapes.union(pipeShape, VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D), Block.createCuboidShape(5, 5, 8, 11, 11, 16))),
            VoxelShapes.union(pipeShape, VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 16.0D), Block.createCuboidShape(0, 5, 5, 8, 11, 11))),
            VoxelShapes.union(pipeShape, VoxelShapes.union(Block.createCuboidShape(0.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(5, 5, 0, 11, 11, 8))),
            VoxelShapes.union(pipeShape, VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(8, 5, 5, 16, 11, 11))),

            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 8, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 8, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 8))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(8, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 16))),

            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 8, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 8, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 8))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(8, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 16)))

    );

    public static final List<VoxelShape> t_FlangeShapes = Arrays.asList(
            VoxelShapes.union(pipeShape, Block.createCuboidShape(5.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D)),
            VoxelShapes.union(pipeShape, Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 16.0D)),
            VoxelShapes.union(pipeShape, Block.createCuboidShape(0.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D)),
            VoxelShapes.union(pipeShape, Block.createCuboidShape(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 11.0D)),

            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 8, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 8, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 8))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(8, 5, 5, 16, 11, 11), Block.createCuboidShape(5, 5, 0, 11, 11, 16))),

            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 16, 11, 11))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(5, 5, 0, 11, 11, 16))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(0, 5, 5, 16, 11, 11))),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), VoxelShapes.union(Block.createCuboidShape(5, 5, 0, 11, 11, 16))),

            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(0, 5, 5, 16, 11, 11)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(5, 5, 0, 11, 11, 16)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(0, 5, 5, 16, 11, 11)),
            VoxelShapes.union(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.createCuboidShape(5, 5, 0, 11, 11, 16))

    );

    public static final List<VoxelShape> sixWayFlangeShape = Arrays.asList(VoxelShapes.union(pipeShape, VoxelShapes.union(pipeShapeHorizontal_NS, pipeShapeHorizontal_EW)));

    public static final List<VoxelShape> cubeFullShape = Arrays.asList(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));

    public static final List<VoxelShape> cubePartialShape = Arrays.asList(Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D));

    public static final List<VoxelShape> cubeMediumLargePartialShape = Arrays.asList(Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D));

    public static final List<VoxelShape> cubeMediumPartialShape = Arrays.asList(Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D));

    public static final List<VoxelShape> cubeSmallPartialShape = Arrays.asList(Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D));

    public static final List<VoxelShape> pillarShape = Arrays.asList(Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D));

    public static final List<VoxelShape> pillarHorizontalShape = Arrays.asList(
            Block.createCuboidShape(6, 6, 0, 10, 10, 16),
            Block.createCuboidShape(0, 6, 6, 16, 10, 10),
            Block.createCuboidShape(6, 6, 0, 10, 10, 16),
            Block.createCuboidShape(0, 6, 6, 16, 10, 10)
    );

    public static final List<VoxelShape> coverShape = Arrays.asList(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D));

    public static final List<VoxelShape> axisShapes = Arrays.asList(Block.createCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D),
            Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D),
            Block.createCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D)
    );

    public static final List<VoxelShape> trapdoorShapes = Arrays.asList(
            Block.createCuboidShape(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D),
            Block.createCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.createCuboidShape(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 16.0D)
            );

    public static final List<VoxelShape> dragonHeadShapes = Arrays.asList(
            VoxelShapes.union(Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.createCuboidShape(3.5, 6.5, -12.5, 12, 13.5, 2)),
            VoxelShapes.union(Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.createCuboidShape(14, 6.5, 3.5, 28.5, 13.5, 12)),
            VoxelShapes.union(Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.createCuboidShape(4, 6.5, 14, 12, 13.5, 28.5)),
            VoxelShapes.union(Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.createCuboidShape(-12.5, 6.5, 4, 2, 13.5, 12))
    );

    public static final List<VoxelShape> stairTopShapes = Arrays.asList(
            VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D)),
            VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D))
    );

    public static final List<VoxelShape> stairBottomShapes = Arrays.asList(
            VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D)),
            VoxelShapes.union(Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D))
    );

    public static final List<VoxelShape> stairInnerCornerTopShapes = Arrays.asList(
            VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D))
            );

    public static final List<VoxelShape> stairOuterCornerTopShapes = Arrays.asList(
            VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D)),
            VoxelShapes.union(Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D))
    );

    public static final List<VoxelShape> verticalSlabShapes = Arrays.asList(
            Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D),
            Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    );

    public static final List<VoxelShape> verticalQuarterShapes = Arrays.asList(
            Block.createCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D),
            Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D)
    );

    public static final List<VoxelShape> doorKnocker = Arrays.asList(
            Block.createCuboidShape(4.0D, 4.0D, 13.0D, 12.0D, 12.0D, 16.0D),
            Block.createCuboidShape(0.0D, 4.0D, 4.0D, 3.0D, 12.0D, 12.0D),
            Block.createCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 3.0D),
            Block.createCuboidShape(13.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D)
    );

    public static final List<VoxelShape> mirrorShape = Arrays.asList(
            Block.createCuboidShape(2.0D, 0.0D, 13.0D, 14.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 2.0D, 3.0D, 16.0D, 14.0D),
            Block.createCuboidShape(2.0D, 0.0D, 0.0D, 14.0D, 16.0D, 3.0D),
            Block.createCuboidShape(13.0D, 0.0D, 2.0D, 16.0D, 16.0D, 14.0D)
    );

    public static final List<VoxelShape> broomShape = Arrays.asList(
            Block.createCuboidShape(6.0D, 0.0D, 7.0D, 10.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 6.0D, 9.0D, 16.0D, 10.0D),
            Block.createCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 9.0D),
            Block.createCuboidShape(7.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D)
    );

    public static final List<VoxelShape> paneShape = Arrays.asList(
            Block.createCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D),
            Block.createCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D),
            Block.createCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D)
    );

    public static final List<VoxelShape> knobShapes = Arrays.asList(
            Block.createCuboidShape(4.0D, 4.0D, 13.0D, 12.0D, 12.0D, 16.0D),
            Block.createCuboidShape(0.0D, 4.0D, 4.0D, 3.0D, 12.0D, 12.0D),
            Block.createCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 3.0D),
            Block.createCuboidShape(13.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D),
            Block.createCuboidShape(4.0D, 13.0D, 4.0D, 12.0D, 16.0D, 12.0D),
            Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 3.0D, 12.0D)
    );

    public static final List<VoxelShape> bellowsShape = Arrays.asList(
            Block.createCuboidShape(3.0D, 0.0D, 0.0D, 13.0D, 12.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 12.0D, 13.0D),
            Block.createCuboidShape(3.0D, 0.0D, 0.0D, 13.0D, 12.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 12.0D, 13.0D)
    );

    public static final List<VoxelShape> slabShape = Arrays.asList(
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    );

    public static final List<VoxelShape> spinningWheelShape = Arrays.asList(
            Block.createCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 16.0D, 13.0D),
            Block.createCuboidShape(3.0D, 0.0D, 0.0D, 13.0D, 16.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 16.0D, 13.0D),
            Block.createCuboidShape(3.0D, 0.0D, 0.0D, 13.0D, 16.0D, 16.0D)
    );

    public static final List<VoxelShape> simpleCauldronShape = Arrays.asList(VoxelShapes.combineAndSimplify(VoxelShapes.fullCube(), Block.createCuboidShape(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D), BooleanBiFunction.ONLY_FIRST));
    public static final List<VoxelShape> halfCauldronShape = Arrays.asList(VoxelShapes.combineAndSimplify(Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D), BooleanBiFunction.ONLY_FIRST));

}
