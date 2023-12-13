package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.WaterloggedShape;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;


@Assets(
        state = @State(name = "%s_small_pillar", template = "parent_pillar_small"),
        item = @Model(name = "item/%s_small_pillar", parent = "block/%s_fence_post", template = "item/dragon_egg"),
        block = {
                @Model(name = "block/%s_fence_post", template = "block/acacia_fence_post")
        }
)
public class PillarSmall extends WaterloggedShape {

    protected static final VoxelShape SHAPE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

    public PillarSmall(Properties properties) {
        super(properties);
        registerDefaultState((this.stateDefinition.any()).setValue(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }
}
