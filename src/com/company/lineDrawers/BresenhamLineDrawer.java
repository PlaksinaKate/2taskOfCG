package com.company.lineDrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int d0 = 0;
        if (dx > dy) {
            for (int i = 0; i <= dx; i++) {
                pd.drawPixel(x1, y1, Color.BLACK);
                d0 += 2 * dy;
                if (y1 > y2 && d0 > dx) {
                    y1--;
                    d0 -= 2 * dx;
                } else if (y1 < y2 && d0 > dx) {
                    y1++;
                    d0 -= 2 * dx;
                }
                if (x1 > x2) {
                    x1--;
                } else {
                    x1++;
                }
            }
        } else {
            for (int i = 0; i <= dy; i++) {
                pd.drawPixel(x1, y1, Color.BLACK);
                d0 += 2 * dx;
                if (x1 > x2 && d0 > dy) {
                    x1--;
                    d0 -= 2 * dy;
                } else if (x1 < x2 && d0 > dy) {
                    x1++;
                    d0 -= 2 * dy;
                }
                if (y1 > y2) {
                    y1--;
                } else {
                    y1++;
                }
            }
        }

    }
}
