package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedShape;
import com.conquestreforged.core.block.properties.SphereShape;
import com.conquestreforged.core.block.properties.Waterloggable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;


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

    private static final VoxelShape SPHERE_SMALL = Shapes.or(
            Block.box(4, 1, 4, 12, 9, 12),
            Block.box(5.5, 0, 5.5, 10.5, 1, 10.5),
            Block.box(5.5, 9, 5.5, 10.5, 10, 10.5),
            Block.box(3, 2.5, 5.5, 4, 7.5, 10.5),
            Block.box(12, 2.5, 5.5, 13, 7.5, 10.5),
            Block.box(5.5, 2.5, 12, 10.5, 7.5, 13),
            Block.box(5.5, 2.5, 2.9999, 10.5, 7.5, 3.9999));

    private static final VoxelShape SPHERE = Shapes.or(
            Block.box(1.64, 1.59, 1.64, 14.36, 14.31, 14.36),
            Block.box(4.025, 3.975, 0.04979, 11.975, 11.925, 1.63979),
            Block.box(4.025, 0, 4.025, 11.975, 1.59, 11.975),
            Block.box(4.025, 14.31, 4.025, 11.975, 15.9, 11.975),
            Block.box(0.05, 3.975, 4.025, 1.64, 11.925, 11.975),
            Block.box(14.36, 3.975, 4.025, 15.95, 11.925, 11.975),
            Block.box(4.025, 3.975, 14.36, 11.975, 11.925, 15.95));

    private static final VoxelShape DRAGONEGG = Shapes.or(
            Block.box(6, 15, 6, 10, 16, 10),
            Block.box(5, 14, 5, 11, 15, 11),
            Block.box(5, 13, 5, 11, 14, 11),
            Block.box(3, 11, 3, 13, 13, 13),
            Block.box(2, 8, 2, 14, 11, 14),
            Block.box(1, 3, 1, 15, 8, 15),
            Block.box(2, 1, 2, 14, 3, 14),
            Block.box(3, 0, 3, 13, 1, 13));

    public static final EnumProperty TYPE = EnumProperty.create("type", SphereShape.class);

    public Sphere(Block.Properties properties) {
        super(properties);
        registerDefaultState((this.stateDefinition.any()).setValue(TYPE, SphereShape.LARGE).setValue(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch(state.getValue(TYPE).toString()) {
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
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }
}
