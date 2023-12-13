package com.conquestreforged.client.gui.palette.shape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dags <dags@dags.me>
 */
public class Polygon {

    private final List<Edge> edges = new ArrayList<>();
    private final int outerPadding;
    private final int innerPadding;
    private final float angleInc;
    private final int edgeCount;
    private final int radius;

    public Polygon(int edges, int radius, int outerPadding, int innerPadding) {
        this.radius = radius;
        this.edgeCount = edges;
        this.angleInc = 360F / edges;
        this.outerPadding = outerPadding;
        this.innerPadding = innerPadding;
    }

    public Bounds outline() {
        Bounds bounds = new Bounds().startNew();
        for (int i = edges.size() - 1; i >= 0; i--) {
            bounds.add(edges.get(i).start);
        }
        return bounds;
    }

    public void init(int centerX, int centerY) {

        Point cStart = new Point(centerX + radius, centerY);
        Point oStart = new Point(centerX + radius + outerPadding, centerY);
        Point iStart = new Point(centerX + radius - innerPadding, centerY);

        for (int i = 0; i <= edgeCount; i++) {
            float angle = angleInc * i;
            if (i != 0) {
                Edge edge = new Edge(cStart, oStart, iStart, centerX, centerY, radius, outerPadding, innerPadding, angle, angleInc);
                cStart = edge.end;
                oStart = edge.outerEnd;
                iStart = edge.innerEnd;
                edges.add(edge);
            } else {
                float rads = FloatMath.radians(angle);
                cStart = Edge.toPoint(centerX, centerY, radius, rads);
                oStart = Edge.toPoint(centerX, centerY, radius + outerPadding, rads);
                iStart = Edge.toPoint(centerX, centerY, radius - innerPadding, rads);
            }
        }
    }

    private Edge getEdge(double angle) {
        for (Edge edge : edges) {
            if (angle < edge.getAngle()) {
                return edge;
            }
        }
        return edges.get(0);
    }

    public Point getPosition(float angle) {
        return getEdge(angle).getPosition(angle);
    }

    public Bounds getBounds(float angle, float halfSpacing) {
        float min = clampAngle(angle - halfSpacing);
        float max = clampAngle(angle + halfSpacing);

        Edge center = getEdge(angle);
        Edge lower = getEdge(min);
        Edge upper = getEdge(max);

        Bounds bounds = new Bounds().startNew();

        if (lower != center) {
            bounds.add(lower.getInnerPosition(min));
            bounds.add(center.innerStart);
            bounds.add(center.outerStart);
            bounds.add(lower.getOuterPosition(min));

            if (upper != center) {
                bounds.startNew();
                bounds.add(center.innerStart);
                bounds.add(center.innerEnd);
                bounds.add(center.outerEnd);
                bounds.add(center.outerStart);

                bounds.startNew();
                bounds.add(center.innerEnd);
                bounds.add(upper.getInnerPosition(max));
                bounds.add(upper.getOuterPosition(max));
                bounds.add(center.outerEnd);
            } else {
                bounds.startNew();
                bounds.add(center.innerStart);
                bounds.add(upper.getInnerPosition(max));
                bounds.add(upper.getOuterPosition(max));
                bounds.add(center.outerStart);
            }
        } else if (upper != center) {
            bounds.add(lower.getOuterPosition(min));
            bounds.add(lower.getInnerPosition(min));
            bounds.add(center.innerEnd);
            bounds.add(center.outerEnd);

            bounds.startNew();
            bounds.add(center.innerEnd);
            bounds.add(upper.getInnerPosition(max));
            bounds.add(upper.getOuterPosition(max));
            bounds.add(center.outerEnd);
        } else {
            bounds.add(lower.getOuterPosition(min));
            bounds.add(lower.getInnerPosition(min));
            bounds.add(upper.getInnerPosition(max));
            bounds.add(upper.getOuterPosition(max));
        }

        return bounds;
    }

    public static float clampAngle(float value) {
        return value < 0F ? 360F + value : value > 360F ? value - 360F : value;
    }
}
