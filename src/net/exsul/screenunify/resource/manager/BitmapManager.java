package net.exsul.screenunify.resource.manager;

import android.graphics.Bitmap;
import net.exsul.screenunify.storage.AbstractStorage;
import net.exsul.screenunify.resource.distortion.Distortion;

public class BitmapManager implements AbstractStorage<Bitmap, Integer> {
    private Distortion distortion;

    public BitmapManager( final BitmapManagerConstructor c ) {
        // TODO: Initialise manager
        throw new UnsupportedOperationException("Need contruction implement");
    }

    public Bitmap get( final Integer id ) {
        return BitmapsCore.getInstance().db().get(distortion, id);
    }

    public Bitmap put( final Integer id, final Bitmap t ) {
        throw new UnsupportedOperationException("You dont need to put something in BitmapManager");
    }
}
