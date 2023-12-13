package com.conquestreforged.blocks.block.decor;

import com.conquestreforged.blocks.tileentity.AnimalTileEntity;
import com.conquestreforged.blocks.tileentity.TileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AnimalBird extends BaseEntityBlock {

    public static final IntegerProperty TOGGLE = IntegerProperty.create("toggle", 1, 4);
    public static final BooleanProperty FLYING = BooleanProperty.create("flying");

    public AnimalBird(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TOGGLE, 1).setValue(FLYING, Boolean.FALSE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Random rand = new Random();
        int toggleState = rand.nextInt(4) + 1;
        return this.defaultBlockState().setValue(TOGGLE, toggleState);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            world.setBlock(pos, state.cycle(FLYING), 3);
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @OnlyIn(Dist.CLIENT)
    public float getShadeBrightness(BlockState state, BlockGetter blockReader, BlockPos pos) {
        return 1.0F;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE, FLYING);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state) {
        return new AnimalTileEntity(blockPos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153213_, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide) {
            return createTickerHelper(blockEntityType, TileEntityTypes.ANIMAL, AnimalTileEntity::particleTick);
        }
        return super.getTicker(level, p_153213_, blockEntityType);
    }
}
