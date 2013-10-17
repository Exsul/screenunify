package net.exsul.screenunify.resource.bitmap.storage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import net.exsul.screenunify.resource.distortion.Distortion;
import net.exsul.screenunify.performer.Performer;

public class BitmapDistortionStorage extends BitmapStorage {
    private Distortion distortion;

    public BitmapDistortionStorage(final Resources _resources, final Distortion _distortion) {
        super(_resources);
        distortion = _distortion;
        throw new UnsupportedOperationException("This implementation need conclusion at issues/8");
    }

    @Deprecated
    private Performer dist;

    @Deprecated
    public BitmapDistortionStorage(final Resources _resources, final Performer _performer) {
        super(_resources);
        dist = _performer;
    }


    @Override
    protected Bitmap load(final int id) {
        Bitmap t = super.load(id);
        return distortion.apply(t);
    }
}
