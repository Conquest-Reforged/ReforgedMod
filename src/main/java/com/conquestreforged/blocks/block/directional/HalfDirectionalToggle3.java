package com.conquestreforged.blocks.block.directional;

import com.conquestreforged.core.block.base.HorizontalDirectionalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HalfDirectionalToggle3 extends HorizontalDirectionalShape {

    public static final IntegerProperty TOGGLE = IntegerProperty.create("toggle", 1, 3);
    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);
    private static final VoxelShape BOTTOM_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape TOP_SHAPE = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public HalfDirectionalToggle3(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE_UPDOWN, Half.BOTTOM).setValue(TOGGLE, 1));
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return getShape(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facingHorizontal = context.getHorizontalDirection().getOpposite();
        BlockState state2 = this.defaultBlockState().setValue(DIRECTION, facingHorizontal).setValue(TYPE_UPDOWN, Half.BOTTOM);
        Direction facing = context.getClickedFace();
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getClickLocation().y - (double) context.getClickedPos().getY() > 0.5D)) ? state2 : state2.setValue(TYPE_UPDOWN, Half.TOP);
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(TYPE_UPDOWN).add(TOGGLE);
    }

    @Override
    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TYPE_UPDOWN) == Half.BOTTOM) {
            return BOTTOM_SHAPE;
        } else {
            return TOP_SHAPE;
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            level.setBlock(blockPos, state.cycle(TOGGLE), 3);
            return InteractionResult.SUCCESS;
        }
    }
}