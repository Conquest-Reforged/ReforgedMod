package com.conquestrefabricated.content.blocks.block.lights;

import com.conquestrefabricated.content.blocks.block.decor.HorizontalDirectionalWaterloggedToggle5;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.block.builder.Props;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Render(RenderLayer.CUTOUT)
public class LightSourceToggle5 extends HorizontalDirectionalWaterloggedToggle5 {

    public static final IntProperty LIGHT_0_3 = IntProperty.of("light", 0, 3);

    public LightSourceToggle5(Props properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(LIGHT_0_3, 0).with(WATERLOGGED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.FAIL;
        } else {
            if (player.getStackInHand(hand).getItem() == Items.FLINT_AND_STEEL) {
                level.setBlockState(blockPos, state.with(LIGHT_0_3, 3),3);
            } else {
                level.setBlockState(blockPos, state.cycle(TOGGLE), 3);
            }
            return ActionResult.SUCCESS;
        }
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE).add(LIGHT_0_3);
    }
}
