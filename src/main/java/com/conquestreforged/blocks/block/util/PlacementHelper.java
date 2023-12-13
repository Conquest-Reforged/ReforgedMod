package com.conquestreforged.blocks.block.util;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.DirectionalPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;

public class PlacementHelper {

    /**
     * Helper method for safely calling BlockItemUseContext.replacingClickedOnBlock() which
     * may StackOverflow if it's an instanceof DirectionalPlaceContext.
     */
    public static boolean replacingClickedOnBlock(BlockPlaceContext context) {
        // filter out DirectionPlaceContexts as they are not caused by Players
        if (context instanceof DirectionalPlaceContext) {
            return false;
        }
        return context.replacingClickedOnBlock();
    }

    /**
     * Helper to determine whether an IBlockReader is being used during world gen or
     * during game-play.
     */
    public static boolean isDuringWorldGen(BlockGetter reader) {
        return !(reader instanceof Level);
    }

    /**
     * Helper to determine what GameMode has been set in the world, if the provided
     * IBlockReader happens to be an IWorld instance.
     */
    //public static boolean isGameMode(IBlockReader reader, GameType mode) {
    //    if (reader instanceof IWorld) {
    //        return ((IWorld) reader).getLevelData().getGameType() == mode;
    //    }
    //    return false;
    //}

    /**
     * Helper to determine which Direction BlockState should be returned depending on
     * which half of a block's side the player is interacting with.
     * Similar to how the Slab does this on the Y-axis.
     */
    public static Direction getHitVecHorizontalAxisDirection(Direction facing, BlockPos pos, BlockPlaceContext context) {
        switch (facing) {
            case NORTH: {
                return (!(context.getClickLocation().x - (double) pos.getX() > 0.5D)) ? facing.getClockWise() : facing;
            }
            case SOUTH: {
                return (!(context.getClickLocation().x - (double) pos.getX() < 0.5D)) ? facing.getClockWise() : facing;
            }
            case EAST: {
                return (!(context.getClickLocation().z - (double) pos.getZ() > 0.5D)) ? facing.getClockWise() : facing;
            }
            default: {
                return (!(context.getClickLocation().z - (double) pos.getZ() < 0.5D)) ? facing.getClockWise() : facing;
            }
        }
    }
}
