package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.BlockState;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.math.Direction;

public class HorizontalDirectionalToggle5Corner extends HorizontalDirectionalToggle5 {

    public HorizontalDirectionalToggle5Corner(Props props) {
        super(props);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch(state.get(HorizontalDirectionalShape.DIRECTION)) {
                    case NORTH:
                        return state.with(HorizontalDirectionalShape.DIRECTION, Direction.EAST);
                    case EAST:
                        return state.with(HorizontalDirectionalShape.DIRECTION, Direction.NORTH);
                    case SOUTH:
                        return state.with(HorizontalDirectionalShape.DIRECTION, Direction.WEST);
                    case WEST:
                        return state.with(HorizontalDirectionalShape.DIRECTION, Direction.SOUTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch(state.get(HorizontalDirectionalShape.DIRECTION)) {
                    case NORTH:
                        return state.with(HorizontalDirectionalShape.DIRECTION, Direction.WEST);
                    case EAST:
                        return state.with(HorizontalDirectionalShape.DIRECTION, Direction.SOUTH);
                    case SOUTH:
                        return state.with(HorizontalDirectionalShape.DIRECTION, Direction.EAST);
                    case WEST:
                        return state.with(HorizontalDirectionalShape.DIRECTION, Direction.NORTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
        }
        return super.mirror(state, mirrorIn);
    }
}
