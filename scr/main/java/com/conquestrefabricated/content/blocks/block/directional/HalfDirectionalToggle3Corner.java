package com.conquestrefabricated.content.blocks.block.directional;

import net.minecraft.block.BlockState;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.math.Direction;

public class HalfDirectionalToggle3Corner extends HalfDirectionalToggle3 {

    public HalfDirectionalToggle3Corner(Settings properties) {
        super(properties);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch(state.get(DIRECTION)) {
                    case NORTH:
                        return state.with(DIRECTION, Direction.EAST);
                    case EAST:
                        return state.with(DIRECTION, Direction.NORTH);
                    case SOUTH:
                        return state.with(DIRECTION, Direction.WEST);
                    case WEST:
                        return state.with(DIRECTION, Direction.SOUTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch(state.get(DIRECTION)) {
                    case NORTH:
                        return state.with(DIRECTION, Direction.WEST);
                    case EAST:
                        return state.with(DIRECTION, Direction.SOUTH);
                    case SOUTH:
                        return state.with(DIRECTION, Direction.EAST);
                    case WEST:
                        return state.with(DIRECTION, Direction.NORTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
        }
        return super.mirror(state, mirrorIn);
    }
}