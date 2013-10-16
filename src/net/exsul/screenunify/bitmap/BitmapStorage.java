package net.exsul.screenunify.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import net.exsul.screenunify.storage.ResourceStorage;

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
