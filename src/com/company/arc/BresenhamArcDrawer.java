package com.company.arc;

import com.company.PixelDrawer;
import com.company.lineDrawers.LineDrawer;

import java.awt.*;

public class BresenhamArcDrawer implements ArcDrawer {
    private LineDrawer ld;

    public BresenhamArcDrawer(LineDrawer pd) {
        this.ld = ld;
    }

    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        int x2 = 0;
        int y2 = 0;
        int limit = 0;

        if (startAngle <= 90) {
            if (arcAngle > 90)
                arcAngle = 90;

            x2 = (int) Math.abs(width / 2 * Math.cos(arcAngle * Math.PI / 180));
            y2 = (int) Math.abs(height / 2 * Math.sin(arcAngle * Math.PI / 180));
            limit = (int) Math.abs(height / 2 * Math.sin(startAngle * Math.PI / 180));

        } else if ((startAngle > 90 && arcAngle <= 180) || (startAngle <= 90 && arcAngle > 90) || (startAngle > 90 && arcAngle >= 180 && arcAngle < 270)) {
            if (arcAngle > 180)
                arcAngle = 180;
            if (startAngle < 90)
                startAngle = 90;

            x2 = (int) Math.abs(width / 2 * Math.cos(startAngle * Math.PI / 180));
            y2 = (int) Math.abs(height / 2 * Math.sin(startAngle * Math.PI / 180));
            limit = (int) Math.abs(height / 2 * Math.sin(arcAngle * Math.PI / 180));

        } else if ((startAngle > 180 && arcAngle <= 270) || (startAngle <= 180 && arcAngle > 180) || (startAngle > 180 && arcAngle >= 270)) {
            if (arcAngle > 270)
                arcAngle = 270;
            if (startAngle < 180)
                startAngle = 180;

            x2 = (int) Math.abs(width / 2 * Math.cos(arcAngle * Math.PI / 180));
            y2 = (int) Math.abs(height / 2 * Math.sin(arcAngle * Math.PI / 180));
            limit = (int) Math.abs(height / 2 * Math.sin(startAngle * Math.PI / 180));

        } else if ((startAngle > 270 && arcAngle <= 360) || (startAngle <= 270 && arcAngle > 270) || (startAngle > 270 && arcAngle >= 360)) {
            if (arcAngle > 360)
                arcAngle = 360;
            if (startAngle < 270)
                startAngle = 270;

            x2 = (int) Math.abs(width / 2 * Math.cos(startAngle * Math.PI / 180));
            y2 = (int) Math.abs(height / 2 * Math.sin(startAngle * Math.PI / 180));
            limit = (int) Math.abs(height / 2 * Math.sin(arcAngle * Math.PI / 180));

        }

        int dx;
        int dy;
        int d0 = 2 - height;
        while (y2 >= limit) {

            if (startAngle <= 90 || (startAngle > 270 && startAngle <= 360))
                ld.drawLine(x + x2, -y + y2, x + x2, -y + y2);
            else
                ld.drawLine(-x + x2, y + y2, -x + x2, y + y2);
            //repaint();
            if (d0 < 0) {
                dy = 2 * d0 - 2 * y2 - 1;
                if (dy < 0) {
                    x2++;
                    d0 += 2 * x2 + 1;
                } else if (dy > 0) {
                    x2++;
                    y2--;
                    d0 += 2 * x2 - 2 * y2 + 2;
                }
            } else if (d0 > 0) {
                dx = 2 * d0 - 2 * x2 - 1;
                if (dx <= 0) {
                    x2++;
                    y2--;
                    d0 += 2 * x2 - 2 * y2 + 2;
                } else if (dx > 0) {
                    y2--;
                    d0 -= 2 * y2 + 1;
                }
            } else if (d0 == 0) {
                x2++;
                y2--;
                d0 += 2 * x2 - 2 * y2 + 2;
            }

        }
    }
}
