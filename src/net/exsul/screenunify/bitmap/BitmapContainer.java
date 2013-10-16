package net.exsul.screenunify.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import net.exsul.screenunify.storage.GenericStorage;

public class BitmapContainer<DistortionInfo> extends GenericStorage<BitmapStorage, DistortionInfo> {
    private Resources resources;

    public BitmapContainer(Resources _resources) {
        resources = _resources;
    }

    public Bitmap get( final DistortionInfo d, final Integer id ) {
        BitmapStorage bs = get(d);
        return bs.get(id);
    }

    @Override
    public BitmapStorage onKeyMiss( final DistortionInfo d ) {
        return new BitmapStorage(resources);
    }
}
