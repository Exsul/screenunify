package net.exsul.screenunify.distortion;

public class NullDistortion<T> extends Distortion<T>  {
    public T apply( final T obj ) {
        return obj;
    }
}
