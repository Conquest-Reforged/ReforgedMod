package com.conquestrefabricated.content.blocks.block.decor;

import com.conquestrefabricated.content.blocks.block.directional.HorizontalDirectional;
import com.conquestrefabricated.core.block.builder.Props;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;


public class HorizontalDirectionalToggle2 extends HorizontalDirectional {

    public static final IntProperty TOGGLE = IntProperty.of("toggle", 1, 2);

    public HorizontalDirectionalToggle2(Props props) {
        super(props);
    }

    @Override
    protected void addProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TOGGLE);
    }

    @Override
    @NotNull
    public BlockState getPlacementState(ItemPlacementContext context) {
        return super.getPlacementState(context).with(TOGGLE, 1);
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
}
