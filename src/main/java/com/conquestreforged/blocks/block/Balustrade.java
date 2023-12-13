package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_balustrade", template = "parent_balustrade"),
        item = @Model(name = "item/%s_balustrade", parent = "block/%s_balustrade", template = "item/parent_balustrade"),
        block = {
                @Model(name = "block/%s_balustrade", template = "block/parent_balustrade"),
                @Model(name = "block/%s_balustrade_base", template = "block/parent_balustrade_base"),
        }
)
public class Balustrade extends RotatedPillarBlock implements Waterloggable {

    public static final VoxelShape field_196436_c = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D);
    public static final VoxelShape field_196439_y = Block.box(3.0D, 4.0D, 4.0D, 13.0D, 5.0D, 12.0D);
    public static final VoxelShape field_196440_z = Block.box(4.0D, 5.0D, 6.0D, 12.0D, 10.0D, 10.0D);
    public static final VoxelShape field_196434_A = Block.box(0.0D, 10.0D, 3.0D, 16.0D, 16.0D, 13.0D);
    public static final VoxelShape field_196435_B = Block.box(4.0D, 4.0D, 3.0D, 12.0D, 5.0D, 13.0D);
    public static final VoxelShape field_196437_C = Block.box(6.0D, 5.0D, 4.0D, 10.0D, 10.0D, 12.0D);
    public static final VoxelShape field_196438_D = Block.box(3.0D, 10.0D, 0.0D, 13.0D, 16.0D, 16.0D);
    public static final VoxelShape X_AXIS_AABB = Shapes.or(field_196436_c, Shapes.or(field_196439_y, Shapes.or(field_196440_z, field_196434_A)));
    public static final VoxelShape Z_AXIS_AABB = Shapes.or(field_196436_c, Shapes.or(field_196435_B, Shapes.or(field_196437_C, field_196438_D)));

    public static final VoxelShape Y_BASE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D);
    public static final VoxelShape Y_LOWER = Block.box(3.0D, 4.0D, 3.0D, 13.0D, 5.0D, 13.0D);
    public static final VoxelShape Y_MIDDLE = Block.box(4.0D, 5.0D, 4.0D, 12.0D, 11.0D, 12.0D);
    public static final VoxelShape Y_TOP = Block.box(2.0D, 11.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public static final VoxelShape Y_AXIS_AABB = Shapes.or(Y_BASE, Shapes.or(Y_LOWER, Shapes.or(Y_MIDDLE, Y_TOP)));


    public Balustrade(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        switch (state.getValue(AXIS)) {
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
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return super.getStateForPlacement(context)
                .setValue(AXIS, context.getClickedFace().getAxis())
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }
}
