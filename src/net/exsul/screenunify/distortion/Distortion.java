package net.exsul.screenunify.distortion;

import net.exsul.screenunify.distortion.info.DistortionInfo;

public abstract class Distortion<T> {
    private Distortion<T> next;

    public abstract T apply( final T obj );

    public void update( final DistortionInfo obj ) {

    }
}
