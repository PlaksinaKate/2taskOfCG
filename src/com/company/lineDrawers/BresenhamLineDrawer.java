package com.company.lineDrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;
import org.omg.CORBA.MARSHAL;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
//        if (x1 > x2) {
//            int tmp = x1;
//            x1 = x2;
//            x2 = tmp;
//        }
//        if (y1 > y2) {
//            int tmp = y1;
//            y1 = y2;
//            y2 = tmp;
//        }
        boolean b = Math.abs(y1) > Math.abs(y2);
        boolean b1 = Math.abs(x1) > Math.abs(x2);

        if (Math.abs(x2 - x1) > Math.abs(y2 - y1)) {
            if (b1) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
            } else if (b && b1) {
                int tmp = x1;
                x1 = y2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
        }else{
            if (b && !b1) {
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }else if (b && b1) {
                int tmp = x1;
                x1 = y2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
        }
//        int dx = x2 - x1;
//        int dy = y2 - y1;
//        int x, y;
//        boolean checkDxDy = Math.abs(dx) > Math.abs(dy);
//        if (checkDxDy) {
//            if (x1 > x2) {
//                x = x1;
//                y = y1;
//            } else {
//                x = x2;
//                y = y2;
//                dx = x1 - x2;
//                dy = y1 - y2;
//            }
//        } else {
//            if (y1 > y2) {
//                x = y1;
//                y = x1;
//            } else {
//                x = y2;
//                y = x2;
//                dx = y1 - y2;
//                dy = x1 - x2;
//            }
//        }
        int dx = x2 - x1;
        int dy = y2 - y1;
        int d0 = 2 * dy + dx;
        if (Math.abs(dx) > Math.abs(dy)) {
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
            for (int j = y1; j <= y2; j++) {
                pd.drawPixel(x1, j, Color.RED);
                if (d0 >= 0) {
                    x1++;
                    d0 += 2 * (dx - dy);
                } else {
                    d0 += 2 * dx;
                }
            }
        }
    }
}
