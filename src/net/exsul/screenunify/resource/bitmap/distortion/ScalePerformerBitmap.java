package net.exsul.screenunify.resource.bitmap.distortion;

import android.graphics.Bitmap;
import net.exsul.screenunify.performer.ScalePerformer;

public class ScalePerformerBitmap extends ScalePerformer<Bitmap> {
    @Override
    public Bitmap apply( final Bitmap origin ) {
        int newW = (int)(origin.getWidth() * info.xMultipier);
        int newH = (int)(origin.getHeight() * info.yMultiplier);

        return Bitmap.createScaledBitmap(origin, newH, newW, true);
    }
}
