package net.exsul.screenunify.bitmap.distortion;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import net.exsul.screenunify.distortion.RotationDistortion;
import net.exsul.screenunify.distortion.info.RotationDistortionInfo;

public class RotationDistortionBitmap extends RotationDistortion<Bitmap> {
    public RotationDistortionBitmap( final RotationDistortionInfo a ) {
        super(a);
    }
    @Override
    public Bitmap apply( final Bitmap origin ) {
        Matrix matrix = new Matrix();

        matrix.postRotate(info.value);

        Bitmap rotatedBitmap = Bitmap.createBitmap(origin, 0, 0, origin.getWidth(), origin.getHeight(), matrix, true);

        return rotatedBitmap;
    }
}
