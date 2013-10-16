package net.exsul.screenunify.storage;

public interface AbstractStorage<T, K> {
    public T put( final K id, final T resource );
    public T get( final K id );
}
