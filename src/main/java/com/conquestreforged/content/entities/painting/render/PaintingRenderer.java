package com.conquestreforged.content.entities.painting.render;

import com.conquestreforged.content.entities.painting.EntityPainting;
import com.conquestreforged.content.entities.painting.art.ArtType;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;

/**
 * @author dags <dags@dags.me>
 */
public class PaintingRenderer extends EntityRenderer<EntityPainting> {

    public PaintingRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager);
    }

    @Override
    public void render(EntityPainting painting, float yaw, float ticks, MatrixStack matrix, VertexConsumerProvider buffer, int light) {
        matrix.push();
        matrix.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0F - yaw));
        matrix.scale(0.0625F, 0.0625F, 0.0625F);
        ArtType art = painting.getArt();
        Identifier texture = getTexture(painting);
        RenderLayer renderType = RenderLayer.getEntityCutout(texture);
        VertexConsumer builder = buffer.getBuffer(renderType);
        render(matrix, builder, painting, art.sizeX, art.sizeY, art.offsetX, art.offsetY);
        matrix.pop();
        super.render(painting, yaw, ticks, matrix, buffer, light);
    }



    @Override
    public Identifier getTexture(EntityPainting entity) {
        return entity.getPaintingType().getRegistryName();
    }

    private void render(MatrixStack matrix, VertexConsumer builder, EntityPainting entity, int width, int height, int textureU, int textureV) {
        MatrixStack.Entry entry = matrix.peek();
        Matrix4f position = entry.getPositionMatrix();
        Matrix3f normals = entry.getNormalMatrix();

        float xCenter = (float) (-width) / 2.0F;
        float yCenter = (float) (-height) / 2.0F;
        for (int x = 0; x < width / 16; ++x) {
            for (int y = 0; y < height / 16; ++y) {
                float minX = xCenter + (float) (x * 16);
                float minY = yCenter + (float) (y * 16);
                float maxX = xCenter + (float) ((x + 1) * 16);
                float maxY = yCenter + (float) ((y + 1) * 16);

                int lightX = MathHelper.floor(entity.getX());
                int lightY = MathHelper.floor(entity.getY() + (double) ((maxY + minY) / 2.0F / 16.0F));
                int lightZ = MathHelper.floor(entity.getZ());
                int light = WorldRenderer.getLightmapCoordinates(entity.world, new BlockPos(lightX, lightY, lightZ));

                float txMin = (float) (textureU + width - x * 16) / 256.0F;
                float txMax = (float) (textureU + width - (x + 1) * 16) / 256.0F;
                float tyMin = (float) (textureV + height - y * 16) / 256.0F;
                float tyMax = (float) (textureV + height - (y + 1) * 16) / 256.0F;
                vertex(position, normals, builder, maxX, minY, txMax, tyMin, 0.2F, 0, 0, -1, light);
                vertex(position, normals, builder, minX, minY, txMin, tyMin, 0.2F, 0, 0, -1, light);
                vertex(position, normals, builder, minX, maxY, txMin, tyMax, 0.2F, 0, 0, -1, light);
                vertex(position, normals, builder, maxX, maxY, txMax, tyMax, 0.2F, 0, 0, -1, light);

                // reverse the texture so it appears flipped on the back side of the paintings
                vertex(position, normals, builder, maxX, maxY, txMax, tyMax, 0.2F, 0, 0, -1, light);
                vertex(position, normals, builder, minX, maxY, txMin, tyMax, 0.2F, 0, 0, -1, light);
                vertex(position, normals, builder, minX, minY, txMin, tyMin, 0.2F, 0, 0, -1, light);
                vertex(position, normals, builder, maxX, minY, txMax, tyMin, 0.2F, 0, 0, -1, light);
            }
        }
    }

    private void vertex(Matrix4f position, Matrix3f normals, VertexConsumer builder, float x, float y, float u, float v, float z, int nx, int ny, int nz, int light) {
        builder.vertex(position, x, y, z)
                .color(255, 255, 255, 255)
                .texture(u, v)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(normals, (float) nx, (float) ny, (float) nz)
                .next();
    }
}
