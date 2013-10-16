package net.exsul.screenunify.manager;

import net.exsul.screenunify.bitmap.BitmapContainer;

public class BitmapsCore {
    // TODO: Replace Integer with valid distortion container
    protected BitmapContainer<Integer> db;
    private static BitmapsCore core;

    public static BitmapsCore getInstance() {
        if (core == null)
            core = new BitmapsCore();
        return core;
    }
}
