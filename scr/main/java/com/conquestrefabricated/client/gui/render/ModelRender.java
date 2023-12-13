package com.conquestrefabricated.client.gui.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import io.github.fabricators_of_create.porting_lib.model.PerspectiveMapWrapper;
import io.github.fabricators_of_create.porting_lib.util.LightUtil;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.List;

public class ModelRender {

    private static final int[] lightmap = {15728880, 15728880, 15728880, 15728880};

    public static void renderModel(MatrixStack poseStack, BakedModel model, int x, int y, int color) {
        renderModel(poseStack, ModelTransformation.Mode.GUI, model, x, y, color);
    }

    public static void renderModel(MatrixStack poseStack, ModelTransformation.Mode transform, BakedModel model, int x, int y, int color) {
        MinecraftClient.getInstance().getTextureManager().getTexture(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).setFilter(false, false);
        RenderSystem.setShaderTexture(0, SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        MatrixStack posestack = RenderSystem.getModelViewStack();
        posestack.push();
        //RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //RenderSystem.enableRescaleNormal();
        //RenderSystem.enableAlphaTest();
        //RenderSystem.defaultAlphaFunc();
        posestack.translate((float) x, (float) y, 100.0F);
        posestack.translate(8.0F, 8.0F, 0.0F);
        posestack.scale(1.0F, -1.0F, 1.0F);
        posestack.scale(16.0F, 16.0F, 16.0F);
        RenderSystem.applyModelViewMatrix();
        MatrixStack matrixstack = new MatrixStack();
        VertexConsumerProvider.Immediate buffer = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        model = handleCameraTransforms(matrixstack, model, transform, false);

        boolean flag = !model.isSideLit();
        if (flag) {
            DiffuseLighting.disableGuiDepthLighting();
        }

        renderModel(matrixstack, RenderLayer.getCutout(), buffer, model, color);

        buffer.draw();
        RenderSystem.enableDepthTest();
        if (flag) {
            DiffuseLighting.enableGuiDepthLighting();
        }

        //RenderSystem.disableAlphaTest();
        posestack.pop();
        RenderSystem.applyModelViewMatrix();
    }

    public static void renderModel(MatrixStack poseStack, BlockState state, BakedModel model, int x, int y, int color) {
        MinecraftClient.getInstance().getTextureManager().getTexture(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).setFilter(false, false);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.enableTexture();
        RenderSystem.setShaderTexture(0, SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.push();

        MatrixStack posestack = RenderSystem.getModelViewStack();
        //RenderSystem.enableRescaleNormal();
        //RenderSystem.enableAlphaTest();
        //RenderSystem.defaultAlphaFunc();
        posestack.translate((float) x, (float) y, 100.0F);
        posestack.translate(8.0F, 8.0F, 0.0F);
        posestack.scale(1.0F, -1.0F, 1.0F);
        posestack.scale(16.0F, 16.0F, 16.0F);
        MatrixStack matrix = new MatrixStack();

        matrix.push();
        matrix.translate(-0.75, 0, 0);
        matrix.multiply(new Quaternion(30, 30, 0, true));
        VertexConsumerProvider.Immediate buffer = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(state, matrix, buffer, 15728880, OverlayTexture.DEFAULT_UV);
        matrix.pop();

        buffer.draw();
        RenderSystem.enableDepthTest();

        //RenderSystem.disableAlphaTest();
        //RenderSystem.disableRescaleNormal();
        poseStack.pop();
        RenderSystem.applyModelViewMatrix();
    }

    private static void renderModel(MatrixStack matrix, RenderLayer rendertype, VertexConsumerProvider.Immediate buffer, BakedModel model, int color) {
        matrix.push();
        matrix.translate(-0.5D, -0.5D, -0.5D);
        VertexConsumer builder = getBuffer(buffer, rendertype, true, false);
        renderModel(model, matrix, builder, color);
        matrix.pop();
    }

    private static void renderModel(BakedModel modelIn, MatrixStack matrix, VertexConsumer buffer, int color) {
        Random random = Random.create();
        long i = 42L;

        for (Direction direction : Direction.values()) {
            random.setSeed(42L);
            renderQuads(matrix, buffer, modelIn.getQuads(null, direction, random), color);
        }

        random.setSeed(42L);
        renderQuads(matrix, buffer, modelIn.getQuads(null, null, random), color);
    }

    private static void renderQuads(MatrixStack matrix, VertexConsumer buffer, List<BakedQuad> quads, int color) {
        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;

        MatrixStack.Entry entry = matrix.peek();
        for (BakedQuad bakedquad : quads) {
            render(buffer, bakedquad, entry, r, g, b, 1);
        }
    }

    private static void render(VertexConsumer bufferIn, BakedQuad quadIn, MatrixStack.Entry entry, float red, float green, float blue, float alpha) {
        int[] aint = quadIn.getVertexData();
        Vec3i vec3i = quadIn.getFace().getVector();
        Vec3f vector3f = new Vec3f((float) vec3i.getX(), (float) vec3i.getY(), (float) vec3i.getZ());
        Matrix4f matrix4f = entry.getPositionMatrix();
        vector3f.transform(entry.getNormalMatrix());
        int i = 8;
        int j = aint.length / 8;

        try (MemoryStack memorystack = MemoryStack.stackPush()) {
            ByteBuffer bytebuffer = memorystack.malloc(VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL.getVertexSizeByte());
            IntBuffer intbuffer = bytebuffer.asIntBuffer();

            for (int k = 0; k < j; ++k) {
                intbuffer.clear();
                intbuffer.put(aint, k * 8, 8);
                float f = bytebuffer.getFloat(0);
                float f1 = bytebuffer.getFloat(4);
                float f2 = bytebuffer.getFloat(8);
                int l = Math.min(k, lightmap.length - 1);
                int light = applyBakedLighting(lightmap[l], bytebuffer);
                float u = bytebuffer.getFloat(16);
                float v = bytebuffer.getFloat(20);
                Vector4f vector4f = new Vector4f(f, f1, f2, 1.0F);
                vector4f.transform(matrix4f);
                applyBakedNormals(vector3f, bytebuffer, entry.getNormalMatrix());
                bufferIn.vertex(vector4f.getX(), vector4f.getY(), vector4f.getZ(), red, green, blue, alpha, u, v, OverlayTexture.DEFAULT_UV, light, vector3f.getX(), vector3f.getY(), vector3f.getZ());
            }
        }
    }

    private static int applyBakedLighting(int lightmapCoord, ByteBuffer data) {
        int bl = LightmapTextureManager.getBlockLightCoordinates(lightmapCoord);
        int sl = LightmapTextureManager.getSkyLightCoordinates(lightmapCoord);
        int offset = LightUtil.getLightOffset(0) * 4; // int offset for vertex 0 * 4 bytes per int
        int blBaked = Short.toUnsignedInt(data.getShort(offset)) >> 4;
        int slBaked = Short.toUnsignedInt(data.getShort(offset + 2)) >> 4;
        bl = Math.max(bl, blBaked);
        sl = Math.max(sl, slBaked);
        return LightmapTextureManager.pack(bl, sl);
    }

    private static void applyBakedNormals(Vec3f generated, ByteBuffer data, Matrix3f normalTransform) {
        byte nx = data.get(28);
        byte ny = data.get(29);
        byte nz = data.get(30);
        if (nx != 0 || ny != 0 || nz != 0) {
            generated.set(nx / 127f, ny / 127f, nz / 127f);
            generated.transform(normalTransform);
        }
    }

    public static VertexConsumer getBuffer(VertexConsumerProvider buffer, RenderLayer type, boolean isItemIn, boolean dummy) {
        return buffer.getBuffer(type);
    }

    private static final Matrix4f flipX;
    private static final Matrix3f flipXNormal;
    static {
        flipX = Matrix4f.scale(-1,1,1);
        flipXNormal = new Matrix3f(flipX);
    }

    public static BakedModel handleCameraTransforms(MatrixStack poseStack, BakedModel model, ModelTransformation.Mode cameraTransformType, boolean leftHandHackery)
    {
        MatrixStack stack = new MatrixStack();
        model = PerspectiveMapWrapper.handlePerspective(model, PerspectiveMapWrapper.getTransforms(model.getTransformation()), cameraTransformType, stack);
                //model.handlePerspective(cameraTransformType, stack);


        // If the stack is not empty, the code has added a matrix for us to use.
        if (!stack.isEmpty())
        {
            // Apply the transformation to the real matrix stack, flipping for left hand
            Matrix4f tMat = stack.peek().getPositionMatrix();
            Matrix3f nMat = stack.peek().getNormalMatrix();
            if (leftHandHackery)
            {
                tMat.multiplyBackward(flipX);
                tMat.multiply(flipX);
                nMat.multiplyBackward(flipXNormal);
                nMat.multiply(flipXNormal);
            }
            poseStack.peek().getPositionMatrix().multiply(tMat);
            poseStack.peek().getNormalMatrix().multiply(nMat);
        }
        return model;
    }

}
