package net.exsul.screenunify.storage;

import java.util.HashMap;
import java.util.Map;

public class GenericStorage<T, K> implements AbstractStorage<T, K> {
    private Map<K, T> store = new HashMap<K, T>();

    public T put( final K id, final T resource ) {
       store.put(id, beforeResourceStored(resource));
       return resource;
    }

    public T get( final K id ) {
       T cache = store.get(id);
       if (cache == null) {
           T new_value = onKeyMiss(id);
           if (new_value != null)
               cache = put(id, new_value);
       }
       return cache;
    }

    public T get( final K id, final T resource ) {
       T cache = get(id);
       if (cache == null)
           cache = put(id, resource);
       return cache;
    }

    public T beforeResourceStored( final T resource ) {
        return resource;
    }

    public T onKeyMiss( final K id ) {
        return null;
    }
}
