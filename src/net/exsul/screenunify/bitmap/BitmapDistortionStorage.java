package net.exsul.screenunify.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import net.exsul.screenunify.distortion.info.DistortionInfo;

public class BitmapDistortionStorage extends BitmapStorage {
    private DistortionInfo distortion;
    public BitmapDistortionStorage( final Resources _resources, final DistortionInfo distortion ) {
        super(_resources);
    }

    @Override
    protected Bitmap load( final int id ) {
        Bitmap t = super.load(id);
        // TODO: make distortion
        return t;
    }
}
