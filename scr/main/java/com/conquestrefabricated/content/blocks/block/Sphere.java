package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.WaterloggedShape;
import com.conquestrefabricated.core.block.properties.SphereShape;
import com.conquestrefabricated.core.block.properties.Waterloggable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;


@Assets(
        state = @State(name = "%s_sphere", template = "parent_sphere"),
        item = @Model(name = "item/%s_sphere", parent = "block/%s_sphere", template = "item/dragon_egg"),
        block = {
                @Model(name = "block/%s_sphere", template = "block/parent_sphere"),
                @Model(name = "block/%s_sphere_dragonegg", template = "block/dragon_egg"),
                @Model(name = "block/%s_sphere_small", template = "block/parent_sphere_small"),
        }
)
public class Sphere extends WaterloggedShape implements Waterloggable {

    private static final VoxelShape SPHERE_SMALL = VoxelShapes.union(
            Block.createCuboidShape(4, 1, 4, 12, 9, 12),
            Block.createCuboidShape(5.5, 0, 5.5, 10.5, 1, 10.5),
            Block.createCuboidShape(5.5, 9, 5.5, 10.5, 10, 10.5),
            Block.createCuboidShape(3, 2.5, 5.5, 4, 7.5, 10.5),
            Block.createCuboidShape(12, 2.5, 5.5, 13, 7.5, 10.5),
            Block.createCuboidShape(5.5, 2.5, 12, 10.5, 7.5, 13),
            Block.createCuboidShape(5.5, 2.5, 2.9999, 10.5, 7.5, 3.9999));

    private static final VoxelShape SPHERE = VoxelShapes.union(
            Block.createCuboidShape(1.64, 1.59, 1.64, 14.36, 14.31, 14.36),
            Block.createCuboidShape(4.025, 3.975, 0.04979, 11.975, 11.925, 1.63979),
            Block.createCuboidShape(4.025, 0, 4.025, 11.975, 1.59, 11.975),
            Block.createCuboidShape(4.025, 14.31, 4.025, 11.975, 15.9, 11.975),
            Block.createCuboidShape(0.05, 3.975, 4.025, 1.64, 11.925, 11.975),
            Block.createCuboidShape(14.36, 3.975, 4.025, 15.95, 11.925, 11.975),
            Block.createCuboidShape(4.025, 3.975, 14.36, 11.975, 11.925, 15.95));

    private static final VoxelShape DRAGONEGG = VoxelShapes.union(
            Block.createCuboidShape(6, 15, 6, 10, 16, 10),
            Block.createCuboidShape(5, 14, 5, 11, 15, 11),
            Block.createCuboidShape(5, 13, 5, 11, 14, 11),
            Block.createCuboidShape(3, 11, 3, 13, 13, 13),
            Block.createCuboidShape(2, 8, 2, 14, 11, 14),
            Block.createCuboidShape(1, 3, 1, 15, 8, 15),
            Block.createCuboidShape(2, 1, 2, 14, 3, 14),
            Block.createCuboidShape(3, 0, 3, 13, 1, 13));

    public static final EnumProperty TYPE = EnumProperty.of("type", SphereShape.class);

    public Sphere(AbstractBlock.Settings properties) {
        super(properties);
        setDefaultState((this.stateManager.getDefaultState()).with(TYPE, SphereShape.LARGE).with(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch(state.get(TYPE).toString()) {
            default:
            case "egg":
                return DRAGONEGG;
            case "small":
                return SPHERE_SMALL;
            case "large":
                return SPHERE;
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }
}
