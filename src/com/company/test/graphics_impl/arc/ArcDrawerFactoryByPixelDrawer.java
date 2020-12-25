package com.company.test.graphics_impl.arc;

import com.company.test.ArcDrawer;
import com.company.test.PixelDrawer;

public interface ArcDrawerFactoryByPixelDrawer {
    ArcDrawer createInstance(PixelDrawer pd);
}
