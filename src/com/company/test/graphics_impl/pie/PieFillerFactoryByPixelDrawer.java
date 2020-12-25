package com.company.test.graphics_impl.pie;

import com.company.test.PieFiller;
import com.company.test.PixelDrawer;

public interface PieFillerFactoryByPixelDrawer {
    PieFiller createInstance(PixelDrawer pd);
}

