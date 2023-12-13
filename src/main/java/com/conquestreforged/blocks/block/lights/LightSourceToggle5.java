package com.conquestreforged.blocks.block.lights;

import com.conquestreforged.blocks.block.decor.HorizontalDirectionalWaterloggedToggle5;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

@Render(RenderLayer.CUTOUT)
public class LightSourceToggle5 extends HorizontalDirectionalWaterloggedToggle5 {

    public static final IntegerProperty LIGHT_0_3 = IntegerProperty.create("light", 0, 3);

    public LightSourceToggle5(Props properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIGHT_0_3, 0).setValue(WATERLOGGED, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().mayBuild) {
            return InteractionResult.FAIL;
        } else {
            if (player.getItemInHand(hand).getItem() == Items.FLINT_AND_STEEL) {
                level.setBlock(blockPos, state.setValue(LIGHT_0_3, 3),3);
            } else {
                level.setBlock(blockPos, state.cycle(TOGGLE), 3);
            }
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE).add(LIGHT_0_3);
    }
}
