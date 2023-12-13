package com.conquestrefabricated.content.blocks.block.glass;

import com.conquestrefabricated.core.asset.annotation.Assets;
import com.conquestrefabricated.core.asset.annotation.Model;
import com.conquestrefabricated.core.asset.annotation.Render;
import com.conquestrefabricated.core.asset.annotation.State;
import com.conquestrefabricated.core.util.RenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

@Assets(
        state = @State(name = "%s_pane", template = "parent_pane"),
        item = @Model(name = "item/%s_pane", parent = "block/%s_pane_ns", template = "item/parent_pane"),
        render = @Render(RenderLayer.CUTOUT),
        block = {
                @Model(name = "block/%s_pane_n", template = "block/parent_flatpane_n"),
                @Model(name = "block/%s_pane_ne", template = "block/parent_flatpane_ne"),
                @Model(name = "block/%s_pane_ns", template = "block/parent_flatpane_ns"),
                @Model(name = "block/%s_pane_nse", template = "block/parent_flatpane_nse"),
                @Model(name = "block/%s_pane_nsew", template = "block/parent_flatpane_nsew"),
                @Model(name = "block/%s_pane_post", template = "block/parent_flatpane_post"),
                @Model(name = "block/%s_pane_n_up", template = "block/parent_flatpane_n_up"),
                @Model(name = "block/%s_pane_ne_up", template = "block/parent_flatpane_ne_up"),
                @Model(name = "block/%s_pane_ns_up", template = "block/parent_flatpane_ns_up"),
                @Model(name = "block/%s_pane_nse_up", template = "block/parent_flatpane_nse_up"),
                @Model(name = "block/%s_pane_nsew_up", template = "block/parent_flatpane_nsew_up"),
                @Model(name = "block/%s_pane_post_up", template = "block/parent_flatpane_post_up"),
                @Model(name = "block/%s_pane_n_updown", template = "block/parent_flatpane_n_updown"),
                @Model(name = "block/%s_pane_ne_updown", template = "block/parent_flatpane_ne_updown"),
                @Model(name = "block/%s_pane_ns_updown", template = "block/parent_flatpane_ns_updown"),
                @Model(name = "block/%s_pane_nse_updown", template = "block/parent_flatpane_nse_updown"),
                @Model(name = "block/%s_pane_nsew_updown", template = "block/parent_flatpane_nsew_updown"),
                @Model(name = "block/%s_pane_post_updown", template = "block/parent_flatpane_post_updown"),
                @Model(name = "block/%s_pane_n_down", template = "block/parent_flatpane_n_down"),
                @Model(name = "block/%s_pane_ne_down", template = "block/parent_flatpane_ne_down"),
                @Model(name = "block/%s_pane_ns_down", template = "block/parent_flatpane_ns_down"),
                @Model(name = "block/%s_pane_nse_down", template = "block/parent_flatpane_nse_down"),
                @Model(name = "block/%s_pane_nsew_down", template = "block/parent_flatpane_nsew_down"),
                @Model(name = "block/%s_pane_post_down", template = "block/parent_flatpane_post_down")
        }
)
public class PaneInvisible extends Pane {

    public PaneInvisible(Settings properties) {
        super(properties);
    }

    @Override
    public void randomDisplayTick(BlockState stateIn, World world, BlockPos pos, Random rand) {
        ItemStack itemstack = MinecraftClient.getInstance().player.getMainHandStack();
        boolean flag = !itemstack.isEmpty() && itemstack.getItem() == this.asItem();
        if (flag) {
            for (int i = 0; i < 2; i++) {
                world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK_MARKER, stateIn), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0, 0.00001, 0);
            }
        }
    }
}
