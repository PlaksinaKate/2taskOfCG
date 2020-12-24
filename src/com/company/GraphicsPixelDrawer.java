package com.company;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer {
    private GraphicsProvider gp;

    public GraphicsPixelDrawer(GraphicsProvider gp) {
        this.gp = gp;
    }

    @Override
    public void drawPixel(int x, int y, Color c) {
        gp.getGraphics().setColor(c);
        gp.getGraphics().fillRect(x, y, 1, 1);
    }
}
