package net.exsul.screenunify.distortion;

public class NullDistortion extends Distortion {
    @Override
    public Object apply( final Object obj ) {
        return obj;
    }
}
