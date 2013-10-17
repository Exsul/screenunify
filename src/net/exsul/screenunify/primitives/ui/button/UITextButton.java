package net.exsul.screenunify.primitives.ui.button;

import android.graphics.Paint;
import android.graphics.Rect;
import net.exsul.screenunify.resource.bitmap.BitmapInfo_deprecated;
import net.exsul.screenunify.coords.Coordinate;
import net.exsul.screenunify.drawer.Drawer;
import net.exsul.screenunify.primitives.text.Text;
import net.exsul.screenunify.primitives.ui.element.UIElementTouchListener;

/**
 * Класс, описывающий кнопку, содержащую текст.
 *
 * @author bsi
 */
public class UITextButton extends UIButton {
    private final Text text;
    private final Paint textPaint;

    /**
     * Конструктор класса.
     *
     * @param touchListener объект реакции на нажатие.
     * @param bitmapFree битмап, отрисовывающийся, когда кнопка не нажата.
     * @param bitmapPressed  битмап, отрисовывающийся, когда кнопка нажата.
     * @param vc виртуальные координаты кнопки.
     * @param text текст для отрисовки.
     * @param textPaint стиль отрисовки текста.
     */
    public UITextButton(final UIElementTouchListener touchListener, final BitmapInfo_deprecated bitmapFree, final BitmapInfo_deprecated bitmapPressed, final Coordinate vc, final Text text, final Paint textPaint) {
        super(touchListener, bitmapFree, bitmapPressed, vc);

        this.text = text;
        this.textPaint = textPaint;
    }

    @Override
    public void draw(final Drawer drawer) {
        super.draw(drawer);

        Rect textBounds = new Rect();
        textPaint.getTextBounds(text.getText(), 0, text.getText().length(), textBounds);

        double textW = (textBounds.right - textBounds.left) * text.getSizeMultiplier();
        double textH = (textBounds.bottom - textBounds.top) * text.getSizeMultiplier();

        Coordinate textVC = new Coordinate(vc.x() + (bitmapVW() - textW) / 2, vc.y() + (bitmapVH() - textH) / 2);

        drawer.drawText(text, textVC, textPaint);
    }
}
