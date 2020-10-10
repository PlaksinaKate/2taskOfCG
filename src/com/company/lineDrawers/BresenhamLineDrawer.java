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
        int dx = x2 - x1;
        int dy = y2 - y1;
        int d0 = 2 * dy + dx;
        if (Math.abs(dx) > Math.abs(dy)) {
            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            for (int i = x1; i <= x2; i++) {
                pd.drawPixel(i, y1, Color.BLACK);
                if (d0 >= 0) {
                    y1++;
                    d0 += 2 * (dy - dx);
                } else {
                    d0 += 2 * dy;
                }
            }
        } else {
            if (y1 > y2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            for (int j = y1; j <= y2; j++) {
                pd.drawPixel(x1, j, Color.RED);
                if (d0 >= 0) {
                    x1++;
                    d0 += 2 * (dy - dx);
                } else {
                    d0 += 2 * dy;
                }
            }
        }
    }
}
