package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.block.windows.WindowSmallHalf;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

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

    public static final IntegerProperty TOGGLE = IntegerProperty.create("toggle", 1, 3);

    public Posts(Props props) {
        super(props.toProperties().noCollission());
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(TOGGLE, 1);
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            level.setBlock(blockPos, state.cycle(TOGGLE), 3);
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(DIRECTION)) {
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
