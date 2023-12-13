package com.conquestreforged.blocks.block.plants;

import com.conquestreforged.blocks.BlockVoxelShapes;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(name = "%s", template = "parent_berry_bush"),
        item = @Model(name = "item/%s", parent = "block/%s_pane_ns", template = "item/parent_round_arch"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_shrub_model_1_a", template = "block/parent_shrub_model_1_a"),
                @Model(name = "block/%s_shrub_model_1_b", template = "block/parent_shrub_model_1_b"),
                @Model(name = "block/%s_shrub_model_1_c", template = "block/parent_shrub_model_1_c"),
                @Model(name = "block/%s_berry_bush_model_1_a", template = "block/parent_berry_bush_model_1_a"),
                @Model(name = "block/%s_berry_bush_model_1_b", template = "block/parent_berry_bush_model_1_b"),
                @Model(name = "block/%s_berry_bush_model_1_c", template = "block/parent_berry_bush_model_1_c"),
                @Model(name = "block/%s_shrub_model_2_a", template = "block/parent_shrub_model_2_a"),
                @Model(name = "block/%s_shrub_model_2_b", template = "block/parent_shrub_model_2_b"),
                @Model(name = "block/%s_shrub_model_2_c", template = "block/parent_shrub_model_2_c"),
                @Model(name = "block/%s_berry_bush_model_2_a", template = "block/parent_berry_bush_model_2_a"),
                @Model(name = "block/%s_berry_bush_model_2_b", template = "block/parent_berry_bush_model_2_b"),
                @Model(name = "block/%s_berry_bush_model_2_c", template = "block/parent_berry_bush_model_2_c"),
                @Model(name = "block/%s_shrub_model_3_a", template = "block/parent_shrub_model_3_a"),
                @Model(name = "block/%s_shrub_model_3_b", template = "block/parent_shrub_model_3_b"),
                @Model(name = "block/%s_shrub_model_3_c", template = "block/parent_shrub_model_3_c"),
                @Model(name = "block/%s_berry_bush_model_3_a", template = "block/parent_berry_bush_model_3_a"),
                @Model(name = "block/%s_berry_bush_model_3_b", template = "block/parent_berry_bush_model_3_b"),
                @Model(name = "block/%s_berry_bush_model_3_c", template = "block/parent_berry_bush_model_3_c"),
                @Model(name = "block/%s_shrub_model_4_a", template = "block/parent_shrub_model_4_a"),
                @Model(name = "block/%s_shrub_model_4_b", template = "block/parent_shrub_model_4_b"),
                @Model(name = "block/%s_shrub_model_4_c", template = "block/parent_shrub_model_4_c"),
                @Model(name = "block/%s_berry_bush_model_4_a", template = "block/parent_berry_bush_model_4_a"),
                @Model(name = "block/%s_berry_bush_model_4_b", template = "block/parent_berry_bush_model_4_b"),
                @Model(name = "block/%s_berry_bush_model_4_c", template = "block/parent_berry_bush_model_4_c"),
                @Model(name = "block/%s_shrub_model_5_a", template = "block/parent_shrub_model_5_a"),
                @Model(name = "block/%s_shrub_model_5_b", template = "block/parent_shrub_model_5_b"),
                @Model(name = "block/%s_shrub_model_5_c", template = "block/parent_shrub_model_5_c"),
                @Model(name = "block/%s_berry_bush_model_5_a", template = "block/parent_berry_bush_model_5_a"),
                @Model(name = "block/%s_berry_bush_model_5_b", template = "block/parent_berry_bush_model_5_b"),
                @Model(name = "block/%s_berry_bush_model_5_c", template = "block/parent_berry_bush_model_5_c"),
                @Model(name = "block/%s_shrub_model_6_a", template = "block/parent_shrub_model_6_a"),
                @Model(name = "block/%s_shrub_model_6_b", template = "block/parent_shrub_model_6_b"),
                @Model(name = "block/%s_shrub_model_6_c", template = "block/parent_shrub_model_6_c"),
                @Model(name = "block/%s_berry_bush_model_6_a", template = "block/parent_berry_bush_model_6_a"),
                @Model(name = "block/%s_berry_bush_model_6_b", template = "block/parent_berry_bush_model_6_b"),
                @Model(name = "block/%s_berry_bush_model_6_c", template = "block/parent_berry_bush_model_6_c"),
                @Model(name = "block/%s_shrub_model_7_a", template = "block/parent_shrub_model_7_a"),
                @Model(name = "block/%s_shrub_model_7_b", template = "block/parent_shrub_model_7_b"),
                @Model(name = "block/%s_shrub_model_7_c", template = "block/parent_shrub_model_7_c"),
                @Model(name = "block/%s_berry_bush_model_7_a", template = "block/parent_berry_bush_model_7_a"),
                @Model(name = "block/%s_berry_bush_model_7_b", template = "block/parent_berry_bush_model_7_b"),
                @Model(name = "block/%s_berry_bush_model_7_c", template = "block/parent_berry_bush_model_7_c"),
                @Model(name = "block/%s_shrub_model_8_a", template = "block/parent_shrub_model_8_a"),
                @Model(name = "block/%s_shrub_model_8_b", template = "block/parent_shrub_model_8_b"),
                @Model(name = "block/%s_shrub_model_8_c", template = "block/parent_shrub_model_8_c"),
                @Model(name = "block/%s_berry_bush_model_8_a", template = "block/parent_berry_bush_model_8_a"),
                @Model(name = "block/%s_berry_bush_model_8_b", template = "block/parent_berry_bush_model_8_b"),
                @Model(name = "block/%s_berry_bush_model_8_c", template = "block/parent_berry_bush_model_8_c"),
                @Model(name = "block/%s_pane_ns", template = "block/parent_flatpane_ns"),
        }
)

public class BerryBush extends AbstractCropsBlock {

    private final ItemLike fruit;

    public BerryBush(Props props) {
        super(props.toProperties());
        this.fruit = props.get("fruit", ItemLike.class);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return BlockVoxelShapes.cubeMediumLargePartialShape.get(0);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return BlockVoxelShapes.cubeMediumLargePartialShape.get(0);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter reader, BlockPos pos, BlockState state) {
        return new ItemStack(this, 1);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (this.isMaxAge(state)) {
            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                state = state.setValue(AGE, 0);
                level.setBlock(blockPos, state, 3);
                this.dropFruit(level, blockPos, state);
                return InteractionResult.SUCCESS;

            }
        }
        return InteractionResult.FAIL;
    }

    private void dropFruit(Level world, BlockPos pos, BlockState state) {
        if (!world.isClientSide) {
            float f = 0.7F;
            double d0 = (double) (world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            double d1 = (double) (world.random.nextFloat() * 0.7F) + 0.06000000238418579D + 0.6D;
            double d2 = (double) (world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            ItemStack itemstack1 = new ItemStack(fruit, 1);
            ItemEntity entityitem = new ItemEntity(world, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, itemstack1);
            entityitem.setDefaultPickUpDelay();

            // addEntity == spawnEntitiy
            world.addFreshEntity(entityitem);
        }
    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }
}
