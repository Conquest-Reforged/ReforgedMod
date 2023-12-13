package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.HorizontalDirectionalShape;
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
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;

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

    public static final IntProperty ACTIVATED = IntProperty.of("activated", 1, 4);
    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);

    private static final VoxelShape HORIZONTAL_BEAM_NE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 12, 0, 11, 16, 11), Block.createCuboidShape(11, 12, 5, 16, 16, 11), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_ES = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 12, 5, 16, 16, 11), Block.createCuboidShape(5, 12, 11, 11, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_SW = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 12, 5, 11, 16, 16), Block.createCuboidShape(0, 12, 5, 5, 16, 11), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_WN = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 12, 5, 11, 16, 11), Block.createCuboidShape(5, 12, 0, 11, 16, 5), BooleanBiFunction.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NS = Block.createCuboidShape(5, 12, 0, 11, 16, 16);
    private static final VoxelShape HORIZONTAL_BEAM_EW = Block.createCuboidShape(0, 12, 5, 16, 16, 11);

    private static final VoxelShape HORIZONTAL_BEAM_NSE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(11, 12, 5, 16, 16, 11), Block.createCuboidShape(5, 12, 0, 11, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_ESW = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 12, 11, 11, 16, 16), Block.createCuboidShape(0, 12, 5, 16, 16, 11), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_SWN = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 12, 5, 5, 16, 11), Block.createCuboidShape(5, 12, 0, 11, 16, 16), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_WNS = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 12, 0, 11, 16, 5), Block.createCuboidShape(0, 12, 5, 16, 16, 11), BooleanBiFunction.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NSEW = VoxelShapes.combineAndSimplify(HORIZONTAL_BEAM_NS, HORIZONTAL_BEAM_EW, BooleanBiFunction.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NE_BOTTOM = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 0, 0, 11, 4, 11), Block.createCuboidShape(11, 0, 5, 16, 4, 11), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_ES_BOTTOM = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 0, 5, 16, 4, 11), Block.createCuboidShape(5, 0, 11, 11, 4, 16), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_SW_BOTTOM = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 0, 5, 11, 4, 16), Block.createCuboidShape(0, 0, 5, 5, 4, 11), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_WN_BOTTOM = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 5, 11, 4, 11), Block.createCuboidShape(5, 0, 0, 11, 4, 5), BooleanBiFunction.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NS_BOTTOM = Block.createCuboidShape(5, 0, 0, 11, 4, 16);
    private static final VoxelShape HORIZONTAL_BEAM_EW_BOTTOM = Block.createCuboidShape(0, 0, 5, 16, 4, 11);

    private static final VoxelShape HORIZONTAL_BEAM_NSE_BOTTOM = VoxelShapes.combineAndSimplify(Block.createCuboidShape(11, 0, 5, 16, 4, 11), Block.createCuboidShape(5, 0, 0, 11, 4, 16), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_ESW_BOTTOM = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 0, 11, 11, 4, 16), Block.createCuboidShape(0, 0, 5, 16, 4, 11), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_SWN_BOTTOM = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 5, 5, 4, 11), Block.createCuboidShape(5, 0, 0, 11, 4, 16), BooleanBiFunction.OR);
    private static final VoxelShape HORIZONTAL_BEAM_WNS_BOTTOM = VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 0, 0, 11, 4, 5), Block.createCuboidShape(0, 0, 5, 16, 4, 11), BooleanBiFunction.OR);

    private static final VoxelShape HORIZONTAL_BEAM_NSEW_BOTTOM = VoxelShapes.combineAndSimplify(HORIZONTAL_BEAM_NS_BOTTOM, HORIZONTAL_BEAM_EW_BOTTOM, BooleanBiFunction.OR);


    public BeamHorizontal(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        switch (state.get(ACTIVATED)) {
            case 1:
                if (state.get(DIRECTION) == Direction.NORTH || state.get(DIRECTION) == Direction.SOUTH) {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_NS: HORIZONTAL_BEAM_NS_BOTTOM;
                } else {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_EW: HORIZONTAL_BEAM_EW_BOTTOM;
                }
            case 2:
                if (state.get(DIRECTION) == Direction.NORTH) {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_NE: HORIZONTAL_BEAM_NE_BOTTOM;
                } else if (state.get(DIRECTION) == Direction.EAST) {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_ES: HORIZONTAL_BEAM_ES_BOTTOM;
                } else if (state.get(DIRECTION) == Direction.SOUTH) {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_SW: HORIZONTAL_BEAM_SW_BOTTOM;
                } else {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_WN: HORIZONTAL_BEAM_WN_BOTTOM;
                }
            case 3:
                if (state.get(DIRECTION) == Direction.NORTH) {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_NSE: HORIZONTAL_BEAM_NSE_BOTTOM;
                } else if (state.get(DIRECTION) == Direction.EAST) {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_ESW: HORIZONTAL_BEAM_ESW_BOTTOM;
                } else if (state.get(DIRECTION) == Direction.SOUTH) {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_SWN: HORIZONTAL_BEAM_SWN_BOTTOM;
                } else {
                    return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_WNS: HORIZONTAL_BEAM_WNS_BOTTOM;
                }
            default:
                return state.get(TYPE_UPDOWN) == BlockHalf.TOP ? HORIZONTAL_BEAM_NSEW: HORIZONTAL_BEAM_NSEW_BOTTOM;
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED).add(TYPE_UPDOWN);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction facing = context.getPlayerFacing().getOpposite();
        BlockPos pos = context.getBlockPos();

        BlockHalf topBottom = BlockHalf.TOP;
        if (facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitPos().y - (double)pos.getY() > 0.5D))) {
            topBottom = BlockHalf.BOTTOM;
        }

        return super.getPlacementState(context)
                .with(DIRECTION, facing)
                .with(ACTIVATED, 1)
                .with(TYPE_UPDOWN, topBottom);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else {
            level.setBlockState(blockPos, state.cycle(ACTIVATED), 3);
            return ActionResult.SUCCESS;
        }
    }
}
