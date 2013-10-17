package net.exsul.screenunify.resource.manager;

import android.content.res.Resources;
import android.graphics.Bitmap;
import net.exsul.screenunify.resource.bitmap.storage.BitmapContainer;
import net.exsul.screenunify.resource.bitmap.distortion.RotationPerformerBitmap;
import net.exsul.screenunify.resource.distortion.Distortion;
import net.exsul.screenunify.resource.distortion.NullDistortion;
import net.exsul.screenunify.resource.distortion.RotationDistortion;
import net.exsul.screenunify.resource.distortion.managers.DistortionPerformerChooser;
import net.exsul.screenunify.metrics.Metrics;

public class BitmapsCore {
    private BitmapContainer db;
    private static BitmapsCore core;

    BitmapsCore() {
      InitDistortion();
    }

    private void InitDistortion() {
        DistortionPerformerChooser<Bitmap> ret = new DistortionPerformerChooser<Bitmap>();
        ret.put(RotationDistortion.class, new RotationPerformerBitmap());
    }

    BitmapContainer db() {
        assert(db != null);
        return db;
    }

    public static void initDB( Resources _resources ) {
        BitmapsCore core = getInstance();
        if (core.db != null)
            return;
        getInstance().db = new BitmapContainer(_resources, core.defaultDistortion());
    }

    static BitmapsCore getInstance() {
        if (core == null)
            core = new BitmapsCore();
        return core;
    }

    @Deprecated
    private Metrics screenMetrics;

    @Deprecated
    public void initMetrics( final Metrics metrics ) {
        screenMetrics = metrics;
    }

    @Deprecated
    public Distortion defaultDistortion() {
        assert(screenMetrics != null);
        Distortion ret = new NullDistortion();

        /* TODO: Scaling bitmap as you want
        int newW = (int)(screenMetrics.w() * nw);
        int newH = (int)(bitmapInfoDeprecated.h() * screenMetrics.w() * nw / bitmapInfoDeprecated.w());

        ret.next(new ScaleDistortionBitmap())
        scaledBitmap = Bitmap.createScaledBitmap(bitmapInfoDeprecated.bitmap(), newW, newH, true);
        */
        if (screenMetrics.w() < screenMetrics.h())
            ret.next(new RotationDistortion(90));
        return ret;
    }
}
