package net.exsul.screenunify.distortion.info;

import net.exsul.screenunify.distortion.managers.DistortionManager;

public class DistortionInfo {
    private DistortionInfo next;

    public void next( final DistortionInfo _next ) {
        if (next != null)
            next.next(_next);
        else
            next = _next;
    }

    public Object next( final Object obj ) {
        if (next == null)
            return obj;

        Object ret = next.apply(obj);
        return next.next(obj);
    }

    public Object apply( final Object obj ) {
        return DistortionManager.applyDistortion(obj, this);
    }
}
