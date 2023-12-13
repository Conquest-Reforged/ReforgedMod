package com.conquestreforged.blocks.block.trees;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Render(RenderLayer.CUTOUT_MIPPED)
public class LeavesLightToggle extends LeavesBlock {

    public static final BooleanProperty LIGHT_PASS_THRU = BooleanProperty.create("light_pass_thru");
    private final ItemLike sapling;

    public LeavesLightToggle(Props props) {
        super(props.toProperties());
        this.sapling = props.get("sapling", ItemLike.class);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIGHT_PASS_THRU, false).setValue(DISTANCE, 7).setValue(PERSISTENT, false));
    }

    @Deprecated
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(LIGHT_PASS_THRU)) {
            return BlockVoxelShapes.cubePartialShape.get(0);
        } else {
            return Shapes.block();
        }
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        if (state.getValue(LIGHT_PASS_THRU)) {
            return 0;
        } else {
            return 1;
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateList) {
        stateList.add(LIGHT_PASS_THRU, DISTANCE, PERSISTENT);
    }

}
