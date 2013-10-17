package net.exsul.screenunify.manager;

import android.content.res.Resources;
import android.graphics.Bitmap;
import net.exsul.screenunify.bitmap.BitmapContainer;
import net.exsul.screenunify.bitmap.distortion.RotationDistortionBitmap;
import net.exsul.screenunify.distortion.Distortion;
import net.exsul.screenunify.distortion.NullDistortion;
import net.exsul.screenunify.distortion.info.DistortionInfo;
import net.exsul.screenunify.distortion.info.NullDistortionInfo;
import net.exsul.screenunify.distortion.info.RotationDistortionInfo;
import net.exsul.screenunify.distortion.managers.DistortionPerformerChooser;
import net.exsul.screenunify.metrics.Metrics;

public class BitmapsCore {
    private BitmapContainer db;
    private static BitmapsCore core;

    BitmapsCore() {
      InitDistortion();
    }

    private void InitDistortion() {
        DistortionPerformerChooser<Bitmap> ret = new DistortionPerformerChooser<Bitmap>();
        ret.put(RotationDistortionInfo.class, new RotationDistortionBitmap());
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
    public DistortionInfo defaultDistortion() {
        assert(screenMetrics != null);
        DistortionInfo ret = new NullDistortionInfo();

        /* TODO: Scaling bitmap as you want
        int newW = (int)(screenMetrics.w() * nw);
        int newH = (int)(bitmapInfoDeprecated.h() * screenMetrics.w() * nw / bitmapInfoDeprecated.w());

        ret.next(new ScaleDistortionBitmap())
        scaledBitmap = Bitmap.createScaledBitmap(bitmapInfoDeprecated.bitmap(), newW, newH, true);
        */
        if (screenMetrics.w() < screenMetrics.h())
            ret.next(new RotationDistortionInfo(90));
        return ret;
    }
}
