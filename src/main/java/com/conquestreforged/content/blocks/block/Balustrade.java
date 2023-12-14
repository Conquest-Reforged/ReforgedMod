package com.conquestreforged.content.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s_balustrade", template = "parent_balustrade"),
        item = @Model(name = "item/%s_balustrade", parent = "block/%s_balustrade", template = "item/parent_balustrade"),
        block = {
                @Model(name = "block/%s_balustrade", template = "block/parent_balustrade"),
                @Model(name = "block/%s_balustrade_base", template = "block/parent_balustrade_base"),
        }
)
public class Balustrade extends PillarBlock implements Waterloggable {

    public static final VoxelShape field_196436_c = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D);
    public static final VoxelShape field_196439_y = Block.createCuboidShape(3.0D, 4.0D, 4.0D, 13.0D, 5.0D, 12.0D);
    public static final VoxelShape field_196440_z = Block.createCuboidShape(4.0D, 5.0D, 6.0D, 12.0D, 10.0D, 10.0D);
    public static final VoxelShape field_196434_A = Block.createCuboidShape(0.0D, 10.0D, 3.0D, 16.0D, 16.0D, 13.0D);
    public static final VoxelShape field_196435_B = Block.createCuboidShape(4.0D, 4.0D, 3.0D, 12.0D, 5.0D, 13.0D);
    public static final VoxelShape field_196437_C = Block.createCuboidShape(6.0D, 5.0D, 4.0D, 10.0D, 10.0D, 12.0D);
    public static final VoxelShape field_196438_D = Block.createCuboidShape(3.0D, 10.0D, 0.0D, 13.0D, 16.0D, 16.0D);
    public static final VoxelShape X_AXIS_AABB = VoxelShapes.union(field_196436_c, VoxelShapes.union(field_196439_y, VoxelShapes.union(field_196440_z, field_196434_A)));
    public static final VoxelShape Z_AXIS_AABB = VoxelShapes.union(field_196436_c, VoxelShapes.union(field_196435_B, VoxelShapes.union(field_196437_C, field_196438_D)));

    public static final VoxelShape Y_BASE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D);
    public static final VoxelShape Y_LOWER = Block.createCuboidShape(3.0D, 4.0D, 3.0D, 13.0D, 5.0D, 13.0D);
    public static final VoxelShape Y_MIDDLE = Block.createCuboidShape(4.0D, 5.0D, 4.0D, 12.0D, 11.0D, 12.0D);
    public static final VoxelShape Y_TOP = Block.createCuboidShape(2.0D, 11.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public static final VoxelShape Y_AXIS_AABB = VoxelShapes.union(Y_BASE, VoxelShapes.union(Y_LOWER, VoxelShapes.union(Y_MIDDLE, Y_TOP)));


    public Balustrade(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        switch (state.get(AXIS)) {
            case X:
            default:
                return X_AXIS_AABB;
            case Y:
                return Y_AXIS_AABB;
            case Z:
                return Z_AXIS_AABB;
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluidstate = context.getWorld().getFluidState(context.getBlockPos());
        return super.getPlacementState(context)
                .with(AXIS, context.getSide().getAxis())
                .with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER);
    }
}
