package com.company.arc;

import com.company.PixelDrawer;

public interface ArcDrawerFactoryByPixelDrawer {
    ArcDrawer createInstance(PixelDrawer pd);
}
