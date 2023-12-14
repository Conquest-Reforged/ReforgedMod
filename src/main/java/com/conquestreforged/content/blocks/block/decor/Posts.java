package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.block.windows.WindowSmallHalf;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

@Assets(
        state = @State(name = "%s_posts", template = "parent_posts"),
        item = @Model(name = "item/%s_posts", parent = "block/%s_posts_single", template = "item/parent_posts"),
        block = {
                @Model(name = "block/%s_posts_left", template = "block/parent_posts_left"),
                @Model(name = "block/%s_posts_right", template = "block/parent_posts_right"),
                @Model(name = "block/%s_posts_single", template = "block/parent_posts_single")
        }
)
public class Posts extends HorizontalDirectionalShape {

    public static final IntProperty TOGGLE = IntProperty.of("toggle", 1, 3);

    public Posts(Props props) {
        super(props.toSettings().noCollision());
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return super.getPlacementState(context).with(TOGGLE, 1);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else {
            level.setBlockState(blockPos, state.cycle(TOGGLE), 3);
            return ActionResult.SUCCESS;
        }
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(DIRECTION)) {
            case NORTH:
            default:
                return WindowSmallHalf.NORTH_SHAPE;
            case SOUTH:
                return WindowSmallHalf.SOUTH_SHAPE;
            case WEST:
                return WindowSmallHalf.WEST_SHAPE;
            case EAST:
                return WindowSmallHalf.EAST_SHAPE;
        }
    }
}
