package com.conquestrefabricated.client.gui.palette.shape;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;

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
        RenderSystem.setShaderColor(red, green, blue, opacity);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        for (List<Point> points : bounds) {
            //used to be gl_polygon instead of quads?
            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION);
            for (Point point : points) {
                // buffer.pos?
                buffer.vertex(point.x, point.y, 0).next();
            }
            tessellator.draw();
        }
    }
}
