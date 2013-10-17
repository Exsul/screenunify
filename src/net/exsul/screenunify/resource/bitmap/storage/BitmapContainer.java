package net.exsul.screenunify.resource.bitmap.storage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import net.exsul.screenunify.resource.distortion.Distortion;
import net.exsul.screenunify.storage.GenericStorage;

public class BitmapContainer extends GenericStorage<BitmapDistortionStorage, Distortion> {
    private Resources resources;

    public BitmapContainer(Resources _resources) {
        resources = _resources;
    }

    @Deprecated
    private Distortion dist;
    @Deprecated
    boolean first;
    @Deprecated
    public BitmapContainer(Resources _resources, Distortion _dist) {
        resources = _resources;
        dist = _dist;
        first = true;
    }

    public Bitmap get( final Distortion d, final Integer id ) {
        BitmapStorage bs = get(d);
        return bs.get(id);
    }

    @Override
    protected BitmapDistortionStorage onKeyMiss( final Distortion d ) {
        if (!first)
            throw new UnsupportedOperationException("This hack wont work for multi distortion. issues/8");
        first = false;
        return new BitmapDistortionStorage(resources, dist);
    }
}
