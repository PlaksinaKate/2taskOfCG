package com.company.pie;

import com.company.PieFiller;
import com.company.PixelDrawer;

public interface PieFillerFactoryByPixelDrawer {
    PieFiller createInstance(PixelDrawer pd);
}
