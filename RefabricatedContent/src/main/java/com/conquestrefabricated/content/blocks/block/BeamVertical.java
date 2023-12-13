package com.conquestrefabricated.content.blocks.block;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.block.base.HorizontalDirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
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
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

@Assets(
        state = @State(name = "%s_vertical", template = "parent_beam"),
        item = @Model(name = "item/%s_vertical", parent = "block/%s_beam_support", template = "item/parent_beam_vertical"),
        block = {
                @Model(name = "block/%s_beam_vertical", template = "block/parent_beam_vertical"),
                @Model(name = "block/%s_beam_support", template = "block/parent_beam_support"),
                @Model(name = "block/%s_beam_support_1", template = "block/parent_beam_support_1"),
                @Model(name = "block/%s_beam_support_2", template = "block/parent_beam_support_2"),
                @Model(name = "block/%s_beam_support_3", template = "block/parent_beam_support_3"),
                @Model(name = "block/%s_beam_support_bottom", template = "block/parent_beam_support_bottom")
        }
)
public class BeamVertical extends HorizontalDirectionalShape {

    public static final IntProperty TOGGLE = IntProperty.of("toggle", 1, 6);
    public static final EnumProperty<BlockHalf> TYPE_UPDOWN = EnumProperty.of("type", BlockHalf.class);

    private static final VoxelShape SHAPE_WEST_OFF = Block.createCuboidShape(0.0D, 0.0D, 5.0D, 4.0D, 16.0D, 11.0D);
    private static final VoxelShape SHAPE_EAST_OFF = Block.createCuboidShape(12.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
    private static final VoxelShape SHAPE_NORTH_OFF = Block.createCuboidShape(5.0D, 0.0D, 12.0D, 11.0D, 16.0D, 16.0D);
    private static final VoxelShape SHAPE_SOUTH_OFF = Block.createCuboidShape(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 4.0D);
    private static final VoxelShape SHAPE_WEST_ON = Block.createCuboidShape(0.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
    private static final VoxelShape SHAPE_EAST_ON = Block.createCuboidShape(0.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
    private static final VoxelShape SHAPE_SOUTH_ON = Block.createCuboidShape(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 16.0D);
    private static final VoxelShape SHAPE_NORTH_ON = Block.createCuboidShape(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 16.0D);

    public BeamVertical(Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.get(TOGGLE) == 1) {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return SHAPE_NORTH_OFF;
                case SOUTH:
                    return SHAPE_SOUTH_OFF;
                case WEST:
                    return SHAPE_EAST_OFF;
                case EAST:
                    return SHAPE_WEST_OFF;
            }
        } else {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return SHAPE_NORTH_ON;
                case SOUTH:
                    return SHAPE_SOUTH_ON;
                case WEST:
                    return SHAPE_EAST_ON;
                case EAST:
                    return SHAPE_WEST_ON;
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return super.getPlacementState(context).with(TOGGLE,1);
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else {
            level.setBlockState(blockPos, state.cycle(TOGGLE), 3);
            if ((state.getMaterial() == Material.METAL)) {
                level.syncWorldEvent(player, (state.get(TOGGLE) <= 4) ? 1037 : 1036, blockPos, 0);
            } else {
                level.syncWorldEvent(player, state.get(TOGGLE) == 5 ? 1008 : 1014, blockPos, 0);
            }
            return ActionResult.SUCCESS;
        }
    }
}
