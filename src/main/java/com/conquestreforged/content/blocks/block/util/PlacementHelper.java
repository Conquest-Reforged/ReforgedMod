package com.conquestreforged.content.blocks.block.util;

import net.minecraft.item.AutomaticItemPlacementContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PlacementHelper {

    /**
     * Helper method for safely calling BlockItemUseContext.replacingClickedOnBlock() which
     * may StackOverflow if it's an instanceof DirectionalPlaceContext.
     */
    public static boolean replacingClickedOnBlock(ItemPlacementContext context) {
        // filter out DirectionPlaceContexts as they are not caused by Players
        if (context instanceof AutomaticItemPlacementContext) {
            return false;
        }
        return context.canReplaceExisting();
    }

    /**
     * Helper to determine whether an IBlockReader is being used during world gen or
     * during game-play.
     */
    public static boolean isDuringWorldGen(BlockView reader) {
        return !(reader instanceof World);
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
    public static Direction getHitVecHorizontalAxisDirection(Direction facing, BlockPos pos, ItemPlacementContext context) {
        switch (facing) {
            case NORTH: {
                return (!(context.getHitPos().x - (double) pos.getX() > 0.5D)) ? facing.rotateYClockwise() : facing;
            }
            case SOUTH: {
                return (!(context.getHitPos().x - (double) pos.getX() < 0.5D)) ? facing.rotateYClockwise() : facing;
            }
            case EAST: {
                return (!(context.getHitPos().z - (double) pos.getZ() > 0.5D)) ? facing.rotateYClockwise() : facing;
            }
            default: {
                return (!(context.getHitPos().z - (double) pos.getZ() < 0.5D)) ? facing.rotateYClockwise() : facing;
            }
        }
    }
}
