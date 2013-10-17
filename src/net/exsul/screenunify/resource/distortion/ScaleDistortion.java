package net.exsul.screenunify.resource.distortion;

public class ScaleDistortion extends Distortion {
    public float xMultipier, yMultiplier;

    public ScaleDistortion( final float xScale, final float yScale ) {
        update(xScale, yScale);
    }

    public ScaleDistortion( final float Scale ) {
        update(Scale);
    }

    public ScaleDistortion update( final float xScale, final float yScale ) {
        xMultipier = xScale;
        yMultiplier = yScale;
        return this;
    }

    public ScaleDistortion update( final float Scale ) {
        return update(Scale, Scale);
    }

    public <T> T apply( final T obj, final float xScale, final float yScale ) {
        update(xScale, yScale);
        return apply(obj);
    }

    public <T> T apply( final T obj, final float Scale ) {
        return apply(obj, Scale);
    }
}
