package com.conquestreforged.content.blocks.block.trees;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@Render(RenderLayer.CUTOUT_MIPPED)
public class LeavesLightToggle extends LeavesBlock {

    public static final BooleanProperty LIGHT_PASS_THRU = BooleanProperty.of("light_pass_thru");
    private final ItemConvertible sapling;

    public LeavesLightToggle(Props props) {
        super(props.toSettings());
        this.sapling = props.get("sapling", ItemConvertible.class);
        this.setDefaultState(this.stateManager.getDefaultState().with(LIGHT_PASS_THRU, false).with(DISTANCE, 7).with(PERSISTENT, false).with(WATERLOGGED, false));
    }

    @Deprecated
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(LIGHT_PASS_THRU)) {
            return BlockVoxelShapes.cubePartialShape.get(0);
        } else {
            return VoxelShapes.fullCube();
        }
    }

    @Override
    public int getOpacity(BlockState state, BlockView worldIn, BlockPos pos) {
        if (state.get(LIGHT_PASS_THRU)) {
            return 0;
        } else {
            return 1;
        }
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateList) {
        stateList.add(LIGHT_PASS_THRU, DISTANCE, PERSISTENT, WATERLOGGED);
    }

}
