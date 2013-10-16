package net.exsul.screenunify.distortion;

public abstract class Distortion<T> {
    public abstract T apply( final T obj );
}
