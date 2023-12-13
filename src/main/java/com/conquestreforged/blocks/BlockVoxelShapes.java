package com.conquestreforged.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;

import java.util.Arrays;
import java.util.List;

public class BlockVoxelShapes {

    public static final VoxelShape pipeShape = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    public static final VoxelShape pipeShapeHorizontal_EW = Block.box(5, 5, 0, 11, 11, 16);
    public static final VoxelShape pipeShapeHorizontal_NS = Block.box(0, 5, 5, 16, 11, 11);

    public static final List<VoxelShape> crossFlangeShapes = Arrays.asList(
            Shapes.or(pipeShape, pipeShapeHorizontal_NS),
            Shapes.or(pipeShape, pipeShapeHorizontal_EW),
            Shapes.or(pipeShapeHorizontal_EW, pipeShapeHorizontal_NS)
    );

    public static final List<VoxelShape> urnShape = Arrays.asList(
            Shapes.or(Block.box(0, 14, 0, 16, 16, 16), Shapes.or(
                    Block.box(3, 5.5, 3, 13, 13, 13), Shapes.or(
                            Block.box(1.5, 7, 1.5, 14.5, 12, 14.5), Shapes.or(
                                    Block.box(2, 13, 2, 14, 14, 14), Shapes.or(
                                            Block.box(5, 3.5, 5, 11, 5.5, 11), Shapes.or(
                                                    Block.box(5, 3.5, 5, 11, 5.5, 11), Shapes.or(
                                                            Block.box(5, 3.5, 5, 11, 5.5, 11), Shapes.or(
                                                                    Block.box(2, 0, 2, 14, 2, 14), Block.box(4, 2, 4, 12, 3.5, 12))
                            ))))))));

    public static final VoxelShape TOP_NORTHSOUTH_SHAPE = Block.box(-10.5D, 8.0D, 0.0D, 26.5D, 16.0D, 16.0D);
    public static final VoxelShape TOP_EASTWEST_SHAPE = Block.box(0.0D, 8.0D, -10.5D, 16.0D, 16.0D, 26.5D);

    public static final List<VoxelShape> tableShapes = Arrays.asList(TOP_NORTHSOUTH_SHAPE, TOP_EASTWEST_SHAPE, TOP_NORTHSOUTH_SHAPE, TOP_EASTWEST_SHAPE);

    public static final List<VoxelShape> fiveWayFlangeShapes = Arrays.asList(
            Shapes.or(pipeShape, Shapes.or(pipeShapeHorizontal_NS, Block.box(5, 5, 8, 11, 11, 16))),
            Shapes.or(pipeShape, Shapes.or(Block.box(0, 5, 5, 8, 11, 11), pipeShapeHorizontal_EW)),
            Shapes.or(pipeShape, Shapes.or(pipeShapeHorizontal_NS, Block.box(5, 5, 0, 11, 11, 8))),
            Shapes.or(pipeShape, Shapes.or(Block.box(8, 5, 5, 16, 11, 11), pipeShapeHorizontal_EW)),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D), Shapes.or(pipeShapeHorizontal_NS, pipeShapeHorizontal_EW)),
            Shapes.or(Block.box(5.0D, 8.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(pipeShapeHorizontal_NS, pipeShapeHorizontal_EW))
    );

    public static final List<VoxelShape> threeWayFlangeShapes = Arrays.asList(
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(8, 5, 5, 16, 11, 11), Block.box(5, 5, 8, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 8, 11, 11), Block.box(5, 5, 8, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 8, 11, 11), Block.box(5, 5, 0, 11, 11, 8))),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(8, 5, 5, 16, 11, 11), Block.box(5, 5, 0, 11, 11, 8))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(8, 5, 5, 16, 11, 11), Block.box(5, 5, 8, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 8, 11, 11), Block.box(5, 5, 8, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 8, 11, 11), Block.box(5, 5, 0, 11, 11, 8))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(8, 5, 5, 16, 11, 11), Block.box(5, 5, 0, 11, 11, 8)))
    );

    public static final List<VoxelShape> elbowFlangeShapes = Arrays.asList(
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(5, 5, 8, 11, 11, 16)),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(0, 5, 5, 8, 11, 11)),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(5, 5, 0, 11, 11, 8)),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(8, 5, 5, 16, 11, 11)),

            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Block.box(5, 5, 8, 11, 11, 16)),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Block.box(0, 5, 5, 8, 11, 11)),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Block.box(5, 5, 0, 11, 11, 8)),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Block.box(8, 5, 5, 16, 11, 11)),

            Shapes.or(Block.box(5, 5, 5, 16, 11, 11), Block.box(5, 5, 8, 11, 11, 16)),
            Shapes.or(Block.box(0, 5, 5, 11, 11, 11), Block.box(5, 5, 8, 11, 11, 16)),
            Shapes.or(Block.box(0, 5, 5, 11, 11, 11), Block.box(5, 5, 0, 11, 11, 8)),
            Shapes.or(Block.box(5, 5, 5, 16, 11, 11), Block.box(5, 5, 0, 11, 11, 8))
    );

    public static final List<VoxelShape> fourWayFlangeShapes = Arrays.asList(
            Shapes.or(pipeShape, Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D), Block.box(5, 5, 8, 11, 11, 16))),
            Shapes.or(pipeShape, Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 16.0D), Block.box(0, 5, 5, 8, 11, 11))),
            Shapes.or(pipeShape, Shapes.or(Block.box(0.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(5, 5, 0, 11, 11, 8))),
            Shapes.or(pipeShape, Shapes.or(Block.box(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 11.0D), Block.box(8, 5, 5, 16, 11, 11))),

            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 16, 11, 11), Block.box(5, 5, 8, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 8, 11, 11), Block.box(5, 5, 0, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 16, 11, 11), Block.box(5, 5, 0, 11, 11, 8))),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(8, 5, 5, 16, 11, 11), Block.box(5, 5, 0, 11, 11, 16))),

            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 16, 11, 11), Block.box(5, 5, 8, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 8, 11, 11), Block.box(5, 5, 0, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 16, 11, 11), Block.box(5, 5, 0, 11, 11, 8))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(8, 5, 5, 16, 11, 11), Block.box(5, 5, 0, 11, 11, 16)))

    );

    public static final List<VoxelShape> t_FlangeShapes = Arrays.asList(
            Shapes.or(pipeShape, Block.box(5.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D)),
            Shapes.or(pipeShape, Block.box(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 16.0D)),
            Shapes.or(pipeShape, Block.box(0.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D)),
            Shapes.or(pipeShape, Block.box(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 11.0D)),

            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 16, 11, 11), Block.box(5, 5, 8, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 8, 11, 11), Block.box(5, 5, 0, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 16, 11, 11), Block.box(5, 5, 0, 11, 11, 8))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D), Shapes.or(Block.box(8, 5, 5, 16, 11, 11), Block.box(5, 5, 0, 11, 11, 16))),

            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 16, 11, 11))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(5, 5, 0, 11, 11, 16))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(0, 5, 5, 16, 11, 11))),
            Shapes.or(Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D), Shapes.or(Block.box(5, 5, 0, 11, 11, 16))),

            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(0, 5, 5, 16, 11, 11)),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(5, 5, 0, 11, 11, 16)),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(0, 5, 5, 16, 11, 11)),
            Shapes.or(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(5, 5, 0, 11, 11, 16))

    );

    public static final List<VoxelShape> sixWayFlangeShape = Arrays.asList(Shapes.or(pipeShape, Shapes.or(pipeShapeHorizontal_NS, pipeShapeHorizontal_EW)));

    public static final List<VoxelShape> cubeFullShape = Arrays.asList(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));

    public static final List<VoxelShape> cubePartialShape = Arrays.asList(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D));

    public static final List<VoxelShape> cubeMediumLargePartialShape = Arrays.asList(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D));

    public static final List<VoxelShape> cubeMediumPartialShape = Arrays.asList(Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D));

    public static final List<VoxelShape> cubeSmallPartialShape = Arrays.asList(Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D));

    public static final List<VoxelShape> pillarShape = Arrays.asList(Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D));

    public static final List<VoxelShape> pillarHorizontalShape = Arrays.asList(
            Block.box(6, 6, 0, 10, 10, 16),
            Block.box(0, 6, 6, 16, 10, 10),
            Block.box(6, 6, 0, 10, 10, 16),
            Block.box(0, 6, 6, 16, 10, 10)
    );

    public static final List<VoxelShape> coverShape = Arrays.asList(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D));

    public static final List<VoxelShape> axisShapes = Arrays.asList(Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D),
            Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D)
    );

    public static final List<VoxelShape> trapdoorShapes = Arrays.asList(
            Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D),
            Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 16.0D)
            );

    public static final List<VoxelShape> dragonHeadShapes = Arrays.asList(
            Shapes.or(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.box(3.5, 6.5, -12.5, 12, 13.5, 2)),
            Shapes.or(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.box(14, 6.5, 3.5, 28.5, 13.5, 12)),
            Shapes.or(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.box(4, 6.5, 14, 12, 13.5, 28.5)),
            Shapes.or(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.box(-12.5, 6.5, 4, 2, 13.5, 12))
    );

    public static final List<VoxelShape> stairTopShapes = Arrays.asList(
            Shapes.or(Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D)),
            Shapes.or(Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D))
    );

    public static final List<VoxelShape> stairBottomShapes = Arrays.asList(
            Shapes.or(Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D)),
            Shapes.or(Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D))
    );

    public static final List<VoxelShape> stairInnerCornerTopShapes = Arrays.asList(
            Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D)),
            Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D), Block.box(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D), Block.box(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D))
            );

    public static final List<VoxelShape> stairOuterCornerTopShapes = Arrays.asList(
            Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(8.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 8.0D, 8.0D, 8.0D, 16.0D)),
            Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 8.0D)),
            Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D))
    );

    public static final List<VoxelShape> verticalSlabShapes = Arrays.asList(
            Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D),
            Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    );

    public static final List<VoxelShape> verticalQuarterShapes = Arrays.asList(
            Block.box(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D),
            Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D)
    );

    public static final List<VoxelShape> doorKnocker = Arrays.asList(
            Block.box(4.0D, 4.0D, 13.0D, 12.0D, 12.0D, 16.0D),
            Block.box(0.0D, 4.0D, 4.0D, 3.0D, 12.0D, 12.0D),
            Block.box(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 3.0D),
            Block.box(13.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D)
    );

    public static final List<VoxelShape> mirrorShape = Arrays.asList(
            Block.box(2.0D, 0.0D, 13.0D, 14.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 2.0D, 3.0D, 16.0D, 14.0D),
            Block.box(2.0D, 0.0D, 0.0D, 14.0D, 16.0D, 3.0D),
            Block.box(13.0D, 0.0D, 2.0D, 16.0D, 16.0D, 14.0D)
    );

    public static final List<VoxelShape> broomShape = Arrays.asList(
            Block.box(6.0D, 0.0D, 7.0D, 10.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 6.0D, 9.0D, 16.0D, 10.0D),
            Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 9.0D),
            Block.box(7.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D)
    );

    public static final List<VoxelShape> paneShape = Arrays.asList(
            Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D),
            Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D),
            Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D)
    );

    public static final List<VoxelShape> knobShapes = Arrays.asList(
            Block.box(4.0D, 4.0D, 13.0D, 12.0D, 12.0D, 16.0D),
            Block.box(0.0D, 4.0D, 4.0D, 3.0D, 12.0D, 12.0D),
            Block.box(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 3.0D),
            Block.box(13.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D),
            Block.box(4.0D, 13.0D, 4.0D, 12.0D, 16.0D, 12.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 3.0D, 12.0D)
    );

    public static final List<VoxelShape> bellowsShape = Arrays.asList(
            Block.box(3.0D, 0.0D, 0.0D, 13.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 3.0D, 16.0D, 12.0D, 13.0D),
            Block.box(3.0D, 0.0D, 0.0D, 13.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 3.0D, 16.0D, 12.0D, 13.0D)
    );

    public static final List<VoxelShape> slabShape = Arrays.asList(
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    );

    public static final List<VoxelShape> spinningWheelShape = Arrays.asList(
            Block.box(0.0D, 0.0D, 3.0D, 16.0D, 16.0D, 13.0D),
            Block.box(3.0D, 0.0D, 0.0D, 13.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 3.0D, 16.0D, 16.0D, 13.0D),
            Block.box(3.0D, 0.0D, 0.0D, 13.0D, 16.0D, 16.0D)
    );

    public static final List<VoxelShape> simpleCauldronShape = Arrays.asList(Shapes.join(Shapes.block(), Block.box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D), BooleanOp.ONLY_FIRST));
    public static final List<VoxelShape> halfCauldronShape = Arrays.asList(Shapes.join(Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D), BooleanOp.ONLY_FIRST));

}
