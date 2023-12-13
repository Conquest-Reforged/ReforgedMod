package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.blocks.block.Layer;
import com.conquestreforged.blocks.block.Slab;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Random;

@Assets(
        state = @State(name = "%s", template = "parent_plant_dense_stackable"),
        item = @Model(name = "item/%s", parent = "block/%s_pane_ns", template = "item/parent_round_arch"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_plant_dense_model_1_a", template = "block/parent_plant_dense_model_1_a"),
                @Model(name = "block/%s_plant_dense_model_1_b", template = "block/parent_plant_dense_model_1_b"),
                @Model(name = "block/%s_plant_dense_model_1_c", template = "block/parent_plant_dense_model_1_c"),
                @Model(name = "block/%s_plant_dense_model_2_a", template = "block/parent_plant_dense_model_2_a"),
                @Model(name = "block/%s_plant_dense_model_2_b", template = "block/parent_plant_dense_model_2_b"),
                @Model(name = "block/%s_plant_dense_model_2_c", template = "block/parent_plant_dense_model_2_c"),
                @Model(name = "block/%s_plant_dense_model_3_a", template = "block/parent_plant_dense_model_3_a"),
                @Model(name = "block/%s_plant_dense_model_3_b", template = "block/parent_plant_dense_model_3_b"),
                @Model(name = "block/%s_plant_dense_model_3_c", template = "block/parent_plant_dense_model_3_c"),
                @Model(name = "block/%s_plant_dense_model_4_a", template = "block/parent_plant_dense_model_4_a"),
                @Model(name = "block/%s_plant_dense_model_4_b", template = "block/parent_plant_dense_model_4_b"),
                @Model(name = "block/%s_plant_dense_model_4_c", template = "block/parent_plant_dense_model_4_c"),
                @Model(name = "block/%s_plant_dense_model_5_a", template = "block/parent_plant_dense_model_5_a"),
                @Model(name = "block/%s_plant_dense_model_5_b", template = "block/parent_plant_dense_model_5_b"),
                @Model(name = "block/%s_plant_dense_model_5_c", template = "block/parent_plant_dense_model_5_c"),
                @Model(name = "block/%s_plant_dense_model_6_a", template = "block/parent_plant_dense_model_6_a"),
                @Model(name = "block/%s_plant_dense_model_6_b", template = "block/parent_plant_dense_model_6_b"),
                @Model(name = "block/%s_plant_dense_model_6_c", template = "block/parent_plant_dense_model_6_c"),
                @Model(name = "block/%s_plant_dense_model_7_a", template = "block/parent_plant_dense_model_7_a"),
                @Model(name = "block/%s_plant_dense_model_7_b", template = "block/parent_plant_dense_model_7_b"),
                @Model(name = "block/%s_plant_dense_model_7_c", template = "block/parent_plant_dense_model_7_c"),
                @Model(name = "block/%s_plant_dense_model_8_a", template = "block/parent_plant_dense_model_8_a"),
                @Model(name = "block/%s_plant_dense_model_8_b", template = "block/parent_plant_dense_model_8_b"),
                @Model(name = "block/%s_plant_dense_model_8_c", template = "block/parent_plant_dense_model_8_c"),
                @Model(name = "block/%s_pane_ns", template = "block/parent_flatpane_ns"),
        }
)
public class PlantsDenseStackable extends Bush {

    private static final IntegerProperty RANDOM = IntegerProperty.create("random", 0, 2);

    public PlantsDenseStackable(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter iblockreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos up = blockpos.above();
        BlockPos down = blockpos.below();
        BlockState blockStateUp = iblockreader.getBlockState(up);
        BlockState blockStateDown = iblockreader.getBlockState(down);
        Random rand = new Random();
        int randomBlockstate = rand.nextInt(3);
        int layerBlockState = 8;

        if (blockStateDown.hasProperty(Layer.LAYERS) || blockStateDown.hasProperty(Slab.LAYERS) || blockStateDown.hasProperty(Bush.LAYERS)) {
            layerBlockState = blockStateDown.getValue(LAYERS);
        } else if (blockStateUp.hasProperty(Layer.LAYERS) || blockStateUp.hasProperty(Slab.LAYERS) || blockStateUp.hasProperty(Bush.LAYERS)) {
            layerBlockState = blockStateUp.getValue(LAYERS);
        }

        if (blockStateUp.getBlock() instanceof PlantsDenseStackable) {
            randomBlockstate = blockStateUp.getValue(RANDOM);
        } else if (blockStateDown.getBlock() instanceof PlantsDenseStackable) {
            randomBlockstate = blockStateDown.getValue(RANDOM);
        }

        return super.getStateForPlacement(context)
                .setValue(LAYERS, layerBlockState)
                .setValue(RANDOM, randomBlockstate);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(RANDOM, LAYERS, WATERLOGGED);
    }
}
