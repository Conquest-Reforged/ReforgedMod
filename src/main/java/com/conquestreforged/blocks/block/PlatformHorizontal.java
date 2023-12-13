package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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

public class PlatformHorizontal extends StairBlock {

    protected static final VoxelShape AABB_SLAB_TOP = Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape AABB_SLAB_BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    protected static final VoxelShape NWD_CORNER = Block.box(0.0D, 0.0D, 0.0D, 4.0D, 12.0D, 4.0D);
    protected static final VoxelShape SWD_CORNER = Block.box(0.0D, 0.0D, 12.0D, 4.0D, 12.0D, 16.0D);
    protected static final VoxelShape NED_CORNER = Block.box(12.0D, 0.0D, 0.0D, 16.0D, 12.0D, 4.0D);
    protected static final VoxelShape SED_CORNER = Block.box(12.0D, 0.0D, 12.0D, 16.0D, 12.0D, 16.0D);
    protected static final VoxelShape NWU_CORNER = Block.box(0.0D, 4.0D, 0.0D, 4.0D, 16.0D, 4.0D);
    protected static final VoxelShape SWU_CORNER = Block.box(0.0D, 4.0D, 12.0D, 4.0D, 16.0D, 16.0D);
    protected static final VoxelShape NEU_CORNER = Block.box(12.0D, 4.0D, 0.0D, 16.0D, 16.0D, 4.0D);
    protected static final VoxelShape SEU_CORNER = Block.box(12.0D, 4.0D, 12.0D, 16.0D, 16.0D, 16.0D);

    protected static final VoxelShape WEST_OPEN_AABB = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_OPEN_AABB = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_OPEN_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape SOUTH_OPEN_AABB = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);

    private static final VoxelShape NORTH_QUARTER_SHAPE = Block.box(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_QUARTER_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0);
    private static final VoxelShape EAST_QUARTER_SHAPE = Block.box(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_QUARTER_SHAPE = Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);

    private static final VoxelShape EAST_CORNER = Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape QTR_EAST_CORNER = Block.box(4.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SHAPE_CORNER = Shapes.or(EAST_CORNER, QTR_EAST_CORNER);

    private static final VoxelShape WEST_CORNER = Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape QTR_WEST_CORNER = Block.box(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 4.0D);
    private static final VoxelShape WEST_SHAPE_CORNER = Shapes.or(WEST_CORNER, QTR_WEST_CORNER);

    private static final VoxelShape NORTH_CORNER = Block.box(0.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape QTR_NORTH_CORNER = Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D);
    private static final VoxelShape NORTH_SHAPE_CORNER = Shapes.or(NORTH_CORNER, QTR_NORTH_CORNER);

    private static final VoxelShape SOUTH_CORNER = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
    private static final VoxelShape QTR_SOUTH_CORNER = Block.box(0.0D, 0.0D, 4.0D, 4.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE_CORNER = Shapes.or(SOUTH_CORNER, QTR_SOUTH_CORNER);


    protected static final VoxelShape[] SLAB_TOP_SHAPES = makeShapes(AABB_SLAB_TOP, NWD_CORNER, NED_CORNER, SWD_CORNER, SED_CORNER);
    protected static final VoxelShape[] SLAB_BOTTOM_SHAPES = makeShapes(AABB_SLAB_BOTTOM, NWU_CORNER, NEU_CORNER, SWU_CORNER, SEU_CORNER);
    private static final int[] field_196522_K = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};

    public PlatformHorizontal(BlockState parent, Properties properties) {
        super(parent, properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(HALF) == Half.BOTTOM) {
            if (state.getValue(FACING) == Direction.NORTH) {
                if (state.getValue(SHAPE) == StairsShape.INNER_LEFT) {
                    return SOUTH_SHAPE_CORNER;
                } else if (state.getValue(SHAPE) == StairsShape.INNER_RIGHT) {
                    return WEST_SHAPE_CORNER;
                } else if (state.getValue(SHAPE) == StairsShape.OUTER_LEFT) {
                    return SOUTH_QUARTER_SHAPE;
                } else if (state.getValue(SHAPE) == StairsShape.OUTER_RIGHT) {
                    return WEST_QUARTER_SHAPE;
                } else {
                    return NORTH_OPEN_AABB;
                }

            } else if (state.getValue(FACING) == Direction.EAST) {
                if (state.getValue(SHAPE) == StairsShape.INNER_LEFT) {
                    return WEST_SHAPE_CORNER;
                } else if (state.getValue(SHAPE) == StairsShape.INNER_RIGHT) {
                    return NORTH_SHAPE_CORNER;
                } else if (state.getValue(SHAPE) == StairsShape.OUTER_LEFT) {
                    return WEST_QUARTER_SHAPE;
                } else if (state.getValue(SHAPE) == StairsShape.OUTER_RIGHT) {
                    return NORTH_QUARTER_SHAPE;
                } else {
                    return EAST_OPEN_AABB;
                }
            } else if (state.getValue(FACING) == Direction.SOUTH) {
                if (state.getValue(SHAPE) == StairsShape.INNER_LEFT) {
                    return NORTH_SHAPE_CORNER;
                } else if (state.getValue(SHAPE) == StairsShape.INNER_RIGHT) {
                    return EAST_SHAPE_CORNER;
                } else if (state.getValue(SHAPE) == StairsShape.OUTER_LEFT) {
                    return NORTH_QUARTER_SHAPE;
                } else if (state.getValue(SHAPE) == StairsShape.OUTER_RIGHT) {
                    return EAST_QUARTER_SHAPE;
                } else {
                    return SOUTH_OPEN_AABB;
                }
            } else if (state.getValue(FACING) == Direction.WEST) {
                if (state.getValue(SHAPE) == StairsShape.INNER_LEFT) {
                    return EAST_SHAPE_CORNER;
                } else if (state.getValue(SHAPE) == StairsShape.INNER_RIGHT) {
                    return SOUTH_SHAPE_CORNER;
                } else if (state.getValue(SHAPE) == StairsShape.OUTER_LEFT) {
                    return EAST_QUARTER_SHAPE;
                } else if (state.getValue(SHAPE) == StairsShape.OUTER_RIGHT) {
                    return SOUTH_QUARTER_SHAPE;
                } else {
                    return WEST_OPEN_AABB;
                }
            }
        }
        return (state.getValue(HALF) == Half.TOP ? SLAB_TOP_SHAPES : SLAB_BOTTOM_SHAPES)[field_196522_K[this.getShapeIndex(state)]];
    }

    private int getShapeIndex(BlockState state) {
        return state.getValue(SHAPE).ordinal() * 4 + state.getValue(FACING).get2DDataValue();
    }

    private static VoxelShape[] makeShapes(VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        return IntStream.range(0, 16).mapToObj((p_199780_5_) -> {
            return combineShapes(p_199780_5_, slabShape, nwCorner, neCorner, swCorner, seCorner);
        }).toArray((p_199778_0_) -> {
            return new VoxelShape[p_199778_0_];
        });
    }

    private static VoxelShape combineShapes(int bitfield, VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        VoxelShape voxelshape = slabShape;
        if ((bitfield & 1) != 0) {
            voxelshape = Shapes.or(slabShape, nwCorner);
        }

        if ((bitfield & 2) != 0) {
            voxelshape = Shapes.or(voxelshape, neCorner);
        }

        if ((bitfield & 4) != 0) {
            voxelshape = Shapes.or(voxelshape, swCorner);
        }

        if ((bitfield & 8) != 0) {
            voxelshape = Shapes.or(voxelshape, seCorner);
        }

        return voxelshape;
    }
}