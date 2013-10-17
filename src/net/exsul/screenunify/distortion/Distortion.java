package net.exsul.screenunify.distortion;

public abstract class Distortion<T> {
    private Distortion<T> next;

    public T apply( final T obj ) {
        return next(obj);
    }

    public void next( final Distortion<T> _next ) {
        if (next != null)
            next.next(_next);
        else
            next = _next;
    }

    public T next( final T obj ) {
        if (next == null)
            return obj;

        T ret = next.apply(obj);
        return next.next(obj);
    }
}
