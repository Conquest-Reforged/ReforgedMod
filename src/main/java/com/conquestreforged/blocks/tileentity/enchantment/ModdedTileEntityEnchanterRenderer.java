package com.conquestreforged.blocks.tileentity.enchantment;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModdedTileEntityEnchanterRenderer implements BlockEntityRenderer<ModdedEnchantingTableTileEntity> {

    public static final Material BOOK_LOCATION = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("entity/enchanting_table_book"));
    private final BookModel bookModel;

    public ModdedTileEntityEnchanterRenderer(final BlockEntityRendererProvider.Context dispatcher) {
        this.bookModel = new BookModel(dispatcher.bakeLayer(ModelLayers.BOOK));
    }

    @Override
    public void render(ModdedEnchantingTableTileEntity p_225616_1_, float p_225616_2_, PoseStack p_225616_3_, MultiBufferSource p_225616_4_, int p_225616_5_, int p_225616_6_) {
        p_225616_3_.pushPose();
        p_225616_3_.translate(0.5D, 0.75D, 0.5D);
        float f = (float)p_225616_1_.time + p_225616_2_;
        p_225616_3_.translate(0.0D, (double)(0.1F + Mth.sin(f * 0.1F) * 0.01F), 0.0D);

        float f1;
        for(f1 = p_225616_1_.rot - p_225616_1_.oRot; f1 >= (float)Math.PI; f1 -= ((float)Math.PI * 2F)) {
        }

        while(f1 < -(float)Math.PI) {
            f1 += ((float)Math.PI * 2F);
        }

        float f2 = p_225616_1_.oRot + f1 * p_225616_2_;
        p_225616_3_.mulPose(Vector3f.YP.rotation(-f2));
        p_225616_3_.mulPose(Vector3f.ZP.rotationDegrees(80.0F));
        float f3 = Mth.lerp(p_225616_2_, p_225616_1_.oFlip, p_225616_1_.flip);
        float f4 = Mth.frac(f3 + 0.25F) * 1.6F - 0.3F;
        float f5 = Mth.frac(f3 + 0.75F) * 1.6F - 0.3F;
        float f6 = Mth.lerp(p_225616_2_, p_225616_1_.oOpen, p_225616_1_.open);
        this.bookModel.setupAnim(f, Mth.clamp(f4, 0.0F, 1.0F), Mth.clamp(f5, 0.0F, 1.0F), f6);
        VertexConsumer ivertexbuilder = BOOK_LOCATION.buffer(p_225616_4_, RenderType::entitySolid);
        this.bookModel.render(p_225616_3_, ivertexbuilder, p_225616_5_, p_225616_6_, 1.0F, 1.0F, 1.0F, 1.0F);
        p_225616_3_.popPose();
    }
}