package com.conquestrefabricated.content.blocks.block.pipes;

import com.conquestrefabricated.content.blocks.BlockVoxelShapes;
import com.conquestrefabricated.content.blocks.block.decor.HorizontalDirectionalWaterloggedToggle4;
import com.conquestrefabricated.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.shape.VoxelShape;

public class t_Flange extends HorizontalDirectionalWaterloggedToggle4 {

    public t_Flange(Props props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(TOGGLE)) {
            default:
            case 1:
                switch(state.get(WaterloggedHorizontalDirectionalShape.DIRECTION)) {
                    default:
                    case NORTH:
                        return BlockVoxelShapes.t_FlangeShapes.get(0);
                    case EAST:
                        return BlockVoxelShapes.t_FlangeShapes.get(1);
                    case SOUTH:
                        return BlockVoxelShapes.t_FlangeShapes.get(2);
                    case WEST:
                        return BlockVoxelShapes.t_FlangeShapes.get(3);
                }
            case 2:
                switch(state.get(WaterloggedHorizontalDirectionalShape.DIRECTION)) {
                    default:
                    case NORTH:
                        return BlockVoxelShapes.t_FlangeShapes.get(8);
                    case EAST:
                        return BlockVoxelShapes.t_FlangeShapes.get(9);
                    case SOUTH:
                        return BlockVoxelShapes.t_FlangeShapes.get(10);
                    case WEST:
                        return BlockVoxelShapes.t_FlangeShapes.get(11);
                }
            case 3:
                switch(state.get(WaterloggedHorizontalDirectionalShape.DIRECTION)) {
                    default:
                    case NORTH:
                        return BlockVoxelShapes.t_FlangeShapes.get(4);
                    case EAST:
                        return BlockVoxelShapes.t_FlangeShapes.get(5);
                    case SOUTH:
                        return BlockVoxelShapes.t_FlangeShapes.get(6);
                    case WEST:
                        return BlockVoxelShapes.t_FlangeShapes.get(7);
                }
            case 4:
                switch(state.get(WaterloggedHorizontalDirectionalShape.DIRECTION)) {
                    default:
                    case NORTH:
                        return BlockVoxelShapes.t_FlangeShapes.get(12);
                    case EAST:
                        return BlockVoxelShapes.t_FlangeShapes.get(13);
                    case SOUTH:
                        return BlockVoxelShapes.t_FlangeShapes.get(14);
                    case WEST:
                        return BlockVoxelShapes.t_FlangeShapes.get(15);
                }
        }
    }
}
