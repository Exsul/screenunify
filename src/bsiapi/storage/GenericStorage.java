package bsiapi.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Enelar
 * Date: 16.10.13
 * Time: 0:19
 * To change this template use File | Settings | File Templates.
 */
public class GenericStorage<T> {
    private Map<Integer, T> store = new HashMap<Integer, T>();

    public T put( final Integer id, final T resource ) {
       store.put(id, beforeResourceStored(resource));
       return resource;
    }

    public T get( final Integer id ) {
      return store.get(id);
    }

    public T get( final Integer id, final T resource ) {
       T cache = get(id);
       if (cache == null)
           cache = put(id, resource);
       return cache;
    }

    public T beforeResourceStored( final T resource ) {
        return resource;
    }
}
