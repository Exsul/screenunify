package net.exsul.screenunify.manager;

import android.content.res.Resources;
import net.exsul.screenunify.bitmap.BitmapContainer;

public class BitmapsCore {
    private BitmapContainer db;
    private static BitmapsCore core;

    BitmapContainer db() {
        assert(db != null);
        return db;
    }

    public static void initDB( Resources _resources ) {
        BitmapsCore core = getInstance();
        if (core.db != null)
            return;
        getInstance().db = new BitmapContainer(_resources);
    }

    static BitmapsCore getInstance() {
        if (core == null)
            core = new BitmapsCore();
        return core;
    }
}
