package net.exsul.screenunify.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import net.exsul.screenunify.distortion.Distortion;
import net.exsul.screenunify.distortion.info.DistortionInfo;

public class BitmapDistortionStorage extends BitmapStorage {
    private DistortionInfo distortion;

    public BitmapDistortionStorage(final Resources _resources, final DistortionInfo _distortion) {
        super(_resources);
        distortion = _distortion;
        throw new UnsupportedOperationException("This implementation need conclusion at issues/8");
    }

    @Deprecated
    private Distortion<Bitmap> dist;

    @Deprecated
    public BitmapDistortionStorage(final Resources _resources, final Distortion<Bitmap> _distortion) {
        super(_resources);
        dist = _distortion;
    }


    @Override
    protected Bitmap load(final int id) {
        Bitmap t = super.load(id);
        return dist.apply(t);
    }
}
