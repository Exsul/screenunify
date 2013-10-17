package net.exsul.screenunify.resource.bitmap;

import android.graphics.Bitmap;

public class BitmapInfo {
    public int w, h;
    public boolean rotated;

    public BitmapInfo(final Bitmap bitmap) {
        this(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
    }

    /**
     * Конструктор класса.
     *
     * @param bitmap битмап.
     * @param w виртуальная ширина битмапа.
     * @param h виртуальная высота битмапа.
     * @param rotated был ли битмап повернут.
     */
    public BitmapInfo(final Bitmap bitmap, final int w, final int h, final boolean rotated) {
        this.w = w;
        this.h = h;
        this.rotated = rotated;
    }
}
