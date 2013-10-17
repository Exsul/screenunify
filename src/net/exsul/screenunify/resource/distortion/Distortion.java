package net.exsul.screenunify.resource.distortion;

import net.exsul.screenunify.resource.distortion.managers.DistortionManager;

public class Distortion {
    private Distortion next;

    public void next( final Distortion _next ) {
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

    public <T> T apply( final Object obj ) {
        return (T)DistortionManager.applyDistortion(obj, this);
    }
}
