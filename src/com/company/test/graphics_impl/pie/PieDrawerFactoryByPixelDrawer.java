package com.company.test.graphics_impl.pie;

import com.company.test.PieDrawer;
import com.company.test.PixelDrawer;

public interface PieDrawerFactoryByPixelDrawer {
    PieDrawer createInstance(PixelDrawer pd);
}
