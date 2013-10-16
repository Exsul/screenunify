package net.exsul.screenunify.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapDistortionStorage extends BitmapStorage {
    private Integer distortion;
    public BitmapDistortionStorage( final Resources _resources, final Integer distortion ) {
        super(_resources);
    }

    @Override
    public Bitmap load( final int id ) {
        Bitmap t = super.load(id);
        // TODO: make distortion
        return t;
    }
}
