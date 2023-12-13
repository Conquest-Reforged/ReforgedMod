package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.IntStream;

@Assets(
        state = @State(name = "%s_platform", template = "parent_platform_horizontal"),
        item = @Model(name = "item/%s_platform", parent = "block/%s_platform_horizontal_top", template = "item/acacia_stairs"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_platform_horizontal_bottom", template = "block/parent_platform_horizontal_bottom"),
                @Model(name = "block/%s_platform_horizontal_bottom_outer", template = "block/parent_platform_horizontal_bottom_outer"),
                @Model(name = "block/%s_platform_horizontal_bottom_inner", template = "block/parent_platform_horizontal_bottom_inner"),
                @Model(name = "block/%s_platform_horizontal_top", template = "block/parent_platform_horizontal_top"),
                @Model(name = "block/%s_platform_horizontal_top_outer", template = "block/parent_platform_horizontal_top_outer"),
                @Model(name = "block/%s_platform_horizontal_top_inner", template = "block/parent_platform_horizontal_top_inner")
        }
)

public class PlatformHorizontal extends StairsBlock {

    protected static final VoxelShape AABB_SLAB_TOP = Block.createCuboidShape(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape AABB_SLAB_BOTTOM = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    protected static final VoxelShape NWD_CORNER = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 12.0D, 4.0D);
    protected static final VoxelShape SWD_CORNER = Block.createCuboidShape(0.0D, 0.0D, 12.0D, 4.0D, 12.0D, 16.0D);
    protected static final VoxelShape NED_CORNER = Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 12.0D, 4.0D);
    protected static final VoxelShape SED_CORNER = Block.createCuboidShape(12.0D, 0.0D, 12.0D, 16.0D, 12.0D, 16.0D);
    protected static final VoxelShape NWU_CORNER = Block.createCuboidShape(0.0D, 4.0D, 0.0D, 4.0D, 16.0D, 4.0D);
    protected static final VoxelShape SWU_CORNER = Block.createCuboidShape(0.0D, 4.0D, 12.0D, 4.0D, 16.0D, 16.0D);
    protected static final VoxelShape NEU_CORNER = Block.createCuboidShape(12.0D, 4.0D, 0.0D, 16.0D, 16.0D, 4.0D);
    protected static final VoxelShape SEU_CORNER = Block.createCuboidShape(12.0D, 4.0D, 12.0D, 16.0D, 16.0D, 16.0D);

    protected static final VoxelShape WEST_OPEN_AABB = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_OPEN_AABB = Block.createCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_OPEN_AABB = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape SOUTH_OPEN_AABB = Block.createCuboidShape(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);

    private static final VoxelShape NORTH_QUARTER_SHAPE = Block.createCuboidShape(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_QUARTER_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0);
    private static final VoxelShape EAST_QUARTER_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_QUARTER_SHAPE = Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);

    private static final VoxelShape EAST_CORNER = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape QTR_EAST_CORNER = Block.createCuboidShape(4.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SHAPE_CORNER = VoxelShapes.union(EAST_CORNER, QTR_EAST_CORNER);

    private static final VoxelShape WEST_CORNER = Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape QTR_WEST_CORNER = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 4.0D);
    private static final VoxelShape WEST_SHAPE_CORNER = VoxelShapes.union(WEST_CORNER, QTR_WEST_CORNER);

    private static final VoxelShape NORTH_CORNER = Block.createCuboidShape(0.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape QTR_NORTH_CORNER = Block.createCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D);
    private static final VoxelShape NORTH_SHAPE_CORNER = VoxelShapes.union(NORTH_CORNER, QTR_NORTH_CORNER);

    private static final VoxelShape SOUTH_CORNER = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
    private static final VoxelShape QTR_SOUTH_CORNER = Block.createCuboidShape(0.0D, 0.0D, 4.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE_CORNER = VoxelShapes.union(SOUTH_CORNER, QTR_SOUTH_CORNER);


    protected static final VoxelShape[] SLAB_TOP_SHAPES = composeShapes(AABB_SLAB_TOP, NWD_CORNER, NED_CORNER, SWD_CORNER, SED_CORNER);
    protected static final VoxelShape[] SLAB_BOTTOM_SHAPES = composeShapes(AABB_SLAB_BOTTOM, NWU_CORNER, NEU_CORNER, SWU_CORNER, SEU_CORNER);
    private static final int[] field_196522_K = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};

    public PlatformHorizontal(BlockState parent, Settings properties) {
        super(parent, properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(HALF) == BlockHalf.BOTTOM) {
            if (state.get(FACING) == Direction.NORTH) {
                if (state.get(SHAPE) == StairShape.INNER_LEFT) {
                    return SOUTH_SHAPE_CORNER;
                } else if (state.get(SHAPE) == StairShape.INNER_RIGHT) {
                    return WEST_SHAPE_CORNER;
                } else if (state.get(SHAPE) == StairShape.OUTER_LEFT) {
                    return SOUTH_QUARTER_SHAPE;
                } else if (state.get(SHAPE) == StairShape.OUTER_RIGHT) {
                    return WEST_QUARTER_SHAPE;
                } else {
                    return NORTH_OPEN_AABB;
                }

            } else if (state.get(FACING) == Direction.EAST) {
                if (state.get(SHAPE) == StairShape.INNER_LEFT) {
                    return WEST_SHAPE_CORNER;
                } else if (state.get(SHAPE) == StairShape.INNER_RIGHT) {
                    return NORTH_SHAPE_CORNER;
                } else if (state.get(SHAPE) == StairShape.OUTER_LEFT) {
                    return WEST_QUARTER_SHAPE;
                } else if (state.get(SHAPE) == StairShape.OUTER_RIGHT) {
                    return NORTH_QUARTER_SHAPE;
                } else {
                    return EAST_OPEN_AABB;
                }
            } else if (state.get(FACING) == Direction.SOUTH) {
                if (state.get(SHAPE) == StairShape.INNER_LEFT) {
                    return NORTH_SHAPE_CORNER;
                } else if (state.get(SHAPE) == StairShape.INNER_RIGHT) {
                    return EAST_SHAPE_CORNER;
                } else if (state.get(SHAPE) == StairShape.OUTER_LEFT) {
                    return NORTH_QUARTER_SHAPE;
                } else if (state.get(SHAPE) == StairShape.OUTER_RIGHT) {
                    return EAST_QUARTER_SHAPE;
                } else {
                    return SOUTH_OPEN_AABB;
                }
            } else if (state.get(FACING) == Direction.WEST) {
                if (state.get(SHAPE) == StairShape.INNER_LEFT) {
                    return EAST_SHAPE_CORNER;
                } else if (state.get(SHAPE) == StairShape.INNER_RIGHT) {
                    return SOUTH_SHAPE_CORNER;
                } else if (state.get(SHAPE) == StairShape.OUTER_LEFT) {
                    return EAST_QUARTER_SHAPE;
                } else if (state.get(SHAPE) == StairShape.OUTER_RIGHT) {
                    return SOUTH_QUARTER_SHAPE;
                } else {
                    return WEST_OPEN_AABB;
                }
            }
        }
        return (state.get(HALF) == BlockHalf.TOP ? SLAB_TOP_SHAPES : SLAB_BOTTOM_SHAPES)[field_196522_K[this.getShapeIndexIndex(state)]];
    }

    private int getShapeIndexIndex(BlockState state) {
        return state.get(SHAPE).ordinal() * 4 + state.get(FACING).getHorizontal();
    }

    private static VoxelShape[] composeShapes(VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        return IntStream.range(0, 16).mapToObj((p_199780_5_) -> {
            return combineShapes(p_199780_5_, slabShape, nwCorner, neCorner, swCorner, seCorner);
        }).toArray((p_199778_0_) -> {
            return new VoxelShape[p_199778_0_];
        });
    }

    private static VoxelShape combineShapes(int bitfield, VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        VoxelShape voxelshape = slabShape;
        if ((bitfield & 1) != 0) {
            voxelshape = VoxelShapes.union(slabShape, nwCorner);
        }

        if ((bitfield & 2) != 0) {
            voxelshape = VoxelShapes.union(voxelshape, neCorner);
        }

        if ((bitfield & 4) != 0) {
            voxelshape = VoxelShapes.union(voxelshape, swCorner);
        }

        if ((bitfield & 8) != 0) {
            voxelshape = VoxelShapes.union(voxelshape, seCorner);
        }

        return voxelshape;
    }
}