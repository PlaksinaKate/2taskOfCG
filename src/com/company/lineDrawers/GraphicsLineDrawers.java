package com.company.lineDrawers;

import com.company.LineDrawer;

import java.awt.*;

public class GraphicsLineDrawers implements LineDrawer {
    private Graphics g;


    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    public GraphicsLineDrawers(Graphics g) {
        this.g = g;
    }
}
