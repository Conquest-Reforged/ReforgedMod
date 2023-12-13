package com.conquestreforged.blocks.block;

import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

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

    public static final IntegerProperty TOGGLE = IntegerProperty.create("toggle", 1, 6);
    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);

    private static final VoxelShape SHAPE_WEST_OFF = Block.box(0.0D, 0.0D, 5.0D, 4.0D, 16.0D, 11.0D);
    private static final VoxelShape SHAPE_EAST_OFF = Block.box(12.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
    private static final VoxelShape SHAPE_NORTH_OFF = Block.box(5.0D, 0.0D, 12.0D, 11.0D, 16.0D, 16.0D);
    private static final VoxelShape SHAPE_SOUTH_OFF = Block.box(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 4.0D);
    private static final VoxelShape SHAPE_WEST_ON = Block.box(0.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
    private static final VoxelShape SHAPE_EAST_ON = Block.box(0.0D, 0.0D, 5.0D, 16.0D, 16.0D, 11.0D);
    private static final VoxelShape SHAPE_SOUTH_ON = Block.box(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 16.0D);
    private static final VoxelShape SHAPE_NORTH_ON = Block.box(5.0D, 0.0D, 0.0D, 11.0D, 16.0D, 16.0D);

    public BeamVertical(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TOGGLE) == 1) {
            switch (state.getValue(DIRECTION)) {
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
            switch (state.getValue(DIRECTION)) {
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
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(TOGGLE,1);
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            level.setBlock(blockPos, state.cycle(TOGGLE), 3);
            if ((state.getMaterial() == Material.METAL)) {
                level.levelEvent(player, (state.getValue(TOGGLE) <= 4) ? 1037 : 1036, blockPos, 0);
            } else {
                level.levelEvent(player, state.getValue(TOGGLE) == 5 ? 1008 : 1014, blockPos, 0);
            }
            return InteractionResult.SUCCESS;
        }
    }
}
