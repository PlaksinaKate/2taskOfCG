package com.company.arc;

import java.awt.*;

public class GraphicsArcDrawer implements ArcDrawer {
    private Graphics g;

    public GraphicsArcDrawer(Graphics gp) {
        this.g = g;
    }

    @Override
    public void drawArc(int x, int y, int width, int height, double startAngle, double arcAngle, Color c) {
        g.setColor(c);
        g.drawArc(x, y, width, height, (int) startAngle, (int) arcAngle);
    }
}
