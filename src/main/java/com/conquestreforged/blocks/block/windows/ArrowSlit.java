package com.conquestreforged.blocks.block.windows;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_arrowslit", template = "parent_arrowslit"),
        item = @Model(name = "item/%s_arrowslit", parent = "block/%s_arrowslit", template = "item/parent_arrowslit"),
        block = {
                @Model(name = "block/%s_arrowslit", template = "block/parent_arrowslit"),
        }
)
public class ArrowSlit extends WaterloggedHorizontalDirectionalShape implements Waterloggable {

    private static final VoxelShape EAST_FR = Block.box(0.0D, 0.0D, 9.0D, 1.0D, 16.0D, 13.0D);
    private static final VoxelShape EAST_FL = Block.box(0.0D, 0.0D, 3.0D, 1.0D, 16.0D, 7.0D);
    private static final VoxelShape EAST_SR = Block.box(0.0D, 0.0D, 13.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SL = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 3.0D);
    private static final VoxelShape EAST_SHAPE = Shapes.or(Shapes.or(EAST_FR, EAST_FL), Shapes.or(EAST_SR, EAST_SL));

    private static final VoxelShape WEST_FR = Block.box(15.0D, 0.0D, 9.0D, 16.0D, 16.0D, 13.0D);
    private static final VoxelShape WEST_FL = Block.box(15.0D, 0.0D, 3.0D, 16.0D, 16.0D, 7.0D);
    private static final VoxelShape WEST_SR = Block.box(8.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_SL = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    private static final VoxelShape WEST_SHAPE = Shapes.or(Shapes.or(WEST_FR, WEST_FL), Shapes.or(WEST_SR, WEST_SL));

    private static final VoxelShape NORTH_FR = Block.box(9.0D, 0.0D, 15.0D, 13.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_FL = Block.box(3.0D, 0.0D, 15.0D, 7.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_SR = Block.box(13.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_SL = Block.box(0.0D, 0.0D, 8.0D, 3.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_SHAPE = Shapes.or(Shapes.or(NORTH_FR, NORTH_FL), Shapes.or(NORTH_SR, NORTH_SL));

    private static final VoxelShape SOUTH_FR = Block.box(9.0D, 0.0D, 0.0D, 13.0D, 16.0D, 1.0D);
    private static final VoxelShape SOUTH_FL = Block.box(3.0D, 0.0D, 0.0D, 7.0D, 16.0D, 1.0D);
    private static final VoxelShape SOUTH_SR = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape SOUTH_SL = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 8.0D);
    private static final VoxelShape SOUTH_SHAPE = Shapes.or(Shapes.or(SOUTH_FR, SOUTH_FL), Shapes.or(SOUTH_SR, SOUTH_SL));

    public ArrowSlit(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(DIRECTION)) {
            case NORTH:
            default:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
        }
    }
}
