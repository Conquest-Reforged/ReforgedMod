package com.conquestrefabricated.content.blocks.block.trees;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

@Assets(
        state = @State(name = "%s_branch", template = "parent_branch"),
        item = @Model(name = "item/%s_branch", parent = "block/%s_branch_post", template = "item/cobblestone_wall"),
        block = {
                @Model(name = "block/%s_branch_post", template = "block/parent_branch_post"),
                @Model(name = "block/%s_branch_n", template = "block/parent_branch_n"),
                @Model(name = "block/%s_branch_n_1", template = "block/parent_branch_n_1"),
                @Model(name = "block/%s_branch_ne", template = "block/parent_branch_ne"),
                @Model(name = "block/%s_branch_ns", template = "block/parent_branch_ns"),
                @Model(name = "block/%s_branch_ns_up", template = "block/parent_branch_ns_up"),
                @Model(name = "block/%s_branch_nse", template = "block/parent_branch_nse"),
                @Model(name = "block/%s_branch_nsew", template = "block/parent_branch_nsew"),
                @Model(name = "block/%s_branch_n_up", template = "block/parent_branch_n_up"),
                @Model(name = "block/%s_branch_n_up", template = "block/parent_branch_n_up_1"),
                @Model(name = "block/%s_branch_ne_up", template = "block/parent_branch_ne_up"),
                @Model(name = "block/%s_branch_nse_up", template = "block/parent_branch_nse_up"),
                @Model(name = "block/%s_branch_nsew_up", template = "block/parent_branch_ne_up")
        }
)
public class Branch extends BranchLarge {

    private final VoxelShape[] wallUpShapes;
    private final VoxelShape[] wallRegularShapes;

    public Branch(Settings properties) {
        super(properties);
        this.wallUpShapes = this.makeUpShapes(3.0F, 3.0F, 16.0F, 10.0F, 16.0F);
        this.wallRegularShapes = this.makeRegularShapes(3.0F, 3.0F, 16.0F, 10.0F, 16.0F);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallUpShapes[this.getShapeIndex(state)] : this.wallRegularShapes[this.getShapeIndex(state)];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(UP) ? this.wallUpShapes[this.getShapeIndex(state)] : this.wallRegularShapes[this.getShapeIndex(state)];
    }
}
