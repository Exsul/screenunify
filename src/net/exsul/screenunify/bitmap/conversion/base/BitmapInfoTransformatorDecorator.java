package net.exsul.screenunify.bitmap.conversion.base;

import net.exsul.screenunify.bitmap.BitmapInfo_deprecated;

/**
 * Декоратор класса преобразования информации о битмапе.
 *
 * @author bsi
 */
public abstract class BitmapInfoTransformatorDecorator extends BitmapInfoTransformator {
    private final BitmapInfoTransformator bitmapInfoTransformator;

    /**
     * Конструктор класса.
     */
    protected BitmapInfoTransformatorDecorator() {
        this.bitmapInfoTransformator = null;
    }

    /**
     * Конструктор класса.
     *
     * @param bitmapInfoTransformator внутренний преобразователь битмапа. Полученные преобразования будут наложены на преобразования внутреннего преобразователя.
     */
    protected BitmapInfoTransformatorDecorator(final BitmapInfoTransformator bitmapInfoTransformator) {
        this.bitmapInfoTransformator = bitmapInfoTransformator;
    }

    @Override
    public final BitmapInfo_deprecated convert(final BitmapInfo_deprecated bitmapInfoDeprecated) {
        if (bitmapInfoTransformator == null) {
            return convertInner(bitmapInfoDeprecated);
        }

        return convertInner(bitmapInfoTransformator.convert(bitmapInfoDeprecated));
    }

    /**
     * Функция преобразования информации о битмапе.
     *
     * @param bitmapInfoDeprecated битмап для преобразования.
     *
     * @return преобразованный битмап.
     */
    protected abstract BitmapInfo_deprecated convertInner(final BitmapInfo_deprecated bitmapInfoDeprecated);
}
