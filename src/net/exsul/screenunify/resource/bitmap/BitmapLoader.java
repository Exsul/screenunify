package net.exsul.screenunify.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import net.exsul.screenunify.resource.bitmap.conversion.base.BitmapInfoTransformator;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс загрузки битмапов.
 *
 * @author bsi
 */
@Deprecated
public final class BitmapLoader {
    private final Resources resources;

    private final Map<Integer, BitmapInfo_deprecated> bitmapsInfo = new HashMap<Integer, BitmapInfo_deprecated>();

    /**
     * Конструктор класса.
     *
     * @param resources медиа-ресурсы приложения.

     */
    BitmapLoader(final Resources resources) {
        this.resources = resources;
    }

    /**
     * Функция загрузки битмапаю
     *
     * @param id идентификатор ресурса битмапа.
     * @param bitmapInfoTransformator преобразователь информации о битмапе.
     */
    public void load(final int id, final BitmapInfoTransformator bitmapInfoTransformator) {
        Bitmap bitmap = BitmapFactory.decodeResource(resources, id);

        bitmapsInfo.put(id, bitmapInfoTransformator.convert(new BitmapInfo_deprecated(bitmap)));
    }

    /**
     * Функция получения информации о загруженном битмапе.
     *
     * @param id идентификатор ресурса битмапа.
     *
     * @return информация о загруженном битмапе.
     */
    public BitmapInfo_deprecated get(final int id) {
        return bitmapsInfo.get(id);
    }
}