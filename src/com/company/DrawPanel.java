package com.company;

import com.company.arc.ArcDrawer;
import com.company.arc.BresenhamArcDrawer;
import com.company.lineDrawers.*;
import com.company.ellipse.BresenhamEllipseDrawer;
import com.company.ellipse.EllipseDrawer;
import com.company.utills.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);
    private PixelDrawer pd;

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.BLACK);
        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        //pd = new GraphicsPixelDrawer(bi_g);
        //LineDrawer lineDrawer = new DDALineDrawer(pd);
        //LineDrawer lineDrawer = new BresenhamLineDrawer(pd);
        LineDrawer lineDrawer = new WuLineDrawer(pd);
        EllipseDrawer ellipseDrawer = new BresenhamEllipseDrawer(pd);
        ArcDrawer arcDrawer = new BresenhamArcDrawer(pd);
        drawAll(lineDrawer);
        drawOval(ellipseDrawer);
        drawArc(arcDrawer);
        //ArcDrawer arcDrawer = new BresenhamArcDrawer(pd);
        //arcDrawer.drawArc(getWidth()/2, getHeight() / 2, 100, 100, 0, 80);
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll(LineDrawer lineDrawer) {
        DrawUtils.drawSnowflake(lineDrawer, getWidth() / 2 - 200, getHeight() / 2 - 50, 100, 64);
        lineDrawer.drawLine(getWidth() / 2, getHeight() / 2, position.x, position.y, Color.BLUE);
    }

    private void drawOval(EllipseDrawer ellipseDrawer) {
        ellipseDrawer.drawEllipse(getWidth() / 2 + 200, getHeight() / 2 - 50, 200, 100);
    }

    private void drawArc(ArcDrawer arcDrawer) {
        arcDrawer.drawArc(getWidth() / 2 + 200, getHeight() / 2 - 100, 100, 100, 0, 90, Color.BLUE);
    }

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}

