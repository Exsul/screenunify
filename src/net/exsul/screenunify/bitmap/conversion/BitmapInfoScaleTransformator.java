package net.exsul.screenunify.bitmap.conversion;


import android.graphics.Bitmap;
import net.exsul.screenunify.bitmap.BitmapInfo_deprecated;
import net.exsul.screenunify.bitmap.conversion.base.BitmapInfoTransformator;
import net.exsul.screenunify.bitmap.conversion.base.BitmapInfoTransformatorDecorator;
import net.exsul.screenunify.metrics.Metrics;

/**
 * Класс преобразования информации о битмапе.
 * Изменяет размеры битмапа до заданных в процентах от ширины экрана. Высота изменится пропорционально.
 *
 * @author bsi
 */
@Deprecated
public final class BitmapInfoScaleTransformator extends BitmapInfoTransformatorDecorator {
    private final Metrics screenMetrics;

    private double nw = 1.0;

    /**
     * Конструктор класса.
     *
     * @param bitmapInfoTransformator внутренний преобразователь битмапа. Полученные преобразования будут наложены на преобразования внутреннего преобразователя.
     * @param screenMetrics размеры экрана.
     */
    public BitmapInfoScaleTransformator(final BitmapInfoTransformator bitmapInfoTransformator, final Metrics screenMetrics) {
        super(bitmapInfoTransformator);

        this.screenMetrics = screenMetrics;
    }

    /**
     * Функция установки новой ширины битмапа в процентах от ширины экрана.
     *
     * @param nw новая ширина битмапа в процентах от ширины экрана.
     */
    public void setNewWidth(final double nw) {
        this.nw = nw;
    }

    @Override
    protected BitmapInfo_deprecated convertInner(final BitmapInfo_deprecated bitmapInfoDeprecated) {
        int newW = (int)(screenMetrics.w() * nw);
        int newH = (int)(bitmapInfoDeprecated.h() * screenMetrics.w() * nw / bitmapInfoDeprecated.w());

        final Bitmap scaledBitmap;

        if (bitmapInfoDeprecated.rotated()) {
            scaledBitmap = Bitmap.createScaledBitmap(bitmapInfoDeprecated.bitmap(), newH, newW, true);
        } else {
            scaledBitmap = Bitmap.createScaledBitmap(bitmapInfoDeprecated.bitmap(), newW, newH, true);
        }

        return new BitmapInfo_deprecated(scaledBitmap, newW, newH, bitmapInfoDeprecated.rotated());
    }
}