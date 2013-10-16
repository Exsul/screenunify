package net.exsul.screenunify.bitmap.conversion;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import net.exsul.screenunify.bitmap.BitmapInfo_deprecated;
import net.exsul.screenunify.bitmap.conversion.base.BitmapInfoTransformator;
import net.exsul.screenunify.bitmap.conversion.base.BitmapInfoTransformatorDecorator;
import net.exsul.screenunify.metrics.Metrics;

/**
 * Класс преобразования информации о битмапе.
 * Если ширина экрана больше высоты, то трансформация не производится. Иначе, битмап поворачивается против часовой стрелки на 90 градусов.
 *
 * @author bsi
 */
public final class BitmapInfoRotationTransformator extends BitmapInfoTransformatorDecorator {
    private final Metrics screenMetrics;

    /**
     * Конструктор класса.
     *
     * @param screenMetrics размеры экрана.
     */
    public BitmapInfoRotationTransformator(final Metrics screenMetrics) {
        this.screenMetrics = screenMetrics;
    }

    /**
     * Конструктор класса.
     *
     * @param bitmapInfoTransformator внутренний преобразователь битмапа. Полученные преобразования будут наложены на преобразования внутреннего преобразователя.
     * @param screenMetrics размеры экрана.
     */
    public BitmapInfoRotationTransformator(final BitmapInfoTransformator bitmapInfoTransformator, final Metrics screenMetrics) {
        super(bitmapInfoTransformator);

        this.screenMetrics = screenMetrics;
    }

    @Override
    protected BitmapInfo_deprecated convertInner(final BitmapInfo_deprecated bitmapInfoDeprecated) {
        if (screenMetrics.w() >= screenMetrics.h()) {
            return bitmapInfoDeprecated;
        } else {
            Matrix matrix = new Matrix();

            matrix.postRotate(-90);

            Bitmap rotatedBitmap = Bitmap.createBitmap(bitmapInfoDeprecated.bitmap(), 0, 0, bitmapInfoDeprecated.w(), bitmapInfoDeprecated.h(), matrix, true);

            return new BitmapInfo_deprecated(rotatedBitmap, bitmapInfoDeprecated.w(), bitmapInfoDeprecated.h(), !bitmapInfoDeprecated.rotated());
        }
    }
}
