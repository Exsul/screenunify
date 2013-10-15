package bsiapi.storage;

public class ResourceStorage<T> extends GenericStorage<T> {
    @Override
    public T get( final Integer id ) {
        T cache = super.get(id);
        assert(cache != null); // TODO: Make resource autoload
        return cache;
    }
}
