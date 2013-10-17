package net.exsul.screenunify.resource.distortion;

public class NullDistortion extends Distortion {
    @Override
    public Object apply( final Object obj ) {
        return obj;
    }
}
