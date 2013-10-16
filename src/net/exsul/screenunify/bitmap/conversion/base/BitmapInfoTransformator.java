package net.exsul.screenunify.bitmap.conversion.base;

import net.exsul.screenunify.bitmap.BitmapInfo_deprecated;

/**
 * Класс преобразования информации о битмапе.
 *
 * @author bsi
 */
@Deprecated
public abstract class BitmapInfoTransformator {
    /**
     * Функция преобразования информации о битмапе.
     *
     * @param bitmapInfoDeprecated битмап для преобразования.
     *
     * @return преобразованный битмап.
     */
    public abstract BitmapInfo_deprecated convert(final BitmapInfo_deprecated bitmapInfoDeprecated);
}
