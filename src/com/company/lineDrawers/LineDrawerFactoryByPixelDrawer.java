package com.company.lineDrawers;

import com.company.PixelDrawer;

public interface LineDrawerFactoryByPixelDrawer {
    LineDrawer createInstance(PixelDrawer pd);
}
