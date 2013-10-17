package net.exsul.screenunify.performer;

public class NullPerformer<T> extends Performer<T> {
    public T apply( final T obj ) {
        return obj;
    }
}
