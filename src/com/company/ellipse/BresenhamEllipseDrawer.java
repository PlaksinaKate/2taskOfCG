package com.company.ellipse;

import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamEllipseDrawer implements EllipseDrawer {
    private PixelDrawer pd;

    public BresenhamEllipseDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawEllipse(int x, int y, int width, int height) {
        int _x = 0; // Компонента x
        int _y = height; // Компонента y
        int width_sqr = width * width; // a^2, a - большая полуось
        int height_sqr = height * height; // b^2, b - малая полуось
        int delta = 4 * height_sqr * ((_x + 1) * (_x + 1)) + width_sqr * ((2 * _y - 1) * (2 * _y - 1)) - 4 * width_sqr * height_sqr; // Функция координат точки (x+1, y-1/2)
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
    }
}
