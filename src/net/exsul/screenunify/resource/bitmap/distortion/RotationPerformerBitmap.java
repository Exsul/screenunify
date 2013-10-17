package net.exsul.screenunify.resource.bitmap.distortion;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import net.exsul.screenunify.performer.RotationPerformer;

public class RotationPerformerBitmap extends RotationPerformer<Bitmap> {
    @Override
    public Bitmap apply( final Bitmap origin ) {
        Matrix matrix = new Matrix();

        matrix.postRotate(info.value);

        Bitmap rotatedBitmap = Bitmap.createBitmap(origin, 0, 0, origin.getWidth(), origin.getHeight(), matrix, true);

        return rotatedBitmap;
    }
}
