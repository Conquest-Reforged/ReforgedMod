package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s_horizontal", template = "parent_beam_horizontal"),
        item = @Model(name = "item/%s_horizontal", parent = "block/%s_beam_horizontal_ns", template = "item/parent_beam_horizontal"),
        block = {
                @Model(name = "block/%s_beam_horizontal_ne", template = "block/parent_beam_horizontal_ne"),
                @Model(name = "block/%s_beam_horizontal_ns", template = "block/parent_beam_horizontal_ns"),
                @Model(name = "block/%s_beam_horizontal_nse", template = "block/parent_beam_horizontal_nse"),
                @Model(name = "block/%s_beam_horizontal_nsew", template = "block/parent_beam_horizontal_nsew"),
                @Model(name = "block/%s_beam_horizontal_ne_bottom", template = "block/parent_beam_horizontal_ne_bottom"),
                @Model(name = "block/%s_beam_horizontal_ns_bottom", template = "block/parent_beam_horizontal_ns_bottom"),
                @Model(name = "block/%s_beam_horizontal_nse_bottom", template = "block/parent_beam_horizontal_nse_bottom"),
                @Model(name = "block/%s_beam_horizontal_nsew_bottom", template = "block/parent_beam_horizontal_nsew_bottom")
        }
)
public class BeamHorizontal extends HorizontalDirectionalShape {

    public static final IntegerProperty ACTIVATED = IntegerProperty.create("activated", 1, 4);
    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);

    private static final VoxelShape HORIZONTAL_BEAM_NE = Shapes.join(Block.box(5, 12, 0, 11, 16, 11), Block.box(11, 12, 5, 16, 16, 11), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_ES = Shapes.join(Block.box(5, 12, 5, 16, 16, 11), Block.box(5, 12, 11, 11, 16, 16), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_SW = Shapes.join(Block.box(5, 12, 5, 11, 16, 16), Block.box(0, 12, 5, 5, 16, 11), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_WN = Shapes.join(Block.box(0, 12, 5, 11, 16, 11), Block.box(5, 12, 0, 11, 16, 5), BooleanOp.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NS = Block.box(5, 12, 0, 11, 16, 16);
    private static final VoxelShape HORIZONTAL_BEAM_EW = Block.box(0, 12, 5, 16, 16, 11);

    private static final VoxelShape HORIZONTAL_BEAM_NSE = Shapes.join(Block.box(11, 12, 5, 16, 16, 11), Block.box(5, 12, 0, 11, 16, 16), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_ESW = Shapes.join(Block.box(5, 12, 11, 11, 16, 16), Block.box(0, 12, 5, 16, 16, 11), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_SWN = Shapes.join(Block.box(0, 12, 5, 5, 16, 11), Block.box(5, 12, 0, 11, 16, 16), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_WNS = Shapes.join(Block.box(5, 12, 0, 11, 16, 5), Block.box(0, 12, 5, 16, 16, 11), BooleanOp.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NSEW = Shapes.join(HORIZONTAL_BEAM_NS, HORIZONTAL_BEAM_EW, BooleanOp.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NE_BOTTOM = Shapes.join(Block.box(5, 0, 0, 11, 4, 11), Block.box(11, 0, 5, 16, 4, 11), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_ES_BOTTOM = Shapes.join(Block.box(5, 0, 5, 16, 4, 11), Block.box(5, 0, 11, 11, 4, 16), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_SW_BOTTOM = Shapes.join(Block.box(5, 0, 5, 11, 4, 16), Block.box(0, 0, 5, 5, 4, 11), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_WN_BOTTOM = Shapes.join(Block.box(0, 0, 5, 11, 4, 11), Block.box(5, 0, 0, 11, 4, 5), BooleanOp.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NS_BOTTOM = Block.box(5, 0, 0, 11, 4, 16);
    private static final VoxelShape HORIZONTAL_BEAM_EW_BOTTOM = Block.box(0, 0, 5, 16, 4, 11);

    private static final VoxelShape HORIZONTAL_BEAM_NSE_BOTTOM = Shapes.join(Block.box(11, 0, 5, 16, 4, 11), Block.box(5, 0, 0, 11, 4, 16), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_ESW_BOTTOM = Shapes.join(Block.box(5, 0, 11, 11, 4, 16), Block.box(0, 0, 5, 16, 4, 11), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_SWN_BOTTOM = Shapes.join(Block.box(0, 0, 5, 5, 4, 11), Block.box(5, 0, 0, 11, 4, 16), BooleanOp.OR);
    private static final VoxelShape HORIZONTAL_BEAM_WNS_BOTTOM = Shapes.join(Block.box(5, 0, 0, 11, 4, 5), Block.box(0, 0, 5, 16, 4, 11), BooleanOp.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NSEW_BOTTOM = Shapes.join(HORIZONTAL_BEAM_NS_BOTTOM, HORIZONTAL_BEAM_EW_BOTTOM, BooleanOp.OR);


    public BeamHorizontal(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.getValue(ACTIVATED)) {
            case 1:
                if (state.getValue(DIRECTION) == Direction.NORTH || state.getValue(DIRECTION) == Direction.SOUTH) {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_NS: HORIZONTAL_BEAM_NS_BOTTOM;
                } else {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_EW: HORIZONTAL_BEAM_EW_BOTTOM;
                }
            case 2:
                if (state.getValue(DIRECTION) == Direction.NORTH) {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_NE: HORIZONTAL_BEAM_NE_BOTTOM;
                } else if (state.getValue(DIRECTION) == Direction.EAST) {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_ES: HORIZONTAL_BEAM_ES_BOTTOM;
                } else if (state.getValue(DIRECTION) == Direction.SOUTH) {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_SW: HORIZONTAL_BEAM_SW_BOTTOM;
                } else {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_WN: HORIZONTAL_BEAM_WN_BOTTOM;
                }
            case 3:
                if (state.getValue(DIRECTION) == Direction.NORTH) {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_NSE: HORIZONTAL_BEAM_NSE_BOTTOM;
                } else if (state.getValue(DIRECTION) == Direction.EAST) {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_ESW: HORIZONTAL_BEAM_ESW_BOTTOM;
                } else if (state.getValue(DIRECTION) == Direction.SOUTH) {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_SWN: HORIZONTAL_BEAM_SWN_BOTTOM;
                } else {
                    return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_WNS: HORIZONTAL_BEAM_WNS_BOTTOM;
                }
            default:
                return state.getValue(TYPE_UPDOWN) == Half.TOP ? HORIZONTAL_BEAM_NSEW: HORIZONTAL_BEAM_NSEW_BOTTOM;
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED).add(TYPE_UPDOWN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();
        BlockPos pos = context.getClickedPos();

        Half topBottom = Half.TOP;
        if (facing != Direction.DOWN && (facing == Direction.UP || !(context.getClickLocation().y - (double)pos.getY() > 0.5D))) {
            topBottom = Half.BOTTOM;
        }

        return super.getStateForPlacement(context)
                .setValue(DIRECTION, facing)
                .setValue(ACTIVATED, 1)
                .setValue(TYPE_UPDOWN, topBottom);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            level.setBlock(blockPos, state.cycle(ACTIVATED), 3);
            return InteractionResult.SUCCESS;
        }
    }
}
