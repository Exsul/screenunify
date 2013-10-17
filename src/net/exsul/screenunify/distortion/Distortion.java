package net.exsul.screenunify.distortion;

public interface Distortion<T> {
    public T apply( final T obj );
}
