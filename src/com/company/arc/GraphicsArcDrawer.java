package com.company.arc;

import java.awt.*;

public class GraphicsArcDrawer implements ArcDrawer {
    private Graphics g;

    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        g.drawArc(x, y, width, height, startAngle, arcAngle);
    }

    public GraphicsArcDrawer(Graphics g) {
        this.g = g;
    }

}
