package com.conquestreforged.content.blocks.block.windows;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

@Assets(
        state = @State(name = "%s_arrowslit", template = "parent_arrowslit"),
        item = @Model(name = "item/%s_arrowslit", parent = "block/%s_arrowslit", template = "item/parent_arrowslit"),
        block = {
                @Model(name = "block/%s_arrowslit", template = "block/parent_arrowslit"),
        }
)
public class ArrowSlit extends WaterloggedHorizontalDirectionalShape implements Waterloggable {

    private static final VoxelShape EAST_FR = Block.createCuboidShape(0.0D, 0.0D, 9.0D, 1.0D, 16.0D, 13.0D);
    private static final VoxelShape EAST_FL = Block.createCuboidShape(0.0D, 0.0D, 3.0D, 1.0D, 16.0D, 7.0D);
    private static final VoxelShape EAST_SR = Block.createCuboidShape(0.0D, 0.0D, 13.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SL = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 3.0D);
    private static final VoxelShape EAST_SHAPE = VoxelShapes.union(VoxelShapes.union(EAST_FR, EAST_FL), VoxelShapes.union(EAST_SR, EAST_SL));

    private static final VoxelShape WEST_FR = Block.createCuboidShape(15.0D, 0.0D, 9.0D, 16.0D, 16.0D, 13.0D);
    private static final VoxelShape WEST_FL = Block.createCuboidShape(15.0D, 0.0D, 3.0D, 16.0D, 16.0D, 7.0D);
    private static final VoxelShape WEST_SR = Block.createCuboidShape(8.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_SL = Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    private static final VoxelShape WEST_SHAPE = VoxelShapes.union(VoxelShapes.union(WEST_FR, WEST_FL), VoxelShapes.union(WEST_SR, WEST_SL));

    private static final VoxelShape NORTH_FR = Block.createCuboidShape(9.0D, 0.0D, 15.0D, 13.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_FL = Block.createCuboidShape(3.0D, 0.0D, 15.0D, 7.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_SR = Block.createCuboidShape(13.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_SL = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 3.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.union(VoxelShapes.union(NORTH_FR, NORTH_FL), VoxelShapes.union(NORTH_SR, NORTH_SL));

    private static final VoxelShape SOUTH_FR = Block.createCuboidShape(9.0D, 0.0D, 0.0D, 13.0D, 16.0D, 1.0D);
    private static final VoxelShape SOUTH_FL = Block.createCuboidShape(3.0D, 0.0D, 0.0D, 7.0D, 16.0D, 1.0D);
    private static final VoxelShape SOUTH_SR = Block.createCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape SOUTH_SL = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 8.0D);
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(VoxelShapes.union(SOUTH_FR, SOUTH_FL), VoxelShapes.union(SOUTH_SR, SOUTH_SL));

    public ArrowSlit(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(DIRECTION, Direction.NORTH).with(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
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
