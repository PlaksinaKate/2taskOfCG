package com.company;

import com.company.arc.ArcDrawer;
import com.company.arc.ArcDrawerFactoryByPixelDrawer;
import com.company.arc.GraphicsArcDrawer;
import com.company.lineDrawers.GraphicsLineDrawer;
import com.company.lineDrawers.LineDrawer;
import com.company.lineDrawers.LineDrawerFactoryByPixelDrawer;
import com.company.pie.GraphicsPieDrawer;
import com.company.pie.GraphicsPieFiller;
import com.company.pie.PieDrawerFactoryByPixelDrawer;
import com.company.pie.PieFillerFactoryByPixelDrawer;

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
