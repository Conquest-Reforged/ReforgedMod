package com.conquestreforged.blocks.block.trees;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

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

    public Branch(Properties properties) {
        super(properties);
        this.wallUpShapes = this.makeUpShapes(3.0F, 3.0F, 16.0F, 10.0F, 16.0F);
        this.wallRegularShapes = this.makeRegularShapes(3.0F, 3.0F, 16.0F, 10.0F, 16.0F);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(UP) ? this.wallUpShapes[this.getAABBIndex(state)] : this.wallRegularShapes[this.getAABBIndex(state)];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(UP) ? this.wallUpShapes[this.getAABBIndex(state)] : this.wallRegularShapes[this.getAABBIndex(state)];
    }
}
