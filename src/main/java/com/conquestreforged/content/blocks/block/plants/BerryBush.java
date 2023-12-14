package com.conquestreforged.content.blocks.block.plants;

import com.conquestreforged.content.blocks.BlockVoxelShapes;
import com.conquestreforged.core.asset.annotation.Assets;
import com.conquestreforged.core.asset.annotation.Model;
import com.conquestreforged.core.asset.annotation.Render;
import com.conquestreforged.core.asset.annotation.State;
import com.conquestreforged.core.block.builder.Props;
import com.conquestreforged.core.util.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

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

    private final ItemConvertible fruit;

    public BerryBush(Props props) {
        super(props.toSettings());
        this.fruit = props.get("fruit", ItemConvertible.class);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BlockVoxelShapes.cubeMediumLargePartialShape.get(0);
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return BlockVoxelShapes.cubeMediumLargePartialShape.get(0);
    }

    @Override
    public ItemStack getPickStack(BlockView reader, BlockPos pos, BlockState state) {
        return new ItemStack(this, 1);
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (this.isMature(state)) {
            if (level.isClient) {
                return ActionResult.SUCCESS;
            } else {
                state = state.with(AGE, 0);
                level.setBlockState(blockPos, state, 3);
                this.dropFruit(level, blockPos, state);
                return ActionResult.SUCCESS;

            }
        }
        return ActionResult.FAIL;
    }

    private void dropFruit(World world, BlockPos pos, BlockState state) {
        if (!world.isClient) {
            float f = 0.7F;
            double d0 = (double) (world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            double d1 = (double) (world.random.nextFloat() * 0.7F) + 0.06000000238418579D + 0.6D;
            double d2 = (double) (world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
            ItemStack itemstack1 = new ItemStack(fruit, 1);
            ItemEntity entityitem = new ItemEntity(world, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, itemstack1);
            entityitem.setToDefaultPickupDelay();

            // addEntity == spawnEntitiy
            world.spawnEntity(entityitem);
        }
    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }
}
