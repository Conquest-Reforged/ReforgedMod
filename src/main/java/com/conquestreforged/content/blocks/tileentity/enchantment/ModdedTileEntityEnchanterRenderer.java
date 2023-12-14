package com.conquestreforged.content.blocks.tileentity.enchantment;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public class ModdedTileEntityEnchanterRenderer implements BlockEntityRenderer<ModdedEnchantingTableTileEntity> {

    public static final SpriteIdentifier BOOK_LOCATION = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("entity/enchanting_table_book"));
    private final BookModel bookModel;

    public ModdedTileEntityEnchanterRenderer(final BlockEntityRendererFactory.Context dispatcher) {
        this.bookModel = new BookModel(dispatcher.getLayerModelPart(EntityModelLayers.BOOK));
    }

    @Override
    public void render(ModdedEnchantingTableTileEntity p_225616_1_, float p_225616_2_, MatrixStack p_225616_3_, VertexConsumerProvider p_225616_4_, int p_225616_5_, int p_225616_6_) {
        p_225616_3_.push();
        p_225616_3_.translate(0.5D, 0.75D, 0.5D);
        float f = (float)p_225616_1_.time + p_225616_2_;
        p_225616_3_.translate(0.0D, (double)(0.1F + MathHelper.sin(f * 0.1F) * 0.01F), 0.0D);

        float f1;
        for(f1 = p_225616_1_.rot - p_225616_1_.oRot; f1 >= (float)Math.PI; f1 -= ((float)Math.PI * 2F)) {
        }

        while(f1 < -(float)Math.PI) {
            f1 += ((float)Math.PI * 2F);
        }

        float f2 = p_225616_1_.oRot + f1 * p_225616_2_;
        p_225616_3_.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion(-f2));
        p_225616_3_.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(80.0F));
        float f3 = MathHelper.lerp(p_225616_2_, p_225616_1_.oFlip, p_225616_1_.flip);
        float f4 = MathHelper.fractionalPart(f3 + 0.25F) * 1.6F - 0.3F;
        float f5 = MathHelper.fractionalPart(f3 + 0.75F) * 1.6F - 0.3F;
        float f6 = MathHelper.lerp(p_225616_2_, p_225616_1_.oOpen, p_225616_1_.open);
        this.bookModel.setPageAngles(f, MathHelper.clamp(f4, 0.0F, 1.0F), MathHelper.clamp(f5, 0.0F, 1.0F), f6);
        VertexConsumer ivertexbuilder = BOOK_LOCATION.getVertexConsumer(p_225616_4_, RenderLayer::getEntitySolid);
        this.bookModel.renderBook(p_225616_3_, ivertexbuilder, p_225616_5_, p_225616_6_, 1.0F, 1.0F, 1.0F, 1.0F);
        p_225616_3_.pop();
    }
}