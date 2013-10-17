package net.exsul.screenunify.resource.distortion;

public class RotationDistortion extends Distortion {
    public float value;

    public RotationDistortion(final float angle) {
        update(angle);
    }

    public RotationDistortion update( final float angle ) {
        value = angle;
        return this;
    }

    public <T> T apply( final T obj, final float angle ) {
        update(angle);
        return apply(obj);
    }
}
