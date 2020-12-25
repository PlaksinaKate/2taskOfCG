package com.company.arc;

import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamArcDrawer implements ArcDrawer {
    private PixelDrawer pd;

    public BresenhamArcDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

//    @Override
//    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
//        int x2 = 0;
//        int y2 = 0;
//        int limit = 0;
//
//        if (startAngle <= 90) {
//            if (arcAngle > 90)
//                arcAngle = 90;
//
//            x2 = (int) Math.abs(width / 2 * Math.cos(arcAngle * Math.PI / 180));
//            y2 = (int) Math.abs(height / 2 * Math.sin(arcAngle * Math.PI / 180));
//            limit = (int) Math.abs(height / 2 * Math.sin(startAngle * Math.PI / 180));
//
//        } else if ((startAngle > 90 && arcAngle <= 180) || (startAngle <= 90 && arcAngle > 90) || (startAngle > 90 && arcAngle >= 180 && arcAngle < 270)) {
//            if (arcAngle > 180)
//                arcAngle = 180;
//            if (startAngle < 90)
//                startAngle = 90;
//
//            x2 = (int) Math.abs(width / 2 * Math.cos(startAngle * Math.PI / 180));
//            y2 = (int) Math.abs(height / 2 * Math.sin(startAngle * Math.PI / 180));
//            limit = (int) Math.abs(height / 2 * Math.sin(arcAngle * Math.PI / 180));
//
//        } else if ((startAngle > 180 && arcAngle <= 270) || (startAngle <= 180 && arcAngle > 180) || (startAngle > 180 && arcAngle >= 270)) {
//            if (arcAngle > 270)
//                arcAngle = 270;
//            if (startAngle < 180)
//                startAngle = 180;
//
//            x2 = (int) Math.abs(width / 2 * Math.cos(arcAngle * Math.PI / 180));
//            y2 = (int) Math.abs(height / 2 * Math.sin(arcAngle * Math.PI / 180));
//            limit = (int) Math.abs(height / 2 * Math.sin(startAngle * Math.PI / 180));
//
//        } else if ((startAngle > 270 && arcAngle <= 360) || (startAngle <= 270 && arcAngle > 270) || (startAngle > 270 && arcAngle >= 360)) {
//            if (arcAngle > 360)
//                arcAngle = 360;
//            if (startAngle < 270)
//                startAngle = 270;
//
//            x2 = (int) Math.abs(width / 2 * Math.cos(startAngle * Math.PI / 180));
//            y2 = (int) Math.abs(height / 2 * Math.sin(startAngle * Math.PI / 180));
//            limit = (int) Math.abs(height / 2 * Math.sin(arcAngle * Math.PI / 180));
//
//        }
//
//        int dx;
//        int dy;
//        int d0 = 2 - height;
//        while (y2 >= limit) {
//
//            if (startAngle <= 90 || (startAngle > 270 && startAngle <= 360))
//                pd.drawPixel(x + x2, -y + y2, x + x2, -y + y2);
//            else
//                ld.drawLine(-x + x2, y + y2, -x + x2, y + y2);
//            //repaint();
//            if (d0 < 0) {
//                dy = 2 * d0 - 2 * y2 - 1;
//                if (dy < 0) {
//                    x2++;
//                    d0 += 2 * x2 + 1;
//                } else if (dy > 0) {
//                    x2++;
//                    y2--;
//                    d0 += 2 * x2 - 2 * y2 + 2;
//                }
//            } else if (d0 > 0) {
//                dx = 2 * d0 - 2 * x2 - 1;
//                if (dx <= 0) {
//                    x2++;
//                    y2--;
//                    d0 += 2 * x2 - 2 * y2 + 2;
//                } else if (dx > 0) {
//                    y2--;
//                    d0 -= 2 * y2 + 1;
//                }
//            } else if (d0 == 0) {
//                x2++;
//                y2--;
//                d0 += 2 * x2 - 2 * y2 + 2;
//            }
//
//        }
//    }

    @Override
    public void drawArc(int x, int y, int width, int height, double startAngle, double arcAngle, Color c) {
        int _x = 0; // Компонента x
        int _y = height; // Компонента y
        int width_sqr = width * width; // a^2, a - большая полуось
        int height_sqr = height * height; // b^2, b - малая полуось
        int delta = 4 * height_sqr * ((_x + 1) * (_x + 1)) + width_sqr * ((2 * _y - 1) * (2 * _y - 1)) - 4 * width_sqr * height_sqr; // Функция координат точки (x+1, y-1/2)
        startAngle = Math.PI * startAngle / 180;
        arcAngle = Math.PI * arcAngle / 180;
        int xS = (int) (x + width / 2 * Math.cos(startAngle));
        int yS = (int) (y + height / 2 * Math.cos(startAngle));
        int xA = (int) (xS + width / 2 * Math.cos(arcAngle));
        int yA = (int) (yS + height / 2 * Math.cos(arcAngle));
        if (arcAngle == 0) {
            while (width_sqr * (2 * _y - 1) > 2 * height_sqr * (_x + 1)) {// Первая часть дуги
                pd.drawPixel(x + _x, y + _y, Color.BLUE);
                pd.drawPixel(x + _x, y - _y, Color.BLUE);
                pd.drawPixel(x - _x, y - _y, Color.BLUE);
                pd.drawPixel(x - _x, y + _y, Color.BLUE);
                if (delta < 0) {// Переход по горизонтали
                    _x++;
                    delta += 4 * height_sqr * (2 * _x + 3);
                } else {// Переход по диагонали
                    _x++;
                    delta = delta - 8 * width_sqr * (_y - 1) + 4 * height_sqr * (2 * _x + 3);
                    _y--;
                }
            }
            delta = height_sqr * ((2 * _x + 1) * (2 * _x + 1)) + 4 * width_sqr * ((_y + 1) * (_y + 1)) - 4 * width_sqr * height_sqr; // Функция координат точки (x+1/2, y-1)
            while (_y + 1 != 0) {// Вторая часть дуги, если не выполняется условие первого цикла, значит выполняется a^2(2y - 1) <= 2b^2(x + 1)
                pd.drawPixel(x + _x, y + _y, Color.BLUE);
                pd.drawPixel(x + _x, y - _y, Color.BLUE);
                pd.drawPixel(x - _x, y - _y, Color.BLUE);
                pd.drawPixel(x - _x, y + _y, Color.BLUE);
                if (delta < 0) { // Переход по вертикали
                    _y--;
                    delta += 4 * width_sqr * (2 * _y + 3);
                } else {// Переход по диагонали
                    _y--;
                    delta = delta - 8 * height_sqr * (_x + 1) + 4 * width_sqr * (2 * _y + 3);
                    _x++;
                }
            }
        } else {
            while (xS != xA) {
                while (width_sqr * (2 * yS - 1) > 2 * height_sqr * (xS + 1)) {// Первая часть дуги
                    pd.drawPixel(x + xS, y + yS, Color.BLUE);
                    pd.drawPixel(x + xS, y - yS, Color.BLUE);
                    pd.drawPixel(x - xS, y - yS, Color.BLUE);
                    pd.drawPixel(x - xS, y + yS, Color.BLUE);
                    if (delta < 0) {// Переход по горизонтали
                        xS++;
                        delta += 4 * height_sqr * (2 * xS + 3);
                    } else {// Переход по диагонали
                        xS++;
                        delta = delta - 8 * width_sqr * (yS - 1) + 4 * height_sqr * (2 * xS + 3);
                        yS--;
                    }
                }
                delta = height_sqr * ((2 * xS + 1) * (2 * xS + 1)) + 4 * width_sqr * ((yS + 1) * (yS + 1)) - 4 * width_sqr * height_sqr; // Функция координат точки (x+1/2, y-1)
                while (_y + 1 != 0) {// Вторая часть дуги, если не выполняется условие первого цикла, значит выполняется a^2(2y - 1) <= 2b^2(x + 1)
                    pd.drawPixel(x + xS, y + yS, Color.BLUE);
                    pd.drawPixel(x + xS, y - yS, Color.BLUE);
                    pd.drawPixel(x - xS, y - yS, Color.BLUE);
                    pd.drawPixel(x - xS, y + yS, Color.BLUE);
                    if (delta < 0) { // Переход по вертикали
                        yS--;
                        delta += 4 * width_sqr * (2 * yS + 3);
                    } else {// Переход по диагонали
                        yS--;
                        delta = delta - 8 * height_sqr * (xS + 1) + 4 * width_sqr * (2 * yS + 3);
                        xS++;
                    }
                }
            }
        }
    }

//    private void drawEllipse(Ellipse ellipse) {
//        int[] pos = ellipse.;
//        int lastX = 0;
//        for (int i = pos.length - 1; i >= 0; i--) {
//            while (lastX <= pos[i]) {
//                drawEllipsePixel;
//                if (i > 0 && pos[i - 1] == pos[i]) {
//                    break;
//                }
//                lastX++;
//            }
//
//        }
//    }
}
