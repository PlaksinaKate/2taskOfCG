package com.company.test.graphics_impl.line;

import com.company.test.LineDrawer;
import com.company.test.PixelDrawer;

public interface LineDrawerFactoryByPixelDrawer {
    LineDrawer createInstance(PixelDrawer pd);
}