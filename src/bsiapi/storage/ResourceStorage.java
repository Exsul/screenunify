package bsiapi.storage;

public class ResourceStorage<T> extends GenericStorage<T> {
    @Override
    public T get( final Integer id ) {
        T cache = super.get(id);
        if (cache == null)
            cache = super.put(id, loadById(id));
        assert(cache != null);
        return cache;
    }

    public T loadById( final int id ) {
       throw new UnsupportedOperationException(
               "Resource load generic method is obvious, you should overload " +
               "ResourceStorage<T> loadById with template specification");
    }
}
