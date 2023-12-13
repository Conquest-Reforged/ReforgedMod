package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.content.blocks.block.SlabQuarterNoLayers;
import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.HorizontalDirectionalShape;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

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

    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);
    public static final IntProperty TOGGLE = IntProperty.of("toggle", 1, 4);

    public Lintels(Props props) {
        super(props.toSettings().noCollision());
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE).add(TYPE_UPDOWN);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction facing = context.getPlayerFacing().getOpposite();
        BlockPos pos = context.getBlockPos();

        BlockHalf topBottom = BlockHalf.TOP;
        if (facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double)pos.getY() > 0.5D))) {
            topBottom = BlockHalf.BOTTOM;
        }

        return super.getPlacementState(context).with(TOGGLE, 1).with(TYPE_UPDOWN, topBottom);
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
        if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            switch (state.get(DIRECTION)) {
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
            switch (state.get(DIRECTION)) {
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
