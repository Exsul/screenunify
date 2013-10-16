package net.exsul.screenunify.bitmap;

import android.graphics.Bitmap;

public class BitmapInfo {
    public final int w, h;
    public final boolean rotated;

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

    /**
     * Функция получения виртуальной ширины битмапа.
     *
     * @return виртуальная ширина битмапа.
     */
    public int w() {
        return w;
    }

    /**
     * Функция получения виртуальной высоты битмапа.
     *
     * @return виртуальная высота битмапа.
     */
    public int h() {
        return h;
    }

    /**
     * Функция получения информации о том, был ли битмап повернут.
     *
     * @return true, если была повернут, false иначе.
     */
    public boolean rotated() {
        return rotated;
    }
}
