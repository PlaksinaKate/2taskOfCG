package com.company.test.graphics_impl;


import com.company.test.*;
import com.company.test.graphics_impl.arc.ArcDrawerFactoryByPixelDrawer;
import com.company.test.graphics_impl.arc.GraphicsArcDrawer;
import com.company.test.graphics_impl.line.GraphicsLineDrawer;
import com.company.test.graphics_impl.line.LineDrawerFactoryByPixelDrawer;
import com.company.test.graphics_impl.pie.GraphicsPieDrawer;
import com.company.test.graphics_impl.pie.GraphicsPieFiller;
import com.company.test.graphics_impl.pie.PieDrawerFactoryByPixelDrawer;
import com.company.test.graphics_impl.pie.PieFillerFactoryByPixelDrawer;

public class PrimitivesFactoryWithDefaultGraphicsImplementation {

    public final LineDrawer createLineDrawer(GraphicsProvider gp) {
        LineDrawerFactoryByPixelDrawer factory = getCustomLineDrawerFactory();
        if (factory != null)
            return factory.createInstance(new GraphicsPixelDrawer(gp));
        return new GraphicsLineDrawer(gp);
    }

    public final ArcDrawer createArcDrawer(GraphicsProvider gp) {
        ArcDrawerFactoryByPixelDrawer factory = getCustomArcDrawerFactory();
        if (factory != null)
            return factory.createInstance(new GraphicsPixelDrawer(gp));
        return new GraphicsArcDrawer(gp);
    }

    public final PieDrawer createPieDrawer(GraphicsProvider gp) {
        PieDrawerFactoryByPixelDrawer factory = getCustomPieDrawerFactory();
        if (factory != null)
            return factory.createInstance(new GraphicsPixelDrawer(gp));
        return new GraphicsPieDrawer(gp);
    }

    public final PieFiller createPieFiller(GraphicsProvider gp) {
        PieFillerFactoryByPixelDrawer factory = getCustomPieFillerFactory();
        if (factory != null)
            return factory.createInstance(new GraphicsPixelDrawer(gp));
        return new GraphicsPieFiller(gp);
    }

    protected ArcDrawerFactoryByPixelDrawer getCustomArcDrawerFactory() {
        return null;
    }
    protected PieDrawerFactoryByPixelDrawer getCustomPieDrawerFactory() {
        return null;
    }
    protected PieFillerFactoryByPixelDrawer getCustomPieFillerFactory() {
        return null;
    }
    protected LineDrawerFactoryByPixelDrawer getCustomLineDrawerFactory() {
        return null;
    }
}
