package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.block.SlabQuarterNoLayers;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
import com.conquestreforged.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_lintel", template = "parent_lintel"),
        item = @Model(name = "item/%s_lintel", parent = "block/%s_lintel_single_top", template = "item/parent_lintel"),
        block = {
                @Model(name = "block/%s_lintel_left_bottom", template = "block/parent_lintel_left_bottom"),
                @Model(name = "block/%s_lintel_right_bottom", template = "block/parent_lintel_right_bottom"),
                @Model(name = "block/%s_lintel_middle_bottom", template = "block/parent_lintel_middle_bottom"),
                @Model(name = "block/%s_lintel_single_bottom", template = "block/parent_lintel_single_bottom"),
                @Model(name = "block/%s_lintel_left_top", template = "block/parent_lintel_left_top"),
                @Model(name = "block/%s_lintel_right_top", template = "block/parent_lintel_right_top"),
                @Model(name = "block/%s_lintel_middle_top", template = "block/parent_lintel_middle_top"),
                @Model(name = "block/%s_lintel_single_top", template = "block/parent_lintel_single_top")
        }
)
public class Lintels extends HorizontalDirectionalShape {

    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);
    public static final IntegerProperty TOGGLE = IntegerProperty.create("toggle", 1, 4);

    public Lintels(Props props) {
        super(props.toProperties().noCollission());
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE).add(TYPE_UPDOWN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();
        BlockPos pos = context.getClickedPos();

        Half topBottom = Half.TOP;
        if (facing != Direction.DOWN && (facing == Direction.UP || !(context.getClickLocation().y - (double)pos.getY() > 0.5D))) {
            topBottom = Half.BOTTOM;
        }

        return super.getStateForPlacement(context).setValue(TOGGLE, 1).setValue(TYPE_UPDOWN, topBottom);
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
        if (state.getValue(TYPE_UPDOWN) == Half.BOTTOM) {
            switch (state.getValue(DIRECTION)) {
                case NORTH:
                default:
                    return SlabQuarterNoLayers.BOTTOM_NORTH_SHAPE;
                case SOUTH:
                    return SlabQuarterNoLayers.BOTTOM_SOUTH_SHAPE;
                case WEST:
                    return SlabQuarterNoLayers.BOTTOM_WEST_SHAPE;
                case EAST:
                    return SlabQuarterNoLayers.BOTTOM_EAST_SHAPE;
            }
        } else {
            switch (state.getValue(DIRECTION)) {
                case NORTH:
                default:
                    return SlabQuarterNoLayers.TOP_NORTH_SHAPE;
                case SOUTH:
                    return SlabQuarterNoLayers.TOP_SOUTH_SHAPE;
                case WEST:
                    return SlabQuarterNoLayers.TOP_WEST_SHAPE;
                case EAST:
                    return SlabQuarterNoLayers.TOP_EAST_SHAPE;
            }
        }
    }
}
