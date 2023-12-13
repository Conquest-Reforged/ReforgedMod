package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockState;

public class HorizontalDirectionalToggle5Corner extends HorizontalDirectionalToggle5 {

    public HorizontalDirectionalToggle5Corner(Props props) {
        super(props);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch(state.getValue(DIRECTION)) {
                    case NORTH:
                        return state.setValue(DIRECTION, Direction.EAST);
                    case EAST:
                        return state.setValue(DIRECTION, Direction.NORTH);
                    case SOUTH:
                        return state.setValue(DIRECTION, Direction.WEST);
                    case WEST:
                        return state.setValue(DIRECTION, Direction.SOUTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch(state.getValue(DIRECTION)) {
                    case NORTH:
                        return state.setValue(DIRECTION, Direction.WEST);
                    case EAST:
                        return state.setValue(DIRECTION, Direction.SOUTH);
                    case SOUTH:
                        return state.setValue(DIRECTION, Direction.EAST);
                    case WEST:
                        return state.setValue(DIRECTION, Direction.NORTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
        }
        return super.mirror(state, mirrorIn);
    }
}
