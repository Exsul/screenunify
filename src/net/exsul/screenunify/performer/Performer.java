package net.exsul.screenunify.performer;

public abstract class Performer<T> {
    private Performer next;

    public abstract T apply( final T obj );

    public void update( final net.exsul.screenunify.distortion.Distortion obj ) {

    }
}
