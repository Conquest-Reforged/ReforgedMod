package com.conquestreforged.content.blocks.block.decor;

import com.conquestreforged.content.blocks.tileentity.AnimalTileEntity;
import com.conquestreforged.content.blocks.tileentity.TileEntityTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AnimalBird extends BlockWithEntity {

    public static final IntProperty TOGGLE = IntProperty.of("toggle", 1, 4);
    public static final BooleanProperty FLYING = BooleanProperty.of("flying");

    public AnimalBird(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(TOGGLE, 1).with(FLYING, Boolean.FALSE));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Random rand = new Random();
        int toggleState = rand.nextInt(4) + 1;
        return this.getDefaultState().with(TOGGLE, toggleState);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else {
            world.setBlockState(pos, state.cycle(FLYING), 3);
            return ActionResult.SUCCESS;
        }
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView reader, BlockPos pos) {
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Environment(EnvType.CLIENT)
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView blockReader, BlockPos pos) {
        return 1.0F;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE, FLYING);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos blockPos, BlockState state) {
        return new AnimalTileEntity(blockPos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState p_153213_, BlockEntityType<T> blockEntityType) {
        if (level.isClient) {
            return checkType(blockEntityType, TileEntityTypes.ANIMAL, AnimalTileEntity::particleTick);
        }
        return super.getTicker(level, p_153213_, blockEntityType);
    }
}
