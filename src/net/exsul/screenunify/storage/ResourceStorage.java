package net.exsul.screenunify.storage;

public class ResourceStorage<T> extends GenericStorage<T, Integer> {
    @Override
    public T get( final Integer id ) {
        T cache = super.get(id);
        assert(cache != null);
        return cache;
    }

    @Override
    public T onKeyMiss( final Integer id ) {
        return load(id);
    }

    public T load( final int id ) {
       throw new UnsupportedOperationException(
               "Resource load generic method is obvious, you should overload " +
               "ResourceStorage<T> loadById with template specification");
    }
}
