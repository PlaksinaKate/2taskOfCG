package com.company.pie;

import com.company.PieDrawer;
import com.company.PixelDrawer;

public interface PieDrawerFactoryByPixelDrawer {
    PieDrawer createInstance(PixelDrawer pd);
}

