package com.conquestreforged.client.gui.palette.shape;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dags <dags@dags.me>
 */
public class Bounds {

    public static final Bounds NONE = new Bounds();

    private final List<List<Point>> bounds = new LinkedList<>();
    private List<Point> points = Collections.emptyList();

    public Bounds startNew() {
        bounds.add(points = new LinkedList<>());
        return this;
    }

    public Bounds add(Point point) {
        points.add(point);
        return this;
    }

    public void draw(float red, float green, float blue, float opacity, float ticks) {
        RenderSystem.color4f(red, green, blue, opacity);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        for (List<Point> points : bounds) {
            buffer.begin(GL11.GL_POLYGON, DefaultVertexFormats.POSITION);
            for (Point point : points) {
                // buffer.pos?
                buffer.pos(point.x, point.y, 0).endVertex();
            }
            tessellator.draw();
        }
    }
}
