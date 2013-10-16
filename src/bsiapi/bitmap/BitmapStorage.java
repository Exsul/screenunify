package bsiapi.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import bsiapi.storage.ResourceStorage;

public class BitmapStorage extends ResourceStorage<Bitmap> {
    private final Resources resources;

    public BitmapStorage( final Resources _resources ) {
        super();
        resources = _resources;
    }

    @Override
    public Bitmap load( final int id ) {
        return BitmapFactory.decodeResource(resources, id);
    }
}
