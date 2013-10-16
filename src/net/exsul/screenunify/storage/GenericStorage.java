package net.exsul.screenunify.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Enelar
 * Date: 16.10.13
 * Time: 0:19
 * To change this template use File | Settings | File Templates.
 */
public class GenericStorage<T, K> {
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
